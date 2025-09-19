package com.regnosys.rosetta.common.transform;

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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.transform.PipelineModel.Serialisation;
import com.regnosys.rosetta.common.transform.PipelineModel.Serialisation.Format;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PipelineInfoDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PipelineInfo#PipelineInfo(String, Serialisation)}
   *   <li>{@link PipelineInfo#getSerialisation()}
   *   <li>{@link PipelineInfo#getUpstreamPipelineId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PipelineInfo.<init>(String, Serialisation)",
    "Serialisation PipelineInfo.getSerialisation()",
    "String PipelineInfo.getUpstreamPipelineId()"
  })
  void testGettersAndSetters() {
    // Arrange
    Serialisation serialisation = new Serialisation(Format.JSON, "Config Path");

    // Act
    PipelineInfo actualPipelineInfo = new PipelineInfo("42", serialisation);
    Serialisation actualSerialisation = actualPipelineInfo.getSerialisation();

    // Assert
    assertEquals("42", actualPipelineInfo.getUpstreamPipelineId());
    assertSame(serialisation, actualSerialisation);
  }

  /**
   * Test {@link PipelineInfo#equals(Object)}, and {@link PipelineInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PipelineInfo#equals(Object)}
   *   <li>{@link PipelineInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PipelineInfo.equals(Object)", "int PipelineInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PipelineInfo pipelineInfo =
        new PipelineInfo("42", new Serialisation(Format.JSON, "Config Path"));
    PipelineInfo pipelineInfo2 =
        new PipelineInfo("42", new Serialisation(Format.JSON, "Config Path"));

    // Act and Assert
    assertEquals(pipelineInfo, pipelineInfo2);
    assertEquals(pipelineInfo.hashCode(), pipelineInfo2.hashCode());
  }

  /**
   * Test {@link PipelineInfo#equals(Object)}, and {@link PipelineInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PipelineInfo#equals(Object)}
   *   <li>{@link PipelineInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PipelineInfo.equals(Object)", "int PipelineInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PipelineInfo pipelineInfo =
        new PipelineInfo("42", new Serialisation(Format.JSON, "Config Path"));

    // Act and Assert
    assertEquals(pipelineInfo, pipelineInfo);
    int expectedHashCodeResult = pipelineInfo.hashCode();
    assertEquals(expectedHashCodeResult, pipelineInfo.hashCode());
  }

  /**
   * Test {@link PipelineInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PipelineInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PipelineInfo.equals(Object)", "int PipelineInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PipelineInfo pipelineInfo =
        new PipelineInfo("Upstream Pipeline Id", new Serialisation(Format.JSON, "Config Path"));
    PipelineInfo pipelineInfo2 =
        new PipelineInfo("42", new Serialisation(Format.JSON, "Config Path"));

    // Act and Assert
    assertNotEquals(pipelineInfo, pipelineInfo2);
  }

  /**
   * Test {@link PipelineInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PipelineInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PipelineInfo.equals(Object)", "int PipelineInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PipelineInfo pipelineInfo =
        new PipelineInfo("42", new Serialisation(Format.XML, "Config Path"));
    PipelineInfo pipelineInfo2 =
        new PipelineInfo("42", new Serialisation(Format.JSON, "Config Path"));

    // Act and Assert
    assertNotEquals(pipelineInfo, pipelineInfo2);
  }

  /**
   * Test {@link PipelineInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PipelineInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PipelineInfo.equals(Object)", "int PipelineInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    PipelineInfo pipelineInfo =
        new PipelineInfo("42", new Serialisation(Format.JSON, "Config Path"));

    // Act and Assert
    assertNotEquals(pipelineInfo, null);
  }

  /**
   * Test {@link PipelineInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PipelineInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PipelineInfo.equals(Object)", "int PipelineInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    PipelineInfo pipelineInfo =
        new PipelineInfo("42", new Serialisation(Format.JSON, "Config Path"));

    // Act and Assert
    assertNotEquals(pipelineInfo, "Different type to PipelineInfo");
  }
}
