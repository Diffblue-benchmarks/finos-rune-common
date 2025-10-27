package com.regnosys.rosetta.common.validation;

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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.regnosys.rosetta.common.merger.BarBuilder;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.FieldWithMetaPrice;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.MetaFields;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.meta.Key;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.AttributeMeta;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.test.Animal;
import com.rosetta.test.AnimalContainer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import org.junit.Test;

public class RosettaTypeValidatorDiffblueTest {
  /**
   * Method under test:
   * {@link RosettaTypeValidator.RosettaTypeProcessor#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testRosettaTypeProcessorProcessRosetta() {
    // Arrange
    RosettaTypeValidator rosettaTypeValidator = new RosettaTypeValidator();
    BarBuilder resultObject = new BarBuilder();
    ValidationReport report = new ValidationReport(resultObject, new ArrayList<>());

    RosettaTypeValidator.RosettaTypeProcessor rosettaTypeProcessor = rosettaTypeValidator.new RosettaTypeProcessor(
        report);
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;

    // Act and Assert
    assertFalse(rosettaTypeProcessor.processRosetta(path, rosettaType, (RosettaModelObject) null, new BarBuilder(),
        AttributeMeta.META));
    assertSame(report, rosettaTypeProcessor.report());
  }

  /**
   * Method under test:
   * {@link RosettaTypeValidator.RosettaTypeProcessor#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testRosettaTypeProcessorProcessRosetta2() {
    // Arrange
    RosettaTypeValidator rosettaTypeValidator = new RosettaTypeValidator();
    BarBuilder resultObject = new BarBuilder();
    ValidationReport report = new ValidationReport(resultObject, new ArrayList<>());

    RosettaTypeValidator.RosettaTypeProcessor rosettaTypeProcessor = rosettaTypeValidator.new RosettaTypeProcessor(
        report);
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;
    Key.KeyBuilderImpl keyBuilderImpl = new Key.KeyBuilderImpl();

    // Act and Assert
    assertTrue(
        rosettaTypeProcessor.processRosetta(path, rosettaType, keyBuilderImpl, new BarBuilder(), AttributeMeta.META));
    assertSame(report, rosettaTypeProcessor.report());
  }

  /**
   * Method under test: {@link RosettaTypeValidator.RosettaTypeProcessor#report()}
   */
  @Test
  public void testRosettaTypeProcessorReport() {
    // Arrange
    RosettaTypeValidator rosettaTypeValidator = new RosettaTypeValidator();
    BarBuilder resultObject = new BarBuilder();
    ValidationReport report = new ValidationReport(resultObject, new ArrayList<>());

    // Act and Assert
    assertSame(report, (rosettaTypeValidator.new RosettaTypeProcessor(report)).report());
  }

  /**
   * Method under test: {@link RosettaTypeValidator.RosettaTypeProcessor#report()}
   */
  @Test
  public void testRosettaTypeProcessorReport2() {
    // Arrange
    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.of("foo");
    validationResults.add(new ValidationResult.ModelValidationResult<>("Name",
        ValidationResult.ValidationType.DATA_RULE, "Model Object Name", path, "Definition", failureReason));
    ValidationReport report = new ValidationReport(new BarBuilder(), validationResults);

    // Act and Assert
    assertSame(report, ((new RosettaTypeValidator()).new RosettaTypeProcessor(report)).report());
  }

