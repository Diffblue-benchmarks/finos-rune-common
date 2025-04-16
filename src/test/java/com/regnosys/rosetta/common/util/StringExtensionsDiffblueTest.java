package com.regnosys.rosetta.common.util;

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

public class StringExtensionsDiffblueTest {
  /**
   * Test {@link StringExtensions#toFirstLower(String)}.
   * <ul>
   *   <li>When {@code foo}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringExtensions#toFirstLower(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StringExtensions.toFirstLower(String)"})
  public void testToFirstLower_whenFoo_thenReturnFoo() {
    // Arrange, Act and Assert
    assertEquals("foo", StringExtensions.toFirstLower("foo"));
  }

  /**
   * Test {@link StringExtensions#toFirstLower(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringExtensions#toFirstLower(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StringExtensions.toFirstLower(String)"})
  public void testToFirstLower_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringExtensions.toFirstLower(null));
  }

  /**
   * Test {@link StringExtensions#toFirstUpper(String)}.
   * <ul>
   *   <li>When {@code foo}.</li>
   *   <li>Then return {@code Foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringExtensions#toFirstUpper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StringExtensions.toFirstUpper(String)"})
  public void testToFirstUpper_whenFoo_thenReturnFoo() {
    // Arrange, Act and Assert
    assertEquals("Foo", StringExtensions.toFirstUpper("foo"));
  }

  /**
   * Test {@link StringExtensions#toFirstUpper(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringExtensions#toFirstUpper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StringExtensions.toFirstUpper(String)"})
  public void testToFirstUpper_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringExtensions.toFirstUpper(null));
  }
}
