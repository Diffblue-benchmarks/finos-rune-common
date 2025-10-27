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

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.regnosys.rosetta.common.hashing.ReferenceConfig;
import com.regnosys.rosetta.common.postprocess.qualify.QualificationReport;
import com.regnosys.rosetta.common.postprocess.qualify.QualifyProcessorStep;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.Price;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class WorkflowPostProcessorDiffblueTest {
  /**
   * Method under test:
   * {@link WorkflowPostProcessor#postProcess(Class, RosettaModelObjectBuilder)}
   */
  @Test
  public void testPostProcess() {
    // Arrange
    QualifyProcessorStep qualifyProcessorStep = mock(QualifyProcessorStep.class);
    when(qualifyProcessorStep.runProcessStep(Mockito.<Class<RosettaModelObject>>any(),
        Mockito.<RosettaModelObject>any())).thenReturn(QualificationReport.SUCCESS);
    WorkflowPostProcessor workflowPostProcessor = new WorkflowPostProcessor(qualifyProcessorStep,
        ReferenceConfig.noScopeOrExcludedPaths());
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;
    Price.PriceBuilderImpl instance = new Price.PriceBuilderImpl();

    // Act
    RosettaModelObjectBuilder actualPostProcessResult = workflowPostProcessor.postProcess(rosettaType, instance);

    // Assert
    verify(qualifyProcessorStep).runProcessStep(isA(Class.class), isA(RosettaModelObject.class));
    assertSame(instance, actualPostProcessResult);
  }
}
