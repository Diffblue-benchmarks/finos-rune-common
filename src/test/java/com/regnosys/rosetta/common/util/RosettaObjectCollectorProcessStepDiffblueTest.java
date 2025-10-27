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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.regnosys.rosetta.common.merger.BarBuilder;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.Price;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.PriceQuantity;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.FieldWithMetaPrice;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.MetaFields;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.meta.Key;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class RosettaObjectCollectorProcessStepDiffblueTest {
  /**
   * Method under test: {@link RosettaObjectCollectorProcessStep#getPriority()}
   */
  @Test
  public void testGetPriority() {
    // Arrange
    Class<RosettaModelObject> collectRosettaType = RosettaModelObject.class;
    RosettaObjectCollectorProcessStep<RosettaModelObject> rosettaObjectCollectorProcessStep = new RosettaObjectCollectorProcessStep<>(
        collectRosettaType);

    // Act and Assert
    assertEquals(3, rosettaObjectCollectorProcessStep.getPriority().intValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link RosettaObjectCollectorProcessStep.RosettaObjectCollectorProcessReport#RosettaObjectCollectorProcessReport(RosettaModelObject, List)}
   *   <li>
   * {@link RosettaObjectCollectorProcessStep.RosettaObjectCollectorProcessReport#getCollectedObjects()}
   *   <li>
   * {@link RosettaObjectCollectorProcessStep.RosettaObjectCollectorProcessReport#getResultObject()}
   * </ul>
   */
  @Test
  public void testRosettaObjectCollectorProcessReportGettersAndSetters() {
    // Arrange
    BarBuilder topClass = new BarBuilder();
    ArrayList<RosettaModelObject> collectedObjects = new ArrayList<>();

    // Act
    RosettaObjectCollectorProcessStep.RosettaObjectCollectorProcessReport<RosettaModelObject> actualRosettaObjectCollectorProcessReport = new RosettaObjectCollectorProcessStep.RosettaObjectCollectorProcessReport<>(
        topClass, collectedObjects);
    List<RosettaModelObject> actualCollectedObjects = actualRosettaObjectCollectorProcessReport.getCollectedObjects();
    RosettaModelObject actualResultObject = actualRosettaObjectCollectorProcessReport.getResultObject();

    // Assert
    assertTrue(actualCollectedObjects.isEmpty());
    assertSame(topClass, actualResultObject);
    assertSame(collectedObjects, actualCollectedObjects);
  }

  /**
   * Method under test:
   * {@link RosettaObjectCollectorProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  public void testRunProcessStep() {
    // Arrange
    Class<RosettaModelObject> collectRosettaType = RosettaModelObject.class;
    RosettaObjectCollectorProcessStep<RosettaModelObject> rosettaObjectCollectorProcessStep = new RosettaObjectCollectorProcessStep<>(
        collectRosettaType);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    Key.KeyBuilderImpl keyBuilderImpl = new Key.KeyBuilderImpl();

    // Act
    RosettaObjectCollectorProcessStep.RosettaObjectCollectorProcessReport<RosettaModelObject> actualRunProcessStepResult = rosettaObjectCollectorProcessStep
        .runProcessStep(topClass, keyBuilderImpl);

    // Assert
    List<RosettaModelObject> collectedObjects = actualRunProcessStepResult.getCollectedObjects();
    assertEquals(1, collectedObjects.size());
    assertSame(keyBuilderImpl, actualRunProcessStepResult.getResultObject());
    assertSame(keyBuilderImpl, collectedObjects.get(0));
  }

  /**
   * Method under test:
   * {@link RosettaObjectCollectorProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  public void testRunProcessStep2() {
    // Arrange
    Class<RosettaModelObject> collectRosettaType = RosettaModelObject.class;
    RosettaObjectCollectorProcessStep<RosettaModelObject> rosettaObjectCollectorProcessStep = new RosettaObjectCollectorProcessStep<>(
        collectRosettaType);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    Price.PriceBuilderImpl priceBuilderImpl = new Price.PriceBuilderImpl();

    // Act
    RosettaObjectCollectorProcessStep.RosettaObjectCollectorProcessReport<RosettaModelObject> actualRunProcessStepResult = rosettaObjectCollectorProcessStep
        .runProcessStep(topClass, priceBuilderImpl);

    // Assert
    List<RosettaModelObject> collectedObjects = actualRunProcessStepResult.getCollectedObjects();
    assertEquals(1, collectedObjects.size());
    assertSame(priceBuilderImpl, actualRunProcessStepResult.getResultObject());
    assertSame(priceBuilderImpl, collectedObjects.get(0));
  }

  /**
   * Method under test:
   * {@link RosettaObjectCollectorProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  public void testRunProcessStep3() {
    // Arrange
    Class<RosettaModelObject> collectRosettaType = RosettaModelObject.class;
    RosettaObjectCollectorProcessStep<RosettaModelObject> rosettaObjectCollectorProcessStep = new RosettaObjectCollectorProcessStep<>(
        collectRosettaType);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    PriceQuantity.PriceQuantityBuilderImpl priceQuantityBuilderImpl = new PriceQuantity.PriceQuantityBuilderImpl();

    // Act
    RosettaObjectCollectorProcessStep.RosettaObjectCollectorProcessReport<RosettaModelObject> actualRunProcessStepResult = rosettaObjectCollectorProcessStep
        .runProcessStep(topClass, priceQuantityBuilderImpl);

    // Assert
    List<RosettaModelObject> collectedObjects = actualRunProcessStepResult.getCollectedObjects();
    assertEquals(1, collectedObjects.size());
    assertSame(priceQuantityBuilderImpl, actualRunProcessStepResult.getResultObject());
    assertSame(priceQuantityBuilderImpl, collectedObjects.get(0));
  }

  /**
   * Method under test:
   * {@link RosettaObjectCollectorProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  public void testRunProcessStep4() {
    // Arrange
    Class<RosettaModelObject> collectRosettaType = RosettaModelObject.class;
    RosettaObjectCollectorProcessStep<RosettaModelObject> rosettaObjectCollectorProcessStep = new RosettaObjectCollectorProcessStep<>(
        collectRosettaType);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl fieldWithMetaPriceBuilderImpl = new FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl();

    // Act
    RosettaObjectCollectorProcessStep.RosettaObjectCollectorProcessReport<RosettaModelObject> actualRunProcessStepResult = rosettaObjectCollectorProcessStep
        .runProcessStep(topClass, fieldWithMetaPriceBuilderImpl);

    // Assert
    List<RosettaModelObject> collectedObjects = actualRunProcessStepResult.getCollectedObjects();
    assertEquals(1, collectedObjects.size());
    assertSame(fieldWithMetaPriceBuilderImpl, actualRunProcessStepResult.getResultObject());
    assertSame(fieldWithMetaPriceBuilderImpl, collectedObjects.get(0));
  }

  /**
   * Method under test:
   * {@link RosettaObjectCollectorProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  public void testRunProcessStep5() {
    // Arrange
    Class<RosettaModelObject> collectRosettaType = RosettaModelObject.class;
    RosettaObjectCollectorProcessStep<RosettaModelObject> rosettaObjectCollectorProcessStep = new RosettaObjectCollectorProcessStep<>(
        collectRosettaType);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    PriceQuantity.PriceQuantityBuilderImpl priceQuantityBuilderImpl = new PriceQuantity.PriceQuantityBuilderImpl();
    FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl price = new FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl();
    priceQuantityBuilderImpl.setPrice(price);

    // Act
    RosettaObjectCollectorProcessStep.RosettaObjectCollectorProcessReport<RosettaModelObject> actualRunProcessStepResult = rosettaObjectCollectorProcessStep
        .runProcessStep(topClass, priceQuantityBuilderImpl);

    // Assert
    List<RosettaModelObject> collectedObjects = actualRunProcessStepResult.getCollectedObjects();
    assertEquals(2, collectedObjects.size());
    assertSame(priceQuantityBuilderImpl, actualRunProcessStepResult.getResultObject());
    assertSame(priceQuantityBuilderImpl, collectedObjects.get(0));
    assertSame(price, collectedObjects.get(1));
  }

  /**
   * Method under test:
   * {@link RosettaObjectCollectorProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  public void testRunProcessStep6() {
    // Arrange
    Class<RosettaModelObject> collectRosettaType = RosettaModelObject.class;
    RosettaObjectCollectorProcessStep<RosettaModelObject> rosettaObjectCollectorProcessStep = new RosettaObjectCollectorProcessStep<>(
        collectRosettaType);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl fieldWithMetaPriceBuilderImpl = new FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl();
    MetaFields.MetaFieldsBuilderImpl meta = new MetaFields.MetaFieldsBuilderImpl();
    fieldWithMetaPriceBuilderImpl.setMeta(meta);

    // Act
    RosettaObjectCollectorProcessStep.RosettaObjectCollectorProcessReport<RosettaModelObject> actualRunProcessStepResult = rosettaObjectCollectorProcessStep
        .runProcessStep(topClass, fieldWithMetaPriceBuilderImpl);

    // Assert
    List<RosettaModelObject> collectedObjects = actualRunProcessStepResult.getCollectedObjects();
    assertEquals(2, collectedObjects.size());
    assertSame(fieldWithMetaPriceBuilderImpl, actualRunProcessStepResult.getResultObject());
    assertSame(fieldWithMetaPriceBuilderImpl, collectedObjects.get(0));
    assertSame(meta, collectedObjects.get(1));
  }

  /**
   * Method under test:
   * {@link RosettaObjectCollectorProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  public void testRunProcessStep7() {
    // Arrange
    Class<RosettaModelObject> collectRosettaType = RosettaModelObject.class;
    RosettaObjectCollectorProcessStep<RosettaModelObject> rosettaObjectCollectorProcessStep = new RosettaObjectCollectorProcessStep<>(
        collectRosettaType);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    MetaFields.MetaFieldsBuilderImpl meta = new MetaFields.MetaFieldsBuilderImpl();
    Key.KeyBuilderImpl key = new Key.KeyBuilderImpl();
    meta.addKey(key);

    FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl fieldWithMetaPriceBuilderImpl = new FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl();
    fieldWithMetaPriceBuilderImpl.setMeta(meta);

    // Act
    RosettaObjectCollectorProcessStep.RosettaObjectCollectorProcessReport<RosettaModelObject> actualRunProcessStepResult = rosettaObjectCollectorProcessStep
        .runProcessStep(topClass, fieldWithMetaPriceBuilderImpl);

    // Assert
    List<RosettaModelObject> collectedObjects = actualRunProcessStepResult.getCollectedObjects();
    assertEquals(3, collectedObjects.size());
    assertSame(fieldWithMetaPriceBuilderImpl, actualRunProcessStepResult.getResultObject());
    assertSame(fieldWithMetaPriceBuilderImpl, collectedObjects.get(0));
    assertSame(meta, collectedObjects.get(1));
    assertSame(key, collectedObjects.get(2));
  }

  /**
   * Method under test:
   * {@link RosettaObjectCollectorProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  public void testRunProcessStep8() {
    // Arrange
    Class<RosettaModelObject> collectRosettaType = RosettaModelObject.class;
    RosettaObjectCollectorProcessStep<RosettaModelObject> rosettaObjectCollectorProcessStep = new RosettaObjectCollectorProcessStep<>(
        collectRosettaType);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    MetaFields.MetaFieldsBuilderImpl meta = new MetaFields.MetaFieldsBuilderImpl();
    Key.KeyBuilderImpl key = new Key.KeyBuilderImpl();
    meta.addKey(key);
    Key.KeyBuilderImpl key2 = new Key.KeyBuilderImpl();
    meta.addKey(key2);

    FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl fieldWithMetaPriceBuilderImpl = new FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl();
    fieldWithMetaPriceBuilderImpl.setMeta(meta);

    // Act
    RosettaObjectCollectorProcessStep.RosettaObjectCollectorProcessReport<RosettaModelObject> actualRunProcessStepResult = rosettaObjectCollectorProcessStep
        .runProcessStep(topClass, fieldWithMetaPriceBuilderImpl);

    // Assert
    List<RosettaModelObject> collectedObjects = actualRunProcessStepResult.getCollectedObjects();
    assertEquals(4, collectedObjects.size());
    assertSame(fieldWithMetaPriceBuilderImpl, actualRunProcessStepResult.getResultObject());
    assertSame(fieldWithMetaPriceBuilderImpl, collectedObjects.get(0));
    assertSame(meta, collectedObjects.get(1));
    assertSame(key, collectedObjects.get(2));
    assertSame(key2, collectedObjects.get(3));
  }

  /**
   * Method under test:
   * {@link RosettaObjectCollectorProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  public void testRunProcessStep9() {
    // Arrange
    Class<RosettaModelObject> collectRosettaType = RosettaModelObject.class;
    RosettaObjectCollectorProcessStep<RosettaModelObject> rosettaObjectCollectorProcessStep = new RosettaObjectCollectorProcessStep<>(
        collectRosettaType);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    MetaFields.MetaFieldsBuilderImpl meta = new MetaFields.MetaFieldsBuilderImpl();
    Key.KeyBuilderImpl key = new Key.KeyBuilderImpl();
    meta.addKey(key, 2);
    Key.KeyBuilderImpl key2 = new Key.KeyBuilderImpl();
    meta.addKey(key2);

    FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl fieldWithMetaPriceBuilderImpl = new FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl();
    fieldWithMetaPriceBuilderImpl.setMeta(meta);

    // Act
    RosettaObjectCollectorProcessStep.RosettaObjectCollectorProcessReport<RosettaModelObject> actualRunProcessStepResult = rosettaObjectCollectorProcessStep
        .runProcessStep(topClass, fieldWithMetaPriceBuilderImpl);

    // Assert
    List<RosettaModelObject> collectedObjects = actualRunProcessStepResult.getCollectedObjects();
    assertEquals(4, collectedObjects.size());
    assertSame(fieldWithMetaPriceBuilderImpl, actualRunProcessStepResult.getResultObject());
    assertSame(fieldWithMetaPriceBuilderImpl, collectedObjects.get(0));
    assertSame(meta, collectedObjects.get(1));
    assertSame(key, collectedObjects.get(2));
    assertSame(key2, collectedObjects.get(3));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link RosettaObjectCollectorProcessStep#RosettaObjectCollectorProcessStep(Class)}
   *   <li>{@link RosettaObjectCollectorProcessStep#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Class<RosettaModelObject> collectRosettaType = RosettaModelObject.class;

    // Act
    RosettaObjectCollectorProcessStep<RosettaModelObject> actualRosettaObjectCollectorProcessStep = new RosettaObjectCollectorProcessStep<>(
        collectRosettaType);

    // Assert
    assertEquals("RosettaObjectCollector postProcessor", actualRosettaObjectCollectorProcessStep.getName());
  }
}
