package com.regnosys.rosetta.common.postprocess.qualify;

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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class QualifyProcessorStepDiffblueTest {
  /**
   * Test {@link QualifyProcessorStep#getPriority()}.
   * <p>
   * Method under test: {@link QualifyProcessorStep#getPriority()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Integer QualifyProcessorStep.getPriority()"})
  public void testGetPriority() {
    // Arrange, Act and Assert
    assertEquals(2, (new QualifyProcessorStep()).getPriority().intValue());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link QualifyProcessorStep}
   *   <li>{@link QualifyProcessorStep#getName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QualifyProcessorStep.<init>()", "java.lang.String QualifyProcessorStep.getName()"})
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Qualification PostProcessor", (new QualifyProcessorStep()).getName());
  }
}
