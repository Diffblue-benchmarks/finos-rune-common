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

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StreamUtilsDiffblueTest {
  /**
   * Test {@link StreamUtils#flattenTreeC(Function)} with {@code extract}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#flattenTreeC(Function)}
   */
  @Test
  @DisplayName("Test flattenTreeC(Function) with 'extract'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Function StreamUtils.flattenTreeC(Function)"})
  void testFlattenTreeCWithExtract_thenThrowRuntimeException() {
    // Arrange
    Function<Object, Object> function = mock(Function.class);
    when(function.apply(Mockito.<Object>any())).thenThrow(new RuntimeException());

    Function<Object, Collection<Object>> extract = mock(Function.class);
    when(extract.andThen(Mockito.<Function<Collection<Object>, Object>>any())).thenReturn(function);

    // Act
    Function<Object, Stream<Object>> actualFlattenTreeCResult = StreamUtils.flattenTreeC(extract);

    // Assert
    assertThrows(
        RuntimeException.class,
        () -> actualFlattenTreeCResult.apply(BeanPropertyWriter.MARKER_FOR_EMPTY));
    verify(extract).andThen(isA(Function.class));
    verify(function).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#flattenTree(Function, Collection)} with {@code extract}, {@code
   * visited}.
   *
   * <p>Method under test: {@link StreamUtils#flattenTree(Function, Collection)}
   */
  @Test
  @DisplayName("Test flattenTree(Function, Collection) with 'extract', 'visited'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Function StreamUtils.flattenTree(Function, Collection)"})
  void testFlattenTreeWithExtractVisited() {
    // Arrange
    Function<Object, Stream<Object>> extract = mock(Function.class);

    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> streamResult = objectList.stream();
    when(extract.apply(Mockito.<Object>any())).thenReturn(streamResult);
    ArrayList<Object> visited = new ArrayList<>();

    // Act
    Function<Object, Stream<Object>> actualFlattenTreeResult =
        StreamUtils.flattenTree(extract, visited);
    Object object = BeanPropertyWriter.MARKER_FOR_EMPTY;
    Stream<Object> actualApplyResult = actualFlattenTreeResult.apply(object);

    // Assert
    verify(extract).apply(isA(Object.class));
    assertTrue(object instanceof Include);
    assertEquals(1, visited.size());
    List<Object> collectResult = actualApplyResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals(Include.NON_EMPTY, object);
    assertSame(object, visited.get(0));
    assertSame(object, collectResult.get(0));
  }

  /**
   * Test {@link StreamUtils#flattenTree(Function, Collection)} with {@code extract}, {@code
   * visited}.
   *
   * <ul>
   *   <li>Given {@link BeanPropertyWriter#MARKER_FOR_EMPTY}.
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#flattenTree(Function, Collection)}
   */
  @Test
  @DisplayName(
      "Test flattenTree(Function, Collection) with 'extract', 'visited'; given MARKER_FOR_EMPTY; then ArrayList() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Function StreamUtils.flattenTree(Function, Collection)"})
  void testFlattenTreeWithExtractVisited_givenMarker_for_empty_thenArrayListSizeIsOne() {
    // Arrange
    Function<Object, Stream<Object>> extract = mock(Function.class);

    ArrayList<Object> visited = new ArrayList<>();
    visited.add(BeanPropertyWriter.MARKER_FOR_EMPTY);

    // Act
    Function<Object, Stream<Object>> actualFlattenTreeResult =
        StreamUtils.flattenTree(extract, visited);
    Object object = BeanPropertyWriter.MARKER_FOR_EMPTY;
    Stream<Object> actualApplyResult = actualFlattenTreeResult.apply(object);

    // Assert
    assertTrue(object instanceof Include);
    assertEquals(1, visited.size());
    assertEquals(Include.NON_EMPTY, object);
    assertTrue(actualApplyResult.limit(5).collect(Collectors.toList()).isEmpty());
    assertSame(object, visited.get(0));
  }

  /**
   * Test {@link StreamUtils#flattenTree(Function, Collection)} with {@code extract}, {@code
   * visited}.
   *
   * <ul>
   *   <li>Given {@link BeanPropertyWriter#MARKER_FOR_EMPTY}.
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#flattenTree(Function, Collection)}
   */
  @Test
  @DisplayName(
      "Test flattenTree(Function, Collection) with 'extract', 'visited'; given MARKER_FOR_EMPTY; then ArrayList() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Function StreamUtils.flattenTree(Function, Collection)"})
  void testFlattenTreeWithExtractVisited_givenMarker_for_empty_thenArrayListSizeIsTwo() {
    // Arrange
    Function<Object, Stream<Object>> extract = mock(Function.class);

    ArrayList<Object> visited = new ArrayList<>();
    visited.add(BeanPropertyWriter.MARKER_FOR_EMPTY);
    visited.add(BeanPropertyWriter.MARKER_FOR_EMPTY);

    // Act
    Function<Object, Stream<Object>> actualFlattenTreeResult =
        StreamUtils.flattenTree(extract, visited);
    Object object = BeanPropertyWriter.MARKER_FOR_EMPTY;
    Stream<Object> actualApplyResult = actualFlattenTreeResult.apply(object);

    // Assert
    assertTrue(object instanceof Include);
    assertEquals(2, visited.size());
    assertEquals(Include.NON_EMPTY, object);
    assertTrue(actualApplyResult.limit(5).collect(Collectors.toList()).isEmpty());
    assertSame(object, visited.get(0));
    assertSame(object, visited.get(1));
  }

  /**
   * Test {@link StreamUtils#flattenTree(Function, Collection)} with {@code extract}, {@code
   * visited}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#flattenTree(Function, Collection)}
   */
  @Test
  @DisplayName(
      "Test flattenTree(Function, Collection) with 'extract', 'visited'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Function StreamUtils.flattenTree(Function, Collection)"})
  void testFlattenTreeWithExtractVisited_thenThrowRuntimeException() {
    // Arrange
    Function<Object, Stream<Object>> extract = mock(Function.class);
    when(extract.apply(Mockito.<Object>any())).thenThrow(new RuntimeException());

    // Act
    Function<Object, Stream<Object>> actualFlattenTreeResult =
        StreamUtils.flattenTree(extract, new ArrayList<>());

    // Assert
    assertThrows(
        RuntimeException.class,
        () -> actualFlattenTreeResult.apply(BeanPropertyWriter.MARKER_FOR_EMPTY));
    verify(extract).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#flattenTree(Function, Collection)} with {@code extract}, {@code
   * visited}.
   *
   * <ul>
   *   <li>When {@link Function}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#flattenTree(Function, Collection)}
   */
  @Test
  @DisplayName(
      "Test flattenTree(Function, Collection) with 'extract', 'visited'; when Function; then ArrayList() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Function StreamUtils.flattenTree(Function, Collection)"})
  void testFlattenTreeWithExtractVisited_whenFunction_thenArrayListEmpty() {
    // Arrange
    Function<Object, Stream<Object>> extract = mock(Function.class);
    ArrayList<Object> visited = new ArrayList<>();

    // Act
    StreamUtils.flattenTree(extract, visited);

    // Assert that nothing has changed
    assertTrue(visited.isEmpty());
  }

  /**
   * Test {@link StreamUtils#flattenTree(Function)} with {@code extract}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} stream.
   *   <li>Then {@link BeanPropertyWriter#MARKER_FOR_EMPTY} {@link JsonInclude.Include}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#flattenTree(Function)}
   */
  @Test
  @DisplayName(
      "Test flattenTree(Function) with 'extract'; given ArrayList() stream; then MARKER_FOR_EMPTY Include")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Function StreamUtils.flattenTree(Function)"})
  void testFlattenTreeWithExtract_givenArrayListStream_thenMarker_for_emptyInclude() {
    // Arrange
    Function<Object, Stream<Object>> extract = mock(Function.class);

    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> streamResult = objectList.stream();
    when(extract.apply(Mockito.<Object>any())).thenReturn(streamResult);

    // Act
    Function<Object, Stream<Object>> actualFlattenTreeResult = StreamUtils.flattenTree(extract);
    Object object = BeanPropertyWriter.MARKER_FOR_EMPTY;
    Stream<Object> actualApplyResult = actualFlattenTreeResult.apply(object);

    // Assert
    verify(extract).apply(isA(Object.class));
    assertTrue(object instanceof Include);
    List<Object> collectResult = actualApplyResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals(Include.NON_EMPTY, object);
    assertSame(object, collectResult.get(0));
  }

  /**
   * Test {@link StreamUtils#flattenTree(Function)} with {@code extract}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#flattenTree(Function)}
   */
  @Test
  @DisplayName(
      "Test flattenTree(Function) with 'extract'; given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Function StreamUtils.flattenTree(Function)"})
  void testFlattenTreeWithExtract_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    Function<Object, Stream<Object>> extract = mock(Function.class);
    when(extract.apply(Mockito.<Object>any())).thenThrow(new RuntimeException());

    // Act
    Function<Object, Stream<Object>> actualFlattenTreeResult = StreamUtils.flattenTree(extract);

    // Assert
    assertThrows(
        RuntimeException.class,
        () -> actualFlattenTreeResult.apply(BeanPropertyWriter.MARKER_FOR_EMPTY));
    verify(extract).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#flattenTree(Function)} with {@code extract}.
   *
   * <ul>
   *   <li>When {@link Function}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#flattenTree(Function)}
   */
  @Test
  @DisplayName("Test flattenTree(Function) with 'extract'; when Function; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Function StreamUtils.flattenTree(Function)"})
  void testFlattenTreeWithExtract_whenFunction_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> StreamUtils.flattenTree(mock(Function.class)));
  }

  /**
   * Test {@link StreamUtils#visitTreeC(Object, Consumer, Function)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BeanPropertyWriter#MARKER_FOR_EMPTY}.
   *   <li>Then calls {@link Function#apply(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#visitTreeC(Object, Consumer, Function)}
   */
  @Test
  @DisplayName(
      "Test visitTreeC(Object, Consumer, Function); given ArrayList() add MARKER_FOR_EMPTY; then calls apply(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StreamUtils.visitTreeC(Object, Consumer, Function)"})
  void testVisitTreeC_givenArrayListAddMarker_for_empty_thenCallsApply() {
    // Arrange
    Consumer<Object> visitFunc = mock(Consumer.class);
    doNothing().when(visitFunc).accept(Mockito.<Object>any());

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add(BeanPropertyWriter.MARKER_FOR_EMPTY);

    Function<Object, Collection<Object>> traverseFunc = mock(Function.class);
    when(traverseFunc.apply(Mockito.<Object>any())).thenReturn(objectList);

    // Act
    StreamUtils.visitTreeC(BeanPropertyWriter.MARKER_FOR_EMPTY, visitFunc, traverseFunc);

    // Assert
    verify(visitFunc).accept(isA(Object.class));
    verify(traverseFunc).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#visitTreeC(Object, Consumer, Function)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link Function} {@link Function#apply(Object)} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then calls {@link Function#apply(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#visitTreeC(Object, Consumer, Function)}
   */
  @Test
  @DisplayName(
      "Test visitTreeC(Object, Consumer, Function); given ArrayList(); when Function apply(Object) return ArrayList(); then calls apply(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StreamUtils.visitTreeC(Object, Consumer, Function)"})
  void testVisitTreeC_givenArrayList_whenFunctionApplyReturnArrayList_thenCallsApply() {
    // Arrange
    Consumer<Object> visitFunc = mock(Consumer.class);
    doNothing().when(visitFunc).accept(Mockito.<Object>any());

    Function<Object, Collection<Object>> traverseFunc = mock(Function.class);
    when(traverseFunc.apply(Mockito.<Object>any())).thenReturn(new ArrayList<>());

    // Act
    StreamUtils.visitTreeC(BeanPropertyWriter.MARKER_FOR_EMPTY, visitFunc, traverseFunc);

    // Assert
    verify(visitFunc).accept(isA(Object.class));
    verify(traverseFunc).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#visitTreeC(Object, Consumer, Function)}.
   *
   * <ul>
   *   <li>When {@link Consumer} {@link Consumer#accept(Object)} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#visitTreeC(Object, Consumer, Function)}
   */
  @Test
  @DisplayName(
      "Test visitTreeC(Object, Consumer, Function); when Consumer accept(Object) throw RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StreamUtils.visitTreeC(Object, Consumer, Function)"})
  void testVisitTreeC_whenConsumerAcceptThrowRuntimeException_thenThrowRuntimeException() {
    // Arrange
    Consumer<Object> visitFunc = mock(Consumer.class);
    doThrow(new RuntimeException()).when(visitFunc).accept(Mockito.<Object>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            StreamUtils.visitTreeC(
                BeanPropertyWriter.MARKER_FOR_EMPTY, visitFunc, mock(Function.class)));
    verify(visitFunc).accept(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#visitTreeC(Object, Consumer, Function)}.
   *
   * <ul>
   *   <li>When {@link Function} {@link Function#apply(Object)} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#visitTreeC(Object, Consumer, Function)}
   */
  @Test
  @DisplayName(
      "Test visitTreeC(Object, Consumer, Function); when Function apply(Object) throw RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StreamUtils.visitTreeC(Object, Consumer, Function)"})
  void testVisitTreeC_whenFunctionApplyThrowRuntimeException_thenThrowRuntimeException() {
    // Arrange
    Consumer<Object> visitFunc = mock(Consumer.class);
    doNothing().when(visitFunc).accept(Mockito.<Object>any());

    Function<Object, Collection<Object>> traverseFunc = mock(Function.class);
    when(traverseFunc.apply(Mockito.<Object>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> StreamUtils.visitTreeC(BeanPropertyWriter.MARKER_FOR_EMPTY, visitFunc, traverseFunc));
    verify(visitFunc).accept(isA(Object.class));
    verify(traverseFunc).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#visitBiTree(Object, Consumer, Function, Function)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BeanPropertyWriter#MARKER_FOR_EMPTY}.
   *   <li>Then calls {@link Function#apply(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#visitBiTree(Object, Consumer, Function, Function)}
   */
  @Test
  @DisplayName(
      "Test visitBiTree(Object, Consumer, Function, Function); given ArrayList() add MARKER_FOR_EMPTY; then calls apply(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StreamUtils.visitBiTree(Object, Consumer, Function, Function)"})
  void testVisitBiTree_givenArrayListAddMarker_for_empty_thenCallsApply() {
    // Arrange
    Consumer<Object> visitFunction = mock(Consumer.class);
    doNothing().when(visitFunction).accept(Mockito.<Object>any());

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add(BeanPropertyWriter.MARKER_FOR_EMPTY);

    Function<Object, Collection<Object>> traverseFunc1 = mock(Function.class);
    when(traverseFunc1.apply(Mockito.<Object>any())).thenReturn(objectList);

    Function<Object, Collection<Object>> traverseFunc2 = mock(Function.class);
    when(traverseFunc2.apply(Mockito.<Object>any())).thenReturn(new ArrayList<>());

    // Act
    StreamUtils.visitBiTree(
        BeanPropertyWriter.MARKER_FOR_EMPTY, visitFunction, traverseFunc1, traverseFunc2);

    // Assert
    verify(visitFunction).accept(isA(Object.class));
    verify(traverseFunc1).apply(isA(Object.class));
    verify(traverseFunc2).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#visitBiTree(Object, Consumer, Function, Function)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link Function} {@link Function#apply(Object)} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then calls {@link Function#apply(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#visitBiTree(Object, Consumer, Function, Function)}
   */
  @Test
  @DisplayName(
      "Test visitBiTree(Object, Consumer, Function, Function); given ArrayList(); when Function apply(Object) return ArrayList(); then calls apply(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StreamUtils.visitBiTree(Object, Consumer, Function, Function)"})
  void testVisitBiTree_givenArrayList_whenFunctionApplyReturnArrayList_thenCallsApply() {
    // Arrange
    Consumer<Object> visitFunction = mock(Consumer.class);
    doNothing().when(visitFunction).accept(Mockito.<Object>any());

    Function<Object, Collection<Object>> traverseFunc1 = mock(Function.class);
    when(traverseFunc1.apply(Mockito.<Object>any())).thenReturn(new ArrayList<>());

    Function<Object, Collection<Object>> traverseFunc2 = mock(Function.class);
    when(traverseFunc2.apply(Mockito.<Object>any())).thenReturn(new ArrayList<>());

    // Act
    StreamUtils.visitBiTree(
        BeanPropertyWriter.MARKER_FOR_EMPTY, visitFunction, traverseFunc1, traverseFunc2);

    // Assert
    verify(visitFunction).accept(isA(Object.class));
    verify(traverseFunc1).apply(isA(Object.class));
    verify(traverseFunc2).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#visitBiTree(Object, Consumer, Function, Function)}.
   *
   * <ul>
   *   <li>When {@link Consumer} {@link Consumer#accept(Object)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#visitBiTree(Object, Consumer, Function, Function)}
   */
  @Test
  @DisplayName(
      "Test visitBiTree(Object, Consumer, Function, Function); when Consumer accept(Object) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StreamUtils.visitBiTree(Object, Consumer, Function, Function)"})
  void testVisitBiTree_whenConsumerAcceptThrowRuntimeException() {
    // Arrange
    Consumer<Object> visitFunction = mock(Consumer.class);
    doThrow(new RuntimeException()).when(visitFunction).accept(Mockito.<Object>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            StreamUtils.visitBiTree(
                BeanPropertyWriter.MARKER_FOR_EMPTY,
                visitFunction,
                mock(Function.class),
                mock(Function.class)));
    verify(visitFunction).accept(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#visitBiTree(Object, Consumer, Function, Function)}.
   *
   * <ul>
   *   <li>When {@link Function} {@link Function#apply(Object)} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#visitBiTree(Object, Consumer, Function, Function)}
   */
  @Test
  @DisplayName(
      "Test visitBiTree(Object, Consumer, Function, Function); when Function apply(Object) throw RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StreamUtils.visitBiTree(Object, Consumer, Function, Function)"})
  void testVisitBiTree_whenFunctionApplyThrowRuntimeException_thenThrowRuntimeException() {
    // Arrange
    Consumer<Object> visitFunction = mock(Consumer.class);
    doNothing().when(visitFunction).accept(Mockito.<Object>any());

    Function<Object, Collection<Object>> traverseFunc1 = mock(Function.class);
    when(traverseFunc1.apply(Mockito.<Object>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            StreamUtils.visitBiTree(
                BeanPropertyWriter.MARKER_FOR_EMPTY,
                visitFunction,
                traverseFunc1,
                mock(Function.class)));
    verify(visitFunction).accept(isA(Object.class));
    verify(traverseFunc1).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#visitBiTree(Object, Consumer, Function, Function)}.
   *
   * <ul>
   *   <li>When {@link Function} {@link Function#apply(Object)} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#visitBiTree(Object, Consumer, Function, Function)}
   */
  @Test
  @DisplayName(
      "Test visitBiTree(Object, Consumer, Function, Function); when Function apply(Object) throw RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StreamUtils.visitBiTree(Object, Consumer, Function, Function)"})
  void testVisitBiTree_whenFunctionApplyThrowRuntimeException_thenThrowRuntimeException2() {
    // Arrange
    Consumer<Object> visitFunction = mock(Consumer.class);
    doNothing().when(visitFunction).accept(Mockito.<Object>any());

    Function<Object, Collection<Object>> traverseFunc1 = mock(Function.class);
    when(traverseFunc1.apply(Mockito.<Object>any())).thenReturn(new ArrayList<>());

    Function<Object, Collection<Object>> traverseFunc2 = mock(Function.class);
    when(traverseFunc2.apply(Mockito.<Object>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            StreamUtils.visitBiTree(
                BeanPropertyWriter.MARKER_FOR_EMPTY, visitFunction, traverseFunc1, traverseFunc2));
    verify(visitFunction).accept(isA(Object.class));
    verify(traverseFunc1).apply(isA(Object.class));
    verify(traverseFunc2).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#visitTreeS(Object, Consumer, Function)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BeanPropertyWriter#MARKER_FOR_EMPTY}.
   *   <li>Then calls {@link Function#apply(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#visitTreeS(Object, Consumer, Function)}
   */
  @Test
  @DisplayName(
      "Test visitTreeS(Object, Consumer, Function); given ArrayList() add MARKER_FOR_EMPTY; then calls apply(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StreamUtils.visitTreeS(Object, Consumer, Function)"})
  void testVisitTreeS_givenArrayListAddMarker_for_empty_thenCallsApply() {
    // Arrange
    Consumer<Object> visitFunc = mock(Consumer.class);
    doNothing().when(visitFunc).accept(Mockito.<Object>any());

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add(BeanPropertyWriter.MARKER_FOR_EMPTY);
    Stream<Object> streamResult = objectList.stream();

    Function<Object, Stream<Object>> traversFunc = mock(Function.class);
    when(traversFunc.apply(Mockito.<Object>any())).thenReturn(streamResult);

    // Act
    StreamUtils.visitTreeS(BeanPropertyWriter.MARKER_FOR_EMPTY, visitFunc, traversFunc);

    // Assert
    verify(visitFunc).accept(isA(Object.class));
    verify(traversFunc).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#visitTreeS(Object, Consumer, Function)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} stream.
   *   <li>Then calls {@link Function#apply(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#visitTreeS(Object, Consumer, Function)}
   */
  @Test
  @DisplayName(
      "Test visitTreeS(Object, Consumer, Function); given ArrayList() stream; then calls apply(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StreamUtils.visitTreeS(Object, Consumer, Function)"})
  void testVisitTreeS_givenArrayListStream_thenCallsApply() {
    // Arrange
    Consumer<Object> visitFunc = mock(Consumer.class);
    doNothing().when(visitFunc).accept(Mockito.<Object>any());

    Function<Object, Stream<Object>> traversFunc = mock(Function.class);

    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> streamResult = objectList.stream();
    when(traversFunc.apply(Mockito.<Object>any())).thenReturn(streamResult);

    // Act
    StreamUtils.visitTreeS(BeanPropertyWriter.MARKER_FOR_EMPTY, visitFunc, traversFunc);

    // Assert
    verify(visitFunc).accept(isA(Object.class));
    verify(traversFunc).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#visitTreeS(Object, Consumer, Function)}.
   *
   * <ul>
   *   <li>When {@link Consumer} {@link Consumer#accept(Object)} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#visitTreeS(Object, Consumer, Function)}
   */
  @Test
  @DisplayName(
      "Test visitTreeS(Object, Consumer, Function); when Consumer accept(Object) throw RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StreamUtils.visitTreeS(Object, Consumer, Function)"})
  void testVisitTreeS_whenConsumerAcceptThrowRuntimeException_thenThrowRuntimeException() {
    // Arrange
    Consumer<Object> visitFunc = mock(Consumer.class);
    doThrow(new RuntimeException()).when(visitFunc).accept(Mockito.<Object>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            StreamUtils.visitTreeS(
                BeanPropertyWriter.MARKER_FOR_EMPTY, visitFunc, mock(Function.class)));
    verify(visitFunc).accept(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#visitTreeS(Object, Consumer, Function)}.
   *
   * <ul>
   *   <li>When {@link Function} {@link Function#apply(Object)} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#visitTreeS(Object, Consumer, Function)}
   */
  @Test
  @DisplayName(
      "Test visitTreeS(Object, Consumer, Function); when Function apply(Object) throw RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StreamUtils.visitTreeS(Object, Consumer, Function)"})
  void testVisitTreeS_whenFunctionApplyThrowRuntimeException_thenThrowRuntimeException() {
    // Arrange
    Consumer<Object> visitFunc = mock(Consumer.class);
    doNothing().when(visitFunc).accept(Mockito.<Object>any());

    Function<Object, Stream<Object>> traversFunc = mock(Function.class);
    when(traversFunc.apply(Mockito.<Object>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> StreamUtils.visitTreeS(BeanPropertyWriter.MARKER_FOR_EMPTY, visitFunc, traversFunc));
    verify(visitFunc).accept(isA(Object.class));
    verify(traversFunc).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#recurse(Object, Function, Collection)} with {@code a}, {@code func},
   * {@code visited}.
   *
   * <ul>
   *   <li>Given {@link BeanPropertyWriter#MARKER_FOR_EMPTY}.
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#recurse(Object, Function, Collection)}
   */
  @Test
  @DisplayName(
      "Test recurse(Object, Function, Collection) with 'a', 'func', 'visited'; given MARKER_FOR_EMPTY; then ArrayList() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream StreamUtils.recurse(Object, Function, Collection)"})
  void testRecurseWithAFuncVisited_givenMarker_for_empty_thenArrayListSizeIsOne() {
    // Arrange
    Object object = BeanPropertyWriter.MARKER_FOR_EMPTY;

    Function<Object, Object> func = mock(Function.class);
    when(func.apply(Mockito.<Object>any())).thenReturn(BeanPropertyWriter.MARKER_FOR_EMPTY);
    ArrayList<Object> visited = new ArrayList<>();

    // Act
    Stream<Object> actualRecurseResult = StreamUtils.recurse(object, func, visited);

    // Assert
    verify(func).apply(isA(Object.class));
    assertEquals(1, visited.size());
    List<Object> collectResult = actualRecurseResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertSame(object, visited.get(0));
    assertSame(object, collectResult.get(0));
  }

  /**
   * Test {@link StreamUtils#recurse(Object, Function, Collection)} with {@code a}, {@code func},
   * {@code visited}.
   *
   * <ul>
   *   <li>Given {@link BeanPropertyWriter#MARKER_FOR_EMPTY}.
   *   <li>When one.
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#recurse(Object, Function, Collection)}
   */
  @Test
  @DisplayName(
      "Test recurse(Object, Function, Collection) with 'a', 'func', 'visited'; given MARKER_FOR_EMPTY; when one; then ArrayList() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream StreamUtils.recurse(Object, Function, Collection)"})
  void testRecurseWithAFuncVisited_givenMarker_for_empty_whenOne_thenArrayListSizeIsTwo() {
    // Arrange
    Function<Object, Object> func = mock(Function.class);
    when(func.apply(Mockito.<Object>any())).thenReturn(BeanPropertyWriter.MARKER_FOR_EMPTY);
    ArrayList<Object> visited = new ArrayList<>();

    // Act
    Stream<Object> actualRecurseResult = StreamUtils.recurse(1, func, visited);

    // Assert
    verify(func, atLeast(1)).apply(Mockito.<Object>any());
    assertEquals(2, visited.size());
    Object getResult = visited.get(1);
    assertTrue(getResult instanceof Include);
    List<Object> collectResult = actualRecurseResult.limit(5).collect(Collectors.toList());
    assertEquals(2, collectResult.size());
    Object getResult2 = collectResult.get(1);
    assertTrue(getResult2 instanceof Include);
    assertEquals(1, ((Integer) visited.get(0)).intValue());
    assertEquals(1, ((Integer) collectResult.get(0)).intValue());
    assertEquals(Include.NON_EMPTY, getResult);
    assertEquals(Include.NON_EMPTY, getResult2);
  }

  /**
   * Test {@link StreamUtils#recurse(Object, Function, Collection)} with {@code a}, {@code func},
   * {@code visited}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#recurse(Object, Function, Collection)}
   */
  @Test
  @DisplayName(
      "Test recurse(Object, Function, Collection) with 'a', 'func', 'visited'; given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream StreamUtils.recurse(Object, Function, Collection)"})
  void testRecurseWithAFuncVisited_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    Function<Object, Object> func = mock(Function.class);
    when(func.apply(Mockito.<Object>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> StreamUtils.recurse(BeanPropertyWriter.MARKER_FOR_EMPTY, func, new ArrayList<>()));
    verify(func).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#recurse(Object, Function, Collection)} with {@code a}, {@code func},
   * {@code visited}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#recurse(Object, Function, Collection)}
   */
  @Test
  @DisplayName(
      "Test recurse(Object, Function, Collection) with 'a', 'func', 'visited'; when 'null'; then ArrayList() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream StreamUtils.recurse(Object, Function, Collection)"})
  void testRecurseWithAFuncVisited_whenNull_thenArrayListEmpty() {
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
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#recurse(Object, Function)}
   */
  @Test
  @DisplayName(
      "Test recurse(Object, Function) with 'a', 'func'; given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream StreamUtils.recurse(Object, Function)"})
  void testRecurseWithAFunc_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    Function<Object, Object> func = mock(Function.class);
    when(func.apply(Mockito.<Object>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> StreamUtils.recurse(BeanPropertyWriter.MARKER_FOR_EMPTY, func));
    verify(func).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#recurse(Object, Function)} with {@code a}, {@code func}.
   *
   * <ul>
   *   <li>Then return limit five collect toList size is one.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#recurse(Object, Function)}
   */
  @Test
  @DisplayName(
      "Test recurse(Object, Function) with 'a', 'func'; then return limit five collect toList size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream StreamUtils.recurse(Object, Function)"})
  void testRecurseWithAFunc_thenReturnLimitFiveCollectToListSizeIsOne() {
    // Arrange
    Object object = BeanPropertyWriter.MARKER_FOR_EMPTY;

    Function<Object, Object> func = mock(Function.class);
    when(func.apply(Mockito.<Object>any())).thenReturn(BeanPropertyWriter.MARKER_FOR_EMPTY);

    // Act
    Stream<Object> actualRecurseResult = StreamUtils.recurse(object, func);

    // Assert
    verify(func).apply(isA(Object.class));
    List<Object> collectResult = actualRecurseResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertSame(object, collectResult.get(0));
  }

  /**
   * Test {@link StreamUtils#recurse(Object, Function)} with {@code a}, {@code func}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return limit five collect toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#recurse(Object, Function)}
   */
  @Test
  @DisplayName(
      "Test recurse(Object, Function) with 'a', 'func'; when 'null'; then return limit five collect toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream StreamUtils.recurse(Object, Function)"})
  void testRecurseWithAFunc_whenNull_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange and Act
    Stream<Object> actualRecurseResult = StreamUtils.recurse(null, mock(Function.class));

    // Assert
    assertTrue(actualRecurseResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link StreamUtils#optionalStream(Collection)}.
   *
   * <ul>
   *   <li>Then return limit five collect toList size is one.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#optionalStream(Collection)}
   */
  @Test
  @DisplayName("Test optionalStream(Collection); then return limit five collect toList size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream StreamUtils.optionalStream(Collection)"})
  void testOptionalStream_thenReturnLimitFiveCollectToListSizeIsOne() {
    // Arrange
    ArrayList<Object> c = new ArrayList<>();
    c.add(BeanPropertyWriter.MARKER_FOR_EMPTY);

    // Act
    Stream<Object> actualOptionalStreamResult = StreamUtils.optionalStream(c);

    // Assert
    List<Object> collectResult = actualOptionalStreamResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    Object getResult = collectResult.get(0);
    assertTrue(getResult instanceof Include);
    assertEquals(Include.NON_EMPTY, getResult);
  }

  /**
   * Test {@link StreamUtils#optionalStream(Collection)}.
   *
   * <ul>
   *   <li>Then return limit five collect toList size is two.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#optionalStream(Collection)}
   */
  @Test
  @DisplayName("Test optionalStream(Collection); then return limit five collect toList size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream StreamUtils.optionalStream(Collection)"})
  void testOptionalStream_thenReturnLimitFiveCollectToListSizeIsTwo() {
    // Arrange
    ArrayList<Object> c = new ArrayList<>();
    c.add(BeanPropertyWriter.MARKER_FOR_EMPTY);
    c.add(BeanPropertyWriter.MARKER_FOR_EMPTY);

    // Act
    Stream<Object> actualOptionalStreamResult = StreamUtils.optionalStream(c);

    // Assert
    List<Object> collectResult = actualOptionalStreamResult.limit(5).collect(Collectors.toList());
    assertEquals(2, collectResult.size());
    Object getResult = collectResult.get(0);
    assertTrue(getResult instanceof Include);
    Object getResult2 = collectResult.get(1);
    assertTrue(getResult2 instanceof Include);
    assertEquals(Include.NON_EMPTY, getResult);
    assertEquals(Include.NON_EMPTY, getResult2);
  }

  /**
   * Test {@link StreamUtils#optionalStream(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return limit five collect toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#optionalStream(Collection)}
   */
  @Test
  @DisplayName(
      "Test optionalStream(Collection); when ArrayList(); then return limit five collect toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream StreamUtils.optionalStream(Collection)"})
  void testOptionalStream_whenArrayList_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange and Act
    Stream<Object> actualOptionalStreamResult = StreamUtils.optionalStream(new ArrayList<>());

    // Assert
    assertTrue(actualOptionalStreamResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link StreamUtils#optionalStream(Collection)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return limit five collect toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#optionalStream(Collection)}
   */
  @Test
  @DisplayName(
      "Test optionalStream(Collection); when 'null'; then return limit five collect toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream StreamUtils.optionalStream(Collection)"})
  void testOptionalStream_whenNull_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange and Act
    Stream<Object> actualOptionalStreamResult = StreamUtils.optionalStream(null);

    // Assert
    assertTrue(actualOptionalStreamResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link StreamUtils#distinctByKey(Function)}.
   *
   * <ul>
   *   <li>Given {@link BeanPropertyWriter#MARKER_FOR_EMPTY}.
   *   <li>Then {@link BeanPropertyWriter#MARKER_FOR_EMPTY} {@link JsonInclude.Include}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#distinctByKey(Function)}
   */
  @Test
  @DisplayName(
      "Test distinctByKey(Function); given MARKER_FOR_EMPTY; then MARKER_FOR_EMPTY Include")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Predicate StreamUtils.distinctByKey(Function)"})
  void testDistinctByKey_givenMarker_for_empty_thenMarker_for_emptyInclude() {
    // Arrange
    Function<Object, Object> ke = mock(Function.class);
    when(ke.apply(Mockito.<Object>any())).thenReturn(BeanPropertyWriter.MARKER_FOR_EMPTY);

    // Act
    Predicate<Object> actualDistinctByKeyResult = StreamUtils.distinctByKey(ke);
    Object object = BeanPropertyWriter.MARKER_FOR_EMPTY;
    boolean actualTestResult = actualDistinctByKeyResult.test(object);

    // Assert
    verify(ke).apply(isA(Object.class));
    assertTrue(object instanceof Include);
    assertEquals(Include.NON_EMPTY, object);
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link StreamUtils#distinctByKey(Function)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#distinctByKey(Function)}
   */
  @Test
  @DisplayName(
      "Test distinctByKey(Function); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Predicate StreamUtils.distinctByKey(Function)"})
  void testDistinctByKey_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    Function<Object, Object> ke = mock(Function.class);
    when(ke.apply(Mockito.<Object>any())).thenThrow(new RuntimeException());

    // Act
    Predicate<Object> actualDistinctByKeyResult = StreamUtils.distinctByKey(ke);

    // Assert
    assertThrows(
        RuntimeException.class,
        () -> actualDistinctByKeyResult.test(BeanPropertyWriter.MARKER_FOR_EMPTY));
    verify(ke).apply(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#distinctByKey(Function)}.
   *
   * <ul>
   *   <li>When {@link Function}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#distinctByKey(Function)}
   */
  @Test
  @DisplayName("Test distinctByKey(Function); when Function; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Predicate StreamUtils.distinctByKey(Function)"})
  void testDistinctByKey_whenFunction_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> StreamUtils.distinctByKey(mock(Function.class)));
  }

  /**
   * Test {@link StreamUtils#peek(Consumer)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#peek(Consumer)}
   */
  @Test
  @DisplayName("Test peek(Consumer); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UnaryOperator StreamUtils.peek(Consumer)"})
  void testPeek_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    Consumer<Object> c = mock(Consumer.class);
    doThrow(new RuntimeException()).when(c).accept(Mockito.<Object>any());

    // Act
    UnaryOperator<Object> actualPeekResult = StreamUtils.peek(c);

    // Assert
    assertThrows(
        RuntimeException.class, () -> actualPeekResult.apply(BeanPropertyWriter.MARKER_FOR_EMPTY));
    verify(c).accept(isA(Object.class));
  }

  /**
   * Test {@link StreamUtils#peek(Consumer)}.
   *
   * <ul>
   *   <li>When {@link Consumer} {@link Consumer#accept(Object)} does nothing.
   *   <li>Then {@link BeanPropertyWriter#MARKER_FOR_EMPTY} {@link JsonInclude.Include}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#peek(Consumer)}
   */
  @Test
  @DisplayName(
      "Test peek(Consumer); when Consumer accept(Object) does nothing; then MARKER_FOR_EMPTY Include")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UnaryOperator StreamUtils.peek(Consumer)"})
  void testPeek_whenConsumerAcceptDoesNothing_thenMarker_for_emptyInclude() {
    // Arrange
    Consumer<Object> c = mock(Consumer.class);
    doNothing().when(c).accept(Mockito.<Object>any());

    // Act
    UnaryOperator<Object> actualPeekResult = StreamUtils.peek(c);
    Object object = BeanPropertyWriter.MARKER_FOR_EMPTY;
    Object actualApplyResult = actualPeekResult.apply(object);

    // Assert
    verify(c).accept(isA(Object.class));
    assertTrue(object instanceof Include);
    assertEquals(Include.NON_EMPTY, object);
    assertSame(object, actualApplyResult);
  }

  /**
   * Test {@link StreamUtils#peek(Consumer)}.
   *
   * <ul>
   *   <li>When {@link Consumer}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#peek(Consumer)}
   */
  @Test
  @DisplayName("Test peek(Consumer); when Consumer; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UnaryOperator StreamUtils.peek(Consumer)"})
  void testPeek_whenConsumer_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> StreamUtils.peek(mock(Consumer.class)));
  }

  /**
   * Test {@link StreamUtils#instancesOf(Class)} with {@code clazz}.
   *
   * <p>Method under test: {@link StreamUtils#instancesOf(Class)}
   */
  @Test
  @DisplayName("Test instancesOf(Class) with 'clazz'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Function StreamUtils.instancesOf(Class)"})
  void testInstancesOfWithClazz() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act
    Function<Object, Stream<Object>> actualInstancesOfResult = StreamUtils.instancesOf(clazz);
    Object object = BeanPropertyWriter.MARKER_FOR_EMPTY;
    Stream<Object> actualApplyResult = actualInstancesOfResult.apply(object);

    // Assert
    List<Object> collectResult = actualApplyResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertSame(object, collectResult.get(0));
  }

  /**
   * Test {@link StreamUtils#instancesOf(Stream, Class)} with {@code stream}, {@code clazz}.
   *
   * <ul>
   *   <li>Then return limit five collect toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtils#instancesOf(Stream, Class)}
   */
  @Test
  @DisplayName(
      "Test instancesOf(Stream, Class) with 'stream', 'clazz'; then return limit five collect toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream StreamUtils.instancesOf(Stream, Class)"})
  void testInstancesOfWithStreamClazz_thenReturnLimitFiveCollectToListEmpty() {
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
