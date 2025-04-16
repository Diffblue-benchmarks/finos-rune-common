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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.hashing.NonNullHashCollector;
import com.regnosys.rosetta.common.merger.BarBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.AttributeMeta;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SimpleProcessorDiffblueTest {
  /**
   * Test {@link SimpleProcessor#processRosetta(RosettaPath, Class, List, RosettaModelObject, AttributeMeta[])} with {@code RosettaPath}, {@code Class}, {@code List}, {@code RosettaModelObject}, {@code AttributeMeta[]}.
   * <p>
   * Method under test: {@link SimpleProcessor#processRosetta(RosettaPath, Class, List, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean SimpleProcessor.processRosetta(RosettaPath, Class, List, RosettaModelObject, AttributeMeta[])"})
  public void testProcessRosettaWithRosettaPathClassListRosettaModelObjectAttributeMeta() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;
    ArrayList<RosettaModelObject> instances = new ArrayList<>();

    // Act and Assert
    assertTrue(nonNullHashCollector.processRosetta(path, rosettaType, instances, new BarBuilder(), AttributeMeta.META));
  }

  /**
   * Test {@link SimpleProcessor#processRosetta(RosettaPath, Class, List, RosettaModelObject, AttributeMeta[])} with {@code RosettaPath}, {@code Class}, {@code List}, {@code RosettaModelObject}, {@code AttributeMeta[]}.
   * <p>
   * Method under test: {@link SimpleProcessor#processRosetta(RosettaPath, Class, List, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean SimpleProcessor.processRosetta(RosettaPath, Class, List, RosettaModelObject, AttributeMeta[])"})
  public void testProcessRosettaWithRosettaPathClassListRosettaModelObjectAttributeMeta2() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;

    // Act and Assert
    assertFalse(nonNullHashCollector.processRosetta(path, rosettaType, (List<? extends RosettaModelObject>) null,
        new BarBuilder(), AttributeMeta.META));
  }
}
