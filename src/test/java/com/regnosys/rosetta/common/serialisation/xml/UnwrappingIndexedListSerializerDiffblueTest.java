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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.util.NameTransformer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UnwrappingIndexedListSerializerDiffblueTest {
  /**
   * Test {@link UnwrappingIndexedListSerializer#UnwrappingIndexedListSerializer(JavaType, boolean,
   * TypeSerializer, JsonSerializer, NameTransformer)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link JavaType} {@link JavaType#isFinal()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UnwrappingIndexedListSerializer#UnwrappingIndexedListSerializer(JavaType, boolean,
   * TypeSerializer, JsonSerializer, NameTransformer)}
   */
  @Test
  @DisplayName(
      "Test new UnwrappingIndexedListSerializer(JavaType, boolean, TypeSerializer, JsonSerializer, NameTransformer); given 'false'; when JavaType isFinal() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnwrappingIndexedListSerializer.<init>(JavaType, boolean, TypeSerializer, JsonSerializer, NameTransformer)"
  })
  void testNewUnwrappingIndexedListSerializer_givenFalse_whenJavaTypeIsFinalReturnFalse() {
    // Arrange
    JavaType elemType = mock(JavaType.class);
    when(elemType.isFinal()).thenReturn(false);
    JsonSerializer<Object> valueSerializer = mock(JsonSerializer.class);

    // Act
    UnwrappingIndexedListSerializer actualUnwrappingIndexedListSerializer =
        new UnwrappingIndexedListSerializer(
            elemType,
            false,
            mock(TypeSerializer.class),
            valueSerializer,
            mock(NameTransformer.class));

    // Assert
    verify(elemType).isFinal();
    assertNull(actualUnwrappingIndexedListSerializer._property);
    assertNull(actualUnwrappingIndexedListSerializer.getDelegatee());
    assertFalse(actualUnwrappingIndexedListSerializer._staticTyping);
    assertTrue(actualUnwrappingIndexedListSerializer.isUnwrappingSerializer());
    assertSame(elemType, actualUnwrappingIndexedListSerializer.getContentType());
    assertSame(valueSerializer, actualUnwrappingIndexedListSerializer.getContentSerializer());
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#UnwrappingIndexedListSerializer(JavaType, boolean,
   * TypeSerializer, JsonSerializer, NameTransformer)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link JavaType} {@link JavaType#isFinal()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UnwrappingIndexedListSerializer#UnwrappingIndexedListSerializer(JavaType, boolean,
   * TypeSerializer, JsonSerializer, NameTransformer)}
   */
  @Test
  @DisplayName(
      "Test new UnwrappingIndexedListSerializer(JavaType, boolean, TypeSerializer, JsonSerializer, NameTransformer); given 'true'; when JavaType isFinal() return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnwrappingIndexedListSerializer.<init>(JavaType, boolean, TypeSerializer, JsonSerializer, NameTransformer)"
  })
  void testNewUnwrappingIndexedListSerializer_givenTrue_whenJavaTypeIsFinalReturnTrue() {
    // Arrange
    JavaType elemType = mock(JavaType.class);
    when(elemType.isFinal()).thenReturn(true);
    JsonSerializer<Object> valueSerializer = mock(JsonSerializer.class);

    // Act
    UnwrappingIndexedListSerializer actualUnwrappingIndexedListSerializer =
        new UnwrappingIndexedListSerializer(
            elemType,
            false,
            mock(TypeSerializer.class),
            valueSerializer,
            mock(NameTransformer.class));

    // Assert
    verify(elemType).isFinal();
    assertNull(actualUnwrappingIndexedListSerializer._property);
    assertNull(actualUnwrappingIndexedListSerializer.getDelegatee());
    assertTrue(actualUnwrappingIndexedListSerializer.isUnwrappingSerializer());
    assertTrue(actualUnwrappingIndexedListSerializer._staticTyping);
    assertSame(elemType, actualUnwrappingIndexedListSerializer.getContentType());
    assertSame(valueSerializer, actualUnwrappingIndexedListSerializer.getContentSerializer());
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#UnwrappingIndexedListSerializer(JavaType, boolean,
   * TypeSerializer, JsonSerializer, NameTransformer)}.
   *
   * <ul>
   *   <li>Then ContentType return {@link PlaceholderForType}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UnwrappingIndexedListSerializer#UnwrappingIndexedListSerializer(JavaType, boolean,
   * TypeSerializer, JsonSerializer, NameTransformer)}
   */
  @Test
  @DisplayName(
      "Test new UnwrappingIndexedListSerializer(JavaType, boolean, TypeSerializer, JsonSerializer, NameTransformer); then ContentType return PlaceholderForType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnwrappingIndexedListSerializer.<init>(JavaType, boolean, TypeSerializer, JsonSerializer, NameTransformer)"
  })
  void testNewUnwrappingIndexedListSerializer_thenContentTypeReturnPlaceholderForType() {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);

    // Act and Assert
    JavaType contentType =
        new UnwrappingIndexedListSerializer(
                elemType,
                false,
                mock(TypeSerializer.class),
                mock(JsonSerializer.class),
                mock(NameTransformer.class))
            .getContentType();
    assertTrue(contentType instanceof PlaceholderForType);
    assertSame(elemType, contentType);
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#UnwrappingIndexedListSerializer(JavaType, boolean,
   * TypeSerializer, JsonSerializer, NameTransformer)}.
   *
   * <ul>
   *   <li>When {@link JavaType}.
   *   <li>Then return {@link UnwrappingAsArraySerializerBase#_staticTyping}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UnwrappingIndexedListSerializer#UnwrappingIndexedListSerializer(JavaType, boolean,
   * TypeSerializer, JsonSerializer, NameTransformer)}
   */
  @Test
  @DisplayName(
      "Test new UnwrappingIndexedListSerializer(JavaType, boolean, TypeSerializer, JsonSerializer, NameTransformer); when JavaType; then return _staticTyping")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnwrappingIndexedListSerializer.<init>(JavaType, boolean, TypeSerializer, JsonSerializer, NameTransformer)"
  })
  void testNewUnwrappingIndexedListSerializer_whenJavaType_thenReturn_staticTyping() {
    // Arrange
    JavaType elemType = mock(JavaType.class);
    JsonSerializer<Object> valueSerializer = mock(JsonSerializer.class);

    // Act
    UnwrappingIndexedListSerializer actualUnwrappingIndexedListSerializer =
        new UnwrappingIndexedListSerializer(
            elemType,
            true,
            mock(TypeSerializer.class),
            valueSerializer,
            mock(NameTransformer.class));

    // Assert
    assertNull(actualUnwrappingIndexedListSerializer._property);
    assertNull(actualUnwrappingIndexedListSerializer.getDelegatee());
    assertTrue(actualUnwrappingIndexedListSerializer.isUnwrappingSerializer());
    assertTrue(actualUnwrappingIndexedListSerializer._staticTyping);
    assertSame(elemType, actualUnwrappingIndexedListSerializer.getContentType());
    assertSame(valueSerializer, actualUnwrappingIndexedListSerializer.getContentSerializer());
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#UnwrappingIndexedListSerializer(JavaType, boolean,
   * TypeSerializer, JsonSerializer, NameTransformer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ContentType is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UnwrappingIndexedListSerializer#UnwrappingIndexedListSerializer(JavaType, boolean,
   * TypeSerializer, JsonSerializer, NameTransformer)}
   */
  @Test
  @DisplayName(
      "Test new UnwrappingIndexedListSerializer(JavaType, boolean, TypeSerializer, JsonSerializer, NameTransformer); when 'null'; then return ContentType is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnwrappingIndexedListSerializer.<init>(JavaType, boolean, TypeSerializer, JsonSerializer, NameTransformer)"
  })
  void testNewUnwrappingIndexedListSerializer_whenNull_thenReturnContentTypeIsNull() {
    // Arrange
    JsonSerializer<Object> valueSerializer = mock(JsonSerializer.class);

    // Act
    UnwrappingIndexedListSerializer actualUnwrappingIndexedListSerializer =
        new UnwrappingIndexedListSerializer(
            null, false, mock(TypeSerializer.class), valueSerializer, mock(NameTransformer.class));

    // Assert
    assertNull(actualUnwrappingIndexedListSerializer._property);
    assertNull(actualUnwrappingIndexedListSerializer.getContentType());
    assertNull(actualUnwrappingIndexedListSerializer.getDelegatee());
    assertFalse(actualUnwrappingIndexedListSerializer._staticTyping);
    assertTrue(actualUnwrappingIndexedListSerializer.isUnwrappingSerializer());
    assertSame(valueSerializer, actualUnwrappingIndexedListSerializer.getContentSerializer());
  }
}
