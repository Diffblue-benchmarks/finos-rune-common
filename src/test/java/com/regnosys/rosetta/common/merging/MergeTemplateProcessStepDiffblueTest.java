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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import com.regnosys.rosetta.common.util.RosettaModelObjectSupplier;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.process.BuilderMerger;
import java.util.function.Consumer;
import org.junit.Test;

public class MergeTemplateProcessStepDiffblueTest {
  /**
   * Method under test: {@link MergeTemplateProcessStep#getPriority()}
   */
  @Test
  public void testGetPriority() {
    // Arrange, Act and Assert
    assertEquals(1,
        (new MergeTemplateProcessStep(new SimpleMerger(), mock(RosettaModelObjectSupplier.class), mock(Consumer.class)))
            .getPriority()
            .intValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link MergeTemplateProcessStep#MergeTemplateProcessStep(BuilderMerger, RosettaModelObjectSupplier, Consumer)}
   *   <li>{@link MergeTemplateProcessStep#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Merge Template Post Processor",
        (new MergeTemplateProcessStep(new SimpleMerger(), mock(RosettaModelObjectSupplier.class), mock(Consumer.class)))
            .getName());
  }
}
