package com.regnosys.rosetta.common.transform;

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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.regnosys.rosetta.common.serialisation.mixin.RosettaJSONAnnotationIntrospector;
import java.io.UncheckedIOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.TimeZone;
import javax.management.loading.MLet;
import org.junit.Test;

public class TestPackUtilsDiffblueTest {
  /**
   * Method under test:
   * {@link TestPackUtils#createTestPack(String, TransformType, String, List)}
   */
  @Test
  public void testCreateTestPack() {
    // Arrange
    ArrayList<TestPackModel.SampleModel> sampleModels = new ArrayList<>();

    // Act
    TestPackModel actualCreateTestPackResult = TestPackUtils.createTestPack("Test Pack Name",
        TransformType.PRE_TRANSLATE, "Formatted Function Name", sampleModels);

    // Assert
    assertEquals("Test Pack Name", actualCreateTestPackResult.getName());
    assertEquals("pipeline-pre_translate-Formatted Function Name", actualCreateTestPackResult.getPipelineId());
    assertEquals("test-pack-pre_translate-Formatted Function Name-test-pack-name", actualCreateTestPackResult.getId());
    List<TestPackModel.SampleModel> samples = actualCreateTestPackResult.getSamples();
    assertTrue(samples.isEmpty());
    assertSame(sampleModels, samples);
  }

  /**
   * Method under test:
   * {@link TestPackUtils#createTestPack(String, TransformType, String, List)}
   */
  @Test
  public void testCreateTestPack2() {
    // Arrange
    ArrayList<TestPackModel.SampleModel> sampleModels = new ArrayList<>();
    sampleModels.add(new TestPackModel.SampleModel("42", "test-pack-%s-%s-%s", "test-pack-%s-%s-%s",
        "test-pack-%s-%s-%s", new TestPackModel.SampleModel.Assertions(1, true, true)));

    // Act
    TestPackModel actualCreateTestPackResult = TestPackUtils.createTestPack("Test Pack Name",
        TransformType.PRE_TRANSLATE, "Formatted Function Name", sampleModels);

    // Assert
    assertEquals("Test Pack Name", actualCreateTestPackResult.getName());
    assertEquals("pipeline-pre_translate-Formatted Function Name", actualCreateTestPackResult.getPipelineId());
    assertEquals("test-pack-pre_translate-Formatted Function Name-test-pack-name", actualCreateTestPackResult.getId());
    assertSame(sampleModels, actualCreateTestPackResult.getSamples());
  }

  /**
   * Method under test:
   * {@link TestPackUtils#createTestPack(String, TransformType, String, List)}
   */
  @Test
  public void testCreateTestPack3() {
    // Arrange
    ArrayList<TestPackModel.SampleModel> sampleModels = new ArrayList<>();
    sampleModels.add(new TestPackModel.SampleModel("42", "test-pack-%s-%s-%s", "test-pack-%s-%s-%s",
        "test-pack-%s-%s-%s", new TestPackModel.SampleModel.Assertions(1, true, true)));
    sampleModels.add(new TestPackModel.SampleModel("42", "test-pack-%s-%s-%s", "test-pack-%s-%s-%s",
        "test-pack-%s-%s-%s", new TestPackModel.SampleModel.Assertions(1, true, true)));

    // Act
    TestPackModel actualCreateTestPackResult = TestPackUtils.createTestPack("Test Pack Name",
        TransformType.PRE_TRANSLATE, "Formatted Function Name", sampleModels);

    // Assert
    assertEquals("Test Pack Name", actualCreateTestPackResult.getName());
    assertEquals("pipeline-pre_translate-Formatted Function Name", actualCreateTestPackResult.getPipelineId());
    assertEquals("test-pack-pre_translate-Formatted Function Name-test-pack-name", actualCreateTestPackResult.getId());
    assertSame(sampleModels, actualCreateTestPackResult.getSamples());
  }

