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
import org.mockito.Mockito;

public class StreamUtilsDiffblueTest {
  /**
   * Method under test: {@link StreamUtils#flattenTreeC(Function)}
   */
  @Test
  public void testFlattenTreeC() {
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
   * Method under test: {@link StreamUtils#flattenTree(Function)}
   */
  @Test
  public void testFlattenTree() {
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
   * Method under test: {@link StreamUtils#flattenTree(Function)}
   */
  @Test
  public void testFlattenTree2() {
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
   * Method under test: {@link StreamUtils#flattenTree(Function, Collection)}
   */
  @Test
  public void testFlattenTree3() {
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
   * Method under test: {@link StreamUtils#flattenTree(Function, Collection)}
   */
  @Test
  public void testFlattenTree4() {
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
   * Method under test: {@link StreamUtils#flattenTree(Function, Collection)}
   */
  @Test
  public void testFlattenTree5() {
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
   * Method under test: {@link StreamUtils#flattenTree(Function, Collection)}
   */
  @Test
  public void testFlattenTree6() {
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
   * Method under test: {@link StreamUtils#visitTreeC(Object, Consumer, Function)}
   */
  @Test
  public void testVisitTreeC() {
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
   * Method under test: {@link StreamUtils#visitTreeC(Object, Consumer, Function)}
   */
  @Test
  public void testVisitTreeC2() {
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
   * Method under test: {@link StreamUtils#visitTreeC(Object, Consumer, Function)}
   */
  @Test
  public void testVisitTreeC3() {
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
   * Method under test:
   * {@link StreamUtils#visitBiTree(Object, Consumer, Function, Function)}
   */
  @Test
  public void testVisitBiTree() {
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
   * Method under test:
   * {@link StreamUtils#visitBiTree(Object, Consumer, Function, Function)}
   */
  @Test
  public void testVisitBiTree2() {
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
   * Method under test:
   * {@link StreamUtils#visitBiTree(Object, Consumer, Function, Function)}
   */
  @Test
  public void testVisitBiTree3() {
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
   * Method under test: {@link StreamUtils#visitTreeS(Object, Consumer, Function)}
   */
  @Test
  public void testVisitTreeS() {
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
   * Method under test: {@link StreamUtils#visitTreeS(Object, Consumer, Function)}
   */
  @Test
  public void testVisitTreeS2() {
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
   * Method under test: {@link StreamUtils#visitTreeS(Object, Consumer, Function)}
   */
  @Test
  public void testVisitTreeS3() {
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
   * Method under test: {@link StreamUtils#recurse(Object, Function)}
   */
  @Test
  public void testRecurse() {
    // Arrange and Act
    Stream<Object> actualRecurseResult = StreamUtils.recurse(null, mock(Function.class));

    // Assert
    assertTrue(actualRecurseResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Method under test: {@link StreamUtils#recurse(Object, Function)}
   */
  @Test
  public void testRecurse2() {
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
   * Method under test: {@link StreamUtils#recurse(Object, Function)}
   */
  @Test
  public void testRecurse3() {
    // Arrange
    Function<Object, Object> func = mock(Function.class);
    when(func.apply(Mockito.<Object>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> StreamUtils.recurse("42", func));
    verify(func).apply(isA(Object.class));
  }

  /**
   * Method under test: {@link StreamUtils#recurse(Object, Function, Collection)}
   */
  @Test
  public void testRecurse4() {
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
   * Method under test: {@link StreamUtils#recurse(Object, Function, Collection)}
   */
  @Test
  public void testRecurse5() {
    // Arrange
    Function<Object, Object> func = mock(Function.class);
    when(func.apply(Mockito.<Object>any())).thenReturn("Apply");
    ArrayList<Object> visited = new ArrayList<>();

    // Act
    Stream<Object> actualRecurseResult = StreamUtils.recurse("42", func, visited);

    // Assert
    verify(func, atLeast(1)).apply(Mockito.<Object>any());
    assertEquals(2, visited.size());
    assertEquals("42", visited.get(0));
    List<Object> collectResult = actualRecurseResult.limit(5).collect(Collectors.toList());
    assertEquals(2, collectResult.size());
    assertEquals("42", collectResult.get(0));
    assertEquals("Apply", visited.get(1));
    assertEquals("Apply", collectResult.get(1));
  }

  /**
   * Method under test: {@link StreamUtils#recurse(Object, Function, Collection)}
   */
  @Test
  public void testRecurse6() {
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
   * Method under test: {@link StreamUtils#recurse(Object, Function, Collection)}
   */
  @Test
  public void testRecurse7() {
    // Arrange
    Function<Object, Object> func = mock(Function.class);
    when(func.apply(Mockito.<Object>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> StreamUtils.recurse("42", func, new ArrayList<>()));
    verify(func).apply(isA(Object.class));
  }

  /**
   * Method under test: {@link StreamUtils#optionalStream(Collection)}
   */
  @Test
  public void testOptionalStream() {
    // Arrange and Act
    Stream<Object> actualOptionalStreamResult = StreamUtils.optionalStream(new ArrayList<>());

    // Assert
    assertTrue(actualOptionalStreamResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Method under test: {@link StreamUtils#optionalStream(Collection)}
   */
  @Test
  public void testOptionalStream2() {
    // Arrange and Act
    Stream<Object> actualOptionalStreamResult = StreamUtils.optionalStream(null);

    // Assert
    assertTrue(actualOptionalStreamResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Method under test: {@link StreamUtils#optionalStream(Collection)}
   */
  @Test
  public void testOptionalStream3() {
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
   * Method under test: {@link StreamUtils#optionalStream(Collection)}
   */
  @Test
  public void testOptionalStream4() {
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
   * Method under test: {@link StreamUtils#distinctByKey(Function)}
   */
  @Test
  public void testDistinctByKey() {
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
   * Method under test: {@link StreamUtils#distinctByKey(Function)}
   */
  @Test
  public void testDistinctByKey2() {
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
   * Method under test: {@link StreamUtils#peek(Consumer)}
   */
  @Test
  public void testPeek() {
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
   * Method under test: {@link StreamUtils#peek(Consumer)}
   */
  @Test
  public void testPeek2() {
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
   * Method under test: {@link StreamUtils#instancesOf(Class)}
   */
  @Test
  public void testInstancesOf() {
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
   * Method under test: {@link StreamUtils#instancesOf(Stream, Class)}
   */
  @Test
  public void testInstancesOf2() {
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
