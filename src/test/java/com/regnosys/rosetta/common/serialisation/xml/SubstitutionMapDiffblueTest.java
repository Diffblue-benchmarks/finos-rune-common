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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class SubstitutionMapDiffblueTest {
  /**
   * Test {@link SubstitutionMap#SubstitutionMap(Map)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubstitutionMap#SubstitutionMap(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SubstitutionMap.<init>(Map)"})
  public void testNewSubstitutionMap_givenEmptyString() {
    // Arrange
    HashMap<JavaType, String> typeToNameMap = new HashMap<>();
    typeToNameMap.put(new PlaceholderForType(1), "");
    typeToNameMap.put(new PlaceholderForType(1), "42");
    typeToNameMap.put(new PlaceholderForType(1), "foo");

    // Act and Assert
    Collection<JavaType> types = (new SubstitutionMap(typeToNameMap)).getTypes();
    assertEquals(3, types.size());
    assertTrue(types instanceof Set);
  }

  /**
   * Test {@link SubstitutionMap#SubstitutionMap(Map)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>Then return Types size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubstitutionMap#SubstitutionMap(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SubstitutionMap.<init>(Map)"})
  public void testNewSubstitutionMap_givenJavaLangObject_thenReturnTypesSizeIsTwo() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(collectionLikeType.getRawClass()).thenReturn(forNameResult);
    CollectionLikeType collectionLikeType2 = mock(CollectionLikeType.class);
    Class<Object> forNameResult2 = Object.class;
    Mockito.<Class<?>>when(collectionLikeType2.getRawClass()).thenReturn(forNameResult2);

    HashMap<JavaType, String> typeToNameMap = new HashMap<>();
    typeToNameMap.put(collectionLikeType2, "42");
    typeToNameMap.put(collectionLikeType, "foo");

    // Act
    SubstitutionMap actualSubstitutionMap = new SubstitutionMap(typeToNameMap);

    // Assert
    verify(collectionLikeType2).getRawClass();
    verify(collectionLikeType).getRawClass();
    Collection<JavaType> types = actualSubstitutionMap.getTypes();
    assertEquals(2, types.size());
    assertTrue(types instanceof Set);
  }

  /**
   * Test {@link SubstitutionMap#SubstitutionMap(Map)}.
   * <ul>
   *   <li>Given {@code String}.</li>
   *   <li>Then return Types size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubstitutionMap#SubstitutionMap(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SubstitutionMap.<init>(Map)"})
  public void testNewSubstitutionMap_givenJavaLangString_thenReturnTypesSizeIsTwo() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    Class<String> forNameResult = String.class;
    Mockito.<Class<?>>when(collectionLikeType.getRawClass()).thenReturn(forNameResult);
    CollectionLikeType collectionLikeType2 = mock(CollectionLikeType.class);
    Class<JavaType> forNameResult2 = JavaType.class;
    Mockito.<Class<?>>when(collectionLikeType2.getRawClass()).thenReturn(forNameResult2);

    HashMap<JavaType, String> typeToNameMap = new HashMap<>();
    typeToNameMap.put(collectionLikeType2, "42");
    typeToNameMap.put(collectionLikeType, "foo");

    // Act
    SubstitutionMap actualSubstitutionMap = new SubstitutionMap(typeToNameMap);

    // Assert
    verify(collectionLikeType2, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getRawClass();
    Collection<JavaType> types = actualSubstitutionMap.getTypes();
    assertEquals(2, types.size());
    assertTrue(types instanceof Set);
  }

  /**
   * Test {@link SubstitutionMap#SubstitutionMap(Map)}.
   * <ul>
   *   <li>Then return Types size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubstitutionMap#SubstitutionMap(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SubstitutionMap.<init>(Map)"})
  public void testNewSubstitutionMap_thenReturnTypesSizeIsOne() {
    // Arrange
    HashMap<JavaType, String> typeToNameMap = new HashMap<>();
    typeToNameMap.put(new PlaceholderForType(1), "foo");

    // Act and Assert
    Collection<JavaType> types = (new SubstitutionMap(typeToNameMap)).getTypes();
    assertEquals(1, types.size());
    assertTrue(types instanceof Set);
  }

  /**
   * Test {@link SubstitutionMap#SubstitutionMap(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@link PlaceholderForType#PlaceholderForType(int)} with ordinal is one is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubstitutionMap#SubstitutionMap(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SubstitutionMap.<init>(Map)"})
  public void testNewSubstitutionMap_whenHashMapPlaceholderForTypeWithOrdinalIsOneIs42() {
    // Arrange
    HashMap<JavaType, String> typeToNameMap = new HashMap<>();
    typeToNameMap.put(new PlaceholderForType(1), "42");
    typeToNameMap.put(new PlaceholderForType(1), "foo");

    // Act and Assert
    Collection<JavaType> types = (new SubstitutionMap(typeToNameMap)).getTypes();
    assertEquals(2, types.size());
    assertTrue(types instanceof Set);
  }

  /**
   * Test {@link SubstitutionMap#SubstitutionMap(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return Types Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubstitutionMap#SubstitutionMap(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SubstitutionMap.<init>(Map)"})
  public void testNewSubstitutionMap_whenHashMap_thenReturnTypesEmpty() {
    // Arrange, Act and Assert
    Collection<JavaType> types = (new SubstitutionMap(new HashMap<>())).getTypes();
    assertTrue(types instanceof Set);
    assertTrue(types.isEmpty());
  }

  /**
   * Test {@link SubstitutionMap#getSubstitutedName(Object)}.
   * <ul>
   *   <li>Given {@link CollectionLikeType} {@link JavaType#isTypeOrSuperTypeOf(Class)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubstitutionMap#getSubstitutedName(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SubstitutionMap.getSubstitutedName(Object)"})
  public void testGetSubstitutedName_givenCollectionLikeTypeIsTypeOrSuperTypeOfReturnFalse() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.isTypeOrSuperTypeOf(Mockito.<Class<Object>>any())).thenReturn(false);

    HashMap<JavaType, String> typeToNameMap = new HashMap<>();
    typeToNameMap.put(collectionLikeType, "foo");

    // Act
    String actualSubstitutedName = (new SubstitutionMap(typeToNameMap)).getSubstitutedName("Object");

    // Assert
    verify(collectionLikeType).isTypeOrSuperTypeOf(isA(Class.class));
    assertNull(actualSubstitutedName);
  }

  /**
   * Test {@link SubstitutionMap#getSubstitutedName(Object)}.
   * <ul>
   *   <li>Given {@link CollectionLikeType} {@link JavaType#isTypeOrSuperTypeOf(Class)} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubstitutionMap#getSubstitutedName(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SubstitutionMap.getSubstitutedName(Object)"})
  public void testGetSubstitutedName_givenCollectionLikeTypeIsTypeOrSuperTypeOfReturnTrue() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.isTypeOrSuperTypeOf(Mockito.<Class<Object>>any())).thenReturn(true);

    HashMap<JavaType, String> typeToNameMap = new HashMap<>();
    typeToNameMap.put(collectionLikeType, "foo");

    // Act
    String actualSubstitutedName = (new SubstitutionMap(typeToNameMap)).getSubstitutedName("Object");

    // Assert
    verify(collectionLikeType).isTypeOrSuperTypeOf(isA(Class.class));
    assertEquals("foo", actualSubstitutedName);
  }

  /**
   * Test {@link SubstitutionMap#getSubstitutedName(Object)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link PlaceholderForType#PlaceholderForType(int)} with ordinal is one is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubstitutionMap#getSubstitutedName(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SubstitutionMap.getSubstitutedName(Object)"})
  public void testGetSubstitutedName_givenHashMapPlaceholderForTypeWithOrdinalIsOneIsFoo() {
    // Arrange
    HashMap<JavaType, String> typeToNameMap = new HashMap<>();
    typeToNameMap.put(new PlaceholderForType(1), "foo");

    // Act and Assert
    assertEquals("foo", (new SubstitutionMap(typeToNameMap)).getSubstitutedName("Object"));
  }

  /**
   * Test {@link SubstitutionMap#getSubstitutedName(Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubstitutionMap#getSubstitutedName(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SubstitutionMap.getSubstitutedName(Object)"})
  public void testGetSubstitutedName_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SubstitutionMap(new HashMap<>())).getSubstitutedName(null));
  }

  /**
   * Test {@link SubstitutionMap#getSubstitutedName(Object)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubstitutionMap#getSubstitutedName(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SubstitutionMap.getSubstitutedName(Object)"})
  public void testGetSubstitutedName_whenObject_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SubstitutionMap(new HashMap<>())).getSubstitutedName("Object"));
  }

  /**
   * Test {@link SubstitutionMap#getTypes()}.
   * <p>
   * Method under test: {@link SubstitutionMap#getTypes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection SubstitutionMap.getTypes()"})
  public void testGetTypes() {
    // Arrange and Act
    Collection<JavaType> actualTypes = (new SubstitutionMap(new HashMap<>())).getTypes();

    // Assert
    assertTrue(actualTypes instanceof Set);
    assertTrue(actualTypes.isEmpty());
  }

  /**
   * Test {@link SubstitutionMap#getName(JavaType)}.
   * <p>
   * Method under test: {@link SubstitutionMap#getName(JavaType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SubstitutionMap.getName(JavaType)"})
  public void testGetName() {
    // Arrange
    SubstitutionMap substitutionMap = new SubstitutionMap(new HashMap<>());

    // Act and Assert
    assertNull(substitutionMap.getName(new PlaceholderForType(1)));
  }
}
