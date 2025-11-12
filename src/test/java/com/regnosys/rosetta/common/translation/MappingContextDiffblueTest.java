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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.regnosys.rosetta.common.hashing.ScopeReferenceHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.eclipse.xtext.ide.server.ServerModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MappingContextDiffblueTest {
  private Injector guiceInjector;

  @BeforeEach
  @ManagedByDiffblue
  @MethodsUnderTest({"void MappingContext.<init>(List, Map, Map, ExecutorService)"})
  void guiceInjectorSetup() {
    this.guiceInjector = Guice.createInjector(new ServerModule());
  }

  /**
   * Test {@link MappingContext#MappingContext(Map)}.
   *
   * <p>Method under test: {@link MappingContext#MappingContext(Map)}
   */
  @Test
  @DisplayName("Test new MappingContext(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MappingContext.<init>(Map)"})
  void testNewMappingContext() {
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
   *
   * <ul>
   *   <li>Then return Mappings is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MappingContext#MappingContext(List, Map, Map)}
   */
  @Test
  @DisplayName("Test new MappingContext(List, Map, Map); then return Mappings is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MappingContext.<init>(List, Map, Map)"})
  void testNewMappingContext_thenReturnMappingsIsArrayList() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    HashMap<Object, Object> mappingParams = new HashMap<>();

    // Act
    MappingContext actualMappingContext =
        new MappingContext(mappings, mappingParams, new HashMap<>());

    // Assert
    assertSame(mappings, actualMappingContext.getMappings());
  }

  /**
   * Test {@link MappingContext#MappingContext(List, Map, Map, ExecutorService)}.
   *
   * <ul>
   *   <li>Then return Mappings is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MappingContext#MappingContext(List, Map, Map, ExecutorService)}
   */
  @Test
  @DisplayName(
      "Test new MappingContext(List, Map, Map, ExecutorService); then return Mappings is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MappingContext.<init>(List, Map, Map, ExecutorService)"})
  void testNewMappingContext_thenReturnMappingsIsArrayList2() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    HashMap<Object, Object> mappingParams = new HashMap<>();
    ExecutorService executor = guiceInjector.getInstance(ExecutorService.class);

    // Act
    MappingContext actualMappingContext =
        new MappingContext(mappings, mappingParams, new HashMap<>(), executor);

    // Assert
    assertSame(mappings, actualMappingContext.getMappings());
  }

  /**
   * Test {@link MappingContext#MappingContext(List, Map, Map)}.
   *
   * <ul>
   *   <li>Then return Mappings size is two.
   * </ul>
   *
   * <p>Method under test: {@link MappingContext#MappingContext(List, Map, Map)}
   */
  @Test
  @DisplayName("Test new MappingContext(List, Map, Map); then return Mappings size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MappingContext.<init>(List, Map, Map)"})
  void testNewMappingContext_thenReturnMappingsSizeIsTwo() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);
    HashMap<Object, Object> mappingParams = new HashMap<>();

    // Act
    MappingContext actualMappingContext =
        new MappingContext(mappings, mappingParams, new HashMap<>());

    // Assert
    List<Mapping> mappings2 = actualMappingContext.getMappings();
    assertEquals(2, mappings2.size());
    assertSame(mapping2, mappings2.get(1));
  }

  /**
   * Test {@link MappingContext#MappingContext(List, Map, Map, ExecutorService)}.
   *
   * <ul>
   *   <li>Then return Mappings size is two.
   * </ul>
   *
   * <p>Method under test: {@link MappingContext#MappingContext(List, Map, Map, ExecutorService)}
   */
  @Test
  @DisplayName(
      "Test new MappingContext(List, Map, Map, ExecutorService); then return Mappings size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MappingContext.<init>(List, Map, Map, ExecutorService)"})
  void testNewMappingContext_thenReturnMappingsSizeIsTwo2() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);
    HashMap<Object, Object> mappingParams = new HashMap<>();
    ExecutorService executor = guiceInjector.getInstance(ExecutorService.class);

    // Act
    MappingContext actualMappingContext =
        new MappingContext(mappings, mappingParams, new HashMap<>(), executor);

    // Assert
    List<Mapping> mappings2 = actualMappingContext.getMappings();
    assertEquals(2, mappings2.size());
    assertSame(mapping2, mappings2.get(1));
  }

  /**
   * Test {@link MappingContext#MappingContext(List, Map, Map)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then Executor return {@link ThreadPoolExecutor}.
   * </ul>
   *
   * <p>Method under test: {@link MappingContext#MappingContext(List, Map, Map)}
   */
  @Test
  @DisplayName(
      "Test new MappingContext(List, Map, Map); when ArrayList(); then Executor return ThreadPoolExecutor")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MappingContext.<init>(List, Map, Map)"})
  void testNewMappingContext_whenArrayList_thenExecutorReturnThreadPoolExecutor() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    HashMap<Object, Object> mappingParams = new HashMap<>();

    // Act
    MappingContext actualMappingContext =
        new MappingContext(mappings, mappingParams, new HashMap<>());

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
   * Test {@link MappingContext#MappingContext(List, Map, Map, ExecutorService)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return InvokedTasks Empty.
   * </ul>
   *
   * <p>Method under test: {@link MappingContext#MappingContext(List, Map, Map, ExecutorService)}
   */
  @Test
  @DisplayName(
      "Test new MappingContext(List, Map, Map, ExecutorService); when ArrayList(); then return InvokedTasks Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MappingContext.<init>(List, Map, Map, ExecutorService)"})
  void testNewMappingContext_whenArrayList_thenReturnInvokedTasksEmpty() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    HashMap<Object, Object> mappingParams = new HashMap<>();
    ExecutorService executor = guiceInjector.getInstance(ExecutorService.class);

    // Act
    MappingContext actualMappingContext =
        new MappingContext(mappings, mappingParams, new HashMap<>(), executor);

    // Assert
    assertTrue(actualMappingContext.getInvokedTasks().isEmpty());
    assertTrue(actualMappingContext.getMappingErrors().isEmpty());
    assertTrue(actualMappingContext.getMappings().isEmpty());
    assertTrue(actualMappingContext.getMappingParams().isEmpty());
    assertSame(executor, actualMappingContext.getExecutor());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExecutorService MappingContext.getExecutor()",
    "List MappingContext.getInvokedTasks()",
    "List MappingContext.getMappingErrors()",
    "Map MappingContext.getMappingParams()",
    "List MappingContext.getMappings()",
    "com.regnosys.rosetta.common.translation.SynonymToEnumMap MappingContext.getSynonymToEnumMap()"
  })
  void testGettersAndSetters() {
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
