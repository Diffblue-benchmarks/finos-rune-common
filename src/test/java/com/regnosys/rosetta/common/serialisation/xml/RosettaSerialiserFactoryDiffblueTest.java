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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.util.ArrayIterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RosettaSerialiserFactoryDiffblueTest {
  /**
   * Test {@link RosettaSerialiserFactory#RosettaSerialiserFactory(SerializerFactoryConfig)}.
   *
   * <ul>
   *   <li>Then FactoryConfig serializers return {@link ArrayIterator}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaSerialiserFactory#RosettaSerialiserFactory(SerializerFactoryConfig)}
   */
  @Test
  @DisplayName(
      "Test new RosettaSerialiserFactory(SerializerFactoryConfig); then FactoryConfig serializers return ArrayIterator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RosettaSerialiserFactory.<init>(SerializerFactoryConfig)"})
  void testNewRosettaSerialiserFactory_thenFactoryConfigSerializersReturnArrayIterator() {
    // Arrange, Act and Assert
    SerializerFactoryConfig factoryConfig = new RosettaSerialiserFactory(null).getFactoryConfig();
    Iterable<Serializers> serializersResult = factoryConfig.serializers();
    assertTrue(serializersResult instanceof ArrayIterator);
    assertFalse(factoryConfig.hasKeySerializers());
    assertFalse(factoryConfig.hasSerializerModifiers());
    assertFalse(factoryConfig.hasSerializers());
    assertFalse(((ArrayIterator<Serializers>) serializersResult).hasNext());
  }

  /**
   * Test {@link RosettaSerialiserFactory#RosettaSerialiserFactory(SerializerFactoryConfig)}.
   *
   * <ul>
   *   <li>Then return FactoryConfig is {@link SerializerFactoryConfig#SerializerFactoryConfig()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaSerialiserFactory#RosettaSerialiserFactory(SerializerFactoryConfig)}
   */
  @Test
  @DisplayName(
      "Test new RosettaSerialiserFactory(SerializerFactoryConfig); then return FactoryConfig is SerializerFactoryConfig()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RosettaSerialiserFactory.<init>(SerializerFactoryConfig)"})
  void testNewRosettaSerialiserFactory_thenReturnFactoryConfigIsSerializerFactoryConfig() {
    // Arrange
    SerializerFactoryConfig config = new SerializerFactoryConfig();

    // Act and Assert
    assertSame(config, new RosettaSerialiserFactory(config).getFactoryConfig());
  }

  /**
   * Test {@link RosettaSerialiserFactory#withConfig(SerializerFactoryConfig)}.
   *
   * <ul>
   *   <li>Then return FactoryConfig is {@link SerializerFactoryConfig#SerializerFactoryConfig()}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaSerialiserFactory#withConfig(SerializerFactoryConfig)}
   */
  @Test
  @DisplayName(
      "Test withConfig(SerializerFactoryConfig); then return FactoryConfig is SerializerFactoryConfig()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SerializerFactory RosettaSerialiserFactory.withConfig(SerializerFactoryConfig)"
  })
  void testWithConfig_thenReturnFactoryConfigIsSerializerFactoryConfig() {
    // Arrange
    SerializerFactoryConfig config = new SerializerFactoryConfig();

    // Act
    SerializerFactory actualWithConfigResult = RosettaSerialiserFactory.INSTANCE.withConfig(config);

    // Assert
    assertTrue(actualWithConfigResult instanceof RosettaSerialiserFactory);
    assertSame(config, ((RosettaSerialiserFactory) actualWithConfigResult).getFactoryConfig());
  }

  /**
   * Test {@link RosettaSerialiserFactory#withConfig(SerializerFactoryConfig)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then FactoryConfig serializers return {@link ArrayIterator}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaSerialiserFactory#withConfig(SerializerFactoryConfig)}
   */
  @Test
  @DisplayName(
      "Test withConfig(SerializerFactoryConfig); when 'null'; then FactoryConfig serializers return ArrayIterator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SerializerFactory RosettaSerialiserFactory.withConfig(SerializerFactoryConfig)"
  })
  void testWithConfig_whenNull_thenFactoryConfigSerializersReturnArrayIterator() {
    // Arrange and Act
    SerializerFactory actualWithConfigResult = RosettaSerialiserFactory.INSTANCE.withConfig(null);

    // Assert
    SerializerFactoryConfig factoryConfig =
        ((RosettaSerialiserFactory) actualWithConfigResult).getFactoryConfig();
    Iterable<Serializers> serializersResult = factoryConfig.serializers();
    assertTrue(serializersResult instanceof ArrayIterator);
    assertTrue(actualWithConfigResult instanceof RosettaSerialiserFactory);
    assertFalse(factoryConfig.hasKeySerializers());
    assertFalse(factoryConfig.hasSerializerModifiers());
    assertFalse(factoryConfig.hasSerializers());
    assertFalse(((ArrayIterator<Serializers>) serializersResult).hasNext());
  }

  /**
   * Test {@link RosettaSerialiserFactory#buildIndexedListSerializer(JavaType, boolean,
   * TypeSerializer, JsonSerializer)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link JavaType} {@link JavaType#isFinal()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaSerialiserFactory#buildIndexedListSerializer(JavaType,
   * boolean, TypeSerializer, JsonSerializer)}
   */
  @Test
  @DisplayName(
      "Test buildIndexedListSerializer(JavaType, boolean, TypeSerializer, JsonSerializer); given 'false'; when JavaType isFinal() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ContainerSerializer RosettaSerialiserFactory.buildIndexedListSerializer(JavaType, boolean, TypeSerializer, JsonSerializer)"
  })
  void testBuildIndexedListSerializer_givenFalse_whenJavaTypeIsFinalReturnFalse() {
    // Arrange
    JavaType elemType = mock(JavaType.class);
    when(elemType.isFinal()).thenReturn(false);
    JsonSerializer<Object> valueSerializer = mock(JsonSerializer.class);

    // Act
    ContainerSerializer<?> actualBuildIndexedListSerializerResult =
        RosettaSerialiserFactory.INSTANCE.buildIndexedListSerializer(
            elemType, false, mock(TypeSerializer.class), valueSerializer);

    // Assert
    verify(elemType).isFinal();
    assertTrue(actualBuildIndexedListSerializerResult instanceof UnwrappableIndexedListSerializer);
    assertNull(actualBuildIndexedListSerializerResult.getDelegatee());
    assertFalse(actualBuildIndexedListSerializerResult.isUnwrappingSerializer());
    assertSame(elemType, actualBuildIndexedListSerializerResult.getContentType());
    assertSame(valueSerializer, actualBuildIndexedListSerializerResult.getContentSerializer());
  }

  /**
   * Test {@link RosettaSerialiserFactory#buildIndexedListSerializer(JavaType, boolean,
   * TypeSerializer, JsonSerializer)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link JavaType} {@link JavaType#isFinal()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaSerialiserFactory#buildIndexedListSerializer(JavaType,
   * boolean, TypeSerializer, JsonSerializer)}
   */
  @Test
  @DisplayName(
      "Test buildIndexedListSerializer(JavaType, boolean, TypeSerializer, JsonSerializer); given 'true'; when JavaType isFinal() return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ContainerSerializer RosettaSerialiserFactory.buildIndexedListSerializer(JavaType, boolean, TypeSerializer, JsonSerializer)"
  })
  void testBuildIndexedListSerializer_givenTrue_whenJavaTypeIsFinalReturnTrue() {
    // Arrange
    JavaType elemType = mock(JavaType.class);
    when(elemType.isFinal()).thenReturn(true);
    JsonSerializer<Object> valueSerializer = mock(JsonSerializer.class);

    // Act
    ContainerSerializer<?> actualBuildIndexedListSerializerResult =
        RosettaSerialiserFactory.INSTANCE.buildIndexedListSerializer(
            elemType, false, mock(TypeSerializer.class), valueSerializer);

    // Assert
    verify(elemType).isFinal();
    assertTrue(actualBuildIndexedListSerializerResult instanceof UnwrappableIndexedListSerializer);
    assertNull(actualBuildIndexedListSerializerResult.getDelegatee());
    assertFalse(actualBuildIndexedListSerializerResult.isUnwrappingSerializer());
    assertSame(elemType, actualBuildIndexedListSerializerResult.getContentType());
    assertSame(valueSerializer, actualBuildIndexedListSerializerResult.getContentSerializer());
  }

  /**
   * Test {@link RosettaSerialiserFactory#buildIndexedListSerializer(JavaType, boolean,
   * TypeSerializer, JsonSerializer)}.
   *
   * <ul>
   *   <li>Then ContentType return {@link PlaceholderForType}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaSerialiserFactory#buildIndexedListSerializer(JavaType,
   * boolean, TypeSerializer, JsonSerializer)}
   */
  @Test
  @DisplayName(
      "Test buildIndexedListSerializer(JavaType, boolean, TypeSerializer, JsonSerializer); then ContentType return PlaceholderForType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ContainerSerializer RosettaSerialiserFactory.buildIndexedListSerializer(JavaType, boolean, TypeSerializer, JsonSerializer)"
  })
  void testBuildIndexedListSerializer_thenContentTypeReturnPlaceholderForType() {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);

    // Act
    ContainerSerializer<?> actualBuildIndexedListSerializerResult =
        RosettaSerialiserFactory.INSTANCE.buildIndexedListSerializer(
            elemType, false, mock(TypeSerializer.class), mock(JsonSerializer.class));

    // Assert
    JavaType contentType = actualBuildIndexedListSerializerResult.getContentType();
    assertTrue(contentType instanceof PlaceholderForType);
    assertTrue(actualBuildIndexedListSerializerResult instanceof UnwrappableIndexedListSerializer);
    assertSame(elemType, contentType);
  }

  /**
   * Test {@link RosettaSerialiserFactory#buildIndexedListSerializer(JavaType, boolean,
   * TypeSerializer, JsonSerializer)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaSerialiserFactory#buildIndexedListSerializer(JavaType,
   * boolean, TypeSerializer, JsonSerializer)}
   */
  @Test
  @DisplayName(
      "Test buildIndexedListSerializer(JavaType, boolean, TypeSerializer, JsonSerializer); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ContainerSerializer RosettaSerialiserFactory.buildIndexedListSerializer(JavaType, boolean, TypeSerializer, JsonSerializer)"
  })
  void testBuildIndexedListSerializer_thenThrowIllegalStateException() {
    // Arrange
    JavaType elemType = mock(JavaType.class);
    when(elemType.isFinal()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            RosettaSerialiserFactory.INSTANCE.buildIndexedListSerializer(
                elemType, false, mock(TypeSerializer.class), mock(JsonSerializer.class)));
    verify(elemType).isFinal();
  }

  /**
   * Test {@link RosettaSerialiserFactory#buildIndexedListSerializer(JavaType, boolean,
   * TypeSerializer, JsonSerializer)}.
   *
   * <ul>
   *   <li>When {@link JavaType}.
   *   <li>Then return ContentType is {@link JavaType}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaSerialiserFactory#buildIndexedListSerializer(JavaType,
   * boolean, TypeSerializer, JsonSerializer)}
   */
  @Test
  @DisplayName(
      "Test buildIndexedListSerializer(JavaType, boolean, TypeSerializer, JsonSerializer); when JavaType; then return ContentType is JavaType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ContainerSerializer RosettaSerialiserFactory.buildIndexedListSerializer(JavaType, boolean, TypeSerializer, JsonSerializer)"
  })
  void testBuildIndexedListSerializer_whenJavaType_thenReturnContentTypeIsJavaType() {
    // Arrange
    JavaType elemType = mock(JavaType.class);
    JsonSerializer<Object> valueSerializer = mock(JsonSerializer.class);

    // Act
    ContainerSerializer<?> actualBuildIndexedListSerializerResult =
        RosettaSerialiserFactory.INSTANCE.buildIndexedListSerializer(
            elemType, true, mock(TypeSerializer.class), valueSerializer);

    // Assert
    assertTrue(actualBuildIndexedListSerializerResult instanceof UnwrappableIndexedListSerializer);
    assertNull(actualBuildIndexedListSerializerResult.getDelegatee());
    assertFalse(actualBuildIndexedListSerializerResult.isUnwrappingSerializer());
    assertSame(elemType, actualBuildIndexedListSerializerResult.getContentType());
    assertSame(valueSerializer, actualBuildIndexedListSerializerResult.getContentSerializer());
  }

  /**
   * Test {@link RosettaSerialiserFactory#buildIndexedListSerializer(JavaType, boolean,
   * TypeSerializer, JsonSerializer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ContentType is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaSerialiserFactory#buildIndexedListSerializer(JavaType,
   * boolean, TypeSerializer, JsonSerializer)}
   */
  @Test
  @DisplayName(
      "Test buildIndexedListSerializer(JavaType, boolean, TypeSerializer, JsonSerializer); when 'null'; then return ContentType is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ContainerSerializer RosettaSerialiserFactory.buildIndexedListSerializer(JavaType, boolean, TypeSerializer, JsonSerializer)"
  })
  void testBuildIndexedListSerializer_whenNull_thenReturnContentTypeIsNull() {
    // Arrange
    JsonSerializer<Object> valueSerializer = mock(JsonSerializer.class);

    // Act
    ContainerSerializer<?> actualBuildIndexedListSerializerResult =
        RosettaSerialiserFactory.INSTANCE.buildIndexedListSerializer(
            null, false, mock(TypeSerializer.class), valueSerializer);

    // Assert
    assertTrue(actualBuildIndexedListSerializerResult instanceof UnwrappableIndexedListSerializer);
    assertNull(actualBuildIndexedListSerializerResult.getContentType());
    assertNull(actualBuildIndexedListSerializerResult.getDelegatee());
    assertFalse(actualBuildIndexedListSerializerResult.isUnwrappingSerializer());
    assertSame(valueSerializer, actualBuildIndexedListSerializerResult.getContentSerializer());
  }
}
