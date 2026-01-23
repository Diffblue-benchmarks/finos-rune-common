package com.regnosys.rosetta.common.hashing;

/*-
 * ==============
 * Rune Common
 * ==============
 * Copyright (C) 2018 - 2026 REGnosys
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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.rosetta.model.lib.path.RosettaPath;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReferenceConfigDiffblueTest {
  /**
   * Test {@link ReferenceConfig#noScopeOrExcludedPaths()}.
   *
   * <p>Method under test: {@link ReferenceConfig#noScopeOrExcludedPaths()}
   */
  @Test
  @DisplayName("Test noScopeOrExcludedPaths()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReferenceConfig ReferenceConfig.noScopeOrExcludedPaths()"})
  void testNoScopeOrExcludedPaths() {
    // Arrange and Act
    ReferenceConfig actualNoScopeOrExcludedPathsResult = ReferenceConfig.noScopeOrExcludedPaths();

    // Assert
    assertNull(actualNoScopeOrExcludedPathsResult.getScopeType());
    assertTrue(actualNoScopeOrExcludedPathsResult.getExcludedPaths().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReferenceConfig#ReferenceConfig(Class, List)}
   *   <li>{@link ReferenceConfig#getExcludedPaths()}
   *   <li>{@link ReferenceConfig#getScopeType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReferenceConfig.<init>(Class, List)",
    "List ReferenceConfig.getExcludedPaths()",
    "Class ReferenceConfig.getScopeType()"
  })
  void testGettersAndSetters() {
    // Arrange
    Class<Object> scopeType = Object.class;
    ArrayList<RosettaPath> excludedPaths = new ArrayList<>();

    // Act
    ReferenceConfig actualReferenceConfig = new ReferenceConfig(scopeType, excludedPaths);
    List<RosettaPath> actualExcludedPaths = actualReferenceConfig.getExcludedPaths();
    Class<?> actualScopeType = actualReferenceConfig.getScopeType();

    // Assert
    assertTrue(actualExcludedPaths.isEmpty());
    Class<Object> expectedScopeType = Object.class;
    assertEquals(expectedScopeType, actualScopeType);
    assertSame(excludedPaths, actualExcludedPaths);
  }
}
