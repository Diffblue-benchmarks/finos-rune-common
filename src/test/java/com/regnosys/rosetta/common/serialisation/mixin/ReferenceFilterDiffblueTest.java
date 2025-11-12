package com.regnosys.rosetta.common.serialisation.mixin;

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

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl;
import com.fasterxml.jackson.databind.ser.impl.AttributePropertyWriter;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.ReferenceWithMetaPrice;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.ReferenceWithMetaPrice.ReferenceWithMetaPriceBuilderImpl;
import com.rosetta.model.lib.meta.Reference;
import com.rosetta.model.lib.meta.Reference.ReferenceBuilderImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ReferenceFilterDiffblueTest {
  /**
   * Test {@link ReferenceFilter#serializeAsField(Object, JsonGenerator, SerializerProvider,
   * BeanPropertyWriter)} with {@code bean}, {@code jgen}, {@code provider}, {@code writer}.
   *
   * <p>Method under test: {@link ReferenceFilter#serializeAsField(Object, JsonGenerator,
   * SerializerProvider, BeanPropertyWriter)}
   */
  @Test
  @DisplayName(
      "Test serializeAsField(Object, JsonGenerator, SerializerProvider, BeanPropertyWriter) with 'bean', 'jgen', 'provider', 'writer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReferenceFilter.serializeAsField(Object, JsonGenerator, SerializerProvider, BeanPropertyWriter)"
  })
  void testSerializeAsFieldWithBeanJgenProviderWriter() throws Exception {
    // Arrange
    ReferenceFilter referenceFilter = new ReferenceFilter();
    JsonGeneratorDelegate d = new JsonGeneratorDelegate(mock(JsonGenerator.class));
    JsonGeneratorDelegate jgen = new JsonGeneratorDelegate(d, true);
    Impl provider = new Impl();

    AttributePropertyWriter writer = mock(AttributePropertyWriter.class);
    doNothing()
        .when(writer)
        .serializeAsField(
            Mockito.<Object>any(), Mockito.<JsonGenerator>any(), Mockito.<SerializerProvider>any());
    when(writer.getName()).thenReturn("Name");

    // Act
    referenceFilter.serializeAsField(BeanPropertyWriter.MARKER_FOR_EMPTY, jgen, provider, writer);

    // Assert
    verify(writer).getName();
    verify(writer)
        .serializeAsField(
            isA(Object.class), isA(JsonGenerator.class), isA(SerializerProvider.class));
  }

  /**
   * Test {@link ReferenceFilter#serializeAsField(Object, JsonGenerator, SerializerProvider,
   * BeanPropertyWriter)} with {@code bean}, {@code jgen}, {@code provider}, {@code writer}.
   *
   * <p>Method under test: {@link ReferenceFilter#serializeAsField(Object, JsonGenerator,
   * SerializerProvider, BeanPropertyWriter)}
   */
  @Test
  @DisplayName(
      "Test serializeAsField(Object, JsonGenerator, SerializerProvider, BeanPropertyWriter) with 'bean', 'jgen', 'provider', 'writer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReferenceFilter.serializeAsField(Object, JsonGenerator, SerializerProvider, BeanPropertyWriter)"
  })
  void testSerializeAsFieldWithBeanJgenProviderWriter2() throws Exception {
    // Arrange
    ReferenceFilter referenceFilter = new ReferenceFilter();
    ReferenceWithMetaPriceBuilderImpl referenceWithMetaPriceBuilderImpl =
        new ReferenceWithMetaPriceBuilderImpl();
    JsonGeneratorDelegate d = new JsonGeneratorDelegate(mock(JsonGenerator.class));
    JsonGeneratorDelegate jgen = new JsonGeneratorDelegate(d, true);
    Impl provider = new Impl();

    AttributePropertyWriter writer = mock(AttributePropertyWriter.class);
    doNothing()
        .when(writer)
        .serializeAsField(
            Mockito.<Object>any(), Mockito.<JsonGenerator>any(), Mockito.<SerializerProvider>any());
    when(writer.getName()).thenReturn("value");

    // Act
    referenceFilter.serializeAsField(referenceWithMetaPriceBuilderImpl, jgen, provider, writer);

    // Assert
    verify(writer).getName();
    verify(writer)
        .serializeAsField(
            isA(Object.class), isA(JsonGenerator.class), isA(SerializerProvider.class));
  }

  /**
   * Test {@link ReferenceFilter#serializeAsField(Object, JsonGenerator, SerializerProvider,
   * BeanPropertyWriter)} with {@code bean}, {@code jgen}, {@code provider}, {@code writer}.
   *
   * <ul>
   *   <li>Given {@code Bean}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceFilter#serializeAsField(Object, JsonGenerator,
   * SerializerProvider, BeanPropertyWriter)}
   */
  @Test
  @DisplayName(
      "Test serializeAsField(Object, JsonGenerator, SerializerProvider, BeanPropertyWriter) with 'bean', 'jgen', 'provider', 'writer'; given 'Bean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReferenceFilter.serializeAsField(Object, JsonGenerator, SerializerProvider, BeanPropertyWriter)"
  })
  void testSerializeAsFieldWithBeanJgenProviderWriter_givenBean() throws Exception {
    // Arrange
    ReferenceFilter referenceFilter = new ReferenceFilter();

    ReferenceBuilderImpl reference = Reference.builder();
    reference.setReference("Bean");

    ReferenceWithMetaPriceBuilderImpl referenceWithMetaPriceBuilderImpl =
        new ReferenceWithMetaPriceBuilderImpl();
    referenceWithMetaPriceBuilderImpl.setGlobalReference("Bean");
    referenceWithMetaPriceBuilderImpl.setReference(reference);
    JsonGeneratorDelegate d = new JsonGeneratorDelegate(mock(JsonGenerator.class));
    JsonGeneratorDelegate jgen = new JsonGeneratorDelegate(d, true);
    Impl provider = new Impl();

    AttributePropertyWriter writer = mock(AttributePropertyWriter.class);
    when(writer.getName()).thenReturn("value");

    // Act
    referenceFilter.serializeAsField(referenceWithMetaPriceBuilderImpl, jgen, provider, writer);

    // Assert
    verify(writer).getName();
  }

  /**
   * Test {@link ReferenceFilter#serializeAsField(Object, JsonGenerator, SerializerProvider,
   * BeanPropertyWriter)} with {@code bean}, {@code jgen}, {@code provider}, {@code writer}.
   *
   * <ul>
   *   <li>Given builder.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceFilter#serializeAsField(Object, JsonGenerator,
   * SerializerProvider, BeanPropertyWriter)}
   */
  @Test
  @DisplayName(
      "Test serializeAsField(Object, JsonGenerator, SerializerProvider, BeanPropertyWriter) with 'bean', 'jgen', 'provider', 'writer'; given builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReferenceFilter.serializeAsField(Object, JsonGenerator, SerializerProvider, BeanPropertyWriter)"
  })
  void testSerializeAsFieldWithBeanJgenProviderWriter_givenBuilder() throws Exception {
    // Arrange
    ReferenceFilter referenceFilter = new ReferenceFilter();

    ReferenceWithMetaPriceBuilderImpl referenceWithMetaPriceBuilderImpl =
        new ReferenceWithMetaPriceBuilderImpl();
    referenceWithMetaPriceBuilderImpl.setReference(Reference.builder());
    JsonGeneratorDelegate d = new JsonGeneratorDelegate(mock(JsonGenerator.class));
    JsonGeneratorDelegate jgen = new JsonGeneratorDelegate(d, true);
    Impl provider = new Impl();

    AttributePropertyWriter writer = mock(AttributePropertyWriter.class);
    doNothing()
        .when(writer)
        .serializeAsField(
            Mockito.<Object>any(), Mockito.<JsonGenerator>any(), Mockito.<SerializerProvider>any());
    when(writer.getName()).thenReturn("value");

    // Act
    referenceFilter.serializeAsField(referenceWithMetaPriceBuilderImpl, jgen, provider, writer);

    // Assert
    verify(writer).getName();
    verify(writer)
        .serializeAsField(
            isA(Object.class), isA(JsonGenerator.class), isA(SerializerProvider.class));
  }

  /**
   * Test {@link ReferenceFilter#serializeAsField(Object, JsonGenerator, SerializerProvider,
   * BeanPropertyWriter)} with {@code bean}, {@code jgen}, {@code provider}, {@code writer}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceFilter#serializeAsField(Object, JsonGenerator,
   * SerializerProvider, BeanPropertyWriter)}
   */
  @Test
  @DisplayName(
      "Test serializeAsField(Object, JsonGenerator, SerializerProvider, BeanPropertyWriter) with 'bean', 'jgen', 'provider', 'writer'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReferenceFilter.serializeAsField(Object, JsonGenerator, SerializerProvider, BeanPropertyWriter)"
  })
  void testSerializeAsFieldWithBeanJgenProviderWriter_givenNull() throws Exception {
    // Arrange
    ReferenceFilter referenceFilter = new ReferenceFilter();

    ReferenceBuilderImpl reference = Reference.builder();
    reference.setReference("Bean");

    ReferenceWithMetaPriceBuilderImpl referenceWithMetaPriceBuilderImpl =
        new ReferenceWithMetaPriceBuilderImpl();
    referenceWithMetaPriceBuilderImpl.setGlobalReference(null);
    referenceWithMetaPriceBuilderImpl.setReference(reference);
    JsonGeneratorDelegate d = new JsonGeneratorDelegate(mock(JsonGenerator.class));
    JsonGeneratorDelegate jgen = new JsonGeneratorDelegate(d, true);
    Impl provider = new Impl();

    AttributePropertyWriter writer = mock(AttributePropertyWriter.class);
    when(writer.getName()).thenReturn("value");

    // Act
    referenceFilter.serializeAsField(referenceWithMetaPriceBuilderImpl, jgen, provider, writer);

    // Assert
    verify(writer).getName();
  }

  /**
   * Test {@link ReferenceFilter#serializeAsField(Object, JsonGenerator, SerializerProvider,
   * BeanPropertyWriter)} with {@code bean}, {@code jgen}, {@code provider}, {@code writer}.
   *
   * <ul>
   *   <li>Then calls {@link AttributePropertyWriter#serializeAsField(Object, JsonGenerator,
   *       SerializerProvider)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceFilter#serializeAsField(Object, JsonGenerator,
   * SerializerProvider, BeanPropertyWriter)}
   */
  @Test
  @DisplayName(
      "Test serializeAsField(Object, JsonGenerator, SerializerProvider, BeanPropertyWriter) with 'bean', 'jgen', 'provider', 'writer'; then calls serializeAsField(Object, JsonGenerator, SerializerProvider)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReferenceFilter.serializeAsField(Object, JsonGenerator, SerializerProvider, BeanPropertyWriter)"
  })
  void testSerializeAsFieldWithBeanJgenProviderWriter_thenCallsSerializeAsField() throws Exception {
    // Arrange
    ReferenceFilter referenceFilter = new ReferenceFilter();
    JsonGeneratorDelegate d = new JsonGeneratorDelegate(mock(JsonGenerator.class));
    JsonGeneratorDelegate jgen = new JsonGeneratorDelegate(d, true);
    Impl provider = new Impl();

    AttributePropertyWriter writer = mock(AttributePropertyWriter.class);
    doNothing()
        .when(writer)
        .serializeAsField(
            Mockito.<Object>any(), Mockito.<JsonGenerator>any(), Mockito.<SerializerProvider>any());
    when(writer.getName()).thenReturn("value");

    // Act
    referenceFilter.serializeAsField(BeanPropertyWriter.MARKER_FOR_EMPTY, jgen, provider, writer);

    // Assert
    verify(writer).getName();
    verify(writer)
        .serializeAsField(
            isA(Object.class), isA(JsonGenerator.class), isA(SerializerProvider.class));
  }
}
