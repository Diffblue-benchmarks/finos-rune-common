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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.merger.BarBuilder;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.FieldWithMetaPrice;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.MetaFields;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.MetaFields.MetaFieldsBuilder;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.MetaFields.MetaFieldsBuilderImpl;
import com.regnosys.rosetta.common.validation.RosettaTypeValidator.RosettaTypeProcessor;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.meta.Key;
import com.rosetta.model.lib.meta.Key.KeyBuilder;
import com.rosetta.model.lib.meta.Key.KeyBuilderImpl;
import com.rosetta.model.lib.meta.Key.KeyImpl;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.AttributeMeta;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.process.Processor.Report;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ModelValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.test.Animal;
import com.rosetta.test.Animal.AnimalBuilderImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RosettaTypeValidatorDiffblueTest {
  /**
   * Test RosettaTypeProcessor {@link RosettaTypeProcessor#processRosetta(RosettaPath, Class,
   * RosettaModelObject, RosettaModelObject, AttributeMeta[])} with {@code path}, {@code
   * rosettaType}, {@code instance}, {@code parent}, {@code metas}.
   *
   * <p>Method under test: {@link RosettaTypeProcessor#processRosetta(RosettaPath, Class,
   * RosettaModelObject, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @DisplayName(
      "Test RosettaTypeProcessor processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[]) with 'path', 'rosettaType', 'instance', 'parent', 'metas'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RosettaTypeProcessor.processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])"
  })
  void testRosettaTypeProcessorProcessRosettaWithPathRosettaTypeInstanceParentMetas() {
    // Arrange
    RosettaTypeValidator rosettaTypeValidator = new RosettaTypeValidator();
    BarBuilder resultObject = new BarBuilder();
    ValidationReport report = new ValidationReport(resultObject, new ArrayList<>());
    RosettaTypeProcessor rosettaTypeProcessor =
        rosettaTypeValidator.new RosettaTypeProcessor(report);
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;

    // Act
    boolean actualProcessRosettaResult =
        rosettaTypeProcessor.processRosetta(
            path, rosettaType, (RosettaModelObject) null, new BarBuilder(), AttributeMeta.META);

    // Assert
    Report reportResult = rosettaTypeProcessor.report();
    assertTrue(reportResult instanceof ValidationReport);
    assertFalse(actualProcessRosettaResult);
    assertTrue(((ValidationReport) reportResult).success());
    assertTrue(((ValidationReport) reportResult).getValidationResults().isEmpty());
  }

  /**
   * Test RosettaTypeProcessor {@link RosettaTypeProcessor#processRosetta(RosettaPath, Class,
   * RosettaModelObject, RosettaModelObject, AttributeMeta[])} with {@code path}, {@code
   * rosettaType}, {@code instance}, {@code parent}, {@code metas}.
   *
   * <p>Method under test: {@link RosettaTypeProcessor#processRosetta(RosettaPath, Class,
   * RosettaModelObject, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @DisplayName(
      "Test RosettaTypeProcessor processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[]) with 'path', 'rosettaType', 'instance', 'parent', 'metas'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RosettaTypeProcessor.processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])"
  })
  void testRosettaTypeProcessorProcessRosettaWithPathRosettaTypeInstanceParentMetas2() {
    // Arrange
    RosettaTypeValidator rosettaTypeValidator = new RosettaTypeValidator();
    BarBuilder resultObject = new BarBuilder();
    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();

    ValidationReport report = new ValidationReport(resultObject, validationResults);
    RosettaTypeProcessor rosettaTypeProcessor =
        rosettaTypeValidator.new RosettaTypeProcessor(report);
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;
    KeyBuilderImpl keyBuilderImpl = new KeyBuilderImpl();

    // Act
    boolean actualProcessRosettaResult =
        rosettaTypeProcessor.processRosetta(
            path, rosettaType, keyBuilderImpl, new BarBuilder(), AttributeMeta.META);

    // Assert
    Report reportResult = rosettaTypeProcessor.report();
    assertTrue(reportResult instanceof ValidationReport);
    assertFalse(((ValidationReport) reportResult).success());
    assertTrue(actualProcessRosettaResult);
    assertSame(validationResults, ((ValidationReport) reportResult).getValidationResults());
  }

  /**
   * Test RosettaTypeProcessor {@link RosettaTypeProcessor#report()}.
   *
   * <p>Method under test: {@link RosettaTypeProcessor#report()}
   */
  @Test
  @DisplayName("Test RosettaTypeProcessor report()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Processor.Report RosettaTypeProcessor.report()"})
  void testRosettaTypeProcessorReport() {
    // Arrange
    RosettaTypeValidator rosettaTypeValidator = new RosettaTypeValidator();
    BarBuilder resultObject = new BarBuilder();
    ValidationReport report = new ValidationReport(resultObject, new ArrayList<>());

    // Act and Assert
    assertSame(report, rosettaTypeValidator.new RosettaTypeProcessor(report).report());
  }

  /**
   * Test {@link RosettaTypeValidator#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Given {@link MetaFieldsBuilderImpl} (default constructor).
   *   <li>Then return success.
   * </ul>
   *
   * <p>Method under test: {@link RosettaTypeValidator#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); given MetaFieldsBuilderImpl (default constructor); then return success")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationReport RosettaTypeValidator.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_givenMetaFieldsBuilderImpl_thenReturnSuccess() {
    // Arrange
    RosettaTypeValidator rosettaTypeValidator = new RosettaTypeValidator();
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    FieldWithMetaPriceBuilderImpl fieldWithMetaPriceBuilderImpl =
        new FieldWithMetaPriceBuilderImpl();
    MetaFieldsBuilderImpl meta = new MetaFieldsBuilderImpl();
    fieldWithMetaPriceBuilderImpl.setMeta(meta);

    // Act
    ValidationReport actualRunProcessStepResult =
        rosettaTypeValidator.runProcessStep(topClass, fieldWithMetaPriceBuilderImpl);

    // Assert
    RosettaModelObject resultObject = actualRunProcessStepResult.getResultObject();
    assertTrue(resultObject instanceof FieldWithMetaPriceBuilderImpl);
    MetaFieldsBuilder meta2 = ((FieldWithMetaPriceBuilderImpl) resultObject).getMeta();
    assertTrue(meta2 instanceof MetaFieldsBuilderImpl);
    assertTrue(actualRunProcessStepResult.success());
    assertTrue(meta2.getKey().isEmpty());
    assertTrue(actualRunProcessStepResult.getValidationResults().isEmpty());
    assertSame(meta, meta2);
    assertSame(meta, ((FieldWithMetaPriceBuilderImpl) resultObject).getOrCreateMeta());
  }

  /**
   * Test {@link RosettaTypeValidator#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then return ResultObject is {@link FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link RosettaTypeValidator#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then return ResultObject is FieldWithMetaPriceBuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationReport RosettaTypeValidator.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenReturnResultObjectIsFieldWithMetaPriceBuilderImpl() {
    // Arrange
    RosettaTypeValidator rosettaTypeValidator = new RosettaTypeValidator();
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    FieldWithMetaPriceBuilderImpl fieldWithMetaPriceBuilderImpl =
        new FieldWithMetaPriceBuilderImpl();

    // Act and Assert
    assertSame(
        fieldWithMetaPriceBuilderImpl,
        rosettaTypeValidator
            .runProcessStep(topClass, fieldWithMetaPriceBuilderImpl)
            .getResultObject());
  }

  /**
   * Test {@link RosettaTypeValidator#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then return ResultObject is {@link KeyImpl#KeyImpl(KeyBuilder)} with builder is {@link
   *       KeyBuilderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link RosettaTypeValidator#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then return ResultObject is KeyImpl(KeyBuilder) with builder is KeyBuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationReport RosettaTypeValidator.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenReturnResultObjectIsKeyImplWithBuilderIsKeyBuilderImpl() {
    // Arrange
    RosettaTypeValidator rosettaTypeValidator = new RosettaTypeValidator();
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    KeyImpl keyImpl = new KeyImpl(new KeyBuilderImpl());

    // Act and Assert
    assertSame(keyImpl, rosettaTypeValidator.runProcessStep(topClass, keyImpl).getResultObject());
  }

  /**
   * Test {@link RosettaTypeValidator#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then return ResultObject Meta Key size is four.
   * </ul>
   *
   * <p>Method under test: {@link RosettaTypeValidator#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then return ResultObject Meta Key size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationReport RosettaTypeValidator.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenReturnResultObjectMetaKeySizeIsFour() {
    // Arrange
    RosettaTypeValidator rosettaTypeValidator = new RosettaTypeValidator();
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    MetaFieldsBuilderImpl meta = new MetaFieldsBuilderImpl();
    KeyBuilderImpl key = new KeyBuilderImpl();
    meta.addKey(key, 2);
    KeyBuilderImpl key2 = new KeyBuilderImpl();
    meta.addKey(key2);

    FieldWithMetaPriceBuilderImpl fieldWithMetaPriceBuilderImpl =
        new FieldWithMetaPriceBuilderImpl();
    fieldWithMetaPriceBuilderImpl.setMeta(meta);

    // Act and Assert
    RosettaModelObject resultObject =
        rosettaTypeValidator
            .runProcessStep(topClass, fieldWithMetaPriceBuilderImpl)
            .getResultObject();
    assertTrue(resultObject instanceof FieldWithMetaPriceBuilderImpl);
    MetaFieldsBuilder meta2 = ((FieldWithMetaPriceBuilderImpl) resultObject).getMeta();
    assertTrue(meta2 instanceof MetaFieldsBuilderImpl);
    List<? extends KeyBuilder> key3 = meta2.getKey();
    assertEquals(4, key3.size());
    KeyBuilder getResult = key3.get(2);
    assertTrue(getResult instanceof KeyBuilderImpl);
    assertNull(key3.get(0));
    assertNull(key3.get(1));
    assertSame(key, getResult);
    assertSame(key2, key3.get(3));
  }

  /**
   * Test {@link RosettaTypeValidator#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then return ValidationResults first ModelObjectName is {@code Animal}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaTypeValidator#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then return ValidationResults first ModelObjectName is 'Animal'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationReport RosettaTypeValidator.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenReturnValidationResultsFirstModelObjectNameIsAnimal() {
    // Arrange
    RosettaTypeValidator rosettaTypeValidator = new RosettaTypeValidator();
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    AnimalBuilderImpl animalBuilderImpl = new AnimalBuilderImpl();

    // Act
    ValidationReport actualRunProcessStepResult =
        rosettaTypeValidator.runProcessStep(topClass, animalBuilderImpl);

    // Assert
    List<ValidationResult<?>> validationResults = actualRunProcessStepResult.getValidationResults();
    assertEquals(1, validationResults.size());
    ValidationResult<?> getResult = validationResults.get(0);
    assertTrue(getResult instanceof ModelValidationResult);
    assertEquals("Animal", getResult.getModelObjectName());
    assertEquals("Animal", getResult.getName());
    assertEquals(ValidationType.CARDINALITY, getResult.getValidationType());
    assertFalse(getResult.getFailureReason().isPresent());
    assertTrue(getResult.isSuccess());
    assertSame(animalBuilderImpl, actualRunProcessStepResult.getResultObject());
  }

  /**
   * Test {@link RosettaTypeValidator#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then return ValidationResults first Path Element Index AsInt is zero.
   * </ul>
   *
   * <p>Method under test: {@link RosettaTypeValidator#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then return ValidationResults first Path Element Index AsInt is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationReport RosettaTypeValidator.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenReturnValidationResultsFirstPathElementIndexAsIntIsZero() {
    // Arrange
    RosettaTypeValidator rosettaTypeValidator = new RosettaTypeValidator();
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    MetaFieldsBuilderImpl meta = new MetaFieldsBuilderImpl();
    KeyBuilderImpl key = new KeyBuilderImpl();
    meta.addKey(key);

    FieldWithMetaPriceBuilderImpl fieldWithMetaPriceBuilderImpl =
        new FieldWithMetaPriceBuilderImpl();
    fieldWithMetaPriceBuilderImpl.setMeta(meta);

    // Act
    ValidationReport actualRunProcessStepResult =
        rosettaTypeValidator.runProcessStep(topClass, fieldWithMetaPriceBuilderImpl);

    // Assert
    RosettaModelObject resultObject = actualRunProcessStepResult.getResultObject();
    assertTrue(resultObject instanceof FieldWithMetaPriceBuilderImpl);
    MetaFieldsBuilder meta2 = ((FieldWithMetaPriceBuilderImpl) resultObject).getMeta();
    assertTrue(meta2 instanceof MetaFieldsBuilderImpl);
    List<ValidationResult<?>> validationResults = actualRunProcessStepResult.getValidationResults();
    assertEquals(1, validationResults.size());
    ValidationResult<?> getResult = validationResults.get(0);
    assertTrue(getResult instanceof ModelValidationResult);
    assertEquals(0, getResult.getPath().getElement().getIndex().getAsInt());
    List<? extends KeyBuilder> key2 = meta2.getKey();
    assertEquals(1, key2.size());
    assertSame(key, key2.get(0));
  }

  /**
   * Test {@link RosettaTypeValidator#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then return ValidationResults size is two.
   * </ul>
   *
   * <p>Method under test: {@link RosettaTypeValidator#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then return ValidationResults size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationReport RosettaTypeValidator.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenReturnValidationResultsSizeIsTwo() {
    // Arrange
    RosettaTypeValidator rosettaTypeValidator = new RosettaTypeValidator();
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    MetaFieldsBuilderImpl meta = new MetaFieldsBuilderImpl();
    meta.addKey(new KeyBuilderImpl());
    KeyBuilderImpl key = new KeyBuilderImpl();
    meta.addKey(key);

    FieldWithMetaPriceBuilderImpl fieldWithMetaPriceBuilderImpl =
        new FieldWithMetaPriceBuilderImpl();
    fieldWithMetaPriceBuilderImpl.setMeta(meta);

    // Act
    ValidationReport actualRunProcessStepResult =
        rosettaTypeValidator.runProcessStep(topClass, fieldWithMetaPriceBuilderImpl);

    // Assert
    RosettaModelObject resultObject = actualRunProcessStepResult.getResultObject();
    assertTrue(resultObject instanceof FieldWithMetaPriceBuilderImpl);
    MetaFieldsBuilder meta2 = ((FieldWithMetaPriceBuilderImpl) resultObject).getMeta();
    assertTrue(meta2 instanceof MetaFieldsBuilderImpl);
    List<ValidationResult<?>> validationResults = actualRunProcessStepResult.getValidationResults();
    assertEquals(2, validationResults.size());
    ValidationResult<?> getResult = validationResults.get(1);
    assertTrue(getResult instanceof ModelValidationResult);
    assertEquals(1, getResult.getPath().getElement().getIndex().getAsInt());
    List<? extends KeyBuilder> key2 = meta2.getKey();
    assertEquals(2, key2.size());
    assertSame(key, key2.get(1));
  }

  /**
   * Test {@link RosettaTypeValidator#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>When {@link KeyBuilderImpl} (default constructor).
   *   <li>Then return ResultObject is {@link KeyBuilderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link RosettaTypeValidator#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); when KeyBuilderImpl (default constructor); then return ResultObject is KeyBuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationReport RosettaTypeValidator.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_whenKeyBuilderImpl_thenReturnResultObjectIsKeyBuilderImpl() {
    // Arrange
    RosettaTypeValidator rosettaTypeValidator = new RosettaTypeValidator();
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    KeyBuilderImpl keyBuilderImpl = new KeyBuilderImpl();

    // Act and Assert
    assertSame(
        keyBuilderImpl,
        rosettaTypeValidator.runProcessStep(topClass, keyBuilderImpl).getResultObject());
  }

  /**
   * Test {@link RosettaTypeValidator#getPriority()}.
   *
   * <p>Method under test: {@link RosettaTypeValidator#getPriority()}
   */
  @Test
  @DisplayName("Test getPriority()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer RosettaTypeValidator.getPriority()"})
  void testGetPriority() {
    // Arrange, Act and Assert
    assertEquals(100, new RosettaTypeValidator().getPriority().intValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link RosettaTypeValidator}
   *   <li>{@link RosettaTypeValidator#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RosettaTypeValidator.<init>()",
    "java.lang.String RosettaTypeValidator.getName()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Rosetta type validator PostProcessor", new RosettaTypeValidator().getName());
  }
}
