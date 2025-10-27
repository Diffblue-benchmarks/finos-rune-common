package com.regnosys.rosetta.common.projection;

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
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ProjectionDataSetExpectationDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ProjectionDataSetExpectation#ProjectionDataSetExpectation(String, String, List)}
   *   <li>{@link ProjectionDataSetExpectation#getDataItemExpectations()}
   *   <li>{@link ProjectionDataSetExpectation#getDataSetName()}
   *   <li>{@link ProjectionDataSetExpectation#getProjectionName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ArrayList<ProjectionDataItemExpectation> dataItemExpectations = new ArrayList<>();

    // Act
    ProjectionDataSetExpectation actualProjectionDataSetExpectation = new ProjectionDataSetExpectation(
        "Projection Name", "Data Set Name", dataItemExpectations);
    List<ProjectionDataItemExpectation> actualDataItemExpectations = actualProjectionDataSetExpectation
        .getDataItemExpectations();
    String actualDataSetName = actualProjectionDataSetExpectation.getDataSetName();

    // Assert
    assertEquals("Data Set Name", actualDataSetName);
    assertEquals("Projection Name", actualProjectionDataSetExpectation.getProjectionName());
    assertTrue(actualDataItemExpectations.isEmpty());
    assertSame(dataItemExpectations, actualDataItemExpectations);
  }
}