  /**
   * Method under test:
   * {@link RosettaTypeValidator#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  public void testRunProcessStep() {
    // Arrange
    RosettaTypeValidator rosettaTypeValidator = new RosettaTypeValidator();
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    Key.KeyBuilderImpl keyBuilderImpl = new Key.KeyBuilderImpl();

    // Act
    ValidationReport actualRunProcessStepResult = rosettaTypeValidator.runProcessStep(topClass, keyBuilderImpl);

    // Assert
    List<ValidationResult<?>> validationResults = actualRunProcessStepResult.getValidationResults();
    assertEquals(1, validationResults.size());
    ValidationResult<?> getResult = validationResults.get(0);
    assertTrue(getResult instanceof ValidationResult.ModelValidationResult);
    assertEquals("", getResult.getDefinition());
    RosettaPath path = getResult.getPath();
    RosettaPath.Element element = path.getElement();
    assertEquals("FpML_5_10", element.getUri());
    Optional<String> failureReason = getResult.getFailureReason();
    assertEquals("Key value must be set", failureReason.get());
    assertEquals("Key", element.getPath());
    assertEquals("Key", getResult.getModelObjectName());
    assertEquals("Key.value", getResult.getName());
    assertNull(path.getParent());
    assertEquals(ValidationResult.ValidationType.KEY, getResult.getValidationType());
    assertFalse(actualRunProcessStepResult.success());
    assertFalse(getResult.isSuccess());
    assertFalse(element.getIndex().isPresent());
    assertTrue(element.getMetas().isEmpty());
    assertTrue(failureReason.isPresent());
    assertSame(keyBuilderImpl, actualRunProcessStepResult.getResultObject());
  }

  /**
   * Method under test:
   * {@link RosettaTypeValidator#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  public void testRunProcessStep2() {
    // Arrange
    RosettaTypeValidator rosettaTypeValidator = new RosettaTypeValidator();
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    Key.KeyImpl keyImpl = new Key.KeyImpl(new Key.KeyBuilderImpl());

    // Act
    ValidationReport actualRunProcessStepResult = rosettaTypeValidator.runProcessStep(topClass, keyImpl);

    // Assert
    List<ValidationResult<?>> validationResults = actualRunProcessStepResult.getValidationResults();
    assertEquals(1, validationResults.size());
    ValidationResult<?> getResult = validationResults.get(0);
    assertTrue(getResult instanceof ValidationResult.ModelValidationResult);
    assertEquals("", getResult.getDefinition());
    RosettaPath path = getResult.getPath();
    RosettaPath.Element element = path.getElement();
    assertEquals("FpML_5_10", element.getUri());
    Optional<String> failureReason = getResult.getFailureReason();
    assertEquals("Key value must be set", failureReason.get());
    assertEquals("Key", element.getPath());
    assertEquals("Key", getResult.getModelObjectName());
    assertEquals("Key.value", getResult.getName());
    assertNull(path.getParent());
    assertEquals(ValidationResult.ValidationType.KEY, getResult.getValidationType());
    assertFalse(actualRunProcessStepResult.success());
    assertFalse(getResult.isSuccess());
    assertFalse(element.getIndex().isPresent());
    assertTrue(element.getMetas().isEmpty());
    assertTrue(failureReason.isPresent());
    assertSame(keyImpl, actualRunProcessStepResult.getResultObject());
  }

  /**
   * Method under test:
   * {@link RosettaTypeValidator#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  public void testRunProcessStep3() {
    // Arrange
    RosettaTypeValidator rosettaTypeValidator = new RosettaTypeValidator();
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl fieldWithMetaPriceBuilderImpl = new FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl();

    // Act
    ValidationReport actualRunProcessStepResult = rosettaTypeValidator.runProcessStep(topClass,
        fieldWithMetaPriceBuilderImpl);

    // Assert
    assertTrue(actualRunProcessStepResult.success());
    assertTrue(actualRunProcessStepResult.getValidationResults().isEmpty());
    assertSame(fieldWithMetaPriceBuilderImpl, actualRunProcessStepResult.getResultObject());
  }

  /**
   * Method under test:
   * {@link RosettaTypeValidator#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  public void testRunProcessStep4() {
    // Arrange
    RosettaTypeValidator rosettaTypeValidator = new RosettaTypeValidator();
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl fieldWithMetaPriceBuilderImpl = new FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl();
    fieldWithMetaPriceBuilderImpl.setMeta(new MetaFields.MetaFieldsBuilderImpl());

    // Act
    ValidationReport actualRunProcessStepResult = rosettaTypeValidator.runProcessStep(topClass,
        fieldWithMetaPriceBuilderImpl);

    // Assert
    assertTrue(actualRunProcessStepResult.success());
    assertTrue(actualRunProcessStepResult.getValidationResults().isEmpty());
    assertSame(fieldWithMetaPriceBuilderImpl, actualRunProcessStepResult.getResultObject());
  }

  /**
   * Method under test:
   * {@link RosettaTypeValidator#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  public void testRunProcessStep5() {
    // Arrange
    RosettaTypeValidator rosettaTypeValidator = new RosettaTypeValidator();
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    MetaFields.MetaFieldsBuilderImpl meta = new MetaFields.MetaFieldsBuilderImpl();
    meta.addKey(new Key.KeyBuilderImpl());

    FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl fieldWithMetaPriceBuilderImpl = new FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl();
    fieldWithMetaPriceBuilderImpl.setMeta(meta);

    // Act
    ValidationReport actualRunProcessStepResult = rosettaTypeValidator.runProcessStep(topClass,
        fieldWithMetaPriceBuilderImpl);

    // Assert
    List<ValidationResult<?>> validationResults = actualRunProcessStepResult.getValidationResults();
    assertEquals(1, validationResults.size());
    ValidationResult<?> getResult = validationResults.get(0);
    assertTrue(getResult instanceof ValidationResult.ModelValidationResult);
    assertEquals("", getResult.getDefinition());
    RosettaPath path = getResult.getPath();
    RosettaPath parent = path.getParent();
    RosettaPath parent2 = parent.getParent();
    RosettaPath.Element element = parent2.getElement();
    assertEquals("FieldWithMetaPrice", element.getPath());
    assertEquals("FpML_5_10", element.getUri());
    RosettaPath.Element element2 = parent.getElement();
    assertEquals("FpML_5_10", element2.getUri());
    RosettaPath.Element element3 = path.getElement();
    assertEquals("FpML_5_10", element3.getUri());
    Optional<String> failureReason = getResult.getFailureReason();
    assertEquals("Key value must be set", failureReason.get());
    assertEquals("Key", getResult.getModelObjectName());
    assertEquals("Key.value", getResult.getName());
    assertEquals("key", element3.getPath());
    assertEquals("meta", element2.getPath());
    assertNull(parent2.getParent());
    OptionalInt index = element3.getIndex();
    assertEquals(0, index.getAsInt());
    assertEquals(ValidationResult.ValidationType.KEY, getResult.getValidationType());
    assertFalse(actualRunProcessStepResult.success());
    assertFalse(getResult.isSuccess());
    assertFalse(element2.getIndex().isPresent());
    assertTrue(element.getMetas().isEmpty());
    Map<String, String> metas = element3.getMetas();
    assertTrue(metas.isEmpty());
    assertTrue(failureReason.isPresent());
    assertTrue(index.isPresent());
    assertSame(fieldWithMetaPriceBuilderImpl, actualRunProcessStepResult.getResultObject());
    assertSame(element.getIndex(), element.getIndex());
    assertSame(metas, element2.getMetas());
  }

  /**
   * Method under test:
   * {@link RosettaTypeValidator#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  public void testRunProcessStep6() {
    // Arrange
    RosettaTypeValidator rosettaTypeValidator = new RosettaTypeValidator();
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    MetaFields.MetaFieldsBuilderImpl meta = new MetaFields.MetaFieldsBuilderImpl();
    meta.addKey(new Key.KeyBuilderImpl());
    meta.addKey(new Key.KeyBuilderImpl());

    FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl fieldWithMetaPriceBuilderImpl = new FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl();
    fieldWithMetaPriceBuilderImpl.setMeta(meta);

    // Act
    ValidationReport actualRunProcessStepResult = rosettaTypeValidator.runProcessStep(topClass,
        fieldWithMetaPriceBuilderImpl);

    // Assert
    List<ValidationResult<?>> validationResults = actualRunProcessStepResult.getValidationResults();
    assertEquals(2, validationResults.size());
    ValidationResult<?> getResult = validationResults.get(0);
    assertTrue(getResult instanceof ValidationResult.ModelValidationResult);
    ValidationResult<?> getResult2 = validationResults.get(1);
    assertTrue(getResult2 instanceof ValidationResult.ModelValidationResult);
    assertEquals("", getResult.getDefinition());
    assertEquals("", getResult2.getDefinition());
    RosettaPath path = getResult.getPath();
    RosettaPath parent = path.getParent();
    RosettaPath parent2 = parent.getParent();
    RosettaPath.Element element = parent2.getElement();
    assertEquals("FieldWithMetaPrice", element.getPath());
    assertEquals("FpML_5_10", element.getUri());
    RosettaPath.Element element2 = parent.getElement();
    assertEquals("FpML_5_10", element2.getUri());
    RosettaPath.Element element3 = path.getElement();
    assertEquals("FpML_5_10", element3.getUri());
    RosettaPath.Element element4 = getResult2.getPath().getElement();
    assertEquals("FpML_5_10", element4.getUri());
    Optional<String> failureReason = getResult.getFailureReason();
    assertEquals("Key value must be set", failureReason.get());
    assertEquals("Key", getResult.getModelObjectName());
    assertEquals("Key", getResult2.getModelObjectName());
    assertEquals("Key.value", getResult.getName());
    assertEquals("Key.value", getResult2.getName());
    assertEquals("key", element3.getPath());
    assertEquals("key", element4.getPath());
    assertEquals("meta", element2.getPath());
    assertNull(parent2.getParent());
    OptionalInt index = element3.getIndex();
    assertEquals(0, index.getAsInt());
    OptionalInt index2 = element4.getIndex();
    assertEquals(1, index2.getAsInt());
    assertEquals(ValidationResult.ValidationType.KEY, getResult.getValidationType());
    assertEquals(ValidationResult.ValidationType.KEY, getResult2.getValidationType());
    assertFalse(actualRunProcessStepResult.success());
    assertFalse(getResult.isSuccess());
    assertFalse(getResult2.isSuccess());
    assertFalse(element2.getIndex().isPresent());
    assertTrue(element.getMetas().isEmpty());
    Map<String, String> metas = element3.getMetas();
    assertTrue(metas.isEmpty());
    assertTrue(failureReason.isPresent());
    assertTrue(index.isPresent());
    assertTrue(index2.isPresent());
    assertEquals(failureReason, getResult2.getFailureReason());
    assertSame(fieldWithMetaPriceBuilderImpl, actualRunProcessStepResult.getResultObject());
    assertSame(element.getIndex(), element.getIndex());
    assertSame(metas, element2.getMetas());
    assertSame(metas, element4.getMetas());
  }

  /**
   * Method under test:
   * {@link RosettaTypeValidator#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  public void testRunProcessStep7() {
    // Arrange
    RosettaTypeValidator rosettaTypeValidator = new RosettaTypeValidator();
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    MetaFields.MetaFieldsBuilderImpl meta = new MetaFields.MetaFieldsBuilderImpl();
    meta.addKey(new Key.KeyBuilderImpl(), 2);
    meta.addKey(new Key.KeyBuilderImpl());

    FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl fieldWithMetaPriceBuilderImpl = new FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl();
    fieldWithMetaPriceBuilderImpl.setMeta(meta);

    // Act
    ValidationReport actualRunProcessStepResult = rosettaTypeValidator.runProcessStep(topClass,
        fieldWithMetaPriceBuilderImpl);

    // Assert
    List<ValidationResult<?>> validationResults = actualRunProcessStepResult.getValidationResults();
    assertEquals(2, validationResults.size());
    ValidationResult<?> getResult = validationResults.get(0);
    assertTrue(getResult instanceof ValidationResult.ModelValidationResult);
    ValidationResult<?> getResult2 = validationResults.get(1);
    assertTrue(getResult2 instanceof ValidationResult.ModelValidationResult);
    assertEquals("", getResult.getDefinition());
    assertEquals("", getResult2.getDefinition());
    RosettaPath path = getResult.getPath();
    RosettaPath parent = path.getParent();
    RosettaPath parent2 = parent.getParent();
    RosettaPath.Element element = parent2.getElement();
    assertEquals("FieldWithMetaPrice", element.getPath());
    assertEquals("FpML_5_10", element.getUri());
    RosettaPath.Element element2 = parent.getElement();
    assertEquals("FpML_5_10", element2.getUri());
    RosettaPath.Element element3 = path.getElement();
    assertEquals("FpML_5_10", element3.getUri());
    RosettaPath.Element element4 = getResult2.getPath().getElement();
    assertEquals("FpML_5_10", element4.getUri());
    Optional<String> failureReason = getResult.getFailureReason();
    assertEquals("Key value must be set", failureReason.get());
    assertEquals("Key", getResult.getModelObjectName());
    assertEquals("Key", getResult2.getModelObjectName());
    assertEquals("Key.value", getResult.getName());
    assertEquals("Key.value", getResult2.getName());
    assertEquals("key", element3.getPath());
    assertEquals("key", element4.getPath());
    assertEquals("meta", element2.getPath());
    assertNull(parent2.getParent());
    OptionalInt index = element3.getIndex();
    assertEquals(2, index.getAsInt());
    OptionalInt index2 = element4.getIndex();
    assertEquals(3, index2.getAsInt());
    assertEquals(ValidationResult.ValidationType.KEY, getResult.getValidationType());
    assertEquals(ValidationResult.ValidationType.KEY, getResult2.getValidationType());
    assertFalse(actualRunProcessStepResult.success());
    assertFalse(getResult.isSuccess());
    assertFalse(getResult2.isSuccess());
    assertFalse(element2.getIndex().isPresent());
    assertTrue(element.getMetas().isEmpty());
    Map<String, String> metas = element3.getMetas();
    assertTrue(metas.isEmpty());
    assertTrue(failureReason.isPresent());
    assertTrue(index.isPresent());
    assertTrue(index2.isPresent());
    assertEquals(failureReason, getResult2.getFailureReason());
    assertSame(fieldWithMetaPriceBuilderImpl, actualRunProcessStepResult.getResultObject());
    assertSame(element.getIndex(), element.getIndex());
    assertSame(metas, element2.getMetas());
    assertSame(metas, element4.getMetas());
  }

  /**
   * Method under test:
   * {@link RosettaTypeValidator#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  public void testRunProcessStep8() {
    // Arrange
    RosettaTypeValidator rosettaTypeValidator = new RosettaTypeValidator();
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    Animal.AnimalBuilderImpl animalBuilderImpl = new Animal.AnimalBuilderImpl();

    // Act
    ValidationReport actualRunProcessStepResult = rosettaTypeValidator.runProcessStep(topClass, animalBuilderImpl);

    // Assert
    List<ValidationResult<?>> validationResults = actualRunProcessStepResult.getValidationResults();
    assertEquals(1, validationResults.size());
    ValidationResult<?> getResult = validationResults.get(0);
    assertTrue(getResult instanceof ValidationResult.ModelValidationResult);
    assertEquals("", getResult.getDefinition());
    RosettaPath path = getResult.getPath();
    RosettaPath.Element element = path.getElement();
    assertEquals("Animal", element.getPath());
    assertEquals("Animal", getResult.getModelObjectName());
    assertEquals("Animal", getResult.getName());
    assertEquals("FpML_5_10", element.getUri());
    assertNull(path.getParent());
    assertEquals(ValidationResult.ValidationType.CARDINALITY, getResult.getValidationType());
    assertFalse(getResult.getFailureReason().isPresent());
    assertFalse(element.getIndex().isPresent());
    assertTrue(actualRunProcessStepResult.success());
    assertTrue(getResult.isSuccess());
    assertTrue(element.getMetas().isEmpty());
    assertSame(animalBuilderImpl, actualRunProcessStepResult.getResultObject());
  }

  /**
   * Method under test:
   * {@link RosettaTypeValidator#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  public void testRunProcessStep9() {
    // Arrange
    RosettaTypeValidator rosettaTypeValidator = new RosettaTypeValidator();
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    AnimalContainer.AnimalContainerBuilderImpl animalContainerBuilderImpl = new AnimalContainer.AnimalContainerBuilderImpl();

    // Act
    ValidationReport actualRunProcessStepResult = rosettaTypeValidator.runProcessStep(topClass,
        animalContainerBuilderImpl);

    // Assert
    List<ValidationResult<?>> validationResults = actualRunProcessStepResult.getValidationResults();
    assertEquals(1, validationResults.size());
    ValidationResult<?> getResult = validationResults.get(0);
    assertTrue(getResult instanceof ValidationResult.ModelValidationResult);
    assertEquals("", getResult.getDefinition());
    Optional<String> failureReason = getResult.getFailureReason();
    assertEquals("'animal' is a required field but does not exist.", failureReason.get());
    RosettaPath path = getResult.getPath();
    RosettaPath.Element element = path.getElement();
    assertEquals("AnimalContainer", element.getPath());
    assertEquals("AnimalContainer", getResult.getModelObjectName());
    assertEquals("AnimalContainer", getResult.getName());
    assertEquals("FpML_5_10", element.getUri());
    assertNull(path.getParent());
    assertEquals(ValidationResult.ValidationType.CARDINALITY, getResult.getValidationType());
    assertFalse(actualRunProcessStepResult.success());
    assertFalse(getResult.isSuccess());
    assertFalse(element.getIndex().isPresent());
    assertTrue(element.getMetas().isEmpty());
    assertTrue(failureReason.isPresent());
    assertSame(animalContainerBuilderImpl, actualRunProcessStepResult.getResultObject());
  }

  /**
   * Method under test: {@link RosettaTypeValidator#getPriority()}
   */
  @Test
  public void testGetPriority() {
    // Arrange, Act and Assert
    assertEquals(100, (new RosettaTypeValidator()).getPriority().intValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RosettaTypeValidator}
   *   <li>{@link RosettaTypeValidator#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Rosetta type validator PostProcessor", (new RosettaTypeValidator()).getName());
  }
}
