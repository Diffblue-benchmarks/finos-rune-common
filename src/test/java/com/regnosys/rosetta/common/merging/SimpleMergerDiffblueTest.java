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

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
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

public class SimpleMergerDiffblueTest {
  /**
   * Test {@link SimpleMerger#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}.
   * <ul>
   *   <li>Given {@link Consumer} {@link Consumer#accept(Object)} does nothing.</li>
   *   <li>When {@link BarBuilder} (default constructor).</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleMerger#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleMerger.run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)"})
  public void testRun_givenConsumerAcceptDoesNothing_whenBarBuilder_thenCallsAccept() {
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
   * <ul>
   *   <li>Given {@link Consumer} {@link Consumer#accept(Object)} does nothing.</li>
   *   <li>When {@link FooBuilder} (default constructor).</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleMerger#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleMerger.run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)"})
  public void testRun_givenConsumerAcceptDoesNothing_whenFooBuilder_thenCallsAccept() {
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
   * <ul>
   *   <li>Given {@link Consumer} {@link Consumer#accept(Object)} does nothing.</li>
   *   <li>When {@link KeyBuilderImpl} (default constructor).</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleMerger#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleMerger.run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)"})
  public void testRun_givenConsumerAcceptDoesNothing_whenKeyBuilderImpl_thenCallsAccept() {
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
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When {@link BarBuilder} (default constructor) Num is ten.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleMerger#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleMerger.run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)"})
  public void testRun_givenTen_whenBarBuilderNumIsTen_thenCallsAccept() {
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
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleMerger#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleMerger.run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)"})
  public void testRun_thenThrowIllegalArgumentException() {
    // Arrange
    Consumer<RosettaModelObjectBuilder> postProcessor = mock(Consumer.class);
    doThrow(new IllegalArgumentException("foo")).when(postProcessor).accept(Mockito.<RosettaModelObjectBuilder>any());
    SimpleMerger simpleMerger = new SimpleMerger(postProcessor);
    BarBuilder barBuilder = new BarBuilder();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> simpleMerger.run(barBuilder, new BarBuilder()));
    verify(postProcessor).accept(isA(RosettaModelObjectBuilder.class));
  }

  /**
   * Test {@link SimpleMerger#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}.
   * <ul>
   *   <li>When {@link PriceQuantityBuilderImpl} (default constructor).</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleMerger#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleMerger.run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)"})
  public void testRun_whenPriceQuantityBuilderImpl_thenCallsAccept() {
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
   * Test {@link SimpleMerger#mergeRosetta(List, List, Function)} with {@code o1}, {@code o2}, {@code o1GetOrCreateByIndex}.
   * <p>
   * Method under test: {@link SimpleMerger#mergeRosetta(List, List, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleMerger.mergeRosetta(List, List, Function)"})
  public void testMergeRosettaWithO1O2O1GetOrCreateByIndex() {
    // Arrange
    SimpleMerger simpleMerger = new SimpleMerger();
    ArrayList<RosettaModelObjectBuilder> o1 = new ArrayList<>();

    ArrayList<RosettaModelObjectBuilder> o2 = new ArrayList<>();
    o2.add(new BarBuilder());
    Function<Integer, RosettaModelObjectBuilder> o1GetOrCreateByIndex = mock(Function.class);
    when(o1GetOrCreateByIndex.apply(Mockito.<Integer>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> simpleMerger.mergeRosetta(o1, o2, o1GetOrCreateByIndex));
    verify(o1GetOrCreateByIndex).apply(eq(0));
  }

  /**
   * Test {@link SimpleMerger#mergeRosetta(List, List, Function)} with {@code o1}, {@code o2}, {@code o1GetOrCreateByIndex}.
   * <ul>
   *   <li>Given {@link BarBuilder} (default constructor) Num is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleMerger#mergeRosetta(List, List, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleMerger.mergeRosetta(List, List, Function)"})
  public void testMergeRosettaWithO1O2O1GetOrCreateByIndex_givenBarBuilderNumIsOne() {
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
    assertThrows(IllegalArgumentException.class, () -> simpleMerger.mergeRosetta(o1, o2, o1GetOrCreateByIndex));
    verify(o1GetOrCreateByIndex).apply(eq(0));
  }

  /**
   * Test {@link SimpleMerger#mergeRosetta(List, List, Function)} with {@code o1}, {@code o2}, {@code o1GetOrCreateByIndex}.
   * <ul>
   *   <li>Given {@link BarBuilder} (default constructor) Num is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleMerger#mergeRosetta(List, List, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleMerger.mergeRosetta(List, List, Function)"})
  public void testMergeRosettaWithO1O2O1GetOrCreateByIndex_givenBarBuilderNumIsTen() {
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
    verify(o1GetOrCreateByIndex).apply(eq(0));
  }

  /**
   * Test {@link SimpleMerger#mergeRosetta(List, List, Function)} with {@code o1}, {@code o2}, {@code o1GetOrCreateByIndex}.
   * <ul>
   *   <li>Given {@link BarBuilder} (default constructor) Num is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleMerger#mergeRosetta(List, List, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleMerger.mergeRosetta(List, List, Function)"})
  public void testMergeRosettaWithO1O2O1GetOrCreateByIndex_givenBarBuilderNumIsTen2() {
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
    verify(o1GetOrCreateByIndex).apply(eq(0));
  }

  /**
   * Test {@link SimpleMerger#mergeRosetta(List, List, Function)} with {@code o1}, {@code o2}, {@code o1GetOrCreateByIndex}.
   * <ul>
   *   <li>Given {@link KeyBuilderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleMerger#mergeRosetta(List, List, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleMerger.mergeRosetta(List, List, Function)"})
  public void testMergeRosettaWithO1O2O1GetOrCreateByIndex_givenKeyBuilderImpl() {
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
    verify(o1GetOrCreateByIndex).apply(eq(0));
  }

  /**
   * Test {@link SimpleMerger#mergeRosetta(List, List, Function)} with {@code o1}, {@code o2}, {@code o1GetOrCreateByIndex}.
   * <ul>
   *   <li>When {@link Function} {@link Function#apply(Object)} return {@link BarBuilder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleMerger#mergeRosetta(List, List, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleMerger.mergeRosetta(List, List, Function)"})
  public void testMergeRosettaWithO1O2O1GetOrCreateByIndex_whenFunctionApplyReturnBarBuilder() {
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
    verify(o1GetOrCreateByIndex).apply(eq(0));
  }

  /**
   * Test {@link SimpleMerger#mergeRosetta(List, List, Function)} with {@code o1}, {@code o2}, {@code o1GetOrCreateByIndex}.
   * <ul>
   *   <li>When {@link Function} {@link Function#apply(Object)} return {@link BarBuilder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleMerger#mergeRosetta(List, List, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleMerger.mergeRosetta(List, List, Function)"})
  public void testMergeRosettaWithO1O2O1GetOrCreateByIndex_whenFunctionApplyReturnBarBuilder2() {
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
   * Test {@link SimpleMerger#mergeRosetta(RosettaModelObjectBuilder, RosettaModelObjectBuilder, Consumer)} with {@code o1}, {@code o2}, {@code o1Setter}.
   * <p>
   * Method under test: {@link SimpleMerger#mergeRosetta(RosettaModelObjectBuilder, RosettaModelObjectBuilder, Consumer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleMerger.mergeRosetta(RosettaModelObjectBuilder, RosettaModelObjectBuilder, Consumer)"})
  public void testMergeRosettaWithO1O2O1Setter() {
    // Arrange
    SimpleMerger simpleMerger = new SimpleMerger();
    KeyBuilderImpl keyBuilderImpl = mock(KeyBuilderImpl.class);
    when(keyBuilderImpl.merge(Mockito.<RosettaModelObjectBuilder>any(), Mockito.<BuilderMerger>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> simpleMerger.mergeRosetta(keyBuilderImpl, new BarBuilder(), mock(Consumer.class)));
    verify(keyBuilderImpl).merge(isA(RosettaModelObjectBuilder.class), isA(BuilderMerger.class));
  }

  /**
   * Test {@link SimpleMerger#mergeRosetta(RosettaModelObjectBuilder, RosettaModelObjectBuilder, Consumer)} with {@code o1}, {@code o2}, {@code o1Setter}.
   * <ul>
   *   <li>Given {@link KeyBuilderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleMerger#mergeRosetta(RosettaModelObjectBuilder, RosettaModelObjectBuilder, Consumer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleMerger.mergeRosetta(RosettaModelObjectBuilder, RosettaModelObjectBuilder, Consumer)"})
  public void testMergeRosettaWithO1O2O1Setter_givenKeyBuilderImpl() {
    // Arrange
    SimpleMerger simpleMerger = new SimpleMerger();
    KeyBuilderImpl keyBuilderImpl = mock(KeyBuilderImpl.class);
    when(keyBuilderImpl.merge(Mockito.<RosettaModelObjectBuilder>any(), Mockito.<BuilderMerger>any()))
        .thenReturn(new KeyBuilderImpl());

    // Act
    simpleMerger.mergeRosetta(keyBuilderImpl, new BarBuilder(), mock(Consumer.class));

    // Assert
    verify(keyBuilderImpl).merge(isA(RosettaModelObjectBuilder.class), isA(BuilderMerger.class));
  }

  /**
   * Test {@link SimpleMerger#mergeRosetta(RosettaModelObjectBuilder, RosettaModelObjectBuilder, Consumer)} with {@code o1}, {@code o2}, {@code o1Setter}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link BarBuilder} (default constructor) Num is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleMerger#mergeRosetta(RosettaModelObjectBuilder, RosettaModelObjectBuilder, Consumer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleMerger.mergeRosetta(RosettaModelObjectBuilder, RosettaModelObjectBuilder, Consumer)"})
  public void testMergeRosettaWithO1O2O1Setter_givenOne_whenBarBuilderNumIsOne() {
    // Arrange
    SimpleMerger simpleMerger = new SimpleMerger();

    BarBuilder barBuilder = new BarBuilder();
    barBuilder.setNum(1);

    BarBuilder barBuilder2 = new BarBuilder();
    barBuilder2.setNum(10);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> simpleMerger.mergeRosetta(barBuilder, barBuilder2, mock(Consumer.class)));
  }

  /**
   * Test {@link SimpleMerger#mergeBasic(List, List, Consumer)} with {@code o1}, {@code o2}, {@code o1Add}.
   * <ul>
   *   <li>When {@link Consumer} {@link Consumer#accept(Object)} does nothing.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleMerger#mergeBasic(List, List, Consumer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleMerger.mergeBasic(List, List, Consumer)"})
  public void testMergeBasicWithO1O2O1Add_whenConsumerAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    SimpleMerger simpleMerger = new SimpleMerger();
    ArrayList<Object> o1 = new ArrayList<>();

    ArrayList<Object> o2 = new ArrayList<>();
    o2.add("42");
    Consumer<Object> o1Add = mock(Consumer.class);
    doNothing().when(o1Add).accept(Mockito.<Object>any());

    // Act
    simpleMerger.mergeBasic(o1, o2, o1Add);

    // Assert
    verify(o1Add).accept(isA(Object.class));
  }

  /**
   * Test {@link SimpleMerger#mergeBasic(List, List, Consumer)} with {@code o1}, {@code o2}, {@code o1Add}.
   * <ul>
   *   <li>When {@link Consumer} {@link Consumer#accept(Object)} does nothing.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleMerger#mergeBasic(List, List, Consumer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleMerger.mergeBasic(List, List, Consumer)"})
  public void testMergeBasicWithO1O2O1Add_whenConsumerAcceptDoesNothing_thenCallsAccept2() {
    // Arrange
    SimpleMerger simpleMerger = new SimpleMerger();
    ArrayList<Object> o1 = new ArrayList<>();

    ArrayList<Object> o2 = new ArrayList<>();
    o2.add("42");
    o2.add("42");
    Consumer<Object> o1Add = mock(Consumer.class);
    doNothing().when(o1Add).accept(Mockito.<Object>any());

    // Act
    simpleMerger.mergeBasic(o1, o2, o1Add);

    // Assert
    verify(o1Add, atLeast(1)).accept(isA(Object.class));
  }

  /**
   * Test {@link SimpleMerger#mergeBasic(Object, Object, Consumer, AttributeMeta[])} with {@code o1}, {@code o2}, {@code o1Setter}, {@code metas}.
   * <ul>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleMerger#mergeBasic(Object, Object, Consumer, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleMerger.mergeBasic(Object, Object, Consumer, AttributeMeta[])"})
  public void testMergeBasicWithO1O2O1SetterMetas_thenCallsAccept() {
    // Arrange
    SimpleMerger simpleMerger = new SimpleMerger();
    Consumer<Object> o1Setter = mock(Consumer.class);
    doNothing().when(o1Setter).accept(Mockito.<Object>any());

    // Act
    simpleMerger.mergeBasic("O2", "O2", o1Setter, AttributeMeta.META);

    // Assert
    verify(o1Setter).accept(isA(Object.class));
  }

  /**
   * Test {@link SimpleMerger#mergeBasic(Object, Object, Consumer, AttributeMeta[])} with {@code o1}, {@code o2}, {@code o1Setter}, {@code metas}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleMerger#mergeBasic(Object, Object, Consumer, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleMerger.mergeBasic(Object, Object, Consumer, AttributeMeta[])"})
  public void testMergeBasicWithO1O2O1SetterMetas_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new SimpleMerger()).mergeBasic(1, "O2", mock(Consumer.class)));
  }

  /**
   * Test {@link SimpleMerger#mergeBasic(Object, Object, Consumer, AttributeMeta[])} with {@code o1}, {@code o2}, {@code o1Setter}, {@code metas}.
   * <ul>
   *   <li>When {@code META} and {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleMerger#mergeBasic(Object, Object, Consumer, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleMerger.mergeBasic(Object, Object, Consumer, AttributeMeta[])"})
  public void testMergeBasicWithO1O2O1SetterMetas_whenMetaAndNull() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SimpleMerger()).mergeBasic(1, "O2", mock(Consumer.class), AttributeMeta.META, null));
  }

  /**
   * Test {@link SimpleMerger#mergeBasic(Object, Object, Consumer, AttributeMeta[])} with {@code o1}, {@code o2}, {@code o1Setter}, {@code metas}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleMerger#mergeBasic(Object, Object, Consumer, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleMerger.mergeBasic(Object, Object, Consumer, AttributeMeta[])"})
  public void testMergeBasicWithO1O2O1SetterMetas_whenNull_thenCallsAccept() {
    // Arrange
    SimpleMerger simpleMerger = new SimpleMerger();
    Consumer<Object> o1Setter = mock(Consumer.class);
    doNothing().when(o1Setter).accept(Mockito.<Object>any());

    // Act
    simpleMerger.mergeBasic(null, "O2", o1Setter, AttributeMeta.META);

    // Assert
    verify(o1Setter).accept(isA(Object.class));
  }

  /**
   * Test {@link SimpleMerger#mergeBasic(Object, Object, Consumer, AttributeMeta[])} with {@code o1}, {@code o2}, {@code o1Setter}, {@code metas}.
   * <ul>
   *   <li>When {@code O1}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleMerger#mergeBasic(Object, Object, Consumer, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleMerger.mergeBasic(Object, Object, Consumer, AttributeMeta[])"})
  public void testMergeBasicWithO1O2O1SetterMetas_whenO1_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SimpleMerger()).mergeBasic("O1", "O2", mock(Consumer.class), AttributeMeta.META));
  }
}
