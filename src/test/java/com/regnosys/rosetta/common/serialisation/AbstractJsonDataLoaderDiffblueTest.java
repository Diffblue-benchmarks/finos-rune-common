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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.CoercionConfigs;
import com.fasterxml.jackson.databind.cfg.ConfigOverrides;
import com.fasterxml.jackson.databind.cfg.DatatypeFeatures;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.jsontype.DefaultBaseTypeLimitingValidator;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import com.regnosys.rosetta.common.serialisation.lookup.JsonLookupDataLoader;
import com.regnosys.rosetta.common.serialisation.mixin.RosettaJSONAnnotationIntrospector;
import com.regnosys.rosetta.common.serialisation.projectiondata.ProjectionDataSet;
import com.regnosys.rosetta.common.serialisation.reportdata.ReportDataItem;
import com.rosetta.model.lib.ModelReportId;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import javax.management.loading.MLet;
import net.bytebuddy.dynamic.loading.ByteArrayClassLoader;
import org.eclipse.core.internal.boot.PlatformURLHandler;
import org.junit.Test;
import org.mockito.Mockito;

public class AbstractJsonDataLoaderDiffblueTest {
  /**
   * Method under test: {@link AbstractJsonDataLoader#load()}
   */
  @Test
  public void testLoad() throws MalformedURLException {
    // Arrange
    MLet classLoader = new MLet();
    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    URL descriptorPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    // Act and Assert
    assertTrue((new JsonLookupDataLoader(classLoader, rosettaObjectMapper, descriptorPath, new ArrayList<>())).load()
        .isEmpty());
  }

  /**
   * Method under test: {@link AbstractJsonDataLoader#load()}
   */
  @Test
  public void testLoad2() throws MalformedURLException {
    // Arrange
    ArrayList<String> descriptorFileNames = new ArrayList<>();
    descriptorFileNames.add("foo");
    MLet classLoader = new MLet();

    // Act and Assert
    assertTrue((new JsonLookupDataLoader(classLoader, new ObjectMapper(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(), descriptorFileNames)).load()
        .isEmpty());
  }

  /**
   * Method under test: {@link AbstractJsonDataLoader#load()}
   */
  @Test
  public void testLoad3() throws MalformedURLException {
    // Arrange
    ArrayList<String> descriptorFileNames = new ArrayList<>();
    descriptorFileNames.add("Resolved URL {}");
    descriptorFileNames.add("foo");
    MLet classLoader = new MLet();

    // Act and Assert
    assertTrue((new JsonLookupDataLoader(classLoader, new ObjectMapper(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(), descriptorFileNames)).load()
        .isEmpty());
  }

  /**
   * Method under test: {@link AbstractJsonDataLoader#load()}
   */
  @Test
  public void testLoad4() throws MalformedURLException {
    // Arrange
    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    rosettaObjectMapper.setConfig(new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class)));
    MLet classLoader = new MLet();
    URL descriptorPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    // Act and Assert
    assertTrue((new JsonLookupDataLoader(classLoader, rosettaObjectMapper, descriptorPath, new ArrayList<>())).load()
        .isEmpty());
  }

