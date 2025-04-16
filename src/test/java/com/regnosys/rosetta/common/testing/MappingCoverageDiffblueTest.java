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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MappingCoverageDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MappingCoverage.<init>(String, Map, double)",
      "String MappingCoverage.getIngestionEnvironment()", "double MappingCoverage.getMappingCoverage()",
      "Map MappingCoverage.getSchema()", "String MappingCoverage.toString()"})
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

  /**
   * Test {@link MappingCoverage#equals(Object)}, and {@link MappingCoverage#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MappingCoverage#equals(Object)}
   *   <li>{@link MappingCoverage#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MappingCoverage.equals(Object)", "int MappingCoverage.hashCode()"})
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
   * Test {@link MappingCoverage#equals(Object)}, and {@link MappingCoverage#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MappingCoverage#equals(Object)}
   *   <li>{@link MappingCoverage#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MappingCoverage.equals(Object)", "int MappingCoverage.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MappingCoverage mappingCoverage = new MappingCoverage("Ingestion Environment", new HashMap<>(), 10.0d);

    // Act and Assert
    assertEquals(mappingCoverage, mappingCoverage);
    int expectedHashCodeResult = mappingCoverage.hashCode();
    assertEquals(expectedHashCodeResult, mappingCoverage.hashCode());
  }

  /**
   * Test {@link MappingCoverage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingCoverage#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MappingCoverage.equals(Object)", "int MappingCoverage.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MappingCoverage mappingCoverage = new MappingCoverage(null, new HashMap<>(), 10.0d);

    // Act and Assert
    assertNotEquals(mappingCoverage, new MappingCoverage("Ingestion Environment", new HashMap<>(), 10.0d));
  }

  /**
   * Test {@link MappingCoverage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingCoverage#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MappingCoverage.equals(Object)", "int MappingCoverage.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashMap<String, String> schema = new HashMap<>();
    schema.put("foo", "foo");
    MappingCoverage mappingCoverage = new MappingCoverage("Ingestion Environment", schema, 10.0d);

    // Act and Assert
    assertNotEquals(mappingCoverage, new MappingCoverage("Ingestion Environment", new HashMap<>(), 10.0d));
  }

  /**
   * Test {@link MappingCoverage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingCoverage#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MappingCoverage.equals(Object)", "int MappingCoverage.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MappingCoverage mappingCoverage = new MappingCoverage("Ingestion Environment", new HashMap<>(), 0.5d);

    // Act and Assert
    assertNotEquals(mappingCoverage, new MappingCoverage("Ingestion Environment", new HashMap<>(), 10.0d));
  }

  /**
   * Test {@link MappingCoverage#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingCoverage#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MappingCoverage.equals(Object)", "int MappingCoverage.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MappingCoverage("Ingestion Environment", new HashMap<>(), 10.0d), null);
  }

  /**
   * Test {@link MappingCoverage#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingCoverage#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MappingCoverage.equals(Object)", "int MappingCoverage.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MappingCoverage("Ingestion Environment", new HashMap<>(), 10.0d),
        "Different type to MappingCoverage");
  }

  /**
   * Test {@link MappingCoverage#compareTo(MappingCoverage)} with {@code MappingCoverage}.
   * <ul>
   *   <li>Then return twenty-eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingCoverage#compareTo(MappingCoverage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MappingCoverage.compareTo(MappingCoverage)"})
  public void testCompareToWithMappingCoverage_thenReturnTwentyEight() {
    // Arrange
    MappingCoverage mappingCoverage = new MappingCoverage(MappingCoverage.ENV, new HashMap<>(), 10.0d);

    // Act and Assert
    assertEquals(28, mappingCoverage.compareTo(new MappingCoverage("Ingestion Environment", new HashMap<>(), 10.0d)));
  }
}
