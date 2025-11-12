package com.regnosys.rosetta.common.postprocess;

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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.hashing.ReferenceConfig;
import com.regnosys.rosetta.common.postprocess.qualify.QualificationReport;
import com.regnosys.rosetta.common.postprocess.qualify.QualifyProcessorStep;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.Price;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.Price.PriceBuilderImpl;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class WorkflowPostProcessorDiffblueTest {
  /**
   * Test {@link WorkflowPostProcessor#WorkflowPostProcessor(QualifyProcessorStep,
   * ReferenceConfig)}.
   *
   * <p>Method under test: {@link WorkflowPostProcessor#WorkflowPostProcessor(QualifyProcessorStep,
   * ReferenceConfig)}
   */
  @Test
  @DisplayName("Test new WorkflowPostProcessor(QualifyProcessorStep, ReferenceConfig)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WorkflowPostProcessor.<init>(QualifyProcessorStep, ReferenceConfig)"})
  void testNewWorkflowPostProcessor() {
    // Arrange
    QualifyProcessorStep qualifyProcessorStep = new QualifyProcessorStep();
    ReferenceConfig resolverConfig = ReferenceConfig.noScopeOrExcludedPaths();

    // Act
    new WorkflowPostProcessor(qualifyProcessorStep, resolverConfig);

    // Assert that nothing has changed
    assertEquals("Qualification PostProcessor", qualifyProcessorStep.getName());
    assertEquals(2, qualifyProcessorStep.getPriority().intValue());
    assertTrue(resolverConfig.getExcludedPaths().isEmpty());
  }

  /**
   * Test {@link WorkflowPostProcessor#WorkflowPostProcessor(QualifyProcessorStep,
   * ReferenceConfig)}.
   *
   * <ul>
   *   <li>Then noScopeOrExcludedPaths ScopeType is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WorkflowPostProcessor#WorkflowPostProcessor(QualifyProcessorStep,
   * ReferenceConfig)}
   */
  @Test
  @DisplayName(
      "Test new WorkflowPostProcessor(QualifyProcessorStep, ReferenceConfig); then noScopeOrExcludedPaths ScopeType is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WorkflowPostProcessor.<init>(QualifyProcessorStep, ReferenceConfig)"})
  void testNewWorkflowPostProcessor_thenNoScopeOrExcludedPathsScopeTypeIsNull() {
    // Arrange
    QualifyProcessorStep qualifyProcessorStep = mock(QualifyProcessorStep.class);
    when(qualifyProcessorStep.runProcessStep(
            Mockito.<Class<RosettaModelObject>>any(), Mockito.<RosettaModelObject>any()))
        .thenReturn(QualificationReport.SUCCESS);
    ReferenceConfig resolverConfig = ReferenceConfig.noScopeOrExcludedPaths();

    // Act
    WorkflowPostProcessor actualWorkflowPostProcessor =
        new WorkflowPostProcessor(qualifyProcessorStep, resolverConfig);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;
    PriceBuilderImpl instance = new PriceBuilderImpl();
    RosettaModelObjectBuilder actualPostProcessResult =
        actualWorkflowPostProcessor.postProcess(rosettaType, instance);

    // Assert
    verify(qualifyProcessorStep).runProcessStep(isA(Class.class), isA(RosettaModelObject.class));
    assertNull(resolverConfig.getScopeType());
    assertNull(instance.getRate());
    assertFalse(instance.hasData());
    assertTrue(resolverConfig.getExcludedPaths().isEmpty());
    Class<Price> expectedType = Price.class;
    assertEquals(expectedType, instance.getType());
    assertSame(instance, actualPostProcessResult);
  }

  /**
   * Test {@link WorkflowPostProcessor#postProcess(Class, RosettaModelObjectBuilder)}.
   *
   * <ul>
   *   <li>Then return {@link Price.PriceBuilderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link WorkflowPostProcessor#postProcess(Class,
   * RosettaModelObjectBuilder)}
   */
  @Test
  @DisplayName(
      "Test postProcess(Class, RosettaModelObjectBuilder); then return PriceBuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RosettaModelObjectBuilder WorkflowPostProcessor.postProcess(Class, RosettaModelObjectBuilder)"
  })
  void testPostProcess_thenReturnPriceBuilderImpl() {
    // Arrange
    QualifyProcessorStep qualifyProcessorStep = mock(QualifyProcessorStep.class);
    when(qualifyProcessorStep.runProcessStep(
            Mockito.<Class<RosettaModelObject>>any(), Mockito.<RosettaModelObject>any()))
        .thenReturn(QualificationReport.SUCCESS);
    WorkflowPostProcessor workflowPostProcessor =
        new WorkflowPostProcessor(qualifyProcessorStep, ReferenceConfig.noScopeOrExcludedPaths());
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;
    PriceBuilderImpl instance = new PriceBuilderImpl();

    // Act
    RosettaModelObjectBuilder actualPostProcessResult =
        workflowPostProcessor.postProcess(rosettaType, instance);

    // Assert
    verify(qualifyProcessorStep).runProcessStep(isA(Class.class), isA(RosettaModelObject.class));
    assertSame(instance, actualPostProcessResult);
  }
}
