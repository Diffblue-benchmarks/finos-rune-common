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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTypeResolverBuilder;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.CacheProvider;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.fasterxml.jackson.databind.util.LRUMap;
import com.regnosys.rosetta.common.postprocess.qualify.QualificationReport;
import com.regnosys.rosetta.common.projection.ProjectionDataItemExpectation;
import java.io.CharArrayReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.management.loading.MLet;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class JsonDataLoaderUtilDiffblueTest {
  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)} with {@code type}, {@code rosettaObjectMapper}, {@code json}.
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, String)"})
  public void testReadTypeWithTypeRosettaObjectMapperJson() {
    // Arrange
    Class<Object> type = Object.class;
    CacheProvider cacheProvider = mock(CacheProvider.class);
    when(cacheProvider.forDeserializerCache(Mockito.<DeserializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forSerializerCache(Mockito.<SerializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forTypeFactory()).thenReturn(new LRUMap<>(1, 3));
    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT));
    builderResult.cacheProvider(cacheProvider);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readType(type, builderResult.findAndAddModules().build(), "["));
    verify(cacheProvider).forDeserializerCache(isNull());
    verify(cacheProvider).forSerializerCache(isNull());
    verify(cacheProvider).forTypeFactory();
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)} with {@code type}, {@code rosettaObjectMapper}, {@code json}.
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, String)"})
  public void testReadTypeWithTypeRosettaObjectMapperJson2() {
    // Arrange
    Class<Object> type = Object.class;
    CacheProvider cacheProvider = mock(CacheProvider.class);
    when(cacheProvider.forDeserializerCache(Mockito.<DeserializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forSerializerCache(Mockito.<SerializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forTypeFactory()).thenReturn(new LRUMap<>(1, 3));
    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(new DefaultTypeResolverBuilder(DefaultTyping.OBJECT_AND_NON_CONCRETE));
    builderResult.cacheProvider(cacheProvider);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readType(type, builderResult.findAndAddModules().build(), "["));
    verify(cacheProvider).forDeserializerCache(isNull());
    verify(cacheProvider).forSerializerCache(isNull());
    verify(cacheProvider).forTypeFactory();
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)} with {@code type}, {@code rosettaObjectMapper}, {@code json}.
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, String)"})
  public void testReadTypeWithTypeRosettaObjectMapperJson3() {
    // Arrange
    Class<Object> type = Object.class;
    CacheProvider cacheProvider = mock(CacheProvider.class);
    when(cacheProvider.forDeserializerCache(Mockito.<DeserializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forSerializerCache(Mockito.<SerializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forTypeFactory()).thenReturn(new LRUMap<>(1, 3));
    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(new DefaultTypeResolverBuilder(DefaultTyping.NON_CONCRETE_AND_ARRAYS));
    builderResult.cacheProvider(cacheProvider);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readType(type, builderResult.findAndAddModules().build(), "["));
    verify(cacheProvider).forDeserializerCache(isNull());
    verify(cacheProvider).forSerializerCache(isNull());
    verify(cacheProvider).forTypeFactory();
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)} with {@code type}, {@code rosettaObjectMapper}, {@code json}.
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, String)"})
  public void testReadTypeWithTypeRosettaObjectMapperJson4() {
    // Arrange
    Class<Object> type = Object.class;
    CacheProvider cacheProvider = mock(CacheProvider.class);
    when(cacheProvider.forDeserializerCache(Mockito.<DeserializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forSerializerCache(Mockito.<SerializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forTypeFactory()).thenReturn(new LRUMap<>(1, 3));
    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(new DefaultTypeResolverBuilder(DefaultTyping.NON_FINAL));
    builderResult.cacheProvider(cacheProvider);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readType(type, builderResult.findAndAddModules().build(), "["));
    verify(cacheProvider).forDeserializerCache(isNull());
    verify(cacheProvider).forSerializerCache(isNull());
    verify(cacheProvider).forTypeFactory();
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)} with {@code type}, {@code rosettaObjectMapper}, {@code json}.
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, String)"})
  public void testReadTypeWithTypeRosettaObjectMapperJson5() {
    // Arrange
    Class<Object> type = Object.class;
    CacheProvider cacheProvider = mock(CacheProvider.class);
    when(cacheProvider.forDeserializerCache(Mockito.<DeserializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forSerializerCache(Mockito.<SerializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forTypeFactory()).thenReturn(new LRUMap<>(1, 3));
    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(new DefaultTypeResolverBuilder(DefaultTyping.NON_FINAL_AND_ENUMS));
    builderResult.cacheProvider(cacheProvider);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readType(type, builderResult.findAndAddModules().build(), "["));
    verify(cacheProvider).forDeserializerCache(isNull());
    verify(cacheProvider).forSerializerCache(isNull());
    verify(cacheProvider).forTypeFactory();
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)} with {@code type}, {@code rosettaObjectMapper}, {@code json}.
   * <ul>
   *   <li>Given {@code List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, String)"})
  public void testReadTypeWithTypeRosettaObjectMapperJson_givenJavaUtilList() {
    // Arrange
    Class<Object> type = Object.class;
    Builder builderResult = JsonMapper.builder();
    Class<List> target = List.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readType(type, builderResult.findAndAddModules().build(), "["));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)} with {@code type}, {@code rosettaObjectMapper}, {@code json}.
   * <ul>
   *   <li>Given {@link StdTypeResolverBuilder#StdTypeResolverBuilder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, String)"})
  public void testReadTypeWithTypeRosettaObjectMapperJson_givenStdTypeResolverBuilder() {
    // Arrange
    Class<Object> type = Object.class;
    CacheProvider cacheProvider = mock(CacheProvider.class);
    when(cacheProvider.forDeserializerCache(Mockito.<DeserializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forSerializerCache(Mockito.<SerializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forTypeFactory()).thenReturn(new LRUMap<>(1, 3));
    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(new StdTypeResolverBuilder());
    builderResult.cacheProvider(cacheProvider);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readType(type, builderResult.findAndAddModules().build(), "["));
    verify(cacheProvider).forDeserializerCache(isNull());
    verify(cacheProvider).forSerializerCache(isNull());
    verify(cacheProvider).forTypeFactory();
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)} with {@code type}, {@code rosettaObjectMapper}, {@code json}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, String)"})
  public void testReadTypeWithTypeRosettaObjectMapperJson_when42_thenReturnIntValueIsFortyTwo() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(42,
        ((Integer) JsonDataLoaderUtil.readType(type, JsonMapper.builder().findAndAddModules().build(), "42"))
            .intValue());
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)} with {@code type}, {@code rosettaObjectMapper}, {@code json}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, String)"})
  public void testReadTypeWithTypeRosettaObjectMapperJson_when42_thenThrowRuntimeException() {
    // Arrange
    Class<List> type = List.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readType(type, JsonMapper.builder().findAndAddModules().build(), "42"));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)} with {@code type}, {@code rosettaObjectMapper}, {@code json}.
   * <ul>
   *   <li>When builder addMixIn {@link Object} and {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, String)"})
  public void testReadTypeWithTypeRosettaObjectMapperJson_whenBuilderAddMixInObjectAndObject() {
    // Arrange
    Class<Object> type = Object.class;
    Builder builderResult = JsonMapper.builder();
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readType(type, builderResult.findAndAddModules().build(), "["));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)} with {@code type}, {@code rosettaObjectMapper}, {@code json}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, String)"})
  public void testReadTypeWithTypeRosettaObjectMapperJson_whenEmptyString() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readType(type, JsonMapper.builder().findAndAddModules().build(), ""));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)} with {@code type}, {@code rosettaObjectMapper}, {@code json}.
   * <ul>
   *   <li>When {@code List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, String)"})
  public void testReadTypeWithTypeRosettaObjectMapperJson_whenJavaUtilList() {
    // Arrange
    Class<List> type = List.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readType(type, JsonMapper.builder().findAndAddModules().build(), "Json"));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)} with {@code type}, {@code rosettaObjectMapper}, {@code json}.
   * <ul>
   *   <li>When {@code List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, String)"})
  public void testReadTypeWithTypeRosettaObjectMapperJson_whenJavaUtilList2() {
    // Arrange
    Class<List> type = List.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readType(type, JsonMapper.builder().findAndAddModules().build(), "["));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)} with {@code type}, {@code rosettaObjectMapper}, {@code json}.
   * <ul>
   *   <li>When {@code Json}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, String)"})
  public void testReadTypeWithTypeRosettaObjectMapperJson_whenJson_thenThrowRuntimeException() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readType(type, JsonMapper.builder().findAndAddModules().build(), "Json"));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)} with {@code type}, {@code rosettaObjectMapper}, {@code json}.
   * <ul>
   *   <li>When {@code [}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, String)"})
  public void testReadTypeWithTypeRosettaObjectMapperJson_whenLeftSquareBracket() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readType(type, JsonMapper.builder().findAndAddModules().build(), "["));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)} with {@code type}, {@code rosettaObjectMapper}, {@code json}.
   * <ul>
   *   <li>When {@code ]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, String)"})
  public void testReadTypeWithTypeRosettaObjectMapperJson_whenRightSquareBracket() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readType(type, JsonMapper.builder().findAndAddModules().build(), "]"));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, URL)} with {@code type}, {@code rosettaObjectMapper}, {@code url}.
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, URL)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, URL)"})
  public void testReadTypeWithTypeRosettaObjectMapperUrl() throws MalformedURLException {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readType(type, JsonMapper.builder().findAndAddModules().build(),
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, URL)} with {@code type}, {@code rosettaObjectMapper}, {@code url}.
   * <ul>
   *   <li>When {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, URL)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, URL)"})
  public void testReadTypeWithTypeRosettaObjectMapperUrl_whenJavaLangObject() throws MalformedURLException {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readType(type, JsonMapper.builder().findAndAddModules().build(),
            Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL()));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, URL)} with {@code type}, {@code rosettaObjectMapper}, {@code url}.
   * <ul>
   *   <li>When {@code List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, URL)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonDataLoaderUtil.readType(Class, ObjectMapper, URL)"})
  public void testReadTypeWithTypeRosettaObjectMapperUrl_whenJavaUtilList() throws MalformedURLException {
    // Arrange
    Class<List> type = List.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readType(type, JsonMapper.builder().findAndAddModules().build(),
            Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL()));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)} with {@code type}, {@code rosettaObjectMapper}, {@code input}.
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JsonDataLoaderUtil.readTypeList(Class, ObjectMapper, Reader)"})
  public void testReadTypeListWithTypeRosettaObjectMapperInput() {
    // Arrange
    Class<Object> type = Object.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper,
        new StringReader(" cannot be serialised to list of ")));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)} with {@code type}, {@code rosettaObjectMapper}, {@code input}.
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JsonDataLoaderUtil.readTypeList(Class, ObjectMapper, Reader)"})
  public void testReadTypeListWithTypeRosettaObjectMapperInput2() {
    // Arrange
    Class<Object> type = Object.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper,
        new CharArrayReader("A\u0000A\u0000".toCharArray(), 1, 1)));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)} with {@code type}, {@code rosettaObjectMapper}, {@code input}.
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JsonDataLoaderUtil.readTypeList(Class, ObjectMapper, Reader)"})
  public void testReadTypeListWithTypeRosettaObjectMapperInput3() {
    // Arrange
    Class<Object> type = Object.class;
    Builder builderResult = JsonMapper.builder();
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);
    JsonMapper rosettaObjectMapper = builderResult.findAndAddModules().build();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("42")));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)} with {@code type}, {@code rosettaObjectMapper}, {@code input}.
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JsonDataLoaderUtil.readTypeList(Class, ObjectMapper, Reader)"})
  public void testReadTypeListWithTypeRosettaObjectMapperInput4() {
    // Arrange
    Class<Object> type = Object.class;
    CacheProvider cacheProvider = mock(CacheProvider.class);
    when(cacheProvider.forDeserializerCache(Mockito.<DeserializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forSerializerCache(Mockito.<SerializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forTypeFactory()).thenReturn(new LRUMap<>(1, 3));
    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT));
    builderResult.cacheProvider(cacheProvider);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);
    JsonMapper rosettaObjectMapper = builderResult.findAndAddModules().build();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("42")));
    verify(cacheProvider).forDeserializerCache(isNull());
    verify(cacheProvider).forSerializerCache(isNull());
    verify(cacheProvider).forTypeFactory();
  }

  /**
   * Test {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)} with {@code type}, {@code rosettaObjectMapper}, {@code input}.
   * <ul>
   *   <li>Given {@code List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JsonDataLoaderUtil.readTypeList(Class, ObjectMapper, Reader)"})
  public void testReadTypeListWithTypeRosettaObjectMapperInput_givenJavaUtilList() {
    // Arrange
    Class<Object> type = Object.class;
    Builder builderResult = JsonMapper.builder();
    Class<List> target = List.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);
    JsonMapper rosettaObjectMapper = builderResult.findAndAddModules().build();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("42")));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)} with {@code type}, {@code rosettaObjectMapper}, {@code input}.
   * <ul>
   *   <li>Given {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JsonDataLoaderUtil.readTypeList(Class, ObjectMapper, Reader)"})
  public void testReadTypeListWithTypeRosettaObjectMapperInput_givenTrue() {
    // Arrange
    Class<Object> type = Object.class;
    CacheProvider cacheProvider = mock(CacheProvider.class);
    when(cacheProvider.forDeserializerCache(Mockito.<DeserializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forSerializerCache(Mockito.<SerializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forTypeFactory()).thenReturn(new LRUMap<>(1, 3));
    Builder builderResult = JsonMapper.builder();
    builderResult.defaultLeniency(true);
    builderResult.cacheProvider(cacheProvider);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);
    JsonMapper rosettaObjectMapper = builderResult.findAndAddModules().build();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("42")));
    verify(cacheProvider).forDeserializerCache(isNull());
    verify(cacheProvider).forSerializerCache(isNull());
    verify(cacheProvider).forTypeFactory();
  }

  /**
   * Test {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)} with {@code type}, {@code rosettaObjectMapper}, {@code input}.
   * <ul>
   *   <li>When {@code List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JsonDataLoaderUtil.readTypeList(Class, ObjectMapper, Reader)"})
  public void testReadTypeListWithTypeRosettaObjectMapperInput_whenJavaUtilList() {
    // Arrange
    Class<List> type = List.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("foo")));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)} with {@code type}, {@code rosettaObjectMapper}, {@code input}.
   * <ul>
   *   <li>When {@code List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JsonDataLoaderUtil.readTypeList(Class, ObjectMapper, Reader)"})
  public void testReadTypeListWithTypeRosettaObjectMapperInput_whenJavaUtilList2() {
    // Arrange
    Class<List> type = List.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("42")));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)} with {@code type}, {@code rosettaObjectMapper}, {@code input}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JsonDataLoaderUtil.readTypeList(Class, ObjectMapper, Reader)"})
  public void testReadTypeListWithTypeRosettaObjectMapperInput_whenStringReaderWith42() {
    // Arrange
    Class<Object> type = Object.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("42")));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)} with {@code type}, {@code rosettaObjectMapper}, {@code input}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JsonDataLoaderUtil.readTypeList(Class, ObjectMapper, Reader)"})
  public void testReadTypeListWithTypeRosettaObjectMapperInput_whenStringReaderWithEmptyString() {
    // Arrange
    Class<Object> type = Object.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("")));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)} with {@code type}, {@code rosettaObjectMapper}, {@code input}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JsonDataLoaderUtil.readTypeList(Class, ObjectMapper, Reader)"})
  public void testReadTypeListWithTypeRosettaObjectMapperInput_whenStringReaderWithFoo() {
    // Arrange
    Class<Object> type = Object.class;
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("foo")));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, URL)} with {@code type}, {@code rosettaObjectMapper}, {@code url}.
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, URL)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JsonDataLoaderUtil.readTypeList(Class, ObjectMapper, URL)"})
  public void testReadTypeListWithTypeRosettaObjectMapperUrl() throws MalformedURLException {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, JsonMapper.builder().findAndAddModules().build(),
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, URL)} with {@code type}, {@code rosettaObjectMapper}, {@code url}.
   * <ul>
   *   <li>When {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, URL)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JsonDataLoaderUtil.readTypeList(Class, ObjectMapper, URL)"})
  public void testReadTypeListWithTypeRosettaObjectMapperUrl_whenJavaLangObject() throws MalformedURLException {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, JsonMapper.builder().findAndAddModules().build(),
            Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL()));
  }

  /**
   * Test {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, URL)} with {@code type}, {@code rosettaObjectMapper}, {@code url}.
   * <ul>
   *   <li>When {@code List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, URL)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JsonDataLoaderUtil.readTypeList(Class, ObjectMapper, URL)"})
  public void testReadTypeListWithTypeRosettaObjectMapperUrl_whenJavaUtilList() throws MalformedURLException {
    // Arrange
    Class<List> type = List.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, JsonMapper.builder().findAndAddModules().build(),
            Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL()));
  }

  /**
   * Test {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}.
   * <ul>
   *   <li>Given {@code List}.</li>
   *   <li>When builder addMixIn {@link List} and {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonDataLoaderUtil.fromObject(Object, Class, ObjectMapper)"})
  public void testFromObject_givenJavaUtilList_whenBuilderAddMixInListAndObject() {
    // Arrange
    Class<Object> type = Object.class;
    Builder builderResult = JsonMapper.builder();
    Class<List> target = List.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);

    // Act
    Object actualFromObjectResult = JsonDataLoaderUtil.fromObject(QualificationReport.SUCCESS, type,
        builderResult.findAndAddModules().build());

    // Assert
    assertEquals(4, ((Map<String, Object>) actualFromObjectResult).size());
    Object getResult = ((Map<String, Object>) actualFromObjectResult).get("results");
    assertTrue(getResult instanceof List);
    assertTrue(actualFromObjectResult instanceof Map);
    assertNull(((Map<String, Object>) actualFromObjectResult).get("ingestedObject"));
    assertEquals(0,
        ((Integer) ((Map<String, Object>) actualFromObjectResult).get("qualifiableObjectsCount")).intValue());
    assertEquals(0,
        ((Integer) ((Map<String, Object>) actualFromObjectResult).get("uniquelyQualifiedObjectsCount")).intValue());
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}.
   * <ul>
   *   <li>Given {@code List}.</li>
   *   <li>When builder addMixIn {@link Object} and {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonDataLoaderUtil.fromObject(Object, Class, ObjectMapper)"})
  public void testFromObject_givenJavaUtilList_whenBuilderAddMixInObjectAndList() {
    // Arrange
    Class<Object> type = Object.class;
    Builder builderResult = JsonMapper.builder();
    Class<Object> target = Object.class;
    Class<List> mixinSource = List.class;
    builderResult.addMixIn(target, mixinSource);

    // Act
    Object actualFromObjectResult = JsonDataLoaderUtil.fromObject(QualificationReport.SUCCESS, type,
        builderResult.findAndAddModules().build());

    // Assert
    assertEquals(4, ((Map<String, Object>) actualFromObjectResult).size());
    Object getResult = ((Map<String, Object>) actualFromObjectResult).get("results");
    assertTrue(getResult instanceof List);
    assertTrue(actualFromObjectResult instanceof Map);
    assertNull(((Map<String, Object>) actualFromObjectResult).get("ingestedObject"));
    assertEquals(0,
        ((Integer) ((Map<String, Object>) actualFromObjectResult).get("qualifiableObjectsCount")).intValue());
    assertEquals(0,
        ((Integer) ((Map<String, Object>) actualFromObjectResult).get("uniquelyQualifiedObjectsCount")).intValue());
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}.
   * <ul>
   *   <li>Then return size is six.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonDataLoaderUtil.fromObject(Object, Class, ObjectMapper)"})
  public void testFromObject_thenReturnSizeIsSix() {
    // Arrange
    ProjectionDataItemExpectation projectionDataItemExpectation = new ProjectionDataItemExpectation("Input File", "42",
        "Output File", 1, true, true);

    Class<Object> type = Object.class;

    // Act
    Object actualFromObjectResult = JsonDataLoaderUtil.fromObject(projectionDataItemExpectation, type,
        JsonMapper.builder().findAndAddModules().build());

    // Assert
    assertTrue(actualFromObjectResult instanceof Map);
    assertEquals(6, ((Map<String, Object>) actualFromObjectResult).size());
    assertEquals("42", ((Map<String, Object>) actualFromObjectResult).get("keyValueFile"));
    assertEquals("Input File", ((Map<String, Object>) actualFromObjectResult).get("inputFile"));
    assertEquals("Output File", ((Map<String, Object>) actualFromObjectResult).get("outputFile"));
    assertEquals(1, ((Integer) ((Map<String, Object>) actualFromObjectResult).get("validationFailures")).intValue());
    assertTrue((Boolean) ((Map<String, Object>) actualFromObjectResult).get("error"));
    assertTrue((Boolean) ((Map<String, Object>) actualFromObjectResult).get("validXml"));
  }

  /**
   * Test {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}.
   * <ul>
   *   <li>When builder addMixIn {@link Object} and {@link Object}.</li>
   *   <li>Then return size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonDataLoaderUtil.fromObject(Object, Class, ObjectMapper)"})
  public void testFromObject_whenBuilderAddMixInObjectAndObject_thenReturnSizeIsFour() {
    // Arrange
    Class<Object> type = Object.class;
    Builder builderResult = JsonMapper.builder();
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);

    // Act
    Object actualFromObjectResult = JsonDataLoaderUtil.fromObject(QualificationReport.SUCCESS, type,
        builderResult.findAndAddModules().build());

    // Assert
    assertEquals(4, ((Map<String, Object>) actualFromObjectResult).size());
    Object getResult = ((Map<String, Object>) actualFromObjectResult).get("results");
    assertTrue(getResult instanceof List);
    assertTrue(actualFromObjectResult instanceof Map);
    assertNull(((Map<String, Object>) actualFromObjectResult).get("ingestedObject"));
    assertEquals(0,
        ((Integer) ((Map<String, Object>) actualFromObjectResult).get("qualifiableObjectsCount")).intValue());
    assertEquals(0,
        ((Integer) ((Map<String, Object>) actualFromObjectResult).get("uniquelyQualifiedObjectsCount")).intValue());
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonDataLoaderUtil.fromObject(Object, Class, ObjectMapper)"})
  public void testFromObject_whenFortyTwo_thenReturnIntValueIsFortyTwo() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(42,
        ((Integer) JsonDataLoaderUtil.fromObject(42, type, JsonMapper.builder().findAndAddModules().build()))
            .intValue());
  }

  /**
   * Test {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonDataLoaderUtil.fromObject(Object, Class, ObjectMapper)"})
  public void testFromObject_whenJavaLangObject_thenReturnJavaLangObject() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals("java.lang.Object",
        JsonDataLoaderUtil.fromObject(forNameResult, type, JsonMapper.builder().findAndAddModules().build()));
  }

  /**
   * Test {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}.
   * <ul>
   *   <li>When {@code List}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonDataLoaderUtil.fromObject(Object, Class, ObjectMapper)"})
  public void testFromObject_whenJavaUtilList_thenThrowRuntimeException() {
    // Arrange
    Class<List> type = List.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.fromObject(QualificationReport.SUCCESS, type,
        JsonMapper.builder().findAndAddModules().build()));
  }

  /**
   * Test {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}.
   * <ul>
   *   <li>When {@link QualificationReport#SUCCESS}.</li>
   *   <li>Then return size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object JsonDataLoaderUtil.fromObject(Object, Class, ObjectMapper)"})
  public void testFromObject_whenSuccess_thenReturnSizeIsFour() {
    // Arrange
    Class<Object> type = Object.class;

    // Act
    Object actualFromObjectResult = JsonDataLoaderUtil.fromObject(QualificationReport.SUCCESS, type,
        JsonMapper.builder().findAndAddModules().build());

    // Assert
    assertEquals(4, ((Map<String, Object>) actualFromObjectResult).size());
    Object getResult = ((Map<String, Object>) actualFromObjectResult).get("results");
    assertTrue(getResult instanceof List);
    assertTrue(actualFromObjectResult instanceof Map);
    assertNull(((Map<String, Object>) actualFromObjectResult).get("ingestedObject"));
    assertEquals(0,
        ((Integer) ((Map<String, Object>) actualFromObjectResult).get("qualifiableObjectsCount")).intValue());
    assertEquals(0,
        ((Integer) ((Map<String, Object>) actualFromObjectResult).get("uniquelyQualifiedObjectsCount")).intValue());
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test {@link JsonDataLoaderUtil#openURL(URL)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is empty string toUri toURL.</li>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#openURL(URL)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional JsonDataLoaderUtil.openURL(URL)"})
  public void testOpenURL_whenPropertyIsJavaIoTmpdirIsEmptyStringToUriToURL_thenReturnPresent()
      throws MalformedURLException {
    // Arrange and Act
    Optional<Reader> actualOpenURLResult = JsonDataLoaderUtil
        .openURL(Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL());

    // Assert
    assertTrue(actualOpenURLResult.isPresent());
  }

  /**
   * Test {@link JsonDataLoaderUtil#openURL(URL)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt} toUri toURL.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#openURL(URL)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional JsonDataLoaderUtil.openURL(URL)"})
  public void testOpenURL_whenPropertyIsJavaIoTmpdirIsTestTxtToUriToURL_thenReturnNotPresent()
      throws MalformedURLException {
    // Arrange and Act
    Optional<Reader> actualOpenURLResult = JsonDataLoaderUtil
        .openURL(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());

    // Assert
    assertFalse(actualOpenURLResult.isPresent());
  }

  /**
   * Test {@link JsonDataLoaderUtil#loadClass(String, ClassLoader)}.
   * <ul>
   *   <li>When {@code List}.</li>
   *   <li>Then return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#loadClass(String, ClassLoader)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JsonDataLoaderUtil.loadClass(String, ClassLoader)"})
  public void testLoadClass_whenJavaUtilList_thenReturnList() {
    // Arrange and Act
    Class<?> actualLoadClassResult = JsonDataLoaderUtil.loadClass("java.util.List", new MLet());

    // Assert
    Class<List> expectedLoadClassResult = List.class;
    assertEquals(expectedLoadClassResult, actualLoadClassResult);
  }

  /**
   * Test {@link JsonDataLoaderUtil#loadClass(String, ClassLoader)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonDataLoaderUtil#loadClass(String, ClassLoader)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JsonDataLoaderUtil.loadClass(String, ClassLoader)"})
  public void testLoadClass_whenType_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.loadClass("Type", new MLet()));
  }
}
