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
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class PipelineModelDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PipelineModel#equals(Object)}
   *   <li>{@link PipelineModel#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PipelineModel.Serialisation inputSerialisation = new PipelineModel.Serialisation(
        PipelineModel.Serialisation.Format.JSON, "Config Path");

    PipelineModel createPipelineResult = TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE,
        "Function Qualified Name", "Display Name", "Formatted Function Name", "Input Type", "Output Type", "42",
        inputSerialisation, new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path"));
    PipelineModel.Serialisation inputSerialisation2 = new PipelineModel.Serialisation(
        PipelineModel.Serialisation.Format.JSON, "Config Path");

    PipelineModel createPipelineResult2 = TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE,
        "Function Qualified Name", "Display Name", "Formatted Function Name", "Input Type", "Output Type", "42",
        inputSerialisation2, new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path"));

    // Act and Assert
    assertEquals(createPipelineResult, createPipelineResult2);
    int expectedHashCodeResult = createPipelineResult.hashCode();
    assertEquals(expectedHashCodeResult, createPipelineResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PipelineModel#equals(Object)}
   *   <li>{@link PipelineModel#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PipelineModel.Serialisation inputSerialisation = new PipelineModel.Serialisation(
        PipelineModel.Serialisation.Format.JSON, "Config Path");

    PipelineModel createPipelineResult = TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE,
        "Function Qualified Name", "Display Name", "Formatted Function Name", "Input Type", "Output Type", "42",
        inputSerialisation, new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path"));

    // Act and Assert
    assertEquals(createPipelineResult, createPipelineResult);
    int expectedHashCodeResult = createPipelineResult.hashCode();
    assertEquals(expectedHashCodeResult, createPipelineResult.hashCode());
  }

  /**
   * Method under test: {@link PipelineModel#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PipelineModel.Serialisation inputSerialisation = new PipelineModel.Serialisation(
        PipelineModel.Serialisation.Format.JSON, "Config Path");

    PipelineModel createPipelineResult = TestPackUtils.createPipeline(TransformType.TRANSLATE,
        "Function Qualified Name", "Display Name", "Formatted Function Name", "Input Type", "Output Type", "42",
        inputSerialisation, new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path"));
    PipelineModel.Serialisation inputSerialisation2 = new PipelineModel.Serialisation(
        PipelineModel.Serialisation.Format.JSON, "Config Path");

    // Act and Assert
    assertNotEquals(createPipelineResult,
        TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE, "Function Qualified Name", "Display Name",
            "Formatted Function Name", "Input Type", "Output Type", "42", inputSerialisation2,
            new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path")));
  }

  /**
   * Method under test: {@link PipelineModel#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PipelineModel.Serialisation inputSerialisation = new PipelineModel.Serialisation(
        PipelineModel.Serialisation.Format.JSON, "Config Path");

    PipelineModel createPipelineResult = TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE, null, "Display Name",
        "Formatted Function Name", "Input Type", "Output Type", "42", inputSerialisation,
        new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path"));
    PipelineModel.Serialisation inputSerialisation2 = new PipelineModel.Serialisation(
        PipelineModel.Serialisation.Format.JSON, "Config Path");

    // Act and Assert
    assertNotEquals(createPipelineResult,
        TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE, "Function Qualified Name", "Display Name",
            "Formatted Function Name", "Input Type", "Output Type", "42", inputSerialisation2,
            new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path")));
  }

  /**
   * Method under test: {@link PipelineModel#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PipelineModel.Serialisation inputSerialisation = new PipelineModel.Serialisation(
        PipelineModel.Serialisation.Format.JSON, "Config Path");

    PipelineModel createPipelineResult = TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE,
        "Function Qualified Name", null, "Formatted Function Name", "Input Type", "Output Type", "42",
        inputSerialisation, new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path"));
    PipelineModel.Serialisation inputSerialisation2 = new PipelineModel.Serialisation(
        PipelineModel.Serialisation.Format.JSON, "Config Path");

    // Act and Assert
    assertNotEquals(createPipelineResult,
        TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE, "Function Qualified Name", "Display Name",
            "Formatted Function Name", "Input Type", "Output Type", "42", inputSerialisation2,
            new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path")));
  }

  /**
   * Method under test: {@link PipelineModel#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    PipelineModel.Serialisation inputSerialisation = new PipelineModel.Serialisation(
        PipelineModel.Serialisation.Format.JSON, "Config Path");

    PipelineModel createPipelineResult = TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE,
        "Function Qualified Name", "Display Name", "Formatted Function Name", "Input Type", "Output Type",
        "Upstream Pipeline Id", inputSerialisation,
        new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path"));
    PipelineModel.Serialisation inputSerialisation2 = new PipelineModel.Serialisation(
        PipelineModel.Serialisation.Format.JSON, "Config Path");

    // Act and Assert
    assertNotEquals(createPipelineResult,
        TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE, "Function Qualified Name", "Display Name",
            "Formatted Function Name", "Input Type", "Output Type", "42", inputSerialisation2,
            new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path")));
  }

  /**
   * Method under test: {@link PipelineModel#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    PipelineModel.Serialisation inputSerialisation = new PipelineModel.Serialisation(null, "Config Path");

    PipelineModel createPipelineResult = TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE,
        "Function Qualified Name", "Display Name", "Formatted Function Name", "Input Type", "Output Type", "42",
        inputSerialisation, new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path"));
    PipelineModel.Serialisation inputSerialisation2 = new PipelineModel.Serialisation(
        PipelineModel.Serialisation.Format.JSON, "Config Path");

    // Act and Assert
    assertNotEquals(createPipelineResult,
        TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE, "Function Qualified Name", "Display Name",
            "Formatted Function Name", "Input Type", "Output Type", "42", inputSerialisation2,
            new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path")));
  }

  /**
   * Method under test: {@link PipelineModel#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    PipelineModel.Serialisation inputSerialisation = mock(PipelineModel.Serialisation.class);
    PipelineModel createPipelineResult = TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE,
        "Function Qualified Name", "Display Name", "Formatted Function Name", "Input Type", "Output Type", "42",
        inputSerialisation, new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path"));
    PipelineModel.Serialisation inputSerialisation2 = new PipelineModel.Serialisation(
        PipelineModel.Serialisation.Format.JSON, "Config Path");

    // Act and Assert
    assertNotEquals(createPipelineResult,
        TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE, "Function Qualified Name", "Display Name",
            "Formatted Function Name", "Input Type", "Output Type", "42", inputSerialisation2,
            new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path")));
  }

  /**
   * Method under test: {@link PipelineModel#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    PipelineModel.Serialisation inputSerialisation = new PipelineModel.Serialisation(
        PipelineModel.Serialisation.Format.JSON, "Config Path");

    PipelineModel createPipelineResult = TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE,
        "Function Qualified Name", "Display Name", "Formatted Function Name", "Input Type", "Output Type", "42",
        inputSerialisation, new PipelineModel.Serialisation(null, "Config Path"));
    PipelineModel.Serialisation inputSerialisation2 = new PipelineModel.Serialisation(
        PipelineModel.Serialisation.Format.JSON, "Config Path");

    // Act and Assert
    assertNotEquals(createPipelineResult,
        TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE, "Function Qualified Name", "Display Name",
            "Formatted Function Name", "Input Type", "Output Type", "42", inputSerialisation2,
            new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path")));
  }

  /**
   * Method under test: {@link PipelineModel#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    PipelineModel.Serialisation inputSerialisation = new PipelineModel.Serialisation(
        PipelineModel.Serialisation.Format.JSON, "Config Path");

    // Act and Assert
    assertNotEquals(TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE, "Function Qualified Name", "Display Name",
        "Formatted Function Name", "Input Type", "Output Type", "42", inputSerialisation,
        new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path")), null);
  }

  /**
   * Method under test: {@link PipelineModel#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    PipelineModel.Serialisation inputSerialisation = new PipelineModel.Serialisation(
        PipelineModel.Serialisation.Format.JSON, "Config Path");

    // Act and Assert
    assertNotEquals(
        TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE, "Function Qualified Name", "Display Name",
            "Formatted Function Name", "Input Type", "Output Type", "42", inputSerialisation,
            new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path")),
        "Different type to PipelineModel");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PipelineModel#PipelineModel(String, String, PipelineModel.Transform, String, PipelineModel.Serialisation, PipelineModel.Serialisation)}
   *   <li>{@link PipelineModel#toString()}
   *   <li>{@link PipelineModel#getId()}
   *   <li>{@link PipelineModel#getInputSerialisation()}
   *   <li>{@link PipelineModel#getName()}
   *   <li>{@link PipelineModel#getOutputSerialisation()}
   *   <li>{@link PipelineModel#getTransform()}
   *   <li>{@link PipelineModel#getUpstreamPipelineId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    PipelineModel.Transform transform = new PipelineModel.Transform(TransformType.PRE_TRANSLATE, "Function",
        "Input Type", "Output Type");

    PipelineModel.Serialisation inputSerialisation = new PipelineModel.Serialisation(
        PipelineModel.Serialisation.Format.JSON, "Config Path");

    PipelineModel.Serialisation outputSerialisation = new PipelineModel.Serialisation(
        PipelineModel.Serialisation.Format.JSON, "Config Path");

    // Act
    PipelineModel actualPipelineModel = new PipelineModel("42", "Name", transform, "42", inputSerialisation,
        outputSerialisation);
    String actualToStringResult = actualPipelineModel.toString();
    String actualId = actualPipelineModel.getId();
    PipelineModel.Serialisation actualInputSerialisation = actualPipelineModel.getInputSerialisation();
    String actualName = actualPipelineModel.getName();
    PipelineModel.Serialisation actualOutputSerialisation = actualPipelineModel.getOutputSerialisation();
    PipelineModel.Transform actualTransform = actualPipelineModel.getTransform();

    // Assert
    assertEquals("42", actualId);
    assertEquals("42", actualPipelineModel.getUpstreamPipelineId());
    assertEquals("Name", actualName);
    assertEquals("PipelineModel{id='42', name='Name', transform=Transform{type=PRE_TRANSLATE, function='Function',"
        + " inputType='Input Type', outputType='Output Type'}, upstreamPipelineId='42', inputSerialisation"
        + "=Serialisation{format=JSON, configPath='Config Path'}, outputSerialisation=Serialisation{format=JSON,"
        + " configPath='Config Path'}}", actualToStringResult);
    assertSame(inputSerialisation, actualInputSerialisation);
    assertSame(outputSerialisation, actualOutputSerialisation);
    assertSame(transform, actualTransform);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PipelineModel.Serialisation#equals(Object)}
   *   <li>{@link PipelineModel.Serialisation#hashCode()}
   * </ul>
   */
  @Test
  public void testSerialisationEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PipelineModel.Serialisation serialisation = new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON,
        "Config Path");
    PipelineModel.Serialisation serialisation2 = new PipelineModel.Serialisation(
        PipelineModel.Serialisation.Format.JSON, "Config Path");

    // Act and Assert
    assertEquals(serialisation, serialisation2);
    int expectedHashCodeResult = serialisation.hashCode();
    assertEquals(expectedHashCodeResult, serialisation2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PipelineModel.Serialisation#equals(Object)}
   *   <li>{@link PipelineModel.Serialisation#hashCode()}
   * </ul>
   */
  @Test
  public void testSerialisationEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PipelineModel.Serialisation serialisation = new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON,
        "Config Path");

    // Act and Assert
    assertEquals(serialisation, serialisation);
    int expectedHashCodeResult = serialisation.hashCode();
    assertEquals(expectedHashCodeResult, serialisation.hashCode());
  }

  /**
   * Method under test: {@link PipelineModel.Serialisation#equals(Object)}
   */
  @Test
  public void testSerialisationEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PipelineModel.Serialisation serialisation = new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.XML,
        "Config Path");

    // Act and Assert
    assertNotEquals(serialisation,
        new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path"));
  }

  /**
   * Method under test: {@link PipelineModel.Serialisation#equals(Object)}
   */
  @Test
  public void testSerialisationEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PipelineModel.Serialisation serialisation = new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON,
        "com.regnosys.rosetta.common.transform.PipelineModel$Serialisation");

    // Act and Assert
    assertNotEquals(serialisation,
        new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path"));
  }

  /**
   * Method under test: {@link PipelineModel.Serialisation#equals(Object)}
   */
  @Test
  public void testSerialisationEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path"), null);
  }

  /**
   * Method under test: {@link PipelineModel.Serialisation#equals(Object)}
   */
  @Test
  public void testSerialisationEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path"),
        "Different type to Serialisation");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PipelineModel.Serialisation#Serialisation(PipelineModel.Serialisation.Format, String)}
   *   <li>{@link PipelineModel.Serialisation#toString()}
   *   <li>{@link PipelineModel.Serialisation#getConfigPath()}
   *   <li>{@link PipelineModel.Serialisation#getFormat()}
   * </ul>
   */
  @Test
  public void testSerialisationGettersAndSetters() {
    // Arrange and Act
    PipelineModel.Serialisation actualSerialisation = new PipelineModel.Serialisation(
        PipelineModel.Serialisation.Format.JSON, "Config Path");
    String actualToStringResult = actualSerialisation.toString();
    String actualConfigPath = actualSerialisation.getConfigPath();

    // Assert
    assertEquals("Config Path", actualConfigPath);
    assertEquals("Serialisation{format=JSON, configPath='Config Path'}", actualToStringResult);
    assertEquals(PipelineModel.Serialisation.Format.JSON, actualSerialisation.getFormat());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PipelineModel.Transform#equals(Object)}
   *   <li>{@link PipelineModel.Transform#hashCode()}
   * </ul>
   */
  @Test
  public void testTransformEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PipelineModel.Transform transform = new PipelineModel.Transform(TransformType.PRE_TRANSLATE, "Function",
        "Input Type", "Output Type");
    PipelineModel.Transform transform2 = new PipelineModel.Transform(TransformType.PRE_TRANSLATE, "Function",
        "Input Type", "Output Type");

    // Act and Assert
    assertEquals(transform, transform2);
    int expectedHashCodeResult = transform.hashCode();
    assertEquals(expectedHashCodeResult, transform2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PipelineModel.Transform#equals(Object)}
   *   <li>{@link PipelineModel.Transform#hashCode()}
   * </ul>
   */
  @Test
  public void testTransformEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PipelineModel.Transform transform = new PipelineModel.Transform(TransformType.PRE_TRANSLATE, "Function",
        "Input Type", "Output Type");

    // Act and Assert
    assertEquals(transform, transform);
    int expectedHashCodeResult = transform.hashCode();
    assertEquals(expectedHashCodeResult, transform.hashCode());
  }

  /**
   * Method under test: {@link PipelineModel.Transform#equals(Object)}
   */
  @Test
  public void testTransformEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PipelineModel.Transform transform = new PipelineModel.Transform(TransformType.TRANSLATE, "Function", "Input Type",
        "Output Type");

    // Act and Assert
    assertNotEquals(transform,
        new PipelineModel.Transform(TransformType.PRE_TRANSLATE, "Function", "Input Type", "Output Type"));
  }

  /**
   * Method under test: {@link PipelineModel.Transform#equals(Object)}
   */
  @Test
  public void testTransformEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PipelineModel.Transform transform = new PipelineModel.Transform(TransformType.PRE_TRANSLATE,
        "com.regnosys.rosetta.common.transform.PipelineModel$Transform", "Input Type", "Output Type");

    // Act and Assert
    assertNotEquals(transform,
        new PipelineModel.Transform(TransformType.PRE_TRANSLATE, "Function", "Input Type", "Output Type"));
  }

  /**
   * Method under test: {@link PipelineModel.Transform#equals(Object)}
   */
  @Test
  public void testTransformEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PipelineModel.Transform transform = new PipelineModel.Transform(TransformType.PRE_TRANSLATE, "Function",
        "com.regnosys.rosetta.common.transform.PipelineModel$Transform", "Output Type");

    // Act and Assert
    assertNotEquals(transform,
        new PipelineModel.Transform(TransformType.PRE_TRANSLATE, "Function", "Input Type", "Output Type"));
  }

  /**
   * Method under test: {@link PipelineModel.Transform#equals(Object)}
   */
  @Test
  public void testTransformEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    PipelineModel.Transform transform = new PipelineModel.Transform(TransformType.PRE_TRANSLATE, "Function",
        "Input Type", "com.regnosys.rosetta.common.transform.PipelineModel$Transform");

    // Act and Assert
    assertNotEquals(transform,
        new PipelineModel.Transform(TransformType.PRE_TRANSLATE, "Function", "Input Type", "Output Type"));
  }

  /**
   * Method under test: {@link PipelineModel.Transform#equals(Object)}
   */
  @Test
  public void testTransformEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PipelineModel.Transform(TransformType.PRE_TRANSLATE, "Function", "Input Type", "Output Type"),
        null);
  }

  /**
   * Method under test: {@link PipelineModel.Transform#equals(Object)}
   */
  @Test
  public void testTransformEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PipelineModel.Transform(TransformType.PRE_TRANSLATE, "Function", "Input Type", "Output Type"),
        "Different type to Transform");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PipelineModel.Transform#Transform(TransformType, String, String, String)}
   *   <li>{@link PipelineModel.Transform#toString()}
   *   <li>{@link PipelineModel.Transform#getFunction()}
   *   <li>{@link PipelineModel.Transform#getInputType()}
   *   <li>{@link PipelineModel.Transform#getOutputType()}
   *   <li>{@link PipelineModel.Transform#getType()}
   * </ul>
   */
  @Test
  public void testTransformGettersAndSetters() {
    // Arrange and Act
    PipelineModel.Transform actualTransform = new PipelineModel.Transform(TransformType.PRE_TRANSLATE, "Function",
        "Input Type", "Output Type");
    String actualToStringResult = actualTransform.toString();
    String actualFunction = actualTransform.getFunction();
    String actualInputType = actualTransform.getInputType();
    String actualOutputType = actualTransform.getOutputType();

    // Assert
    assertEquals("Function", actualFunction);
    assertEquals("Input Type", actualInputType);
    assertEquals("Output Type", actualOutputType);
    assertEquals("Transform{type=PRE_TRANSLATE, function='Function', inputType='Input Type', outputType='Output Type'}",
        actualToStringResult);
    assertEquals(TransformType.PRE_TRANSLATE, actualTransform.getType());
  }
}
