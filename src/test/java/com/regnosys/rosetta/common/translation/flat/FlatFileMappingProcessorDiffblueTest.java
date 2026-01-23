package com.regnosys.rosetta.common.translation.flat;

/*-
 * ==============
 * Rune Common
 * ==============
 * Copyright (C) 2018 - 2026 REGnosys
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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.regnosys.rosetta.common.translation.Path;
import com.regnosys.rosetta.common.translation.flat.FlatFileMappingProcessor.PathValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FlatFileMappingProcessorDiffblueTest {
  /**
   * Test PathValue getters and setters.
   *
   * <ul>
   *   <li>When {@link FlatFileMappingProcessor#BASE_PATH}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PathValue#PathValue(Path, Object)}
   *   <li>{@link PathValue#getModelPath()}
   *   <li>{@link PathValue#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test PathValue getters and setters; when BASE_PATH")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PathValue.<init>(Path, Object)",
    "void PathValue.<init>(Path, Object, boolean)",
    "Path PathValue.getModelPath()",
    "Object PathValue.getValue()"
  })
  void testPathValueGettersAndSetters_whenBase_path() {
    // Arrange
    Path modelPath = FlatFileMappingProcessor.BASE_PATH;
    Object object = BeanPropertyWriter.MARKER_FOR_EMPTY;

    // Act
    PathValue<Object> actualPathValue = new PathValue<>(modelPath, object);
    Path actualModelPath = actualPathValue.getModelPath();
    Object actualValue = actualPathValue.getValue();

    // Assert
    assertTrue(actualValue instanceof Include);
    assertEquals(Include.NON_EMPTY, actualValue);
    assertSame(object, actualValue);
    assertSame(modelPath, actualModelPath);
  }

  /**
   * Test PathValue getters and setters.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PathValue#PathValue(Path, Object, boolean)}
   *   <li>{@link PathValue#getModelPath()}
   *   <li>{@link PathValue#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test PathValue getters and setters; when 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PathValue.<init>(Path, Object)",
    "void PathValue.<init>(Path, Object, boolean)",
    "Path PathValue.getModelPath()",
    "Object PathValue.getValue()"
  })
  void testPathValueGettersAndSetters_whenTrue() {
    // Arrange
    Path modelPath = FlatFileMappingProcessor.BASE_PATH;
    Object object = BeanPropertyWriter.MARKER_FOR_EMPTY;

    // Act
    PathValue<Object> actualPathValue = new PathValue<>(modelPath, object, true);
    Path actualModelPath = actualPathValue.getModelPath();
    Object actualValue = actualPathValue.getValue();

    // Assert
    assertTrue(actualValue instanceof Include);
    assertEquals(Include.NON_EMPTY, actualValue);
    assertSame(object, actualValue);
    assertSame(modelPath, actualModelPath);
  }
}
