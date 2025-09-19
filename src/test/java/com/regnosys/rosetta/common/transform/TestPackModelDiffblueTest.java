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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.transform.TestPackModel.SampleModel;
import com.regnosys.rosetta.common.transform.TestPackModel.SampleModel.Assertions;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TestPackModelDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TestPackModel.<init>(String, String, String, List)",
    "String TestPackModel.getId()",
    "String TestPackModel.getName()",
    "String TestPackModel.getPipelineId()",
    "List TestPackModel.getSamples()",
    "String TestPackModel.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ArrayList<SampleModel> samples = new ArrayList<>();

    // Act
    TestPackModel actualTestPackModel = new TestPackModel("42", "42", "Name", samples);
    String actualToStringResult = actualTestPackModel.toString();
    String actualId = actualTestPackModel.getId();
    String actualName = actualTestPackModel.getName();
    String actualPipelineId = actualTestPackModel.getPipelineId();
    List<SampleModel> actualSamples = actualTestPackModel.getSamples();

    // Assert
    assertEquals("42", actualId);
    assertEquals("42", actualPipelineId);
    assertEquals("Name", actualName);
    assertEquals(
        "TestPackModel{id='42', pipelineId='42', name='Name', samples=[]}", actualToStringResult);
    assertTrue(actualSamples.isEmpty());
    assertSame(samples, actualSamples);
  }

  /**
   * Test {@link TestPackModel#equals(Object)}, and {@link TestPackModel#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TestPackModel#equals(Object)}
   *   <li>{@link TestPackModel#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TestPackModel.equals(Object)", "int TestPackModel.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TestPackModel createTestPackResult =
        TestPackUtils.createTestPack(
            "Test Pack Name",
            TransformType.PRE_TRANSLATE,
            "Formatted Function Name",
            new ArrayList<>());
    TestPackModel createTestPackResult2 =
        TestPackUtils.createTestPack(
            "Test Pack Name",
            TransformType.PRE_TRANSLATE,
            "Formatted Function Name",
            new ArrayList<>());

    // Act and Assert
    assertEquals(createTestPackResult, createTestPackResult2);
    assertEquals(createTestPackResult.hashCode(), createTestPackResult2.hashCode());
  }

  /**
   * Test {@link TestPackModel#equals(Object)}, and {@link TestPackModel#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TestPackModel#equals(Object)}
   *   <li>{@link TestPackModel#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TestPackModel.equals(Object)", "int TestPackModel.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TestPackModel createTestPackResult =
        TestPackUtils.createTestPack(
            "Test Pack Name",
            TransformType.PRE_TRANSLATE,
            "Formatted Function Name",
            new ArrayList<>());

    // Act and Assert
    assertEquals(createTestPackResult, createTestPackResult);
    int expectedHashCodeResult = createTestPackResult.hashCode();
    assertEquals(expectedHashCodeResult, createTestPackResult.hashCode());
  }

  /**
   * Test {@link TestPackModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TestPackModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TestPackModel.equals(Object)", "int TestPackModel.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TestPackModel testPackModel = new TestPackModel("42", "42", "Name", new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        testPackModel,
        TestPackUtils.createTestPack(
            "Test Pack Name",
            TransformType.PRE_TRANSLATE,
            "Formatted Function Name",
            new ArrayList<>()));
  }

  /**
   * Test {@link TestPackModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TestPackModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TestPackModel.equals(Object)", "int TestPackModel.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<SampleModel> sampleModels = new ArrayList<>();
    SampleModel sampleModel =
        new SampleModel("42", "Name", "Input Path", "Output Path", new Assertions(1, true, true));
    sampleModels.add(sampleModel);
    TestPackModel createTestPackResult =
        TestPackUtils.createTestPack(
            "Test Pack Name", TransformType.PRE_TRANSLATE, "Formatted Function Name", sampleModels);

    // Act and Assert
    assertNotEquals(
        createTestPackResult,
        TestPackUtils.createTestPack(
            "Test Pack Name",
            TransformType.PRE_TRANSLATE,
            "Formatted Function Name",
            new ArrayList<>()));
  }

  /**
   * Test {@link TestPackModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TestPackModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TestPackModel.equals(Object)", "int TestPackModel.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TestPackModel testPackModel = new TestPackModel("42", "Pipeline Id", "Name", new ArrayList<>());

    // Act and Assert
    assertNotEquals(testPackModel, new TestPackModel("42", "42", "Name", new ArrayList<>()));
  }

  /**
   * Test {@link TestPackModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TestPackModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TestPackModel.equals(Object)", "int TestPackModel.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TestPackModel testPackModel =
        new TestPackModel(
            "42", "42", "com.regnosys.rosetta.common.transform.TestPackModel", new ArrayList<>());

    // Act and Assert
    assertNotEquals(testPackModel, new TestPackModel("42", "42", "Name", new ArrayList<>()));
  }

  /**
   * Test {@link TestPackModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TestPackModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TestPackModel.equals(Object)", "int TestPackModel.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        TestPackUtils.createTestPack(
            "Test Pack Name",
            TransformType.PRE_TRANSLATE,
            "Formatted Function Name",
            new ArrayList<>()),
        null);
  }

  /**
   * Test {@link TestPackModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TestPackModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TestPackModel.equals(Object)", "int TestPackModel.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        TestPackUtils.createTestPack(
            "Test Pack Name",
            TransformType.PRE_TRANSLATE,
            "Formatted Function Name",
            new ArrayList<>()),
        "Different type to TestPackModel");
  }

  /**
   * Test SampleModel {@link SampleModel#equals(Object)}, and {@link SampleModel#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SampleModel#equals(Object)}
   *   <li>{@link SampleModel#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test SampleModel equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SampleModel.equals(Object)", "int SampleModel.hashCode()"})
  void testSampleModelEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SampleModel sampleModel =
        new SampleModel("42", "Name", "Input Path", "Output Path", new Assertions(1, true, true));
    SampleModel sampleModel2 =
        new SampleModel("42", "Name", "Input Path", "Output Path", new Assertions(1, true, true));

    // Act and Assert
    assertEquals(sampleModel, sampleModel2);
    assertEquals(sampleModel.hashCode(), sampleModel2.hashCode());
  }

  /**
   * Test SampleModel {@link SampleModel#equals(Object)}, and {@link SampleModel#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SampleModel#equals(Object)}
   *   <li>{@link SampleModel#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test SampleModel equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SampleModel.equals(Object)", "int SampleModel.hashCode()"})
  void testSampleModelEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SampleModel sampleModel =
        new SampleModel("42", "Name", "Input Path", "Output Path", new Assertions(1, true, true));

    // Act and Assert
    assertEquals(sampleModel, sampleModel);
    int expectedHashCodeResult = sampleModel.hashCode();
    assertEquals(expectedHashCodeResult, sampleModel.hashCode());
  }

  /**
   * Test SampleModel {@link SampleModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SampleModel#equals(Object)}
   */
  @Test
  @DisplayName("Test SampleModel equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SampleModel.equals(Object)", "int SampleModel.hashCode()"})
  void testSampleModelEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SampleModel sampleModel =
        new SampleModel("Id", "Name", "Input Path", "Output Path", new Assertions(1, true, true));

    // Act and Assert
    assertNotEquals(
        sampleModel,
        new SampleModel("42", "Name", "Input Path", "Output Path", new Assertions(1, true, true)));
  }

  /**
   * Test SampleModel {@link SampleModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SampleModel#equals(Object)}
   */
  @Test
  @DisplayName("Test SampleModel equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SampleModel.equals(Object)", "int SampleModel.hashCode()"})
  void testSampleModelEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SampleModel sampleModel =
        new SampleModel(
            "42",
            "com.regnosys.rosetta.common.transform.TestPackModel$SampleModel",
            "Input Path",
            "Output Path",
            new Assertions(1, true, true));

    // Act and Assert
    assertNotEquals(
        sampleModel,
        new SampleModel("42", "Name", "Input Path", "Output Path", new Assertions(1, true, true)));
  }

  /**
   * Test SampleModel {@link SampleModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SampleModel#equals(Object)}
   */
  @Test
  @DisplayName("Test SampleModel equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SampleModel.equals(Object)", "int SampleModel.hashCode()"})
  void testSampleModelEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SampleModel sampleModel =
        new SampleModel(
            "42",
            "Name",
            "com.regnosys.rosetta.common.transform.TestPackModel$SampleModel",
            "Output Path",
            new Assertions(1, true, true));

    // Act and Assert
    assertNotEquals(
        sampleModel,
        new SampleModel("42", "Name", "Input Path", "Output Path", new Assertions(1, true, true)));
  }

  /**
   * Test SampleModel {@link SampleModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SampleModel#equals(Object)}
   */
  @Test
  @DisplayName("Test SampleModel equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SampleModel.equals(Object)", "int SampleModel.hashCode()"})
  void testSampleModelEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SampleModel sampleModel =
        new SampleModel(
            "42",
            "Name",
            "Input Path",
            "com.regnosys.rosetta.common.transform.TestPackModel$SampleModel",
            new Assertions(1, true, true));

    // Act and Assert
    assertNotEquals(
        sampleModel,
        new SampleModel("42", "Name", "Input Path", "Output Path", new Assertions(1, true, true)));
  }

  /**
   * Test SampleModel {@link SampleModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SampleModel#equals(Object)}
   */
  @Test
  @DisplayName("Test SampleModel equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SampleModel.equals(Object)", "int SampleModel.hashCode()"})
  void testSampleModelEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SampleModel sampleModel =
        new SampleModel("42", "Name", "Input Path", "Output Path", new Assertions(2, true, true));

    // Act and Assert
    assertNotEquals(
        sampleModel,
        new SampleModel("42", "Name", "Input Path", "Output Path", new Assertions(1, true, true)));
  }

  /**
   * Test SampleModel {@link SampleModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SampleModel#equals(Object)}
   */
  @Test
  @DisplayName("Test SampleModel equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SampleModel.equals(Object)", "int SampleModel.hashCode()"})
  void testSampleModelEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new SampleModel("42", "Name", "Input Path", "Output Path", new Assertions(1, true, true)),
        null);
  }

  /**
   * Test SampleModel {@link SampleModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SampleModel#equals(Object)}
   */
  @Test
  @DisplayName("Test SampleModel equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SampleModel.equals(Object)", "int SampleModel.hashCode()"})
  void testSampleModelEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new SampleModel("42", "Name", "Input Path", "Output Path", new Assertions(1, true, true)),
        "Different type to SampleModel");
  }

  /**
   * Test SampleModel getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SampleModel#SampleModel(String, String, String, String, Assertions)}
   *   <li>{@link SampleModel#toString()}
   *   <li>{@link SampleModel#getAssertions()}
   *   <li>{@link SampleModel#getId()}
   *   <li>{@link SampleModel#getInputPath()}
   *   <li>{@link SampleModel#getName()}
   *   <li>{@link SampleModel#getOutputPath()}
   * </ul>
   */
  @Test
  @DisplayName("Test SampleModel getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SampleModel.<init>(String, String, String, String, Assertions)",
    "Assertions SampleModel.getAssertions()",
    "String SampleModel.getId()",
    "String SampleModel.getInputPath()",
    "String SampleModel.getName()",
    "String SampleModel.getOutputPath()",
    "String SampleModel.toString()"
  })
  void testSampleModelGettersAndSetters() {
    // Arrange
    Assertions assertions = new Assertions(1, true, true);

    // Act
    SampleModel actualSampleModel =
        new SampleModel("42", "Name", "Input Path", "Output Path", assertions);
    String actualToStringResult = actualSampleModel.toString();
    Assertions actualAssertions = actualSampleModel.getAssertions();
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
   * Test SampleModel_Assertions {@link Assertions#equals(Object)}, and {@link
   * Assertions#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Assertions#equals(Object)}
   *   <li>{@link Assertions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test SampleModel_Assertions equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Assertions.equals(Object)", "int Assertions.hashCode()"})
  void testSampleModel_AssertionsEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Assertions assertions = new Assertions(1, true, true);
    Assertions assertions2 = new Assertions(1, true, true);

    // Act and Assert
    assertEquals(assertions, assertions2);
    assertEquals(assertions.hashCode(), assertions2.hashCode());
  }

  /**
   * Test SampleModel_Assertions {@link Assertions#equals(Object)}, and {@link
   * Assertions#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Assertions#equals(Object)}
   *   <li>{@link Assertions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test SampleModel_Assertions equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Assertions.equals(Object)", "int Assertions.hashCode()"})
  void testSampleModel_AssertionsEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Assertions assertions = new Assertions(1, true, true);

    // Act and Assert
    assertEquals(assertions, assertions);
    int expectedHashCodeResult = assertions.hashCode();
    assertEquals(expectedHashCodeResult, assertions.hashCode());
  }

  /**
   * Test SampleModel_Assertions {@link Assertions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Assertions#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test SampleModel_Assertions equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Assertions.equals(Object)", "int Assertions.hashCode()"})
  void testSampleModel_AssertionsEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Assertions assertions = new Assertions(2, true, true);

    // Act and Assert
    assertNotEquals(assertions, new Assertions(1, true, true));
  }

  /**
   * Test SampleModel_Assertions {@link Assertions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Assertions#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test SampleModel_Assertions equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Assertions.equals(Object)", "int Assertions.hashCode()"})
  void testSampleModel_AssertionsEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Assertions assertions = new Assertions(1, false, true);

    // Act and Assert
    assertNotEquals(assertions, new Assertions(1, true, true));
  }

  /**
   * Test SampleModel_Assertions {@link Assertions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Assertions#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test SampleModel_Assertions equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Assertions.equals(Object)", "int Assertions.hashCode()"})
  void testSampleModel_AssertionsEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Assertions assertions = new Assertions(1, true, false);

    // Act and Assert
    assertNotEquals(assertions, new Assertions(1, true, true));
  }

  /**
   * Test SampleModel_Assertions {@link Assertions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Assertions#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test SampleModel_Assertions equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Assertions.equals(Object)", "int Assertions.hashCode()"})
  void testSampleModel_AssertionsEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Assertions(1, true, true), null);
  }

  /**
   * Test SampleModel_Assertions {@link Assertions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Assertions#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test SampleModel_Assertions equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Assertions.equals(Object)", "int Assertions.hashCode()"})
  void testSampleModel_AssertionsEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Assertions(1, true, true), "Different type to Assertions");
  }

  /**
   * Test SampleModel_Assertions getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Assertions#Assertions(Integer, Boolean, Boolean)}
   *   <li>{@link Assertions#toString()}
   *   <li>{@link Assertions#getModelValidationFailures()}
   *   <li>{@link Assertions#isRuntimeError()}
   *   <li>{@link Assertions#isSchemaValidationFailure()}
   * </ul>
   */
  @Test
  @DisplayName("Test SampleModel_Assertions getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Assertions.<init>(Integer, Boolean, Boolean)",
    "Integer Assertions.getModelValidationFailures()",
    "Boolean Assertions.isRuntimeError()",
    "Boolean Assertions.isSchemaValidationFailure()",
    "String Assertions.toString()"
  })
  void testSampleModel_AssertionsGettersAndSetters() {
    // Arrange and Act
    Assertions actualAssertions = new Assertions(1, true, true);
    String actualToStringResult = actualAssertions.toString();
    Integer actualModelValidationFailures = actualAssertions.getModelValidationFailures();
    Boolean actualIsRuntimeErrorResult = actualAssertions.isRuntimeError();
    Boolean actualIsSchemaValidationFailureResult = actualAssertions.isSchemaValidationFailure();

    // Assert
    assertEquals(
        "Assertions{modelValidationFailures=1, schemaValidationFailure=true, runtimeError=true}",
        actualToStringResult);
    assertEquals(1, actualModelValidationFailures.intValue());
    assertTrue(actualIsRuntimeErrorResult);
    assertTrue(actualIsSchemaValidationFailureResult);
  }
}
