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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.Price;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.Price.PriceBuilderImpl;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.Price.PriceImpl;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.PriceQuantity;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.PriceQuantity.PriceQuantityBuilderImpl;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.PriceQuantity.PriceQuantityImpl;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.FieldWithMetaPrice;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.FieldWithMetaPrice.FieldWithMetaPriceImpl;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.MetaFields;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.MetaFields.MetaFieldsBuilderImpl;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.MetaFields.MetaFieldsImpl;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.meta.Key;
import com.rosetta.model.lib.meta.Key.KeyBuilderImpl;
import com.rosetta.model.lib.meta.Key.KeyImpl;
import com.rosetta.model.lib.meta.Reference;
import com.rosetta.model.lib.meta.Reference.ReferenceImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReferenceResolverProcessStepDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReferenceResolverProcessStep#ReferenceResolverProcessStep(ReferenceConfig)}
   *   <li>{@link ReferenceResolverProcessStep#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReferenceResolverProcessStep.<init>(ReferenceConfig)",
    "java.lang.String ReferenceResolverProcessStep.getName()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "Reference Resolver",
        new ReferenceResolverProcessStep(ReferenceConfig.noScopeOrExcludedPaths()).getName());
  }

  /**
   * Test {@link ReferenceResolverProcessStep#getPriority()}.
   *
   * <p>Method under test: {@link ReferenceResolverProcessStep#getPriority()}
   */
  @Test
  @DisplayName("Test getPriority()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer ReferenceResolverProcessStep.getPriority()"})
  void testGetPriority() {
    // Arrange, Act and Assert
    assertEquals(
        2,
        new ReferenceResolverProcessStep(ReferenceConfig.noScopeOrExcludedPaths())
            .getPriority()
            .intValue());
  }

  /**
   * Test {@link ReferenceResolverProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then return ResultObject Price is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceResolverProcessStep#runProcessStep(Class,
   * RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); given 'java.lang.Object'; then return ResultObject Price is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceResolverProcessStep.ReferenceResolverPostProcessorReport ReferenceResolverProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_givenJavaLangObject_thenReturnResultObjectPriceIsNull() {
    // Arrange
    Class<Object> scopeType = Object.class;
    ReferenceConfig referenceConfig = new ReferenceConfig(scopeType, new ArrayList<>());
    ReferenceResolverProcessStep referenceResolverProcessStep =
        new ReferenceResolverProcessStep(referenceConfig);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    // Act
    Object actualResultObject =
        referenceResolverProcessStep
            .runProcessStep(topClass, new PriceQuantityBuilderImpl())
            .getResultObject();

    // Assert
    assertTrue(actualResultObject instanceof PriceQuantityImpl);
    assertNull(((PriceQuantityImpl) actualResultObject).getPrice());
    Class<PriceQuantity> expectedType = PriceQuantity.class;
    assertEquals(expectedType, ((PriceQuantityImpl) actualResultObject).getType());
  }

  /**
   * Test {@link ReferenceResolverProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Given {@link MetaFields.MetaFieldsBuilderImpl} (default constructor) addKey {@link
   *       KeyBuilderImpl} (default constructor) and two.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceResolverProcessStep#runProcessStep(Class,
   * RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); given MetaFieldsBuilderImpl (default constructor) addKey KeyBuilderImpl (default constructor) and two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceResolverProcessStep.ReferenceResolverPostProcessorReport ReferenceResolverProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_givenMetaFieldsBuilderImplAddKeyKeyBuilderImplAndTwo() {
    // Arrange
    ReferenceResolverProcessStep referenceResolverProcessStep =
        new ReferenceResolverProcessStep(ReferenceConfig.noScopeOrExcludedPaths());
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    MetaFieldsBuilderImpl meta = new MetaFieldsBuilderImpl();
    meta.addKey(new KeyBuilderImpl(), 2);
    meta.addKey(new KeyBuilderImpl());

    FieldWithMetaPriceBuilderImpl price = new FieldWithMetaPriceBuilderImpl();
    price.setMeta(meta);

    PriceQuantityBuilderImpl priceQuantityBuilderImpl = new PriceQuantityBuilderImpl();
    priceQuantityBuilderImpl.setPrice(price);

    // Act
    Object actualResultObject =
        referenceResolverProcessStep
            .runProcessStep(topClass, priceQuantityBuilderImpl)
            .getResultObject();

    // Assert
    assertTrue(actualResultObject instanceof PriceQuantityImpl);
    FieldWithMetaPrice price2 = ((PriceQuantityImpl) actualResultObject).getPrice();
    assertTrue(price2 instanceof FieldWithMetaPriceImpl);
    MetaFields meta2 = price2.getMeta();
    assertTrue(meta2 instanceof MetaFieldsImpl);
    List<? extends Key> key = meta2.getKey();
    assertEquals(2, key.size());
    Key getResult = key.get(1);
    assertTrue(getResult instanceof KeyImpl);
    assertNull(price2.getValue());
    assertEquals(key.get(0), getResult);
  }

  /**
   * Test {@link ReferenceResolverProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then return ResultObject is {@link KeyImpl#KeyImpl(KeyBuilder)} with builder is {@link
   *       KeyBuilderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ReferenceResolverProcessStep#runProcessStep(Class,
   * RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then return ResultObject is KeyImpl(KeyBuilder) with builder is KeyBuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceResolverProcessStep.ReferenceResolverPostProcessorReport ReferenceResolverProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenReturnResultObjectIsKeyImplWithBuilderIsKeyBuilderImpl() {
    // Arrange
    ReferenceResolverProcessStep referenceResolverProcessStep =
        new ReferenceResolverProcessStep(ReferenceConfig.noScopeOrExcludedPaths());
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    KeyImpl keyImpl = new KeyImpl(new KeyBuilderImpl());

    // Act
    Object actualResultObject =
        referenceResolverProcessStep.runProcessStep(topClass, keyImpl).getResultObject();

    // Assert
    assertTrue(actualResultObject instanceof KeyImpl);
    assertEquals(keyImpl, actualResultObject);
  }

  /**
   * Test {@link ReferenceResolverProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then return ResultObject Price is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceResolverProcessStep#runProcessStep(Class,
   * RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then return ResultObject Price is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceResolverProcessStep.ReferenceResolverPostProcessorReport ReferenceResolverProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenReturnResultObjectPriceIsNull() {
    // Arrange
    ReferenceResolverProcessStep referenceResolverProcessStep =
        new ReferenceResolverProcessStep(ReferenceConfig.noScopeOrExcludedPaths());
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    // Act
    Object actualResultObject =
        referenceResolverProcessStep
            .runProcessStep(topClass, new PriceQuantityBuilderImpl())
            .getResultObject();

    // Assert
    assertTrue(actualResultObject instanceof PriceQuantityImpl);
    assertNull(((PriceQuantityImpl) actualResultObject).getPrice());
    Class<PriceQuantity> expectedType = PriceQuantity.class;
    assertEquals(expectedType, ((PriceQuantityImpl) actualResultObject).getType());
  }

  /**
   * Test {@link ReferenceResolverProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then return ResultObject Price Meta ExternalKey is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceResolverProcessStep#runProcessStep(Class,
   * RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then return ResultObject Price Meta ExternalKey is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceResolverProcessStep.ReferenceResolverPostProcessorReport ReferenceResolverProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenReturnResultObjectPriceMetaExternalKeyIsNull() {
    // Arrange
    ReferenceResolverProcessStep referenceResolverProcessStep =
        new ReferenceResolverProcessStep(ReferenceConfig.noScopeOrExcludedPaths());
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    FieldWithMetaPriceBuilderImpl price = new FieldWithMetaPriceBuilderImpl();
    price.setMeta(new MetaFieldsBuilderImpl());

    PriceQuantityBuilderImpl priceQuantityBuilderImpl = new PriceQuantityBuilderImpl();
    priceQuantityBuilderImpl.setPrice(price);

    // Act
    Object actualResultObject =
        referenceResolverProcessStep
            .runProcessStep(topClass, priceQuantityBuilderImpl)
            .getResultObject();

    // Assert
    assertTrue(actualResultObject instanceof PriceQuantityImpl);
    FieldWithMetaPrice price2 = ((PriceQuantityImpl) actualResultObject).getPrice();
    assertTrue(price2 instanceof FieldWithMetaPriceImpl);
    MetaFields meta = price2.getMeta();
    assertTrue(meta instanceof MetaFieldsImpl);
    assertNull(meta.getExternalKey());
    assertNull(meta.getGlobalKey());
    assertNull(meta.getScheme());
    Class<MetaFields> expectedType = MetaFields.class;
    assertEquals(expectedType, meta.getType());
  }

  /**
   * Test {@link ReferenceResolverProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then return ResultObject Price Meta GlobalKey is {@code Global Key}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceResolverProcessStep#runProcessStep(Class,
   * RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then return ResultObject Price Meta GlobalKey is 'Global Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceResolverProcessStep.ReferenceResolverPostProcessorReport ReferenceResolverProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenReturnResultObjectPriceMetaGlobalKeyIsGlobalKey() {
    // Arrange
    ReferenceResolverProcessStep referenceResolverProcessStep =
        new ReferenceResolverProcessStep(ReferenceConfig.noScopeOrExcludedPaths());
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    MetaFieldsBuilderImpl meta = new MetaFieldsBuilderImpl();
    meta.setGlobalKey("Global Key");
    meta.addKey(new KeyBuilderImpl());

    FieldWithMetaPriceBuilderImpl price = new FieldWithMetaPriceBuilderImpl();
    PriceBuilderImpl value = new PriceBuilderImpl();
    price.setValue(value);
    price.setMeta(meta);

    PriceQuantityBuilderImpl priceQuantityBuilderImpl = new PriceQuantityBuilderImpl();
    priceQuantityBuilderImpl.setPrice(price);

    // Act
    Object actualResultObject =
        referenceResolverProcessStep
            .runProcessStep(topClass, priceQuantityBuilderImpl)
            .getResultObject();

    // Assert
    FieldWithMetaPrice price2 = ((PriceQuantityImpl) actualResultObject).getPrice();
    Price value2 = price2.getValue();
    assertTrue(value2 instanceof PriceImpl);
    assertTrue(actualResultObject instanceof PriceQuantityImpl);
    assertTrue(price2 instanceof FieldWithMetaPriceImpl);
    MetaFields meta2 = price2.getMeta();
    assertTrue(meta2 instanceof MetaFieldsImpl);
    List<? extends Key> key = meta2.getKey();
    assertEquals(1, key.size());
    Key getResult = key.get(0);
    assertTrue(getResult instanceof KeyImpl);
    assertEquals("Global Key", meta2.getGlobalKey());
    assertNull(getResult.getKeyValue());
    assertEquals(value, value2);
  }

  /**
   * Test {@link ReferenceResolverProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then return ResultObject Price Meta is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceResolverProcessStep#runProcessStep(Class,
   * RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then return ResultObject Price Meta is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceResolverProcessStep.ReferenceResolverPostProcessorReport ReferenceResolverProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenReturnResultObjectPriceMetaIsNull() {
    // Arrange
    ReferenceResolverProcessStep referenceResolverProcessStep =
        new ReferenceResolverProcessStep(ReferenceConfig.noScopeOrExcludedPaths());
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    FieldWithMetaPriceBuilderImpl price = new FieldWithMetaPriceBuilderImpl();
    PriceBuilderImpl value = new PriceBuilderImpl();
    price.setValue(value);

    PriceQuantityBuilderImpl priceQuantityBuilderImpl = new PriceQuantityBuilderImpl();
    priceQuantityBuilderImpl.setPrice(price);

    // Act
    Object actualResultObject =
        referenceResolverProcessStep
            .runProcessStep(topClass, priceQuantityBuilderImpl)
            .getResultObject();

    // Assert
    FieldWithMetaPrice price2 = ((PriceQuantityImpl) actualResultObject).getPrice();
    Price value2 = price2.getValue();
    assertTrue(value2 instanceof PriceImpl);
    assertTrue(actualResultObject instanceof PriceQuantityImpl);
    assertTrue(price2 instanceof FieldWithMetaPriceImpl);
    assertNull(price2.getMeta());
    assertEquals(value, value2);
  }

  /**
   * Test {@link ReferenceResolverProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then return ResultObject Price Meta Key first KeyValue is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceResolverProcessStep#runProcessStep(Class,
   * RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then return ResultObject Price Meta Key first KeyValue is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceResolverProcessStep.ReferenceResolverPostProcessorReport ReferenceResolverProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenReturnResultObjectPriceMetaKeyFirstKeyValueIs42() {
    // Arrange
    ReferenceResolverProcessStep referenceResolverProcessStep =
        new ReferenceResolverProcessStep(ReferenceConfig.noScopeOrExcludedPaths());
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    KeyBuilderImpl key = new KeyBuilderImpl();
    key.setKeyValue("42");

    MetaFieldsBuilderImpl meta = new MetaFieldsBuilderImpl();
    meta.addKey(key);

    FieldWithMetaPriceBuilderImpl price = new FieldWithMetaPriceBuilderImpl();
    PriceBuilderImpl value = new PriceBuilderImpl();
    price.setValue(value);
    price.setMeta(meta);

    PriceQuantityBuilderImpl priceQuantityBuilderImpl = new PriceQuantityBuilderImpl();
    priceQuantityBuilderImpl.setPrice(price);

    // Act
    Object actualResultObject =
        referenceResolverProcessStep
            .runProcessStep(topClass, priceQuantityBuilderImpl)
            .getResultObject();

    // Assert
    FieldWithMetaPrice price2 = ((PriceQuantityImpl) actualResultObject).getPrice();
    Price value2 = price2.getValue();
    assertTrue(value2 instanceof PriceImpl);
    assertTrue(actualResultObject instanceof PriceQuantityImpl);
    assertTrue(price2 instanceof FieldWithMetaPriceImpl);
    MetaFields meta2 = price2.getMeta();
    assertTrue(meta2 instanceof MetaFieldsImpl);
    List<? extends Key> key2 = meta2.getKey();
    assertEquals(1, key2.size());
    Key getResult = key2.get(0);
    assertTrue(getResult instanceof KeyImpl);
    assertEquals("42", getResult.getKeyValue());
    assertEquals(value, value2);
  }

  /**
   * Test {@link ReferenceResolverProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then return ResultObject Price Meta Key first KeyValue is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceResolverProcessStep#runProcessStep(Class,
   * RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then return ResultObject Price Meta Key first KeyValue is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceResolverProcessStep.ReferenceResolverPostProcessorReport ReferenceResolverProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenReturnResultObjectPriceMetaKeyFirstKeyValueIs422() {
    // Arrange
    Class<Object> scopeType = Object.class;
    ReferenceConfig referenceConfig = new ReferenceConfig(scopeType, new ArrayList<>());
    ReferenceResolverProcessStep referenceResolverProcessStep =
        new ReferenceResolverProcessStep(referenceConfig);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    KeyBuilderImpl key = new KeyBuilderImpl();
    key.setKeyValue("42");

    MetaFieldsBuilderImpl meta = new MetaFieldsBuilderImpl();
    meta.addKey(key);

    FieldWithMetaPriceBuilderImpl price = new FieldWithMetaPriceBuilderImpl();
    PriceBuilderImpl value = new PriceBuilderImpl();
    price.setValue(value);
    price.setMeta(meta);

    PriceQuantityBuilderImpl priceQuantityBuilderImpl = new PriceQuantityBuilderImpl();
    priceQuantityBuilderImpl.setPrice(price);

    // Act
    Object actualResultObject =
        referenceResolverProcessStep
            .runProcessStep(topClass, priceQuantityBuilderImpl)
            .getResultObject();

    // Assert
    FieldWithMetaPrice price2 = ((PriceQuantityImpl) actualResultObject).getPrice();
    Price value2 = price2.getValue();
    assertTrue(value2 instanceof PriceImpl);
    assertTrue(actualResultObject instanceof PriceQuantityImpl);
    assertTrue(price2 instanceof FieldWithMetaPriceImpl);
    MetaFields meta2 = price2.getMeta();
    assertTrue(meta2 instanceof MetaFieldsImpl);
    List<? extends Key> key2 = meta2.getKey();
    assertEquals(1, key2.size());
    Key getResult = key2.get(0);
    assertTrue(getResult instanceof KeyImpl);
    assertEquals("42", getResult.getKeyValue());
    assertEquals(value, value2);
  }

  /**
   * Test {@link ReferenceResolverProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then return ResultObject Price Meta Key first KeyValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceResolverProcessStep#runProcessStep(Class,
   * RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then return ResultObject Price Meta Key first KeyValue is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceResolverProcessStep.ReferenceResolverPostProcessorReport ReferenceResolverProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenReturnResultObjectPriceMetaKeyFirstKeyValueIsNull() {
    // Arrange
    ReferenceResolverProcessStep referenceResolverProcessStep =
        new ReferenceResolverProcessStep(ReferenceConfig.noScopeOrExcludedPaths());
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    MetaFieldsBuilderImpl meta = new MetaFieldsBuilderImpl();
    meta.addKey(new KeyBuilderImpl());

    FieldWithMetaPriceBuilderImpl price = new FieldWithMetaPriceBuilderImpl();
    PriceBuilderImpl value = new PriceBuilderImpl();
    price.setValue(value);
    price.setMeta(meta);

    PriceQuantityBuilderImpl priceQuantityBuilderImpl = new PriceQuantityBuilderImpl();
    priceQuantityBuilderImpl.setPrice(price);

    // Act
    Object actualResultObject =
        referenceResolverProcessStep
            .runProcessStep(topClass, priceQuantityBuilderImpl)
            .getResultObject();

    // Assert
    FieldWithMetaPrice price2 = ((PriceQuantityImpl) actualResultObject).getPrice();
    Price value2 = price2.getValue();
    assertTrue(value2 instanceof PriceImpl);
    assertTrue(actualResultObject instanceof PriceQuantityImpl);
    assertTrue(price2 instanceof FieldWithMetaPriceImpl);
    MetaFields meta2 = price2.getMeta();
    assertTrue(meta2 instanceof MetaFieldsImpl);
    List<? extends Key> key = meta2.getKey();
    assertEquals(1, key.size());
    Key getResult = key.get(0);
    assertTrue(getResult instanceof KeyImpl);
    assertNull(getResult.getKeyValue());
    assertEquals(value, value2);
  }

  /**
   * Test {@link ReferenceResolverProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then return ResultObject Price Meta Key first Scope is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceResolverProcessStep#runProcessStep(Class,
   * RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then return ResultObject Price Meta Key first Scope is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceResolverProcessStep.ReferenceResolverPostProcessorReport ReferenceResolverProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenReturnResultObjectPriceMetaKeyFirstScopeIsNull() {
    // Arrange
    ReferenceResolverProcessStep referenceResolverProcessStep =
        new ReferenceResolverProcessStep(ReferenceConfig.noScopeOrExcludedPaths());
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    MetaFieldsBuilderImpl meta = new MetaFieldsBuilderImpl();
    meta.addKey(new KeyBuilderImpl());

    FieldWithMetaPriceBuilderImpl price = new FieldWithMetaPriceBuilderImpl();
    price.setMeta(meta);

    PriceQuantityBuilderImpl priceQuantityBuilderImpl = new PriceQuantityBuilderImpl();
    priceQuantityBuilderImpl.setPrice(price);

    // Act
    Object actualResultObject =
        referenceResolverProcessStep
            .runProcessStep(topClass, priceQuantityBuilderImpl)
            .getResultObject();

    // Assert
    assertTrue(actualResultObject instanceof PriceQuantityImpl);
    FieldWithMetaPrice price2 = ((PriceQuantityImpl) actualResultObject).getPrice();
    assertTrue(price2 instanceof FieldWithMetaPriceImpl);
    MetaFields meta2 = price2.getMeta();
    assertTrue(meta2 instanceof MetaFieldsImpl);
    List<? extends Key> key = meta2.getKey();
    assertEquals(1, key.size());
    Key getResult = key.get(0);
    assertTrue(getResult instanceof KeyImpl);
    assertNull(price2.getValue());
    assertNull(getResult.getKeyValue());
    assertNull(getResult.getScope());
    Class<Key> expectedType = Key.class;
    assertEquals(expectedType, getResult.getType());
  }

  /**
   * Test {@link ReferenceResolverProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then return ResultObject Price Meta Key first Scope is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceResolverProcessStep#runProcessStep(Class,
   * RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then return ResultObject Price Meta Key first Scope is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceResolverProcessStep.ReferenceResolverPostProcessorReport ReferenceResolverProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenReturnResultObjectPriceMetaKeyFirstScopeIsNull2() {
    // Arrange
    Class<Object> scopeType = Object.class;
    ReferenceConfig referenceConfig = new ReferenceConfig(scopeType, new ArrayList<>());
    ReferenceResolverProcessStep referenceResolverProcessStep =
        new ReferenceResolverProcessStep(referenceConfig);
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    MetaFieldsBuilderImpl meta = new MetaFieldsBuilderImpl();
    meta.addKey(new KeyBuilderImpl());

    FieldWithMetaPriceBuilderImpl price = new FieldWithMetaPriceBuilderImpl();
    price.setMeta(meta);

    PriceQuantityBuilderImpl priceQuantityBuilderImpl = new PriceQuantityBuilderImpl();
    priceQuantityBuilderImpl.setPrice(price);

    // Act
    Object actualResultObject =
        referenceResolverProcessStep
            .runProcessStep(topClass, priceQuantityBuilderImpl)
            .getResultObject();

    // Assert
    assertTrue(actualResultObject instanceof PriceQuantityImpl);
    FieldWithMetaPrice price2 = ((PriceQuantityImpl) actualResultObject).getPrice();
    assertTrue(price2 instanceof FieldWithMetaPriceImpl);
    MetaFields meta2 = price2.getMeta();
    assertTrue(meta2 instanceof MetaFieldsImpl);
    List<? extends Key> key = meta2.getKey();
    assertEquals(1, key.size());
    Key getResult = key.get(0);
    assertTrue(getResult instanceof KeyImpl);
    assertNull(price2.getValue());
    assertNull(getResult.getKeyValue());
    assertNull(getResult.getScope());
    Class<Key> expectedType = Key.class;
    assertEquals(expectedType, getResult.getType());
  }

  /**
   * Test {@link ReferenceResolverProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then return ResultObject Price Meta Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceResolverProcessStep#runProcessStep(Class,
   * RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then return ResultObject Price Meta Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceResolverProcessStep.ReferenceResolverPostProcessorReport ReferenceResolverProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenReturnResultObjectPriceMetaKeyIsNull() {
    // Arrange
    ReferenceResolverProcessStep referenceResolverProcessStep =
        new ReferenceResolverProcessStep(ReferenceConfig.noScopeOrExcludedPaths());
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    MetaFieldsBuilderImpl meta = new MetaFieldsBuilderImpl();
    meta.addKey((Key) null);

    FieldWithMetaPriceBuilderImpl price = new FieldWithMetaPriceBuilderImpl();
    PriceBuilderImpl value = new PriceBuilderImpl();
    price.setValue(value);
    price.setMeta(meta);

    PriceQuantityBuilderImpl priceQuantityBuilderImpl = new PriceQuantityBuilderImpl();
    priceQuantityBuilderImpl.setPrice(price);

    // Act
    Object actualResultObject =
        referenceResolverProcessStep
            .runProcessStep(topClass, priceQuantityBuilderImpl)
            .getResultObject();

    // Assert
    FieldWithMetaPrice price2 = ((PriceQuantityImpl) actualResultObject).getPrice();
    Price value2 = price2.getValue();
    assertTrue(value2 instanceof PriceImpl);
    assertTrue(actualResultObject instanceof PriceQuantityImpl);
    assertTrue(price2 instanceof FieldWithMetaPriceImpl);
    MetaFields meta2 = price2.getMeta();
    assertTrue(meta2 instanceof MetaFieldsImpl);
    assertNull(meta2.getKey());
    assertEquals(value, value2);
  }

  /**
   * Test {@link ReferenceResolverProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then return ResultObject Price Meta Key size is two.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceResolverProcessStep#runProcessStep(Class,
   * RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then return ResultObject Price Meta Key size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceResolverProcessStep.ReferenceResolverPostProcessorReport ReferenceResolverProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenReturnResultObjectPriceMetaKeySizeIsTwo() {
    // Arrange
    ReferenceResolverProcessStep referenceResolverProcessStep =
        new ReferenceResolverProcessStep(ReferenceConfig.noScopeOrExcludedPaths());
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    MetaFieldsBuilderImpl meta = new MetaFieldsBuilderImpl();
    meta.addKey(new KeyBuilderImpl());
    meta.addKey(new KeyBuilderImpl());

    FieldWithMetaPriceBuilderImpl price = new FieldWithMetaPriceBuilderImpl();
    price.setMeta(meta);

    PriceQuantityBuilderImpl priceQuantityBuilderImpl = new PriceQuantityBuilderImpl();
    priceQuantityBuilderImpl.setPrice(price);

    // Act
    Object actualResultObject =
        referenceResolverProcessStep
            .runProcessStep(topClass, priceQuantityBuilderImpl)
            .getResultObject();

    // Assert
    assertTrue(actualResultObject instanceof PriceQuantityImpl);
    FieldWithMetaPrice price2 = ((PriceQuantityImpl) actualResultObject).getPrice();
    assertTrue(price2 instanceof FieldWithMetaPriceImpl);
    MetaFields meta2 = price2.getMeta();
    assertTrue(meta2 instanceof MetaFieldsImpl);
    List<? extends Key> key = meta2.getKey();
    assertEquals(2, key.size());
    Key getResult = key.get(1);
    assertTrue(getResult instanceof KeyImpl);
    assertNull(price2.getValue());
    assertEquals(key.get(0), getResult);
  }

  /**
   * Test {@link ReferenceResolverProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then return ResultObject Price Meta Key size is two.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceResolverProcessStep#runProcessStep(Class,
   * RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then return ResultObject Price Meta Key size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceResolverProcessStep.ReferenceResolverPostProcessorReport ReferenceResolverProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenReturnResultObjectPriceMetaKeySizeIsTwo2() {
    // Arrange
    ReferenceResolverProcessStep referenceResolverProcessStep =
        new ReferenceResolverProcessStep(ReferenceConfig.noScopeOrExcludedPaths());
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    MetaFieldsBuilderImpl meta = new MetaFieldsBuilderImpl();
    meta.addKey(new KeyBuilderImpl());
    meta.addKey(new KeyBuilderImpl());

    FieldWithMetaPriceBuilderImpl price = new FieldWithMetaPriceBuilderImpl();
    price.setValue(new PriceBuilderImpl());
    price.setMeta(meta);

    PriceQuantityBuilderImpl priceQuantityBuilderImpl = new PriceQuantityBuilderImpl();
    priceQuantityBuilderImpl.setPrice(price);

    // Act
    Object actualResultObject =
        referenceResolverProcessStep
            .runProcessStep(topClass, priceQuantityBuilderImpl)
            .getResultObject();

    // Assert
    assertTrue(actualResultObject instanceof PriceQuantityImpl);
    FieldWithMetaPrice price2 = ((PriceQuantityImpl) actualResultObject).getPrice();
    assertTrue(price2 instanceof FieldWithMetaPriceImpl);
    MetaFields meta2 = price2.getMeta();
    assertTrue(meta2 instanceof MetaFieldsImpl);
    List<? extends Key> key = meta2.getKey();
    assertEquals(2, key.size());
    Key getResult = key.get(0);
    assertTrue(getResult instanceof KeyImpl);
    Key getResult2 = key.get(1);
    assertTrue(getResult2 instanceof KeyImpl);
    assertNull(getResult.getKeyValue());
    assertEquals(getResult, getResult2);
  }

  /**
   * Test {@link ReferenceResolverProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>Then return ResultObject Price ValueType is {@link Price}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceResolverProcessStep#runProcessStep(Class,
   * RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); then return ResultObject Price ValueType is Price")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceResolverProcessStep.ReferenceResolverPostProcessorReport ReferenceResolverProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_thenReturnResultObjectPriceValueTypeIsPrice() {
    // Arrange
    ReferenceResolverProcessStep referenceResolverProcessStep =
        new ReferenceResolverProcessStep(ReferenceConfig.noScopeOrExcludedPaths());
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    PriceQuantityBuilderImpl priceQuantityBuilderImpl = new PriceQuantityBuilderImpl();
    priceQuantityBuilderImpl.setPrice(new FieldWithMetaPriceBuilderImpl());

    // Act
    Object actualResultObject =
        referenceResolverProcessStep
            .runProcessStep(topClass, priceQuantityBuilderImpl)
            .getResultObject();

    // Assert
    assertTrue(actualResultObject instanceof PriceQuantityImpl);
    FieldWithMetaPrice price = ((PriceQuantityImpl) actualResultObject).getPrice();
    assertTrue(price instanceof FieldWithMetaPriceImpl);
    assertNull(price.getMeta());
    Class<Price> expectedValueType = Price.class;
    assertEquals(expectedValueType, price.getValueType());
    Class<FieldWithMetaPrice> expectedType = FieldWithMetaPrice.class;
    assertEquals(expectedType, price.getType());
  }

  /**
   * Test {@link ReferenceResolverProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>When builder.
   *   <li>Then ResultObject return {@link Reference.ReferenceImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceResolverProcessStep#runProcessStep(Class,
   * RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); when builder; then ResultObject return ReferenceImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceResolverProcessStep.ReferenceResolverPostProcessorReport ReferenceResolverProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_whenBuilder_thenResultObjectReturnReferenceImpl() {
    // Arrange
    ReferenceResolverProcessStep referenceResolverProcessStep =
        new ReferenceResolverProcessStep(ReferenceConfig.noScopeOrExcludedPaths());
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    // Act
    Object actualResultObject =
        referenceResolverProcessStep
            .runProcessStep(topClass, Reference.builder())
            .getResultObject();

    // Assert
    assertTrue(actualResultObject instanceof ReferenceImpl);
    assertNull(((ReferenceImpl) actualResultObject).getPointsTo());
    assertNull(((ReferenceImpl) actualResultObject).getReference());
    assertNull(((ReferenceImpl) actualResultObject).getScope());
    Class<Reference> expectedType = Reference.class;
    assertEquals(expectedType, ((ReferenceImpl) actualResultObject).getType());
  }

  /**
   * Test {@link ReferenceResolverProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>When {@link KeyBuilderImpl} (default constructor).
   *   <li>Then return ResultObject KeyValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceResolverProcessStep#runProcessStep(Class,
   * RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); when KeyBuilderImpl (default constructor); then return ResultObject KeyValue is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceResolverProcessStep.ReferenceResolverPostProcessorReport ReferenceResolverProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_whenKeyBuilderImpl_thenReturnResultObjectKeyValueIsNull() {
    // Arrange
    ReferenceResolverProcessStep referenceResolverProcessStep =
        new ReferenceResolverProcessStep(ReferenceConfig.noScopeOrExcludedPaths());
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    // Act
    Object actualResultObject =
        referenceResolverProcessStep
            .runProcessStep(topClass, new KeyBuilderImpl())
            .getResultObject();

    // Assert
    assertTrue(actualResultObject instanceof KeyImpl);
    assertNull(((KeyImpl) actualResultObject).getKeyValue());
    assertNull(((KeyImpl) actualResultObject).getScope());
    Class<Key> expectedType = Key.class;
    assertEquals(expectedType, ((KeyImpl) actualResultObject).getType());
  }

  /**
   * Test {@link ReferenceResolverProcessStep#runProcessStep(Class, RosettaModelObject)}.
   *
   * <ul>
   *   <li>When {@link Price.PriceBuilderImpl} (default constructor).
   *   <li>Then ResultObject return {@link PriceImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceResolverProcessStep#runProcessStep(Class,
   * RosettaModelObject)}
   */
  @Test
  @DisplayName(
      "Test runProcessStep(Class, RosettaModelObject); when PriceBuilderImpl (default constructor); then ResultObject return PriceImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceResolverProcessStep.ReferenceResolverPostProcessorReport ReferenceResolverProcessStep.runProcessStep(Class, RosettaModelObject)"
  })
  void testRunProcessStep_whenPriceBuilderImpl_thenResultObjectReturnPriceImpl() {
    // Arrange
    ReferenceResolverProcessStep referenceResolverProcessStep =
        new ReferenceResolverProcessStep(ReferenceConfig.noScopeOrExcludedPaths());
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    PriceBuilderImpl priceBuilderImpl = new PriceBuilderImpl();

    // Act
    Object actualResultObject =
        referenceResolverProcessStep.runProcessStep(topClass, priceBuilderImpl).getResultObject();

    // Assert
    assertTrue(actualResultObject instanceof PriceImpl);
    assertEquals(priceBuilderImpl, actualResultObject);
  }
}
