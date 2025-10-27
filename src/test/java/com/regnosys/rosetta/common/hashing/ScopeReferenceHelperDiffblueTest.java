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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.regnosys.rosetta.common.translation.Path;
import com.rosetta.model.lib.path.RosettaPath;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Supplier;
import org.junit.Test;

public class ScopeReferenceHelperDiffblueTest {
  /**
   * Method under test:
   * {@link ScopeReferenceHelper#collectScopePath(RosettaPath, Class)}
   */
  @Test
  public void testCollectScopePath() {
    // Arrange
    Supplier<Object> newDataStructureSupplier = mock(Supplier.class);
    when(newDataStructureSupplier.get()).thenReturn("Get");
    Class<Object> scopeType = Object.class;
    ScopeReferenceHelper<Object> scopeReferenceHelper = new ScopeReferenceHelper<>(
        new ReferenceConfig(scopeType, new ArrayList<>()), newDataStructureSupplier);
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
   * Method under test: {@link ScopeReferenceHelper#getDataForModelPath(Path)}
   */
  @Test
  public void testGetDataForModelPath() {
    // Arrange
    Supplier<Object> newDataStructureSupplier = mock(Supplier.class);
    when(newDataStructureSupplier.get()).thenReturn("Get");
    ScopeReferenceHelper<Object> scopeReferenceHelper = new ScopeReferenceHelper<>(
        ReferenceConfig.noScopeOrExcludedPaths(), newDataStructureSupplier);

    // Act
    Object actualDataForModelPath = scopeReferenceHelper.getDataForModelPath(ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    verify(newDataStructureSupplier).get();
    assertEquals("Get", actualDataForModelPath);
    assertEquals(1, scopeReferenceHelper.getScopeToDataMap().size());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ScopeReferenceHelper#ScopeReferenceHelper(ReferenceConfig, Supplier)}
   *   <li>{@link ScopeReferenceHelper#getScopeToDataMap()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ScopeReferenceHelper<Object> actualScopeReferenceHelper = new ScopeReferenceHelper<>(
        ReferenceConfig.noScopeOrExcludedPaths(), mock(Supplier.class));

    // Assert
    assertTrue(actualScopeReferenceHelper.getScopeToDataMap().isEmpty());
  }
}
