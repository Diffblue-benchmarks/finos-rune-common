package com.regnosys.granite.projector;

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
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class ProjectionEnvironmentDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProjectionEnvironment#equals(Object)}
   *   <li>{@link ProjectionEnvironment#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProjectionEnvironment projectionEnvironment = new ProjectionEnvironment(ProjectionEnvironment.FileFormat.XML,
        "java.text", "Projection Service Class", new HashSet<>());
    ProjectionEnvironment projectionEnvironment2 = new ProjectionEnvironment(ProjectionEnvironment.FileFormat.XML,
        "java.text", "Projection Service Class", new HashSet<>());

    // Act and Assert
    assertEquals(projectionEnvironment, projectionEnvironment2);
    int expectedHashCodeResult = projectionEnvironment.hashCode();
    assertEquals(expectedHashCodeResult, projectionEnvironment2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProjectionEnvironment#equals(Object)}
   *   <li>{@link ProjectionEnvironment#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProjectionEnvironment projectionEnvironment = new ProjectionEnvironment(ProjectionEnvironment.FileFormat.XML,
        "java.text", "Projection Service Class", new HashSet<>());

    // Act and Assert
    assertEquals(projectionEnvironment, projectionEnvironment);
    int expectedHashCodeResult = projectionEnvironment.hashCode();
    assertEquals(expectedHashCodeResult, projectionEnvironment.hashCode());
  }

  /**
   * Method under test: {@link ProjectionEnvironment#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ProjectionEnvironment projectionEnvironment = new ProjectionEnvironment(ProjectionEnvironment.FileFormat.JSON,
        "java.text", "Projection Service Class", new HashSet<>());

    // Act and Assert
    assertNotEquals(projectionEnvironment, new ProjectionEnvironment(ProjectionEnvironment.FileFormat.XML, "java.text",
        "Projection Service Class", new HashSet<>()));
  }

  /**
   * Method under test: {@link ProjectionEnvironment#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProjectionEnvironment projectionEnvironment = new ProjectionEnvironment(ProjectionEnvironment.FileFormat.XML,
        "Projection Service Class", "Projection Service Class", new HashSet<>());

    // Act and Assert
    assertNotEquals(projectionEnvironment, new ProjectionEnvironment(ProjectionEnvironment.FileFormat.XML, "java.text",
        "Projection Service Class", new HashSet<>()));
  }

  /**
   * Method under test: {@link ProjectionEnvironment#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProjectionEnvironment projectionEnvironment = new ProjectionEnvironment(ProjectionEnvironment.FileFormat.XML,
        "java.text", "java.text", new HashSet<>());

    // Act and Assert
    assertNotEquals(projectionEnvironment, new ProjectionEnvironment(ProjectionEnvironment.FileFormat.XML, "java.text",
        "Projection Service Class", new HashSet<>()));
  }

  /**
   * Method under test: {@link ProjectionEnvironment#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HashSet<String> projectionClassOptions = new HashSet<>();
    projectionClassOptions.add("java.text");
    ProjectionEnvironment projectionEnvironment = new ProjectionEnvironment(ProjectionEnvironment.FileFormat.XML,
        "java.text", "Projection Service Class", projectionClassOptions);

    // Act and Assert
    assertNotEquals(projectionEnvironment, new ProjectionEnvironment(ProjectionEnvironment.FileFormat.XML, "java.text",
        "Projection Service Class", new HashSet<>()));
  }

  /**
   * Method under test: {@link ProjectionEnvironment#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ProjectionEnvironment(ProjectionEnvironment.FileFormat.XML, "java.text",
        "Projection Service Class", new HashSet<>()), null);
  }

  /**
   * Method under test: {@link ProjectionEnvironment#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ProjectionEnvironment(ProjectionEnvironment.FileFormat.XML, "java.text",
        "Projection Service Class", new HashSet<>()), "Different type to ProjectionEnvironment");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProjectionEnvironment#getOutputFileFormat()}
   *   <li>{@link ProjectionEnvironment#getPojoPackage()}
   *   <li>{@link ProjectionEnvironment#getProjectionClassOptions()}
   *   <li>{@link ProjectionEnvironment#getProjectionServiceClass()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    HashSet<String> projectionClassOptions = new HashSet<>();
    ProjectionEnvironment projectionEnvironment = new ProjectionEnvironment(ProjectionEnvironment.FileFormat.XML,
        "java.text", "Projection Service Class", projectionClassOptions);

    // Act
    ProjectionEnvironment.FileFormat actualOutputFileFormat = projectionEnvironment.getOutputFileFormat();
    String actualPojoPackage = projectionEnvironment.getPojoPackage();
    Set<String> actualProjectionClassOptions = projectionEnvironment.getProjectionClassOptions();

    // Assert
    assertEquals("Projection Service Class", projectionEnvironment.getProjectionServiceClass());
    assertEquals("java.text", actualPojoPackage);
    assertEquals(ProjectionEnvironment.FileFormat.XML, actualOutputFileFormat);
    assertTrue(actualProjectionClassOptions.isEmpty());
    assertSame(projectionClassOptions, actualProjectionClassOptions);
  }

  /**
   * Method under test:
   * {@link ProjectionEnvironment#ProjectionEnvironment(ProjectionEnvironment.FileFormat, String, String, Set)}
   */
  @Test
  public void testNewProjectionEnvironment() {
    // Arrange
    HashSet<String> projectionClassOptions = new HashSet<>();

    // Act
    ProjectionEnvironment actualProjectionEnvironment = new ProjectionEnvironment(ProjectionEnvironment.FileFormat.XML,
        "java.text", "Projection Service Class", projectionClassOptions);

    // Assert
    assertEquals("Projection Service Class", actualProjectionEnvironment.getProjectionServiceClass());
    assertEquals("java.text", actualProjectionEnvironment.getPojoPackage());
    assertEquals(ProjectionEnvironment.FileFormat.XML, actualProjectionEnvironment.getOutputFileFormat());
    Set<String> projectionClassOptions2 = actualProjectionEnvironment.getProjectionClassOptions();
    assertTrue(projectionClassOptions2.isEmpty());
    assertSame(projectionClassOptions, projectionClassOptions2);
  }

  /**
   * Method under test:
   * {@link ProjectionEnvironment#ProjectionEnvironment(ProjectionEnvironment.FileFormat, String, String, Set)}
   */
  @Test
  public void testNewProjectionEnvironment2() {
    // Arrange
    HashSet<String> projectionClassOptions = new HashSet<>();
    projectionClassOptions.add("foo");

    // Act
    ProjectionEnvironment actualProjectionEnvironment = new ProjectionEnvironment(ProjectionEnvironment.FileFormat.XML,
        "java.text", "Projection Service Class", projectionClassOptions);

    // Assert
    assertEquals("Projection Service Class", actualProjectionEnvironment.getProjectionServiceClass());
    assertEquals("java.text", actualProjectionEnvironment.getPojoPackage());
    Set<String> projectionClassOptions2 = actualProjectionEnvironment.getProjectionClassOptions();
    assertEquals(1, projectionClassOptions2.size());
    assertEquals(ProjectionEnvironment.FileFormat.XML, actualProjectionEnvironment.getOutputFileFormat());
    assertTrue(projectionClassOptions2.contains("foo"));
    assertSame(projectionClassOptions, projectionClassOptions2);
  }

  /**
   * Method under test:
   * {@link ProjectionEnvironment#ProjectionEnvironment(ProjectionEnvironment.FileFormat, String, String, Set)}
   */
  @Test
  public void testNewProjectionEnvironment3() {
    // Arrange
    HashSet<String> projectionClassOptions = new HashSet<>();
    projectionClassOptions.add("42");
    projectionClassOptions.add("foo");

    // Act
    ProjectionEnvironment actualProjectionEnvironment = new ProjectionEnvironment(ProjectionEnvironment.FileFormat.XML,
        "java.text", "Projection Service Class", projectionClassOptions);

    // Assert
    assertEquals("Projection Service Class", actualProjectionEnvironment.getProjectionServiceClass());
    assertEquals("java.text", actualProjectionEnvironment.getPojoPackage());
    assertEquals(ProjectionEnvironment.FileFormat.XML, actualProjectionEnvironment.getOutputFileFormat());
    assertSame(projectionClassOptions, actualProjectionEnvironment.getProjectionClassOptions());
  }
}
