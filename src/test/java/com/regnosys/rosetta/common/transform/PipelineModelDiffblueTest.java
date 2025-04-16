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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.transform.PipelineModel.Serialisation;
import com.regnosys.rosetta.common.transform.PipelineModel.Serialisation.Format;
import com.regnosys.rosetta.common.transform.PipelineModel.Transform;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PipelineModelDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PipelineModel#PipelineModel(String, String, Transform, String, Serialisation, Serialisation)}
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PipelineModel.<init>(String, String, Transform, String, Serialisation, Serialisation)",
      "String PipelineModel.getId()", "Serialisation PipelineModel.getInputSerialisation()",
      "String PipelineModel.getName()", "Serialisation PipelineModel.getOutputSerialisation()",
      "Transform PipelineModel.getTransform()", "String PipelineModel.getUpstreamPipelineId()",
      "String PipelineModel.toString()"})
  public void testGettersAndSetters() {
    // Arrange
    Transform transform = new Transform(TransformType.PRE_TRANSLATE, "Function", "Input Type", "Output Type");

    Serialisation inputSerialisation = new Serialisation(Format.JSON, "Config Path");

    Serialisation outputSerialisation = new Serialisation(Format.JSON, "Config Path");

    // Act
    PipelineModel actualPipelineModel = new PipelineModel("42", "Name", transform, "42", inputSerialisation,
        outputSerialisation);
    String actualToStringResult = actualPipelineModel.toString();
    String actualId = actualPipelineModel.getId();
    Serialisation actualInputSerialisation = actualPipelineModel.getInputSerialisation();
    String actualName = actualPipelineModel.getName();
    Serialisation actualOutputSerialisation = actualPipelineModel.getOutputSerialisation();
    Transform actualTransform = actualPipelineModel.getTransform();

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
   * Test {@link PipelineModel#equals(Object)}, and {@link PipelineModel#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PipelineModel#equals(Object)}
   *   <li>{@link PipelineModel#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PipelineModel.equals(Object)", "int PipelineModel.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Serialisation inputSerialisation = new Serialisation(Format.JSON, "Config Path");

    PipelineModel createPipelineResult = TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE,
        "Function Qualified Name", "Display Name", "Formatted Function Name", "Input Type", "Output Type", "42",
        inputSerialisation, new Serialisation(Format.JSON, "Config Path"));
    Serialisation inputSerialisation2 = new Serialisation(Format.JSON, "Config Path");

    PipelineModel createPipelineResult2 = TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE,
        "Function Qualified Name", "Display Name", "Formatted Function Name", "Input Type", "Output Type", "42",
        inputSerialisation2, new Serialisation(Format.JSON, "Config Path"));

    // Act and Assert
    assertEquals(createPipelineResult, createPipelineResult2);
    int expectedHashCodeResult = createPipelineResult.hashCode();
    assertEquals(expectedHashCodeResult, createPipelineResult2.hashCode());
  }

  /**
   * Test {@link PipelineModel#equals(Object)}, and {@link PipelineModel#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PipelineModel#equals(Object)}
   *   <li>{@link PipelineModel#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PipelineModel.equals(Object)", "int PipelineModel.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Serialisation inputSerialisation = new Serialisation(Format.JSON, "Config Path");

    PipelineModel createPipelineResult = TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE,
        "Function Qualified Name", "Display Name", "Formatted Function Name", "Input Type", "Output Type", "42",
        inputSerialisation, new Serialisation(Format.JSON, "Config Path"));

    // Act and Assert
    assertEquals(createPipelineResult, createPipelineResult);
    int expectedHashCodeResult = createPipelineResult.hashCode();
    assertEquals(expectedHashCodeResult, createPipelineResult.hashCode());
  }

  /**
   * Test {@link PipelineModel#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PipelineModel#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PipelineModel.equals(Object)", "int PipelineModel.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Serialisation inputSerialisation = new Serialisation(Format.JSON, "Config Path");

    PipelineModel createPipelineResult = TestPackUtils.createPipeline(TransformType.TRANSLATE,
        "Function Qualified Name", "Display Name", "Formatted Function Name", "Input Type", "Output Type", "42",
        inputSerialisation, new Serialisation(Format.JSON, "Config Path"));
    Serialisation inputSerialisation2 = new Serialisation(Format.JSON, "Config Path");

    // Act and Assert
    assertNotEquals(createPipelineResult,
        TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE, "Function Qualified Name", "Display Name",
            "Formatted Function Name", "Input Type", "Output Type", "42", inputSerialisation2,
            new Serialisation(Format.JSON, "Config Path")));
  }

  /**
   * Test {@link PipelineModel#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PipelineModel#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PipelineModel.equals(Object)", "int PipelineModel.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Serialisation inputSerialisation = new Serialisation(Format.JSON, "Config Path");

    PipelineModel createPipelineResult = TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE, null, "Display Name",
        "Formatted Function Name", "Input Type", "Output Type", "42", inputSerialisation,
        new Serialisation(Format.JSON, "Config Path"));
    Serialisation inputSerialisation2 = new Serialisation(Format.JSON, "Config Path");

    // Act and Assert
    assertNotEquals(createPipelineResult,
        TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE, "Function Qualified Name", "Display Name",
            "Formatted Function Name", "Input Type", "Output Type", "42", inputSerialisation2,
            new Serialisation(Format.JSON, "Config Path")));
  }

  /**
   * Test {@link PipelineModel#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PipelineModel#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PipelineModel.equals(Object)", "int PipelineModel.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Serialisation inputSerialisation = new Serialisation(Format.JSON, "Config Path");

    PipelineModel createPipelineResult = TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE,
        "Function Qualified Name", null, "Formatted Function Name", "Input Type", "Output Type", "42",
        inputSerialisation, new Serialisation(Format.JSON, "Config Path"));
    Serialisation inputSerialisation2 = new Serialisation(Format.JSON, "Config Path");

    // Act and Assert
    assertNotEquals(createPipelineResult,
        TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE, "Function Qualified Name", "Display Name",
            "Formatted Function Name", "Input Type", "Output Type", "42", inputSerialisation2,
            new Serialisation(Format.JSON, "Config Path")));
  }

  /**
   * Test {@link PipelineModel#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PipelineModel#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PipelineModel.equals(Object)", "int PipelineModel.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Serialisation inputSerialisation = new Serialisation(Format.JSON, "Config Path");

    PipelineModel createPipelineResult = TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE,
        "Function Qualified Name", "Display Name", "Formatted Function Name", "Input Type", "Output Type",
        "Upstream Pipeline Id", inputSerialisation, new Serialisation(Format.JSON, "Config Path"));
    Serialisation inputSerialisation2 = new Serialisation(Format.JSON, "Config Path");

    // Act and Assert
    assertNotEquals(createPipelineResult,
        TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE, "Function Qualified Name", "Display Name",
            "Formatted Function Name", "Input Type", "Output Type", "42", inputSerialisation2,
            new Serialisation(Format.JSON, "Config Path")));
  }

  /**
   * Test {@link PipelineModel#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PipelineModel#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PipelineModel.equals(Object)", "int PipelineModel.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Serialisation inputSerialisation = new Serialisation(null, "Config Path");

    PipelineModel createPipelineResult = TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE,
        "Function Qualified Name", "Display Name", "Formatted Function Name", "Input Type", "Output Type", "42",
        inputSerialisation, new Serialisation(Format.JSON, "Config Path"));
    Serialisation inputSerialisation2 = new Serialisation(Format.JSON, "Config Path");

    // Act and Assert
    assertNotEquals(createPipelineResult,
        TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE, "Function Qualified Name", "Display Name",
            "Formatted Function Name", "Input Type", "Output Type", "42", inputSerialisation2,
            new Serialisation(Format.JSON, "Config Path")));
  }

  /**
   * Test {@link PipelineModel#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PipelineModel#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PipelineModel.equals(Object)", "int PipelineModel.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Serialisation inputSerialisation = new Serialisation(Format.JSON, "Config Path");

    PipelineModel createPipelineResult = TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE,
        "Function Qualified Name", "Display Name", "Formatted Function Name", "Input Type", "Output Type", "42",
        inputSerialisation, new Serialisation(null, "Config Path"));
    Serialisation inputSerialisation2 = new Serialisation(Format.JSON, "Config Path");

    // Act and Assert
    assertNotEquals(createPipelineResult,
        TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE, "Function Qualified Name", "Display Name",
            "Formatted Function Name", "Input Type", "Output Type", "42", inputSerialisation2,
            new Serialisation(Format.JSON, "Config Path")));
  }

  /**
   * Test {@link PipelineModel#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PipelineModel#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PipelineModel.equals(Object)", "int PipelineModel.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Serialisation inputSerialisation = new Serialisation(Format.JSON, "Config Path");

    // Act and Assert
    assertNotEquals(TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE, "Function Qualified Name", "Display Name",
        "Formatted Function Name", "Input Type", "Output Type", "42", inputSerialisation,
        new Serialisation(Format.JSON, "Config Path")), null);
  }

  /**
   * Test {@link PipelineModel#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PipelineModel#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PipelineModel.equals(Object)", "int PipelineModel.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Serialisation inputSerialisation = new Serialisation(Format.JSON, "Config Path");

    // Act and Assert
    assertNotEquals(TestPackUtils.createPipeline(TransformType.PRE_TRANSLATE, "Function Qualified Name", "Display Name",
        "Formatted Function Name", "Input Type", "Output Type", "42", inputSerialisation,
        new Serialisation(Format.JSON, "Config Path")), "Different type to PipelineModel");
  }

  /**
   * Test Serialisation {@link Serialisation#equals(Object)}, and {@link Serialisation#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Serialisation#equals(Object)}
   *   <li>{@link Serialisation#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Serialisation.equals(Object)", "int Serialisation.hashCode()"})
  public void testSerialisationEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Serialisation serialisation = new Serialisation(Format.JSON, "Config Path");
    Serialisation serialisation2 = new Serialisation(Format.JSON, "Config Path");

    // Act and Assert
    assertEquals(serialisation, serialisation2);
    int expectedHashCodeResult = serialisation.hashCode();
    assertEquals(expectedHashCodeResult, serialisation2.hashCode());
  }

  /**
   * Test Serialisation {@link Serialisation#equals(Object)}, and {@link Serialisation#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Serialisation#equals(Object)}
   *   <li>{@link Serialisation#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Serialisation.equals(Object)", "int Serialisation.hashCode()"})
  public void testSerialisationEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Serialisation serialisation = new Serialisation(Format.JSON, "Config Path");

    // Act and Assert
    assertEquals(serialisation, serialisation);
    int expectedHashCodeResult = serialisation.hashCode();
    assertEquals(expectedHashCodeResult, serialisation.hashCode());
  }

  /**
   * Test Serialisation {@link Serialisation#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Serialisation#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Serialisation.equals(Object)", "int Serialisation.hashCode()"})
  public void testSerialisationEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Serialisation serialisation = new Serialisation(Format.XML, "Config Path");

    // Act and Assert
    assertNotEquals(serialisation, new Serialisation(Format.JSON, "Config Path"));
  }

  /**
   * Test Serialisation {@link Serialisation#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Serialisation#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Serialisation.equals(Object)", "int Serialisation.hashCode()"})
  public void testSerialisationEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Serialisation serialisation = new Serialisation(Format.JSON,
        "com.regnosys.rosetta.common.transform.PipelineModel$Serialisation");

    // Act and Assert
    assertNotEquals(serialisation, new Serialisation(Format.JSON, "Config Path"));
  }

  /**
   * Test Serialisation {@link Serialisation#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Serialisation#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Serialisation.equals(Object)", "int Serialisation.hashCode()"})
  public void testSerialisationEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Serialisation(Format.JSON, "Config Path"), null);
  }

  /**
   * Test Serialisation {@link Serialisation#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Serialisation#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Serialisation.equals(Object)", "int Serialisation.hashCode()"})
  public void testSerialisationEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Serialisation(Format.JSON, "Config Path"), "Different type to Serialisation");
  }

  /**
   * Test Serialisation getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Serialisation#Serialisation(Format, String)}
   *   <li>{@link Serialisation#toString()}
   *   <li>{@link Serialisation#getConfigPath()}
   *   <li>{@link Serialisation#getFormat()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Serialisation.<init>(Format, String)", "String Serialisation.getConfigPath()",
      "Format Serialisation.getFormat()", "String Serialisation.toString()"})
  public void testSerialisationGettersAndSetters() {
    // Arrange and Act
    Serialisation actualSerialisation = new Serialisation(Format.JSON, "Config Path");
    String actualToStringResult = actualSerialisation.toString();
    String actualConfigPath = actualSerialisation.getConfigPath();

    // Assert
    assertEquals("Config Path", actualConfigPath);
    assertEquals("Serialisation{format=JSON, configPath='Config Path'}", actualToStringResult);
    assertEquals(Format.JSON, actualSerialisation.getFormat());
  }

  /**
   * Test Transform {@link Transform#equals(Object)}, and {@link Transform#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Transform#equals(Object)}
   *   <li>{@link Transform#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Transform.equals(Object)", "int Transform.hashCode()"})
  public void testTransformEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Transform transform = new Transform(TransformType.PRE_TRANSLATE, "Function", "Input Type", "Output Type");
    Transform transform2 = new Transform(TransformType.PRE_TRANSLATE, "Function", "Input Type", "Output Type");

    // Act and Assert
    assertEquals(transform, transform2);
    int expectedHashCodeResult = transform.hashCode();
    assertEquals(expectedHashCodeResult, transform2.hashCode());
  }

  /**
   * Test Transform {@link Transform#equals(Object)}, and {@link Transform#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Transform#equals(Object)}
   *   <li>{@link Transform#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Transform.equals(Object)", "int Transform.hashCode()"})
  public void testTransformEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Transform transform = new Transform(TransformType.PRE_TRANSLATE, "Function", "Input Type", "Output Type");

    // Act and Assert
    assertEquals(transform, transform);
    int expectedHashCodeResult = transform.hashCode();
    assertEquals(expectedHashCodeResult, transform.hashCode());
  }

  /**
   * Test Transform {@link Transform#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Transform#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Transform.equals(Object)", "int Transform.hashCode()"})
  public void testTransformEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Transform transform = new Transform(TransformType.TRANSLATE, "Function", "Input Type", "Output Type");

    // Act and Assert
    assertNotEquals(transform, new Transform(TransformType.PRE_TRANSLATE, "Function", "Input Type", "Output Type"));
  }

  /**
   * Test Transform {@link Transform#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Transform#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Transform.equals(Object)", "int Transform.hashCode()"})
  public void testTransformEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Transform transform = new Transform(TransformType.PRE_TRANSLATE,
        "com.regnosys.rosetta.common.transform.PipelineModel$Transform", "Input Type", "Output Type");

    // Act and Assert
    assertNotEquals(transform, new Transform(TransformType.PRE_TRANSLATE, "Function", "Input Type", "Output Type"));
  }

  /**
   * Test Transform {@link Transform#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Transform#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Transform.equals(Object)", "int Transform.hashCode()"})
  public void testTransformEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Transform transform = new Transform(TransformType.PRE_TRANSLATE, "Function",
        "com.regnosys.rosetta.common.transform.PipelineModel$Transform", "Output Type");

    // Act and Assert
    assertNotEquals(transform, new Transform(TransformType.PRE_TRANSLATE, "Function", "Input Type", "Output Type"));
  }

  /**
   * Test Transform {@link Transform#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Transform#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Transform.equals(Object)", "int Transform.hashCode()"})
  public void testTransformEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Transform transform = new Transform(TransformType.PRE_TRANSLATE, "Function", "Input Type",
        "com.regnosys.rosetta.common.transform.PipelineModel$Transform");

    // Act and Assert
    assertNotEquals(transform, new Transform(TransformType.PRE_TRANSLATE, "Function", "Input Type", "Output Type"));
  }

  /**
   * Test Transform {@link Transform#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Transform#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Transform.equals(Object)", "int Transform.hashCode()"})
  public void testTransformEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Transform(TransformType.PRE_TRANSLATE, "Function", "Input Type", "Output Type"), null);
  }

  /**
   * Test Transform {@link Transform#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Transform#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Transform.equals(Object)", "int Transform.hashCode()"})
  public void testTransformEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Transform(TransformType.PRE_TRANSLATE, "Function", "Input Type", "Output Type"),
        "Different type to Transform");
  }

  /**
   * Test Transform getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Transform#Transform(TransformType, String, String, String)}
   *   <li>{@link Transform#toString()}
   *   <li>{@link Transform#getFunction()}
   *   <li>{@link Transform#getInputType()}
   *   <li>{@link Transform#getOutputType()}
   *   <li>{@link Transform#getType()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Transform.<init>(TransformType, String, String, String)", "String Transform.getFunction()",
      "String Transform.getInputType()", "String Transform.getOutputType()", "TransformType Transform.getType()",
      "String Transform.toString()"})
  public void testTransformGettersAndSetters() {
    // Arrange and Act
    Transform actualTransform = new Transform(TransformType.PRE_TRANSLATE, "Function", "Input Type", "Output Type");
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
