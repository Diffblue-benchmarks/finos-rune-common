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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.translation.Path;
import com.regnosys.rosetta.common.translation.flat.FlatFileMappingProcessor.PathValue;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FlatFileMappingProcessorDiffblueTest {
  /**
   * Test PathValue getters and setters.
   * <ul>
   *   <li>When {@link FlatFileMappingProcessor#BASE_PATH}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PathValue#PathValue(Path, Object)}
   *   <li>{@link PathValue#getModelPath()}
   *   <li>{@link PathValue#getValue()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PathValue.<init>(Path, Object)", "void PathValue.<init>(Path, Object, boolean)",
      "Path PathValue.getModelPath()", "Object PathValue.getValue()"})
  public void testPathValueGettersAndSetters_whenBase_path() {
    // Arrange
    Path modelPath = FlatFileMappingProcessor.BASE_PATH;

    // Act
    PathValue<Object> actualPathValue = new PathValue<>(modelPath, "Value");
    Path actualModelPath = actualPathValue.getModelPath();

    // Assert
    assertEquals("Value", actualPathValue.getValue());
    assertSame(modelPath, actualModelPath);
  }

  /**
   * Test PathValue getters and setters.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PathValue#PathValue(Path, Object, boolean)}
   *   <li>{@link PathValue#getModelPath()}
   *   <li>{@link PathValue#getValue()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PathValue.<init>(Path, Object)", "void PathValue.<init>(Path, Object, boolean)",
      "Path PathValue.getModelPath()", "Object PathValue.getValue()"})
  public void testPathValueGettersAndSetters_whenTrue() {
    // Arrange
    Path modelPath = FlatFileMappingProcessor.BASE_PATH;

    // Act
    PathValue<Object> actualPathValue = new PathValue<>(modelPath, "Value", true);
    Path actualModelPath = actualPathValue.getModelPath();

    // Assert
    assertEquals("Value", actualPathValue.getValue());
    assertSame(modelPath, actualModelPath);
  }
}
