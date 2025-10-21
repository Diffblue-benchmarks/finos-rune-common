package com.regnosys.rosetta.common.util;

/*-
 * ==============
 * Rune Common
 * ==============
 * Copyright (C) 2018 - 2025 REGnosys
 * ==============
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ==============
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class StreamUtilsDiffblueTest {
  /**
   * Test {@link StreamUtils#flattenTreeC(Function)} with {@code extract}.
   * <p>
   * Method under test: {@link StreamUtils#flattenTreeC(Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Function StreamUtils.flattenTreeC(Function)"})
  public void testFlattenTreeCWithExtract() {
    // Arrange
    Function<Object, Object> function = mock(Function.class);
    when(function.apply(Mockito.<Object>any())).thenThrow(new RuntimeException("foo"));
    Function<Object, Collection<Object>> extract = mock(Function.class);
    when(extract.andThen(Mockito.<Function<Collection<Object>, Object>>any())).thenReturn(function);

    // Act
    Function<Object, Stream<Object>> actualFlattenTreeCResult = StreamUtils.flattenTreeC(extract);

    // Assert
    assertThrows(RuntimeException.class, () -> actualFlattenTreeCResult.apply("42"));
    verify(extract).andThen(isA(Function.class));
    verify(function).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#flattenTree(Function, Collection)} with {@code extract}, {@code visited}.
   * <p>
   * Method under test: {@link StreamUtils#flattenTree(Function, Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Function StreamUtils.flattenTree(Function, Collection)"})
  public void testFlattenTreeWithExtractVisited() {
    // Arrange
    Function<Object, Stream<Object>> extract = mock(Function.class);

    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> streamResult = objectList.stream();
    when(extract.apply(Mockito.<Object>any())).thenReturn(streamResult);
    ArrayList<Object> visited = new ArrayList<>();

    // Act
    Function<Object, Stream<Object>> actualFlattenTreeResult = StreamUtils.flattenTree(extract, visited);
    Stream<Object> actualApplyResult = actualFlattenTreeResult.apply("42");

    // Assert
    verify(extract).apply(isA(Object.class));
    assertEquals(1, visited.size());
    assertEquals("42", visited.get(0));
    List<Object> collectResult = actualApplyResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals("42", collectResult.get(0));
  }

  /**
   * Test {@link StreamUtils#flattenTree(Function, Collection)} with {@code extract}, {@code visited}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link Function}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#flattenTree(Function, Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Function StreamUtils.flattenTree(Function, Collection)"})
  public void testFlattenTreeWithExtractVisited_given42_whenFunction_thenArrayListSizeIsOne() {
    // Arrange
    Function<Object, Stream<Object>> extract = mock(Function.class);

    ArrayList<Object> visited = new ArrayList<>();
    visited.add("42");

    // Act
    Function<Object, Stream<Object>> actualFlattenTreeResult = StreamUtils.flattenTree(extract, visited);
    Stream<Object> actualApplyResult = actualFlattenTreeResult.apply("42");

    // Assert
    assertEquals(1, visited.size());
    assertEquals("42", visited.get(0));
    assertTrue(actualApplyResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link StreamUtils#flattenTree(Function, Collection)} with {@code extract}, {@code visited}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link Function}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#flattenTree(Function, Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Function StreamUtils.flattenTree(Function, Collection)"})
  public void testFlattenTreeWithExtractVisited_given42_whenFunction_thenArrayListSizeIsTwo() {
    // Arrange
    Function<Object, Stream<Object>> extract = mock(Function.class);

    ArrayList<Object> visited = new ArrayList<>();
    visited.add("42");
    visited.add("42");

    // Act
    Function<Object, Stream<Object>> actualFlattenTreeResult = StreamUtils.flattenTree(extract, visited);
    Stream<Object> actualApplyResult = actualFlattenTreeResult.apply("42");

    // Assert
    assertEquals(2, visited.size());
    assertEquals("42", visited.get(0));
    assertTrue(actualApplyResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link StreamUtils#flattenTree(Function, Collection)} with {@code extract}, {@code visited}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#flattenTree(Function, Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Function StreamUtils.flattenTree(Function, Collection)"})
  public void testFlattenTreeWithExtractVisited_thenThrowRuntimeException() {
    // Arrange
    Function<Object, Stream<Object>> extract = mock(Function.class);
    when(extract.apply(Mockito.<Object>any())).thenThrow(new RuntimeException("foo"));

    // Act
    Function<Object, Stream<Object>> actualFlattenTreeResult = StreamUtils.flattenTree(extract, new ArrayList<>());

    // Assert
    assertThrows(RuntimeException.class, () -> actualFlattenTreeResult.apply("42"));
    verify(extract).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#flattenTree(Function)} with {@code extract}.
   * <ul>
   *   <li>Then return apply {@code 42} limit five collect toList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#flattenTree(Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Function StreamUtils.flattenTree(Function)"})
  public void testFlattenTreeWithExtract_thenReturnApply42LimitFiveCollectToListSizeIsOne() {
    // Arrange
    Function<Object, Stream<Object>> extract = mock(Function.class);

    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> streamResult = objectList.stream();
    when(extract.apply(Mockito.<Object>any())).thenReturn(streamResult);

    // Act
    Function<Object, Stream<Object>> actualFlattenTreeResult = StreamUtils.flattenTree(extract);
    Stream<Object> actualApplyResult = actualFlattenTreeResult.apply("42");

    // Assert
    verify(extract).apply(isA(Object.class));
    List<Object> collectResult = actualApplyResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals("42", collectResult.get(0));
  }

  /**
   * Test {@link StreamUtils#flattenTree(Function)} with {@code extract}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#flattenTree(Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Function StreamUtils.flattenTree(Function)"})
  public void testFlattenTreeWithExtract_thenThrowRuntimeException() {
    // Arrange
    Function<Object, Stream<Object>> extract = mock(Function.class);
    when(extract.apply(Mockito.<Object>any())).thenThrow(new RuntimeException("foo"));

    // Act
    Function<Object, Stream<Object>> actualFlattenTreeResult = StreamUtils.flattenTree(extract);

    // Assert
    assertThrows(RuntimeException.class, () -> actualFlattenTreeResult.apply("42"));
    verify(extract).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#visitTreeC(Object, Consumer, Function)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>When {@code Initial}.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#visitTreeC(Object, Consumer, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StreamUtils.visitTreeC(Object, Consumer, Function)"})
  public void testVisitTreeC_givenArrayListAdd42_whenInitial_thenCallsAccept() {
    // Arrange
    Consumer<Object> visitFunc = mock(Consumer.class);
    doNothing().when(visitFunc).accept(Mockito.<Object>any());

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    Function<Object, Collection<Object>> traverseFunc = mock(Function.class);
    when(traverseFunc.apply(Mockito.<Object>any())).thenReturn(objectList);

    // Act
    StreamUtils.visitTreeC("Initial", visitFunc, traverseFunc);

    // Assert
    verify(visitFunc, atLeast(1)).accept(Mockito.<Object>any());
    verify(traverseFunc, atLeast(1)).apply(Mockito.<Object>any());
  }

  /**
   * Test {@link StreamUtils#visitTreeC(Object, Consumer, Function)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@code Initial}.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#visitTreeC(Object, Consumer, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StreamUtils.visitTreeC(Object, Consumer, Function)"})
  public void testVisitTreeC_givenArrayList_whenInitial_thenCallsAccept() {
    // Arrange
    Consumer<Object> visitFunc = mock(Consumer.class);
    doNothing().when(visitFunc).accept(Mockito.<Object>any());
    Function<Object, Collection<Object>> traverseFunc = mock(Function.class);
    when(traverseFunc.apply(Mockito.<Object>any())).thenReturn(new ArrayList<>());

    // Act
    StreamUtils.visitTreeC("Initial", visitFunc, traverseFunc);

    // Assert
    verify(visitFunc).accept(isA(Object.class));
    verify(traverseFunc).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#visitTreeC(Object, Consumer, Function)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#visitTreeC(Object, Consumer, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StreamUtils.visitTreeC(Object, Consumer, Function)"})
  public void testVisitTreeC_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    // Arrange
    Consumer<Object> visitFunc = mock(Consumer.class);
    doNothing().when(visitFunc).accept(Mockito.<Object>any());
    Function<Object, Collection<Object>> traverseFunc = mock(Function.class);
    when(traverseFunc.apply(Mockito.<Object>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> StreamUtils.visitTreeC("Initial", visitFunc, traverseFunc));
    verify(visitFunc).accept(isA(Object.class));
    verify(traverseFunc).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#visitBiTree(Object, Consumer, Function, Function)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>When {@code Initial}.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#visitBiTree(Object, Consumer, Function, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StreamUtils.visitBiTree(Object, Consumer, Function, Function)"})
  public void testVisitBiTree_givenArrayListAdd42_whenInitial_thenCallsAccept() {
    // Arrange
    Consumer<Object> visitFunction = mock(Consumer.class);
    doNothing().when(visitFunction).accept(Mockito.<Object>any());

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    Function<Object, Collection<Object>> traverseFunc1 = mock(Function.class);
    when(traverseFunc1.apply(Mockito.<Object>any())).thenReturn(objectList);
    Function<Object, Collection<Object>> traverseFunc2 = mock(Function.class);
    when(traverseFunc2.apply(Mockito.<Object>any())).thenReturn(new ArrayList<>());

    // Act
    StreamUtils.visitBiTree("Initial", visitFunction, traverseFunc1, traverseFunc2);

    // Assert
    verify(visitFunction, atLeast(1)).accept(Mockito.<Object>any());
    verify(traverseFunc1, atLeast(1)).apply(Mockito.<Object>any());
    verify(traverseFunc2, atLeast(1)).apply(Mockito.<Object>any());
  }

  /**
   * Test {@link StreamUtils#visitBiTree(Object, Consumer, Function, Function)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#visitBiTree(Object, Consumer, Function, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StreamUtils.visitBiTree(Object, Consumer, Function, Function)"})
  public void testVisitBiTree_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    // Arrange
    Consumer<Object> visitFunction = mock(Consumer.class);
    doNothing().when(visitFunction).accept(Mockito.<Object>any());
    Function<Object, Collection<Object>> traverseFunc1 = mock(Function.class);
    when(traverseFunc1.apply(Mockito.<Object>any())).thenReturn(new ArrayList<>());
    Function<Object, Collection<Object>> traverseFunc2 = mock(Function.class);
    when(traverseFunc2.apply(Mockito.<Object>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> StreamUtils.visitBiTree("Initial", visitFunction, traverseFunc1, traverseFunc2));
    verify(visitFunction).accept(isA(Object.class));
    verify(traverseFunc1).apply(isA(Object.class));
    verify(traverseFunc2).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#visitBiTree(Object, Consumer, Function, Function)}.
   * <ul>
   *   <li>When {@code Initial}.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#visitBiTree(Object, Consumer, Function, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StreamUtils.visitBiTree(Object, Consumer, Function, Function)"})
  public void testVisitBiTree_whenInitial_thenCallsAccept() {
    // Arrange
    Consumer<Object> visitFunction = mock(Consumer.class);
    doNothing().when(visitFunction).accept(Mockito.<Object>any());
    Function<Object, Collection<Object>> traverseFunc1 = mock(Function.class);
    when(traverseFunc1.apply(Mockito.<Object>any())).thenReturn(new ArrayList<>());
    Function<Object, Collection<Object>> traverseFunc2 = mock(Function.class);
    when(traverseFunc2.apply(Mockito.<Object>any())).thenReturn(new ArrayList<>());

    // Act
    StreamUtils.visitBiTree("Initial", visitFunction, traverseFunc1, traverseFunc2);

    // Assert
    verify(visitFunction).accept(isA(Object.class));
    verify(traverseFunc1).apply(isA(Object.class));
    verify(traverseFunc2).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#visitTreeS(Object, Consumer, Function)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#visitTreeS(Object, Consumer, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StreamUtils.visitTreeS(Object, Consumer, Function)"})
  public void testVisitTreeS_givenArrayListAdd42_when42_thenCallsAccept() {
    // Arrange
    Consumer<Object> visitFunc = mock(Consumer.class);
    doNothing().when(visitFunc).accept(Mockito.<Object>any());

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    Stream<Object> streamResult = objectList.stream();
    Function<Object, Stream<Object>> traversFunc = mock(Function.class);
    when(traversFunc.apply(Mockito.<Object>any())).thenReturn(streamResult);

    // Act
    StreamUtils.visitTreeS("42", visitFunc, traversFunc);

    // Assert
    verify(visitFunc).accept(isA(Object.class));
    verify(traversFunc).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#visitTreeS(Object, Consumer, Function)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} stream.</li>
   *   <li>When {@code Initial}.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#visitTreeS(Object, Consumer, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StreamUtils.visitTreeS(Object, Consumer, Function)"})
  public void testVisitTreeS_givenArrayListStream_whenInitial_thenCallsAccept() {
    // Arrange
    Consumer<Object> visitFunc = mock(Consumer.class);
    doNothing().when(visitFunc).accept(Mockito.<Object>any());
    Function<Object, Stream<Object>> traversFunc = mock(Function.class);

    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> streamResult = objectList.stream();
    when(traversFunc.apply(Mockito.<Object>any())).thenReturn(streamResult);

    // Act
    StreamUtils.visitTreeS("Initial", visitFunc, traversFunc);

    // Assert
    verify(visitFunc).accept(isA(Object.class));
    verify(traversFunc).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#visitTreeS(Object, Consumer, Function)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#visitTreeS(Object, Consumer, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StreamUtils.visitTreeS(Object, Consumer, Function)"})
  public void testVisitTreeS_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    // Arrange
    Consumer<Object> visitFunc = mock(Consumer.class);
    doNothing().when(visitFunc).accept(Mockito.<Object>any());
    Function<Object, Stream<Object>> traversFunc = mock(Function.class);
    when(traversFunc.apply(Mockito.<Object>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> StreamUtils.visitTreeS("Initial", visitFunc, traversFunc));
    verify(visitFunc).accept(isA(Object.class));
    verify(traversFunc).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#recurse(Object, Function, Collection)} with {@code a}, {@code func}, {@code visited}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#recurse(Object, Function, Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Stream StreamUtils.recurse(Object, Function, Collection)"})
  public void testRecurseWithAFuncVisited_given42_thenArrayListSizeIsOne() {
    // Arrange
    Function<Object, Object> func = mock(Function.class);
    when(func.apply(Mockito.<Object>any())).thenReturn("42");
    ArrayList<Object> visited = new ArrayList<>();

    // Act
    Stream<Object> actualRecurseResult = StreamUtils.recurse("42", func, visited);

    // Assert
    verify(func).apply(isA(Object.class));
    assertEquals(1, visited.size());
    assertEquals("42", visited.get(0));
    List<Object> collectResult = actualRecurseResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals("42", collectResult.get(0));
  }

  /**
   * Test {@link StreamUtils#recurse(Object, Function, Collection)} with {@code a}, {@code func}, {@code visited}.
   * <ul>
   *   <li>Given {@code Apply}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#recurse(Object, Function, Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Stream StreamUtils.recurse(Object, Function, Collection)"})
  public void testRecurseWithAFuncVisited_givenApply_thenArrayListSizeIsTwo() {
    // Arrange
    Function<Object, Object> func = mock(Function.class);
    when(func.apply(Mockito.<Object>any())).thenReturn("Apply");
    ArrayList<Object> visited = new ArrayList<>();

    // Act
    Stream<Object> actualRecurseResult = StreamUtils.recurse("42", func, visited);

    // Assert
    verify(func, atLeast(1)).apply(Mockito.<Object>any());
    assertEquals(2, visited.size());
    assertEquals("Apply", visited.get(1));
    List<Object> collectResult = actualRecurseResult.limit(5).collect(Collectors.toList());
    assertEquals(2, collectResult.size());
    assertEquals("Apply", collectResult.get(1));
  }

  /**
   * Test {@link StreamUtils#recurse(Object, Function, Collection)} with {@code a}, {@code func}, {@code visited}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#recurse(Object, Function, Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Stream StreamUtils.recurse(Object, Function, Collection)"})
  public void testRecurseWithAFuncVisited_thenThrowRuntimeException() {
    // Arrange
    Function<Object, Object> func = mock(Function.class);
    when(func.apply(Mockito.<Object>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> StreamUtils.recurse("42", func, new ArrayList<>()));
    verify(func).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#recurse(Object, Function, Collection)} with {@code a}, {@code func}, {@code visited}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#recurse(Object, Function, Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Stream StreamUtils.recurse(Object, Function, Collection)"})
  public void testRecurseWithAFuncVisited_whenNull_thenArrayListEmpty() {
    // Arrange
    Function<Object, Object> func = mock(Function.class);
    ArrayList<Object> visited = new ArrayList<>();

    // Act
    Stream<Object> actualRecurseResult = StreamUtils.recurse(null, func, visited);

    // Assert
    assertTrue(visited.isEmpty());
    assertTrue(actualRecurseResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link StreamUtils#recurse(Object, Function)} with {@code a}, {@code func}.
   * <ul>
   *   <li>Given {@code Apply}.</li>
   *   <li>Then return limit five collect toList size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#recurse(Object, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Stream StreamUtils.recurse(Object, Function)"})
  public void testRecurseWithAFunc_givenApply_thenReturnLimitFiveCollectToListSizeIsTwo() {
    // Arrange
    Function<Object, Object> func = mock(Function.class);
    when(func.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Stream<Object> actualRecurseResult = StreamUtils.recurse("42", func);

    // Assert
    verify(func, atLeast(1)).apply(Mockito.<Object>any());
    List<Object> collectResult = actualRecurseResult.limit(5).collect(Collectors.toList());
    assertEquals(2, collectResult.size());
    assertEquals("42", collectResult.get(0));
    assertEquals("Apply", collectResult.get(1));
  }

  /**
   * Test {@link StreamUtils#recurse(Object, Function)} with {@code a}, {@code func}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#recurse(Object, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Stream StreamUtils.recurse(Object, Function)"})
  public void testRecurseWithAFunc_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    // Arrange
    Function<Object, Object> func = mock(Function.class);
    when(func.apply(Mockito.<Object>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> StreamUtils.recurse("42", func));
    verify(func).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#recurse(Object, Function)} with {@code a}, {@code func}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return limit five collect toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#recurse(Object, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Stream StreamUtils.recurse(Object, Function)"})
  public void testRecurseWithAFunc_whenNull_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange and Act
    Stream<Object> actualRecurseResult = StreamUtils.recurse(null, mock(Function.class));

    // Assert
    assertTrue(actualRecurseResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link StreamUtils#optionalStream(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return limit five collect toList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#optionalStream(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Stream StreamUtils.optionalStream(Collection)"})
  public void testOptionalStream_given42_thenReturnLimitFiveCollectToListSizeIsOne() {
    // Arrange
    ArrayList<Object> c = new ArrayList<>();
    c.add("42");

    // Act
    Stream<Object> actualOptionalStreamResult = StreamUtils.optionalStream(c);

    // Assert
    List<Object> collectResult = actualOptionalStreamResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals("42", collectResult.get(0));
  }

  /**
   * Test {@link StreamUtils#optionalStream(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return limit five collect toList size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#optionalStream(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Stream StreamUtils.optionalStream(Collection)"})
  public void testOptionalStream_given42_thenReturnLimitFiveCollectToListSizeIsTwo() {
    // Arrange
    ArrayList<Object> c = new ArrayList<>();
    c.add("42");
    c.add("42");

    // Act
    Stream<Object> actualOptionalStreamResult = StreamUtils.optionalStream(c);

    // Assert
    List<Object> collectResult = actualOptionalStreamResult.limit(5).collect(Collectors.toList());
    assertEquals(2, collectResult.size());
    assertEquals("42", collectResult.get(0));
    assertEquals("42", collectResult.get(1));
  }

  /**
   * Test {@link StreamUtils#optionalStream(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return limit five collect toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#optionalStream(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Stream StreamUtils.optionalStream(Collection)"})
  public void testOptionalStream_whenArrayList_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange and Act
    Stream<Object> actualOptionalStreamResult = StreamUtils.optionalStream(new ArrayList<>());

    // Assert
    assertTrue(actualOptionalStreamResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link StreamUtils#optionalStream(Collection)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return limit five collect toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#optionalStream(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Stream StreamUtils.optionalStream(Collection)"})
  public void testOptionalStream_whenNull_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange and Act
    Stream<Object> actualOptionalStreamResult = StreamUtils.optionalStream(null);

    // Assert
    assertTrue(actualOptionalStreamResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link StreamUtils#distinctByKey(Function)}.
   * <ul>
   *   <li>Given {@code Apply}.</li>
   *   <li>When {@link Function} {@link Function#apply(Object)} return {@code Apply}.</li>
   *   <li>Then return test {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#distinctByKey(Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Predicate StreamUtils.distinctByKey(Function)"})
  public void testDistinctByKey_givenApply_whenFunctionApplyReturnApply_thenReturnTest42() {
    // Arrange
    Function<Object, Object> ke = mock(Function.class);
    when(ke.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Predicate<Object> actualDistinctByKeyResult = StreamUtils.distinctByKey(ke);
    boolean actualTestResult = actualDistinctByKeyResult.test("42");

    // Assert
    verify(ke).apply(isA(Object.class));
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link StreamUtils#distinctByKey(Function)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#distinctByKey(Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Predicate StreamUtils.distinctByKey(Function)"})
  public void testDistinctByKey_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    // Arrange
    Function<Object, Object> ke = mock(Function.class);
    when(ke.apply(Mockito.<Object>any())).thenThrow(new RuntimeException("foo"));

    // Act
    Predicate<Object> actualDistinctByKeyResult = StreamUtils.distinctByKey(ke);

    // Assert
    assertThrows(RuntimeException.class, () -> actualDistinctByKeyResult.test("42"));
    verify(ke).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#peek(Consumer)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#peek(Consumer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnaryOperator StreamUtils.peek(Consumer)"})
  public void testPeek_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    // Arrange
    Consumer<Object> c = mock(Consumer.class);
    doThrow(new RuntimeException("foo")).when(c).accept(Mockito.<Object>any());

    // Act
    UnaryOperator<Object> actualPeekResult = StreamUtils.peek(c);

    // Assert
    assertThrows(RuntimeException.class, () -> actualPeekResult.apply("42"));
    verify(c).accept(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#peek(Consumer)}.
   * <ul>
   *   <li>When {@link Consumer} {@link Consumer#accept(Object)} does nothing.</li>
   *   <li>Then return apply {@code 42} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#peek(Consumer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnaryOperator StreamUtils.peek(Consumer)"})
  public void testPeek_whenConsumerAcceptDoesNothing_thenReturnApply42Is42() {
    // Arrange
    Consumer<Object> c = mock(Consumer.class);
    doNothing().when(c).accept(Mockito.<Object>any());

    // Act
    UnaryOperator<Object> actualPeekResult = StreamUtils.peek(c);
    Object actualApplyResult = actualPeekResult.apply("42");

    // Assert
    verify(c).accept(isA(Object.class));
    assertEquals("42", actualApplyResult);
  }

  /**
   * Test {@link StreamUtils#instancesOf(Class)} with {@code clazz}.
   * <ul>
   *   <li>Then return apply {@code 42} limit five collect toList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#instancesOf(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Function StreamUtils.instancesOf(Class)"})
  public void testInstancesOfWithClazz_thenReturnApply42LimitFiveCollectToListSizeIsOne() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act
    Function<Object, Stream<Object>> actualInstancesOfResult = StreamUtils.instancesOf(clazz);
    Stream<Object> actualApplyResult = actualInstancesOfResult.apply("42");

    // Assert
    List<Object> collectResult = actualApplyResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals("42", collectResult.get(0));
  }

  /**
   * Test {@link StreamUtils#instancesOf(Stream, Class)} with {@code stream}, {@code clazz}.
   * <ul>
   *   <li>Then return limit five collect toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtils#instancesOf(Stream, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Stream StreamUtils.instancesOf(Stream, Class)"})
  public void testInstancesOfWithStreamClazz_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> stream = objectList.stream();
    Class<Object> clazz = Object.class;

    // Act
    Stream<Object> actualInstancesOfResult = StreamUtils.instancesOf(stream, clazz);

    // Assert
    assertTrue(actualInstancesOfResult.limit(5).collect(Collectors.toList()).isEmpty());
  }
}
