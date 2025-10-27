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
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.impl.AttributePropertyWriter;
import org.junit.Test;
import org.mockito.Mockito;

public class ReferenceFilterDiffblueTest {
  /**
   * Method under test:
   * {@link ReferenceFilter#serializeAsField(Object, JsonGenerator, SerializerProvider, BeanPropertyWriter)}
   */
  @Test
  public void testSerializeAsField() throws Exception {
    // Arrange
    ReferenceFilter referenceFilter = new ReferenceFilter();
    JsonGeneratorDelegate jgen = new JsonGeneratorDelegate(new JsonGeneratorDelegate(mock(JsonGenerator.class)), true);

    DefaultSerializerProvider.Impl provider = new DefaultSerializerProvider.Impl();
    AttributePropertyWriter writer = mock(AttributePropertyWriter.class);
    doNothing().when(writer)
        .serializeAsField(Mockito.<Object>any(), Mockito.<JsonGenerator>any(), Mockito.<SerializerProvider>any());
    when(writer.getName()).thenReturn("Name");

    // Act
    referenceFilter.serializeAsField("Bean", jgen, provider, writer);

    // Assert that nothing has changed
    verify(writer).getName();
    verify(writer).serializeAsField(isA(Object.class), isA(JsonGenerator.class), isA(SerializerProvider.class));
  }
}
