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
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.regnosys.rosetta.common.merger.BarBuilder;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.process.Processor;
import java.util.function.Supplier;
import org.junit.Test;

public class ReKeyProcessStepDiffblueTest {
  /**
   * Method under test: {@link ReKeyProcessStep#getPriority()}
   */
  @Test
  public void testGetPriority() {
    // Arrange, Act and Assert
    assertEquals(2, (new ReKeyProcessStep(new GlobalKeyProcessStep(mock(Supplier.class)))).getPriority().intValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ReKeyProcessStep#ReKeyProcessStep(GlobalKeyProcessStep)}
   *   <li>{@link ReKeyProcessStep#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Re-key PostProcessor",
        (new ReKeyProcessStep(new GlobalKeyProcessStep(mock(Supplier.class)))).getName());
  }

  /**
   * Method under test:
   * {@link ReKeyProcessStep.ReKeyPostProcessReport#getResultObject()}
   */
  @Test
  public void testReKeyPostProcessReportGetResultObject() {
    // Arrange
    ReKeyProcessStep reKeyProcessStep = new ReKeyProcessStep(new GlobalKeyProcessStep(mock(Supplier.class)));
    BarBuilder result = new BarBuilder();

    // Act and Assert
    assertSame(result, (reKeyProcessStep.new ReKeyPostProcessReport(result)).getResultObject());
  }

  /**
   * Method under test:
   * {@link ReKeyProcessStep.ReKeyPostProcessReport#ReKeyPostProcessReport(ReKeyProcessStep, RosettaModelObjectBuilder)}
   */
  @Test
  public void testReKeyPostProcessReportNewReKeyPostProcessReport() {
    // Arrange
    ReKeyProcessStep reKeyProcessStep = new ReKeyProcessStep(new GlobalKeyProcessStep(mock(Supplier.class)));
    BarBuilder result = new BarBuilder();

    // Act and Assert
    assertSame(result, (reKeyProcessStep.new ReKeyPostProcessReport(result)).getResultObject());
  }
}
