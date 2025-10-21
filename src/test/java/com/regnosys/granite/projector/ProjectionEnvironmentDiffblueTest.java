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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.granite.projector.ProjectionEnvironment.FileFormat;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ProjectionEnvironmentDiffblueTest {
  /**
   * Test {@link ProjectionEnvironment#ProjectionEnvironment(FileFormat, String, String, Set)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProjectionEnvironment#ProjectionEnvironment(FileFormat, String, String, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProjectionEnvironment.<init>(FileFormat, String, String, Set)"})
  public void testNewProjectionEnvironment_given42_whenHashSetAdd42() {
    // Arrange
    HashSet<String> projectionClassOptions = new HashSet<>();
    projectionClassOptions.add("42");
    projectionClassOptions.add("foo");

    // Act
    ProjectionEnvironment actualProjectionEnvironment = new ProjectionEnvironment(FileFormat.XML, "java.text",
        "Projection Service Class", projectionClassOptions);

    // Assert
    assertEquals("Projection Service Class", actualProjectionEnvironment.getProjectionServiceClass());
    assertEquals("java.text", actualProjectionEnvironment.getPojoPackage());
    assertEquals(FileFormat.XML, actualProjectionEnvironment.getOutputFileFormat());
    assertSame(projectionClassOptions, actualProjectionEnvironment.getProjectionClassOptions());
  }

  /**
   * Test {@link ProjectionEnvironment#ProjectionEnvironment(FileFormat, String, String, Set)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return ProjectionClassOptions is {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProjectionEnvironment#ProjectionEnvironment(FileFormat, String, String, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProjectionEnvironment.<init>(FileFormat, String, String, Set)"})
  public void testNewProjectionEnvironment_givenFoo_thenReturnProjectionClassOptionsIsHashSet() {
    // Arrange
    HashSet<String> projectionClassOptions = new HashSet<>();
    projectionClassOptions.add("foo");

    // Act
    ProjectionEnvironment actualProjectionEnvironment = new ProjectionEnvironment(FileFormat.XML, "java.text",
        "Projection Service Class", projectionClassOptions);

    // Assert
    assertEquals("Projection Service Class", actualProjectionEnvironment.getProjectionServiceClass());
    assertEquals("java.text", actualProjectionEnvironment.getPojoPackage());
    assertEquals(FileFormat.XML, actualProjectionEnvironment.getOutputFileFormat());
    assertSame(projectionClassOptions, actualProjectionEnvironment.getProjectionClassOptions());
  }

  /**
   * Test {@link ProjectionEnvironment#ProjectionEnvironment(FileFormat, String, String, Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return ProjectionClassOptions Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProjectionEnvironment#ProjectionEnvironment(FileFormat, String, String, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProjectionEnvironment.<init>(FileFormat, String, String, Set)"})
  public void testNewProjectionEnvironment_whenHashSet_thenReturnProjectionClassOptionsEmpty() {
    // Arrange and Act
    ProjectionEnvironment actualProjectionEnvironment = new ProjectionEnvironment(FileFormat.XML, "java.text",
        "Projection Service Class", new HashSet<>());

    // Assert
    assertEquals("Projection Service Class", actualProjectionEnvironment.getProjectionServiceClass());
    assertEquals("java.text", actualProjectionEnvironment.getPojoPackage());
    assertEquals(FileFormat.XML, actualProjectionEnvironment.getOutputFileFormat());
    assertTrue(actualProjectionEnvironment.getProjectionClassOptions().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProjectionEnvironment#getOutputFileFormat()}
   *   <li>{@link ProjectionEnvironment#getPojoPackage()}
   *   <li>{@link ProjectionEnvironment#getProjectionClassOptions()}
   *   <li>{@link ProjectionEnvironment#getProjectionServiceClass()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FileFormat ProjectionEnvironment.getOutputFileFormat()",
      "String ProjectionEnvironment.getPojoPackage()", "Set ProjectionEnvironment.getProjectionClassOptions()",
      "String ProjectionEnvironment.getProjectionServiceClass()"})
  public void testGettersAndSetters() {
    // Arrange
    HashSet<String> projectionClassOptions = new HashSet<>();
    ProjectionEnvironment projectionEnvironment = new ProjectionEnvironment(FileFormat.XML, "java.text",
        "Projection Service Class", projectionClassOptions);

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
   * Test {@link ProjectionEnvironment#equals(Object)}, and {@link ProjectionEnvironment#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProjectionEnvironment#equals(Object)}
   *   <li>{@link ProjectionEnvironment#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProjectionEnvironment.equals(Object)", "int ProjectionEnvironment.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProjectionEnvironment projectionEnvironment = new ProjectionEnvironment(FileFormat.XML, "java.text",
        "Projection Service Class", new HashSet<>());
    ProjectionEnvironment projectionEnvironment2 = new ProjectionEnvironment(FileFormat.XML, "java.text",
        "Projection Service Class", new HashSet<>());

    // Act and Assert
    assertEquals(projectionEnvironment, projectionEnvironment2);
    int expectedHashCodeResult = projectionEnvironment.hashCode();
    assertEquals(expectedHashCodeResult, projectionEnvironment2.hashCode());
  }

  /**
   * Test {@link ProjectionEnvironment#equals(Object)}, and {@link ProjectionEnvironment#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProjectionEnvironment#equals(Object)}
   *   <li>{@link ProjectionEnvironment#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProjectionEnvironment.equals(Object)", "int ProjectionEnvironment.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProjectionEnvironment projectionEnvironment = new ProjectionEnvironment(FileFormat.XML, "java.text",
        "Projection Service Class", new HashSet<>());

    // Act and Assert
    assertEquals(projectionEnvironment, projectionEnvironment);
    int expectedHashCodeResult = projectionEnvironment.hashCode();
    assertEquals(expectedHashCodeResult, projectionEnvironment.hashCode());
  }

  /**
   * Test {@link ProjectionEnvironment#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProjectionEnvironment#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProjectionEnvironment.equals(Object)", "int ProjectionEnvironment.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ProjectionEnvironment projectionEnvironment = new ProjectionEnvironment(FileFormat.JSON, "java.text",
        "Projection Service Class", new HashSet<>());

    // Act and Assert
    assertNotEquals(projectionEnvironment,
        new ProjectionEnvironment(FileFormat.XML, "java.text", "Projection Service Class", new HashSet<>()));
  }

  /**
   * Test {@link ProjectionEnvironment#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProjectionEnvironment#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProjectionEnvironment.equals(Object)", "int ProjectionEnvironment.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProjectionEnvironment projectionEnvironment = new ProjectionEnvironment(FileFormat.XML, "Projection Service Class",
        "Projection Service Class", new HashSet<>());

    // Act and Assert
    assertNotEquals(projectionEnvironment,
        new ProjectionEnvironment(FileFormat.XML, "java.text", "Projection Service Class", new HashSet<>()));
  }

  /**
   * Test {@link ProjectionEnvironment#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProjectionEnvironment#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProjectionEnvironment.equals(Object)", "int ProjectionEnvironment.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProjectionEnvironment projectionEnvironment = new ProjectionEnvironment(FileFormat.XML, "java.text", "java.text",
        new HashSet<>());

    // Act and Assert
    assertNotEquals(projectionEnvironment,
        new ProjectionEnvironment(FileFormat.XML, "java.text", "Projection Service Class", new HashSet<>()));
  }

  /**
   * Test {@link ProjectionEnvironment#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProjectionEnvironment#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProjectionEnvironment.equals(Object)", "int ProjectionEnvironment.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HashSet<String> projectionClassOptions = new HashSet<>();
    projectionClassOptions.add("java.text");
    ProjectionEnvironment projectionEnvironment = new ProjectionEnvironment(FileFormat.XML, "java.text",
        "Projection Service Class", projectionClassOptions);

    // Act and Assert
    assertNotEquals(projectionEnvironment,
        new ProjectionEnvironment(FileFormat.XML, "java.text", "Projection Service Class", new HashSet<>()));
  }

  /**
   * Test {@link ProjectionEnvironment#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProjectionEnvironment#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProjectionEnvironment.equals(Object)", "int ProjectionEnvironment.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ProjectionEnvironment(FileFormat.XML, "java.text", "Projection Service Class", new HashSet<>()),
        null);
  }

  /**
   * Test {@link ProjectionEnvironment#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProjectionEnvironment#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProjectionEnvironment.equals(Object)", "int ProjectionEnvironment.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ProjectionEnvironment(FileFormat.XML, "java.text", "Projection Service Class", new HashSet<>()),
        "Different type to ProjectionEnvironment");
  }
}
