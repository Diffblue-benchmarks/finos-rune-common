package com.regnosys.rosetta.common.hashing;

/*-
 * ==============
 * Rune Common
 * ==============
 * Copyright (C) 2018 - 2026 REGnosys
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
import com.regnosys.rosetta.common.hashing.ReKeyProcessStep.ReKeyPostProcessReport;
import com.regnosys.rosetta.common.merger.BarBuilder;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.Price;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.Price.PriceBuilderImpl;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.PriceQuantity;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.PriceQuantity.PriceQuantityBuilderImpl;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.FieldWithMetaPrice;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.FieldWithMetaPrice.FieldWithMetaPriceBuilder;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.MetaFields;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.MetaFields.MetaFieldsBuilder;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.MetaFields.MetaFieldsBuilderImpl;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.ReferenceWithMetaPrice;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.ReferenceWithMetaPrice.ReferenceWithMetaPriceBuilderImpl;
import com.rosetta.lib.postprocess.PostProcessorReport;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.meta.Key;
import com.rosetta.model.lib.meta.Key.KeyBuilder;
import com.rosetta.model.lib.meta.Key.KeyBuilderImpl;
import com.rosetta.model.lib.meta.Reference;
import com.rosetta.model.lib.meta.Reference.ReferenceBuilderImpl;
import com.rosetta.model.lib.meta.Reference.ReferenceImpl;
import java.util.List;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReKeyProcessStepDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReKeyProcessStep#ReKeyProcessStep(GlobalKeyProcessStep)}
   *   <li>{@link ReKeyProcessStep#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReKeyProcessStep.<init>(GlobalKeyProcessStep)",
    "java.lang.String ReKeyProcessStep.getName()"
  })
  void testGettersAndSetters() {
    // Arrange
    GlobalKeyProcessStep keyProcessor = new GlobalKeyProcessStep(mock(Supplier.class));

    // Act and Assert
    assertEquals("Re-key PostProcessor", new ReKeyProcessStep(keyProcessor).getName());
  }

  /**
   * Test ReKeyPostProcessReport {@link ReKeyPostProcessReport#getResultObject()}.
   *
   * <p>Method under test: {@link ReKeyPostProcessReport#getResultObject()}
   */
  @Test
  @DisplayName("Test ReKeyPostProcessReport getResultObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RosettaModelObjectBuilder ReKeyPostProcessReport.getResultObject()"})
  void testReKeyPostProcessReportGetResultObject() {
    // Arrange
    GlobalKeyProcessStep keyProcessor = new GlobalKeyProcessStep(mock(Supplier.class));
    ReKeyProcessStep reKeyProcessStep = new ReKeyProcessStep(keyProcessor);
    BarBuilder result = new BarBuilder();

    // Act and Assert
    assertSame(result, reKeyProcessStep.new ReKeyPostProcessReport(result).getResultObject());
  }

  /**
   * Test ReKeyPostProcessReport {@link
   * ReKeyPostProcessReport#ReKeyPostProcessReport(ReKeyProcessStep, RosettaModelObjectBuilder)}.
   *
   * <p>Method under test: {@link ReKeyPostProcessReport#ReKeyPostProcessReport(ReKeyProcessStep,
   * RosettaModelObjectBuilder)}
   */
  @Test
  @DisplayName(
      "Test ReKeyPostProcessReport new ReKeyPostProcessReport(ReKeyProcessStep, RosettaModelObjectBuilder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReKeyPostProcessReport.<init>(ReKeyProcessStep, RosettaModelObjectBuilder)"
  })
  void testReKeyPostProcessReportNewReKeyPostProcessReport() {
    // Arrange
    GlobalKeyProcessStep keyProcessor = new GlobalKeyProcessStep(mock(Supplier.class));
    ReKeyProcessStep reKeyProcessStep = new ReKeyProcessStep(keyProcessor);
    BarBuilder result = new BarBuilder();

    // Act and Assert
    assertSame(result, reKeyProcessStep.new ReKeyPostProcessReport(result).getResultObject());
  }

  /**
   * Test {@link ReKeyProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <p>Method under test: {@link ReKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @DisplayName("Test runProcessStep(Class, RosettaModelObject)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PostProcessorReport ReKeyProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep() {
    // Arrange
    GlobalKeyProcessStep keyProcessor = new GlobalKeyProcessStep(mock(Supplier.class));
    ReKeyProcessStep reKeyProcessStep = new ReKeyProcessStep(keyProcessor);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    FieldWithMetaPriceBuilderImpl price = new FieldWithMetaPriceBuilderImpl();
    price.setMeta(new MetaFieldsBuilderImpl());

    PriceQuantityBuilderImpl priceQuantityBuilderImpl = new PriceQuantityBuilderImpl();
    priceQuantityBuilderImpl.setPrice(price);

    // Act
    PostProcessorReport actualRunProcessStepResult =
        reKeyProcessStep.runProcessStep(topClass, priceQuantityBuilderImpl);
    actualRunProcessStepResult.getResultObject();

    // Assert
    assertTrue(actualRunProcessStepResult instanceof ReKeyPostProcessReport);
    RosettaModelObject resultObject = actualRunProcessStepResult.getResultObject();
    assertTrue(resultObject instanceof PriceQuantityBuilderImpl);
    assertSame(price, ((PriceQuantityBuilderImpl) resultObject).getOrCreatePrice());
    assertSame(price, ((PriceQuantityBuilderImpl) resultObject).getPrice());
  }

  /**
   * Test {@link ReKeyProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <p>Method under test: {@link ReKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @DisplayName("Test runProcessStep(Class, RosettaModelObject)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PostProcessorReport ReKeyProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep2() {
    // Arrange
    GlobalKeyProcessStep keyProcessor = new GlobalKeyProcessStep(mock(Supplier.class));
    ReKeyProcessStep reKeyProcessStep = new ReKeyProcessStep(keyProcessor);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    MetaFieldsBuilderImpl meta = new MetaFieldsBuilderImpl();
    KeyBuilderImpl key = new KeyBuilderImpl();
    meta.addKey(key);

    FieldWithMetaPriceBuilderImpl price = new FieldWithMetaPriceBuilderImpl();
    price.setMeta(meta);

    PriceQuantityBuilderImpl priceQuantityBuilderImpl = new PriceQuantityBuilderImpl();
    priceQuantityBuilderImpl.setPrice(price);

    // Act
    PostProcessorReport actualRunProcessStepResult =
        reKeyProcessStep.runProcessStep(topClass, priceQuantityBuilderImpl);
    actualRunProcessStepResult.getResultObject();

    // Assert
    assertTrue(actualRunProcessStepResult instanceof ReKeyPostProcessReport);
    RosettaModelObject resultObject = actualRunProcessStepResult.getResultObject();
    assertTrue(resultObject instanceof PriceQuantityBuilderImpl);
    FieldWithMetaPriceBuilder orCreatePrice =
        ((PriceQuantityBuilderImpl) resultObject).getOrCreatePrice();
    assertTrue(orCreatePrice instanceof FieldWithMetaPriceBuilderImpl);
    MetaFieldsBuilder meta2 = orCreatePrice.getMeta();
    assertTrue(meta2 instanceof MetaFieldsBuilderImpl);
    List<? extends KeyBuilder> key2 = meta2.getKey();
    assertEquals(1, key2.size());
    assertSame(key, key2.get(0));
  }

  /**
   * Test {@link ReKeyProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Given builder.
   * </ul>
   *
   * <p>Method under test: {@link ReKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @DisplayName("Test runProcessStep(Class, RosettaModelObject); given builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PostProcessorReport ReKeyProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_givenBuilder() {
    // Arrange
    GlobalKeyProcessStep keyProcessor = new GlobalKeyProcessStep(mock(Supplier.class));
    ReKeyProcessStep reKeyProcessStep = new ReKeyProcessStep(keyProcessor);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    ReferenceWithMetaPriceBuilderImpl referenceWithMetaPriceBuilderImpl =
        new ReferenceWithMetaPriceBuilderImpl();
    referenceWithMetaPriceBuilderImpl.setReference(Reference.builder());

    // Act
    PostProcessorReport actualRunProcessStepResult =
        reKeyProcessStep.runProcessStep(topClass, referenceWithMetaPriceBuilderImpl);
    RosettaModelObject actualResultObject = actualRunProcessStepResult.getResultObject();

    // Assert
    assertTrue(actualRunProcessStepResult instanceof ReKeyPostProcessReport);
    assertSame(referenceWithMetaPriceBuilderImpl, actualRunProcessStepResult.getResultObject());
    assertSame(referenceWithMetaPriceBuilderImpl, actualResultObject);
  }

  /**
   * Test {@link ReKeyProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then ResultObject OrCreatePrice Meta Key first return {@link KeyBuilderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ReKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then ResultObject OrCreatePrice Meta Key first return KeyBuilderImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PostProcessorReport ReKeyProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenResultObjectOrCreatePriceMetaKeyFirstReturnKeyBuilderImpl() {
    // Arrange
    GlobalKeyProcessStep keyProcessor = new GlobalKeyProcessStep(mock(Supplier.class));
    ReKeyProcessStep reKeyProcessStep = new ReKeyProcessStep(keyProcessor);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    // Act
    PostProcessorReport actualRunProcessStepResult =
        reKeyProcessStep.runProcessStep(topClass, new PriceQuantityBuilderImpl());
    actualRunProcessStepResult.getResultObject();

    // Assert
    assertTrue(actualRunProcessStepResult instanceof ReKeyPostProcessReport);
    RosettaModelObject resultObject = actualRunProcessStepResult.getResultObject();
    assertTrue(resultObject instanceof PriceQuantityBuilderImpl);
    FieldWithMetaPriceBuilder orCreatePrice =
        ((PriceQuantityBuilderImpl) resultObject).getOrCreatePrice();
    assertTrue(orCreatePrice instanceof FieldWithMetaPriceBuilderImpl);
    MetaFieldsBuilder meta = orCreatePrice.getMeta();
    assertTrue(meta instanceof MetaFieldsBuilderImpl);
    List<? extends KeyBuilder> key = meta.getKey();
    assertEquals(1, key.size());
    KeyBuilder getResult = key.get(0);
    assertTrue(getResult instanceof KeyBuilderImpl);
    assertEquals("DOCUMENT", getResult.getScope());
    assertNull(getResult.getKeyValue());
    assertFalse(getResult.hasData());
    Class<Key> expectedType = Key.class;
    assertEquals(expectedType, getResult.getType());
  }

  /**
   * Test {@link ReKeyProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then ResultObject return {@link ReferenceBuilderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ReKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then ResultObject return ReferenceBuilderImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PostProcessorReport ReKeyProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenResultObjectReturnReferenceBuilderImpl() {
    // Arrange
    GlobalKeyProcessStep keyProcessor = new GlobalKeyProcessStep(mock(Supplier.class));
    ReKeyProcessStep reKeyProcessStep = new ReKeyProcessStep(keyProcessor);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    ReferenceImpl referenceImpl =
        new ReferenceImpl("Scope", "alice.liddell@example.org", "Reference");

    // Act
    PostProcessorReport actualRunProcessStepResult =
        reKeyProcessStep.runProcessStep(topClass, referenceImpl);
    RosettaModelObject actualResultObject = actualRunProcessStepResult.getResultObject();

    // Assert
    assertTrue(actualRunProcessStepResult instanceof ReKeyPostProcessReport);
    RosettaModelObject resultObject = actualRunProcessStepResult.getResultObject();
    assertTrue(resultObject instanceof ReferenceBuilderImpl);
    assertEquals("Reference", ((ReferenceBuilderImpl) resultObject).getReference());
    assertEquals("Scope", ((ReferenceBuilderImpl) resultObject).getScope());
    assertEquals("alice.liddell@example.org", ((ReferenceBuilderImpl) resultObject).getPointsTo());
    assertTrue(((ReferenceBuilderImpl) resultObject).hasData());
    Class<Reference> expectedType = Reference.class;
    assertEquals(expectedType, resultObject.getType());
    assertSame(resultObject, actualResultObject);
  }

  /**
   * Test {@link ReKeyProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then return ResultObject is {@link PriceQuantity.PriceQuantityBuilderImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link ReKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then return ResultObject is PriceQuantityBuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PostProcessorReport ReKeyProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenReturnResultObjectIsPriceQuantityBuilderImpl() {
    // Arrange
    GlobalKeyProcessStep keyProcessor = new GlobalKeyProcessStep(mock(Supplier.class));
    ReKeyProcessStep reKeyProcessStep = new ReKeyProcessStep(keyProcessor);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    PriceQuantityBuilderImpl priceQuantityBuilderImpl = new PriceQuantityBuilderImpl();
    priceQuantityBuilderImpl.setPrice(new FieldWithMetaPriceBuilderImpl());

    // Act
    PostProcessorReport actualRunProcessStepResult =
        reKeyProcessStep.runProcessStep(topClass, priceQuantityBuilderImpl);
    RosettaModelObject actualResultObject = actualRunProcessStepResult.getResultObject();

    // Assert
    assertTrue(actualRunProcessStepResult instanceof ReKeyPostProcessReport);
    assertSame(priceQuantityBuilderImpl, actualRunProcessStepResult.getResultObject());
    assertSame(priceQuantityBuilderImpl, actualResultObject);
  }

  /**
   * Test {@link ReKeyProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then return ResultObject OrCreatePrice Meta Key size is four.
   * </ul>
   *
   * <p>Method under test: {@link ReKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then return ResultObject OrCreatePrice Meta Key size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PostProcessorReport ReKeyProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenReturnResultObjectOrCreatePriceMetaKeySizeIsFour() {
    // Arrange
    GlobalKeyProcessStep keyProcessor = new GlobalKeyProcessStep(mock(Supplier.class));
    ReKeyProcessStep reKeyProcessStep = new ReKeyProcessStep(keyProcessor);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    MetaFieldsBuilderImpl meta = new MetaFieldsBuilderImpl();
    KeyBuilderImpl key = new KeyBuilderImpl();
    meta.addKey(key, 2);
    KeyBuilderImpl key2 = new KeyBuilderImpl();
    meta.addKey(key2);

    FieldWithMetaPriceBuilderImpl price = new FieldWithMetaPriceBuilderImpl();
    price.setMeta(meta);

    PriceQuantityBuilderImpl priceQuantityBuilderImpl = new PriceQuantityBuilderImpl();
    priceQuantityBuilderImpl.setPrice(price);

    // Act
    PostProcessorReport actualRunProcessStepResult =
        reKeyProcessStep.runProcessStep(topClass, priceQuantityBuilderImpl);
    actualRunProcessStepResult.getResultObject();

    // Assert
    assertTrue(actualRunProcessStepResult instanceof ReKeyPostProcessReport);
    RosettaModelObject resultObject = actualRunProcessStepResult.getResultObject();
    assertTrue(resultObject instanceof PriceQuantityBuilderImpl);
    FieldWithMetaPriceBuilder orCreatePrice =
        ((PriceQuantityBuilderImpl) resultObject).getOrCreatePrice();
    assertTrue(orCreatePrice instanceof FieldWithMetaPriceBuilderImpl);
    MetaFieldsBuilder meta2 = orCreatePrice.getMeta();
    assertTrue(meta2 instanceof MetaFieldsBuilderImpl);
    List<? extends KeyBuilder> key3 = meta2.getKey();
    assertEquals(4, key3.size());
    assertNull(key3.get(0));
    assertNull(key3.get(1));
    assertSame(key, key3.get(2));
    assertSame(key2, key3.get(3));
  }

  /**
   * Test {@link ReKeyProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then return ResultObject OrCreatePrice Meta Key size is two.
   * </ul>
   *
   * <p>Method under test: {@link ReKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then return ResultObject OrCreatePrice Meta Key size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PostProcessorReport ReKeyProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenReturnResultObjectOrCreatePriceMetaKeySizeIsTwo() {
    // Arrange
    GlobalKeyProcessStep keyProcessor = new GlobalKeyProcessStep(mock(Supplier.class));
    ReKeyProcessStep reKeyProcessStep = new ReKeyProcessStep(keyProcessor);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    MetaFieldsBuilderImpl meta = new MetaFieldsBuilderImpl();
    meta.addKey(new KeyBuilderImpl());
    KeyBuilderImpl key = new KeyBuilderImpl();
    meta.addKey(key);

    FieldWithMetaPriceBuilderImpl price = new FieldWithMetaPriceBuilderImpl();
    price.setMeta(meta);

    PriceQuantityBuilderImpl priceQuantityBuilderImpl = new PriceQuantityBuilderImpl();
    priceQuantityBuilderImpl.setPrice(price);

    // Act
    PostProcessorReport actualRunProcessStepResult =
        reKeyProcessStep.runProcessStep(topClass, priceQuantityBuilderImpl);
    actualRunProcessStepResult.getResultObject();

    // Assert
    assertTrue(actualRunProcessStepResult instanceof ReKeyPostProcessReport);
    RosettaModelObject resultObject = actualRunProcessStepResult.getResultObject();
    assertTrue(resultObject instanceof PriceQuantityBuilderImpl);
    FieldWithMetaPriceBuilder orCreatePrice =
        ((PriceQuantityBuilderImpl) resultObject).getOrCreatePrice();
    assertTrue(orCreatePrice instanceof FieldWithMetaPriceBuilderImpl);
    MetaFieldsBuilder meta2 = orCreatePrice.getMeta();
    assertTrue(meta2 instanceof MetaFieldsBuilderImpl);
    List<? extends KeyBuilder> key2 = meta2.getKey();
    assertEquals(2, key2.size());
    assertSame(key, key2.get(1));
  }

  /**
   * Test {@link ReKeyProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>When {@link KeyBuilderImpl} (default constructor).
   *   <li>Then return ResultObject is {@link KeyBuilderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ReKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); when KeyBuilderImpl (default constructor); then return ResultObject is KeyBuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PostProcessorReport ReKeyProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_whenKeyBuilderImpl_thenReturnResultObjectIsKeyBuilderImpl() {
    // Arrange
    GlobalKeyProcessStep keyProcessor = new GlobalKeyProcessStep(mock(Supplier.class));
    ReKeyProcessStep reKeyProcessStep = new ReKeyProcessStep(keyProcessor);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    KeyBuilderImpl keyBuilderImpl = new KeyBuilderImpl();

    // Act
    PostProcessorReport actualRunProcessStepResult =
        reKeyProcessStep.runProcessStep(topClass, keyBuilderImpl);
    RosettaModelObject actualResultObject = actualRunProcessStepResult.getResultObject();

    // Assert
    assertTrue(actualRunProcessStepResult instanceof ReKeyPostProcessReport);
    assertSame(keyBuilderImpl, actualRunProcessStepResult.getResultObject());
    assertSame(keyBuilderImpl, actualResultObject);
  }

  /**
   * Test {@link ReKeyProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>When {@link Price.PriceBuilderImpl} (default constructor).
   *   <li>Then return ResultObject is {@link Price.PriceBuilderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ReKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); when PriceBuilderImpl (default constructor); then return ResultObject is PriceBuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PostProcessorReport ReKeyProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_whenPriceBuilderImpl_thenReturnResultObjectIsPriceBuilderImpl() {
    // Arrange
    GlobalKeyProcessStep keyProcessor = new GlobalKeyProcessStep(mock(Supplier.class));
    ReKeyProcessStep reKeyProcessStep = new ReKeyProcessStep(keyProcessor);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    PriceBuilderImpl priceBuilderImpl = new PriceBuilderImpl();

    // Act
    PostProcessorReport actualRunProcessStepResult =
        reKeyProcessStep.runProcessStep(topClass, priceBuilderImpl);
    RosettaModelObject actualResultObject = actualRunProcessStepResult.getResultObject();

    // Assert
    assertTrue(actualRunProcessStepResult instanceof ReKeyPostProcessReport);
    assertSame(priceBuilderImpl, actualRunProcessStepResult.getResultObject());
    assertSame(priceBuilderImpl, actualResultObject);
  }

  /**
   * Test {@link ReKeyProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>When {@link ReferenceWithMetaPrice.ReferenceWithMetaPriceBuilderImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link ReKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); when ReferenceWithMetaPriceBuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PostProcessorReport ReKeyProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_whenReferenceWithMetaPriceBuilderImpl() {
    // Arrange
    GlobalKeyProcessStep keyProcessor = new GlobalKeyProcessStep(mock(Supplier.class));
    ReKeyProcessStep reKeyProcessStep = new ReKeyProcessStep(keyProcessor);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    ReferenceWithMetaPriceBuilderImpl referenceWithMetaPriceBuilderImpl =
        new ReferenceWithMetaPriceBuilderImpl();

    // Act
    PostProcessorReport actualRunProcessStepResult =
        reKeyProcessStep.runProcessStep(topClass, referenceWithMetaPriceBuilderImpl);
    RosettaModelObject actualResultObject = actualRunProcessStepResult.getResultObject();

    // Assert
    assertTrue(actualRunProcessStepResult instanceof ReKeyPostProcessReport);
    assertSame(referenceWithMetaPriceBuilderImpl, actualRunProcessStepResult.getResultObject());
    assertSame(referenceWithMetaPriceBuilderImpl, actualResultObject);
  }

  /**
   * Test {@link ReKeyProcessStep#getPriority()}.
   *
   * <p>Method under test: {@link ReKeyProcessStep#getPriority()}
   */
  @Test
  @DisplayName("Test getPriority()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer ReKeyProcessStep.getPriority()"})
  void testGetPriority() {
    // Arrange
    GlobalKeyProcessStep keyProcessor = new GlobalKeyProcessStep(mock(Supplier.class));

    // Act and Assert
    assertEquals(2, new ReKeyProcessStep(keyProcessor).getPriority().intValue());
  }
}
