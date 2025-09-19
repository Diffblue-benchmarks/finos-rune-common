package com.regnosys.rosetta.common.serialisation.xml;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SubstitutionMapDiffblueTest {
  /**
   * Test {@link SubstitutionMap#SubstitutionMap(Map)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link SubstitutionMap#SubstitutionMap(Map)}
   */
  @Test
  @DisplayName("Test new SubstitutionMap(Map); given empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SubstitutionMap.<init>(Map)"})
  void testNewSubstitutionMap_givenEmptyString() {
    // Arrange
    HashMap<JavaType, String> typeToNameMap = new HashMap<>();
    typeToNameMap.put(new PlaceholderForType(1), "");
    typeToNameMap.put(new PlaceholderForType(1), "42");
    typeToNameMap.put(new PlaceholderForType(1), "foo");

    // Act and Assert
    Collection<JavaType> types = new SubstitutionMap(typeToNameMap).getTypes();
    assertEquals(3, types.size());
    assertTrue(types instanceof Set);
  }

  /**
   * Test {@link SubstitutionMap#SubstitutionMap(Map)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then return Types size is two.
   * </ul>
   *
   * <p>Method under test: {@link SubstitutionMap#SubstitutionMap(Map)}
   */
  @Test
  @DisplayName(
      "Test new SubstitutionMap(Map); given 'java.lang.Object'; then return Types size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SubstitutionMap.<init>(Map)"})
  void testNewSubstitutionMap_givenJavaLangObject_thenReturnTypesSizeIsTwo() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(arrayType.getRawClass()).thenReturn(forNameResult);

    ArrayType arrayType2 = mock(ArrayType.class);
    Class<Object> forNameResult2 = Object.class;
    Mockito.<Class<?>>when(arrayType2.getRawClass()).thenReturn(forNameResult2);

    HashMap<JavaType, String> typeToNameMap = new HashMap<>();
    typeToNameMap.put(arrayType2, "42");
    typeToNameMap.put(arrayType, "foo");

    // Act
    SubstitutionMap actualSubstitutionMap = new SubstitutionMap(typeToNameMap);

    // Assert
    verify(arrayType2).getRawClass();
    verify(arrayType).getRawClass();
    Collection<JavaType> types = actualSubstitutionMap.getTypes();
    assertEquals(2, types.size());
    assertTrue(types instanceof Set);
  }

  /**
   * Test {@link SubstitutionMap#SubstitutionMap(Map)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then return Types size is two.
   * </ul>
   *
   * <p>Method under test: {@link SubstitutionMap#SubstitutionMap(Map)}
   */
  @Test
  @DisplayName(
      "Test new SubstitutionMap(Map); given 'java.lang.String'; then return Types size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SubstitutionMap.<init>(Map)"})
  void testNewSubstitutionMap_givenJavaLangString_thenReturnTypesSizeIsTwo() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    Class<String> forNameResult = String.class;
    Mockito.<Class<?>>when(arrayType.getRawClass()).thenReturn(forNameResult);

    ArrayType arrayType2 = mock(ArrayType.class);
    Class<JavaType> forNameResult2 = JavaType.class;
    Mockito.<Class<?>>when(arrayType2.getRawClass()).thenReturn(forNameResult2);

    HashMap<JavaType, String> typeToNameMap = new HashMap<>();
    typeToNameMap.put(arrayType2, "42");
    typeToNameMap.put(arrayType, "foo");

    // Act
    SubstitutionMap actualSubstitutionMap = new SubstitutionMap(typeToNameMap);

    // Assert
    verify(arrayType2, atLeast(1)).getRawClass();
    verify(arrayType, atLeast(1)).getRawClass();
    Collection<JavaType> types = actualSubstitutionMap.getTypes();
    assertEquals(2, types.size());
    assertTrue(types instanceof Set);
  }

  /**
   * Test {@link SubstitutionMap#SubstitutionMap(Map)}.
   *
   * <ul>
   *   <li>Then return Types size is one.
   * </ul>
   *
   * <p>Method under test: {@link SubstitutionMap#SubstitutionMap(Map)}
   */
  @Test
  @DisplayName("Test new SubstitutionMap(Map); then return Types size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SubstitutionMap.<init>(Map)"})
  void testNewSubstitutionMap_thenReturnTypesSizeIsOne() {
    // Arrange
    HashMap<JavaType, String> typeToNameMap = new HashMap<>();
    typeToNameMap.put(new PlaceholderForType(1), "foo");

    // Act and Assert
    Collection<JavaType> types = new SubstitutionMap(typeToNameMap).getTypes();
    assertEquals(1, types.size());
    assertTrue(types instanceof Set);
  }

  /**
   * Test {@link SubstitutionMap#SubstitutionMap(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@link PlaceholderForType#PlaceholderForType(int)} with
   *       ordinal is one is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SubstitutionMap#SubstitutionMap(Map)}
   */
  @Test
  @DisplayName(
      "Test new SubstitutionMap(Map); when HashMap() PlaceholderForType(int) with ordinal is one is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SubstitutionMap.<init>(Map)"})
  void testNewSubstitutionMap_whenHashMapPlaceholderForTypeWithOrdinalIsOneIs42() {
    // Arrange
    HashMap<JavaType, String> typeToNameMap = new HashMap<>();
    typeToNameMap.put(new PlaceholderForType(1), "42");
    typeToNameMap.put(new PlaceholderForType(1), "foo");

    // Act and Assert
    Collection<JavaType> types = new SubstitutionMap(typeToNameMap).getTypes();
    assertEquals(2, types.size());
    assertTrue(types instanceof Set);
  }

  /**
   * Test {@link SubstitutionMap#SubstitutionMap(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return Types Empty.
   * </ul>
   *
   * <p>Method under test: {@link SubstitutionMap#SubstitutionMap(Map)}
   */
  @Test
  @DisplayName("Test new SubstitutionMap(Map); when HashMap(); then return Types Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SubstitutionMap.<init>(Map)"})
  void testNewSubstitutionMap_whenHashMap_thenReturnTypesEmpty() {
    // Arrange, Act and Assert
    Collection<JavaType> types = new SubstitutionMap(new HashMap<>()).getTypes();
    assertTrue(types instanceof Set);
    assertTrue(types.isEmpty());
  }

  /**
   * Test {@link SubstitutionMap#getSubstitutedName(Object)}.
   *
   * <ul>
   *   <li>Given {@link ArrayType} {@link ArrayType#isTypeOrSuperTypeOf(Class)} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link SubstitutionMap#getSubstitutedName(Object)}
   */
  @Test
  @DisplayName(
      "Test getSubstitutedName(Object); given ArrayType isTypeOrSuperTypeOf(Class) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SubstitutionMap.getSubstitutedName(Object)"})
  void testGetSubstitutedName_givenArrayTypeIsTypeOrSuperTypeOfReturnFalse() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.isTypeOrSuperTypeOf(Mockito.<Class<?>>any())).thenReturn(false);

    HashMap<JavaType, String> typeToNameMap = new HashMap<>();
    typeToNameMap.put(arrayType, "foo");

    // Act
    String actualSubstitutedName =
        new SubstitutionMap(typeToNameMap).getSubstitutedName(BeanPropertyWriter.MARKER_FOR_EMPTY);

    // Assert
    verify(arrayType).isTypeOrSuperTypeOf(isA(Class.class));
    assertNull(actualSubstitutedName);
  }

  /**
   * Test {@link SubstitutionMap#getSubstitutedName(Object)}.
   *
   * <ul>
   *   <li>Given {@link ArrayType} {@link ArrayType#isTypeOrSuperTypeOf(Class)} return {@code true}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link SubstitutionMap#getSubstitutedName(Object)}
   */
  @Test
  @DisplayName(
      "Test getSubstitutedName(Object); given ArrayType isTypeOrSuperTypeOf(Class) return 'true'; then return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SubstitutionMap.getSubstitutedName(Object)"})
  void testGetSubstitutedName_givenArrayTypeIsTypeOrSuperTypeOfReturnTrue_thenReturnFoo() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.isTypeOrSuperTypeOf(Mockito.<Class<?>>any())).thenReturn(true);

    HashMap<JavaType, String> typeToNameMap = new HashMap<>();
    typeToNameMap.put(arrayType, "foo");

    // Act
    String actualSubstitutedName =
        new SubstitutionMap(typeToNameMap).getSubstitutedName(BeanPropertyWriter.MARKER_FOR_EMPTY);

    // Assert
    verify(arrayType).isTypeOrSuperTypeOf(isA(Class.class));
    assertEquals("foo", actualSubstitutedName);
  }

  /**
   * Test {@link SubstitutionMap#getSubstitutedName(Object)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link PlaceholderForType#PlaceholderForType(int)} with
   *       ordinal is one is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link SubstitutionMap#getSubstitutedName(Object)}
   */
  @Test
  @DisplayName(
      "Test getSubstitutedName(Object); given HashMap() PlaceholderForType(int) with ordinal is one is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SubstitutionMap.getSubstitutedName(Object)"})
  void testGetSubstitutedName_givenHashMapPlaceholderForTypeWithOrdinalIsOneIsFoo() {
    // Arrange
    HashMap<JavaType, String> typeToNameMap = new HashMap<>();
    typeToNameMap.put(new PlaceholderForType(1), "foo");

    // Act and Assert
    assertEquals(
        "foo",
        new SubstitutionMap(typeToNameMap).getSubstitutedName(BeanPropertyWriter.MARKER_FOR_EMPTY));
  }

  /**
   * Test {@link SubstitutionMap#getSubstitutedName(Object)}.
   *
   * <ul>
   *   <li>When {@link BeanPropertyWriter#MARKER_FOR_EMPTY}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SubstitutionMap#getSubstitutedName(Object)}
   */
  @Test
  @DisplayName("Test getSubstitutedName(Object); when MARKER_FOR_EMPTY; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SubstitutionMap.getSubstitutedName(Object)"})
  void testGetSubstitutedName_whenMarker_for_empty_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new SubstitutionMap(new HashMap<>())
            .getSubstitutedName(BeanPropertyWriter.MARKER_FOR_EMPTY));
  }

  /**
   * Test {@link SubstitutionMap#getSubstitutedName(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SubstitutionMap#getSubstitutedName(Object)}
   */
  @Test
  @DisplayName("Test getSubstitutedName(Object); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SubstitutionMap.getSubstitutedName(Object)"})
  void testGetSubstitutedName_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new SubstitutionMap(new HashMap<>()).getSubstitutedName(null));
  }

  /**
   * Test {@link SubstitutionMap#getTypes()}.
   *
   * <p>Method under test: {@link SubstitutionMap#getTypes()}
   */
  @Test
  @DisplayName("Test getTypes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection SubstitutionMap.getTypes()"})
  void testGetTypes() {
    // Arrange and Act
    Collection<JavaType> actualTypes = new SubstitutionMap(new HashMap<>()).getTypes();

    // Assert
    assertTrue(actualTypes instanceof Set);
    assertTrue(actualTypes.isEmpty());
  }

  /**
   * Test {@link SubstitutionMap#getName(JavaType)}.
   *
   * <p>Method under test: {@link SubstitutionMap#getName(JavaType)}
   */
  @Test
  @DisplayName("Test getName(JavaType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SubstitutionMap.getName(JavaType)"})
  void testGetName() {
    // Arrange
    SubstitutionMap substitutionMap = new SubstitutionMap(new HashMap<>());

    // Act
    String actualName = substitutionMap.getName(new PlaceholderForType(1));

    // Assert
    assertNull(actualName);
  }
}
