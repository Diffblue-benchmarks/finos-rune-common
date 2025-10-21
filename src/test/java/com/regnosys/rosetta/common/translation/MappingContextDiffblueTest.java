package com.regnosys.rosetta.common.translation;

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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.hashing.ScopeReferenceHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MappingContextDiffblueTest {
  /**
   * Test {@link MappingContext#MappingContext(Map)}.
   * <p>
   * Method under test: {@link MappingContext#MappingContext(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MappingContext.<init>(Map)"})
  public void testNewMappingContext() {
    // Arrange and Act
    MappingContext actualMappingContext = new MappingContext(new HashMap<>());

    // Assert
    ExecutorService executor = actualMappingContext.getExecutor();
    assertTrue(executor instanceof ThreadPoolExecutor);
    assertEquals(0, ((ThreadPoolExecutor) executor).getActiveCount());
    assertEquals(0, ((ThreadPoolExecutor) executor).getLargestPoolSize());
    assertEquals(0, ((ThreadPoolExecutor) executor).getPoolSize());
    assertEquals(0L, ((ThreadPoolExecutor) executor).getCompletedTaskCount());
    assertEquals(0L, ((ThreadPoolExecutor) executor).getTaskCount());
    assertEquals(5, ((ThreadPoolExecutor) executor).getCorePoolSize());
    assertEquals(5, ((ThreadPoolExecutor) executor).getMaximumPoolSize());
    assertTrue(((ThreadPoolExecutor) executor).getQueue().isEmpty());
    assertTrue(actualMappingContext.getInvokedTasks().isEmpty());
    assertTrue(actualMappingContext.getMappingErrors().isEmpty());
    assertTrue(actualMappingContext.getMappings().isEmpty());
    assertTrue(actualMappingContext.getMappingParams().isEmpty());
  }

  /**
   * Test {@link MappingContext#MappingContext(List, Map, Map)}.
   * <ul>
   *   <li>Then return Mappings is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingContext#MappingContext(List, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MappingContext.<init>(List, Map, Map)"})
  public void testNewMappingContext_thenReturnMappingsIsArrayList() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    HashMap<Object, Object> mappingParams = new HashMap<>();

    // Act and Assert
    assertSame(mappings, (new MappingContext(mappings, mappingParams, new HashMap<>())).getMappings());
  }

  /**
   * Test {@link MappingContext#MappingContext(List, Map, Map)}.
   * <ul>
   *   <li>Then return Mappings size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingContext#MappingContext(List, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MappingContext.<init>(List, Map, Map)"})
  public void testNewMappingContext_thenReturnMappingsSizeIsTwo() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);
    HashMap<Object, Object> mappingParams = new HashMap<>();

    // Act and Assert
    List<Mapping> mappings2 = (new MappingContext(mappings, mappingParams, new HashMap<>())).getMappings();
    assertEquals(2, mappings2.size());
    assertSame(mapping, mappings2.get(1));
  }

  /**
   * Test {@link MappingContext#MappingContext(List, Map, Map)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then Executor return {@link ThreadPoolExecutor}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingContext#MappingContext(List, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MappingContext.<init>(List, Map, Map)"})
  public void testNewMappingContext_whenArrayList_thenExecutorReturnThreadPoolExecutor() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    HashMap<Object, Object> mappingParams = new HashMap<>();

    // Act
    MappingContext actualMappingContext = new MappingContext(mappings, mappingParams, new HashMap<>());

    // Assert
    ExecutorService executor = actualMappingContext.getExecutor();
    assertTrue(executor instanceof ThreadPoolExecutor);
    assertEquals(0, ((ThreadPoolExecutor) executor).getActiveCount());
    assertEquals(0, ((ThreadPoolExecutor) executor).getLargestPoolSize());
    assertEquals(0, ((ThreadPoolExecutor) executor).getPoolSize());
    assertEquals(0L, ((ThreadPoolExecutor) executor).getCompletedTaskCount());
    assertEquals(0L, ((ThreadPoolExecutor) executor).getTaskCount());
    assertEquals(5, ((ThreadPoolExecutor) executor).getCorePoolSize());
    assertEquals(5, ((ThreadPoolExecutor) executor).getMaximumPoolSize());
    assertTrue(((ThreadPoolExecutor) executor).getQueue().isEmpty());
    assertTrue(actualMappingContext.getInvokedTasks().isEmpty());
    assertTrue(actualMappingContext.getMappingErrors().isEmpty());
    assertTrue(actualMappingContext.getMappings().isEmpty());
    assertTrue(actualMappingContext.getMappingParams().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MappingContext#getExecutor()}
   *   <li>{@link MappingContext#getInvokedTasks()}
   *   <li>{@link MappingContext#getMappingErrors()}
   *   <li>{@link MappingContext#getMappingParams()}
   *   <li>{@link MappingContext#getMappings()}
   *   <li>{@link MappingContext#getSynonymToEnumMap()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExecutorService MappingContext.getExecutor()", "List MappingContext.getInvokedTasks()",
      "List MappingContext.getMappingErrors()", "Map MappingContext.getMappingParams()",
      "List MappingContext.getMappings()",
      "com.regnosys.rosetta.common.translation.SynonymToEnumMap MappingContext.getSynonymToEnumMap()"})
  public void testGettersAndSetters() {
    // Arrange
    MappingContext mappingContext = new MappingContext(new HashMap<>());

    // Act
    ExecutorService actualExecutor = mappingContext.getExecutor();
    List<CompletableFuture<?>> actualInvokedTasks = mappingContext.getInvokedTasks();
    List<String> actualMappingErrors = mappingContext.getMappingErrors();
    Map<Object, Object> actualMappingParams = mappingContext.getMappingParams();
    List<Mapping> actualMappings = mappingContext.getMappings();
    mappingContext.getSynonymToEnumMap();

    // Assert
    assertTrue(actualExecutor instanceof ThreadPoolExecutor);
    assertTrue(actualInvokedTasks.isEmpty());
    assertTrue(actualMappingErrors.isEmpty());
    assertTrue(actualMappings.isEmpty());
    assertTrue(actualMappingParams.isEmpty());
  }
}
