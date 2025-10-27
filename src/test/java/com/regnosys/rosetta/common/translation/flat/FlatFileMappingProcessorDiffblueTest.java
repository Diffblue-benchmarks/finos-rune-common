package com.regnosys.rosetta.common.translation.flat;

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
import static org.junit.Assert.assertSame;
import com.regnosys.rosetta.common.translation.Path;
import org.junit.Test;

public class FlatFileMappingProcessorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FlatFileMappingProcessor.PathValue#PathValue(Path, Object)}
   *   <li>{@link FlatFileMappingProcessor.PathValue#getModelPath()}
   *   <li>{@link FlatFileMappingProcessor.PathValue#getValue()}
   * </ul>
   */
  @Test
  public void testPathValueGettersAndSetters() {
    // Arrange
    Path modelPath = FlatFileMappingProcessor.BASE_PATH;

    // Act
    FlatFileMappingProcessor.PathValue<Object> actualPathValue = new FlatFileMappingProcessor.PathValue<>(modelPath,
        "Value");
    Path actualModelPath = actualPathValue.getModelPath();

    // Assert
    assertEquals("Value", actualPathValue.getValue());
    assertSame(modelPath, actualModelPath);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link FlatFileMappingProcessor.PathValue#PathValue(Path, Object, boolean)}
   *   <li>{@link FlatFileMappingProcessor.PathValue#getModelPath()}
   *   <li>{@link FlatFileMappingProcessor.PathValue#getValue()}
   * </ul>
   */
  @Test
  public void testPathValueGettersAndSetters2() {
    // Arrange
    Path modelPath = FlatFileMappingProcessor.BASE_PATH;

    // Act
    FlatFileMappingProcessor.PathValue<Object> actualPathValue = new FlatFileMappingProcessor.PathValue<>(modelPath,
        "Value", true);
    Path actualModelPath = actualPathValue.getModelPath();

    // Assert
    assertEquals("Value", actualPathValue.getValue());
    assertSame(modelPath, actualModelPath);
  }
}
