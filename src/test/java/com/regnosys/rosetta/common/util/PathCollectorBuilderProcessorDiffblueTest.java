package com.regnosys.rosetta.common.util;

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
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.regnosys.rosetta.common.merger.BarBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.AttributeMeta;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.Test;

public class PathCollectorBuilderProcessorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link PathCollectorBuilderProcessor.PathReport}
   *   <li>{@link PathCollectorBuilderProcessor.PathReport#getCollectedPaths()}
   * </ul>
   */
  @Test
  public void testPathReportGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new PathCollectorBuilderProcessor.PathReport()).getCollectedPaths().isEmpty());
  }

  /**
   * Method under test:
   * {@link PathCollectorBuilderProcessor#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testProcessRosetta() {
    // Arrange
    PathCollectorBuilderProcessor pathCollectorBuilderProcessor = new PathCollectorBuilderProcessor();
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;
    BarBuilder barBuilder = new BarBuilder();

    // Act and Assert
    assertTrue(pathCollectorBuilderProcessor.processRosetta(path, rosettaType, barBuilder, new BarBuilder(),
        AttributeMeta.META));
  }

  /**
   * Method under test:
   * {@link PathCollectorBuilderProcessor#processRosetta(RosettaPath, Class, List, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testProcessRosetta2() {
    // Arrange
    PathCollectorBuilderProcessor pathCollectorBuilderProcessor = new PathCollectorBuilderProcessor();
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;
    ArrayList<RosettaModelObject> builders = new ArrayList<>();

    // Act and Assert
    assertTrue(pathCollectorBuilderProcessor.processRosetta(path, rosettaType, builders, new BarBuilder(),
        AttributeMeta.META));
  }

  /**
   * Method under test:
   * {@link PathCollectorBuilderProcessor#processRosetta(RosettaPath, Class, List, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testProcessRosetta3() {
    // Arrange
    PathCollectorBuilderProcessor pathCollectorBuilderProcessor = new PathCollectorBuilderProcessor();
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;

    ArrayList<RosettaModelObject> builders = new ArrayList<>();
    builders.add(new BarBuilder());

    // Act and Assert
    assertTrue(pathCollectorBuilderProcessor.processRosetta(path, rosettaType, builders, new BarBuilder(),
        AttributeMeta.META));
  }

  /**
   * Method under test:
   * {@link PathCollectorBuilderProcessor#processRosetta(RosettaPath, Class, List, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testProcessRosetta4() {
    // Arrange
    PathCollectorBuilderProcessor pathCollectorBuilderProcessor = new PathCollectorBuilderProcessor();
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;

    ArrayList<RosettaModelObject> builders = new ArrayList<>();
    builders.add(new BarBuilder());
    builders.add(new BarBuilder());

    // Act and Assert
    assertTrue(pathCollectorBuilderProcessor.processRosetta(path, rosettaType, builders, new BarBuilder(),
        AttributeMeta.META));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PathCollectorBuilderProcessor}
   */
  @Test
  public void testNewPathCollectorBuilderProcessor() {
    // Arrange, Act and Assert
    assertTrue((new PathCollectorBuilderProcessor()).report().getCollectedPaths().isEmpty());
  }

  /**
   * Method under test:
   * {@link PathCollectorBuilderProcessor#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testProcessBasic() {
    // Arrange
    PathCollectorBuilderProcessor pathCollectorBuilderProcessor = new PathCollectorBuilderProcessor();
    RosettaPath path = mock(RosettaPath.class);
    Class<Object> rosettaType = Object.class;

    // Act
    pathCollectorBuilderProcessor.processBasic(path, rosettaType, "Instance", new BarBuilder(), AttributeMeta.META);

    // Assert
    assertEquals(1, pathCollectorBuilderProcessor.report().getCollectedPaths().size());
  }

  /**
   * Method under test:
   * {@link PathCollectorBuilderProcessor#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testProcessBasic2() {
    // Arrange
    PathCollectorBuilderProcessor pathCollectorBuilderProcessor = new PathCollectorBuilderProcessor();
    RosettaPath path = mock(RosettaPath.class);
    Class<Object> rosettaType = Object.class;

    // Act
    pathCollectorBuilderProcessor.processBasic(path, rosettaType, (Object) null, new BarBuilder(), AttributeMeta.META);

    // Assert that nothing has changed
    assertTrue(pathCollectorBuilderProcessor.report().getCollectedPaths().isEmpty());
  }

  /**
   * Method under test:
   * {@link PathCollectorBuilderProcessor#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testProcessBasic3() {
    // Arrange
    PathCollectorBuilderProcessor pathCollectorBuilderProcessor = new PathCollectorBuilderProcessor();
    RosettaPath.NullPath path = new RosettaPath.NullPath();
    Class<Object> rosettaType = Object.class;

    // Act
    pathCollectorBuilderProcessor.processBasic(path, rosettaType, "Instance", new BarBuilder(), AttributeMeta.META);

    // Assert
    assertEquals(1, pathCollectorBuilderProcessor.report().getCollectedPaths().size());
  }

  /**
   * Method under test:
   * {@link PathCollectorBuilderProcessor#processBasic(RosettaPath, Class, Collection, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testProcessBasic4() {
    // Arrange
    PathCollectorBuilderProcessor pathCollectorBuilderProcessor = new PathCollectorBuilderProcessor();
    RosettaPath path = mock(RosettaPath.class);
    Class<Object> rosettaType = Object.class;
    ArrayList<Object> instance = new ArrayList<>();

    // Act
    pathCollectorBuilderProcessor.processBasic(path, rosettaType, (Collection<?>) instance, new BarBuilder(),
        AttributeMeta.META);

    // Assert that nothing has changed
    assertTrue(pathCollectorBuilderProcessor.report().getCollectedPaths().isEmpty());
  }

  /**
   * Method under test:
   * {@link PathCollectorBuilderProcessor#processBasic(RosettaPath, Class, Collection, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testProcessBasic5() {
    // Arrange
    PathCollectorBuilderProcessor pathCollectorBuilderProcessor = new PathCollectorBuilderProcessor();
    RosettaPath path = mock(RosettaPath.class);
    Class<Object> rosettaType = Object.class;

    // Act
    pathCollectorBuilderProcessor.processBasic(path, rosettaType, (Collection<?>) null, new BarBuilder(),
        AttributeMeta.META);

    // Assert that nothing has changed
    assertTrue(pathCollectorBuilderProcessor.report().getCollectedPaths().isEmpty());
  }

  /**
   * Method under test:
   * {@link PathCollectorBuilderProcessor#processBasic(RosettaPath, Class, Collection, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testProcessBasic6() {
    // Arrange
    PathCollectorBuilderProcessor pathCollectorBuilderProcessor = new PathCollectorBuilderProcessor();
    RosettaPath path = mock(RosettaPath.class);
    when(path.withIndex(anyInt())).thenReturn(mock(RosettaPath.class));
    Class<Object> rosettaType = Object.class;

    ArrayList<Object> instance = new ArrayList<>();
    instance.add("42");

    // Act
    pathCollectorBuilderProcessor.processBasic(path, rosettaType, (Collection<?>) instance, new BarBuilder(),
        AttributeMeta.META);

    // Assert
    verify(path).withIndex(eq(0));
    assertEquals(1, pathCollectorBuilderProcessor.report().getCollectedPaths().size());
  }

  /**
   * Method under test:
   * {@link PathCollectorBuilderProcessor#processBasic(RosettaPath, Class, Collection, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testProcessBasic7() {
    // Arrange
    PathCollectorBuilderProcessor pathCollectorBuilderProcessor = new PathCollectorBuilderProcessor();
    RosettaPath path = mock(RosettaPath.class);
    when(path.withIndex(anyInt())).thenReturn(mock(RosettaPath.class));
    Class<Object> rosettaType = Object.class;

    ArrayList<Object> instance = new ArrayList<>();
    instance.add("42");
    instance.add("42");

    // Act
    pathCollectorBuilderProcessor.processBasic(path, rosettaType, (Collection<?>) instance, new BarBuilder(),
        AttributeMeta.META);

    // Assert
    verify(path, atLeast(1)).withIndex(anyInt());
    assertEquals(1, pathCollectorBuilderProcessor.report().getCollectedPaths().size());
  }

  /**
   * Method under test: {@link PathCollectorBuilderProcessor#report()}
   */
  @Test
  public void testReport() {
    // Arrange, Act and Assert
    assertTrue((new PathCollectorBuilderProcessor()).report().getCollectedPaths().isEmpty());
  }
}
