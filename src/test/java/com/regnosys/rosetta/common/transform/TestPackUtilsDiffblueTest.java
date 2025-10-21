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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.regnosys.rosetta.common.transform.PipelineModel.Serialisation;
import com.regnosys.rosetta.common.transform.PipelineModel.Serialisation.Format;
import com.regnosys.rosetta.common.transform.PipelineModel.Transform;
import com.regnosys.rosetta.common.transform.TestPackModel.SampleModel;
import com.regnosys.rosetta.common.transform.TestPackModel.SampleModel.Assertions;
import java.io.UncheckedIOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.management.loading.MLet;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TestPackUtilsDiffblueTest {
  /**
   * Test {@link TestPackUtils#createTestPack(String, TransformType, String, List)}.
   * <ul>
   *   <li>Then return Samples is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TestPackUtils#createTestPack(String, TransformType, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TestPackModel TestPackUtils.createTestPack(String, TransformType, String, List)"})
  public void testCreateTestPack_thenReturnSamplesIsArrayList() {
    // Arrange
    ArrayList<SampleModel> sampleModels = new ArrayList<>();
    sampleModels.add(new SampleModel("42", "test-pack-%s-%s-%s", "test-pack-%s-%s-%s", "test-pack-%s-%s-%s",
        new Assertions(1, true, true)));

    // Act and Assert
    assertSame(sampleModels,
        TestPackUtils
            .createTestPack("Test Pack Name", TransformType.PRE_TRANSLATE, "Formatted Function Name", sampleModels)
            .getSamples());
  }

  /**
   * Test {@link TestPackUtils#createTestPack(String, TransformType, String, List)}.
   * <ul>
   *   <li>Then return Samples size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TestPackUtils#createTestPack(String, TransformType, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TestPackModel TestPackUtils.createTestPack(String, TransformType, String, List)"})
  public void testCreateTestPack_thenReturnSamplesSizeIsTwo() {
    // Arrange
    ArrayList<SampleModel> sampleModels = new ArrayList<>();
    sampleModels.add(new SampleModel("42", "test-pack-%s-%s-%s", "test-pack-%s-%s-%s", "test-pack-%s-%s-%s",
        new Assertions(1, true, true)));
    SampleModel sampleModel = new SampleModel("42", "test-pack-%s-%s-%s", "test-pack-%s-%s-%s", "test-pack-%s-%s-%s",
        new Assertions(1, true, true));

    sampleModels.add(sampleModel);

    // Act and Assert
    List<SampleModel> samples = TestPackUtils
        .createTestPack("Test Pack Name", TransformType.PRE_TRANSLATE, "Formatted Function Name", sampleModels)
        .getSamples();
    assertEquals(2, samples.size());
    assertSame(sampleModel, samples.get(1));
  }

  /**
   * Test {@link TestPackUtils#createTestPack(String, TransformType, String, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Name is {@code Test Pack Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TestPackUtils#createTestPack(String, TransformType, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TestPackModel TestPackUtils.createTestPack(String, TransformType, String, List)"})
  public void testCreateTestPack_whenArrayList_thenReturnNameIsTestPackName() {
    // Arrange and Act
    TestPackModel actualCreateTestPackResult = TestPackUtils.createTestPack("Test Pack Name",
        TransformType.PRE_TRANSLATE, "Formatted Function Name", new ArrayList<>());

    // Assert
    assertEquals("Test Pack Name", actualCreateTestPackResult.getName());
    assertEquals("pipeline-pre_translate-Formatted Function Name", actualCreateTestPackResult.getPipelineId());
    assertEquals("test-pack-pre_translate-Formatted Function Name-test-pack-name", actualCreateTestPackResult.getId());
    assertTrue(actualCreateTestPackResult.getSamples().isEmpty());
  }

  /**
   * Test {@link TestPackUtils#createPipeline(TransformType, String, String, String, String, String, String, Serialisation, Serialisation)}.
   * <p>
   * Method under test: {@link TestPackUtils#createPipeline(TransformType, String, String, String, String, String, String, Serialisation, Serialisation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PipelineModel TestPackUtils.createPipeline(TransformType, String, String, String, String, String, String, Serialisation, Serialisation)"})
  public void testCreatePipeline() {
    // Arrange
    Serialisation inputSerialisation = new Serialisation(Format.JSON, "Config Path");

    Serialisation outputSerialisation = new Serialisation(Format.JSON, "Config Path");

    // Act
    PipelineModel actualCreatePipelineResult = TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE,
        "Function Qualified Name", "Display Name", "Formatted Function Name", "Input Type", "Output Type", "42",
        inputSerialisation, outputSerialisation);

    // Assert
    assertEquals("42", actualCreatePipelineResult.getUpstreamPipelineId());
    assertEquals("Display Name", actualCreatePipelineResult.getName());
    Transform transform = actualCreatePipelineResult.getTransform();
    assertEquals("Function Qualified Name", transform.getFunction());
    assertEquals("Input Type", transform.getInputType());
    assertEquals("Output Type", transform.getOutputType());
    assertEquals("pipeline-pre_translate-Formatted Function Name", actualCreatePipelineResult.getId());
    assertEquals(TransformType.PRE_TRANSLATE, transform.getType());
    assertSame(inputSerialisation, actualCreatePipelineResult.getInputSerialisation());
    assertSame(outputSerialisation, actualCreatePipelineResult.getOutputSerialisation());
  }

  /**
   * Test {@link TestPackUtils#getPipelineModels(Path, ClassLoader, ObjectMapper)}.
   * <ul>
   *   <li>When {@link TestPackUtils#INGEST_CONFIG_PATH}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TestPackUtils#getPipelineModels(Path, ClassLoader, ObjectMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List TestPackUtils.getPipelineModels(Path, ClassLoader, ObjectMapper)"})
  public void testGetPipelineModels_whenIngest_config_path_thenReturnEmpty() {
    // Arrange
    MLet classLoader = new MLet();

    // Act
    List<PipelineModel> actualPipelineModels = TestPackUtils.getPipelineModels(TestPackUtils.INGEST_CONFIG_PATH,
        classLoader, JsonMapper.builder().findAndAddModules().build());

    // Assert
    assertTrue(actualPipelineModels.isEmpty());
  }

  /**
   * Test {@link TestPackUtils#getPipelineModel(List, String)}.
   * <p>
   * Method under test: {@link TestPackUtils#getPipelineModel(List, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PipelineModel TestPackUtils.getPipelineModel(List, String)"})
  public void testGetPipelineModel() {
    // Arrange
    ArrayList<PipelineModel> pipelineModels = new ArrayList<>();
    Serialisation inputSerialisation = new Serialisation(Format.JSON, "No PipelineModel found with function name %s");

    pipelineModels
        .add(TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE, "No PipelineModel found with function name %s",
            "No PipelineModel found with function name %s", "No PipelineModel found with function name %s",
            "No PipelineModel found with function name %s", "No PipelineModel found with function name %s", "42",
            inputSerialisation, new Serialisation(Format.JSON, "No PipelineModel found with function name %s")));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TestPackUtils.getPipelineModel(pipelineModels, "Function Name"));
  }

  /**
   * Test {@link TestPackUtils#getPipelineModel(List, String)}.
   * <p>
   * Method under test: {@link TestPackUtils#getPipelineModel(List, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PipelineModel TestPackUtils.getPipelineModel(List, String)"})
  public void testGetPipelineModel2() {
    // Arrange
    ArrayList<PipelineModel> pipelineModels = new ArrayList<>();
    Serialisation inputSerialisation = new Serialisation(Format.JSON, "No PipelineModel found with function name %s");

    pipelineModels
        .add(TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE, "No PipelineModel found with function name %s",
            "No PipelineModel found with function name %s", "No PipelineModel found with function name %s",
            "No PipelineModel found with function name %s", "No PipelineModel found with function name %s", "42",
            inputSerialisation, new Serialisation(Format.JSON, "No PipelineModel found with function name %s")));
    Serialisation inputSerialisation2 = new Serialisation(Format.JSON, "No PipelineModel found with function name %s");

    pipelineModels
        .add(TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE, "No PipelineModel found with function name %s",
            "No PipelineModel found with function name %s", "No PipelineModel found with function name %s",
            "No PipelineModel found with function name %s", "No PipelineModel found with function name %s", "42",
            inputSerialisation2, new Serialisation(Format.JSON, "No PipelineModel found with function name %s")));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TestPackUtils.getPipelineModel(pipelineModels, "Function Name"));
  }

  /**
   * Test {@link TestPackUtils#getPipelineModel(List, String)}.
   * <ul>
   *   <li>Then return UpstreamPipelineId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TestPackUtils#getPipelineModel(List, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PipelineModel TestPackUtils.getPipelineModel(List, String)"})
  public void testGetPipelineModel_thenReturnUpstreamPipelineIdIs42() {
    // Arrange
    ArrayList<PipelineModel> pipelineModels = new ArrayList<>();
    Serialisation inputSerialisation = new Serialisation(Format.JSON, "No PipelineModel found with function name %s");

    Serialisation outputSerialisation = new Serialisation(Format.JSON, "No PipelineModel found with function name %s");

    pipelineModels.add(TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE, "Function Name",
        "No PipelineModel found with function name %s", "No PipelineModel found with function name %s",
        "No PipelineModel found with function name %s", "No PipelineModel found with function name %s", "42",
        inputSerialisation, outputSerialisation));

    // Act
    PipelineModel actualPipelineModel = TestPackUtils.getPipelineModel(pipelineModels, "Function Name");

    // Assert
    assertEquals("42", actualPipelineModel.getUpstreamPipelineId());
    Transform transform = actualPipelineModel.getTransform();
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
   * Test {@link TestPackUtils#getPipelineModel(List, String)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TestPackUtils#getPipelineModel(List, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PipelineModel TestPackUtils.getPipelineModel(List, String)"})
  public void testGetPipelineModel_whenArrayList_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TestPackUtils.getPipelineModel(new ArrayList<>(), "Function Name"));
  }

  /**
   * Test {@link TestPackUtils#getTestPackModels(Path, ClassLoader, ObjectMapper)} with {@code resourcePath}, {@code classLoader}, {@code jsonObjectMapper}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TestPackUtils#getTestPackModels(Path, ClassLoader, ObjectMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List TestPackUtils.getTestPackModels(Path, ClassLoader, ObjectMapper)"})
  public void testGetTestPackModelsWithResourcePathClassLoaderJsonObjectMapper_thenReturnEmpty() {
    // Arrange
    MLet classLoader = new MLet();

    // Act
    List<TestPackModel> actualTestPackModels = TestPackUtils.getTestPackModels(TestPackUtils.INGEST_CONFIG_PATH,
        classLoader, JsonMapper.builder().findAndAddModules().build());

    // Assert
    assertTrue(actualTestPackModels.isEmpty());
  }

  /**
   * Test {@link TestPackUtils#getTestPackModels(List, String)} with {@code testPackModels}, {@code pipelineId}.
   * <p>
   * Method under test: {@link TestPackUtils#getTestPackModels(List, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List TestPackUtils.getTestPackModels(List, String)"})
  public void testGetTestPackModelsWithTestPackModelsPipelineId() {
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
   * Test {@link TestPackUtils#getTestPackModels(List, String)} with {@code testPackModels}, {@code pipelineId}.
   * <p>
   * Method under test: {@link TestPackUtils#getTestPackModels(List, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List TestPackUtils.getTestPackModels(List, String)"})
  public void testGetTestPackModelsWithTestPackModelsPipelineId2() {
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
   * Test {@link TestPackUtils#getTestPackModels(List, String)} with {@code testPackModels}, {@code pipelineId}.
   * <p>
   * Method under test: {@link TestPackUtils#getTestPackModels(List, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List TestPackUtils.getTestPackModels(List, String)"})
  public void testGetTestPackModelsWithTestPackModelsPipelineId3() {
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
   * Test {@link TestPackUtils#getTestPackModels(List, String)} with {@code testPackModels}, {@code pipelineId}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TestPackUtils#getTestPackModels(List, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List TestPackUtils.getTestPackModels(List, String)"})
  public void testGetTestPackModelsWithTestPackModelsPipelineId_thenReturnArrayList() {
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
   * Test {@link TestPackUtils#getTestPackModels(List, String)} with {@code testPackModels}, {@code pipelineId}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TestPackUtils#getTestPackModels(List, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List TestPackUtils.getTestPackModels(List, String)"})
  public void testGetTestPackModelsWithTestPackModelsPipelineId_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<TestPackModel> actualTestPackModels = TestPackUtils.getTestPackModels(new ArrayList<>(), "42");

    // Assert
    assertTrue(actualTestPackModels.isEmpty());
  }

  /**
   * Test {@link TestPackUtils#getObjectMapper(Serialisation)}.
   * <ul>
   *   <li>Then throw {@link UncheckedIOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TestPackUtils#getObjectMapper(Serialisation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional TestPackUtils.getObjectMapper(Serialisation)"})
  public void testGetObjectMapper_thenThrowUncheckedIOException() {
    // Arrange, Act and Assert
    assertThrows(UncheckedIOException.class, () -> TestPackUtils.getObjectMapper(new Serialisation(Format.XML, "")));
  }

  /**
   * Test {@link TestPackUtils#getObjectMapper(Serialisation)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link TestPackUtils#getObjectMapper(Serialisation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional TestPackUtils.getObjectMapper(Serialisation)"})
  public void testGetObjectMapper_whenNull_thenReturnNotPresent() {
    // Arrange and Act
    Optional<ObjectMapper> actualObjectMapper = TestPackUtils.getObjectMapper(null);

    // Assert
    assertFalse(actualObjectMapper.isPresent());
  }

  /**
   * Test {@link TestPackUtils#getObjectMapper(Serialisation)}.
   * <ul>
   *   <li>When {@link Serialisation#Serialisation(Format, String)} with format is {@code JSON} and {@code Config Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TestPackUtils#getObjectMapper(Serialisation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional TestPackUtils.getObjectMapper(Serialisation)"})
  public void testGetObjectMapper_whenSerialisationWithFormatIsJsonAndConfigPath() {
    // Arrange and Act
    Optional<ObjectMapper> actualObjectMapper = TestPackUtils
        .getObjectMapper(new Serialisation(Format.JSON, "Config Path"));

    // Assert
    assertFalse(actualObjectMapper.isPresent());
  }

  /**
   * Test {@link TestPackUtils#getObjectWriter(Serialisation)}.
   * <ul>
   *   <li>Then throw {@link UncheckedIOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TestPackUtils#getObjectWriter(Serialisation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional TestPackUtils.getObjectWriter(Serialisation)"})
  public void testGetObjectWriter_thenThrowUncheckedIOException() {
    // Arrange, Act and Assert
    assertThrows(UncheckedIOException.class, () -> TestPackUtils.getObjectWriter(new Serialisation(Format.XML, "")));
  }

  /**
   * Test {@link TestPackUtils#getObjectWriter(Serialisation)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link TestPackUtils#getObjectWriter(Serialisation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional TestPackUtils.getObjectWriter(Serialisation)"})
  public void testGetObjectWriter_whenNull_thenReturnNotPresent() {
    // Arrange and Act
    Optional<ObjectWriter> actualObjectWriter = TestPackUtils.getObjectWriter(null);

    // Assert
    assertFalse(actualObjectWriter.isPresent());
  }

  /**
   * Test {@link TestPackUtils#getObjectWriter(Serialisation)}.
   * <ul>
   *   <li>When {@link Serialisation#Serialisation(Format, String)} with format is {@code JSON} and {@code Config Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TestPackUtils#getObjectWriter(Serialisation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional TestPackUtils.getObjectWriter(Serialisation)"})
  public void testGetObjectWriter_whenSerialisationWithFormatIsJsonAndConfigPath() {
    // Arrange and Act
    Optional<ObjectWriter> actualObjectWriter = TestPackUtils
        .getObjectWriter(new Serialisation(Format.JSON, "Config Path"));

    // Assert
    assertFalse(actualObjectWriter.isPresent());
  }

  /**
   * Test {@link TestPackUtils#getProjectionTestPackName(String)}.
   * <p>
   * Method under test: {@link TestPackUtils#getProjectionTestPackName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TestPackUtils.getProjectionTestPackName(String)"})
  public void testGetProjectionTestPackName() {
    // Arrange, Act and Assert
    assertEquals("test-pack-projection-42-report-to-iso20022.*\\.json", TestPackUtils.getProjectionTestPackName("42"));
  }

  /**
   * Test {@link TestPackUtils#getReportTestPackName(String)}.
   * <p>
   * Method under test: {@link TestPackUtils#getReportTestPackName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TestPackUtils.getReportTestPackName(String)"})
  public void testGetReportTestPackName() {
    // Arrange, Act and Assert
    assertEquals("test-pack-report-42.*\\.json", TestPackUtils.getReportTestPackName("42"));
  }

  /**
   * Test {@link TestPackUtils#findPaths(Path, ClassLoader, String)}.
   * <ul>
   *   <li>When {@link TestPackUtils#INGEST_CONFIG_PATH}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TestPackUtils#findPaths(Path, ClassLoader, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List TestPackUtils.findPaths(Path, ClassLoader, String)"})
  public void testFindPaths_whenIngest_config_path_thenReturnEmpty() {
    // Arrange and Act
    List<URL> actualFindPathsResult = TestPackUtils.findPaths(TestPackUtils.INGEST_CONFIG_PATH, new MLet(), "foo.txt");

    // Assert
    assertTrue(actualFindPathsResult.isEmpty());
  }

  /**
   * Test {@link TestPackUtils#findPaths(Path, ClassLoader, String)}.
   * <ul>
   *   <li>When {@link TestPackUtils#PROJECTION_CONFIG_PATH_WITHOUT_ISO20022}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TestPackUtils#findPaths(Path, ClassLoader, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List TestPackUtils.findPaths(Path, ClassLoader, String)"})
  public void testFindPaths_whenProjection_config_path_without_iso20022_thenReturnEmpty() {
    // Arrange and Act
    List<URL> actualFindPathsResult = TestPackUtils.findPaths(TestPackUtils.PROJECTION_CONFIG_PATH_WITHOUT_ISO20022,
        new MLet(), "foo.txt");

    // Assert
    assertTrue(actualFindPathsResult.isEmpty());
  }

  /**
   * Test {@link TestPackUtils#readFile(URL, ObjectMapper, Class)}.
   * <ul>
   *   <li>Then throw {@link UncheckedIOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TestPackUtils#readFile(URL, ObjectMapper, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object TestPackUtils.readFile(URL, ObjectMapper, Class)"})
  public void testReadFile_thenThrowUncheckedIOException() throws MalformedURLException {
    // Arrange
    URL u = Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL();
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(UncheckedIOException.class, () -> TestPackUtils.readFile(u, mapper, clazz));
  }

  /**
   * Test {@link TestPackUtils#readFile(URL, ObjectMapper, Class)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt} toUri toURL.</li>
   * </ul>
   * <p>
   * Method under test: {@link TestPackUtils#readFile(URL, ObjectMapper, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object TestPackUtils.readFile(URL, ObjectMapper, Class)"})
  public void testReadFile_whenPropertyIsJavaIoTmpdirIsTestTxtToUriToURL() throws MalformedURLException {
    // Arrange
    URL u = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(UncheckedIOException.class, () -> TestPackUtils.readFile(u, mapper, clazz));
  }
}
