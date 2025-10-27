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
import com.regnosys.rosetta.common.merger.BarBuilder;
import com.regnosys.rosetta.common.merger.FooBuilder;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.PriceQuantity;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.meta.Key;
import com.rosetta.model.lib.process.AttributeMeta;
import com.rosetta.model.lib.process.BuilderMerger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import org.junit.Test;
import org.mockito.Mockito;

public class SimpleMergerDiffblueTest {
  /**
   * Method under test:
   * {@link SimpleMerger#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}
   */
  @Test
  public void testRun() {
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
   * Method under test:
   * {@link SimpleMerger#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}
   */
  @Test
  public void testRun2() {
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
   * Method under test:
   * {@link SimpleMerger#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}
   */
  @Test
  public void testRun3() {
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
   * Method under test:
   * {@link SimpleMerger#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}
   */
  @Test
  public void testRun4() {
    // Arrange
    Consumer<RosettaModelObjectBuilder> postProcessor = mock(Consumer.class);
    doNothing().when(postProcessor).accept(Mockito.<RosettaModelObjectBuilder>any());
    SimpleMerger simpleMerger = new SimpleMerger(postProcessor);
    Key.KeyBuilderImpl keyBuilderImpl = new Key.KeyBuilderImpl();

    // Act
    simpleMerger.run(keyBuilderImpl, new Key.KeyBuilderImpl());

    // Assert
    verify(postProcessor).accept(isA(RosettaModelObjectBuilder.class));
  }

  /**
   * Method under test:
   * {@link SimpleMerger#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}
   */
  @Test
  public void testRun5() {
    // Arrange
    Consumer<RosettaModelObjectBuilder> postProcessor = mock(Consumer.class);
    doNothing().when(postProcessor).accept(Mockito.<RosettaModelObjectBuilder>any());
    SimpleMerger simpleMerger = new SimpleMerger(postProcessor);
    PriceQuantity.PriceQuantityBuilderImpl priceQuantityBuilderImpl = new PriceQuantity.PriceQuantityBuilderImpl();

    // Act
    simpleMerger.run(priceQuantityBuilderImpl, new PriceQuantity.PriceQuantityBuilderImpl());

    // Assert
    verify(postProcessor).accept(isA(RosettaModelObjectBuilder.class));
  }

  /**
   * Method under test:
   * {@link SimpleMerger#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}
   */
  @Test
  public void testRun6() {
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
   * Method under test:
   * {@link SimpleMerger#mergeRosetta(RosettaModelObjectBuilder, RosettaModelObjectBuilder, Consumer)}
   */
  @Test
  public void testMergeRosetta() {
    // Arrange
    SimpleMerger simpleMerger = new SimpleMerger();
    Key.KeyBuilderImpl keyBuilderImpl = mock(Key.KeyBuilderImpl.class);
    when(keyBuilderImpl.merge(Mockito.<RosettaModelObjectBuilder>any(), Mockito.<BuilderMerger>any()))
        .thenReturn(new Key.KeyBuilderImpl());

    // Act
    simpleMerger.mergeRosetta(keyBuilderImpl, new BarBuilder(), mock(Consumer.class));

    // Assert that nothing has changed
    verify(keyBuilderImpl).merge(isA(RosettaModelObjectBuilder.class), isA(BuilderMerger.class));
  }

  /**
   * Method under test:
   * {@link SimpleMerger#mergeRosetta(RosettaModelObjectBuilder, RosettaModelObjectBuilder, Consumer)}
   */
  @Test
  public void testMergeRosetta2() {
    // Arrange
    SimpleMerger simpleMerger = new SimpleMerger();
    Key.KeyBuilderImpl keyBuilderImpl = mock(Key.KeyBuilderImpl.class);
    when(keyBuilderImpl.merge(Mockito.<RosettaModelObjectBuilder>any(), Mockito.<BuilderMerger>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> simpleMerger.mergeRosetta(keyBuilderImpl, new BarBuilder(), mock(Consumer.class)));
    verify(keyBuilderImpl).merge(isA(RosettaModelObjectBuilder.class), isA(BuilderMerger.class));
  }

  /**
   * Method under test:
   * {@link SimpleMerger#mergeRosetta(RosettaModelObjectBuilder, RosettaModelObjectBuilder, Consumer)}
   */
  @Test
  public void testMergeRosetta3() {
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
   * Method under test: {@link SimpleMerger#mergeRosetta(List, List, Function)}
   */
  @Test
  public void testMergeRosetta4() {
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
   * Method under test: {@link SimpleMerger#mergeRosetta(List, List, Function)}
   */
  @Test
  public void testMergeRosetta5() {
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
   * Method under test: {@link SimpleMerger#mergeRosetta(List, List, Function)}
   */
  @Test
  public void testMergeRosetta6() {
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
   * Method under test: {@link SimpleMerger#mergeRosetta(List, List, Function)}
   */
  @Test
  public void testMergeRosetta7() {
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
   * Method under test: {@link SimpleMerger#mergeRosetta(List, List, Function)}
   */
  @Test
  public void testMergeRosetta8() {
    // Arrange
    SimpleMerger simpleMerger = new SimpleMerger();
    ArrayList<RosettaModelObjectBuilder> o1 = new ArrayList<>();

    ArrayList<RosettaModelObjectBuilder> o2 = new ArrayList<>();
    o2.add(new Key.KeyBuilderImpl());
    Function<Integer, RosettaModelObjectBuilder> o1GetOrCreateByIndex = mock(Function.class);
    when(o1GetOrCreateByIndex.apply(Mockito.<Integer>any())).thenReturn(new Key.KeyBuilderImpl());

    // Act
    simpleMerger.mergeRosetta(o1, o2, o1GetOrCreateByIndex);

    // Assert
    verify(o1GetOrCreateByIndex).apply(eq(0));
  }

  /**
   * Method under test: {@link SimpleMerger#mergeRosetta(List, List, Function)}
   */
  @Test
  public void testMergeRosetta9() {
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
   * Method under test: {@link SimpleMerger#mergeRosetta(List, List, Function)}
   */
  @Test
  public void testMergeRosetta10() {
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
   * Method under test:
   * {@link SimpleMerger#mergeBasic(Object, Object, Consumer, AttributeMeta[])}
   */
  @Test
  public void testMergeBasic() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SimpleMerger()).mergeBasic("O1", "O2", mock(Consumer.class), AttributeMeta.META));
    assertThrows(IllegalArgumentException.class, () -> (new SimpleMerger()).mergeBasic(1, "O2", mock(Consumer.class)));
    assertThrows(IllegalArgumentException.class,
        () -> (new SimpleMerger()).mergeBasic(1, "O2", mock(Consumer.class), AttributeMeta.META, null));
  }

  /**
   * Method under test:
   * {@link SimpleMerger#mergeBasic(Object, Object, Consumer, AttributeMeta[])}
   */
  @Test
  public void testMergeBasic2() {
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
   * Method under test:
   * {@link SimpleMerger#mergeBasic(Object, Object, Consumer, AttributeMeta[])}
   */
  @Test
  public void testMergeBasic3() {
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
   * Method under test: {@link SimpleMerger#mergeBasic(List, List, Consumer)}
   */
  @Test
  public void testMergeBasic4() {
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
   * Method under test: {@link SimpleMerger#mergeBasic(List, List, Consumer)}
   */
  @Test
  public void testMergeBasic5() {
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
}
