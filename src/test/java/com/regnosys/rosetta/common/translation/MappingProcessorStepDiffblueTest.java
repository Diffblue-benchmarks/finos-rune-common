package com.regnosys.rosetta.common.translation;

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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MappingProcessorStepDiffblueTest {
  /**
   * Test {@link MappingProcessorStep#MappingProcessorStep(Collection, MappingContext)}.
   *
   * <ul>
   *   <li>Then return Name is {@code Mapping Processor}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorStep#MappingProcessorStep(Collection,
   * MappingContext)}
   */
  @Test
  @DisplayName(
      "Test new MappingProcessorStep(Collection, MappingContext); then return Name is 'Mapping Processor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MappingProcessorStep.<init>(Collection, MappingContext)"})
  void testNewMappingProcessorStep_thenReturnNameIsMappingProcessor() {
    // Arrange
    ArrayList<MappingProcessor> mappingProcessors = new ArrayList<>();

    // Act
    MappingProcessorStep actualMappingProcessorStep =
        new MappingProcessorStep(mappingProcessors, new MappingContext(new HashMap<>()));

    // Assert
    assertEquals("Mapping Processor", actualMappingProcessorStep.getName());
    assertEquals(1, actualMappingProcessorStep.getPriority().intValue());
  }

  /**
   * Test {@link MappingProcessorStep#MappingProcessorStep(Collection, MappingContext, int)}.
   *
   * <ul>
   *   <li>Then return Name is {@code Mapping Processor}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorStep#MappingProcessorStep(Collection,
   * MappingContext, int)}
   */
  @Test
  @DisplayName(
      "Test new MappingProcessorStep(Collection, MappingContext, int); then return Name is 'Mapping Processor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MappingProcessorStep.<init>(Collection, MappingContext, int)"})
  void testNewMappingProcessorStep_thenReturnNameIsMappingProcessor2() {
    // Arrange
    ArrayList<MappingProcessor> mappingProcessors = new ArrayList<>();

    // Act
    MappingProcessorStep actualMappingProcessorStep =
        new MappingProcessorStep(mappingProcessors, new MappingContext(new HashMap<>()), 10);

    // Assert
    assertEquals("Mapping Processor", actualMappingProcessorStep.getName());
    assertEquals(1, actualMappingProcessorStep.getPriority().intValue());
  }

  /**
   * Test {@link MappingProcessorStep#getPriority()}.
   *
   * <p>Method under test: {@link MappingProcessorStep#getPriority()}
   */
  @Test
  @DisplayName("Test getPriority()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer MappingProcessorStep.getPriority()"})
  void testGetPriority() {
    // Arrange
    ArrayList<MappingProcessor> mappingProcessors = new ArrayList<>();
    MappingProcessorStep mappingProcessorStep =
        new MappingProcessorStep(mappingProcessors, new MappingContext(new HashMap<>()));

    // Act and Assert
    assertEquals(1, mappingProcessorStep.getPriority().intValue());
  }

  /**
   * Test {@link MappingProcessorStep#getName()}.
   *
   * <p>Method under test: {@link MappingProcessorStep#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String MappingProcessorStep.getName()"})
  void testGetName() {
    // Arrange
    ArrayList<MappingProcessor> mappingProcessors = new ArrayList<>();
    MappingProcessorStep mappingProcessorStep =
        new MappingProcessorStep(mappingProcessors, new MappingContext(new HashMap<>()));

    // Act and Assert
    assertEquals("Mapping Processor", mappingProcessorStep.getName());
  }
}
