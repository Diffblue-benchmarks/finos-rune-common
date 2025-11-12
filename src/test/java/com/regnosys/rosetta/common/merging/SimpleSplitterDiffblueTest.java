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

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.regnosys.rosetta.common.merger.BarBuilder;
import com.regnosys.rosetta.common.merger.FooBuilder;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.Price;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.Price.PriceBuilderImpl;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SimpleSplitterDiffblueTest {
  /**
   * Test {@link SimpleSplitter#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}.
   *
   * <ul>
   *   <li>Given {@link Consumer} {@link Consumer#accept(Object)} does nothing.
   *   <li>When {@link BarBuilder} (default constructor).
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleSplitter#run(RosettaModelObjectBuilder,
   * RosettaModelObjectBuilder)}
   */
  @Test
  @DisplayName(
      "Test run(RosettaModelObjectBuilder, RosettaModelObjectBuilder); given Consumer accept(Object) does nothing; when BarBuilder (default constructor); then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleSplitter.run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)"
  })
  void testRun_givenConsumerAcceptDoesNothing_whenBarBuilder_thenCallsAccept() {
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
   *
   * <ul>
   *   <li>Given {@link Consumer} {@link Consumer#accept(Object)} does nothing.
   *   <li>When {@link FooBuilder} (default constructor).
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleSplitter#run(RosettaModelObjectBuilder,
   * RosettaModelObjectBuilder)}
   */
  @Test
  @DisplayName(
      "Test run(RosettaModelObjectBuilder, RosettaModelObjectBuilder); given Consumer accept(Object) does nothing; when FooBuilder (default constructor); then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleSplitter.run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)"
  })
  void testRun_givenConsumerAcceptDoesNothing_whenFooBuilder_thenCallsAccept() {
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
   *
   * <ul>
   *   <li>Given {@link Consumer} {@link Consumer#accept(Object)} does nothing.
   *   <li>When {@link KeyBuilderImpl} (default constructor).
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleSplitter#run(RosettaModelObjectBuilder,
   * RosettaModelObjectBuilder)}
   */
  @Test
  @DisplayName(
      "Test run(RosettaModelObjectBuilder, RosettaModelObjectBuilder); given Consumer accept(Object) does nothing; when KeyBuilderImpl (default constructor); then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleSplitter.run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)"
  })
  void testRun_givenConsumerAcceptDoesNothing_whenKeyBuilderImpl_thenCallsAccept() {
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
   *
   * <ul>
   *   <li>Given ten.
   *   <li>When {@link BarBuilder} (default constructor) Num is ten.
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleSplitter#run(RosettaModelObjectBuilder,
   * RosettaModelObjectBuilder)}
   */
  @Test
  @DisplayName(
      "Test run(RosettaModelObjectBuilder, RosettaModelObjectBuilder); given ten; when BarBuilder (default constructor) Num is ten; then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleSplitter.run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)"
  })
  void testRun_givenTen_whenBarBuilderNumIsTen_thenCallsAccept() {
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
   *
   * <ul>
   *   <li>When {@link PriceQuantity.PriceQuantityBuilderImpl} (default constructor).
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleSplitter#run(RosettaModelObjectBuilder,
   * RosettaModelObjectBuilder)}
   */
  @Test
  @DisplayName(
      "Test run(RosettaModelObjectBuilder, RosettaModelObjectBuilder); when PriceQuantityBuilderImpl (default constructor); then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleSplitter.run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)"
  })
  void testRun_whenPriceQuantityBuilderImpl_thenCallsAccept() {
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
   * Test {@link SimpleSplitter#mergeRosetta(List, List, Function)} with {@code o1}, {@code o2},
   * {@code o1GetOrCreateByIndex}.
   *
   * <ul>
   *   <li>Given {@link BarBuilder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SimpleSplitter#mergeRosetta(List, List, Function)}
   */
  @Test
  @DisplayName(
      "Test mergeRosetta(List, List, Function) with 'o1', 'o2', 'o1GetOrCreateByIndex'; given BarBuilder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleSplitter.mergeRosetta(List, List, Function)"})
  void testMergeRosettaWithO1O2O1GetOrCreateByIndex_givenBarBuilder() {
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
    verify(o1GetOrCreateByIndex).apply(0);
  }

  /**
   * Test {@link SimpleSplitter#mergeRosetta(List, List, Function)} with {@code o1}, {@code o2},
   * {@code o1GetOrCreateByIndex}.
   *
   * <ul>
   *   <li>Given {@link BarBuilder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SimpleSplitter#mergeRosetta(List, List, Function)}
   */
  @Test
  @DisplayName(
      "Test mergeRosetta(List, List, Function) with 'o1', 'o2', 'o1GetOrCreateByIndex'; given BarBuilder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleSplitter.mergeRosetta(List, List, Function)"})
  void testMergeRosettaWithO1O2O1GetOrCreateByIndex_givenBarBuilder2() {
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
   * Test {@link SimpleSplitter#mergeRosetta(List, List, Function)} with {@code o1}, {@code o2},
   * {@code o1GetOrCreateByIndex}.
   *
   * <ul>
   *   <li>Given {@link BarBuilder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SimpleSplitter#mergeRosetta(List, List, Function)}
   */
  @Test
  @DisplayName(
      "Test mergeRosetta(List, List, Function) with 'o1', 'o2', 'o1GetOrCreateByIndex'; given BarBuilder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleSplitter.mergeRosetta(List, List, Function)"})
  void testMergeRosettaWithO1O2O1GetOrCreateByIndex_givenBarBuilder3() {
    // Arrange
    SimpleSplitter simpleSplitter = new SimpleSplitter();

    ArrayList<RosettaModelObjectBuilder> o1 = new ArrayList<>();
    o1.add(new BarBuilder());

    ArrayList<RosettaModelObjectBuilder> o2 = new ArrayList<>();
    o2.add(new BarBuilder());

    Function<Integer, RosettaModelObjectBuilder> o1GetOrCreateByIndex = mock(Function.class);
    when(o1GetOrCreateByIndex.apply(Mockito.<Integer>any())).thenReturn(new BarBuilder());

    // Act
    simpleSplitter.mergeRosetta(o1, o2, o1GetOrCreateByIndex);

    // Assert
    verify(o1GetOrCreateByIndex).apply(0);
  }

  /**
   * Test {@link SimpleSplitter#mergeRosetta(List, List, Function)} with {@code o1}, {@code o2},
   * {@code o1GetOrCreateByIndex}.
   *
   * <ul>
   *   <li>Given {@link BarBuilder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SimpleSplitter#mergeRosetta(List, List, Function)}
   */
  @Test
  @DisplayName(
      "Test mergeRosetta(List, List, Function) with 'o1', 'o2', 'o1GetOrCreateByIndex'; given BarBuilder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleSplitter.mergeRosetta(List, List, Function)"})
  void testMergeRosettaWithO1O2O1GetOrCreateByIndex_givenBarBuilder4() {
    // Arrange
    SimpleSplitter simpleSplitter = new SimpleSplitter();

    ArrayList<RosettaModelObjectBuilder> o1 = new ArrayList<>();
    o1.add(new BarBuilder());
    o1.add(new BarBuilder());

    ArrayList<RosettaModelObjectBuilder> o2 = new ArrayList<>();
    o2.add(new BarBuilder());

    Function<Integer, RosettaModelObjectBuilder> o1GetOrCreateByIndex = mock(Function.class);
    when(o1GetOrCreateByIndex.apply(Mockito.<Integer>any())).thenReturn(new BarBuilder());

    // Act
    simpleSplitter.mergeRosetta(o1, o2, o1GetOrCreateByIndex);

    // Assert
    verify(o1GetOrCreateByIndex).apply(0);
  }

  /**
   * Test {@link SimpleSplitter#mergeRosetta(List, List, Function)} with {@code o1}, {@code o2},
   * {@code o1GetOrCreateByIndex}.
   *
   * <ul>
   *   <li>Given {@link BarBuilder} (default constructor) Num is ten.
   * </ul>
   *
   * <p>Method under test: {@link SimpleSplitter#mergeRosetta(List, List, Function)}
   */
  @Test
  @DisplayName(
      "Test mergeRosetta(List, List, Function) with 'o1', 'o2', 'o1GetOrCreateByIndex'; given BarBuilder (default constructor) Num is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleSplitter.mergeRosetta(List, List, Function)"})
  void testMergeRosettaWithO1O2O1GetOrCreateByIndex_givenBarBuilderNumIsTen() {
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
    verify(o1GetOrCreateByIndex).apply(0);
  }

  /**
   * Test {@link SimpleSplitter#mergeRosetta(List, List, Function)} with {@code o1}, {@code o2},
   * {@code o1GetOrCreateByIndex}.
   *
   * <ul>
   *   <li>Given {@link BarBuilder} (default constructor) Num is ten.
   * </ul>
   *
   * <p>Method under test: {@link SimpleSplitter#mergeRosetta(List, List, Function)}
   */
  @Test
  @DisplayName(
      "Test mergeRosetta(List, List, Function) with 'o1', 'o2', 'o1GetOrCreateByIndex'; given BarBuilder (default constructor) Num is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleSplitter.mergeRosetta(List, List, Function)"})
  void testMergeRosettaWithO1O2O1GetOrCreateByIndex_givenBarBuilderNumIsTen2() {
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
    verify(o1GetOrCreateByIndex).apply(0);
  }

  /**
   * Test {@link SimpleSplitter#mergeRosetta(List, List, Function)} with {@code o1}, {@code o2},
   * {@code o1GetOrCreateByIndex}.
   *
   * <ul>
   *   <li>Given {@link KeyBuilderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SimpleSplitter#mergeRosetta(List, List, Function)}
   */
  @Test
  @DisplayName(
      "Test mergeRosetta(List, List, Function) with 'o1', 'o2', 'o1GetOrCreateByIndex'; given KeyBuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleSplitter.mergeRosetta(List, List, Function)"})
  void testMergeRosettaWithO1O2O1GetOrCreateByIndex_givenKeyBuilderImpl() {
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
    verify(o1GetOrCreateByIndex).apply(0);
  }

  /**
   * Test {@link SimpleSplitter#mergeRosetta(RosettaModelObjectBuilder, RosettaModelObjectBuilder,
   * Consumer)} with {@code o1}, {@code o2}, {@code o1Setter}.
   *
   * <ul>
   *   <li>Given {@link Price.PriceBuilderImpl} (default constructor).
   *   <li>Then calls {@link Price.PriceBuilderImpl#merge(RosettaModelObjectBuilder,
   *       BuilderMerger)}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleSplitter#mergeRosetta(RosettaModelObjectBuilder,
   * RosettaModelObjectBuilder, Consumer)}
   */
  @Test
  @DisplayName(
      "Test mergeRosetta(RosettaModelObjectBuilder, RosettaModelObjectBuilder, Consumer) with 'o1', 'o2', 'o1Setter'; given PriceBuilderImpl (default constructor); then calls merge(RosettaModelObjectBuilder, BuilderMerger)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleSplitter.mergeRosetta(RosettaModelObjectBuilder, RosettaModelObjectBuilder, Consumer)"
  })
  void testMergeRosettaWithO1O2O1Setter_givenPriceBuilderImpl_thenCallsMerge() {
    // Arrange
    SimpleSplitter simpleSplitter = new SimpleSplitter();

    PriceBuilderImpl priceBuilderImpl = mock(PriceBuilderImpl.class);
    when(priceBuilderImpl.merge(
            Mockito.<RosettaModelObjectBuilder>any(), Mockito.<BuilderMerger>any()))
        .thenReturn(new PriceBuilderImpl());

    // Act
    simpleSplitter.mergeRosetta(priceBuilderImpl, new BarBuilder(), mock(Consumer.class));

    // Assert
    verify(priceBuilderImpl).merge(isA(RosettaModelObjectBuilder.class), isA(BuilderMerger.class));
  }

  /**
   * Test {@link SimpleSplitter#mergeBasic(Object, Object, Consumer, AttributeMeta[])} with {@code
   * o1}, {@code o2}, {@code setter}, {@code metas}.
   *
   * <ul>
   *   <li>When {@link Consumer} {@link Consumer#accept(Object)} does nothing.
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleSplitter#mergeBasic(Object, Object, Consumer,
   * AttributeMeta[])}
   */
  @Test
  @DisplayName(
      "Test mergeBasic(Object, Object, Consumer, AttributeMeta[]) with 'o1', 'o2', 'setter', 'metas'; when Consumer accept(Object) does nothing; then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleSplitter.mergeBasic(Object, Object, Consumer, AttributeMeta[])"})
  void testMergeBasicWithO1O2SetterMetas_whenConsumerAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    SimpleSplitter simpleSplitter = new SimpleSplitter();

    Consumer<Object> setter = mock(Consumer.class);
    doNothing().when(setter).accept(Mockito.<Object>any());

    // Act
    simpleSplitter.mergeBasic(
        BeanPropertyWriter.MARKER_FOR_EMPTY,
        BeanPropertyWriter.MARKER_FOR_EMPTY,
        setter,
        AttributeMeta.META);

    // Assert
    verify(setter).accept(isNull());
  }
}
