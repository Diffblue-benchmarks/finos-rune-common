package com.regnosys.rosetta.common.merging;

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

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.merger.BarBuilder;
import com.regnosys.rosetta.common.merger.FooBuilder;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.PriceQuantity;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.PriceQuantity.PriceQuantityBuilderImpl;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.meta.Key;
import com.rosetta.model.lib.meta.Key.KeyBuilderImpl;
import com.rosetta.model.lib.process.AttributeMeta;
import com.rosetta.model.lib.process.BuilderMerger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class SimpleSplitterDiffblueTest {
  /**
   * Test {@link SimpleSplitter#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}.
   * <ul>
   *   <li>Given {@link Consumer} {@link Consumer#accept(Object)} does nothing.</li>
   *   <li>When {@link BarBuilder} (default constructor).</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleSplitter#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleSplitter.run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)"})
  public void testRun_givenConsumerAcceptDoesNothing_whenBarBuilder_thenCallsAccept() {
    // Arrange
    Consumer<RosettaModelObjectBuilder> postProcessor = mock(Consumer.class);
    doNothing().when(postProcessor).accept(Mockito.<RosettaModelObjectBuilder>any());
    SimpleSplitter simpleSplitter = new SimpleSplitter(postProcessor);
    BarBuilder barBuilder = new BarBuilder();

    // Act
    simpleSplitter.run(barBuilder, new BarBuilder());

    // Assert
    verify(postProcessor).accept(isA(RosettaModelObjectBuilder.class));
  }

  /**
   * Test {@link SimpleSplitter#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}.
   * <ul>
   *   <li>Given {@link Consumer} {@link Consumer#accept(Object)} does nothing.</li>
   *   <li>When {@link FooBuilder} (default constructor).</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleSplitter#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleSplitter.run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)"})
  public void testRun_givenConsumerAcceptDoesNothing_whenFooBuilder_thenCallsAccept() {
    // Arrange
    Consumer<RosettaModelObjectBuilder> postProcessor = mock(Consumer.class);
    doNothing().when(postProcessor).accept(Mockito.<RosettaModelObjectBuilder>any());
    SimpleSplitter simpleSplitter = new SimpleSplitter(postProcessor);
    FooBuilder fooBuilder = new FooBuilder();

    // Act
    simpleSplitter.run(fooBuilder, new FooBuilder());

    // Assert
    verify(postProcessor).accept(isA(RosettaModelObjectBuilder.class));
  }

  /**
   * Test {@link SimpleSplitter#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}.
   * <ul>
   *   <li>Given {@link Consumer} {@link Consumer#accept(Object)} does nothing.</li>
   *   <li>When {@link KeyBuilderImpl} (default constructor).</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleSplitter#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleSplitter.run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)"})
  public void testRun_givenConsumerAcceptDoesNothing_whenKeyBuilderImpl_thenCallsAccept() {
    // Arrange
    Consumer<RosettaModelObjectBuilder> postProcessor = mock(Consumer.class);
    doNothing().when(postProcessor).accept(Mockito.<RosettaModelObjectBuilder>any());
    SimpleSplitter simpleSplitter = new SimpleSplitter(postProcessor);
    KeyBuilderImpl keyBuilderImpl = new KeyBuilderImpl();

    // Act
    simpleSplitter.run(keyBuilderImpl, new KeyBuilderImpl());

    // Assert
    verify(postProcessor).accept(isA(RosettaModelObjectBuilder.class));
  }

  /**
   * Test {@link SimpleSplitter#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When {@link BarBuilder} (default constructor) Num is ten.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleSplitter#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleSplitter.run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)"})
  public void testRun_givenTen_whenBarBuilderNumIsTen_thenCallsAccept() {
    // Arrange
    Consumer<RosettaModelObjectBuilder> postProcessor = mock(Consumer.class);
    doNothing().when(postProcessor).accept(Mockito.<RosettaModelObjectBuilder>any());
    SimpleSplitter simpleSplitter = new SimpleSplitter(postProcessor);

    BarBuilder barBuilder = new BarBuilder();
    barBuilder.setNum(10);

    // Act
    simpleSplitter.run(barBuilder, new BarBuilder());

    // Assert
    verify(postProcessor).accept(isA(RosettaModelObjectBuilder.class));
  }

  /**
   * Test {@link SimpleSplitter#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}.
   * <ul>
   *   <li>When {@link PriceQuantityBuilderImpl} (default constructor).</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleSplitter#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleSplitter.run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)"})
  public void testRun_whenPriceQuantityBuilderImpl_thenCallsAccept() {
    // Arrange
    Consumer<RosettaModelObjectBuilder> postProcessor = mock(Consumer.class);
    doNothing().when(postProcessor).accept(Mockito.<RosettaModelObjectBuilder>any());
    SimpleSplitter simpleSplitter = new SimpleSplitter(postProcessor);
    PriceQuantityBuilderImpl priceQuantityBuilderImpl = new PriceQuantityBuilderImpl();

    // Act
    simpleSplitter.run(priceQuantityBuilderImpl, new PriceQuantityBuilderImpl());

    // Assert
    verify(postProcessor).accept(isA(RosettaModelObjectBuilder.class));
  }

  /**
   * Test {@link SimpleSplitter#mergeRosetta(List, List, Function)} with {@code o1}, {@code o2}, {@code o1GetOrCreateByIndex}.
   * <ul>
   *   <li>Given {@link BarBuilder} (default constructor) Num is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleSplitter#mergeRosetta(List, List, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleSplitter.mergeRosetta(List, List, Function)"})
  public void testMergeRosettaWithO1O2O1GetOrCreateByIndex_givenBarBuilderNumIsTen() {
    // Arrange
    SimpleSplitter simpleSplitter = new SimpleSplitter();
    ArrayList<RosettaModelObjectBuilder> o1 = new ArrayList<>();

    ArrayList<RosettaModelObjectBuilder> o2 = new ArrayList<>();
    o2.add(new BarBuilder());

    BarBuilder barBuilder = new BarBuilder();
    barBuilder.setNum(10);
    Function<Integer, RosettaModelObjectBuilder> o1GetOrCreateByIndex = mock(Function.class);
    when(o1GetOrCreateByIndex.apply(Mockito.<Integer>any())).thenReturn(barBuilder);

    // Act
    simpleSplitter.mergeRosetta(o1, o2, o1GetOrCreateByIndex);

    // Assert
    verify(o1GetOrCreateByIndex).apply(eq(0));
  }

  /**
   * Test {@link SimpleSplitter#mergeRosetta(List, List, Function)} with {@code o1}, {@code o2}, {@code o1GetOrCreateByIndex}.
   * <ul>
   *   <li>Given {@link BarBuilder} (default constructor) Num is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleSplitter#mergeRosetta(List, List, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleSplitter.mergeRosetta(List, List, Function)"})
  public void testMergeRosettaWithO1O2O1GetOrCreateByIndex_givenBarBuilderNumIsTen2() {
    // Arrange
    SimpleSplitter simpleSplitter = new SimpleSplitter();
    ArrayList<RosettaModelObjectBuilder> o1 = new ArrayList<>();

    BarBuilder barBuilder = new BarBuilder();
    barBuilder.setNum(10);

    ArrayList<RosettaModelObjectBuilder> o2 = new ArrayList<>();
    o2.add(barBuilder);

    BarBuilder barBuilder2 = new BarBuilder();
    barBuilder2.setNum(10);
    Function<Integer, RosettaModelObjectBuilder> o1GetOrCreateByIndex = mock(Function.class);
    when(o1GetOrCreateByIndex.apply(Mockito.<Integer>any())).thenReturn(barBuilder2);

    // Act
    simpleSplitter.mergeRosetta(o1, o2, o1GetOrCreateByIndex);

    // Assert
    verify(o1GetOrCreateByIndex).apply(eq(0));
  }

  /**
   * Test {@link SimpleSplitter#mergeRosetta(List, List, Function)} with {@code o1}, {@code o2}, {@code o1GetOrCreateByIndex}.
   * <ul>
   *   <li>Given {@link KeyBuilderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleSplitter#mergeRosetta(List, List, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleSplitter.mergeRosetta(List, List, Function)"})
  public void testMergeRosettaWithO1O2O1GetOrCreateByIndex_givenKeyBuilderImpl() {
    // Arrange
    SimpleSplitter simpleSplitter = new SimpleSplitter();
    ArrayList<RosettaModelObjectBuilder> o1 = new ArrayList<>();

    ArrayList<RosettaModelObjectBuilder> o2 = new ArrayList<>();
    o2.add(new KeyBuilderImpl());
    Function<Integer, RosettaModelObjectBuilder> o1GetOrCreateByIndex = mock(Function.class);
    when(o1GetOrCreateByIndex.apply(Mockito.<Integer>any())).thenReturn(new KeyBuilderImpl());

    // Act
    simpleSplitter.mergeRosetta(o1, o2, o1GetOrCreateByIndex);

    // Assert
    verify(o1GetOrCreateByIndex).apply(eq(0));
  }

  /**
   * Test {@link SimpleSplitter#mergeRosetta(List, List, Function)} with {@code o1}, {@code o2}, {@code o1GetOrCreateByIndex}.
   * <ul>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleSplitter#mergeRosetta(List, List, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleSplitter.mergeRosetta(List, List, Function)"})
  public void testMergeRosettaWithO1O2O1GetOrCreateByIndex_thenCallsApply() {
    // Arrange
    SimpleSplitter simpleSplitter = new SimpleSplitter();
    ArrayList<RosettaModelObjectBuilder> o1 = new ArrayList<>();

    ArrayList<RosettaModelObjectBuilder> o2 = new ArrayList<>();
    o2.add(new BarBuilder());
    Function<Integer, RosettaModelObjectBuilder> o1GetOrCreateByIndex = mock(Function.class);
    when(o1GetOrCreateByIndex.apply(Mockito.<Integer>any())).thenReturn(new BarBuilder());

    // Act
    simpleSplitter.mergeRosetta(o1, o2, o1GetOrCreateByIndex);

    // Assert
    verify(o1GetOrCreateByIndex).apply(eq(0));
  }

  /**
   * Test {@link SimpleSplitter#mergeRosetta(List, List, Function)} with {@code o1}, {@code o2}, {@code o1GetOrCreateByIndex}.
   * <ul>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleSplitter#mergeRosetta(List, List, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleSplitter.mergeRosetta(List, List, Function)"})
  public void testMergeRosettaWithO1O2O1GetOrCreateByIndex_thenCallsApply2() {
    // Arrange
    SimpleSplitter simpleSplitter = new SimpleSplitter();
    ArrayList<RosettaModelObjectBuilder> o1 = new ArrayList<>();

    ArrayList<RosettaModelObjectBuilder> o2 = new ArrayList<>();
    o2.add(new BarBuilder());
    o2.add(new BarBuilder());
    Function<Integer, RosettaModelObjectBuilder> o1GetOrCreateByIndex = mock(Function.class);
    when(o1GetOrCreateByIndex.apply(Mockito.<Integer>any())).thenReturn(new BarBuilder());

    // Act
    simpleSplitter.mergeRosetta(o1, o2, o1GetOrCreateByIndex);

    // Assert
    verify(o1GetOrCreateByIndex, atLeast(1)).apply(Mockito.<Integer>any());
  }

  /**
   * Test {@link SimpleSplitter#mergeRosetta(RosettaModelObjectBuilder, RosettaModelObjectBuilder, Consumer)} with {@code o1}, {@code o2}, {@code o1Setter}.
   * <ul>
   *   <li>Given {@link BarBuilder} (default constructor).</li>
   *   <li>Then calls {@link RosettaModelObjectBuilder#merge(RosettaModelObjectBuilder, BuilderMerger)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleSplitter#mergeRosetta(RosettaModelObjectBuilder, RosettaModelObjectBuilder, Consumer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void SimpleSplitter.mergeRosetta(RosettaModelObjectBuilder, RosettaModelObjectBuilder, Consumer)"})
  public void testMergeRosettaWithO1O2O1Setter_givenBarBuilder_thenCallsMerge() {
    // Arrange
    SimpleSplitter simpleSplitter = new SimpleSplitter();
    RosettaModelObjectBuilder rosettaModelObjectBuilder = mock(RosettaModelObjectBuilder.class);
    when(rosettaModelObjectBuilder.merge(Mockito.<BarBuilder>any(), Mockito.<BuilderMerger>any()))
        .thenReturn(new BarBuilder());

    // Act
    simpleSplitter.mergeRosetta(rosettaModelObjectBuilder, new BarBuilder(), mock(Consumer.class));

    // Assert
    verify(rosettaModelObjectBuilder).merge(isA(BarBuilder.class), isA(BuilderMerger.class));
  }

  /**
   * Test {@link SimpleSplitter#mergeBasic(Object, Object, Consumer, AttributeMeta[])} with {@code o1}, {@code o2}, {@code setter}, {@code metas}.
   * <ul>
   *   <li>When {@code O2}.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleSplitter#mergeBasic(Object, Object, Consumer, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleSplitter.mergeBasic(Object, Object, Consumer, AttributeMeta[])"})
  public void testMergeBasicWithO1O2SetterMetas_whenO2_thenCallsAccept() {
    // Arrange
    SimpleSplitter simpleSplitter = new SimpleSplitter();
    Consumer<Object> setter = mock(Consumer.class);
    doNothing().when(setter).accept(Mockito.<Object>any());

    // Act
    simpleSplitter.mergeBasic("O1", "O2", setter, AttributeMeta.META);

    // Assert
    verify(setter).accept(isNull());
  }
}
