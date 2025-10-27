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
import static org.mockito.Mockito.mock;
import com.regnosys.rosetta.common.hashing.ScopeReferenceHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.BiFunction;
import org.junit.Test;

public class MappingContextDiffblueTest {
  /**
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

  /**
   * Method under test: {@link MappingContext#MappingContext(List, Map, Map)}
   */
  @Test
  public void testNewMappingContext() {
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
    List<Mapping> mappings2 = actualMappingContext.getMappings();
    assertTrue(mappings2.isEmpty());
    Map<Object, Object> mappingParams2 = actualMappingContext.getMappingParams();
    assertTrue(mappingParams2.isEmpty());
    assertSame(mappings, mappings2);
    assertSame(mappingParams, mappingParams2);
  }

  /**
   * Method under test: {@link MappingContext#MappingContext(List, Map, Map)}
   */
  @Test
  public void testNewMappingContext2() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
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
    Map<Object, Object> mappingParams2 = actualMappingContext.getMappingParams();
    assertTrue(mappingParams2.isEmpty());
    assertSame(mappings, actualMappingContext.getMappings());
    assertSame(mappingParams, mappingParams2);
  }

  /**
   * Method under test: {@link MappingContext#MappingContext(List, Map, Map)}
   */
  @Test
  public void testNewMappingContext3() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
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
    Map<Object, Object> mappingParams2 = actualMappingContext.getMappingParams();
    assertTrue(mappingParams2.isEmpty());
    assertSame(mappings, actualMappingContext.getMappings());
    assertSame(mappingParams, mappingParams2);
  }

  /**
   * Method under test: {@link MappingContext#MappingContext(List, Map, Map)}
   */
  @Test
  public void testNewMappingContext4() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();

    HashMap<Object, Object> mappingParams = new HashMap<>();
    mappingParams.computeIfPresent("42", mock(BiFunction.class));

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
    List<Mapping> mappings2 = actualMappingContext.getMappings();
    assertTrue(mappings2.isEmpty());
    Map<Object, Object> mappingParams2 = actualMappingContext.getMappingParams();
    assertTrue(mappingParams2.isEmpty());
    assertSame(mappings, mappings2);
    assertSame(mappingParams, mappingParams2);
  }

  /**
   * Method under test: {@link MappingContext#MappingContext(Map)}
   */
  @Test
  public void testNewMappingContext5() {
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
}
