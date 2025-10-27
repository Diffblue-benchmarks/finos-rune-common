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
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ProjectionDataItemExpectationDiffblueTest {
  /**
   * Method under test:
   * {@link ProjectionDataItemExpectation#compareTo(ProjectionDataItemExpectation)}
   */
  @Test
  public void testCompareTo() {
    // Arrange
    ProjectionDataItemExpectation projectionDataItemExpectation = new ProjectionDataItemExpectation("Input File", "42",
        "Output File", 1, true, true);

    // Act and Assert
    assertEquals(0, projectionDataItemExpectation
        .compareTo(new ProjectionDataItemExpectation("Input File", "42", "Output File", 1, true, true)));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ProjectionDataItemExpectation#ProjectionDataItemExpectation(String, String, String, int, boolean, boolean)}
   *   <li>{@link ProjectionDataItemExpectation#setError(boolean)}
   *   <li>{@link ProjectionDataItemExpectation#setInputFile(String)}
   *   <li>{@link ProjectionDataItemExpectation#setKeyValueFile(String)}
   *   <li>{@link ProjectionDataItemExpectation#setOutputFile(String)}
   *   <li>{@link ProjectionDataItemExpectation#setValidXml(boolean)}
   *   <li>{@link ProjectionDataItemExpectation#setValidationFailures(int)}
   *   <li>{@link ProjectionDataItemExpectation#getInputFile()}
   *   <li>{@link ProjectionDataItemExpectation#getKeyValueFile()}
   *   <li>{@link ProjectionDataItemExpectation#getOutputFile()}
   *   <li>{@link ProjectionDataItemExpectation#getValidationFailures()}
   *   <li>{@link ProjectionDataItemExpectation#isError()}
   *   <li>{@link ProjectionDataItemExpectation#isValidXml()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ProjectionDataItemExpectation actualProjectionDataItemExpectation = new ProjectionDataItemExpectation("Input File",
        "42", "Output File", 1, true, true);
    actualProjectionDataItemExpectation.setError(true);
    actualProjectionDataItemExpectation.setInputFile("Input File");
    actualProjectionDataItemExpectation.setKeyValueFile("42");
    actualProjectionDataItemExpectation.setOutputFile("Output File");
    actualProjectionDataItemExpectation.setValidXml(true);
    actualProjectionDataItemExpectation.setValidationFailures(1);
    String actualInputFile = actualProjectionDataItemExpectation.getInputFile();
    String actualKeyValueFile = actualProjectionDataItemExpectation.getKeyValueFile();
    String actualOutputFile = actualProjectionDataItemExpectation.getOutputFile();
    int actualValidationFailures = actualProjectionDataItemExpectation.getValidationFailures();
    boolean actualIsErrorResult = actualProjectionDataItemExpectation.isError();

    // Assert that nothing has changed
    assertEquals("42", actualKeyValueFile);
    assertEquals("Input File", actualInputFile);
    assertEquals("Output File", actualOutputFile);
    assertEquals(1, actualValidationFailures);
    assertTrue(actualIsErrorResult);
    assertTrue(actualProjectionDataItemExpectation.isValidXml());
  }
}
