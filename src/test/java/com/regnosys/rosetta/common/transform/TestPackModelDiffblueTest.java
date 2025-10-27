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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class TestPackModelDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TestPackModel#equals(Object)}
   *   <li>{@link TestPackModel#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TestPackModel createTestPackResult = TestPackUtils.createTestPack("Test Pack Name", TransformType.PRE_TRANSLATE,
        "Formatted Function Name", new ArrayList<>());
    TestPackModel createTestPackResult2 = TestPackUtils.createTestPack("Test Pack Name", TransformType.PRE_TRANSLATE,
        "Formatted Function Name", new ArrayList<>());

    // Act and Assert
    assertEquals(createTestPackResult, createTestPackResult2);
    int expectedHashCodeResult = createTestPackResult.hashCode();
    assertEquals(expectedHashCodeResult, createTestPackResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TestPackModel#equals(Object)}
   *   <li>{@link TestPackModel#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TestPackModel createTestPackResult = TestPackUtils.createTestPack("Test Pack Name", TransformType.PRE_TRANSLATE,
        "Formatted Function Name", new ArrayList<>());

    // Act and Assert
    assertEquals(createTestPackResult, createTestPackResult);
    int expectedHashCodeResult = createTestPackResult.hashCode();
    assertEquals(expectedHashCodeResult, createTestPackResult.hashCode());
  }

  /**
   * Method under test: {@link TestPackModel#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TestPackModel createTestPackResult = TestPackUtils.createTestPack("config", TransformType.PRE_TRANSLATE,
        "Formatted Function Name", new ArrayList<>());

    // Act and Assert
    assertNotEquals(createTestPackResult, TestPackUtils.createTestPack("Test Pack Name", TransformType.PRE_TRANSLATE,
        "Formatted Function Name", new ArrayList<>()));
  }

  /**
   * Method under test: {@link TestPackModel#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<TestPackModel.SampleModel> sampleModels = new ArrayList<>();
    sampleModels.add(new TestPackModel.SampleModel("42", "Name", "Input Path", "Output Path",
        new TestPackModel.SampleModel.Assertions(1, true, true)));
    TestPackModel createTestPackResult = TestPackUtils.createTestPack("Test Pack Name", TransformType.PRE_TRANSLATE,
        "Formatted Function Name", sampleModels);

    // Act and Assert
    assertNotEquals(createTestPackResult, TestPackUtils.createTestPack("Test Pack Name", TransformType.PRE_TRANSLATE,
        "Formatted Function Name", new ArrayList<>()));
  }

  /**
   * Method under test: {@link TestPackModel#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ArrayList<TestPackModel.SampleModel> sampleModels = new ArrayList<>();
    sampleModels.add(new TestPackModel.SampleModel("42", "Name", "Input Path", "Output Path",
        mock(TestPackModel.SampleModel.Assertions.class)));
    TestPackModel createTestPackResult = TestPackUtils.createTestPack("Test Pack Name", TransformType.PRE_TRANSLATE,
        "Formatted Function Name", sampleModels);

    // Act and Assert
    assertNotEquals(createTestPackResult, TestPackUtils.createTestPack("Test Pack Name", TransformType.PRE_TRANSLATE,
        "Formatted Function Name", new ArrayList<>()));
  }

  /**
   * Method under test: {@link TestPackModel#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TestPackUtils.createTestPack("Test Pack Name", TransformType.PRE_TRANSLATE,
        "Formatted Function Name", new ArrayList<>()), null);
  }

  /**
   * Method under test: {@link TestPackModel#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TestPackUtils.createTestPack("Test Pack Name", TransformType.PRE_TRANSLATE,
        "Formatted Function Name", new ArrayList<>()), "Different type to TestPackModel");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TestPackModel#TestPackModel(String, String, String, List)}
   *   <li>{@link TestPackModel#toString()}
   *   <li>{@link TestPackModel#getId()}
   *   <li>{@link TestPackModel#getName()}
   *   <li>{@link TestPackModel#getPipelineId()}
   *   <li>{@link TestPackModel#getSamples()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ArrayList<TestPackModel.SampleModel> samples = new ArrayList<>();

    // Act
    TestPackModel actualTestPackModel = new TestPackModel("42", "42", "Name", samples);
    String actualToStringResult = actualTestPackModel.toString();
    String actualId = actualTestPackModel.getId();
    String actualName = actualTestPackModel.getName();
    String actualPipelineId = actualTestPackModel.getPipelineId();
    List<TestPackModel.SampleModel> actualSamples = actualTestPackModel.getSamples();

    // Assert
    assertEquals("42", actualId);
    assertEquals("42", actualPipelineId);
    assertEquals("Name", actualName);
    assertEquals("TestPackModel{id='42', pipelineId='42', name='Name', samples=[]}", actualToStringResult);
    assertTrue(actualSamples.isEmpty());
    assertSame(samples, actualSamples);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TestPackModel.SampleModel#equals(Object)}
   *   <li>{@link TestPackModel.SampleModel#hashCode()}
   * </ul>
   */
  @Test
  public void testSampleModelEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TestPackModel.SampleModel sampleModel = new TestPackModel.SampleModel("42", "Name", "Input Path", "Output Path",
        new TestPackModel.SampleModel.Assertions(1, true, true));
    TestPackModel.SampleModel sampleModel2 = new TestPackModel.SampleModel("42", "Name", "Input Path", "Output Path",
        new TestPackModel.SampleModel.Assertions(1, true, true));

    // Act and Assert
    assertEquals(sampleModel, sampleModel2);
    int expectedHashCodeResult = sampleModel.hashCode();
    assertEquals(expectedHashCodeResult, sampleModel2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TestPackModel.SampleModel#equals(Object)}
   *   <li>{@link TestPackModel.SampleModel#hashCode()}
   * </ul>
   */
  @Test
  public void testSampleModelEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TestPackModel.SampleModel sampleModel = new TestPackModel.SampleModel("42", "Name", "Input Path", "Output Path",
        new TestPackModel.SampleModel.Assertions(1, true, true));

    // Act and Assert
    assertEquals(sampleModel, sampleModel);
    int expectedHashCodeResult = sampleModel.hashCode();
    assertEquals(expectedHashCodeResult, sampleModel.hashCode());
  }

  /**
   * Method under test: {@link TestPackModel.SampleModel#equals(Object)}
   */
  @Test
  public void testSampleModelEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TestPackModel.SampleModel sampleModel = new TestPackModel.SampleModel("Id", "Name", "Input Path", "Output Path",
        new TestPackModel.SampleModel.Assertions(1, true, true));

    // Act and Assert
    assertNotEquals(sampleModel, new TestPackModel.SampleModel("42", "Name", "Input Path", "Output Path",
        new TestPackModel.SampleModel.Assertions(1, true, true)));
  }

  /**
   * Method under test: {@link TestPackModel.SampleModel#equals(Object)}
   */
  @Test
  public void testSampleModelEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TestPackModel.SampleModel sampleModel = new TestPackModel.SampleModel("42",
        "com.regnosys.rosetta.common.transform.TestPackModel$SampleModel", "Input Path", "Output Path",
        new TestPackModel.SampleModel.Assertions(1, true, true));

    // Act and Assert
    assertNotEquals(sampleModel, new TestPackModel.SampleModel("42", "Name", "Input Path", "Output Path",
        new TestPackModel.SampleModel.Assertions(1, true, true)));
  }

  /**
   * Method under test: {@link TestPackModel.SampleModel#equals(Object)}
   */
  @Test
  public void testSampleModelEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TestPackModel.SampleModel sampleModel = new TestPackModel.SampleModel("42", "Name",
        "com.regnosys.rosetta.common.transform.TestPackModel$SampleModel", "Output Path",
        new TestPackModel.SampleModel.Assertions(1, true, true));

    // Act and Assert
    assertNotEquals(sampleModel, new TestPackModel.SampleModel("42", "Name", "Input Path", "Output Path",
        new TestPackModel.SampleModel.Assertions(1, true, true)));
  }

  /**
   * Method under test: {@link TestPackModel.SampleModel#equals(Object)}
   */
  @Test
  public void testSampleModelEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TestPackModel.SampleModel sampleModel = new TestPackModel.SampleModel("42", "Name", "Input Path",
        "com.regnosys.rosetta.common.transform.TestPackModel$SampleModel",
        new TestPackModel.SampleModel.Assertions(1, true, true));

    // Act and Assert
    assertNotEquals(sampleModel, new TestPackModel.SampleModel("42", "Name", "Input Path", "Output Path",
        new TestPackModel.SampleModel.Assertions(1, true, true)));
  }

  /**
   * Method under test: {@link TestPackModel.SampleModel#equals(Object)}
   */
  @Test
  public void testSampleModelEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TestPackModel.SampleModel sampleModel = new TestPackModel.SampleModel("42", "Name", "Input Path", "Output Path",
        new TestPackModel.SampleModel.Assertions(2, true, true));

    // Act and Assert
    assertNotEquals(sampleModel, new TestPackModel.SampleModel("42", "Name", "Input Path", "Output Path",
        new TestPackModel.SampleModel.Assertions(1, true, true)));
  }

  /**
   * Method under test: {@link TestPackModel.SampleModel#equals(Object)}
   */
  @Test
  public void testSampleModelEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TestPackModel.SampleModel sampleModel = new TestPackModel.SampleModel("42", "Name", "Input Path", "Output Path",
        mock(TestPackModel.SampleModel.Assertions.class));

    // Act and Assert
    assertNotEquals(sampleModel, new TestPackModel.SampleModel("42", "Name", "Input Path", "Output Path",
        new TestPackModel.SampleModel.Assertions(1, true, true)));
  }

  /**
   * Method under test: {@link TestPackModel.SampleModel#equals(Object)}
   */
  @Test
  public void testSampleModelEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TestPackModel.SampleModel("42", "Name", "Input Path", "Output Path",
        new TestPackModel.SampleModel.Assertions(1, true, true)), null);
  }

  /**
   * Method under test: {@link TestPackModel.SampleModel#equals(Object)}
   */
  @Test
  public void testSampleModelEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TestPackModel.SampleModel("42", "Name", "Input Path", "Output Path",
        new TestPackModel.SampleModel.Assertions(1, true, true)), "Different type to SampleModel");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TestPackModel.SampleModel#SampleModel(String, String, String, String, TestPackModel.SampleModel.Assertions)}
   *   <li>{@link TestPackModel.SampleModel#toString()}
   *   <li>{@link TestPackModel.SampleModel#getAssertions()}
   *   <li>{@link TestPackModel.SampleModel#getId()}
   *   <li>{@link TestPackModel.SampleModel#getInputPath()}
   *   <li>{@link TestPackModel.SampleModel#getName()}
   *   <li>{@link TestPackModel.SampleModel#getOutputPath()}
   * </ul>
   */
  @Test
  public void testSampleModelGettersAndSetters() {
    // Arrange
    TestPackModel.SampleModel.Assertions assertions = new TestPackModel.SampleModel.Assertions(1, true, true);

    // Act
    TestPackModel.SampleModel actualSampleModel = new TestPackModel.SampleModel("42", "Name", "Input Path",
        "Output Path", assertions);
    String actualToStringResult = actualSampleModel.toString();
    TestPackModel.SampleModel.Assertions actualAssertions = actualSampleModel.getAssertions();
    String actualId = actualSampleModel.getId();
    String actualInputPath = actualSampleModel.getInputPath();
    String actualName = actualSampleModel.getName();

    // Assert
    assertEquals("42", actualId);
    assertEquals("Input Path", actualInputPath);
    assertEquals("Name", actualName);
    assertEquals("Output Path", actualSampleModel.getOutputPath());
    assertEquals(
        "SampleModel{id='42', name='Name', inputPath='Input Path', outputPath='Output Path', assertions=Assertions"
            + "{modelValidationFailures=1, schemaValidationFailure=true, runtimeError=true}}",
        actualToStringResult);
    assertSame(assertions, actualAssertions);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TestPackModel.SampleModel.Assertions#equals(Object)}
   *   <li>{@link TestPackModel.SampleModel.Assertions#hashCode()}
   * </ul>
   */
  @Test
  public void testSampleModel_AssertionsEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TestPackModel.SampleModel.Assertions assertions = new TestPackModel.SampleModel.Assertions(1, true, true);
    TestPackModel.SampleModel.Assertions assertions2 = new TestPackModel.SampleModel.Assertions(1, true, true);

    // Act and Assert
    assertEquals(assertions, assertions2);
    int expectedHashCodeResult = assertions.hashCode();
    assertEquals(expectedHashCodeResult, assertions2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TestPackModel.SampleModel.Assertions#equals(Object)}
   *   <li>{@link TestPackModel.SampleModel.Assertions#hashCode()}
   * </ul>
   */
  @Test
  public void testSampleModel_AssertionsEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TestPackModel.SampleModel.Assertions assertions = new TestPackModel.SampleModel.Assertions(1, true, true);

    // Act and Assert
    assertEquals(assertions, assertions);
    int expectedHashCodeResult = assertions.hashCode();
    assertEquals(expectedHashCodeResult, assertions.hashCode());
  }

  /**
   * Method under test:
   * {@link TestPackModel.SampleModel.Assertions#equals(Object)}
   */
  @Test
  public void testSampleModel_AssertionsEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TestPackModel.SampleModel.Assertions assertions = new TestPackModel.SampleModel.Assertions(2, true, true);

    // Act and Assert
    assertNotEquals(assertions, new TestPackModel.SampleModel.Assertions(1, true, true));
  }

  /**
   * Method under test:
   * {@link TestPackModel.SampleModel.Assertions#equals(Object)}
   */
  @Test
  public void testSampleModel_AssertionsEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TestPackModel.SampleModel.Assertions assertions = new TestPackModel.SampleModel.Assertions(1, false, true);

    // Act and Assert
    assertNotEquals(assertions, new TestPackModel.SampleModel.Assertions(1, true, true));
  }

  /**
   * Method under test:
   * {@link TestPackModel.SampleModel.Assertions#equals(Object)}
   */
  @Test
  public void testSampleModel_AssertionsEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TestPackModel.SampleModel.Assertions assertions = new TestPackModel.SampleModel.Assertions(1, true, false);

    // Act and Assert
    assertNotEquals(assertions, new TestPackModel.SampleModel.Assertions(1, true, true));
  }

  /**
   * Method under test:
   * {@link TestPackModel.SampleModel.Assertions#equals(Object)}
   */
  @Test
  public void testSampleModel_AssertionsEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TestPackModel.SampleModel.Assertions(1, true, true), null);
  }

  /**
   * Method under test:
   * {@link TestPackModel.SampleModel.Assertions#equals(Object)}
   */
  @Test
  public void testSampleModel_AssertionsEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TestPackModel.SampleModel.Assertions(1, true, true), "Different type to Assertions");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TestPackModel.SampleModel.Assertions#Assertions(Integer, Boolean, Boolean)}
   *   <li>{@link TestPackModel.SampleModel.Assertions#toString()}
   *   <li>{@link TestPackModel.SampleModel.Assertions#getModelValidationFailures()}
   *   <li>{@link TestPackModel.SampleModel.Assertions#isRuntimeError()}
   *   <li>{@link TestPackModel.SampleModel.Assertions#isSchemaValidationFailure()}
   * </ul>
   */
  @Test
  public void testSampleModel_AssertionsGettersAndSetters() {
    // Arrange and Act
    TestPackModel.SampleModel.Assertions actualAssertions = new TestPackModel.SampleModel.Assertions(1, true, true);
    String actualToStringResult = actualAssertions.toString();
    Integer actualModelValidationFailures = actualAssertions.getModelValidationFailures();
    Boolean actualIsRuntimeErrorResult = actualAssertions.isRuntimeError();
    Boolean actualIsSchemaValidationFailureResult = actualAssertions.isSchemaValidationFailure();

    // Assert
    assertEquals("Assertions{modelValidationFailures=1, schemaValidationFailure=true, runtimeError=true}",
        actualToStringResult);
    assertEquals(1, actualModelValidationFailures.intValue());
    assertTrue(actualIsRuntimeErrorResult);
    assertTrue(actualIsSchemaValidationFailureResult);
  }
}
