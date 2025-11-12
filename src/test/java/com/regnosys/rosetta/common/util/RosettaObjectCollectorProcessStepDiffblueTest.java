package com.regnosys.rosetta.common.util;

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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.merger.BarBuilder;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.Price;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.Price.PriceBuilder;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.Price.PriceBuilderImpl;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.PriceQuantity;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.PriceQuantity.PriceQuantityBuilderImpl;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.FieldWithMetaPrice;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.FieldWithMetaPrice.FieldWithMetaPriceBuilder;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.MetaFields;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.MetaFields.MetaFieldsBuilder;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.MetaFields.MetaFieldsBuilderImpl;
import com.regnosys.rosetta.common.util.RosettaObjectCollectorProcessStep.RosettaObjectCollectorProcessReport;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.meta.Key;
import com.rosetta.model.lib.meta.Key.KeyBuilder;
import com.rosetta.model.lib.meta.Key.KeyBuilderImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RosettaObjectCollectorProcessStepDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RosettaObjectCollectorProcessStep#RosettaObjectCollectorProcessStep(Class)}
   *   <li>{@link RosettaObjectCollectorProcessStep#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RosettaObjectCollectorProcessStep.<init>(Class)",
    "java.lang.String RosettaObjectCollectorProcessStep.getName()"
  })
  void testGettersAndSetters() {
    // Arrange
    Class<RosettaModelObject> collectRosettaType = RosettaModelObject.class;

    // Act
    RosettaObjectCollectorProcessStep<RosettaModelObject> actualRosettaObjectCollectorProcessStep =
        new RosettaObjectCollectorProcessStep<>(collectRosettaType);

    // Assert
    assertEquals(
        "RosettaObjectCollector postProcessor", actualRosettaObjectCollectorProcessStep.getName());
  }

  /**
   * Test {@link RosettaObjectCollectorProcessStep#getPriority()}.
   *
   * <p>Method under test: {@link RosettaObjectCollectorProcessStep#getPriority()}
   */
  @Test
  @DisplayName("Test getPriority()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer RosettaObjectCollectorProcessStep.getPriority()"})
  void testGetPriority() {
    // Arrange
    Class<RosettaModelObject> collectRosettaType = RosettaModelObject.class;
    RosettaObjectCollectorProcessStep<RosettaModelObject> rosettaObjectCollectorProcessStep =
        new RosettaObjectCollectorProcessStep<>(collectRosettaType);

    // Act and Assert
    assertEquals(3, rosettaObjectCollectorProcessStep.getPriority().intValue());
  }

  /**
   * Test RosettaObjectCollectorProcessReport getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       RosettaObjectCollectorProcessReport#RosettaObjectCollectorProcessReport(RosettaModelObject,
   *       List)}
   *   <li>{@link RosettaObjectCollectorProcessReport#getCollectedObjects()}
   *   <li>{@link RosettaObjectCollectorProcessReport#getResultObject()}
   * </ul>
   */
  @Test
  @DisplayName("Test RosettaObjectCollectorProcessReport getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RosettaObjectCollectorProcessReport.<init>(RosettaModelObject, List)",
    "List RosettaObjectCollectorProcessReport.getCollectedObjects()",
    "RosettaModelObject RosettaObjectCollectorProcessReport.getResultObject()"
  })
  void testRosettaObjectCollectorProcessReportGettersAndSetters() {
    // Arrange
    BarBuilder topClass = new BarBuilder();
    ArrayList<RosettaModelObject> collectedObjects = new ArrayList<>();

    // Act
    RosettaObjectCollectorProcessReport<RosettaModelObject>
        actualRosettaObjectCollectorProcessReport =
            new RosettaObjectCollectorProcessReport<>(topClass, collectedObjects);
    List<RosettaModelObject> actualCollectedObjects =
        actualRosettaObjectCollectorProcessReport.getCollectedObjects();
    RosettaModelObject actualResultObject =
        actualRosettaObjectCollectorProcessReport.getResultObject();

    // Assert
    assertTrue(actualCollectedObjects.isEmpty());
    assertSame(topClass, actualResultObject);
    assertSame(collectedObjects, actualCollectedObjects);
  }

  /**
   * Test {@link RosettaObjectCollectorProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <p>Method under test: {@link RosettaObjectCollectorProcessStep#runProcessStep(Class,
   * RosettaModelObject)}
   */
  @Test
  @DisplayName("Test runProcessStep(Class, RosettaModelObject)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RosettaObjectCollectorProcessReport RosettaObjectCollectorProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep() {
    // Arrange
    Class<RosettaModelObject> collectRosettaType = RosettaModelObject.class;
    RosettaObjectCollectorProcessStep<RosettaModelObject> rosettaObjectCollectorProcessStep =
        new RosettaObjectCollectorProcessStep<>(collectRosettaType);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    // Act and Assert
    RosettaModelObject resultObject =
        rosettaObjectCollectorProcessStep
            .runProcessStep(topClass, new PriceQuantityBuilderImpl())
            .getResultObject();
    FieldWithMetaPriceBuilder orCreatePrice =
        ((PriceQuantityBuilderImpl) resultObject).getOrCreatePrice();
    PriceBuilder orCreateValue = orCreatePrice.getOrCreateValue();
    assertTrue(orCreateValue instanceof PriceBuilderImpl);
    assertTrue(resultObject instanceof PriceQuantityBuilderImpl);
    assertTrue(orCreatePrice instanceof FieldWithMetaPriceBuilderImpl);
    MetaFieldsBuilder meta = orCreatePrice.getMeta();
    assertTrue(meta instanceof MetaFieldsBuilderImpl);
    assertFalse(orCreatePrice.hasData());
    Class<Price> expectedValueType = Price.class;
    assertEquals(expectedValueType, orCreatePrice.getValueType());
    Class<FieldWithMetaPrice> expectedType = FieldWithMetaPrice.class;
    assertEquals(expectedType, orCreatePrice.getType());
    assertSame(orCreateValue, orCreatePrice.getValue());
    assertSame(orCreatePrice, ((PriceQuantityBuilderImpl) resultObject).getPrice());
    assertSame(meta, orCreatePrice.getOrCreateMeta());
  }

  /**
   * Test {@link RosettaObjectCollectorProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <p>Method under test: {@link RosettaObjectCollectorProcessStep#runProcessStep(Class,
   * RosettaModelObject)}
   */
  @Test
  @DisplayName("Test runProcessStep(Class, RosettaModelObject)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RosettaObjectCollectorProcessReport RosettaObjectCollectorProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep2() {
    // Arrange
    Class<RosettaModelObject> collectRosettaType = RosettaModelObject.class;
    RosettaObjectCollectorProcessStep<RosettaModelObject> rosettaObjectCollectorProcessStep =
        new RosettaObjectCollectorProcessStep<>(collectRosettaType);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    PriceQuantityBuilderImpl priceQuantityBuilderImpl = new PriceQuantityBuilderImpl();
    FieldWithMetaPriceBuilderImpl price = new FieldWithMetaPriceBuilderImpl();
    priceQuantityBuilderImpl.setPrice(price);

    // Act
    RosettaObjectCollectorProcessReport<RosettaModelObject> actualRunProcessStepResult =
        rosettaObjectCollectorProcessStep.runProcessStep(topClass, priceQuantityBuilderImpl);

    // Assert
    RosettaModelObject resultObject = actualRunProcessStepResult.getResultObject();
    assertTrue(resultObject instanceof PriceQuantityBuilderImpl);
    List<RosettaModelObject> collectedObjects = actualRunProcessStepResult.getCollectedObjects();
    assertEquals(2, collectedObjects.size());
    assertSame(price, ((PriceQuantityBuilderImpl) resultObject).getOrCreatePrice());
    assertSame(price, ((PriceQuantityBuilderImpl) resultObject).getPrice());
    assertSame(price, collectedObjects.get(1));
  }

  /**
   * Test {@link RosettaObjectCollectorProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then return CollectedObjects second Key size is four.
   * </ul>
   *
   * <p>Method under test: {@link RosettaObjectCollectorProcessStep#runProcessStep(Class,
   * RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then return CollectedObjects second Key size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RosettaObjectCollectorProcessReport RosettaObjectCollectorProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenReturnCollectedObjectsSecondKeySizeIsFour() {
    // Arrange
    Class<RosettaModelObject> collectRosettaType = RosettaModelObject.class;
    RosettaObjectCollectorProcessStep<RosettaModelObject> rosettaObjectCollectorProcessStep =
        new RosettaObjectCollectorProcessStep<>(collectRosettaType);
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
    List<RosettaModelObject> collectedObjects =
        rosettaObjectCollectorProcessStep
            .runProcessStep(topClass, fieldWithMetaPriceBuilderImpl)
            .getCollectedObjects();
    assertEquals(4, collectedObjects.size());
    RosettaModelObject getResult = collectedObjects.get(1);
    assertTrue(getResult instanceof MetaFieldsBuilderImpl);
    List<? extends KeyBuilder> key3 = ((MetaFieldsBuilderImpl) getResult).getKey();
    assertEquals(4, key3.size());
    assertNull(key3.get(0));
    assertNull(key3.get(1));
    assertSame(key, key3.get(2));
    assertSame(key2, key3.get(3));
  }

  /**
   * Test {@link RosettaObjectCollectorProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then return CollectedObjects second Key size is two.
   * </ul>
   *
   * <p>Method under test: {@link RosettaObjectCollectorProcessStep#runProcessStep(Class,
   * RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then return CollectedObjects second Key size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RosettaObjectCollectorProcessReport RosettaObjectCollectorProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenReturnCollectedObjectsSecondKeySizeIsTwo() {
    // Arrange
    Class<RosettaModelObject> collectRosettaType = RosettaModelObject.class;
    RosettaObjectCollectorProcessStep<RosettaModelObject> rosettaObjectCollectorProcessStep =
        new RosettaObjectCollectorProcessStep<>(collectRosettaType);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    MetaFieldsBuilderImpl meta = new MetaFieldsBuilderImpl();
    meta.addKey(new KeyBuilderImpl());
    KeyBuilderImpl key = new KeyBuilderImpl();
    meta.addKey(key);

    FieldWithMetaPriceBuilderImpl fieldWithMetaPriceBuilderImpl =
        new FieldWithMetaPriceBuilderImpl();
    fieldWithMetaPriceBuilderImpl.setMeta(meta);

    // Act and Assert
    List<RosettaModelObject> collectedObjects =
        rosettaObjectCollectorProcessStep
            .runProcessStep(topClass, fieldWithMetaPriceBuilderImpl)
            .getCollectedObjects();
    assertEquals(4, collectedObjects.size());
    RosettaModelObject getResult = collectedObjects.get(1);
    assertTrue(getResult instanceof MetaFieldsBuilderImpl);
    List<? extends KeyBuilder> key2 = ((MetaFieldsBuilderImpl) getResult).getKey();
    assertEquals(2, key2.size());
    assertSame(key, collectedObjects.get(3));
    assertSame(key, key2.get(1));
  }

  /**
   * Test {@link RosettaObjectCollectorProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then return CollectedObjects size is three.
   * </ul>
   *
   * <p>Method under test: {@link RosettaObjectCollectorProcessStep#runProcessStep(Class,
   * RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then return CollectedObjects size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RosettaObjectCollectorProcessReport RosettaObjectCollectorProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenReturnCollectedObjectsSizeIsThree() {
    // Arrange
    Class<RosettaModelObject> collectRosettaType = RosettaModelObject.class;
    RosettaObjectCollectorProcessStep<RosettaModelObject> rosettaObjectCollectorProcessStep =
        new RosettaObjectCollectorProcessStep<>(collectRosettaType);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    MetaFieldsBuilderImpl meta = new MetaFieldsBuilderImpl();
    KeyBuilderImpl key = new KeyBuilderImpl();
    meta.addKey(key);

    FieldWithMetaPriceBuilderImpl fieldWithMetaPriceBuilderImpl =
        new FieldWithMetaPriceBuilderImpl();
    fieldWithMetaPriceBuilderImpl.setMeta(meta);

    // Act and Assert
    List<RosettaModelObject> collectedObjects =
        rosettaObjectCollectorProcessStep
            .runProcessStep(topClass, fieldWithMetaPriceBuilderImpl)
            .getCollectedObjects();
    assertEquals(3, collectedObjects.size());
    RosettaModelObject getResult = collectedObjects.get(1);
    assertTrue(getResult instanceof MetaFieldsBuilderImpl);
    List<? extends KeyBuilder> key2 = ((MetaFieldsBuilderImpl) getResult).getKey();
    assertEquals(1, key2.size());
    assertSame(key, key2.get(0));
  }

  /**
   * Test {@link RosettaObjectCollectorProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then return ResultObject Meta is {@link MetaFieldsBuilderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link RosettaObjectCollectorProcessStep#runProcessStep(Class,
   * RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then return ResultObject Meta is MetaFieldsBuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RosettaObjectCollectorProcessReport RosettaObjectCollectorProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenReturnResultObjectMetaIsMetaFieldsBuilderImpl() {
    // Arrange
    Class<RosettaModelObject> collectRosettaType = RosettaModelObject.class;
    RosettaObjectCollectorProcessStep<RosettaModelObject> rosettaObjectCollectorProcessStep =
        new RosettaObjectCollectorProcessStep<>(collectRosettaType);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    FieldWithMetaPriceBuilderImpl fieldWithMetaPriceBuilderImpl =
        new FieldWithMetaPriceBuilderImpl();
    MetaFieldsBuilderImpl meta = new MetaFieldsBuilderImpl();
    fieldWithMetaPriceBuilderImpl.setMeta(meta);

    // Act
    RosettaObjectCollectorProcessReport<RosettaModelObject> actualRunProcessStepResult =
        rosettaObjectCollectorProcessStep.runProcessStep(topClass, fieldWithMetaPriceBuilderImpl);

    // Assert
    RosettaModelObject resultObject = actualRunProcessStepResult.getResultObject();
    assertTrue(resultObject instanceof FieldWithMetaPriceBuilderImpl);
    List<RosettaModelObject> collectedObjects = actualRunProcessStepResult.getCollectedObjects();
    assertEquals(2, collectedObjects.size());
    assertSame(meta, ((FieldWithMetaPriceBuilderImpl) resultObject).getMeta());
    assertSame(meta, ((FieldWithMetaPriceBuilderImpl) resultObject).getOrCreateMeta());
    assertSame(meta, collectedObjects.get(1));
  }

  /**
   * Test {@link RosettaObjectCollectorProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>When {@link KeyBuilderImpl} (default constructor).
   *   <li>Then return ResultObject is {@link KeyBuilderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link RosettaObjectCollectorProcessStep#runProcessStep(Class,
   * RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); when KeyBuilderImpl (default constructor); then return ResultObject is KeyBuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RosettaObjectCollectorProcessReport RosettaObjectCollectorProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_whenKeyBuilderImpl_thenReturnResultObjectIsKeyBuilderImpl() {
    // Arrange
    Class<RosettaModelObject> collectRosettaType = RosettaModelObject.class;
    RosettaObjectCollectorProcessStep<RosettaModelObject> rosettaObjectCollectorProcessStep =
        new RosettaObjectCollectorProcessStep<>(collectRosettaType);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    KeyBuilderImpl keyBuilderImpl = new KeyBuilderImpl();

    // Act
    RosettaObjectCollectorProcessReport<RosettaModelObject> actualRunProcessStepResult =
        rosettaObjectCollectorProcessStep.runProcessStep(topClass, keyBuilderImpl);

    // Assert
    List<RosettaModelObject> collectedObjects = actualRunProcessStepResult.getCollectedObjects();
    assertEquals(1, collectedObjects.size());
    assertSame(keyBuilderImpl, actualRunProcessStepResult.getResultObject());
    assertSame(keyBuilderImpl, collectedObjects.get(0));
  }

  /**
   * Test {@link RosettaObjectCollectorProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>When {@link Price.PriceBuilderImpl} (default constructor).
   *   <li>Then return ResultObject is {@link Price.PriceBuilderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link RosettaObjectCollectorProcessStep#runProcessStep(Class,
   * RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); when PriceBuilderImpl (default constructor); then return ResultObject is PriceBuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RosettaObjectCollectorProcessReport RosettaObjectCollectorProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_whenPriceBuilderImpl_thenReturnResultObjectIsPriceBuilderImpl() {
    // Arrange
    Class<RosettaModelObject> collectRosettaType = RosettaModelObject.class;
    RosettaObjectCollectorProcessStep<RosettaModelObject> rosettaObjectCollectorProcessStep =
        new RosettaObjectCollectorProcessStep<>(collectRosettaType);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    PriceBuilderImpl priceBuilderImpl = new PriceBuilderImpl();

    // Act
    RosettaObjectCollectorProcessReport<RosettaModelObject> actualRunProcessStepResult =
        rosettaObjectCollectorProcessStep.runProcessStep(topClass, priceBuilderImpl);

    // Assert
    List<RosettaModelObject> collectedObjects = actualRunProcessStepResult.getCollectedObjects();
    assertEquals(1, collectedObjects.size());
    assertSame(priceBuilderImpl, actualRunProcessStepResult.getResultObject());
    assertSame(priceBuilderImpl, collectedObjects.get(0));
  }
}