  /**
   * Method under test:
   * {@link TestPackUtils#createPipeline(TransformType, String, String, String, String, String, String, PipelineModel.Serialisation, PipelineModel.Serialisation)}
   */
  @Test
  public void testCreatePipeline() {
    // Arrange
    PipelineModel.Serialisation inputSerialisation = new PipelineModel.Serialisation(
        PipelineModel.Serialisation.Format.JSON, "Config Path");

    PipelineModel.Serialisation outputSerialisation = new PipelineModel.Serialisation(
        PipelineModel.Serialisation.Format.JSON, "Config Path");

    // Act
    PipelineModel actualCreatePipelineResult = TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE,
        "Function Qualified Name", "Display Name", "Formatted Function Name", "Input Type", "Output Type", "42",
        inputSerialisation, outputSerialisation);

    // Assert
    assertEquals("42", actualCreatePipelineResult.getUpstreamPipelineId());
    assertEquals("Display Name", actualCreatePipelineResult.getName());
    PipelineModel.Transform transform = actualCreatePipelineResult.getTransform();
    assertEquals("Function Qualified Name", transform.getFunction());
    assertEquals("Input Type", transform.getInputType());
    assertEquals("Output Type", transform.getOutputType());
    assertEquals("pipeline-pre_translate-Formatted Function Name", actualCreatePipelineResult.getId());
    assertEquals(TransformType.PRE_TRANSLATE, transform.getType());
    assertSame(inputSerialisation, actualCreatePipelineResult.getInputSerialisation());
    assertSame(outputSerialisation, actualCreatePipelineResult.getOutputSerialisation());
  }

  /**
   * Method under test:
   * {@link TestPackUtils#getPipelineModels(Path, ClassLoader, ObjectMapper)}
   */
  @Test
  public void testGetPipelineModels() {
    // Arrange
    MLet classLoader = new MLet();

    // Act
    List<PipelineModel> actualPipelineModels = TestPackUtils.getPipelineModels(TestPackUtils.INGEST_CONFIG_PATH,
        classLoader, new ObjectMapper());

    // Assert
    assertTrue(actualPipelineModels.isEmpty());
  }

  /**
   * Method under test:
   * {@link TestPackUtils#getPipelineModels(Path, ClassLoader, ObjectMapper)}
   */
  @Test
  public void testGetPipelineModels2() {
    // Arrange
    MLet classLoader = new MLet();

    ObjectMapper jsonObjectMapper = new ObjectMapper();
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
    jsonObjectMapper.setConfig(new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class)));

    // Act
    List<PipelineModel> actualPipelineModels = TestPackUtils.getPipelineModels(TestPackUtils.INGEST_CONFIG_PATH,
        classLoader, jsonObjectMapper);

    // Assert
    assertTrue(actualPipelineModels.isEmpty());
  }

  /**
   * Method under test: {@link TestPackUtils#getPipelineModel(List, String)}
   */
  @Test
  public void testGetPipelineModel() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TestPackUtils.getPipelineModel(new ArrayList<>(), "Function Name"));
  }

  /**
   * Method under test: {@link TestPackUtils#getPipelineModel(List, String)}
   */
  @Test
  public void testGetPipelineModel2() {
    // Arrange
    ArrayList<PipelineModel> pipelineModels = new ArrayList<>();
    PipelineModel.Serialisation inputSerialisation = new PipelineModel.Serialisation(
        PipelineModel.Serialisation.Format.JSON, "No PipelineModel found with function name %s");

    pipelineModels
        .add(TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE, "No PipelineModel found with function name %s",
            "No PipelineModel found with function name %s", "No PipelineModel found with function name %s",
            "No PipelineModel found with function name %s", "No PipelineModel found with function name %s", "42",
            inputSerialisation, new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON,
                "No PipelineModel found with function name %s")));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TestPackUtils.getPipelineModel(pipelineModels, "Function Name"));
  }

  /**
   * Method under test: {@link TestPackUtils#getPipelineModel(List, String)}
   */
  @Test
  public void testGetPipelineModel3() {
    // Arrange
    ArrayList<PipelineModel> pipelineModels = new ArrayList<>();
    PipelineModel.Serialisation inputSerialisation = new PipelineModel.Serialisation(
        PipelineModel.Serialisation.Format.JSON, "No PipelineModel found with function name %s");

    pipelineModels
        .add(TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE, "No PipelineModel found with function name %s",
            "No PipelineModel found with function name %s", "No PipelineModel found with function name %s",
            "No PipelineModel found with function name %s", "No PipelineModel found with function name %s", "42",
            inputSerialisation, new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON,
                "No PipelineModel found with function name %s")));
    PipelineModel.Serialisation inputSerialisation2 = new PipelineModel.Serialisation(
        PipelineModel.Serialisation.Format.JSON, "No PipelineModel found with function name %s");

    pipelineModels
        .add(TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE, "No PipelineModel found with function name %s",
            "No PipelineModel found with function name %s", "No PipelineModel found with function name %s",
            "No PipelineModel found with function name %s", "No PipelineModel found with function name %s", "42",
            inputSerialisation2, new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON,
                "No PipelineModel found with function name %s")));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TestPackUtils.getPipelineModel(pipelineModels, "Function Name"));
  }

  /**
   * Method under test: {@link TestPackUtils#getPipelineModel(List, String)}
   */
  @Test
  public void testGetPipelineModel4() {
    // Arrange
    ArrayList<PipelineModel> pipelineModels = new ArrayList<>();
    PipelineModel.Serialisation inputSerialisation = new PipelineModel.Serialisation(
        PipelineModel.Serialisation.Format.JSON, "No PipelineModel found with function name %s");

    PipelineModel.Serialisation outputSerialisation = new PipelineModel.Serialisation(
        PipelineModel.Serialisation.Format.JSON, "No PipelineModel found with function name %s");

    pipelineModels.add(TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE, "Function Name",
        "No PipelineModel found with function name %s", "No PipelineModel found with function name %s",
        "No PipelineModel found with function name %s", "No PipelineModel found with function name %s", "42",
        inputSerialisation, outputSerialisation));

    // Act
    PipelineModel actualPipelineModel = TestPackUtils.getPipelineModel(pipelineModels, "Function Name");

    // Assert
    assertEquals("42", actualPipelineModel.getUpstreamPipelineId());
    PipelineModel.Transform transform = actualPipelineModel.getTransform();
    assertEquals("Function Name", transform.getFunction());
    assertEquals("No PipelineModel found with function name %s", actualPipelineModel.getName());
    assertEquals("No PipelineModel found with function name %s", transform.getInputType());
    assertEquals("No PipelineModel found with function name %s", transform.getOutputType());
    assertEquals("pipeline-pre_translate-No PipelineModel found with function name %s", actualPipelineModel.getId());
    assertEquals(TransformType.PRE_TRANSLATE, transform.getType());
    assertSame(inputSerialisation, actualPipelineModel.getInputSerialisation());
    assertSame(outputSerialisation, actualPipelineModel.getOutputSerialisation());
  }

  /**
   * Method under test:
   * {@link TestPackUtils#getTestPackModels(Path, ClassLoader, ObjectMapper)}
   */
  @Test
  public void testGetTestPackModels() {
    // Arrange
    MLet classLoader = new MLet();

    // Act
    List<TestPackModel> actualTestPackModels = TestPackUtils.getTestPackModels(TestPackUtils.INGEST_CONFIG_PATH,
        classLoader, new ObjectMapper());

    // Assert
    assertTrue(actualTestPackModels.isEmpty());
  }

  /**
   * Method under test:
   * {@link TestPackUtils#getTestPackModels(Path, ClassLoader, ObjectMapper)}
   */
  @Test
  public void testGetTestPackModels2() {
    // Arrange
    MLet classLoader = new MLet();

    ObjectMapper jsonObjectMapper = new ObjectMapper();
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
    jsonObjectMapper.setConfig(new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class)));

    // Act
    List<TestPackModel> actualTestPackModels = TestPackUtils.getTestPackModels(TestPackUtils.INGEST_CONFIG_PATH,
        classLoader, jsonObjectMapper);

    // Assert
    assertTrue(actualTestPackModels.isEmpty());
  }

  /**
   * Method under test: {@link TestPackUtils#getTestPackModels(List, String)}
   */
  @Test
  public void testGetTestPackModels3() {
    // Arrange and Act
    List<TestPackModel> actualTestPackModels = TestPackUtils.getTestPackModels(new ArrayList<>(), "42");

    // Assert
    assertTrue(actualTestPackModels.isEmpty());
  }

  /**
   * Method under test: {@link TestPackUtils#getTestPackModels(List, String)}
   */
  @Test
  public void testGetTestPackModels4() {
    // Arrange
    ArrayList<TestPackModel> testPackModels = new ArrayList<>();
    testPackModels.add(TestPackUtils.createTestPack("Test Pack Name", TransformType.PRE_TRANSLATE,
        "Formatted Function Name", new ArrayList<>()));

    // Act
    List<TestPackModel> actualTestPackModels = TestPackUtils.getTestPackModels(testPackModels, "42");

    // Assert
    assertTrue(actualTestPackModels.isEmpty());
  }

  /**
   * Method under test: {@link TestPackUtils#getTestPackModels(List, String)}
   */
  @Test
  public void testGetTestPackModels5() {
    // Arrange
    ArrayList<TestPackModel> testPackModels = new ArrayList<>();
    testPackModels.add(TestPackUtils.createTestPack("pipeline-pre_translate-Formatted Function Name",
        TransformType.PRE_TRANSLATE, "pipeline-pre_translate-Formatted Function Name", new ArrayList<>()));
    testPackModels.add(TestPackUtils.createTestPack("Test Pack Name", TransformType.PRE_TRANSLATE,
        "Formatted Function Name", new ArrayList<>()));

    // Act
    List<TestPackModel> actualTestPackModels = TestPackUtils.getTestPackModels(testPackModels, "42");

    // Assert
    assertTrue(actualTestPackModels.isEmpty());
  }

  /**
   * Method under test: {@link TestPackUtils#getTestPackModels(List, String)}
   */
  @Test
  public void testGetTestPackModels6() {
    // Arrange
    ArrayList<TestPackModel> testPackModels = new ArrayList<>();
    testPackModels
        .add(new TestPackModel("42", "42", "pipeline-pre_translate-Formatted Function Name", new ArrayList<>()));

    // Act
    List<TestPackModel> actualTestPackModels = TestPackUtils.getTestPackModels(testPackModels, "42");

    // Assert
    assertEquals(testPackModels, actualTestPackModels);
  }

  /**
   * Method under test: {@link TestPackUtils#getTestPackModels(List, String)}
   */
  @Test
  public void testGetTestPackModels7() {
    // Arrange
    ArrayList<TestPackModel> testPackModels = new ArrayList<>();
    testPackModels
        .add(new TestPackModel("42", null, "pipeline-pre_translate-Formatted Function Name", new ArrayList<>()));

    // Act
    List<TestPackModel> actualTestPackModels = TestPackUtils.getTestPackModels(testPackModels, "42");

    // Assert
    assertTrue(actualTestPackModels.isEmpty());
  }

  /**
   * Method under test:
   * {@link TestPackUtils#getObjectMapper(PipelineModel.Serialisation)}
   */
  @Test
  public void testGetObjectMapper() {
    // Arrange and Act
    Optional<ObjectMapper> actualObjectMapper = TestPackUtils
        .getObjectMapper(new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path"));

    // Assert
    assertFalse(actualObjectMapper.isPresent());
  }

  /**
   * Method under test:
   * {@link TestPackUtils#getObjectMapper(PipelineModel.Serialisation)}
   */
  @Test
  public void testGetObjectMapper2() {
    // Arrange and Act
    Optional<ObjectMapper> actualObjectMapper = TestPackUtils.getObjectMapper(null);

    // Assert
    assertFalse(actualObjectMapper.isPresent());
  }

  /**
   * Method under test:
   * {@link TestPackUtils#getObjectMapper(PipelineModel.Serialisation)}
   */
  @Test
  public void testGetObjectMapper3() {
    // Arrange, Act and Assert
    assertThrows(UncheckedIOException.class, () -> TestPackUtils
        .getObjectMapper(new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.XML, "")));
  }

  /**
   * Method under test:
   * {@link TestPackUtils#getObjectWriter(PipelineModel.Serialisation)}
   */
  @Test
  public void testGetObjectWriter() {
    // Arrange and Act
    Optional<ObjectWriter> actualObjectWriter = TestPackUtils
        .getObjectWriter(new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path"));

    // Assert
    assertFalse(actualObjectWriter.isPresent());
  }

  /**
   * Method under test:
   * {@link TestPackUtils#getObjectWriter(PipelineModel.Serialisation)}
   */
  @Test
  public void testGetObjectWriter2() {
    // Arrange and Act
    Optional<ObjectWriter> actualObjectWriter = TestPackUtils.getObjectWriter(null);

    // Assert
    assertFalse(actualObjectWriter.isPresent());
  }

  /**
   * Method under test:
   * {@link TestPackUtils#getObjectWriter(PipelineModel.Serialisation)}
   */
  @Test
  public void testGetObjectWriter3() {
    // Arrange, Act and Assert
    assertThrows(UncheckedIOException.class, () -> TestPackUtils
        .getObjectWriter(new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.XML, "")));
  }

  /**
   * Method under test: {@link TestPackUtils#getProjectionTestPackName(String)}
   */
  @Test
  public void testGetProjectionTestPackName() {
    // Arrange, Act and Assert
    assertEquals("test-pack-projection-42-report-to-iso20022.*\\.json", TestPackUtils.getProjectionTestPackName("42"));
  }

  /**
   * Method under test: {@link TestPackUtils#getReportTestPackName(String)}
   */
  @Test
  public void testGetReportTestPackName() {
    // Arrange, Act and Assert
    assertEquals("test-pack-report-42.*\\.json", TestPackUtils.getReportTestPackName("42"));
  }

  /**
   * Method under test: {@link TestPackUtils#findPaths(Path, ClassLoader, String)}
   */
  @Test
  public void testFindPaths() {
    // Arrange and Act
    List<URL> actualFindPathsResult = TestPackUtils.findPaths(TestPackUtils.INGEST_CONFIG_PATH, new MLet(), "foo.txt");

    // Assert
    assertTrue(actualFindPathsResult.isEmpty());
  }

  /**
   * Method under test: {@link TestPackUtils#findPaths(Path, ClassLoader, String)}
   */
  @Test
  public void testFindPaths2() {
    // Arrange and Act
    List<URL> actualFindPathsResult = TestPackUtils.findPaths(TestPackUtils.PROJECTION_CONFIG_PATH_WITHOUT_ISO20022,
        new MLet(), "foo.txt");

    // Assert
    assertTrue(actualFindPathsResult.isEmpty());
  }

  /**
   * Method under test: {@link TestPackUtils#readFile(URL, ObjectMapper, Class)}
   */
  @Test
  public void testReadFile() throws MalformedURLException {
    // Arrange
    URL u = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    ObjectMapper mapper = new ObjectMapper();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(UncheckedIOException.class, () -> TestPackUtils.readFile(u, mapper, clazz));
  }

  /**
   * Method under test: {@link TestPackUtils#readFile(URL, ObjectMapper, Class)}
   */
  @Test
  public void testReadFile2() throws MalformedURLException {
    // Arrange
    URL u = Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL();
    ObjectMapper mapper = new ObjectMapper();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(UncheckedIOException.class, () -> TestPackUtils.readFile(u, mapper, clazz));
  }

  /**
   * Method under test: {@link TestPackUtils#readFile(URL, ObjectMapper, Class)}
   */
  @Test
  public void testReadFile3() throws MalformedURLException {
    // Arrange
    URL u = Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL();
    XmlMapper mapper = new XmlMapper();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(UncheckedIOException.class, () -> TestPackUtils.readFile(u, mapper, clazz));
  }
}
