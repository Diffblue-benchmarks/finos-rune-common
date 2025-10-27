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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class PipelineInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PipelineInfo#equals(Object)}
   *   <li>{@link PipelineInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PipelineInfo pipelineInfo = new PipelineInfo("42",
        new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path"));
    PipelineInfo pipelineInfo2 = new PipelineInfo("42",
        new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path"));

    // Act and Assert
    assertEquals(pipelineInfo, pipelineInfo2);
    int expectedHashCodeResult = pipelineInfo.hashCode();
    assertEquals(expectedHashCodeResult, pipelineInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PipelineInfo#equals(Object)}
   *   <li>{@link PipelineInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PipelineInfo pipelineInfo = new PipelineInfo("42",
        new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path"));

    // Act and Assert
    assertEquals(pipelineInfo, pipelineInfo);
    int expectedHashCodeResult = pipelineInfo.hashCode();
    assertEquals(expectedHashCodeResult, pipelineInfo.hashCode());
  }

  /**
   * Method under test: {@link PipelineInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PipelineInfo pipelineInfo = new PipelineInfo("Upstream Pipeline Id",
        new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path"));

    // Act and Assert
    assertNotEquals(pipelineInfo, new PipelineInfo("42",
        new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path")));
  }

  /**
   * Method under test: {@link PipelineInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PipelineInfo pipelineInfo = new PipelineInfo("42",
        new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.XML, "Config Path"));

    // Act and Assert
    assertNotEquals(pipelineInfo, new PipelineInfo("42",
        new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path")));
  }

  /**
   * Method under test: {@link PipelineInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PipelineInfo pipelineInfo = new PipelineInfo("42", mock(PipelineModel.Serialisation.class));

    // Act and Assert
    assertNotEquals(pipelineInfo, new PipelineInfo("42",
        new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path")));
  }

  /**
   * Method under test: {@link PipelineInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new PipelineInfo("42", new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path")),
        null);
  }

  /**
   * Method under test: {@link PipelineInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new PipelineInfo("42", new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON, "Config Path")),
        "Different type to PipelineInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PipelineInfo#PipelineInfo(String, PipelineModel.Serialisation)}
   *   <li>{@link PipelineInfo#getSerialisation()}
   *   <li>{@link PipelineInfo#getUpstreamPipelineId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    PipelineModel.Serialisation serialisation = new PipelineModel.Serialisation(PipelineModel.Serialisation.Format.JSON,
        "Config Path");

    // Act
    PipelineInfo actualPipelineInfo = new PipelineInfo("42", serialisation);
    PipelineModel.Serialisation actualSerialisation = actualPipelineInfo.getSerialisation();

    // Assert
    assertEquals("42", actualPipelineInfo.getUpstreamPipelineId());
    assertSame(serialisation, actualSerialisation);
  }
}
