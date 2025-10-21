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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.hashing.GlobalKeyProcessStep.KeyPostProcessReport;
import com.regnosys.rosetta.common.hashing.GlobalKeyProcessStep.ReKeyProcessor;
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
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.meta.Key;
import com.rosetta.model.lib.meta.Key.KeyBuilder;
import com.rosetta.model.lib.meta.Key.KeyBuilderImpl;
import com.rosetta.model.lib.meta.Reference;
import com.rosetta.model.lib.meta.Reference.ReferenceBuilderImpl;
import com.rosetta.model.lib.meta.Reference.ReferenceImpl;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.AttributeMeta;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class GlobalKeyProcessStepDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GlobalKeyProcessStep#GlobalKeyProcessStep(Supplier)}
   *   <li>{@link GlobalKeyProcessStep#getName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GlobalKeyProcessStep.<init>(Supplier)", "java.lang.String GlobalKeyProcessStep.getName()"})
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("GlobalKey postProcessor", (new GlobalKeyProcessStep(mock(Supplier.class))).getName());
  }

  /**
   * Test {@link GlobalKeyProcessStep#getPriority()}.
   * <p>
   * Method under test: {@link GlobalKeyProcessStep#getPriority()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Integer GlobalKeyProcessStep.getPriority()"})
  public void testGetPriority() {
    // Arrange, Act and Assert
    assertEquals(1, (new GlobalKeyProcessStep(mock(Supplier.class))).getPriority().intValue());
  }

  /**
   * Test KeyPostProcessReport {@link KeyPostProcessReport#getResultObject()}.
   * <p>
   * Method under test: {@link KeyPostProcessReport#getResultObject()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RosettaModelObjectBuilder KeyPostProcessReport.getResultObject()"})
  public void testKeyPostProcessReportGetResultObject() {
    // Arrange
    GlobalKeyProcessStep globalKeyProcessStep = new GlobalKeyProcessStep(mock(Supplier.class));
    BarBuilder result = new BarBuilder();

    // Act and Assert
    assertSame(result, (globalKeyProcessStep.new KeyPostProcessReport(result, new HashMap<>())).getResultObject());
  }

  /**
   * Test ReKeyProcessor {@link ReKeyProcessor#processRosetta(RosettaPath, Class, RosettaModelObjectBuilder, RosettaModelObjectBuilder, AttributeMeta[])} with {@code path}, {@code rosettaType}, {@code builder}, {@code parent}, {@code metas}.
   * <p>
   * Method under test: {@link ReKeyProcessor#processRosetta(RosettaPath, Class, RosettaModelObjectBuilder, RosettaModelObjectBuilder, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ReKeyProcessor.processRosetta(RosettaPath, Class, RosettaModelObjectBuilder, RosettaModelObjectBuilder, AttributeMeta[])"})
  public void testReKeyProcessorProcessRosettaWithPathRosettaTypeBuilderParentMetas() {
    // Arrange
    GlobalKeyProcessStep globalKeyProcessStep = new GlobalKeyProcessStep(mock(Supplier.class));
    GlobalKeyProcessStep globalKeyProcessStep2 = new GlobalKeyProcessStep(mock(Supplier.class));
    BarBuilder result = new BarBuilder();
    ReKeyProcessor reKeyProcessor = globalKeyProcessStep.new ReKeyProcessor(
        globalKeyProcessStep2.new KeyPostProcessReport(result, new HashMap<>()));
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;
    BarBuilder builder = new BarBuilder();

    // Act and Assert
    assertFalse(reKeyProcessor.processRosetta(path, rosettaType, builder, new BarBuilder(), AttributeMeta.META));
  }

  /**
   * Test ReKeyProcessor {@link ReKeyProcessor#processRosetta(RosettaPath, Class, RosettaModelObjectBuilder, RosettaModelObjectBuilder, AttributeMeta[])} with {@code path}, {@code rosettaType}, {@code builder}, {@code parent}, {@code metas}.
   * <p>
   * Method under test: {@link ReKeyProcessor#processRosetta(RosettaPath, Class, RosettaModelObjectBuilder, RosettaModelObjectBuilder, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ReKeyProcessor.processRosetta(RosettaPath, Class, RosettaModelObjectBuilder, RosettaModelObjectBuilder, AttributeMeta[])"})
  public void testReKeyProcessorProcessRosettaWithPathRosettaTypeBuilderParentMetas2() {
    // Arrange
    GlobalKeyProcessStep globalKeyProcessStep = new GlobalKeyProcessStep(mock(Supplier.class));
    GlobalKeyProcessStep globalKeyProcessStep2 = new GlobalKeyProcessStep(mock(Supplier.class));
    BarBuilder result = new BarBuilder();
    ReKeyProcessor reKeyProcessor = globalKeyProcessStep.new ReKeyProcessor(
        globalKeyProcessStep2.new KeyPostProcessReport(result, new HashMap<>()));
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;

    BarBuilder builder = new BarBuilder();
    builder.setNum(10);

    // Act and Assert
    assertTrue(reKeyProcessor.processRosetta(path, rosettaType, builder, new BarBuilder(), AttributeMeta.META));
  }

  /**
   * Test ReKeyProcessor {@link ReKeyProcessor#processRosetta(RosettaPath, Class, RosettaModelObjectBuilder, RosettaModelObjectBuilder, AttributeMeta[])} with {@code path}, {@code rosettaType}, {@code builder}, {@code parent}, {@code metas}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReKeyProcessor#processRosetta(RosettaPath, Class, RosettaModelObjectBuilder, RosettaModelObjectBuilder, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ReKeyProcessor.processRosetta(RosettaPath, Class, RosettaModelObjectBuilder, RosettaModelObjectBuilder, AttributeMeta[])"})
  public void testReKeyProcessorProcessRosettaWithPathRosettaTypeBuilderParentMetas_whenNull() {
    // Arrange
    GlobalKeyProcessStep globalKeyProcessStep = new GlobalKeyProcessStep(mock(Supplier.class));
    GlobalKeyProcessStep globalKeyProcessStep2 = new GlobalKeyProcessStep(mock(Supplier.class));
    BarBuilder result = new BarBuilder();
    ReKeyProcessor reKeyProcessor = globalKeyProcessStep.new ReKeyProcessor(
        globalKeyProcessStep2.new KeyPostProcessReport(result, new HashMap<>()));
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;

    // Act and Assert
    assertFalse(reKeyProcessor.processRosetta(path, rosettaType, (RosettaModelObjectBuilder) null, new BarBuilder(),
        AttributeMeta.META));
  }

  /**
   * Test {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}.
   * <ul>
   *   <li>Given {@link KeyBuilderImpl} (default constructor).</li>
   *   <li>Then return ResultObject Key size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KeyPostProcessReport GlobalKeyProcessStep.runProcessStep(Class, RosettaModelObject)"})
  public void testRunProcessStep_givenKeyBuilderImpl_thenReturnResultObjectKeySizeIsOne() {
    // Arrange
    GlobalKeyProcessStep globalKeyProcessStep = new GlobalKeyProcessStep(mock(Supplier.class));
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    MetaFieldsBuilderImpl metaFieldsBuilderImpl = new MetaFieldsBuilderImpl();
    KeyBuilderImpl key = new KeyBuilderImpl();
    metaFieldsBuilderImpl.addKey(key);

    // Act and Assert
    RosettaModelObjectBuilder resultObject = globalKeyProcessStep.runProcessStep(topClass, metaFieldsBuilderImpl)
        .getResultObject();
    assertTrue(resultObject instanceof MetaFieldsBuilderImpl);
    List<? extends KeyBuilder> key2 = ((MetaFieldsBuilderImpl) resultObject).getKey();
    assertEquals(1, key2.size());
    assertSame(key, key2.get(0));
  }

  /**
   * Test {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}.
   * <ul>
   *   <li>Given {@link KeyBuilderImpl} (default constructor).</li>
   *   <li>Then return ResultObject Key size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KeyPostProcessReport GlobalKeyProcessStep.runProcessStep(Class, RosettaModelObject)"})
  public void testRunProcessStep_givenKeyBuilderImpl_thenReturnResultObjectKeySizeIsTwo() {
    // Arrange
    GlobalKeyProcessStep globalKeyProcessStep = new GlobalKeyProcessStep(mock(Supplier.class));
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    MetaFieldsBuilderImpl metaFieldsBuilderImpl = new MetaFieldsBuilderImpl();
    metaFieldsBuilderImpl.addKey(new KeyBuilderImpl());
    KeyBuilderImpl key = new KeyBuilderImpl();
    metaFieldsBuilderImpl.addKey(key);

    // Act and Assert
    RosettaModelObjectBuilder resultObject = globalKeyProcessStep.runProcessStep(topClass, metaFieldsBuilderImpl)
        .getResultObject();
    assertTrue(resultObject instanceof MetaFieldsBuilderImpl);
    List<? extends KeyBuilder> key2 = ((MetaFieldsBuilderImpl) resultObject).getKey();
    assertEquals(2, key2.size());
    assertSame(key, key2.get(1));
  }

  /**
   * Test {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>Then return ResultObject Key size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KeyPostProcessReport GlobalKeyProcessStep.runProcessStep(Class, RosettaModelObject)"})
  public void testRunProcessStep_givenTwo_thenReturnResultObjectKeySizeIsFour() {
    // Arrange
    GlobalKeyProcessStep globalKeyProcessStep = new GlobalKeyProcessStep(mock(Supplier.class));
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    MetaFieldsBuilderImpl metaFieldsBuilderImpl = new MetaFieldsBuilderImpl();
    KeyBuilderImpl key = new KeyBuilderImpl();
    metaFieldsBuilderImpl.addKey(key, 2);
    KeyBuilderImpl key2 = new KeyBuilderImpl();
    metaFieldsBuilderImpl.addKey(key2);

    // Act and Assert
    RosettaModelObjectBuilder resultObject = globalKeyProcessStep.runProcessStep(topClass, metaFieldsBuilderImpl)
        .getResultObject();
    assertTrue(resultObject instanceof MetaFieldsBuilderImpl);
    List<? extends KeyBuilder> key3 = ((MetaFieldsBuilderImpl) resultObject).getKey();
    assertEquals(4, key3.size());
    assertNull(key3.get(0));
    assertNull(key3.get(1));
    assertSame(key, key3.get(2));
    assertSame(key2, key3.get(3));
  }

  /**
   * Test {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}.
   * <ul>
   *   <li>Then ResultObject return {@link PriceQuantity.PriceQuantityBuilderImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KeyPostProcessReport GlobalKeyProcessStep.runProcessStep(Class, RosettaModelObject)"})
  public void testRunProcessStep_thenResultObjectReturnPriceQuantityBuilderImpl() {
    // Arrange
    GlobalKeyProcessStep globalKeyProcessStep = new GlobalKeyProcessStep(mock(Supplier.class));
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    // Act and Assert
    RosettaModelObjectBuilder resultObject = globalKeyProcessStep
        .runProcessStep(topClass, new PriceQuantityBuilderImpl())
        .getResultObject();
    assertTrue(resultObject instanceof PriceQuantityBuilderImpl);
    FieldWithMetaPriceBuilder orCreatePrice = ((PriceQuantityBuilderImpl) resultObject).getOrCreatePrice();
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
   * Test {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}.
   * <ul>
   *   <li>Then ResultObject return {@link ReferenceBuilderImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KeyPostProcessReport GlobalKeyProcessStep.runProcessStep(Class, RosettaModelObject)"})
  public void testRunProcessStep_thenResultObjectReturnReferenceBuilderImpl() {
    // Arrange
    GlobalKeyProcessStep globalKeyProcessStep = new GlobalKeyProcessStep(mock(Supplier.class));
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    // Act and Assert
    RosettaModelObjectBuilder resultObject = globalKeyProcessStep
        .runProcessStep(topClass,
            new ReferenceImpl("method toBuilder in BarBuilder has not been implemented", "alice.liddell@example.org",
                "method toBuilder in BarBuilder has not been implemented"))
        .getResultObject();
    assertTrue(resultObject instanceof ReferenceBuilderImpl);
    assertEquals("alice.liddell@example.org", ((ReferenceBuilderImpl) resultObject).getPointsTo());
    assertEquals("method toBuilder in BarBuilder has not been implemented",
        ((ReferenceBuilderImpl) resultObject).getReference());
    assertEquals("method toBuilder in BarBuilder has not been implemented",
        ((ReferenceBuilderImpl) resultObject).getScope());
    assertTrue(resultObject.hasData());
    Class<Reference> expectedType = Reference.class;
    assertEquals(expectedType, resultObject.getType());
  }

  /**
   * Test {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}.
   * <ul>
   *   <li>Then return ResultObject is {@link FieldWithMetaPrice.FieldWithMetaPriceBuilderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KeyPostProcessReport GlobalKeyProcessStep.runProcessStep(Class, RosettaModelObject)"})
  public void testRunProcessStep_thenReturnResultObjectIsFieldWithMetaPriceBuilderImpl() {
    // Arrange
    GlobalKeyProcessStep globalKeyProcessStep = new GlobalKeyProcessStep(mock(Supplier.class));
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    FieldWithMetaPriceBuilderImpl fieldWithMetaPriceBuilderImpl = new FieldWithMetaPriceBuilderImpl();

    // Act and Assert
    assertSame(fieldWithMetaPriceBuilderImpl,
        globalKeyProcessStep.runProcessStep(topClass, fieldWithMetaPriceBuilderImpl).getResultObject());
  }

  /**
   * Test {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}.
   * <ul>
   *   <li>Then return ResultObject is {@link MetaFieldsBuilderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KeyPostProcessReport GlobalKeyProcessStep.runProcessStep(Class, RosettaModelObject)"})
  public void testRunProcessStep_thenReturnResultObjectIsMetaFieldsBuilderImpl() {
    // Arrange
    GlobalKeyProcessStep globalKeyProcessStep = new GlobalKeyProcessStep(mock(Supplier.class));
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    MetaFieldsBuilderImpl metaFieldsBuilderImpl = new MetaFieldsBuilderImpl();

    // Act and Assert
    assertSame(metaFieldsBuilderImpl,
        globalKeyProcessStep.runProcessStep(topClass, metaFieldsBuilderImpl).getResultObject());
  }

  /**
   * Test {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}.
   * <ul>
   *   <li>Then return ResultObject is {@link PriceQuantity.PriceQuantityBuilderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KeyPostProcessReport GlobalKeyProcessStep.runProcessStep(Class, RosettaModelObject)"})
  public void testRunProcessStep_thenReturnResultObjectIsPriceQuantityBuilderImpl() {
    // Arrange
    GlobalKeyProcessStep globalKeyProcessStep = new GlobalKeyProcessStep(mock(Supplier.class));
    Class<RosettaModelObject> topClass = RosettaModelObject.class;

    PriceQuantityBuilderImpl priceQuantityBuilderImpl = new PriceQuantityBuilderImpl();
    priceQuantityBuilderImpl.setPrice(new FieldWithMetaPriceBuilderImpl());

    // Act and Assert
    assertSame(priceQuantityBuilderImpl,
        globalKeyProcessStep.runProcessStep(topClass, priceQuantityBuilderImpl).getResultObject());
  }

  /**
   * Test {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}.
   * <ul>
   *   <li>When {@link KeyBuilderImpl} (default constructor).</li>
   *   <li>Then return ResultObject is {@link KeyBuilderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KeyPostProcessReport GlobalKeyProcessStep.runProcessStep(Class, RosettaModelObject)"})
  public void testRunProcessStep_whenKeyBuilderImpl_thenReturnResultObjectIsKeyBuilderImpl() {
    // Arrange
    GlobalKeyProcessStep globalKeyProcessStep = new GlobalKeyProcessStep(mock(Supplier.class));
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    KeyBuilderImpl keyBuilderImpl = new KeyBuilderImpl();

    // Act and Assert
    assertSame(keyBuilderImpl, globalKeyProcessStep.runProcessStep(topClass, keyBuilderImpl).getResultObject());
  }

  /**
   * Test {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}.
   * <ul>
   *   <li>When {@link Price.PriceBuilderImpl} (default constructor).</li>
   *   <li>Then return ResultObject is {@link Price.PriceBuilderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link GlobalKeyProcessStep#runProcessStep(Class, RosettaModelObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KeyPostProcessReport GlobalKeyProcessStep.runProcessStep(Class, RosettaModelObject)"})
  public void testRunProcessStep_whenPriceBuilderImpl_thenReturnResultObjectIsPriceBuilderImpl() {
    // Arrange
    GlobalKeyProcessStep globalKeyProcessStep = new GlobalKeyProcessStep(mock(Supplier.class));
    Class<RosettaModelObject> topClass = RosettaModelObject.class;
    PriceBuilderImpl priceBuilderImpl = new PriceBuilderImpl();

    // Act and Assert
    assertSame(priceBuilderImpl, globalKeyProcessStep.runProcessStep(topClass, priceBuilderImpl).getResultObject());
  }
}
