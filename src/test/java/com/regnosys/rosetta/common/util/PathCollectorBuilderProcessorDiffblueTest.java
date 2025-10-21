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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.merger.BarBuilder;
import com.regnosys.rosetta.common.util.PathCollectorBuilderProcessor.PathReport;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.path.RosettaPath.NullPath;
import com.rosetta.model.lib.process.AttributeMeta;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PathCollectorBuilderProcessorDiffblueTest {
  /**
   * Test PathReport getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PathReport}
   *   <li>{@link PathReport#getCollectedPaths()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PathReport.<init>()", "java.util.Map PathReport.getCollectedPaths()"})
  public void testPathReportGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new PathReport()).getCollectedPaths().isEmpty());
  }

  /**
   * Test {@link PathCollectorBuilderProcessor#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])} with {@code path}, {@code rosettaType}, {@code builder}, {@code parent}, {@code meta}.
   * <p>
   * Method under test: {@link PathCollectorBuilderProcessor#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean PathCollectorBuilderProcessor.processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])"})
  public void testProcessRosettaWithPathRosettaTypeBuilderParentMeta() {
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
   * Test {@link PathCollectorBuilderProcessor#processRosetta(RosettaPath, Class, List, RosettaModelObject, AttributeMeta[])} with {@code path}, {@code rosettaType}, {@code builders}, {@code parent}, {@code meta}.
   * <ul>
   *   <li>Given {@link BarBuilder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PathCollectorBuilderProcessor#processRosetta(RosettaPath, Class, List, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean PathCollectorBuilderProcessor.processRosetta(RosettaPath, Class, List, RosettaModelObject, AttributeMeta[])"})
  public void testProcessRosettaWithPathRosettaTypeBuildersParentMeta_givenBarBuilder() {
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
   * Test {@link PathCollectorBuilderProcessor#processRosetta(RosettaPath, Class, List, RosettaModelObject, AttributeMeta[])} with {@code path}, {@code rosettaType}, {@code builders}, {@code parent}, {@code meta}.
   * <ul>
   *   <li>Given {@link BarBuilder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PathCollectorBuilderProcessor#processRosetta(RosettaPath, Class, List, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean PathCollectorBuilderProcessor.processRosetta(RosettaPath, Class, List, RosettaModelObject, AttributeMeta[])"})
  public void testProcessRosettaWithPathRosettaTypeBuildersParentMeta_givenBarBuilder2() {
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
   * Test {@link PathCollectorBuilderProcessor#processRosetta(RosettaPath, Class, List, RosettaModelObject, AttributeMeta[])} with {@code path}, {@code rosettaType}, {@code builders}, {@code parent}, {@code meta}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PathCollectorBuilderProcessor#processRosetta(RosettaPath, Class, List, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean PathCollectorBuilderProcessor.processRosetta(RosettaPath, Class, List, RosettaModelObject, AttributeMeta[])"})
  public void testProcessRosettaWithPathRosettaTypeBuildersParentMeta_whenArrayList() {
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
   * Test {@link PathCollectorBuilderProcessor#processBasic(RosettaPath, Class, Collection, RosettaModelObject, AttributeMeta[])} with {@code RosettaPath}, {@code Class}, {@code Collection}, {@code RosettaModelObject}, {@code AttributeMeta[]}.
   * <p>
   * Method under test: {@link PathCollectorBuilderProcessor#processBasic(RosettaPath, Class, Collection, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void PathCollectorBuilderProcessor.processBasic(RosettaPath, Class, Collection, RosettaModelObject, AttributeMeta[])"})
  public void testProcessBasicWithRosettaPathClassCollectionRosettaModelObjectAttributeMeta() {
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
   * Test {@link PathCollectorBuilderProcessor#processBasic(RosettaPath, Class, Collection, RosettaModelObject, AttributeMeta[])} with {@code RosettaPath}, {@code Class}, {@code Collection}, {@code RosettaModelObject}, {@code AttributeMeta[]}.
   * <p>
   * Method under test: {@link PathCollectorBuilderProcessor#processBasic(RosettaPath, Class, Collection, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void PathCollectorBuilderProcessor.processBasic(RosettaPath, Class, Collection, RosettaModelObject, AttributeMeta[])"})
  public void testProcessBasicWithRosettaPathClassCollectionRosettaModelObjectAttributeMeta2() {
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
   * Test {@link PathCollectorBuilderProcessor#processBasic(RosettaPath, Class, Collection, RosettaModelObject, AttributeMeta[])} with {@code RosettaPath}, {@code Class}, {@code Collection}, {@code RosettaModelObject}, {@code AttributeMeta[]}.
   * <p>
   * Method under test: {@link PathCollectorBuilderProcessor#processBasic(RosettaPath, Class, Collection, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void PathCollectorBuilderProcessor.processBasic(RosettaPath, Class, Collection, RosettaModelObject, AttributeMeta[])"})
  public void testProcessBasicWithRosettaPathClassCollectionRosettaModelObjectAttributeMeta3() {
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
   * Test {@link PathCollectorBuilderProcessor#processBasic(RosettaPath, Class, Collection, RosettaModelObject, AttributeMeta[])} with {@code RosettaPath}, {@code Class}, {@code Collection}, {@code RosettaModelObject}, {@code AttributeMeta[]}.
   * <p>
   * Method under test: {@link PathCollectorBuilderProcessor#processBasic(RosettaPath, Class, Collection, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void PathCollectorBuilderProcessor.processBasic(RosettaPath, Class, Collection, RosettaModelObject, AttributeMeta[])"})
  public void testProcessBasicWithRosettaPathClassCollectionRosettaModelObjectAttributeMeta4() {
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
   * Test {@link PathCollectorBuilderProcessor#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])} with {@code RosettaPath}, {@code Class}, {@code Object}, {@code RosettaModelObject}, {@code AttributeMeta[]}.
   * <p>
   * Method under test: {@link PathCollectorBuilderProcessor#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void PathCollectorBuilderProcessor.processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])"})
  public void testProcessBasicWithRosettaPathClassObjectRosettaModelObjectAttributeMeta() {
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
   * Test {@link PathCollectorBuilderProcessor#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])} with {@code RosettaPath}, {@code Class}, {@code Object}, {@code RosettaModelObject}, {@code AttributeMeta[]}.
   * <p>
   * Method under test: {@link PathCollectorBuilderProcessor#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void PathCollectorBuilderProcessor.processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])"})
  public void testProcessBasicWithRosettaPathClassObjectRosettaModelObjectAttributeMeta2() {
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
   * Test {@link PathCollectorBuilderProcessor#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])} with {@code RosettaPath}, {@code Class}, {@code Object}, {@code RosettaModelObject}, {@code AttributeMeta[]}.
   * <p>
   * Method under test: {@link PathCollectorBuilderProcessor#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void PathCollectorBuilderProcessor.processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])"})
  public void testProcessBasicWithRosettaPathClassObjectRosettaModelObjectAttributeMeta3() {
    // Arrange
    PathCollectorBuilderProcessor pathCollectorBuilderProcessor = new PathCollectorBuilderProcessor();
    NullPath path = new NullPath();
    Class<Object> rosettaType = Object.class;

    // Act
    pathCollectorBuilderProcessor.processBasic(path, rosettaType, "Instance", new BarBuilder(), AttributeMeta.META);

    // Assert
    assertEquals(1, pathCollectorBuilderProcessor.report().getCollectedPaths().size());
  }

  /**
   * Test {@link PathCollectorBuilderProcessor#report()}.
   * <p>
   * Method under test: {@link PathCollectorBuilderProcessor#report()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PathReport PathCollectorBuilderProcessor.report()"})
  public void testReport() {
    // Arrange, Act and Assert
    assertTrue((new PathCollectorBuilderProcessor()).report().getCollectedPaths().isEmpty());
  }

  /**
   * Test new {@link PathCollectorBuilderProcessor} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link PathCollectorBuilderProcessor}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PathCollectorBuilderProcessor.<init>()"})
  public void testNewPathCollectorBuilderProcessor() {
    // Arrange, Act and Assert
    assertTrue((new PathCollectorBuilderProcessor()).report().getCollectedPaths().isEmpty());
  }
}
