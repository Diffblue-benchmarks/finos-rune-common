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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SimpleMergerDiffblueTest {
  /**
   * Test {@link SimpleMerger#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}.
   *
   * <ul>
   *   <li>Given {@link Consumer} {@link Consumer#accept(Object)} does nothing.
   *   <li>When {@link BarBuilder} (default constructor).
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleMerger#run(RosettaModelObjectBuilder,
   * RosettaModelObjectBuilder)}
   */
  @Test
  @DisplayName(
      "Test run(RosettaModelObjectBuilder, RosettaModelObjectBuilder); given Consumer accept(Object) does nothing; when BarBuilder (default constructor); then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleMerger.run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)"})
  void testRun_givenConsumerAcceptDoesNothing_whenBarBuilder_thenCallsAccept() {
    // Arrange
    Consumer<RosettaModelObjectBuilder> postProcessor = mock(Consumer.class);
    doNothing().when(postProcessor).accept(Mockito.<RosettaModelObjectBuilder>any());
    SimpleMerger simpleMerger = new SimpleMerger(postProcessor);
    BarBuilder barBuilder = new BarBuilder();

    // Act
    simpleMerger.run(barBuilder, new BarBuilder());

    // Assert
    verify(postProcessor).accept(isA(RosettaModelObjectBuilder.class));
  }

  /**
   * Test {@link SimpleMerger#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}.
   *
   * <ul>
   *   <li>Given {@link Consumer} {@link Consumer#accept(Object)} does nothing.
   *   <li>When {@link FooBuilder} (default constructor).
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleMerger#run(RosettaModelObjectBuilder,
   * RosettaModelObjectBuilder)}
   */
  @Test
  @DisplayName(
      "Test run(RosettaModelObjectBuilder, RosettaModelObjectBuilder); given Consumer accept(Object) does nothing; when FooBuilder (default constructor); then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleMerger.run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)"})
  void testRun_givenConsumerAcceptDoesNothing_whenFooBuilder_thenCallsAccept() {
    // Arrange
    Consumer<RosettaModelObjectBuilder> postProcessor = mock(Consumer.class);
    doNothing().when(postProcessor).accept(Mockito.<RosettaModelObjectBuilder>any());
    SimpleMerger simpleMerger = new SimpleMerger(postProcessor);
    FooBuilder fooBuilder = new FooBuilder();

    // Act
    simpleMerger.run(fooBuilder, new FooBuilder());

    // Assert
    verify(postProcessor).accept(isA(RosettaModelObjectBuilder.class));
  }

  /**
   * Test {@link SimpleMerger#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}.
   *
   * <ul>
   *   <li>Given {@link Consumer} {@link Consumer#accept(Object)} does nothing.
   *   <li>When {@link KeyBuilderImpl} (default constructor).
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleMerger#run(RosettaModelObjectBuilder,
   * RosettaModelObjectBuilder)}
   */
  @Test
  @DisplayName(
      "Test run(RosettaModelObjectBuilder, RosettaModelObjectBuilder); given Consumer accept(Object) does nothing; when KeyBuilderImpl (default constructor); then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleMerger.run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)"})
  void testRun_givenConsumerAcceptDoesNothing_whenKeyBuilderImpl_thenCallsAccept() {
    // Arrange
    Consumer<RosettaModelObjectBuilder> postProcessor = mock(Consumer.class);
    doNothing().when(postProcessor).accept(Mockito.<RosettaModelObjectBuilder>any());
    SimpleMerger simpleMerger = new SimpleMerger(postProcessor);
    KeyBuilderImpl keyBuilderImpl = new KeyBuilderImpl();

    // Act
    simpleMerger.run(keyBuilderImpl, new KeyBuilderImpl());

    // Assert
    verify(postProcessor).accept(isA(RosettaModelObjectBuilder.class));
  }

  /**
   * Test {@link SimpleMerger#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>When {@link BarBuilder} (default constructor) Num is ten.
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleMerger#run(RosettaModelObjectBuilder,
   * RosettaModelObjectBuilder)}
   */
  @Test
  @DisplayName(
      "Test run(RosettaModelObjectBuilder, RosettaModelObjectBuilder); given ten; when BarBuilder (default constructor) Num is ten; then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleMerger.run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)"})
  void testRun_givenTen_whenBarBuilderNumIsTen_thenCallsAccept() {
    // Arrange
    Consumer<RosettaModelObjectBuilder> postProcessor = mock(Consumer.class);
    doNothing().when(postProcessor).accept(Mockito.<RosettaModelObjectBuilder>any());
    SimpleMerger simpleMerger = new SimpleMerger(postProcessor);

    BarBuilder barBuilder = new BarBuilder();
    barBuilder.setNum(10);

    // Act
    simpleMerger.run(barBuilder, new BarBuilder());

    // Assert
    verify(postProcessor).accept(isA(RosettaModelObjectBuilder.class));
  }

  /**
   * Test {@link SimpleMerger#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleMerger#run(RosettaModelObjectBuilder,
   * RosettaModelObjectBuilder)}
   */
  @Test
  @DisplayName(
      "Test run(RosettaModelObjectBuilder, RosettaModelObjectBuilder); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleMerger.run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)"})
  void testRun_thenThrowIllegalArgumentException() {
    // Arrange
    Consumer<RosettaModelObjectBuilder> postProcessor = mock(Consumer.class);
    doThrow(new IllegalArgumentException())
        .when(postProcessor)
        .accept(Mockito.<RosettaModelObjectBuilder>any());
    SimpleMerger simpleMerger = new SimpleMerger(postProcessor);
    BarBuilder barBuilder = new BarBuilder();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> simpleMerger.run(barBuilder, new BarBuilder()));
    verify(postProcessor).accept(isA(RosettaModelObjectBuilder.class));
  }

  /**
   * Test {@link SimpleMerger#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}.
   *
   * <ul>
   *   <li>When {@link PriceQuantity.PriceQuantityBuilderImpl} (default constructor).
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleMerger#run(RosettaModelObjectBuilder,
   * RosettaModelObjectBuilder)}
   */
  @Test
  @DisplayName(
      "Test run(RosettaModelObjectBuilder, RosettaModelObjectBuilder); when PriceQuantityBuilderImpl (default constructor); then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleMerger.run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)"})
  void testRun_whenPriceQuantityBuilderImpl_thenCallsAccept() {
    // Arrange
    Consumer<RosettaModelObjectBuilder> postProcessor = mock(Consumer.class);
    doNothing().when(postProcessor).accept(Mockito.<RosettaModelObjectBuilder>any());
    SimpleMerger simpleMerger = new SimpleMerger(postProcessor);
    PriceQuantityBuilderImpl priceQuantityBuilderImpl = new PriceQuantityBuilderImpl();

    // Act
    simpleMerger.run(priceQuantityBuilderImpl, new PriceQuantityBuilderImpl());

    // Assert
    verify(postProcessor).accept(isA(RosettaModelObjectBuilder.class));
  }

  /**
   * Test {@link SimpleMerger#mergeRosetta(List, List, Function)} with {@code o1}, {@code o2},
   * {@code o1GetOrCreateByIndex}.
   *
   * <ul>
   *   <li>Given {@link BarBuilder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SimpleMerger#mergeRosetta(List, List, Function)}
   */
  @Test
  @DisplayName(
      "Test mergeRosetta(List, List, Function) with 'o1', 'o2', 'o1GetOrCreateByIndex'; given BarBuilder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleMerger.mergeRosetta(List, List, Function)"})
  void testMergeRosettaWithO1O2O1GetOrCreateByIndex_givenBarBuilder() {
    // Arrange
    SimpleMerger simpleMerger = new SimpleMerger();
    ArrayList<RosettaModelObjectBuilder> o1 = new ArrayList<>();

    ArrayList<RosettaModelObjectBuilder> o2 = new ArrayList<>();
    o2.add(new BarBuilder());

    Function<Integer, RosettaModelObjectBuilder> o1GetOrCreateByIndex = mock(Function.class);
    when(o1GetOrCreateByIndex.apply(Mockito.<Integer>any())).thenReturn(new BarBuilder());

    // Act
    simpleMerger.mergeRosetta(o1, o2, o1GetOrCreateByIndex);

    // Assert
    verify(o1GetOrCreateByIndex).apply(0);
  }

  /**
   * Test {@link SimpleMerger#mergeRosetta(List, List, Function)} with {@code o1}, {@code o2},
   * {@code o1GetOrCreateByIndex}.
   *
   * <ul>
   *   <li>Given {@link BarBuilder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SimpleMerger#mergeRosetta(List, List, Function)}
   */
  @Test
  @DisplayName(
      "Test mergeRosetta(List, List, Function) with 'o1', 'o2', 'o1GetOrCreateByIndex'; given BarBuilder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleMerger.mergeRosetta(List, List, Function)"})
  void testMergeRosettaWithO1O2O1GetOrCreateByIndex_givenBarBuilder2() {
    // Arrange
    SimpleMerger simpleMerger = new SimpleMerger();
    ArrayList<RosettaModelObjectBuilder> o1 = new ArrayList<>();

    ArrayList<RosettaModelObjectBuilder> o2 = new ArrayList<>();
    o2.add(new BarBuilder());
    o2.add(new BarBuilder());

    Function<Integer, RosettaModelObjectBuilder> o1GetOrCreateByIndex = mock(Function.class);
    when(o1GetOrCreateByIndex.apply(Mockito.<Integer>any())).thenReturn(new BarBuilder());

    // Act
    simpleMerger.mergeRosetta(o1, o2, o1GetOrCreateByIndex);

    // Assert
    verify(o1GetOrCreateByIndex, atLeast(1)).apply(Mockito.<Integer>any());
  }

  /**
   * Test {@link SimpleMerger#mergeRosetta(List, List, Function)} with {@code o1}, {@code o2},
   * {@code o1GetOrCreateByIndex}.
   *
   * <ul>
   *   <li>Given {@link BarBuilder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SimpleMerger#mergeRosetta(List, List, Function)}
   */
  @Test
  @DisplayName(
      "Test mergeRosetta(List, List, Function) with 'o1', 'o2', 'o1GetOrCreateByIndex'; given BarBuilder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleMerger.mergeRosetta(List, List, Function)"})
  void testMergeRosettaWithO1O2O1GetOrCreateByIndex_givenBarBuilder3() {
    // Arrange
    SimpleMerger simpleMerger = new SimpleMerger();

    ArrayList<RosettaModelObjectBuilder> o1 = new ArrayList<>();
    o1.add(new BarBuilder());

    ArrayList<RosettaModelObjectBuilder> o2 = new ArrayList<>();
    o2.add(new BarBuilder());

    Function<Integer, RosettaModelObjectBuilder> o1GetOrCreateByIndex = mock(Function.class);
    when(o1GetOrCreateByIndex.apply(Mockito.<Integer>any())).thenReturn(new BarBuilder());

    // Act
    simpleMerger.mergeRosetta(o1, o2, o1GetOrCreateByIndex);

    // Assert
    verify(o1GetOrCreateByIndex).apply(0);
  }

  /**
   * Test {@link SimpleMerger#mergeRosetta(List, List, Function)} with {@code o1}, {@code o2},
   * {@code o1GetOrCreateByIndex}.
   *
   * <ul>
   *   <li>Given {@link BarBuilder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SimpleMerger#mergeRosetta(List, List, Function)}
   */
  @Test
  @DisplayName(
      "Test mergeRosetta(List, List, Function) with 'o1', 'o2', 'o1GetOrCreateByIndex'; given BarBuilder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleMerger.mergeRosetta(List, List, Function)"})
  void testMergeRosettaWithO1O2O1GetOrCreateByIndex_givenBarBuilder4() {
    // Arrange
    SimpleMerger simpleMerger = new SimpleMerger();

    ArrayList<RosettaModelObjectBuilder> o1 = new ArrayList<>();
    o1.add(new BarBuilder());
    o1.add(new BarBuilder());

    ArrayList<RosettaModelObjectBuilder> o2 = new ArrayList<>();
    o2.add(new BarBuilder());

    Function<Integer, RosettaModelObjectBuilder> o1GetOrCreateByIndex = mock(Function.class);
    when(o1GetOrCreateByIndex.apply(Mockito.<Integer>any())).thenReturn(new BarBuilder());

    // Act
    simpleMerger.mergeRosetta(o1, o2, o1GetOrCreateByIndex);

    // Assert
    verify(o1GetOrCreateByIndex).apply(0);
  }

  /**
   * Test {@link SimpleMerger#mergeRosetta(List, List, Function)} with {@code o1}, {@code o2},
   * {@code o1GetOrCreateByIndex}.
   *
   * <ul>
   *   <li>Given {@link BarBuilder} (default constructor) Num is one.
   * </ul>
   *
   * <p>Method under test: {@link SimpleMerger#mergeRosetta(List, List, Function)}
   */
  @Test
  @DisplayName(
      "Test mergeRosetta(List, List, Function) with 'o1', 'o2', 'o1GetOrCreateByIndex'; given BarBuilder (default constructor) Num is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleMerger.mergeRosetta(List, List, Function)"})
  void testMergeRosettaWithO1O2O1GetOrCreateByIndex_givenBarBuilderNumIsOne() {
    // Arrange
    SimpleMerger simpleMerger = new SimpleMerger();
    ArrayList<RosettaModelObjectBuilder> o1 = new ArrayList<>();

    BarBuilder barBuilder = new BarBuilder();
    barBuilder.setNum(1);

    ArrayList<RosettaModelObjectBuilder> o2 = new ArrayList<>();
    o2.add(barBuilder);

    BarBuilder barBuilder2 = new BarBuilder();
    barBuilder2.setNum(10);

    Function<Integer, RosettaModelObjectBuilder> o1GetOrCreateByIndex = mock(Function.class);
    when(o1GetOrCreateByIndex.apply(Mockito.<Integer>any())).thenReturn(barBuilder2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> simpleMerger.mergeRosetta(o1, o2, o1GetOrCreateByIndex));
    verify(o1GetOrCreateByIndex).apply(0);
  }

  /**
   * Test {@link SimpleMerger#mergeRosetta(List, List, Function)} with {@code o1}, {@code o2},
   * {@code o1GetOrCreateByIndex}.
   *
   * <ul>
   *   <li>Given {@link BarBuilder} (default constructor) Num is ten.
   * </ul>
   *
   * <p>Method under test: {@link SimpleMerger#mergeRosetta(List, List, Function)}
   */
  @Test
  @DisplayName(
      "Test mergeRosetta(List, List, Function) with 'o1', 'o2', 'o1GetOrCreateByIndex'; given BarBuilder (default constructor) Num is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleMerger.mergeRosetta(List, List, Function)"})
  void testMergeRosettaWithO1O2O1GetOrCreateByIndex_givenBarBuilderNumIsTen() {
    // Arrange
    SimpleMerger simpleMerger = new SimpleMerger();
    ArrayList<RosettaModelObjectBuilder> o1 = new ArrayList<>();

    ArrayList<RosettaModelObjectBuilder> o2 = new ArrayList<>();
    o2.add(new BarBuilder());

    BarBuilder barBuilder = new BarBuilder();
    barBuilder.setNum(10);

    Function<Integer, RosettaModelObjectBuilder> o1GetOrCreateByIndex = mock(Function.class);
    when(o1GetOrCreateByIndex.apply(Mockito.<Integer>any())).thenReturn(barBuilder);

    // Act
    simpleMerger.mergeRosetta(o1, o2, o1GetOrCreateByIndex);

    // Assert
    verify(o1GetOrCreateByIndex).apply(0);
  }

  /**
   * Test {@link SimpleMerger#mergeRosetta(List, List, Function)} with {@code o1}, {@code o2},
   * {@code o1GetOrCreateByIndex}.
   *
   * <ul>
   *   <li>Given {@link BarBuilder} (default constructor) Num is ten.
   * </ul>
   *
   * <p>Method under test: {@link SimpleMerger#mergeRosetta(List, List, Function)}
   */
  @Test
  @DisplayName(
      "Test mergeRosetta(List, List, Function) with 'o1', 'o2', 'o1GetOrCreateByIndex'; given BarBuilder (default constructor) Num is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleMerger.mergeRosetta(List, List, Function)"})
  void testMergeRosettaWithO1O2O1GetOrCreateByIndex_givenBarBuilderNumIsTen2() {
    // Arrange
    SimpleMerger simpleMerger = new SimpleMerger();
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
    simpleMerger.mergeRosetta(o1, o2, o1GetOrCreateByIndex);

    // Assert
    verify(o1GetOrCreateByIndex).apply(0);
  }

  /**
   * Test {@link SimpleMerger#mergeRosetta(List, List, Function)} with {@code o1}, {@code o2},
   * {@code o1GetOrCreateByIndex}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleMerger#mergeRosetta(List, List, Function)}
   */
  @Test
  @DisplayName(
      "Test mergeRosetta(List, List, Function) with 'o1', 'o2', 'o1GetOrCreateByIndex'; given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleMerger.mergeRosetta(List, List, Function)"})
  void testMergeRosettaWithO1O2O1GetOrCreateByIndex_givenIllegalArgumentException() {
    // Arrange
    SimpleMerger simpleMerger = new SimpleMerger();
    ArrayList<RosettaModelObjectBuilder> o1 = new ArrayList<>();

    ArrayList<RosettaModelObjectBuilder> o2 = new ArrayList<>();
    o2.add(new BarBuilder());

    Function<Integer, RosettaModelObjectBuilder> o1GetOrCreateByIndex = mock(Function.class);
    when(o1GetOrCreateByIndex.apply(Mockito.<Integer>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> simpleMerger.mergeRosetta(o1, o2, o1GetOrCreateByIndex));
    verify(o1GetOrCreateByIndex).apply(0);
  }

  /**
   * Test {@link SimpleMerger#mergeRosetta(List, List, Function)} with {@code o1}, {@code o2},
   * {@code o1GetOrCreateByIndex}.
   *
   * <ul>
   *   <li>Given {@link KeyBuilderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SimpleMerger#mergeRosetta(List, List, Function)}
   */
  @Test
  @DisplayName(
      "Test mergeRosetta(List, List, Function) with 'o1', 'o2', 'o1GetOrCreateByIndex'; given KeyBuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleMerger.mergeRosetta(List, List, Function)"})
  void testMergeRosettaWithO1O2O1GetOrCreateByIndex_givenKeyBuilderImpl() {
    // Arrange
    SimpleMerger simpleMerger = new SimpleMerger();
    ArrayList<RosettaModelObjectBuilder> o1 = new ArrayList<>();

    ArrayList<RosettaModelObjectBuilder> o2 = new ArrayList<>();
    o2.add(new KeyBuilderImpl());

    Function<Integer, RosettaModelObjectBuilder> o1GetOrCreateByIndex = mock(Function.class);
    when(o1GetOrCreateByIndex.apply(Mockito.<Integer>any())).thenReturn(new KeyBuilderImpl());

    // Act
    simpleMerger.mergeRosetta(o1, o2, o1GetOrCreateByIndex);

    // Assert
    verify(o1GetOrCreateByIndex).apply(0);
  }

  /**
   * Test {@link SimpleMerger#mergeRosetta(RosettaModelObjectBuilder, RosettaModelObjectBuilder,
   * Consumer)} with {@code o1}, {@code o2}, {@code o1Setter}.
   *
   * <ul>
   *   <li>Given {@link KeyBuilderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SimpleMerger#mergeRosetta(RosettaModelObjectBuilder,
   * RosettaModelObjectBuilder, Consumer)}
   */
  @Test
  @DisplayName(
      "Test mergeRosetta(RosettaModelObjectBuilder, RosettaModelObjectBuilder, Consumer) with 'o1', 'o2', 'o1Setter'; given KeyBuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleMerger.mergeRosetta(RosettaModelObjectBuilder, RosettaModelObjectBuilder, Consumer)"
  })
  void testMergeRosettaWithO1O2O1Setter_givenKeyBuilderImpl() {
    // Arrange
    SimpleMerger simpleMerger = new SimpleMerger();

    KeyBuilderImpl keyBuilderImpl = mock(KeyBuilderImpl.class);
    when(keyBuilderImpl.merge(
            Mockito.<RosettaModelObjectBuilder>any(), Mockito.<BuilderMerger>any()))
        .thenReturn(new KeyBuilderImpl());

    // Act
    simpleMerger.mergeRosetta(keyBuilderImpl, new BarBuilder(), mock(Consumer.class));

    // Assert
    verify(keyBuilderImpl).merge(isA(RosettaModelObjectBuilder.class), isA(BuilderMerger.class));
  }

  /**
   * Test {@link SimpleMerger#mergeRosetta(RosettaModelObjectBuilder, RosettaModelObjectBuilder,
   * Consumer)} with {@code o1}, {@code o2}, {@code o1Setter}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleMerger#mergeRosetta(RosettaModelObjectBuilder,
   * RosettaModelObjectBuilder, Consumer)}
   */
  @Test
  @DisplayName(
      "Test mergeRosetta(RosettaModelObjectBuilder, RosettaModelObjectBuilder, Consumer) with 'o1', 'o2', 'o1Setter'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleMerger.mergeRosetta(RosettaModelObjectBuilder, RosettaModelObjectBuilder, Consumer)"
  })
  void testMergeRosettaWithO1O2O1Setter_thenThrowIllegalArgumentException() {
    // Arrange
    SimpleMerger simpleMerger = new SimpleMerger();

    KeyBuilderImpl keyBuilderImpl = mock(KeyBuilderImpl.class);
    when(keyBuilderImpl.merge(
            Mockito.<RosettaModelObjectBuilder>any(), Mockito.<BuilderMerger>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> simpleMerger.mergeRosetta(keyBuilderImpl, new BarBuilder(), mock(Consumer.class)));
    verify(keyBuilderImpl).merge(isA(RosettaModelObjectBuilder.class), isA(BuilderMerger.class));
  }

  /**
   * Test {@link SimpleMerger#mergeBasic(List, List, Consumer)} with {@code o1}, {@code o2}, {@code
   * o1Add}.
   *
   * <ul>
   *   <li>Given {@link BeanPropertyWriter#MARKER_FOR_EMPTY}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleMerger#mergeBasic(List, List, Consumer)}
   */
  @Test
  @DisplayName(
      "Test mergeBasic(List, List, Consumer) with 'o1', 'o2', 'o1Add'; given MARKER_FOR_EMPTY; when ArrayList(); then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleMerger.mergeBasic(List, List, Consumer)"})
  void testMergeBasicWithO1O2O1Add_givenMarker_for_empty_whenArrayList_thenCallsAccept() {
    // Arrange
    SimpleMerger simpleMerger = new SimpleMerger();
    ArrayList<Object> o1 = new ArrayList<>();

    ArrayList<Object> o2 = new ArrayList<>();
    o2.add(BeanPropertyWriter.MARKER_FOR_EMPTY);
    o2.add(BeanPropertyWriter.MARKER_FOR_EMPTY);

    Consumer<Object> o1Add = mock(Consumer.class);
    doNothing().when(o1Add).accept(Mockito.<Object>any());

    // Act
    simpleMerger.mergeBasic(o1, o2, o1Add);

    // Assert
    verify(o1Add, atLeast(1)).accept(isA(Object.class));
  }

  /**
   * Test {@link SimpleMerger#mergeBasic(List, List, Consumer)} with {@code o1}, {@code o2}, {@code
   * o1Add}.
   *
   * <ul>
   *   <li>When {@link Consumer} {@link Consumer#accept(Object)} does nothing.
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleMerger#mergeBasic(List, List, Consumer)}
   */
  @Test
  @DisplayName(
      "Test mergeBasic(List, List, Consumer) with 'o1', 'o2', 'o1Add'; when Consumer accept(Object) does nothing; then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleMerger.mergeBasic(List, List, Consumer)"})
  void testMergeBasicWithO1O2O1Add_whenConsumerAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    SimpleMerger simpleMerger = new SimpleMerger();

    ArrayList<Object> o1 = new ArrayList<>();
    o1.add(BeanPropertyWriter.MARKER_FOR_EMPTY);

    ArrayList<Object> o2 = new ArrayList<>();
    o2.add(BeanPropertyWriter.MARKER_FOR_EMPTY);

    Consumer<Object> o1Add = mock(Consumer.class);
    doNothing().when(o1Add).accept(Mockito.<Object>any());

    // Act
    simpleMerger.mergeBasic(o1, o2, o1Add);

    // Assert
    verify(o1Add).accept(isA(Object.class));
  }

  /**
   * Test {@link SimpleMerger#mergeBasic(List, List, Consumer)} with {@code o1}, {@code o2}, {@code
   * o1Add}.
   *
   * <ul>
   *   <li>When {@link Consumer} {@link Consumer#accept(Object)} does nothing.
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleMerger#mergeBasic(List, List, Consumer)}
   */
  @Test
  @DisplayName(
      "Test mergeBasic(List, List, Consumer) with 'o1', 'o2', 'o1Add'; when Consumer accept(Object) does nothing; then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleMerger.mergeBasic(List, List, Consumer)"})
  void testMergeBasicWithO1O2O1Add_whenConsumerAcceptDoesNothing_thenCallsAccept2() {
    // Arrange
    SimpleMerger simpleMerger = new SimpleMerger();

    ArrayList<Object> o1 = new ArrayList<>();
    o1.add(BeanPropertyWriter.MARKER_FOR_EMPTY);
    o1.add(BeanPropertyWriter.MARKER_FOR_EMPTY);

    ArrayList<Object> o2 = new ArrayList<>();
    o2.add(BeanPropertyWriter.MARKER_FOR_EMPTY);

    Consumer<Object> o1Add = mock(Consumer.class);
    doNothing().when(o1Add).accept(Mockito.<Object>any());

    // Act
    simpleMerger.mergeBasic(o1, o2, o1Add);

    // Assert
    verify(o1Add).accept(isA(Object.class));
  }

  /**
   * Test {@link SimpleMerger#mergeBasic(Object, Object, Consumer, AttributeMeta[])} with {@code
   * o1}, {@code o2}, {@code o1Setter}, {@code metas}.
   *
   * <ul>
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleMerger#mergeBasic(Object, Object, Consumer,
   * AttributeMeta[])}
   */
  @Test
  @DisplayName(
      "Test mergeBasic(Object, Object, Consumer, AttributeMeta[]) with 'o1', 'o2', 'o1Setter', 'metas'; then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleMerger.mergeBasic(Object, Object, Consumer, AttributeMeta[])"})
  void testMergeBasicWithO1O2O1SetterMetas_thenCallsAccept() {
    // Arrange
    SimpleMerger simpleMerger = new SimpleMerger();

    Consumer<Object> o1Setter = mock(Consumer.class);
    doNothing().when(o1Setter).accept(Mockito.<Object>any());

    // Act
    simpleMerger.mergeBasic(
        BeanPropertyWriter.MARKER_FOR_EMPTY,
        BeanPropertyWriter.MARKER_FOR_EMPTY,
        o1Setter,
        AttributeMeta.META);

    // Assert
    verify(o1Setter).accept(isA(Object.class));
  }

  /**
   * Test {@link SimpleMerger#mergeBasic(Object, Object, Consumer, AttributeMeta[])} with {@code
   * o1}, {@code o2}, {@code o1Setter}, {@code metas}.
   *
   * <ul>
   *   <li>When {@code META} and {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleMerger#mergeBasic(Object, Object, Consumer,
   * AttributeMeta[])}
   */
  @Test
  @DisplayName(
      "Test mergeBasic(Object, Object, Consumer, AttributeMeta[]) with 'o1', 'o2', 'o1Setter', 'metas'; when 'META' and 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleMerger.mergeBasic(Object, Object, Consumer, AttributeMeta[])"})
  void testMergeBasicWithO1O2O1SetterMetas_whenMetaAndNull() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new SimpleMerger()
                .mergeBasic(
                    1,
                    BeanPropertyWriter.MARKER_FOR_EMPTY,
                    mock(Consumer.class),
                    AttributeMeta.META,
                    null));
  }

  /**
   * Test {@link SimpleMerger#mergeBasic(Object, Object, Consumer, AttributeMeta[])} with {@code
   * o1}, {@code o2}, {@code o1Setter}, {@code metas}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleMerger#mergeBasic(Object, Object, Consumer,
   * AttributeMeta[])}
   */
  @Test
  @DisplayName(
      "Test mergeBasic(Object, Object, Consumer, AttributeMeta[]) with 'o1', 'o2', 'o1Setter', 'metas'; when one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleMerger.mergeBasic(Object, Object, Consumer, AttributeMeta[])"})
  void testMergeBasicWithO1O2O1SetterMetas_whenOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new SimpleMerger()
                .mergeBasic(
                    1,
                    BeanPropertyWriter.MARKER_FOR_EMPTY,
                    mock(Consumer.class),
                    AttributeMeta.META));
  }

  /**
   * Test {@link SimpleMerger#mergeBasic(Object, Object, Consumer, AttributeMeta[])} with {@code
   * o1}, {@code o2}, {@code o1Setter}, {@code metas}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleMerger#mergeBasic(Object, Object, Consumer,
   * AttributeMeta[])}
   */
  @Test
  @DisplayName(
      "Test mergeBasic(Object, Object, Consumer, AttributeMeta[]) with 'o1', 'o2', 'o1Setter', 'metas'; when one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleMerger.mergeBasic(Object, Object, Consumer, AttributeMeta[])"})
  void testMergeBasicWithO1O2O1SetterMetas_whenOne_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new SimpleMerger()
                .mergeBasic(1, BeanPropertyWriter.MARKER_FOR_EMPTY, mock(Consumer.class)));
  }
}
