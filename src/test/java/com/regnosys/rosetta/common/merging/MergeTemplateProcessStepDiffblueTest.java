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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.util.RosettaModelObjectSupplier;
import com.rosetta.model.lib.process.BuilderMerger;
import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MergeTemplateProcessStepDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MergeTemplateProcessStep#MergeTemplateProcessStep(BuilderMerger,
   *       RosettaModelObjectSupplier, Consumer)}
   *   <li>{@link MergeTemplateProcessStep#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MergeTemplateProcessStep.<init>(BuilderMerger, RosettaModelObjectSupplier, Consumer)",
    "java.lang.String MergeTemplateProcessStep.getName()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    MergeTemplateProcessStep actualMergeTemplateProcessStep =
        new MergeTemplateProcessStep(
            new SimpleMerger(), mock(RosettaModelObjectSupplier.class), mock(Consumer.class));

    // Assert
    assertEquals("Merge Template Post Processor", actualMergeTemplateProcessStep.getName());
  }

  /**
   * Test {@link MergeTemplateProcessStep#getPriority()}.
   *
   * <p>Method under test: {@link MergeTemplateProcessStep#getPriority()}
   */
  @Test
  @DisplayName("Test getPriority()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer MergeTemplateProcessStep.getPriority()"})
  void testGetPriority() {
    // Arrange
    MergeTemplateProcessStep mergeTemplateProcessStep =
        new MergeTemplateProcessStep(
            new SimpleMerger(), mock(RosettaModelObjectSupplier.class), mock(Consumer.class));

    // Act and Assert
    assertEquals(1, mergeTemplateProcessStep.getPriority().intValue());
  }
}
