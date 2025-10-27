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
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import org.junit.Test;
import org.mockito.Mockito;

public class SubstitutionMapDiffblueTest {
  /**
   * Method under test: {@link SubstitutionMap#getSubstitutedName(Object)}
   */
  @Test
  public void testGetSubstitutedName() {
    // Arrange, Act and Assert
    assertNull((new SubstitutionMap(new HashMap<>())).getSubstitutedName("Object"));
    assertNull((new SubstitutionMap(new HashMap<>())).getSubstitutedName(null));
  }

  /**
   * Method under test: {@link SubstitutionMap#getSubstitutedName(Object)}
   */
  @Test
  public void testGetSubstitutedName2() {
    // Arrange
    HashMap<JavaType, String> typeToNameMap = new HashMap<>();
    typeToNameMap.put(new PlaceholderForType(1), "foo");

    // Act and Assert
    assertEquals("foo", (new SubstitutionMap(typeToNameMap)).getSubstitutedName("Object"));
  }

  /**
   * Method under test: {@link SubstitutionMap#getSubstitutedName(Object)}
   */
  @Test
  public void testGetSubstitutedName3() {
    // Arrange
    HashMap<JavaType, String> typeToNameMap = new HashMap<>();
    typeToNameMap.computeIfPresent(new PlaceholderForType(1), mock(BiFunction.class));
    typeToNameMap.put(new PlaceholderForType(1), "foo");

    // Act and Assert
    assertEquals("foo", (new SubstitutionMap(typeToNameMap)).getSubstitutedName("Object"));
  }

  /**
   * Method under test: {@link SubstitutionMap#getSubstitutedName(Object)}
   */
  @Test
  public void testGetSubstitutedName4() {
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
   * Method under test: {@link SubstitutionMap#getSubstitutedName(Object)}
   */
  @Test
  public void testGetSubstitutedName5() {
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
   * Method under test: {@link SubstitutionMap#getTypes()}
   */
  @Test
  public void testGetTypes() {
    // Arrange and Act
    Collection<JavaType> actualTypes = (new SubstitutionMap(new HashMap<>())).getTypes();

    // Assert
    assertTrue(actualTypes instanceof Set);
    assertTrue(actualTypes.isEmpty());
  }

  /**
   * Method under test: {@link SubstitutionMap#getTypes()}
   */
  @Test
  public void testGetTypes2() {
    // Arrange
    HashMap<JavaType, String> typeToNameMap = new HashMap<>();
    typeToNameMap.computeIfPresent(new PlaceholderForType(1), mock(BiFunction.class));

    // Act
    Collection<JavaType> actualTypes = (new SubstitutionMap(typeToNameMap)).getTypes();

    // Assert
    assertTrue(actualTypes instanceof Set);
    assertTrue(actualTypes.isEmpty());
  }

  /**
   * Method under test: {@link SubstitutionMap#getName(JavaType)}
   */
  @Test
  public void testGetName() {
    // Arrange
    SubstitutionMap substitutionMap = new SubstitutionMap(new HashMap<>());

    // Act and Assert
    assertNull(substitutionMap.getName(new PlaceholderForType(1)));
  }

  /**
   * Method under test: {@link SubstitutionMap#getName(JavaType)}
   */
  @Test
  public void testGetName2() {
    // Arrange
    HashMap<JavaType, String> typeToNameMap = new HashMap<>();
    typeToNameMap.computeIfPresent(new PlaceholderForType(1), mock(BiFunction.class));
    SubstitutionMap substitutionMap = new SubstitutionMap(typeToNameMap);

    // Act and Assert
    assertNull(substitutionMap.getName(new PlaceholderForType(1)));
  }

  /**
   * Method under test: {@link SubstitutionMap#SubstitutionMap(Map)}
   */
  @Test
  public void testNewSubstitutionMap() {
    // Arrange, Act and Assert
    Collection<JavaType> types = (new SubstitutionMap(new HashMap<>())).getTypes();
    assertTrue(types instanceof Set);
    assertTrue(types.isEmpty());
  }

  /**
   * Method under test: {@link SubstitutionMap#SubstitutionMap(Map)}
   */
  @Test
  public void testNewSubstitutionMap2() {
    // Arrange
    HashMap<JavaType, String> typeToNameMap = new HashMap<>();
    typeToNameMap.put(new PlaceholderForType(1), "foo");

    // Act and Assert
    Collection<JavaType> types = (new SubstitutionMap(typeToNameMap)).getTypes();
    assertEquals(1, types.size());
    assertTrue(types instanceof Set);
  }

  /**
   * Method under test: {@link SubstitutionMap#SubstitutionMap(Map)}
   */
  @Test
  public void testNewSubstitutionMap3() {
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
   * Method under test: {@link SubstitutionMap#SubstitutionMap(Map)}
   */
  @Test
  public void testNewSubstitutionMap4() {
    // Arrange
    HashMap<JavaType, String> typeToNameMap = new HashMap<>();
    typeToNameMap.computeIfPresent(new PlaceholderForType(1), mock(BiFunction.class));
    typeToNameMap.put(new PlaceholderForType(1), "foo");

    // Act and Assert
    Collection<JavaType> types = (new SubstitutionMap(typeToNameMap)).getTypes();
    assertEquals(1, types.size());
    assertTrue(types instanceof Set);
  }

  /**
   * Method under test: {@link SubstitutionMap#SubstitutionMap(Map)}
   */
  @Test
  public void testNewSubstitutionMap5() {
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
   * Method under test: {@link SubstitutionMap#SubstitutionMap(Map)}
   */
  @Test
  public void testNewSubstitutionMap6() {
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
   * Method under test: {@link SubstitutionMap#SubstitutionMap(Map)}
   */
  @Test
  public void testNewSubstitutionMap7() {
    // Arrange
    HashMap<JavaType, String> typeToNameMap = new HashMap<>();
    Class<JavaType> forNameResult = JavaType.class;
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    Mockito.<Class<?>>when(collectionLikeType.getRawClass()).thenReturn(forNameResult);
    typeToNameMap.put(collectionLikeType, "42");
    Class<Object> forNameResult2 = Object.class;
    CollectionLikeType collectionLikeType2 = mock(CollectionLikeType.class);
    Mockito.<Class<?>>when(collectionLikeType2.getRawClass()).thenReturn(forNameResult2);
    typeToNameMap.put(collectionLikeType2, "foo");

    // Act and Assert
    Collection<JavaType> types = (new SubstitutionMap(typeToNameMap)).getTypes();
    verify(collectionLikeType, atLeast(1)).getRawClass();
    verify(collectionLikeType2, atLeast(1)).getRawClass();
    assertEquals(2, types.size());
    assertTrue(types instanceof Set);
  }

  /**
   * Method under test: {@link SubstitutionMap#SubstitutionMap(Map)}
   */
  @Test
  public void testNewSubstitutionMap8() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(collectionLikeType.getRawClass()).thenReturn(forNameResult);
    CollectionLikeType collectionLikeType2 = mock(CollectionLikeType.class);
    Class<String> forNameResult2 = String.class;
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
   * Method under test: {@link SubstitutionMap#SubstitutionMap(Map)}
   */
  @Test
  public void testNewSubstitutionMap9() {
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
}
