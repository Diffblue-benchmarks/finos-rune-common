package com.regnosys.rosetta.common.hashing;

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
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.regnosys.rosetta.common.merger.BarBuilder;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.Price;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.PriceQuantity;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.FieldWithMetaPrice;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.MetaFields;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.meta.Key;
import com.rosetta.model.lib.meta.Reference;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.AttributeMeta;
import com.rosetta.model.lib.process.Processor;
import java.util.HashMap;
import java.util.function.Supplier;
import org.junit.Test;

public class GlobalKeyProcessStepDiffblueTest {
  /**
   * Method under test: {@link GlobalKeyProcessStep#getPriority()}
   */
  @Test
  public void testGetPriority() {
    // Arrange, Act and Assert
    assertEquals(1, (new GlobalKeyProcessStep(mock(Supplier.class))).getPriority().intValue());
  }

  /**
   * Method under test:
   * {@link GlobalKeyProcessStep.KeyPostProcessReport#getResultObject()}
   */
  @Test
  public void testKeyPostProcessReportGetResultObject() {
    // Arrange
    GlobalKeyProcessStep globalKeyProcessStep = new GlobalKeyProcessStep(mock(Supplier.class));
    BarBuilder result = new BarBuilder();

    // Act and Assert
    assertSame(result, (globalKeyProcessStep.new KeyPostProcessReport(result, new HashMap<>())).getResultObject());
  }

  /**
   * Method under test:
   * {@link GlobalKeyProcessStep.ReKeyProcessor#processRosetta(RosettaPath, Class, RosettaModelObjectBuilder, RosettaModelObjectBuilder, AttributeMeta[])}
   */
  @Test
  public void testReKeyProcessorProcessRosetta() {
    // Arrange
    GlobalKeyProcessStep globalKeyProcessStep = new GlobalKeyProcessStep(mock(Supplier.class));
    GlobalKeyProcessStep globalKeyProcessStep2 = new GlobalKeyProcessStep(mock(Supplier.class));
    BarBuilder result = new BarBuilder();
    GlobalKeyProcessStep.ReKeyProcessor reKeyProcessor = globalKeyProcessStep.new ReKeyProcessor(
        globalKeyProcessStep2.new KeyPostProcessReport(result, new HashMap<>()));
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;
    BarBuilder builder = new BarBuilder();

    // Act and Assert
    assertFalse(reKeyProcessor.processRosetta(path, rosettaType, builder, new BarBuilder(), AttributeMeta.META));
  }

  /**
   * Method under test:
   * {@link GlobalKeyProcessStep.ReKeyProcessor#processRosetta(RosettaPath, Class, RosettaModelObjectBuilder, RosettaModelObjectBuilder, AttributeMeta[])}
   */
  @Test
  public void testReKeyProcessorProcessRosetta2() {
    // Arrange
    GlobalKeyProcessStep globalKeyProcessStep = new GlobalKeyProcessStep(mock(Supplier.class));
    GlobalKeyProcessStep globalKeyProcessStep2 = new GlobalKeyProcessStep(mock(Supplier.class));
    BarBuilder result = new BarBuilder();
    GlobalKeyProcessStep.ReKeyProcessor reKeyProcessor = globalKeyProcessStep.new ReKeyProcessor(
        globalKeyProcessStep2.new KeyPostProcessReport(result, new HashMap<>()));
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;

    // Act and Assert
    assertFalse(reKeyProcessor.processRosetta(path, rosettaType, (RosettaModelObjectBuilder) null, new BarBuilder(),
        AttributeMeta.META));
  }

  /**
   * Method under test:
   * {@link GlobalKeyProcessStep.ReKeyProcessor#processRosetta(RosettaPath, Class, RosettaModelObjectBuilder, RosettaModelObjectBuilder, AttributeMeta[])}
   */
  @Test
  public void testReKeyProcessorProcessRosetta3() {
    // Arrange
    GlobalKeyProcessStep globalKeyProcessStep = new GlobalKeyProcessStep(mock(Supplier.class));
    GlobalKeyProcessStep globalKeyProcessStep2 = new GlobalKeyProcessStep(mock(Supplier.class));
    BarBuilder result = new BarBuilder();
    GlobalKeyProcessStep.ReKeyProcessor reKeyProcessor = globalKeyProcessStep.new ReKeyProcessor(
        globalKeyProcessStep2.new KeyPostProcessReport(result, new HashMap<>()));
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;

    BarBuilder builder = new BarBuilder();
    builder.setNum(10);

    // Act and Assert
    assertTrue(reKeyProcessor.processRosetta(path, rosettaType, builder, new BarBuilder(), AttributeMeta.META));
  }

