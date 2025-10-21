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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.hashing.ReKeyProcessStep.ReKeyPostProcessReport;
import com.regnosys.rosetta.common.merger.BarBuilder;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import java.util.function.Supplier;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ReKeyProcessStepDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReKeyProcessStep#ReKeyProcessStep(GlobalKeyProcessStep)}
   *   <li>{@link ReKeyProcessStep#getName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReKeyProcessStep.<init>(GlobalKeyProcessStep)",
      "java.lang.String ReKeyProcessStep.getName()"})
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Re-key PostProcessor",
        (new ReKeyProcessStep(new GlobalKeyProcessStep(mock(Supplier.class)))).getName());
  }

  /**
   * Test {@link ReKeyProcessStep#getPriority()}.
   * <p>
   * Method under test: {@link ReKeyProcessStep#getPriority()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Integer ReKeyProcessStep.getPriority()"})
  public void testGetPriority() {
    // Arrange, Act and Assert
    assertEquals(2, (new ReKeyProcessStep(new GlobalKeyProcessStep(mock(Supplier.class)))).getPriority().intValue());
  }

  /**
   * Test ReKeyPostProcessReport {@link ReKeyPostProcessReport#getResultObject()}.
   * <p>
   * Method under test: {@link ReKeyPostProcessReport#getResultObject()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RosettaModelObjectBuilder ReKeyPostProcessReport.getResultObject()"})
  public void testReKeyPostProcessReportGetResultObject() {
    // Arrange
    ReKeyProcessStep reKeyProcessStep = new ReKeyProcessStep(new GlobalKeyProcessStep(mock(Supplier.class)));
    BarBuilder result = new BarBuilder();

    // Act and Assert
    assertSame(result, (reKeyProcessStep.new ReKeyPostProcessReport(result)).getResultObject());
  }

  /**
   * Test ReKeyPostProcessReport {@link ReKeyPostProcessReport#ReKeyPostProcessReport(ReKeyProcessStep, RosettaModelObjectBuilder)}.
   * <p>
   * Method under test: {@link ReKeyPostProcessReport#ReKeyPostProcessReport(ReKeyProcessStep, RosettaModelObjectBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReKeyPostProcessReport.<init>(ReKeyProcessStep, RosettaModelObjectBuilder)"})
  public void testReKeyPostProcessReportNewReKeyPostProcessReport() {
    // Arrange
    ReKeyProcessStep reKeyProcessStep = new ReKeyProcessStep(new GlobalKeyProcessStep(mock(Supplier.class)));
    BarBuilder result = new BarBuilder();

    // Act and Assert
    assertSame(result, (reKeyProcessStep.new ReKeyPostProcessReport(result)).getResultObject());
  }
}
