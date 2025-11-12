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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.granite.projector.ProjectionEnvironment.FileFormat;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ProjectionEnvironmentDiffblueTest {
  /**
   * Test {@link ProjectionEnvironment#ProjectionEnvironment(FileFormat, String, String, Set)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ProjectionEnvironment#ProjectionEnvironment(FileFormat, String,
   * String, Set)}
   */
  @Test
  @DisplayName(
      "Test new ProjectionEnvironment(FileFormat, String, String, Set); given '42'; when HashSet() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProjectionEnvironment.<init>(FileFormat, String, String, Set)"})
  void testNewProjectionEnvironment_given42_whenHashSetAdd42() {
    // Arrange
    HashSet<String> projectionClassOptions = new HashSet<>();
    projectionClassOptions.add("42");
    projectionClassOptions.add("foo");

    // Act
    ProjectionEnvironment actualProjectionEnvironment =
        new ProjectionEnvironment(
            FileFormat.XML, "java.text", "Projection Service Class", projectionClassOptions);

    // Assert
    assertEquals(
        "Projection Service Class", actualProjectionEnvironment.getProjectionServiceClass());
    assertEquals("java.text", actualProjectionEnvironment.getPojoPackage());
    assertEquals(FileFormat.XML, actualProjectionEnvironment.getOutputFileFormat());
    assertSame(projectionClassOptions, actualProjectionEnvironment.getProjectionClassOptions());
  }

  /**
   * Test {@link ProjectionEnvironment#ProjectionEnvironment(FileFormat, String, String, Set)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return ProjectionClassOptions is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ProjectionEnvironment#ProjectionEnvironment(FileFormat, String,
   * String, Set)}
   */
  @Test
  @DisplayName(
      "Test new ProjectionEnvironment(FileFormat, String, String, Set); given 'foo'; then return ProjectionClassOptions is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProjectionEnvironment.<init>(FileFormat, String, String, Set)"})
  void testNewProjectionEnvironment_givenFoo_thenReturnProjectionClassOptionsIsHashSet() {
    // Arrange
    HashSet<String> projectionClassOptions = new HashSet<>();
    projectionClassOptions.add("foo");

    // Act
    ProjectionEnvironment actualProjectionEnvironment =
        new ProjectionEnvironment(
            FileFormat.XML, "java.text", "Projection Service Class", projectionClassOptions);

    // Assert
    assertEquals(
        "Projection Service Class", actualProjectionEnvironment.getProjectionServiceClass());
    assertEquals("java.text", actualProjectionEnvironment.getPojoPackage());
    assertEquals(FileFormat.XML, actualProjectionEnvironment.getOutputFileFormat());
    assertSame(projectionClassOptions, actualProjectionEnvironment.getProjectionClassOptions());
  }

  /**
   * Test {@link ProjectionEnvironment#ProjectionEnvironment(FileFormat, String, String, Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return ProjectionClassOptions Empty.
   * </ul>
   *
   * <p>Method under test: {@link ProjectionEnvironment#ProjectionEnvironment(FileFormat, String,
   * String, Set)}
   */
  @Test
  @DisplayName(
      "Test new ProjectionEnvironment(FileFormat, String, String, Set); when HashSet(); then return ProjectionClassOptions Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProjectionEnvironment.<init>(FileFormat, String, String, Set)"})
  void testNewProjectionEnvironment_whenHashSet_thenReturnProjectionClassOptionsEmpty() {
    // Arrange and Act
    ProjectionEnvironment actualProjectionEnvironment =
        new ProjectionEnvironment(
            FileFormat.XML, "java.text", "Projection Service Class", new HashSet<>());

    // Assert
    assertEquals(
        "Projection Service Class", actualProjectionEnvironment.getProjectionServiceClass());
    assertEquals("java.text", actualProjectionEnvironment.getPojoPackage());
    assertEquals(FileFormat.XML, actualProjectionEnvironment.getOutputFileFormat());
    assertTrue(actualProjectionEnvironment.getProjectionClassOptions().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProjectionEnvironment#getOutputFileFormat()}
   *   <li>{@link ProjectionEnvironment#getPojoPackage()}
   *   <li>{@link ProjectionEnvironment#getProjectionClassOptions()}
   *   <li>{@link ProjectionEnvironment#getProjectionServiceClass()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FileFormat ProjectionEnvironment.getOutputFileFormat()",
    "String ProjectionEnvironment.getPojoPackage()",
    "Set ProjectionEnvironment.getProjectionClassOptions()",
    "String ProjectionEnvironment.getProjectionServiceClass()"
  })
  void testGettersAndSetters() {
    // Arrange
    HashSet<String> projectionClassOptions = new HashSet<>();
    ProjectionEnvironment projectionEnvironment =
        new ProjectionEnvironment(
            FileFormat.XML, "java.text", "Projection Service Class", projectionClassOptions);

    // Act
    FileFormat actualOutputFileFormat = projectionEnvironment.getOutputFileFormat();
    String actualPojoPackage = projectionEnvironment.getPojoPackage();
    Set<String> actualProjectionClassOptions = projectionEnvironment.getProjectionClassOptions();

    // Assert
    assertEquals("Projection Service Class", projectionEnvironment.getProjectionServiceClass());
    assertEquals("java.text", actualPojoPackage);
    assertEquals(FileFormat.XML, actualOutputFileFormat);
    assertTrue(actualProjectionClassOptions.isEmpty());
    assertSame(projectionClassOptions, actualProjectionClassOptions);
  }

  /**
   * Test {@link ProjectionEnvironment#equals(Object)}, and {@link
   * ProjectionEnvironment#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProjectionEnvironment#equals(Object)}
   *   <li>{@link ProjectionEnvironment#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProjectionEnvironment.equals(Object)",
    "int ProjectionEnvironment.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProjectionEnvironment projectionEnvironment =
        new ProjectionEnvironment(
            FileFormat.XML, "java.text", "Projection Service Class", new HashSet<>());
    ProjectionEnvironment projectionEnvironment2 =
        new ProjectionEnvironment(
            FileFormat.XML, "java.text", "Projection Service Class", new HashSet<>());

    // Act and Assert
    assertEquals(projectionEnvironment, projectionEnvironment2);
    assertEquals(projectionEnvironment.hashCode(), projectionEnvironment2.hashCode());
  }

  /**
   * Test {@link ProjectionEnvironment#equals(Object)}, and {@link
   * ProjectionEnvironment#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProjectionEnvironment#equals(Object)}
   *   <li>{@link ProjectionEnvironment#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProjectionEnvironment.equals(Object)",
    "int ProjectionEnvironment.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProjectionEnvironment projectionEnvironment =
        new ProjectionEnvironment(
            FileFormat.XML, "java.text", "Projection Service Class", new HashSet<>());

    // Act and Assert
    assertEquals(projectionEnvironment, projectionEnvironment);
    int expectedHashCodeResult = projectionEnvironment.hashCode();
    assertEquals(expectedHashCodeResult, projectionEnvironment.hashCode());
  }

  /**
   * Test {@link ProjectionEnvironment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProjectionEnvironment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProjectionEnvironment.equals(Object)",
    "int ProjectionEnvironment.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<String> projectionClassOptions = new HashSet<>();
    projectionClassOptions.add("java.text");
    ProjectionEnvironment projectionEnvironment =
        new ProjectionEnvironment(
            FileFormat.XML, "java.text", "Projection Service Class", projectionClassOptions);

    // Act and Assert
    assertNotEquals(
        projectionEnvironment,
        new ProjectionEnvironment(
            FileFormat.XML, "java.text", "Projection Service Class", new HashSet<>()));
  }

  /**
   * Test {@link ProjectionEnvironment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProjectionEnvironment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProjectionEnvironment.equals(Object)",
    "int ProjectionEnvironment.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProjectionEnvironment projectionEnvironment =
        new ProjectionEnvironment(
            FileFormat.JSON, "java.text", "Projection Service Class", new HashSet<>());

    // Act and Assert
    assertNotEquals(
        projectionEnvironment,
        new ProjectionEnvironment(
            FileFormat.XML, "java.text", "Projection Service Class", new HashSet<>()));
  }

  /**
   * Test {@link ProjectionEnvironment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProjectionEnvironment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProjectionEnvironment.equals(Object)",
    "int ProjectionEnvironment.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProjectionEnvironment projectionEnvironment =
        new ProjectionEnvironment(
            FileFormat.XML,
            "Projection Service Class",
            "Projection Service Class",
            new HashSet<>());

    // Act and Assert
    assertNotEquals(
        projectionEnvironment,
        new ProjectionEnvironment(
            FileFormat.XML, "java.text", "Projection Service Class", new HashSet<>()));
  }

  /**
   * Test {@link ProjectionEnvironment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProjectionEnvironment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProjectionEnvironment.equals(Object)",
    "int ProjectionEnvironment.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ProjectionEnvironment projectionEnvironment =
        new ProjectionEnvironment(FileFormat.XML, "java.text", "java.text", new HashSet<>());

    // Act and Assert
    assertNotEquals(
        projectionEnvironment,
        new ProjectionEnvironment(
            FileFormat.XML, "java.text", "Projection Service Class", new HashSet<>()));
  }

  /**
   * Test {@link ProjectionEnvironment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProjectionEnvironment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProjectionEnvironment.equals(Object)",
    "int ProjectionEnvironment.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ProjectionEnvironment(
            FileFormat.XML, "java.text", "Projection Service Class", new HashSet<>()),
        null);
  }

  /**
   * Test {@link ProjectionEnvironment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProjectionEnvironment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProjectionEnvironment.equals(Object)",
    "int ProjectionEnvironment.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ProjectionEnvironment(
            FileFormat.XML, "java.text", "Projection Service Class", new HashSet<>()),
        "Different type to ProjectionEnvironment");
  }
}
