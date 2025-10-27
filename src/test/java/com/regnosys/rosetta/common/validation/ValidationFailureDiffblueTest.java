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

import static org.junit.Assert.assertEquals;
import com.rosetta.model.lib.validation.ValidationResult;
import org.junit.Test;

public class ValidationFailureDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ValidationFailure#ValidationFailure(ValidationResult.ValidationType, String, String, String)}
   *   <li>{@link ValidationFailure#getFailureReason()}
   *   <li>{@link ValidationFailure#getModelClassName()}
   *   <li>{@link ValidationFailure#getRuleName()}
   *   <li>{@link ValidationFailure#getValidationType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ValidationFailure actualValidationFailure = new ValidationFailure(ValidationResult.ValidationType.DATA_RULE,
        "Rule Name", "Just cause", "Model Class Name");
    String actualFailureReason = actualValidationFailure.getFailureReason();
    String actualModelClassName = actualValidationFailure.getModelClassName();
    String actualRuleName = actualValidationFailure.getRuleName();

    // Assert
    assertEquals("Just cause", actualFailureReason);
    assertEquals("Model Class Name", actualModelClassName);
    assertEquals("Rule Name", actualRuleName);
    assertEquals(ValidationResult.ValidationType.DATA_RULE, actualValidationFailure.getValidationType());
  }
}
