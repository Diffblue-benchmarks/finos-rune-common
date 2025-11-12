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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UnwrappableIndexedListSerializerDiffblueTest {
  /**
   * Test {@link UnwrappableIndexedListSerializer#UnwrappableIndexedListSerializer(JavaType,
   * boolean, TypeSerializer, JsonSerializer)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UnwrappableIndexedListSerializer#UnwrappableIndexedListSerializer(JavaType, boolean,
   * TypeSerializer, JsonSerializer)}
   */
  @Test
  @DisplayName(
      "Test new UnwrappableIndexedListSerializer(JavaType, boolean, TypeSerializer, JsonSerializer); given 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnwrappableIndexedListSerializer.<init>(JavaType, boolean, TypeSerializer, JsonSerializer)"
  })
  void testNewUnwrappableIndexedListSerializer_givenFalse() {
    // Arrange
    JavaType elemType = mock(JavaType.class);
    when(elemType.isFinal()).thenReturn(false);
    JsonSerializer<Object> valueSerializer = mock(JsonSerializer.class);

    // Act
    UnwrappableIndexedListSerializer actualUnwrappableIndexedListSerializer =
        new UnwrappableIndexedListSerializer(
            elemType, false, mock(TypeSerializer.class), valueSerializer);

    // Assert
    verify(elemType).isFinal();
    assertNull(actualUnwrappableIndexedListSerializer.getDelegatee());
    assertFalse(actualUnwrappableIndexedListSerializer.isUnwrappingSerializer());
    assertSame(elemType, actualUnwrappableIndexedListSerializer.getContentType());
    assertSame(valueSerializer, actualUnwrappableIndexedListSerializer.getContentSerializer());
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#UnwrappableIndexedListSerializer(JavaType,
   * boolean, TypeSerializer, JsonSerializer)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link JavaType} {@link JavaType#isFinal()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UnwrappableIndexedListSerializer#UnwrappableIndexedListSerializer(JavaType, boolean,
   * TypeSerializer, JsonSerializer)}
   */
  @Test
  @DisplayName(
      "Test new UnwrappableIndexedListSerializer(JavaType, boolean, TypeSerializer, JsonSerializer); given 'true'; when JavaType isFinal() return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnwrappableIndexedListSerializer.<init>(JavaType, boolean, TypeSerializer, JsonSerializer)"
  })
  void testNewUnwrappableIndexedListSerializer_givenTrue_whenJavaTypeIsFinalReturnTrue() {
    // Arrange
    JavaType elemType = mock(JavaType.class);
    when(elemType.isFinal()).thenReturn(true);
    JsonSerializer<Object> valueSerializer = mock(JsonSerializer.class);

    // Act
    UnwrappableIndexedListSerializer actualUnwrappableIndexedListSerializer =
        new UnwrappableIndexedListSerializer(
            elemType, false, mock(TypeSerializer.class), valueSerializer);

    // Assert
    verify(elemType).isFinal();
    assertNull(actualUnwrappableIndexedListSerializer.getDelegatee());
    assertFalse(actualUnwrappableIndexedListSerializer.isUnwrappingSerializer());
    assertSame(elemType, actualUnwrappableIndexedListSerializer.getContentType());
    assertSame(valueSerializer, actualUnwrappableIndexedListSerializer.getContentSerializer());
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#UnwrappableIndexedListSerializer(JavaType,
   * boolean, TypeSerializer, JsonSerializer)}.
   *
   * <ul>
   *   <li>Then ContentType return {@link PlaceholderForType}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UnwrappableIndexedListSerializer#UnwrappableIndexedListSerializer(JavaType, boolean,
   * TypeSerializer, JsonSerializer)}
   */
  @Test
  @DisplayName(
      "Test new UnwrappableIndexedListSerializer(JavaType, boolean, TypeSerializer, JsonSerializer); then ContentType return PlaceholderForType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnwrappableIndexedListSerializer.<init>(JavaType, boolean, TypeSerializer, JsonSerializer)"
  })
  void testNewUnwrappableIndexedListSerializer_thenContentTypeReturnPlaceholderForType() {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);

    // Act and Assert
    JavaType contentType =
        new UnwrappableIndexedListSerializer(
                elemType, false, mock(TypeSerializer.class), mock(JsonSerializer.class))
            .getContentType();
    assertTrue(contentType instanceof PlaceholderForType);
    assertSame(elemType, contentType);
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#UnwrappableIndexedListSerializer(JavaType,
   * boolean, TypeSerializer, JsonSerializer)}.
   *
   * <ul>
   *   <li>When {@link JavaType}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UnwrappableIndexedListSerializer#UnwrappableIndexedListSerializer(JavaType, boolean,
   * TypeSerializer, JsonSerializer)}
   */
  @Test
  @DisplayName(
      "Test new UnwrappableIndexedListSerializer(JavaType, boolean, TypeSerializer, JsonSerializer); when JavaType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnwrappableIndexedListSerializer.<init>(JavaType, boolean, TypeSerializer, JsonSerializer)"
  })
  void testNewUnwrappableIndexedListSerializer_whenJavaType() {
    // Arrange
    JavaType elemType = mock(JavaType.class);
    JsonSerializer<Object> valueSerializer = mock(JsonSerializer.class);

    // Act
    UnwrappableIndexedListSerializer actualUnwrappableIndexedListSerializer =
        new UnwrappableIndexedListSerializer(
            elemType, true, mock(TypeSerializer.class), valueSerializer);

    // Assert
    assertNull(actualUnwrappableIndexedListSerializer.getDelegatee());
    assertFalse(actualUnwrappableIndexedListSerializer.isUnwrappingSerializer());
    assertSame(elemType, actualUnwrappableIndexedListSerializer.getContentType());
    assertSame(valueSerializer, actualUnwrappableIndexedListSerializer.getContentSerializer());
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#UnwrappableIndexedListSerializer(JavaType,
   * boolean, TypeSerializer, JsonSerializer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ContentType is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UnwrappableIndexedListSerializer#UnwrappableIndexedListSerializer(JavaType, boolean,
   * TypeSerializer, JsonSerializer)}
   */
  @Test
  @DisplayName(
      "Test new UnwrappableIndexedListSerializer(JavaType, boolean, TypeSerializer, JsonSerializer); when 'null'; then return ContentType is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnwrappableIndexedListSerializer.<init>(JavaType, boolean, TypeSerializer, JsonSerializer)"
  })
  void testNewUnwrappableIndexedListSerializer_whenNull_thenReturnContentTypeIsNull() {
    // Arrange
    JsonSerializer<Object> valueSerializer = mock(JsonSerializer.class);

    // Act
    UnwrappableIndexedListSerializer actualUnwrappableIndexedListSerializer =
        new UnwrappableIndexedListSerializer(
            null, false, mock(TypeSerializer.class), valueSerializer);

    // Assert
    assertNull(actualUnwrappableIndexedListSerializer.getContentType());
    assertNull(actualUnwrappableIndexedListSerializer.getDelegatee());
    assertFalse(actualUnwrappableIndexedListSerializer.isUnwrappingSerializer());
    assertSame(valueSerializer, actualUnwrappableIndexedListSerializer.getContentSerializer());
  }
}