  /**
   * Method under test: {@link AbstractJsonDataLoader#resolve(URL, String)}
   */
  @Test
  public void testResolve() throws MalformedURLException {
    // Arrange
    MLet classLoader = new MLet();
    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    URL descriptorPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    // Act
    URL actualResolveResult = (new JsonLookupDataLoader(classLoader, rosettaObjectMapper, descriptorPath,
        new ArrayList<>()))
        .resolve(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(), "Child");

    // Assert
    String expectedToStringResult = String.join("", "file:",
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt", "Child").toString());
    assertEquals(expectedToStringResult, actualResolveResult.toString());
  }

  /**
   * Method under test: {@link AbstractJsonDataLoader#resolve(URL, String)}
   */
  @Test
  public void testResolve2() throws MalformedURLException {
    // Arrange
    URLStreamHandlerFactory urlStreamHandlerFactory = mock(URLStreamHandlerFactory.class);
    when(urlStreamHandlerFactory.createURLStreamHandler(Mockito.<String>any())).thenReturn(new PlatformURLHandler());
    URLClassLoader classLoader = new URLClassLoader(
        new URL[]{Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()}, new MLet(),
        urlStreamHandlerFactory);

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    URL descriptorPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    // Act
    URL actualResolveResult = (new JsonLookupDataLoader(classLoader, rosettaObjectMapper, descriptorPath,
        new ArrayList<>()))
        .resolve(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(), "Child");

    // Assert
    verify(urlStreamHandlerFactory).createURLStreamHandler(eq("jar"));
    String expectedToStringResult = String.join("", "file:",
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt", "Child").toString());
    assertEquals(expectedToStringResult, actualResolveResult.toString());
  }

  /**
   * Method under test:
   * {@link AbstractJsonDataLoader#getInput(String, ReportDataItem, URL)}
   */
  @Test
  public void testGetInput() throws ClassNotFoundException, MalformedURLException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    ByteArrayClassLoader classLoader = mock(ByteArrayClassLoader.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(classLoader.loadClass(Mockito.<String>any())).thenReturn(forNameResult);
    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    URL descriptorPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    JsonLookupDataLoader jsonLookupDataLoader = new JsonLookupDataLoader(classLoader, rosettaObjectMapper,
        descriptorPath, new ArrayList<>());

    // Act
    Object actualInput = jsonLookupDataLoader.getInput("Input Type", new ReportDataItem(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());

    // Assert
    verify(classLoader).loadClass(eq("Input Type"));
    assertNull(actualInput);
  }

  /**
   * Method under test:
   * {@link AbstractJsonDataLoader#getInput(String, ReportDataItem, URL)}
   */
  @Test
  public void testGetInput2() throws ClassNotFoundException, MalformedURLException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    ByteArrayClassLoader classLoader = mock(ByteArrayClassLoader.class);
    Class<AbstractJsonDataLoader> forNameResult = AbstractJsonDataLoader.class;
    Mockito.<Class<?>>when(classLoader.loadClass(Mockito.<String>any())).thenReturn(forNameResult);
    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    URL descriptorPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    JsonLookupDataLoader jsonLookupDataLoader = new JsonLookupDataLoader(classLoader, rosettaObjectMapper,
        descriptorPath, new ArrayList<>());

    // Act
    Object actualInput = jsonLookupDataLoader.getInput("Input Type", new ReportDataItem(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());

    // Assert
    verify(classLoader).loadClass(eq("Input Type"));
    assertNull(actualInput);
  }

  /**
   * Method under test:
   * {@link AbstractJsonDataLoader#getInput(String, ReportDataItem, URL)}
   */
  @Test
  public void testGetInput3() throws ClassNotFoundException, MalformedURLException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    ByteArrayClassLoader classLoader = mock(ByteArrayClassLoader.class);
    Class<ReportDataItem> forNameResult = ReportDataItem.class;
    Mockito.<Class<?>>when(classLoader.loadClass(Mockito.<String>any())).thenReturn(forNameResult);
    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    URL descriptorPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    JsonLookupDataLoader jsonLookupDataLoader = new JsonLookupDataLoader(classLoader, rosettaObjectMapper,
        descriptorPath, new ArrayList<>());

    // Act
    Object actualInput = jsonLookupDataLoader.getInput("Input Type", new ReportDataItem(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());

    // Assert
    verify(classLoader).loadClass(eq("Input Type"));
    assertNull(actualInput);
  }

  /**
   * Method under test:
   * {@link AbstractJsonDataLoader#getInput(String, ReportDataItem, URL)}
   */
  @Test
  public void testGetInput4() throws JsonProcessingException, ClassNotFoundException, MalformedURLException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    ByteArrayClassLoader classLoader = mock(ByteArrayClassLoader.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(classLoader.loadClass(Mockito.<String>any())).thenReturn(forNameResult);
    ObjectMapper rosettaObjectMapper = mock(ObjectMapper.class);
    Class<Object> forNameResult2 = Object.class;
    when(rosettaObjectMapper.readValue(Mockito.<String>any(), Mockito.<Class<Object>>any())).thenReturn(forNameResult2);
    when(rosettaObjectMapper.writeValueAsString(Mockito.<Object>any())).thenReturn("42");
    URL descriptorPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    JsonLookupDataLoader jsonLookupDataLoader = new JsonLookupDataLoader(classLoader, rosettaObjectMapper,
        descriptorPath, new ArrayList<>());

    // Act
    Object actualInput = jsonLookupDataLoader.getInput("Input Type", new ReportDataItem(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());

    // Assert
    verify(rosettaObjectMapper).readValue(eq("42"), isA(Class.class));
    verify(rosettaObjectMapper).writeValueAsString(isNull());
    verify(classLoader).loadClass(eq("Input Type"));
    assertSame(forNameResult2, actualInput);
  }

  /**
   * Method under test: {@link AbstractJsonDataLoader#getDataItem(DataSet, URL)}
   */
  @Test
  public void testGetDataItem() throws MalformedURLException {
    // Arrange
    URLStreamHandlerFactory urlStreamHandlerFactory = mock(URLStreamHandlerFactory.class);
    when(urlStreamHandlerFactory.createURLStreamHandler(Mockito.<String>any())).thenReturn(new PlatformURLHandler());
    URLClassLoader classLoader = new URLClassLoader(
        new URL[]{Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()}, new MLet(),
        urlStreamHandlerFactory);

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    URL descriptorPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    JsonLookupDataLoader jsonLookupDataLoader = new JsonLookupDataLoader(classLoader, rosettaObjectMapper,
        descriptorPath, new ArrayList<>());
    ArrayList<String> applicableProjections = new ArrayList<>();
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    // Act
    List<ReportDataItem> actualDataItem = jsonLookupDataLoader.getDataItem(
        new ProjectionDataSet("Data Set Name", "Data Set Short Name", "Input Type", applicableProjections,
            applicableReports, new ArrayList<>()),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());

    // Assert
    verify(urlStreamHandlerFactory).createURLStreamHandler(eq("jar"));
    assertTrue(actualDataItem.isEmpty());
  }

  /**
   * Method under test: {@link AbstractJsonDataLoader#getDataItem(DataSet, URL)}
   */
  @Test
  public void testGetDataItem2() throws MalformedURLException {
    // Arrange
    URLStreamHandlerFactory urlStreamHandlerFactory = mock(URLStreamHandlerFactory.class);
    when(urlStreamHandlerFactory.createURLStreamHandler(Mockito.<String>any())).thenReturn(new PlatformURLHandler());
    URLClassLoader classLoader = new URLClassLoader(
        new URL[]{Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()}, new MLet(),
        urlStreamHandlerFactory);

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    URL descriptorPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    JsonLookupDataLoader jsonLookupDataLoader = new JsonLookupDataLoader(classLoader, rosettaObjectMapper,
        descriptorPath, new ArrayList<>());

    ArrayList<ReportDataItem> data = new ArrayList<>();
    data.add(new ReportDataItem());
    ArrayList<String> applicableProjections = new ArrayList<>();

    // Act
    List<ReportDataItem> actualDataItem = jsonLookupDataLoader.getDataItem(new ProjectionDataSet("Data Set Name",
        "Data Set Short Name", "Input Type", applicableProjections, new ArrayList<>(), data),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());

    // Assert
    verify(urlStreamHandlerFactory).createURLStreamHandler(eq("jar"));
    assertEquals(data, actualDataItem);
  }

  /**
   * Method under test: {@link AbstractJsonDataLoader#getDataItem(DataSet, URL)}
   */
  @Test
  public void testGetDataItem3() throws MalformedURLException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    URL descriptorPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    JsonLookupDataLoader jsonLookupDataLoader = new JsonLookupDataLoader(null, rosettaObjectMapper, descriptorPath,
        new ArrayList<>());

    ArrayList<ReportDataItem> data = new ArrayList<>();
    data.add(new ReportDataItem());
    ArrayList<String> applicableProjections = new ArrayList<>();

    // Act and Assert
    assertEquals(data,
        jsonLookupDataLoader
            .getDataItem(
                new ProjectionDataSet("Data Set Name", "Data Set Short Name", "Input Type", applicableProjections,
                    new ArrayList<>(), data),
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
  }
}
