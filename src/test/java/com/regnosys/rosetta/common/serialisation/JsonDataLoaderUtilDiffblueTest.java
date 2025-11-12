package com.regnosys.rosetta.common.serialisation;

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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Value;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTypeResolverBuilder;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;
import com.fasterxml.jackson.databind.jsontype.impl.MinimalClassNameIdResolver;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.regnosys.rosetta.common.postprocess.qualify.QualificationReport;
import com.regnosys.rosetta.common.projection.ProjectionDataItemExpectation;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.UncheckedIOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.management.loading.MLet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JsonDataLoaderUtilDiffblueTest {
  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)} with {@code type}, {@code
   * rosettaObjectMapper}, {@code json}.
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  @DisplayName(
      "Test readType(Class, ObjectMapper, String) with 'type', 'rosettaObjectMapper', 'json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, String)"})
  void testReadTypeWithTypeRosettaObjectMapperJson() {
    // Arrange
    Class<Object> type = Object.class;

    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT));
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper rosettaObjectMapper = builderResult.findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> JsonDataLoaderUtil.readType(type, rosettaObjectMapper, "["));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)} with {@code type}, {@code
   * rosettaObjectMapper}, {@code json}.
   *
   * <ul>
   *   <li>Given {@code List}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  @DisplayName(
      "Test readType(Class, ObjectMapper, String) with 'type', 'rosettaObjectMapper', 'json'; given 'java.util.List'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, String)"})
  void testReadTypeWithTypeRosettaObjectMapperJson_givenJavaUtilList() {
    // Arrange
    Class<Object> type = Object.class;

    Builder builderResult = JsonMapper.builder();
    Class<List> target = List.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper rosettaObjectMapper = builderResult.findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> JsonDataLoaderUtil.readType(type, rosettaObjectMapper, "["));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)} with {@code type}, {@code
   * rosettaObjectMapper}, {@code json}.
   *
   * <ul>
   *   <li>Given {@link StdTypeResolverBuilder#StdTypeResolverBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  @DisplayName(
      "Test readType(Class, ObjectMapper, String) with 'type', 'rosettaObjectMapper', 'json'; given StdTypeResolverBuilder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, String)"})
  void testReadTypeWithTypeRosettaObjectMapperJson_givenStdTypeResolverBuilder() {
    // Arrange
    Class<Object> type = Object.class;

    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(new StdTypeResolverBuilder());
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper rosettaObjectMapper = builderResult.findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> JsonDataLoaderUtil.readType(type, rosettaObjectMapper, "["));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)} with {@code type}, {@code
   * rosettaObjectMapper}, {@code json}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  @DisplayName(
      "Test readType(Class, ObjectMapper, String) with 'type', 'rosettaObjectMapper', 'json'; when '42'; then return intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, String)"})
  void testReadTypeWithTypeRosettaObjectMapperJson_when42_thenReturnIntValueIsFortyTwo() {
    // Arrange
    Class<Object> type = Object.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act
    Object actualReadTypeResult = JsonDataLoaderUtil.readType(type, rosettaObjectMapper, "42");

    // Assert
    assertEquals(42, ((Integer) actualReadTypeResult).intValue());
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)} with {@code type}, {@code
   * rosettaObjectMapper}, {@code json}.
   *
   * <ul>
   *   <li>When builder addMixIn {@link Object} and {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  @DisplayName(
      "Test readType(Class, ObjectMapper, String) with 'type', 'rosettaObjectMapper', 'json'; when builder addMixIn Object and Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, String)"})
  void testReadTypeWithTypeRosettaObjectMapperJson_whenBuilderAddMixInObjectAndObject() {
    // Arrange
    Class<Object> type = Object.class;

    Builder builderResult = JsonMapper.builder();
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper rosettaObjectMapper = builderResult.findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> JsonDataLoaderUtil.readType(type, rosettaObjectMapper, "["));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)} with {@code type}, {@code
   * rosettaObjectMapper}, {@code json}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  @DisplayName(
      "Test readType(Class, ObjectMapper, String) with 'type', 'rosettaObjectMapper', 'json'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, String)"})
  void testReadTypeWithTypeRosettaObjectMapperJson_whenEmptyString() {
    // Arrange
    Class<Object> type = Object.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> JsonDataLoaderUtil.readType(type, rosettaObjectMapper, ""));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)} with {@code type}, {@code
   * rosettaObjectMapper}, {@code json}.
   *
   * <ul>
   *   <li>When {@code List}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  @DisplayName(
      "Test readType(Class, ObjectMapper, String) with 'type', 'rosettaObjectMapper', 'json'; when 'java.util.List'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, String)"})
  void testReadTypeWithTypeRosettaObjectMapperJson_whenJavaUtilList() {
    // Arrange
    Class<List> type = List.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> JsonDataLoaderUtil.readType(type, rosettaObjectMapper, "Json"));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)} with {@code type}, {@code
   * rosettaObjectMapper}, {@code json}.
   *
   * <ul>
   *   <li>When {@code Json}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  @DisplayName(
      "Test readType(Class, ObjectMapper, String) with 'type', 'rosettaObjectMapper', 'json'; when 'Json'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, String)"})
  void testReadTypeWithTypeRosettaObjectMapperJson_whenJson_thenThrowRuntimeException() {
    // Arrange
    Class<Object> type = Object.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> JsonDataLoaderUtil.readType(type, rosettaObjectMapper, "Json"));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)} with {@code type}, {@code
   * rosettaObjectMapper}, {@code json}.
   *
   * <ul>
   *   <li>When {@code [}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  @DisplayName(
      "Test readType(Class, ObjectMapper, String) with 'type', 'rosettaObjectMapper', 'json'; when '['")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, String)"})
  void testReadTypeWithTypeRosettaObjectMapperJson_whenLeftSquareBracket() {
    // Arrange
    Class<Object> type = Object.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> JsonDataLoaderUtil.readType(type, rosettaObjectMapper, "["));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)} with {@code type}, {@code
   * rosettaObjectMapper}, {@code json}.
   *
   * <ul>
   *   <li>When {@code ]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  @DisplayName(
      "Test readType(Class, ObjectMapper, String) with 'type', 'rosettaObjectMapper', 'json'; when ']'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, String)"})
  void testReadTypeWithTypeRosettaObjectMapperJson_whenRightSquareBracket() {
    // Arrange
    Class<Object> type = Object.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> JsonDataLoaderUtil.readType(type, rosettaObjectMapper, "]"));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, URL)} with {@code type}, {@code
   * rosettaObjectMapper}, {@code url}.
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, URL)}
   */
  @Test
  @DisplayName("Test readType(Class, ObjectMapper, URL) with 'type', 'rosettaObjectMapper', 'url'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, URL)"})
  void testReadTypeWithTypeRosettaObjectMapperUrl() throws MalformedURLException {
    // Arrange
    Class<Object> type = Object.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            JsonDataLoaderUtil.readType(
                type,
                rosettaObjectMapper,
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, URL)} with {@code type}, {@code
   * rosettaObjectMapper}, {@code url}.
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, URL)}
   */
  @Test
  @DisplayName("Test readType(Class, ObjectMapper, URL) with 'type', 'rosettaObjectMapper', 'url'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, URL)"})
  void testReadTypeWithTypeRosettaObjectMapperUrl2() throws MalformedURLException {
    // Arrange
    Class<Object> type = Object.class;
    JsonMapper m = JsonMapper.builder().findAndAddModules().build();
    JsonMapper rosettaObjectMapper = new Builder(m).findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            JsonDataLoaderUtil.readType(
                type,
                rosettaObjectMapper,
                Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL()));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, URL)} with {@code type}, {@code
   * rosettaObjectMapper}, {@code url}.
   *
   * <ul>
   *   <li>Given defaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, URL)}
   */
  @Test
  @DisplayName(
      "Test readType(Class, ObjectMapper, URL) with 'type', 'rosettaObjectMapper', 'url'; given defaultInstance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, URL)"})
  void testReadTypeWithTypeRosettaObjectMapperUrl_givenDefaultInstance()
      throws MalformedURLException {
    // Arrange
    Class<Object> type = Object.class;
    JsonMapper m = JsonMapper.builder().findAndAddModules().build();

    Builder builder = new Builder(m);
    builder.typeFactory(TypeFactory.defaultInstance());
    JsonMapper rosettaObjectMapper = builder.findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            JsonDataLoaderUtil.readType(
                type,
                rosettaObjectMapper,
                Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL()));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, URL)} with {@code type}, {@code
   * rosettaObjectMapper}, {@code url}.
   *
   * <ul>
   *   <li>Given defaultInstance.
   *   <li>When {@code List}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, URL)}
   */
  @Test
  @DisplayName(
      "Test readType(Class, ObjectMapper, URL) with 'type', 'rosettaObjectMapper', 'url'; given defaultInstance; when 'java.util.List'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, URL)"})
  void testReadTypeWithTypeRosettaObjectMapperUrl_givenDefaultInstance_whenJavaUtilList()
      throws MalformedURLException {
    // Arrange
    Class<List> type = List.class;
    JsonMapper m = JsonMapper.builder().findAndAddModules().build();

    Builder builder = new Builder(m);
    builder.typeFactory(TypeFactory.defaultInstance());
    JsonMapper rosettaObjectMapper = builder.findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            JsonDataLoaderUtil.readType(
                type,
                rosettaObjectMapper,
                Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL()));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, URL)} with {@code type}, {@code
   * rosettaObjectMapper}, {@code url}.
   *
   * <ul>
   *   <li>When {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, URL)}
   */
  @Test
  @DisplayName(
      "Test readType(Class, ObjectMapper, URL) with 'type', 'rosettaObjectMapper', 'url'; when 'java.lang.Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, URL)"})
  void testReadTypeWithTypeRosettaObjectMapperUrl_whenJavaLangObject()
      throws MalformedURLException {
    // Arrange
    Class<Object> type = Object.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            JsonDataLoaderUtil.readType(
                type,
                rosettaObjectMapper,
                Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL()));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, URL)} with {@code type}, {@code
   * rosettaObjectMapper}, {@code url}.
   *
   * <ul>
   *   <li>When {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, URL)}
   */
  @Test
  @DisplayName(
      "Test readType(Class, ObjectMapper, URL) with 'type', 'rosettaObjectMapper', 'url'; when 'java.lang.Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, URL)"})
  void testReadTypeWithTypeRosettaObjectMapperUrl_whenJavaLangObject2()
      throws MalformedURLException {
    // Arrange
    Class<Object> type = Object.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            JsonDataLoaderUtil.readType(
                type,
                rosettaObjectMapper,
                Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL()));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, URL)} with {@code type}, {@code
   * rosettaObjectMapper}, {@code url}.
   *
   * <ul>
   *   <li>When {@code List}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, URL)}
   */
  @Test
  @DisplayName(
      "Test readType(Class, ObjectMapper, URL) with 'type', 'rosettaObjectMapper', 'url'; when 'java.util.List'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, URL)"})
  void testReadTypeWithTypeRosettaObjectMapperUrl_whenJavaUtilList() throws MalformedURLException {
    // Arrange
    Class<List> type = List.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            JsonDataLoaderUtil.readType(
                type,
                rosettaObjectMapper,
                Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL()));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)} with {@code type},
   * {@code rosettaObjectMapper}, {@code input}.
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  @DisplayName(
      "Test readTypeList(Class, ObjectMapper, Reader) with 'type', 'rosettaObjectMapper', 'input'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List JsonDataLoaderUtil.readTypeList(Class, ObjectMapper, Reader)"})
  void testReadTypeListWithTypeRosettaObjectMapperInput() {
    // Arrange
    Class<Object> type = Object.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            JsonDataLoaderUtil.readTypeList(
                type, rosettaObjectMapper, new StringReader(" cannot be serialised to list of ")));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)} with {@code type},
   * {@code rosettaObjectMapper}, {@code input}.
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  @DisplayName(
      "Test readTypeList(Class, ObjectMapper, Reader) with 'type', 'rosettaObjectMapper', 'input'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List JsonDataLoaderUtil.readTypeList(Class, ObjectMapper, Reader)"})
  void testReadTypeListWithTypeRosettaObjectMapperInput2() {
    // Arrange
    Class<Object> type = Object.class;

    Builder builderResult = JsonMapper.builder();
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper rosettaObjectMapper = builderResult.findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("42")));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)} with {@code type},
   * {@code rosettaObjectMapper}, {@code input}.
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  @DisplayName(
      "Test readTypeList(Class, ObjectMapper, Reader) with 'type', 'rosettaObjectMapper', 'input'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List JsonDataLoaderUtil.readTypeList(Class, ObjectMapper, Reader)"})
  void testReadTypeListWithTypeRosettaObjectMapperInput3() {
    // Arrange
    Class<Object> type = Object.class;

    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT));
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper rosettaObjectMapper = builderResult.findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("42")));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)} with {@code type},
   * {@code rosettaObjectMapper}, {@code input}.
   *
   * <ul>
   *   <li>Given {@code List}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  @DisplayName(
      "Test readTypeList(Class, ObjectMapper, Reader) with 'type', 'rosettaObjectMapper', 'input'; given 'java.util.List'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List JsonDataLoaderUtil.readTypeList(Class, ObjectMapper, Reader)"})
  void testReadTypeListWithTypeRosettaObjectMapperInput_givenJavaUtilList() {
    // Arrange
    Class<Object> type = Object.class;

    Builder builderResult = JsonMapper.builder();
    Class<List> target = List.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper rosettaObjectMapper = builderResult.findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("42")));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)} with {@code type},
   * {@code rosettaObjectMapper}, {@code input}.
   *
   * <ul>
   *   <li>Given {@link StdTypeResolverBuilder#StdTypeResolverBuilder()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  @DisplayName(
      "Test readTypeList(Class, ObjectMapper, Reader) with 'type', 'rosettaObjectMapper', 'input'; given StdTypeResolverBuilder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List JsonDataLoaderUtil.readTypeList(Class, ObjectMapper, Reader)"})
  void testReadTypeListWithTypeRosettaObjectMapperInput_givenStdTypeResolverBuilder() {
    // Arrange
    Class<Object> type = Object.class;

    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(new StdTypeResolverBuilder());
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper rosettaObjectMapper = builderResult.findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("42")));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)} with {@code type},
   * {@code rosettaObjectMapper}, {@code input}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  @DisplayName(
      "Test readTypeList(Class, ObjectMapper, Reader) with 'type', 'rosettaObjectMapper', 'input'; given 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List JsonDataLoaderUtil.readTypeList(Class, ObjectMapper, Reader)"})
  void testReadTypeListWithTypeRosettaObjectMapperInput_givenTrue() {
    // Arrange
    Class<Object> type = Object.class;

    Builder builderResult = JsonMapper.builder();
    builderResult.defaultLeniency(true);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper rosettaObjectMapper = builderResult.findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("42")));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)} with {@code type},
   * {@code rosettaObjectMapper}, {@code input}.
   *
   * <ul>
   *   <li>When {@code List}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  @DisplayName(
      "Test readTypeList(Class, ObjectMapper, Reader) with 'type', 'rosettaObjectMapper', 'input'; when 'java.util.List'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List JsonDataLoaderUtil.readTypeList(Class, ObjectMapper, Reader)"})
  void testReadTypeListWithTypeRosettaObjectMapperInput_whenJavaUtilList() {
    // Arrange
    Class<List> type = List.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("foo")));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)} with {@code type},
   * {@code rosettaObjectMapper}, {@code input}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  @DisplayName(
      "Test readTypeList(Class, ObjectMapper, Reader) with 'type', 'rosettaObjectMapper', 'input'; when StringReader(String) with '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List JsonDataLoaderUtil.readTypeList(Class, ObjectMapper, Reader)"})
  void testReadTypeListWithTypeRosettaObjectMapperInput_whenStringReaderWith42() {
    // Arrange
    Class<Object> type = Object.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("42")));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)} with {@code type},
   * {@code rosettaObjectMapper}, {@code input}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with empty string.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  @DisplayName(
      "Test readTypeList(Class, ObjectMapper, Reader) with 'type', 'rosettaObjectMapper', 'input'; when StringReader(String) with empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List JsonDataLoaderUtil.readTypeList(Class, ObjectMapper, Reader)"})
  void testReadTypeListWithTypeRosettaObjectMapperInput_whenStringReaderWithEmptyString() {
    // Arrange
    Class<Object> type = Object.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("")));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)} with {@code type},
   * {@code rosettaObjectMapper}, {@code input}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  @DisplayName(
      "Test readTypeList(Class, ObjectMapper, Reader) with 'type', 'rosettaObjectMapper', 'input'; when StringReader(String) with 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List JsonDataLoaderUtil.readTypeList(Class, ObjectMapper, Reader)"})
  void testReadTypeListWithTypeRosettaObjectMapperInput_whenStringReaderWithFoo() {
    // Arrange
    Class<Object> type = Object.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("foo")));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, URL)} with {@code type},
   * {@code rosettaObjectMapper}, {@code url}.
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, URL)}
   */
  @Test
  @DisplayName(
      "Test readTypeList(Class, ObjectMapper, URL) with 'type', 'rosettaObjectMapper', 'url'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List JsonDataLoaderUtil.readTypeList(Class, ObjectMapper, URL)"})
  void testReadTypeListWithTypeRosettaObjectMapperUrl() throws MalformedURLException {
    // Arrange
    Class<Object> type = Object.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            JsonDataLoaderUtil.readTypeList(
                type,
                rosettaObjectMapper,
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, URL)} with {@code type},
   * {@code rosettaObjectMapper}, {@code url}.
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, URL)}
   */
  @Test
  @DisplayName(
      "Test readTypeList(Class, ObjectMapper, URL) with 'type', 'rosettaObjectMapper', 'url'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List JsonDataLoaderUtil.readTypeList(Class, ObjectMapper, URL)"})
  void testReadTypeListWithTypeRosettaObjectMapperUrl2() throws MalformedURLException {
    // Arrange
    Class<Object> type = Object.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            JsonDataLoaderUtil.readTypeList(
                type,
                rosettaObjectMapper,
                Paths.get(System.getProperty("java.io.tmpdir")).toUri().toURL()));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, URL)} with {@code type},
   * {@code rosettaObjectMapper}, {@code url}.
   *
   * <ul>
   *   <li>When {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, URL)}
   */
  @Test
  @DisplayName(
      "Test readTypeList(Class, ObjectMapper, URL) with 'type', 'rosettaObjectMapper', 'url'; when 'java.lang.Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List JsonDataLoaderUtil.readTypeList(Class, ObjectMapper, URL)"})
  void testReadTypeListWithTypeRosettaObjectMapperUrl_whenJavaLangObject()
      throws MalformedURLException {
    // Arrange
    Class<Object> type = Object.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            JsonDataLoaderUtil.readTypeList(
                type,
                rosettaObjectMapper,
                Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL()));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, URL)} with {@code type},
   * {@code rosettaObjectMapper}, {@code url}.
   *
   * <ul>
   *   <li>When {@code List}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, URL)}
   */
  @Test
  @DisplayName(
      "Test readTypeList(Class, ObjectMapper, URL) with 'type', 'rosettaObjectMapper', 'url'; when 'java.util.List'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List JsonDataLoaderUtil.readTypeList(Class, ObjectMapper, URL)"})
  void testReadTypeListWithTypeRosettaObjectMapperUrl_whenJavaUtilList()
      throws MalformedURLException {
    // Arrange
    Class<List> type = List.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            JsonDataLoaderUtil.readTypeList(
                type,
                rosettaObjectMapper,
                Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL()));
  }

  /**
   * Test {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}.
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  @DisplayName("Test fromObject(Object, Class, ObjectMapper)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.fromObject(Object, Class, ObjectMapper)"})
  void testFromObject() {
    // Arrange
    Class<Object> type = Object.class;

    Value settings = mock(Value.class);
    when(settings.getIdVisible()).thenReturn(true);
    when(settings.getInclusionType()).thenReturn(As.PROPERTY);
    when(settings.getRequireTypeIdForSubtypes()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(settings.getDefaultImpl()).thenReturn(forNameResult);
    when(settings.getPropertyName()).thenReturn("Property Name");
    when(settings.getIdType()).thenReturn(Id.CLASS);

    MinimalClassNameIdResolver idRes = mock(MinimalClassNameIdResolver.class);
    when(idRes.idFromValue(Mockito.<Object>any()))
        .thenThrow(new UncheckedIOException(new IOException()));

    StdTypeResolverBuilder typer = new StdTypeResolverBuilder();

    typer.init(settings, idRes);

    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(typer);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper rosettaObjectMapper = builderResult.findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            JsonDataLoaderUtil.fromObject(
                BeanPropertyWriter.MARKER_FOR_EMPTY, type, rosettaObjectMapper));
    verify(settings).getDefaultImpl();
    verify(settings).getIdType();
    verify(settings).getIdVisible();
    verify(settings).getInclusionType();
    verify(settings).getPropertyName();
    verify(settings).getRequireTypeIdForSubtypes();
    verify(idRes).idFromValue(isA(Object.class));
  }

  /**
   * Test {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}.
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  @DisplayName("Test fromObject(Object, Class, ObjectMapper)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.fromObject(Object, Class, ObjectMapper)"})
  void testFromObject2() throws IOException {
    // Arrange
    Class<Object> type = Object.class;

    Value settings = mock(Value.class);
    when(settings.getIdVisible()).thenReturn(true);
    when(settings.getInclusionType()).thenReturn(As.PROPERTY);
    when(settings.getRequireTypeIdForSubtypes()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(settings.getDefaultImpl()).thenReturn(forNameResult);
    when(settings.getPropertyName()).thenReturn("Property Name");
    when(settings.getIdType()).thenReturn(Id.CLASS);

    MinimalClassNameIdResolver idRes = mock(MinimalClassNameIdResolver.class);
    when(idRes.typeFromId(Mockito.<DatabindContext>any(), Mockito.<String>any()))
        .thenReturn(new PlaceholderForType(1));
    when(idRes.idFromValue(Mockito.<Object>any())).thenReturn("42");

    StdTypeResolverBuilder typer = new StdTypeResolverBuilder();

    typer.init(settings, idRes);

    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(typer);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper rosettaObjectMapper = builderResult.findAndAddModules().build();

    // Act
    Object actualFromObjectResult =
        JsonDataLoaderUtil.fromObject(
            BeanPropertyWriter.MARKER_FOR_EMPTY, type, rosettaObjectMapper);

    // Assert
    verify(settings).getDefaultImpl();
    verify(settings).getIdType();
    verify(settings).getIdVisible();
    verify(settings).getInclusionType();
    verify(settings).getPropertyName();
    verify(settings).getRequireTypeIdForSubtypes();
    verify(idRes).typeFromId(isA(DatabindContext.class), eq("42"));
    verify(idRes).idFromValue(isA(Object.class));
    assertEquals("NON_EMPTY", actualFromObjectResult);
  }

  /**
   * Test {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}.
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  @DisplayName("Test fromObject(Object, Class, ObjectMapper)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.fromObject(Object, Class, ObjectMapper)"})
  void testFromObject3() throws IOException {
    // Arrange
    Class<Object> type = Object.class;

    Value settings = mock(Value.class);
    when(settings.getIdVisible()).thenReturn(true);
    when(settings.getInclusionType()).thenReturn(As.PROPERTY);
    when(settings.getRequireTypeIdForSubtypes()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(settings.getDefaultImpl()).thenReturn(forNameResult);
    when(settings.getPropertyName()).thenReturn("Property Name");
    when(settings.getIdType()).thenReturn(Id.CLASS);

    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.isEnumType()).thenReturn(true);
    when(arrayType.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(arrayType.getContentType()).thenReturn(new PlaceholderForType(1));
    when(arrayType.isMapLikeType()).thenReturn(true);
    when(arrayType.isAbstract()).thenReturn(true);
    when(arrayType.isContainerType()).thenReturn(true);
    Class<Object> forNameResult2 = Object.class;
    Mockito.<Class<?>>when(arrayType.getRawClass()).thenReturn(forNameResult2);

    MinimalClassNameIdResolver idRes = mock(MinimalClassNameIdResolver.class);
    when(idRes.typeFromId(Mockito.<DatabindContext>any(), Mockito.<String>any()))
        .thenReturn(arrayType);
    when(idRes.idFromValue(Mockito.<Object>any())).thenReturn("42");

    StdTypeResolverBuilder typer = new StdTypeResolverBuilder();

    typer.init(settings, idRes);

    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(typer);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper rosettaObjectMapper = builderResult.findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            JsonDataLoaderUtil.fromObject(
                BeanPropertyWriter.MARKER_FOR_EMPTY, type, rosettaObjectMapper));
    verify(settings).getDefaultImpl();
    verify(settings).getIdType();
    verify(settings).getIdVisible();
    verify(settings).getInclusionType();
    verify(settings).getPropertyName();
    verify(settings).getRequireTypeIdForSubtypes();
    verify(arrayType, atLeast(1)).getKeyType();
    verify(arrayType, atLeast(1)).getRawClass();
    verify(arrayType).isEnumType();
    verify(arrayType, atLeast(1)).isMapLikeType();
    verify(idRes).typeFromId(isA(DatabindContext.class), eq("42"));
    verify(idRes).idFromValue(isA(Object.class));
    verify(arrayType, atLeast(1)).getContentType();
    verify(arrayType).isAbstract();
    verify(arrayType, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}.
   *
   * <ul>
   *   <li>Given {@link ArrayType} {@link ArrayType#getContentType()} return {@link ArrayType}.
   *   <li>Then calls {@link ArrayType#getKeyType()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test fromObject(Object, Class, ObjectMapper); given ArrayType getContentType() return ArrayType; then calls getKeyType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.fromObject(Object, Class, ObjectMapper)"})
  void testFromObject_givenArrayTypeGetContentTypeReturnArrayType_thenCallsGetKeyType()
      throws IOException {
    // Arrange
    Class<Object> type = Object.class;

    Value settings = mock(Value.class);
    when(settings.getIdVisible()).thenReturn(true);
    when(settings.getInclusionType()).thenReturn(As.PROPERTY);
    when(settings.getRequireTypeIdForSubtypes()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(settings.getDefaultImpl()).thenReturn(forNameResult);
    when(settings.getPropertyName()).thenReturn("Property Name");
    when(settings.getIdType()).thenReturn(Id.CLASS);

    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn(BeanPropertyWriter.MARKER_FOR_EMPTY);

    ArrayType arrayType2 = mock(ArrayType.class);
    when(arrayType2.isEnumType()).thenReturn(true);
    when(arrayType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(arrayType2.getContentType()).thenReturn(arrayType);
    when(arrayType2.isMapLikeType()).thenReturn(true);
    when(arrayType2.isAbstract()).thenReturn(true);
    when(arrayType2.isContainerType()).thenReturn(true);
    Class<Object> forNameResult2 = Object.class;
    Mockito.<Class<?>>when(arrayType2.getRawClass()).thenReturn(forNameResult2);

    MinimalClassNameIdResolver idRes = mock(MinimalClassNameIdResolver.class);
    when(idRes.typeFromId(Mockito.<DatabindContext>any(), Mockito.<String>any()))
        .thenReturn(arrayType2);
    when(idRes.idFromValue(Mockito.<Object>any())).thenReturn("42");

    StdTypeResolverBuilder typer = new StdTypeResolverBuilder();

    typer.init(settings, idRes);

    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(typer);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper rosettaObjectMapper = builderResult.findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            JsonDataLoaderUtil.fromObject(
                BeanPropertyWriter.MARKER_FOR_EMPTY, type, rosettaObjectMapper));
    verify(settings).getDefaultImpl();
    verify(settings).getIdType();
    verify(settings).getIdVisible();
    verify(settings).getInclusionType();
    verify(settings).getPropertyName();
    verify(settings).getRequireTypeIdForSubtypes();
    verify(arrayType2, atLeast(1)).getKeyType();
    verify(arrayType2, atLeast(1)).getRawClass();
    verify(arrayType, atLeast(1)).getValueHandler();
    verify(arrayType2).isEnumType();
    verify(arrayType2, atLeast(1)).isMapLikeType();
    verify(idRes).typeFromId(isA(DatabindContext.class), eq("42"));
    verify(idRes).idFromValue(isA(Object.class));
    verify(arrayType2, atLeast(1)).getContentType();
    verify(arrayType2).isAbstract();
    verify(arrayType2, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}.
   *
   * <ul>
   *   <li>Given {@link ArrayType} {@link ArrayType#getContentType()} return {@link ArrayType}.
   *   <li>When {@link QualificationReport#SUCCESS}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test fromObject(Object, Class, ObjectMapper); given ArrayType getContentType() return ArrayType; when SUCCESS")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.fromObject(Object, Class, ObjectMapper)"})
  void testFromObject_givenArrayTypeGetContentTypeReturnArrayType_whenSuccess() throws IOException {
    // Arrange
    Class<Object> type = Object.class;

    Value settings = mock(Value.class);
    when(settings.getIdVisible()).thenReturn(true);
    when(settings.getInclusionType()).thenReturn(As.PROPERTY);
    when(settings.getRequireTypeIdForSubtypes()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(settings.getDefaultImpl()).thenReturn(forNameResult);
    when(settings.getPropertyName()).thenReturn("Property Name");
    when(settings.getIdType()).thenReturn(Id.CLASS);

    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn(BeanPropertyWriter.MARKER_FOR_EMPTY);

    ArrayType arrayType2 = mock(ArrayType.class);
    when(arrayType2.isEnumType()).thenReturn(true);
    when(arrayType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(arrayType2.getContentType()).thenReturn(arrayType);
    when(arrayType2.isMapLikeType()).thenReturn(true);
    when(arrayType2.isAbstract()).thenReturn(true);
    when(arrayType2.isContainerType()).thenReturn(true);
    Class<Object> forNameResult2 = Object.class;
    Mockito.<Class<?>>when(arrayType2.getRawClass()).thenReturn(forNameResult2);

    MinimalClassNameIdResolver idRes = mock(MinimalClassNameIdResolver.class);
    when(idRes.typeFromId(Mockito.<DatabindContext>any(), Mockito.<String>any()))
        .thenReturn(arrayType2);
    when(idRes.idFromValue(Mockito.<Object>any())).thenReturn("42");

    StdTypeResolverBuilder typer = new StdTypeResolverBuilder();

    typer.init(settings, idRes);

    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(typer);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper rosettaObjectMapper = builderResult.findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            JsonDataLoaderUtil.fromObject(QualificationReport.SUCCESS, type, rosettaObjectMapper));
    verify(settings).getDefaultImpl();
    verify(settings).getIdType();
    verify(settings).getIdVisible();
    verify(settings).getInclusionType();
    verify(settings).getPropertyName();
    verify(settings).getRequireTypeIdForSubtypes();
    verify(arrayType2, atLeast(1)).getKeyType();
    verify(arrayType2, atLeast(1)).getRawClass();
    verify(arrayType, atLeast(1)).getValueHandler();
    verify(arrayType2).isEnumType();
    verify(arrayType2, atLeast(1)).isMapLikeType();
    verify(idRes).typeFromId(isA(DatabindContext.class), eq("42"));
    verify(idRes, atLeast(1)).idFromValue(Mockito.<Object>any());
    verify(arrayType2, atLeast(1)).getContentType();
    verify(arrayType2).isAbstract();
    verify(arrayType2, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}.
   *
   * <ul>
   *   <li>Given {@link DefaultTypeResolverBuilder#DefaultTypeResolverBuilder(DefaultTyping)} with t
   *       is {@code JAVA_LANG_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test fromObject(Object, Class, ObjectMapper); given DefaultTypeResolverBuilder(DefaultTyping) with t is 'JAVA_LANG_OBJECT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.fromObject(Object, Class, ObjectMapper)"})
  void testFromObject_givenDefaultTypeResolverBuilderWithTIsJavaLangObject() {
    // Arrange
    Class<Object> type = Object.class;

    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT));
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper rosettaObjectMapper = builderResult.findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            JsonDataLoaderUtil.fromObject(
                BeanPropertyWriter.MARKER_FOR_EMPTY, type, rosettaObjectMapper));
  }

  /**
   * Test {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}.
   *
   * <ul>
   *   <li>Given {@code List}.
   *   <li>When builder addMixIn {@link List} and {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test fromObject(Object, Class, ObjectMapper); given 'java.util.List'; when builder addMixIn List and Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.fromObject(Object, Class, ObjectMapper)"})
  void testFromObject_givenJavaUtilList_whenBuilderAddMixInListAndObject() {
    // Arrange
    Class<Object> type = Object.class;

    Builder builderResult = JsonMapper.builder();
    Class<List> target = List.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper rosettaObjectMapper = builderResult.findAndAddModules().build();

    // Act
    Object actualFromObjectResult =
        JsonDataLoaderUtil.fromObject(
            BeanPropertyWriter.MARKER_FOR_EMPTY, type, rosettaObjectMapper);

    // Assert
    assertEquals("NON_EMPTY", actualFromObjectResult);
  }

  /**
   * Test {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}.
   *
   * <ul>
   *   <li>Given {@code List}.
   *   <li>When builder addMixIn {@link Object} and {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test fromObject(Object, Class, ObjectMapper); given 'java.util.List'; when builder addMixIn Object and List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.fromObject(Object, Class, ObjectMapper)"})
  void testFromObject_givenJavaUtilList_whenBuilderAddMixInObjectAndList() {
    // Arrange
    Class<Object> type = Object.class;

    Builder builderResult = JsonMapper.builder();
    Class<Object> target = Object.class;
    Class<List> mixinSource = List.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper rosettaObjectMapper = builderResult.findAndAddModules().build();

    // Act
    Object actualFromObjectResult =
        JsonDataLoaderUtil.fromObject(
            BeanPropertyWriter.MARKER_FOR_EMPTY, type, rosettaObjectMapper);

    // Assert
    assertEquals("NON_EMPTY", actualFromObjectResult);
  }

  /**
   * Test {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}.
   *
   * <ul>
   *   <li>Given {@link MinimalClassNameIdResolver} {@link
   *       MinimalClassNameIdResolver#idFromValue(Object)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test fromObject(Object, Class, ObjectMapper); given MinimalClassNameIdResolver idFromValue(Object) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.fromObject(Object, Class, ObjectMapper)"})
  void testFromObject_givenMinimalClassNameIdResolverIdFromValueThrowRuntimeException() {
    // Arrange
    Class<Object> type = Object.class;

    Value settings = mock(Value.class);
    when(settings.getIdVisible()).thenReturn(true);
    when(settings.getInclusionType()).thenReturn(As.PROPERTY);
    when(settings.getRequireTypeIdForSubtypes()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(settings.getDefaultImpl()).thenReturn(forNameResult);
    when(settings.getPropertyName()).thenReturn("Property Name");
    when(settings.getIdType()).thenReturn(Id.CLASS);

    MinimalClassNameIdResolver idRes = mock(MinimalClassNameIdResolver.class);
    when(idRes.idFromValue(Mockito.<Object>any())).thenThrow(new RuntimeException());

    StdTypeResolverBuilder typer = new StdTypeResolverBuilder();

    typer.init(settings, idRes);

    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(typer);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper rosettaObjectMapper = builderResult.findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            JsonDataLoaderUtil.fromObject(
                BeanPropertyWriter.MARKER_FOR_EMPTY, type, rosettaObjectMapper));
    verify(settings).getDefaultImpl();
    verify(settings).getIdType();
    verify(settings).getIdVisible();
    verify(settings).getInclusionType();
    verify(settings).getPropertyName();
    verify(settings).getRequireTypeIdForSubtypes();
    verify(idRes).idFromValue(isA(Object.class));
  }

  /**
   * Test {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}.
   *
   * <ul>
   *   <li>Given {@link MinimalClassNameIdResolver} {@link
   *       MinimalClassNameIdResolver#typeFromId(DatabindContext, String)} throw {@link
   *       IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test fromObject(Object, Class, ObjectMapper); given MinimalClassNameIdResolver typeFromId(DatabindContext, String) throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.fromObject(Object, Class, ObjectMapper)"})
  void testFromObject_givenMinimalClassNameIdResolverTypeFromIdThrowIOException()
      throws IOException {
    // Arrange
    Class<Object> type = Object.class;

    Value settings = mock(Value.class);
    when(settings.getIdVisible()).thenReturn(true);
    when(settings.getInclusionType()).thenReturn(As.PROPERTY);
    when(settings.getRequireTypeIdForSubtypes()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(settings.getDefaultImpl()).thenReturn(forNameResult);
    when(settings.getPropertyName()).thenReturn("Property Name");
    when(settings.getIdType()).thenReturn(Id.CLASS);

    MinimalClassNameIdResolver idRes = mock(MinimalClassNameIdResolver.class);
    when(idRes.typeFromId(Mockito.<DatabindContext>any(), Mockito.<String>any()))
        .thenThrow(new IOException());
    when(idRes.idFromValue(Mockito.<Object>any())).thenReturn("42");

    StdTypeResolverBuilder typer = new StdTypeResolverBuilder();

    typer.init(settings, idRes);

    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(typer);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper rosettaObjectMapper = builderResult.findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            JsonDataLoaderUtil.fromObject(
                BeanPropertyWriter.MARKER_FOR_EMPTY, type, rosettaObjectMapper));
    verify(settings).getDefaultImpl();
    verify(settings).getIdType();
    verify(settings).getIdVisible();
    verify(settings).getInclusionType();
    verify(settings).getPropertyName();
    verify(settings).getRequireTypeIdForSubtypes();
    verify(idRes).typeFromId(isA(DatabindContext.class), eq("42"));
    verify(idRes).idFromValue(isA(Object.class));
  }

  /**
   * Test {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When builder defaultLeniency {@code true}.
   *   <li>Then return {@code NON_EMPTY}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test fromObject(Object, Class, ObjectMapper); given 'true'; when builder defaultLeniency 'true'; then return 'NON_EMPTY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.fromObject(Object, Class, ObjectMapper)"})
  void testFromObject_givenTrue_whenBuilderDefaultLeniencyTrue_thenReturnNonEmpty() {
    // Arrange
    Class<Object> type = Object.class;

    Builder builderResult = JsonMapper.builder();
    builderResult.defaultLeniency(true);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper rosettaObjectMapper = builderResult.findAndAddModules().build();

    // Act
    Object actualFromObjectResult =
        JsonDataLoaderUtil.fromObject(
            BeanPropertyWriter.MARKER_FOR_EMPTY, type, rosettaObjectMapper);

    // Assert
    assertEquals("NON_EMPTY", actualFromObjectResult);
  }

  /**
   * Test {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}.
   *
   * <ul>
   *   <li>Given {@link JsonTypeInfo.Value} {@link JsonTypeInfo.Value#getInclusionType()} return
   *       {@code WRAPPER_OBJECT}.
   *   <li>Then calls {@link ArrayType#getKeyType()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test fromObject(Object, Class, ObjectMapper); given Value getInclusionType() return 'WRAPPER_OBJECT'; then calls getKeyType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.fromObject(Object, Class, ObjectMapper)"})
  void testFromObject_givenValueGetInclusionTypeReturnWrapperObject_thenCallsGetKeyType()
      throws IOException {
    // Arrange
    Class<Object> type = Object.class;

    Value settings = mock(Value.class);
    when(settings.getIdVisible()).thenReturn(true);
    when(settings.getInclusionType()).thenReturn(As.WRAPPER_OBJECT);
    when(settings.getRequireTypeIdForSubtypes()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(settings.getDefaultImpl()).thenReturn(forNameResult);
    when(settings.getPropertyName()).thenReturn("Property Name");
    when(settings.getIdType()).thenReturn(Id.CLASS);

    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn(BeanPropertyWriter.MARKER_FOR_EMPTY);

    ArrayType arrayType2 = mock(ArrayType.class);
    when(arrayType2.isEnumType()).thenReturn(true);
    when(arrayType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(arrayType2.getContentType()).thenReturn(arrayType);
    when(arrayType2.isMapLikeType()).thenReturn(true);
    when(arrayType2.isAbstract()).thenReturn(true);
    when(arrayType2.isContainerType()).thenReturn(true);
    Class<Object> forNameResult2 = Object.class;
    Mockito.<Class<?>>when(arrayType2.getRawClass()).thenReturn(forNameResult2);

    MinimalClassNameIdResolver idRes = mock(MinimalClassNameIdResolver.class);
    when(idRes.typeFromId(Mockito.<DatabindContext>any(), Mockito.<String>any()))
        .thenReturn(arrayType2);
    when(idRes.idFromValue(Mockito.<Object>any())).thenReturn("42");

    StdTypeResolverBuilder typer = new StdTypeResolverBuilder();

    typer.init(settings, idRes);

    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(typer);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper rosettaObjectMapper = builderResult.findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            JsonDataLoaderUtil.fromObject(
                BeanPropertyWriter.MARKER_FOR_EMPTY, type, rosettaObjectMapper));
    verify(settings).getDefaultImpl();
    verify(settings).getIdType();
    verify(settings).getIdVisible();
    verify(settings).getInclusionType();
    verify(settings).getPropertyName();
    verify(settings).getRequireTypeIdForSubtypes();
    verify(arrayType2, atLeast(1)).getKeyType();
    verify(arrayType2, atLeast(1)).getRawClass();
    verify(arrayType, atLeast(1)).getValueHandler();
    verify(arrayType2).isEnumType();
    verify(arrayType2, atLeast(1)).isMapLikeType();
    verify(idRes).typeFromId(isA(DatabindContext.class), eq("42"));
    verify(idRes).idFromValue(isA(Object.class));
    verify(arrayType2, atLeast(1)).getContentType();
    verify(arrayType2).isAbstract();
    verify(arrayType2, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}.
   *
   * <ul>
   *   <li>Then return size is six.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  @DisplayName("Test fromObject(Object, Class, ObjectMapper); then return size is six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.fromObject(Object, Class, ObjectMapper)"})
  void testFromObject_thenReturnSizeIsSix() {
    // Arrange
    ProjectionDataItemExpectation projectionDataItemExpectation =
        new ProjectionDataItemExpectation("Input File", "42", "Output File", 1, true, true);
    Class<Object> type = Object.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act
    Object actualFromObjectResult =
        JsonDataLoaderUtil.fromObject(projectionDataItemExpectation, type, rosettaObjectMapper);

    // Assert
    assertTrue(actualFromObjectResult instanceof Map);
    assertEquals(6, ((Map<String, Object>) actualFromObjectResult).size());
    assertEquals("42", ((Map<String, Object>) actualFromObjectResult).get("keyValueFile"));
    assertEquals("Input File", ((Map<String, Object>) actualFromObjectResult).get("inputFile"));
    assertEquals("Output File", ((Map<String, Object>) actualFromObjectResult).get("outputFile"));
    assertEquals(
        1,
        ((Integer) ((Map<String, Object>) actualFromObjectResult).get("validationFailures"))
            .intValue());
    assertTrue((Boolean) ((Map<String, Object>) actualFromObjectResult).get("error"));
    assertTrue((Boolean) ((Map<String, Object>) actualFromObjectResult).get("validXml"));
  }

  /**
   * Test {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}.
   *
   * <ul>
   *   <li>When builder addMixIn {@link Object} and {@link Object}.
   *   <li>Then return {@code NON_EMPTY}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test fromObject(Object, Class, ObjectMapper); when builder addMixIn Object and Object; then return 'NON_EMPTY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.fromObject(Object, Class, ObjectMapper)"})
  void testFromObject_whenBuilderAddMixInObjectAndObject_thenReturnNonEmpty() {
    // Arrange
    Class<Object> type = Object.class;

    Builder builderResult = JsonMapper.builder();
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper rosettaObjectMapper = builderResult.findAndAddModules().build();

    // Act
    Object actualFromObjectResult =
        JsonDataLoaderUtil.fromObject(
            BeanPropertyWriter.MARKER_FOR_EMPTY, type, rosettaObjectMapper);

    // Assert
    assertEquals("NON_EMPTY", actualFromObjectResult);
  }

  /**
   * Test {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test fromObject(Object, Class, ObjectMapper); when forty-two; then return intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.fromObject(Object, Class, ObjectMapper)"})
  void testFromObject_whenFortyTwo_thenReturnIntValueIsFortyTwo() {
    // Arrange
    Class<Object> type = Object.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act
    Object actualFromObjectResult = JsonDataLoaderUtil.fromObject(42, type, rosettaObjectMapper);

    // Assert
    assertEquals(42, ((Integer) actualFromObjectResult).intValue());
  }

  /**
   * Test {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test fromObject(Object, Class, ObjectMapper); when 'java.lang.Object'; then return 'java.lang.Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.fromObject(Object, Class, ObjectMapper)"})
  void testFromObject_whenJavaLangObject_thenReturnJavaLangObject() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Class<Object> type = Object.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act
    Object actualFromObjectResult =
        JsonDataLoaderUtil.fromObject(forNameResult, type, rosettaObjectMapper);

    // Assert
    assertEquals("java.lang.Object", actualFromObjectResult);
  }

  /**
   * Test {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}.
   *
   * <ul>
   *   <li>When {@link BeanPropertyWriter#MARKER_FOR_EMPTY}.
   *   <li>Then return {@code NON_EMPTY}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test fromObject(Object, Class, ObjectMapper); when MARKER_FOR_EMPTY; then return 'NON_EMPTY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.fromObject(Object, Class, ObjectMapper)"})
  void testFromObject_whenMarker_for_empty_thenReturnNonEmpty() {
    // Arrange
    Class<Object> type = Object.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act
    Object actualFromObjectResult =
        JsonDataLoaderUtil.fromObject(
            BeanPropertyWriter.MARKER_FOR_EMPTY, type, rosettaObjectMapper);

    // Assert
    assertEquals("NON_EMPTY", actualFromObjectResult);
  }

  /**
   * Test {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}.
   *
   * <ul>
   *   <li>When {@link QualificationReport#SUCCESS}.
   *   <li>Then return size is four.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test fromObject(Object, Class, ObjectMapper); when SUCCESS; then return size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JsonDataLoaderUtil.fromObject(Object, Class, ObjectMapper)"})
  void testFromObject_whenSuccess_thenReturnSizeIsFour() {
    // Arrange
    Class<Object> type = Object.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act
    Object actualFromObjectResult =
        JsonDataLoaderUtil.fromObject(QualificationReport.SUCCESS, type, rosettaObjectMapper);

    // Assert
    assertEquals(4, ((Map<String, Object>) actualFromObjectResult).size());
    Object getResult = ((Map<String, Object>) actualFromObjectResult).get("results");
    assertTrue(getResult instanceof List);
    assertTrue(actualFromObjectResult instanceof Map);
    assertNull(((Map<String, Object>) actualFromObjectResult).get("ingestedObject"));
    assertEquals(
        0,
        ((Integer) ((Map<String, Object>) actualFromObjectResult).get("qualifiableObjectsCount"))
            .intValue());
    assertEquals(
        0,
        ((Integer)
                ((Map<String, Object>) actualFromObjectResult).get("uniquelyQualifiedObjectsCount"))
            .intValue());
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test {@link JsonDataLoaderUtil#openURL(URL)}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is empty string toUri toURL.
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#openURL(URL)}
   */
  @Test
  @DisplayName(
      "Test openURL(URL); when Property is 'java.io.tmpdir' is empty string toUri toURL; then return Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional JsonDataLoaderUtil.openURL(URL)"})
  void testOpenURL_whenPropertyIsJavaIoTmpdirIsEmptyStringToUriToURL_thenReturnPresent()
      throws MalformedURLException {
    // Arrange and Act
    Optional<Reader> actualOpenURLResult =
        JsonDataLoaderUtil.openURL(
            Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL());

    // Assert
    assertTrue(actualOpenURLResult.isPresent());
  }

  /**
   * Test {@link JsonDataLoaderUtil#openURL(URL)}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt} toUri toURL.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#openURL(URL)}
   */
  @Test
  @DisplayName(
      "Test openURL(URL); when Property is 'java.io.tmpdir' is 'test.txt' toUri toURL; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional JsonDataLoaderUtil.openURL(URL)"})
  void testOpenURL_whenPropertyIsJavaIoTmpdirIsTestTxtToUriToURL_thenReturnNotPresent()
      throws MalformedURLException {
    // Arrange and Act
    Optional<Reader> actualOpenURLResult =
        JsonDataLoaderUtil.openURL(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());

    // Assert
    assertFalse(actualOpenURLResult.isPresent());
  }

  /**
   * Test {@link JsonDataLoaderUtil#loadClass(String, ClassLoader)}.
   *
   * <ul>
   *   <li>When {@code List}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#loadClass(String, ClassLoader)}
   */
  @Test
  @DisplayName("Test loadClass(String, ClassLoader); when 'java.util.List'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class JsonDataLoaderUtil.loadClass(String, ClassLoader)"})
  void testLoadClass_whenJavaUtilList_thenReturnList() {
    // Arrange and Act
    Class<?> actualLoadClassResult = JsonDataLoaderUtil.loadClass("java.util.List", new MLet());

    // Assert
    Class<List> expectedLoadClassResult = List.class;
    assertEquals(expectedLoadClassResult, actualLoadClassResult);
  }

  /**
   * Test {@link JsonDataLoaderUtil#loadClass(String, ClassLoader)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataLoaderUtil#loadClass(String, ClassLoader)}
   */
  @Test
  @DisplayName("Test loadClass(String, ClassLoader); when 'Type'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class JsonDataLoaderUtil.loadClass(String, ClassLoader)"})
  void testLoadClass_whenType_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.loadClass("Type", new MLet()));
  }
}
