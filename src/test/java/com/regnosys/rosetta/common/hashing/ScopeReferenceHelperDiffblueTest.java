package com.regnosys.rosetta.common.hashing;

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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.regnosys.rosetta.common.translation.Path;
import com.rosetta.model.lib.path.RosettaPath;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ScopeReferenceHelperDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ScopeReferenceHelper#ScopeReferenceHelper(ReferenceConfig, Supplier)}
   *   <li>{@link ScopeReferenceHelper#getScopeToDataMap()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ScopeReferenceHelper.<init>(ReferenceConfig, Supplier)",
    "java.util.Map ScopeReferenceHelper.getScopeToDataMap()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ScopeReferenceHelper<Object> actualScopeReferenceHelper =
        new ScopeReferenceHelper<>(ReferenceConfig.noScopeOrExcludedPaths(), mock(Supplier.class));

    // Assert
    assertTrue(actualScopeReferenceHelper.getScopeToDataMap().isEmpty());
  }

  /**
   * Test {@link ScopeReferenceHelper#collectScopePath(RosettaPath, Class)}.
   *
   * <p>Method under test: {@link ScopeReferenceHelper#collectScopePath(RosettaPath, Class)}
   */
  @Test
  @DisplayName("Test collectScopePath(RosettaPath, Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScopeReferenceHelper.collectScopePath(RosettaPath, Class)"})
  void testCollectScopePath() {
    // Arrange
    ScopeReferenceHelper<Object> scopeReferenceHelper =
        new ScopeReferenceHelper<>(ReferenceConfig.noScopeOrExcludedPaths(), mock(Supplier.class));
    RosettaPath path = mock(RosettaPath.class);
    Class<Object> rosettaType = Object.class;

    // Act
    scopeReferenceHelper.collectScopePath(path, rosettaType);

    // Assert that nothing has changed
    assertTrue(scopeReferenceHelper.getScopeToDataMap().isEmpty());
  }

  /**
   * Test {@link ScopeReferenceHelper#collectScopePath(RosettaPath, Class)}.
   *
   * <p>Method under test: {@link ScopeReferenceHelper#collectScopePath(RosettaPath, Class)}
   */
  @Test
  @DisplayName("Test collectScopePath(RosettaPath, Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScopeReferenceHelper.collectScopePath(RosettaPath, Class)"})
  void testCollectScopePath2() {
    // Arrange
    Supplier<Object> newDataStructureSupplier = mock(Supplier.class);
    when(newDataStructureSupplier.get()).thenReturn(BeanPropertyWriter.MARKER_FOR_EMPTY);
    Class<Object> scopeType = Object.class;
    ReferenceConfig referenceConfig = new ReferenceConfig(scopeType, new ArrayList<>());

    ScopeReferenceHelper<Object> scopeReferenceHelper =
        new ScopeReferenceHelper<>(referenceConfig, newDataStructureSupplier);

    RosettaPath path = mock(RosettaPath.class);
    when(path.allElements()).thenReturn(new LinkedList<>());
    Class<Object> rosettaType = Object.class;

    // Act
    scopeReferenceHelper.collectScopePath(path, rosettaType);

    // Assert
    verify(path).allElements();
    verify(newDataStructureSupplier).get();
    assertEquals(1, scopeReferenceHelper.getScopeToDataMap().size());
  }

  /**
   * Test {@link ScopeReferenceHelper#getDataForModelPath(Path)}.
   *
   * <p>Method under test: {@link ScopeReferenceHelper#getDataForModelPath(Path)}
   */
  @Test
  @DisplayName("Test getDataForModelPath(Path)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ScopeReferenceHelper.getDataForModelPath(Path)"})
  void testGetDataForModelPath() {
    // Arrange
    Supplier<Object> newDataStructureSupplier = mock(Supplier.class);
    when(newDataStructureSupplier.get()).thenReturn(BeanPropertyWriter.MARKER_FOR_EMPTY);
    ScopeReferenceHelper<Object> scopeReferenceHelper =
        new ScopeReferenceHelper<>(
            ReferenceConfig.noScopeOrExcludedPaths(), newDataStructureSupplier);

    // Act
    Object actualDataForModelPath =
        scopeReferenceHelper.getDataForModelPath(ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    verify(newDataStructureSupplier).get();
    assertTrue(actualDataForModelPath instanceof Include);
    assertEquals(1, scopeReferenceHelper.getScopeToDataMap().size());
    assertEquals(Include.NON_EMPTY, actualDataForModelPath);
  }
}
