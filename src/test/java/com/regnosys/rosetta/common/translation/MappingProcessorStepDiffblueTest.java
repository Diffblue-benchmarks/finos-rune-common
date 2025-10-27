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

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import org.junit.Test;

public class MappingProcessorStepDiffblueTest {
  /**
   * Method under test: {@link MappingProcessorStep#getPriority()}
   */
  @Test
  public void testGetPriority() {
    // Arrange
    ArrayList<MappingProcessor> mappingProcessors = new ArrayList<>();

    // Act and Assert
    assertEquals(1,
        (new MappingProcessorStep(mappingProcessors, new MappingContext(new HashMap<>()))).getPriority().intValue());
  }

  /**
   * Method under test: {@link MappingProcessorStep#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange
    ArrayList<MappingProcessor> mappingProcessors = new ArrayList<>();

    // Act and Assert
    assertEquals("Mapping Processor",
        (new MappingProcessorStep(mappingProcessors, new MappingContext(new HashMap<>()))).getName());
  }

  /**
   * Method under test:
   * {@link MappingProcessorStep#MappingProcessorStep(Collection, MappingContext)}
   */
  @Test
  public void testNewMappingProcessorStep() {
    // Arrange
    ArrayList<MappingProcessor> mappingProcessors = new ArrayList<>();

    // Act
    MappingProcessorStep actualMappingProcessorStep = new MappingProcessorStep(mappingProcessors,
        new MappingContext(new HashMap<>()));

    // Assert
    assertEquals("Mapping Processor", actualMappingProcessorStep.getName());
    assertEquals(1, actualMappingProcessorStep.getPriority().intValue());
  }

  /**
   * Method under test:
   * {@link MappingProcessorStep#MappingProcessorStep(Collection, MappingContext, int)}
   */
  @Test
  public void testNewMappingProcessorStep2() {
    // Arrange
    ArrayList<MappingProcessor> mappingProcessors = new ArrayList<>();

    // Act
    MappingProcessorStep actualMappingProcessorStep = new MappingProcessorStep(mappingProcessors,
        new MappingContext(new HashMap<>()), 10);

    // Assert
    assertEquals("Mapping Processor", actualMappingProcessorStep.getName());
    assertEquals(1, actualMappingProcessorStep.getPriority().intValue());
  }
}