  /**
   * Method under test:
   * {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  public void testRunProcessStep() {
    // Arrange
    GlobalKeyProcessStep globalKeyProcessStep = new GlobalKeyProcessStep(mock(Supplier.class));
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    Key.KeyBuilderImpl keyBuilderImpl = new Key.KeyBuilderImpl();

    // Act
    GlobalKeyProcessStep.KeyPostProcessReport actualRunProcessStepResult = globalKeyProcessStep.runProcessStep(topClass,
        keyBuilderImpl);

    // Assert
    assertTrue(actualRunProcessStepResult.getKeyMap().isEmpty());
    assertSame(keyBuilderImpl, actualRunProcessStepResult.getResultObject());
  }

  /**
   * Method under test:
   * {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  public void testRunProcessStep2() {
    // Arrange
    GlobalKeyProcessStep globalKeyProcessStep = new GlobalKeyProcessStep(mock(Supplier.class));
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    // Act
    GlobalKeyProcessStep.KeyPostProcessReport actualRunProcessStepResult = globalKeyProcessStep.runProcessStep(topClass,
        new Reference.ReferenceImpl("method toBuilder in BarBuilder has not been implemented",
            "alice.liddell@example.org", "method toBuilder in BarBuilder has not been implemented"));

    // Assert
    RosettaModelObjectBuilder resultObject = actualRunProcessStepResult.getResultObject();
    assertTrue(resultObject instanceof Reference.ReferenceBuilderImpl);
    assertEquals("alice.liddell@example.org", ((Reference.ReferenceBuilderImpl) resultObject).getPointsTo());
    assertEquals("method toBuilder in BarBuilder has not been implemented",
        ((Reference.ReferenceBuilderImpl) resultObject).getReference());
    assertEquals("method toBuilder in BarBuilder has not been implemented",
        ((Reference.ReferenceBuilderImpl) resultObject).getScope());
    assertTrue(resultObject.hasData());
    assertTrue(actualRunProcessStepResult.getKeyMap().isEmpty());
    Class<Reference> expectedType = Reference.class;
    assertEquals(expectedType, resultObject.getType());
  }

  /**
   * Method under test:
   * {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  public void testRunProcessStep3() {
    // Arrange
    GlobalKeyProcessStep globalKeyProcessStep = new GlobalKeyProcessStep(mock(Supplier.class));
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    Price.PriceBuilderImpl priceBuilderImpl = new Price.PriceBuilderImpl();

    // Act
    GlobalKeyProcessStep.KeyPostProcessReport actualRunProcessStepResult = globalKeyProcessStep.runProcessStep(topClass,
        priceBuilderImpl);

    // Assert
    assertTrue(actualRunProcessStepResult.getKeyMap().isEmpty());
    assertSame(priceBuilderImpl, actualRunProcessStepResult.getResultObject());
  }

  /**
   * Method under test:
   * {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  public void testRunProcessStep4() {
    // Arrange
    GlobalKeyProcessStep globalKeyProcessStep = new GlobalKeyProcessStep(mock(Supplier.class));
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    PriceQuantity.PriceQuantityBuilderImpl priceQuantityBuilderImpl = new PriceQuantity.PriceQuantityBuilderImpl();

    // Act
    GlobalKeyProcessStep.KeyPostProcessReport actualRunProcessStepResult = globalKeyProcessStep.runProcessStep(topClass,
        priceQuantityBuilderImpl);

    // Assert
    assertTrue(actualRunProcessStepResult.getKeyMap().isEmpty());
    assertSame(priceQuantityBuilderImpl, actualRunProcessStepResult.getResultObject());
  }

  /**
   * Method under test:
   * {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  public void testRunProcessStep5() {
    // Arrange
    GlobalKeyProcessStep globalKeyProcessStep = new GlobalKeyProcessStep(mock(Supplier.class));
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl fieldWithMetaPriceBuilderImpl = new FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl();

    // Act
    GlobalKeyProcessStep.KeyPostProcessReport actualRunProcessStepResult = globalKeyProcessStep.runProcessStep(topClass,
        fieldWithMetaPriceBuilderImpl);

    // Assert
    assertTrue(actualRunProcessStepResult.getKeyMap().isEmpty());
    assertSame(fieldWithMetaPriceBuilderImpl, actualRunProcessStepResult.getResultObject());
  }

  /**
   * Method under test:
   * {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  public void testRunProcessStep6() {
    // Arrange
    GlobalKeyProcessStep globalKeyProcessStep = new GlobalKeyProcessStep(mock(Supplier.class));
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    PriceQuantity.PriceQuantityBuilderImpl priceQuantityBuilderImpl = new PriceQuantity.PriceQuantityBuilderImpl();
    priceQuantityBuilderImpl.setPrice(new FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl());

    // Act
    GlobalKeyProcessStep.KeyPostProcessReport actualRunProcessStepResult = globalKeyProcessStep.runProcessStep(topClass,
        priceQuantityBuilderImpl);

    // Assert
    assertTrue(actualRunProcessStepResult.getKeyMap().isEmpty());
    assertSame(priceQuantityBuilderImpl, actualRunProcessStepResult.getResultObject());
  }

  /**
   * Method under test:
   * {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  public void testRunProcessStep7() {
    // Arrange
    GlobalKeyProcessStep globalKeyProcessStep = new GlobalKeyProcessStep(mock(Supplier.class));
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    MetaFields.MetaFieldsBuilderImpl metaFieldsBuilderImpl = new MetaFields.MetaFieldsBuilderImpl();

    // Act
    GlobalKeyProcessStep.KeyPostProcessReport actualRunProcessStepResult = globalKeyProcessStep.runProcessStep(topClass,
        metaFieldsBuilderImpl);

    // Assert
    assertTrue(actualRunProcessStepResult.getKeyMap().isEmpty());
    assertSame(metaFieldsBuilderImpl, actualRunProcessStepResult.getResultObject());
  }

  /**
   * Method under test:
   * {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  public void testRunProcessStep8() {
    // Arrange
    GlobalKeyProcessStep globalKeyProcessStep = new GlobalKeyProcessStep(mock(Supplier.class));
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    MetaFields.MetaFieldsBuilderImpl metaFieldsBuilderImpl = new MetaFields.MetaFieldsBuilderImpl();
    metaFieldsBuilderImpl.addKey(new Key.KeyBuilderImpl());

    // Act
    GlobalKeyProcessStep.KeyPostProcessReport actualRunProcessStepResult = globalKeyProcessStep.runProcessStep(topClass,
        metaFieldsBuilderImpl);

    // Assert
    assertTrue(actualRunProcessStepResult.getKeyMap().isEmpty());
    assertSame(metaFieldsBuilderImpl, actualRunProcessStepResult.getResultObject());
  }

  /**
   * Method under test:
   * {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  public void testRunProcessStep9() {
    // Arrange
    GlobalKeyProcessStep globalKeyProcessStep = new GlobalKeyProcessStep(mock(Supplier.class));
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    MetaFields.MetaFieldsBuilderImpl metaFieldsBuilderImpl = new MetaFields.MetaFieldsBuilderImpl();
    metaFieldsBuilderImpl.addKey(new Key.KeyBuilderImpl());
    metaFieldsBuilderImpl.addKey(new Key.KeyBuilderImpl());

    // Act
    GlobalKeyProcessStep.KeyPostProcessReport actualRunProcessStepResult = globalKeyProcessStep.runProcessStep(topClass,
        metaFieldsBuilderImpl);

    // Assert
    assertTrue(actualRunProcessStepResult.getKeyMap().isEmpty());
    assertSame(metaFieldsBuilderImpl, actualRunProcessStepResult.getResultObject());
  }

  /**
   * Method under test:
   * {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  public void testRunProcessStep10() {
    // Arrange
    GlobalKeyProcessStep globalKeyProcessStep = new GlobalKeyProcessStep(mock(Supplier.class));
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    MetaFields.MetaFieldsBuilderImpl metaFieldsBuilderImpl = new MetaFields.MetaFieldsBuilderImpl();
    metaFieldsBuilderImpl.addKey(new Key.KeyBuilderImpl(), 2);
    metaFieldsBuilderImpl.addKey(new Key.KeyBuilderImpl());

    // Act
    GlobalKeyProcessStep.KeyPostProcessReport actualRunProcessStepResult = globalKeyProcessStep.runProcessStep(topClass,
        metaFieldsBuilderImpl);

    // Assert
    assertTrue(actualRunProcessStepResult.getKeyMap().isEmpty());
    assertSame(metaFieldsBuilderImpl, actualRunProcessStepResult.getResultObject());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GlobalKeyProcessStep#GlobalKeyProcessStep(Supplier)}
   *   <li>{@link GlobalKeyProcessStep#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("GlobalKey postProcessor", (new GlobalKeyProcessStep(mock(Supplier.class))).getName());
  }
}
