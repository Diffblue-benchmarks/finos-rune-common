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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiPredicate;
import org.junit.Test;
import org.mockito.Mockito;

public class CollectionUtilsDiffblueTest {
  /**
   * Method under test: {@link CollectionUtils#listMatch(List, List, BiPredicate)}
   */
  @Test
  public void testListMatch() {
    // Arrange
    ArrayList<Object> list1 = new ArrayList<>();

    // Act and Assert
    assertTrue(CollectionUtils.listMatch(list1, new ArrayList<>(), mock(BiPredicate.class)));
  }

  /**
   * Method under test: {@link CollectionUtils#listMatch(List, List, BiPredicate)}
   */
  @Test
  public void testListMatch2() {
    // Arrange
    ArrayList<Object> list1 = new ArrayList<>();
    list1.add("42");

    // Act and Assert
    assertFalse(CollectionUtils.listMatch(list1, new ArrayList<>(), mock(BiPredicate.class)));
  }

  /**
   * Method under test: {@link CollectionUtils#listMatch(List, List, BiPredicate)}
   */
  @Test
  public void testListMatch3() {
    // Arrange
    ArrayList<Object> list1 = new ArrayList<>();
    list1.add("42");
    list1.add("42");

    // Act and Assert
    assertFalse(CollectionUtils.listMatch(list1, new ArrayList<>(), mock(BiPredicate.class)));
  }

  /**
   * Method under test: {@link CollectionUtils#listMatch(List, List, BiPredicate)}
   */
  @Test
  public void testListMatch4() {
    // Arrange
    ArrayList<Object> list1 = new ArrayList<>();

    ArrayList<Object> list2 = new ArrayList<>();
    list2.add("42");

    // Act and Assert
    assertFalse(CollectionUtils.listMatch(list1, list2, mock(BiPredicate.class)));
  }

  /**
   * Method under test: {@link CollectionUtils#listMatch(List, List, BiPredicate)}
   */
  @Test
  public void testListMatch5() {
    // Arrange
    ArrayList<Object> list1 = new ArrayList<>();

    ArrayList<Object> list2 = new ArrayList<>();
    list2.add("42");
    list2.add("42");

    // Act and Assert
    assertFalse(CollectionUtils.listMatch(list1, list2, mock(BiPredicate.class)));
  }

  /**
   * Method under test: {@link CollectionUtils#listMatch(List, List, BiPredicate)}
   */
  @Test
  public void testListMatch6() {
    // Arrange
    ArrayList<Object> list1 = new ArrayList<>();
    list1.add("42");

    ArrayList<Object> list2 = new ArrayList<>();
    list2.add("42");
    BiPredicate<Object, Object> comparer = mock(BiPredicate.class);
    when(comparer.test(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(true);

    // Act
    boolean actualListMatchResult = CollectionUtils.listMatch(list1, list2, comparer);

    // Assert
    verify(comparer).test(isA(Object.class), isA(Object.class));
    assertTrue(actualListMatchResult);
  }

  /**
   * Method under test: {@link CollectionUtils#listMatch(List, List, BiPredicate)}
   */
  @Test
  public void testListMatch7() {
    // Arrange
    ArrayList<Object> list1 = new ArrayList<>();
    list1.add("42");

    ArrayList<Object> list2 = new ArrayList<>();
    list2.add("42");
    BiPredicate<Object, Object> comparer = mock(BiPredicate.class);
    when(comparer.test(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(false);

    // Act
    boolean actualListMatchResult = CollectionUtils.listMatch(list1, list2, comparer);

    // Assert
    verify(comparer).test(isA(Object.class), isA(Object.class));
    assertFalse(actualListMatchResult);
  }

  /**
   * Method under test:
   * {@link CollectionUtils#collectionContains(Collection, Collection, BiPredicate)}
   */
  @Test
  public void testCollectionContains() {
    // Arrange
    ArrayList<Object> col1 = new ArrayList<>();

    // Act and Assert
    assertTrue(CollectionUtils.collectionContains(col1, new ArrayList<>(), mock(BiPredicate.class)));
  }

  /**
   * Method under test:
   * {@link CollectionUtils#collectionContains(Collection, Collection, BiPredicate)}
   */
  @Test
  public void testCollectionContains2() {
    // Arrange
    ArrayList<Object> col1 = new ArrayList<>();
    col1.add("42");

    // Act and Assert
    assertFalse(CollectionUtils.collectionContains(col1, new ArrayList<>(), mock(BiPredicate.class)));
  }

  /**
   * Method under test:
   * {@link CollectionUtils#collectionContains(Collection, Collection, BiPredicate)}
   */
  @Test
  public void testCollectionContains3() {
    // Arrange
    ArrayList<Object> col1 = new ArrayList<>();
    col1.add("42");
    col1.add("42");

    // Act and Assert
    assertFalse(CollectionUtils.collectionContains(col1, new ArrayList<>(), mock(BiPredicate.class)));
  }

  /**
   * Method under test:
   * {@link CollectionUtils#collectionContains(Collection, Collection, BiPredicate)}
   */
  @Test
  public void testCollectionContains4() {
    // Arrange
    ArrayList<Object> col1 = new ArrayList<>();

    ArrayList<Object> col2 = new ArrayList<>();
    col2.add("42");

    // Act and Assert
    assertTrue(CollectionUtils.collectionContains(col1, col2, mock(BiPredicate.class)));
  }

  /**
   * Method under test:
   * {@link CollectionUtils#collectionContains(Collection, Collection, BiPredicate)}
   */
  @Test
  public void testCollectionContains5() {
    // Arrange
    ArrayList<Object> col1 = new ArrayList<>();

    ArrayList<Object> col2 = new ArrayList<>();
    col2.add("42");
    col2.add("42");

    // Act and Assert
    assertTrue(CollectionUtils.collectionContains(col1, col2, mock(BiPredicate.class)));
  }

  /**
   * Method under test:
   * {@link CollectionUtils#collectionContains(Collection, Collection, BiPredicate)}
   */
  @Test
  public void testCollectionContains6() {
    // Arrange
    ArrayList<Object> col1 = new ArrayList<>();
    col1.add("42");

    ArrayList<Object> col2 = new ArrayList<>();
    col2.add("42");
    BiPredicate<Object, Object> comparer = mock(BiPredicate.class);
    when(comparer.test(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(true);

    // Act
    boolean actualCollectionContainsResult = CollectionUtils.collectionContains(col1, col2, comparer);

    // Assert
    verify(comparer).test(isA(Object.class), isA(Object.class));
    assertTrue(actualCollectionContainsResult);
  }

  /**
   * Method under test:
   * {@link CollectionUtils#collectionContains(Collection, Collection, BiPredicate)}
   */
  @Test
  public void testCollectionContains7() {
    // Arrange
    ArrayList<Object> col1 = new ArrayList<>();
    col1.add("42");

    ArrayList<Object> col2 = new ArrayList<>();
    col2.add("42");
    BiPredicate<Object, Object> comparer = mock(BiPredicate.class);
    when(comparer.test(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(false);

    // Act
    boolean actualCollectionContainsResult = CollectionUtils.collectionContains(col1, col2, comparer);

    // Assert
    verify(comparer).test(isA(Object.class), isA(Object.class));
    assertFalse(actualCollectionContainsResult);
  }
}
