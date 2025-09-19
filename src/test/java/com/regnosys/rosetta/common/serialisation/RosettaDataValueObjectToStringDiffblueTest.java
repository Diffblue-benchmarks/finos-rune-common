package com.regnosys.rosetta.common.serialisation;

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
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import java.time.LocalDate;
import java.time.ZoneOffset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RosettaDataValueObjectToStringDiffblueTest {
  /**
   * Test {@link RosettaDataValueObjectToString#toValueString(Object)}.
   *
   * <ul>
   *   <li>Then return {@code 1970-01-01T00:00:00Z}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaDataValueObjectToString#toValueString(Object)}
   */
  @Test
  @DisplayName("Test toValueString(Object); then return '1970-01-01T00:00:00Z'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String RosettaDataValueObjectToString.toValueString(Object)"})
  void testToValueString_thenReturn19700101t000000z() {
    // Arrange, Act and Assert
    assertEquals(
        "1970-01-01T00:00:00Z",
        RosettaDataValueObjectToString.toValueString(
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC)));
  }

  /**
   * Test {@link RosettaDataValueObjectToString#toValueString(Object)}.
   *
   * <ul>
   *   <li>When {@link BeanPropertyWriter#MARKER_FOR_EMPTY}.
   *   <li>Then return {@code NON_EMPTY}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaDataValueObjectToString#toValueString(Object)}
   */
  @Test
  @DisplayName("Test toValueString(Object); when MARKER_FOR_EMPTY; then return 'NON_EMPTY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String RosettaDataValueObjectToString.toValueString(Object)"})
  void testToValueString_whenMarker_for_empty_thenReturnNonEmpty() {
    // Arrange, Act and Assert
    assertEquals(
        "NON_EMPTY",
        RosettaDataValueObjectToString.toValueString(BeanPropertyWriter.MARKER_FOR_EMPTY));
  }
}
