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

public class SimpleSplitterDiffblueTest {
  /**
   * Method under test:
   * {@link SimpleSplitter#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}
   */
  @Test
  public void testRun() {
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
   * Method under test:
   * {@link SimpleSplitter#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}
   */
  @Test
  public void testRun2() {
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
   * Method under test:
   * {@link SimpleSplitter#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}
   */
  @Test
  public void testRun3() {
    // Arrange
    Consumer<RosettaModelObjectBuilder> postProcessor = mock(Consumer.class);
    doNothing().when(postProcessor).accept(Mockito.<RosettaModelObjectBuilder>any());
    SimpleSplitter simpleSplitter = new SimpleSplitter(postProcessor);
    Key.KeyBuilderImpl keyBuilderImpl = new Key.KeyBuilderImpl();

    // Act
    simpleSplitter.run(keyBuilderImpl, new Key.KeyBuilderImpl());

    // Assert
    verify(postProcessor).accept(isA(RosettaModelObjectBuilder.class));
  }

  /**
   * Method under test:
   * {@link SimpleSplitter#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}
   */
  @Test
  public void testRun4() {
    // Arrange
    Consumer<RosettaModelObjectBuilder> postProcessor = mock(Consumer.class);
    doNothing().when(postProcessor).accept(Mockito.<RosettaModelObjectBuilder>any());
    SimpleSplitter simpleSplitter = new SimpleSplitter(postProcessor);
    PriceQuantity.PriceQuantityBuilderImpl priceQuantityBuilderImpl = new PriceQuantity.PriceQuantityBuilderImpl();

    // Act
    simpleSplitter.run(priceQuantityBuilderImpl, new PriceQuantity.PriceQuantityBuilderImpl());

    // Assert
    verify(postProcessor).accept(isA(RosettaModelObjectBuilder.class));
  }

  /**
   * Method under test:
   * {@link SimpleSplitter#run(RosettaModelObjectBuilder, RosettaModelObjectBuilder)}
   */
  @Test
  public void testRun5() {
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
   * Method under test:
   * {@link SimpleSplitter#mergeRosetta(RosettaModelObjectBuilder, RosettaModelObjectBuilder, Consumer)}
   */
  @Test
  public void testMergeRosetta() {
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
   * Method under test: {@link SimpleSplitter#mergeRosetta(List, List, Function)}
   */
  @Test
  public void testMergeRosetta2() {
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
   * Method under test: {@link SimpleSplitter#mergeRosetta(List, List, Function)}
   */
  @Test
  public void testMergeRosetta3() {
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
   * Method under test: {@link SimpleSplitter#mergeRosetta(List, List, Function)}
   */
  @Test
  public void testMergeRosetta4() {
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
   * Method under test: {@link SimpleSplitter#mergeRosetta(List, List, Function)}
   */
  @Test
  public void testMergeRosetta5() {
    // Arrange
    SimpleSplitter simpleSplitter = new SimpleSplitter();
    ArrayList<RosettaModelObjectBuilder> o1 = new ArrayList<>();

    ArrayList<RosettaModelObjectBuilder> o2 = new ArrayList<>();
    o2.add(new Key.KeyBuilderImpl());
    Function<Integer, RosettaModelObjectBuilder> o1GetOrCreateByIndex = mock(Function.class);
    when(o1GetOrCreateByIndex.apply(Mockito.<Integer>any())).thenReturn(new Key.KeyBuilderImpl());

    // Act
    simpleSplitter.mergeRosetta(o1, o2, o1GetOrCreateByIndex);

    // Assert
    verify(o1GetOrCreateByIndex).apply(eq(0));
  }

  /**
   * Method under test: {@link SimpleSplitter#mergeRosetta(List, List, Function)}
   */
  @Test
  public void testMergeRosetta6() {
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
   * Method under test:
   * {@link SimpleSplitter#mergeBasic(Object, Object, Consumer, AttributeMeta[])}
   */
  @Test
  public void testMergeBasic() {
    // Arrange
    SimpleSplitter simpleSplitter = new SimpleSplitter();
    Consumer<Object> setter = mock(Consumer.class);
    doNothing().when(setter).accept(Mockito.<Object>any());

    // Act
    simpleSplitter.mergeBasic("O1", "O2", setter, AttributeMeta.META);

    // Assert that nothing has changed
    verify(setter).accept(isNull());
  }
}
