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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MappingCoverageDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MappingCoverage#MappingCoverage(String, Map, double)}
   *   <li>{@link MappingCoverage#toString()}
   *   <li>{@link MappingCoverage#getIngestionEnvironment()}
   *   <li>{@link MappingCoverage#getMappingCoverage()}
   *   <li>{@link MappingCoverage#getSchema()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MappingCoverage.<init>(String, Map, double)",
    "String MappingCoverage.getIngestionEnvironment()",
    "double MappingCoverage.getMappingCoverage()",
    "Map MappingCoverage.getSchema()",
    "String MappingCoverage.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    HashMap<String, String> schema = new HashMap<>();

    // Act
    MappingCoverage actualMappingCoverage =
        new MappingCoverage("Ingestion Environment", schema, 10.0d);
    String actualToStringResult = actualMappingCoverage.toString();
    String actualIngestionEnvironment = actualMappingCoverage.getIngestionEnvironment();
    double actualMappingCoverage2 = actualMappingCoverage.getMappingCoverage();
    Map<String, String> actualSchema = actualMappingCoverage.getSchema();

    // Assert
    assertEquals("Ingestion Environment", actualIngestionEnvironment);
    assertEquals(
        "MappingCoverage{ingestionEnvironment='Ingestion Environment', schema={}, mappingCoverage=10.0}",
        actualToStringResult);
    assertEquals(10.0d, actualMappingCoverage2);
    assertTrue(actualSchema.isEmpty());
    assertSame(schema, actualSchema);
  }

  /**
   * Test {@link MappingCoverage#equals(Object)}, and {@link MappingCoverage#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MappingCoverage#equals(Object)}
   *   <li>{@link MappingCoverage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MappingCoverage.equals(Object)", "int MappingCoverage.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MappingCoverage mappingCoverage =
        new MappingCoverage("Ingestion Environment", new HashMap<>(), 10.0d);
    MappingCoverage mappingCoverage2 =
        new MappingCoverage("Ingestion Environment", new HashMap<>(), 10.0d);

    // Act and Assert
    assertEquals(mappingCoverage, mappingCoverage2);
    assertEquals(mappingCoverage.hashCode(), mappingCoverage2.hashCode());
  }

  /**
   * Test {@link MappingCoverage#equals(Object)}, and {@link MappingCoverage#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MappingCoverage#equals(Object)}
   *   <li>{@link MappingCoverage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MappingCoverage.equals(Object)", "int MappingCoverage.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MappingCoverage mappingCoverage =
        new MappingCoverage("Ingestion Environment", new HashMap<>(), 10.0d);

    // Act and Assert
    assertEquals(mappingCoverage, mappingCoverage);
    int expectedHashCodeResult = mappingCoverage.hashCode();
    assertEquals(expectedHashCodeResult, mappingCoverage.hashCode());
  }

  /**
   * Test {@link MappingCoverage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MappingCoverage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MappingCoverage.equals(Object)", "int MappingCoverage.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MappingCoverage mappingCoverage = new MappingCoverage(null, new HashMap<>(), 10.0d);

    // Act and Assert
    assertNotEquals(
        mappingCoverage, new MappingCoverage("Ingestion Environment", new HashMap<>(), 10.0d));
  }

  /**
   * Test {@link MappingCoverage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MappingCoverage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MappingCoverage.equals(Object)", "int MappingCoverage.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashMap<String, String> schema = new HashMap<>();
    schema.put("Key", "42");
    MappingCoverage mappingCoverage = new MappingCoverage("Ingestion Environment", schema, 10.0d);

    // Act and Assert
    assertNotEquals(
        mappingCoverage, new MappingCoverage("Ingestion Environment", new HashMap<>(), 10.0d));
  }

  /**
   * Test {@link MappingCoverage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MappingCoverage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MappingCoverage.equals(Object)", "int MappingCoverage.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MappingCoverage mappingCoverage =
        new MappingCoverage("Ingestion Environment", new HashMap<>(), 0.5d);

    // Act and Assert
    assertNotEquals(
        mappingCoverage, new MappingCoverage("Ingestion Environment", new HashMap<>(), 10.0d));
  }

  /**
   * Test {@link MappingCoverage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MappingCoverage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MappingCoverage.equals(Object)", "int MappingCoverage.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MappingCoverage("Ingestion Environment", new HashMap<>(), 10.0d), null);
  }

  /**
   * Test {@link MappingCoverage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MappingCoverage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MappingCoverage.equals(Object)", "int MappingCoverage.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new MappingCoverage("Ingestion Environment", new HashMap<>(), 10.0d),
        "Different type to MappingCoverage");
  }

  /**
   * Test {@link MappingCoverage#compareTo(MappingCoverage)} with {@code MappingCoverage}.
   *
   * <ul>
   *   <li>Then return twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link MappingCoverage#compareTo(MappingCoverage)}
   */
  @Test
  @DisplayName("Test compareTo(MappingCoverage) with 'MappingCoverage'; then return twenty-eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MappingCoverage.compareTo(MappingCoverage)"})
  void testCompareToWithMappingCoverage_thenReturnTwentyEight() {
    // Arrange
    MappingCoverage mappingCoverage =
        new MappingCoverage(MappingCoverage.ENV, new HashMap<>(), 10.0d);
    MappingCoverage other = new MappingCoverage("Ingestion Environment", new HashMap<>(), 10.0d);

    // Act
    int actualCompareToResult = mappingCoverage.compareTo(other);

    // Assert
    assertEquals(28, actualCompareToResult);
  }
}
