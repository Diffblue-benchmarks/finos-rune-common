package com.regnosys.rosetta.common.testing;

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
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Test;

public class MappingCoverageDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MappingCoverage#equals(Object)}
   *   <li>{@link MappingCoverage#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MappingCoverage mappingCoverage = new MappingCoverage("Ingestion Environment", new HashMap<>(), 10.0d);
    MappingCoverage mappingCoverage2 = new MappingCoverage("Ingestion Environment", new HashMap<>(), 10.0d);

    // Act and Assert
    assertEquals(mappingCoverage, mappingCoverage2);
    int expectedHashCodeResult = mappingCoverage.hashCode();
    assertEquals(expectedHashCodeResult, mappingCoverage2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MappingCoverage#equals(Object)}
   *   <li>{@link MappingCoverage#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MappingCoverage mappingCoverage = new MappingCoverage("Ingestion Environment", new HashMap<>(), 10.0d);

    // Act and Assert
    assertEquals(mappingCoverage, mappingCoverage);
    int expectedHashCodeResult = mappingCoverage.hashCode();
    assertEquals(expectedHashCodeResult, mappingCoverage.hashCode());
  }

  /**
   * Method under test: {@link MappingCoverage#compareTo(MappingCoverage)}
   */
  @Test
  public void testCompareTo() {
    // Arrange
    MappingCoverage mappingCoverage = new MappingCoverage(MappingCoverage.ENV, new HashMap<>(), 10.0d);

    // Act and Assert
    assertEquals(28, mappingCoverage.compareTo(new MappingCoverage("Ingestion Environment", new HashMap<>(), 10.0d)));
  }

  /**
   * Method under test: {@link MappingCoverage#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MappingCoverage mappingCoverage = new MappingCoverage(null, new HashMap<>(), 10.0d);

    // Act and Assert
    assertNotEquals(mappingCoverage, new MappingCoverage("Ingestion Environment", new HashMap<>(), 10.0d));
  }

  /**
   * Method under test: {@link MappingCoverage#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashMap<String, String> schema = new HashMap<>();
    schema.put("foo", "foo");
    MappingCoverage mappingCoverage = new MappingCoverage("Ingestion Environment", schema, 10.0d);

    // Act and Assert
    assertNotEquals(mappingCoverage, new MappingCoverage("Ingestion Environment", new HashMap<>(), 10.0d));
  }

  /**
   * Method under test: {@link MappingCoverage#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashMap<String, String> schema = new HashMap<>();
    schema.computeIfPresent("foo", mock(BiFunction.class));
    schema.put("foo", "foo");
    MappingCoverage mappingCoverage = new MappingCoverage("Ingestion Environment", schema, 10.0d);

    // Act and Assert
    assertNotEquals(mappingCoverage, new MappingCoverage("Ingestion Environment", new HashMap<>(), 10.0d));
  }

  /**
   * Method under test: {@link MappingCoverage#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MappingCoverage mappingCoverage = new MappingCoverage("Ingestion Environment", new HashMap<>(), 0.5d);

    // Act and Assert
    assertNotEquals(mappingCoverage, new MappingCoverage("Ingestion Environment", new HashMap<>(), 10.0d));
  }

  /**
   * Method under test: {@link MappingCoverage#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MappingCoverage("Ingestion Environment", new HashMap<>(), 10.0d), null);
  }

  /**
   * Method under test: {@link MappingCoverage#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MappingCoverage("Ingestion Environment", new HashMap<>(), 10.0d),
        "Different type to MappingCoverage");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MappingCoverage#MappingCoverage(String, Map, double)}
   *   <li>{@link MappingCoverage#toString()}
   *   <li>{@link MappingCoverage#getIngestionEnvironment()}
   *   <li>{@link MappingCoverage#getMappingCoverage()}
   *   <li>{@link MappingCoverage#getSchema()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    HashMap<String, String> schema = new HashMap<>();

    // Act
    MappingCoverage actualMappingCoverage = new MappingCoverage("Ingestion Environment", schema, 10.0d);
    String actualToStringResult = actualMappingCoverage.toString();
    String actualIngestionEnvironment = actualMappingCoverage.getIngestionEnvironment();
    double actualMappingCoverage2 = actualMappingCoverage.getMappingCoverage();
    Map<String, String> actualSchema = actualMappingCoverage.getSchema();

    // Assert
    assertEquals("Ingestion Environment", actualIngestionEnvironment);
    assertEquals("MappingCoverage{ingestionEnvironment='Ingestion Environment', schema={}, mappingCoverage=10.0}",
        actualToStringResult);
    assertEquals(10.0d, actualMappingCoverage2, 0.0);
    assertTrue(actualSchema.isEmpty());
    assertSame(schema, actualSchema);
  }
}
