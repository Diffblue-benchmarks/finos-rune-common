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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiPredicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CollectionUtilsDiffblueTest {
  /**
   * Test {@link CollectionUtils#listMatch(List, List, BiPredicate)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link BiPredicate} {@link BiPredicate#test(Object, Object)} return {@code false}.
   *   <li>Then calls {@link BiPredicate#test(Object, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#listMatch(List, List, BiPredicate)}
   */
  @Test
  @DisplayName(
      "Test listMatch(List, List, BiPredicate); given 'false'; when BiPredicate test(Object, Object) return 'false'; then calls test(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollectionUtils.listMatch(List, List, BiPredicate)"})
  void testListMatch_givenFalse_whenBiPredicateTestReturnFalse_thenCallsTest() {
    // Arrange
    ArrayList<Object> list1 = new ArrayList<>();
    list1.add(BeanPropertyWriter.MARKER_FOR_EMPTY);

    ArrayList<Object> list2 = new ArrayList<>();
    list2.add(BeanPropertyWriter.MARKER_FOR_EMPTY);

    BiPredicate<Object, Object> comparer = mock(BiPredicate.class);
    when(comparer.test(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(false);

    // Act
    boolean actualListMatchResult = CollectionUtils.listMatch(list1, list2, comparer);

    // Assert
    verify(comparer).test(isA(Object.class), isA(Object.class));
    assertFalse(actualListMatchResult);
  }

  /**
   * Test {@link CollectionUtils#listMatch(List, List, BiPredicate)}.
   *
   * <ul>
   *   <li>Given {@link BeanPropertyWriter#MARKER_FOR_EMPTY}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#listMatch(List, List, BiPredicate)}
   */
  @Test
  @DisplayName(
      "Test listMatch(List, List, BiPredicate); given MARKER_FOR_EMPTY; when ArrayList(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollectionUtils.listMatch(List, List, BiPredicate)"})
  void testListMatch_givenMarker_for_empty_whenArrayList_thenReturnFalse() {
    // Arrange
    ArrayList<Object> list1 = new ArrayList<>();
    list1.add(BeanPropertyWriter.MARKER_FOR_EMPTY);

    // Act
    boolean actualListMatchResult =
        CollectionUtils.listMatch(list1, new ArrayList<>(), mock(BiPredicate.class));

    // Assert
    assertFalse(actualListMatchResult);
  }

  /**
   * Test {@link CollectionUtils#listMatch(List, List, BiPredicate)}.
   *
   * <ul>
   *   <li>Given {@link BeanPropertyWriter#MARKER_FOR_EMPTY}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#listMatch(List, List, BiPredicate)}
   */
  @Test
  @DisplayName(
      "Test listMatch(List, List, BiPredicate); given MARKER_FOR_EMPTY; when ArrayList(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollectionUtils.listMatch(List, List, BiPredicate)"})
  void testListMatch_givenMarker_for_empty_whenArrayList_thenReturnFalse2() {
    // Arrange
    ArrayList<Object> list1 = new ArrayList<>();
    list1.add(BeanPropertyWriter.MARKER_FOR_EMPTY);
    list1.add(BeanPropertyWriter.MARKER_FOR_EMPTY);

    // Act
    boolean actualListMatchResult =
        CollectionUtils.listMatch(list1, new ArrayList<>(), mock(BiPredicate.class));

    // Assert
    assertFalse(actualListMatchResult);
  }

  /**
   * Test {@link CollectionUtils#listMatch(List, List, BiPredicate)}.
   *
   * <ul>
   *   <li>Given {@link BeanPropertyWriter#MARKER_FOR_EMPTY}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#listMatch(List, List, BiPredicate)}
   */
  @Test
  @DisplayName(
      "Test listMatch(List, List, BiPredicate); given MARKER_FOR_EMPTY; when ArrayList(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollectionUtils.listMatch(List, List, BiPredicate)"})
  void testListMatch_givenMarker_for_empty_whenArrayList_thenReturnFalse3() {
    // Arrange
    ArrayList<Object> list1 = new ArrayList<>();

    ArrayList<Object> list2 = new ArrayList<>();
    list2.add(BeanPropertyWriter.MARKER_FOR_EMPTY);

    // Act
    boolean actualListMatchResult =
        CollectionUtils.listMatch(list1, list2, mock(BiPredicate.class));

    // Assert
    assertFalse(actualListMatchResult);
  }

  /**
   * Test {@link CollectionUtils#listMatch(List, List, BiPredicate)}.
   *
   * <ul>
   *   <li>Given {@link BeanPropertyWriter#MARKER_FOR_EMPTY}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#listMatch(List, List, BiPredicate)}
   */
  @Test
  @DisplayName(
      "Test listMatch(List, List, BiPredicate); given MARKER_FOR_EMPTY; when ArrayList(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollectionUtils.listMatch(List, List, BiPredicate)"})
  void testListMatch_givenMarker_for_empty_whenArrayList_thenReturnFalse4() {
    // Arrange
    ArrayList<Object> list1 = new ArrayList<>();

    ArrayList<Object> list2 = new ArrayList<>();
    list2.add(BeanPropertyWriter.MARKER_FOR_EMPTY);
    list2.add(BeanPropertyWriter.MARKER_FOR_EMPTY);

    // Act
    boolean actualListMatchResult =
        CollectionUtils.listMatch(list1, list2, mock(BiPredicate.class));

    // Assert
    assertFalse(actualListMatchResult);
  }

  /**
   * Test {@link CollectionUtils#listMatch(List, List, BiPredicate)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link BiPredicate} {@link BiPredicate#test(Object, Object)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#listMatch(List, List, BiPredicate)}
   */
  @Test
  @DisplayName(
      "Test listMatch(List, List, BiPredicate); given 'true'; when BiPredicate test(Object, Object) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollectionUtils.listMatch(List, List, BiPredicate)"})
  void testListMatch_givenTrue_whenBiPredicateTestReturnTrue_thenReturnTrue() {
    // Arrange
    ArrayList<Object> list1 = new ArrayList<>();
    list1.add(BeanPropertyWriter.MARKER_FOR_EMPTY);

    ArrayList<Object> list2 = new ArrayList<>();
    list2.add(BeanPropertyWriter.MARKER_FOR_EMPTY);

    BiPredicate<Object, Object> comparer = mock(BiPredicate.class);
    when(comparer.test(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(true);

    // Act
    boolean actualListMatchResult = CollectionUtils.listMatch(list1, list2, comparer);

    // Assert
    verify(comparer).test(isA(Object.class), isA(Object.class));
    assertTrue(actualListMatchResult);
  }

  /**
   * Test {@link CollectionUtils#listMatch(List, List, BiPredicate)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#listMatch(List, List, BiPredicate)}
   */
  @Test
  @DisplayName("Test listMatch(List, List, BiPredicate); when ArrayList(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollectionUtils.listMatch(List, List, BiPredicate)"})
  void testListMatch_whenArrayList_thenReturnTrue() {
    // Arrange
    ArrayList<Object> list1 = new ArrayList<>();

    // Act
    boolean actualListMatchResult =
        CollectionUtils.listMatch(list1, new ArrayList<>(), mock(BiPredicate.class));

    // Assert
    assertTrue(actualListMatchResult);
  }

  /**
   * Test {@link CollectionUtils#collectionContains(Collection, Collection, BiPredicate)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link BiPredicate} {@link BiPredicate#test(Object, Object)} return {@code false}.
   *   <li>Then calls {@link BiPredicate#test(Object, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#collectionContains(Collection, Collection,
   * BiPredicate)}
   */
  @Test
  @DisplayName(
      "Test collectionContains(Collection, Collection, BiPredicate); given 'false'; when BiPredicate test(Object, Object) return 'false'; then calls test(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollectionUtils.collectionContains(Collection, Collection, BiPredicate)"
  })
  void testCollectionContains_givenFalse_whenBiPredicateTestReturnFalse_thenCallsTest() {
    // Arrange
    ArrayList<Object> col1 = new ArrayList<>();
    col1.add(BeanPropertyWriter.MARKER_FOR_EMPTY);

    ArrayList<Object> col2 = new ArrayList<>();
    col2.add(BeanPropertyWriter.MARKER_FOR_EMPTY);

    BiPredicate<Object, Object> comparer = mock(BiPredicate.class);
    when(comparer.test(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(false);

    // Act
    boolean actualCollectionContainsResult =
        CollectionUtils.collectionContains(col1, col2, comparer);

    // Assert
    verify(comparer).test(isA(Object.class), isA(Object.class));
    assertFalse(actualCollectionContainsResult);
  }

  /**
   * Test {@link CollectionUtils#collectionContains(Collection, Collection, BiPredicate)}.
   *
   * <ul>
   *   <li>Given {@link BeanPropertyWriter#MARKER_FOR_EMPTY}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#collectionContains(Collection, Collection,
   * BiPredicate)}
   */
  @Test
  @DisplayName(
      "Test collectionContains(Collection, Collection, BiPredicate); given MARKER_FOR_EMPTY; when ArrayList(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollectionUtils.collectionContains(Collection, Collection, BiPredicate)"
  })
  void testCollectionContains_givenMarker_for_empty_whenArrayList_thenReturnFalse() {
    // Arrange
    ArrayList<Object> col1 = new ArrayList<>();
    col1.add(BeanPropertyWriter.MARKER_FOR_EMPTY);

    // Act
    boolean actualCollectionContainsResult =
        CollectionUtils.collectionContains(col1, new ArrayList<>(), mock(BiPredicate.class));

    // Assert
    assertFalse(actualCollectionContainsResult);
  }

  /**
   * Test {@link CollectionUtils#collectionContains(Collection, Collection, BiPredicate)}.
   *
   * <ul>
   *   <li>Given {@link BeanPropertyWriter#MARKER_FOR_EMPTY}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#collectionContains(Collection, Collection,
   * BiPredicate)}
   */
  @Test
  @DisplayName(
      "Test collectionContains(Collection, Collection, BiPredicate); given MARKER_FOR_EMPTY; when ArrayList(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollectionUtils.collectionContains(Collection, Collection, BiPredicate)"
  })
  void testCollectionContains_givenMarker_for_empty_whenArrayList_thenReturnFalse2() {
    // Arrange
    ArrayList<Object> col1 = new ArrayList<>();
    col1.add(BeanPropertyWriter.MARKER_FOR_EMPTY);
    col1.add(BeanPropertyWriter.MARKER_FOR_EMPTY);

    // Act
    boolean actualCollectionContainsResult =
        CollectionUtils.collectionContains(col1, new ArrayList<>(), mock(BiPredicate.class));

    // Assert
    assertFalse(actualCollectionContainsResult);
  }

  /**
   * Test {@link CollectionUtils#collectionContains(Collection, Collection, BiPredicate)}.
   *
   * <ul>
   *   <li>Given {@link BeanPropertyWriter#MARKER_FOR_EMPTY}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#collectionContains(Collection, Collection,
   * BiPredicate)}
   */
  @Test
  @DisplayName(
      "Test collectionContains(Collection, Collection, BiPredicate); given MARKER_FOR_EMPTY; when ArrayList(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollectionUtils.collectionContains(Collection, Collection, BiPredicate)"
  })
  void testCollectionContains_givenMarker_for_empty_whenArrayList_thenReturnTrue() {
    // Arrange
    ArrayList<Object> col1 = new ArrayList<>();

    ArrayList<Object> col2 = new ArrayList<>();
    col2.add(BeanPropertyWriter.MARKER_FOR_EMPTY);

    // Act
    boolean actualCollectionContainsResult =
        CollectionUtils.collectionContains(col1, col2, mock(BiPredicate.class));

    // Assert
    assertTrue(actualCollectionContainsResult);
  }

  /**
   * Test {@link CollectionUtils#collectionContains(Collection, Collection, BiPredicate)}.
   *
   * <ul>
   *   <li>Given {@link BeanPropertyWriter#MARKER_FOR_EMPTY}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#collectionContains(Collection, Collection,
   * BiPredicate)}
   */
  @Test
  @DisplayName(
      "Test collectionContains(Collection, Collection, BiPredicate); given MARKER_FOR_EMPTY; when ArrayList(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollectionUtils.collectionContains(Collection, Collection, BiPredicate)"
  })
  void testCollectionContains_givenMarker_for_empty_whenArrayList_thenReturnTrue2() {
    // Arrange
    ArrayList<Object> col1 = new ArrayList<>();

    ArrayList<Object> col2 = new ArrayList<>();
    col2.add(BeanPropertyWriter.MARKER_FOR_EMPTY);
    col2.add(BeanPropertyWriter.MARKER_FOR_EMPTY);

    // Act
    boolean actualCollectionContainsResult =
        CollectionUtils.collectionContains(col1, col2, mock(BiPredicate.class));

    // Assert
    assertTrue(actualCollectionContainsResult);
  }

  /**
   * Test {@link CollectionUtils#collectionContains(Collection, Collection, BiPredicate)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link BiPredicate} {@link BiPredicate#test(Object, Object)} return {@code true}.
   *   <li>Then calls {@link BiPredicate#test(Object, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#collectionContains(Collection, Collection,
   * BiPredicate)}
   */
  @Test
  @DisplayName(
      "Test collectionContains(Collection, Collection, BiPredicate); given 'true'; when BiPredicate test(Object, Object) return 'true'; then calls test(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollectionUtils.collectionContains(Collection, Collection, BiPredicate)"
  })
  void testCollectionContains_givenTrue_whenBiPredicateTestReturnTrue_thenCallsTest() {
    // Arrange
    ArrayList<Object> col1 = new ArrayList<>();
    col1.add(BeanPropertyWriter.MARKER_FOR_EMPTY);

    ArrayList<Object> col2 = new ArrayList<>();
    col2.add(BeanPropertyWriter.MARKER_FOR_EMPTY);

    BiPredicate<Object, Object> comparer = mock(BiPredicate.class);
    when(comparer.test(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(true);

    // Act
    boolean actualCollectionContainsResult =
        CollectionUtils.collectionContains(col1, col2, comparer);

    // Assert
    verify(comparer).test(isA(Object.class), isA(Object.class));
    assertTrue(actualCollectionContainsResult);
  }

  /**
   * Test {@link CollectionUtils#collectionContains(Collection, Collection, BiPredicate)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#collectionContains(Collection, Collection,
   * BiPredicate)}
   */
  @Test
  @DisplayName(
      "Test collectionContains(Collection, Collection, BiPredicate); when ArrayList(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollectionUtils.collectionContains(Collection, Collection, BiPredicate)"
  })
  void testCollectionContains_whenArrayList_thenReturnTrue() {
    // Arrange
    ArrayList<Object> col1 = new ArrayList<>();

    // Act
    boolean actualCollectionContainsResult =
        CollectionUtils.collectionContains(col1, new ArrayList<>(), mock(BiPredicate.class));

    // Assert
    assertTrue(actualCollectionContainsResult);
  }
}
