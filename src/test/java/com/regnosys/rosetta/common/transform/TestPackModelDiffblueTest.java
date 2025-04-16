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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.transform.TestPackModel.SampleModel;
import com.regnosys.rosetta.common.transform.TestPackModel.SampleModel.Assertions;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TestPackModelDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TestPackModel.<init>(String, String, String, List)", "String TestPackModel.getId()",
      "String TestPackModel.getName()", "String TestPackModel.getPipelineId()", "List TestPackModel.getSamples()",
      "String TestPackModel.toString()"})
  public void testGettersAndSetters() {
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
    assertEquals("TestPackModel{id='42', pipelineId='42', name='Name', samples=[]}", actualToStringResult);
    assertTrue(actualSamples.isEmpty());
    assertSame(samples, actualSamples);
  }

  /**
   * Test {@link TestPackModel#equals(Object)}, and {@link TestPackModel#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TestPackModel#equals(Object)}
   *   <li>{@link TestPackModel#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TestPackModel.equals(Object)", "int TestPackModel.hashCode()"})
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
   * Test {@link TestPackModel#equals(Object)}, and {@link TestPackModel#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TestPackModel#equals(Object)}
   *   <li>{@link TestPackModel#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TestPackModel.equals(Object)", "int TestPackModel.hashCode()"})
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
   * Test {@link TestPackModel#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TestPackModel#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TestPackModel.equals(Object)", "int TestPackModel.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TestPackModel createTestPackResult = TestPackUtils.createTestPack("config", TransformType.PRE_TRANSLATE,
        "Formatted Function Name", new ArrayList<>());

    // Act and Assert
    assertNotEquals(createTestPackResult, TestPackUtils.createTestPack("Test Pack Name", TransformType.PRE_TRANSLATE,
        "Formatted Function Name", new ArrayList<>()));
  }

  /**
   * Test {@link TestPackModel#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TestPackModel#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TestPackModel.equals(Object)", "int TestPackModel.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<SampleModel> sampleModels = new ArrayList<>();
    sampleModels.add(new SampleModel("42", "Name", "Input Path", "Output Path", new Assertions(1, true, true)));
    TestPackModel createTestPackResult = TestPackUtils.createTestPack("Test Pack Name", TransformType.PRE_TRANSLATE,
        "Formatted Function Name", sampleModels);

    // Act and Assert
    assertNotEquals(createTestPackResult, TestPackUtils.createTestPack("Test Pack Name", TransformType.PRE_TRANSLATE,
        "Formatted Function Name", new ArrayList<>()));
  }

  /**
   * Test {@link TestPackModel#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TestPackModel#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TestPackModel.equals(Object)", "int TestPackModel.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TestPackUtils.createTestPack("Test Pack Name", TransformType.PRE_TRANSLATE,
        "Formatted Function Name", new ArrayList<>()), null);
  }

  /**
   * Test {@link TestPackModel#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TestPackModel#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TestPackModel.equals(Object)", "int TestPackModel.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TestPackUtils.createTestPack("Test Pack Name", TransformType.PRE_TRANSLATE,
        "Formatted Function Name", new ArrayList<>()), "Different type to TestPackModel");
  }

  /**
   * Test SampleModel {@link SampleModel#equals(Object)}, and {@link SampleModel#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SampleModel#equals(Object)}
   *   <li>{@link SampleModel#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SampleModel.equals(Object)", "int SampleModel.hashCode()"})
  public void testSampleModelEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SampleModel sampleModel = new SampleModel("42", "Name", "Input Path", "Output Path", new Assertions(1, true, true));
    SampleModel sampleModel2 = new SampleModel("42", "Name", "Input Path", "Output Path",
        new Assertions(1, true, true));

    // Act and Assert
    assertEquals(sampleModel, sampleModel2);
    int expectedHashCodeResult = sampleModel.hashCode();
    assertEquals(expectedHashCodeResult, sampleModel2.hashCode());
  }

  /**
   * Test SampleModel {@link SampleModel#equals(Object)}, and {@link SampleModel#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SampleModel#equals(Object)}
   *   <li>{@link SampleModel#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SampleModel.equals(Object)", "int SampleModel.hashCode()"})
  public void testSampleModelEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SampleModel sampleModel = new SampleModel("42", "Name", "Input Path", "Output Path", new Assertions(1, true, true));

    // Act and Assert
    assertEquals(sampleModel, sampleModel);
    int expectedHashCodeResult = sampleModel.hashCode();
    assertEquals(expectedHashCodeResult, sampleModel.hashCode());
  }

  /**
   * Test SampleModel {@link SampleModel#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampleModel#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SampleModel.equals(Object)", "int SampleModel.hashCode()"})
  public void testSampleModelEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SampleModel sampleModel = new SampleModel("Id", "Name", "Input Path", "Output Path", new Assertions(1, true, true));

    // Act and Assert
    assertNotEquals(sampleModel,
        new SampleModel("42", "Name", "Input Path", "Output Path", new Assertions(1, true, true)));
  }

  /**
   * Test SampleModel {@link SampleModel#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampleModel#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SampleModel.equals(Object)", "int SampleModel.hashCode()"})
  public void testSampleModelEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SampleModel sampleModel = new SampleModel("42", "com.regnosys.rosetta.common.transform.TestPackModel$SampleModel",
        "Input Path", "Output Path", new Assertions(1, true, true));

    // Act and Assert
    assertNotEquals(sampleModel,
        new SampleModel("42", "Name", "Input Path", "Output Path", new Assertions(1, true, true)));
  }

  /**
   * Test SampleModel {@link SampleModel#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampleModel#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SampleModel.equals(Object)", "int SampleModel.hashCode()"})
  public void testSampleModelEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SampleModel sampleModel = new SampleModel("42", "Name",
        "com.regnosys.rosetta.common.transform.TestPackModel$SampleModel", "Output Path",
        new Assertions(1, true, true));

    // Act and Assert
    assertNotEquals(sampleModel,
        new SampleModel("42", "Name", "Input Path", "Output Path", new Assertions(1, true, true)));
  }

  /**
   * Test SampleModel {@link SampleModel#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampleModel#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SampleModel.equals(Object)", "int SampleModel.hashCode()"})
  public void testSampleModelEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SampleModel sampleModel = new SampleModel("42", "Name", "Input Path",
        "com.regnosys.rosetta.common.transform.TestPackModel$SampleModel", new Assertions(1, true, true));

    // Act and Assert
    assertNotEquals(sampleModel,
        new SampleModel("42", "Name", "Input Path", "Output Path", new Assertions(1, true, true)));
  }

  /**
   * Test SampleModel {@link SampleModel#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampleModel#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SampleModel.equals(Object)", "int SampleModel.hashCode()"})
  public void testSampleModelEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SampleModel sampleModel = new SampleModel("42", "Name", "Input Path", "Output Path", new Assertions(2, true, true));

    // Act and Assert
    assertNotEquals(sampleModel,
        new SampleModel("42", "Name", "Input Path", "Output Path", new Assertions(1, true, true)));
  }

  /**
   * Test SampleModel {@link SampleModel#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampleModel#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SampleModel.equals(Object)", "int SampleModel.hashCode()"})
  public void testSampleModelEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SampleModel("42", "Name", "Input Path", "Output Path", new Assertions(1, true, true)), null);
  }

  /**
   * Test SampleModel {@link SampleModel#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampleModel#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SampleModel.equals(Object)", "int SampleModel.hashCode()"})
  public void testSampleModelEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SampleModel("42", "Name", "Input Path", "Output Path", new Assertions(1, true, true)),
        "Different type to SampleModel");
  }

  /**
   * Test SampleModel getters and setters.
   * <p>
   * Methods under test:
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SampleModel.<init>(String, String, String, String, Assertions)",
      "Assertions SampleModel.getAssertions()", "String SampleModel.getId()", "String SampleModel.getInputPath()",
      "String SampleModel.getName()", "String SampleModel.getOutputPath()", "String SampleModel.toString()"})
  public void testSampleModelGettersAndSetters() {
    // Arrange
    Assertions assertions = new Assertions(1, true, true);

    // Act
    SampleModel actualSampleModel = new SampleModel("42", "Name", "Input Path", "Output Path", assertions);
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
   * Test SampleModel_Assertions {@link Assertions#equals(Object)}, and {@link Assertions#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Assertions#equals(Object)}
   *   <li>{@link Assertions#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Assertions.equals(Object)", "int Assertions.hashCode()"})
  public void testSampleModel_AssertionsEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Assertions assertions = new Assertions(1, true, true);
    Assertions assertions2 = new Assertions(1, true, true);

    // Act and Assert
    assertEquals(assertions, assertions2);
    int expectedHashCodeResult = assertions.hashCode();
    assertEquals(expectedHashCodeResult, assertions2.hashCode());
  }

  /**
   * Test SampleModel_Assertions {@link Assertions#equals(Object)}, and {@link Assertions#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Assertions#equals(Object)}
   *   <li>{@link Assertions#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Assertions.equals(Object)", "int Assertions.hashCode()"})
  public void testSampleModel_AssertionsEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Assertions assertions = new Assertions(1, true, true);

    // Act and Assert
    assertEquals(assertions, assertions);
    int expectedHashCodeResult = assertions.hashCode();
    assertEquals(expectedHashCodeResult, assertions.hashCode());
  }

  /**
   * Test SampleModel_Assertions {@link Assertions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Assertions#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Assertions.equals(Object)", "int Assertions.hashCode()"})
  public void testSampleModel_AssertionsEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Assertions assertions = new Assertions(2, true, true);

    // Act and Assert
    assertNotEquals(assertions, new Assertions(1, true, true));
  }

  /**
   * Test SampleModel_Assertions {@link Assertions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Assertions#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Assertions.equals(Object)", "int Assertions.hashCode()"})
  public void testSampleModel_AssertionsEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Assertions assertions = new Assertions(1, false, true);

    // Act and Assert
    assertNotEquals(assertions, new Assertions(1, true, true));
  }

  /**
   * Test SampleModel_Assertions {@link Assertions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Assertions#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Assertions.equals(Object)", "int Assertions.hashCode()"})
  public void testSampleModel_AssertionsEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Assertions assertions = new Assertions(1, true, false);

    // Act and Assert
    assertNotEquals(assertions, new Assertions(1, true, true));
  }

  /**
   * Test SampleModel_Assertions {@link Assertions#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Assertions#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Assertions.equals(Object)", "int Assertions.hashCode()"})
  public void testSampleModel_AssertionsEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Assertions(1, true, true), null);
  }

  /**
   * Test SampleModel_Assertions {@link Assertions#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Assertions#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Assertions.equals(Object)", "int Assertions.hashCode()"})
  public void testSampleModel_AssertionsEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Assertions(1, true, true), "Different type to Assertions");
  }

  /**
   * Test SampleModel_Assertions getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Assertions#Assertions(Integer, Boolean, Boolean)}
   *   <li>{@link Assertions#toString()}
   *   <li>{@link Assertions#getModelValidationFailures()}
   *   <li>{@link Assertions#isRuntimeError()}
   *   <li>{@link Assertions#isSchemaValidationFailure()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Assertions.<init>(Integer, Boolean, Boolean)",
      "Integer Assertions.getModelValidationFailures()", "Boolean Assertions.isRuntimeError()",
      "Boolean Assertions.isSchemaValidationFailure()", "String Assertions.toString()"})
  public void testSampleModel_AssertionsGettersAndSetters() {
    // Arrange and Act
    Assertions actualAssertions = new Assertions(1, true, true);
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
