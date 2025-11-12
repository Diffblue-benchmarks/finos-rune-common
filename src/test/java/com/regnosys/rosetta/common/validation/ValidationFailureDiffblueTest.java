package com.regnosys.rosetta.common.validation;

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
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ValidationFailureDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ValidationFailure#ValidationFailure(ValidationType, String, String, String)}
   *   <li>{@link ValidationFailure#getFailureReason()}
   *   <li>{@link ValidationFailure#getModelClassName()}
   *   <li>{@link ValidationFailure#getRuleName()}
   *   <li>{@link ValidationFailure#getValidationType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidationFailure.<init>(ValidationType, String, String, String)",
    "String ValidationFailure.getFailureReason()",
    "String ValidationFailure.getModelClassName()",
    "String ValidationFailure.getRuleName()",
    "ValidationType ValidationFailure.getValidationType()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ValidationFailure actualValidationFailure =
        new ValidationFailure(
            ValidationType.DATA_RULE, "Rule Name", "Just cause", "Model Class Name");
    String actualFailureReason = actualValidationFailure.getFailureReason();
    String actualModelClassName = actualValidationFailure.getModelClassName();
    String actualRuleName = actualValidationFailure.getRuleName();

    // Assert
    assertEquals("Just cause", actualFailureReason);
    assertEquals("Model Class Name", actualModelClassName);
    assertEquals("Rule Name", actualRuleName);
    assertEquals(ValidationType.DATA_RULE, actualValidationFailure.getValidationType());
  }
}
