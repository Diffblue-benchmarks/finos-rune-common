package com.regnosys.rosetta.common.serialisation.mixin;

/*-
 * ==============
 * Rune Common
 * ==============
 * Copyright (C) 2018 - 2026 REGnosys
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
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RosettaDateModuleDiffblueTest {
  /**
   * Test new {@link RosettaDateModule} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link RosettaDateModule}
   */
  @Test
  @DisplayName("Test new RosettaDateModule (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RosettaDateModule.<init>()"})
  void testNewRosettaDateModule() {
    // Arrange and Act
    RosettaDateModule actualRosettaDateModule = new RosettaDateModule();

    // Assert
    Iterable<? extends Module> dependencies = actualRosettaDateModule.getDependencies();
    assertTrue(dependencies instanceof List);
    Version versionResult = actualRosettaDateModule.version();
    assertEquals("", versionResult.getArtifactId());
    assertEquals("", versionResult.getGroupId());
    assertEquals("//0.0.0", versionResult.toFullString());
    assertEquals(
        "com.regnosys.rosetta.common.serialisation.mixin.RosettaDateModule",
        actualRosettaDateModule.getModuleName());
    assertEquals(
        "com.regnosys.rosetta.common.serialisation.mixin.RosettaDateModule",
        actualRosettaDateModule.getTypeId());
    assertEquals(0, versionResult.getMajorVersion());
    assertEquals(0, versionResult.getMinorVersion());
    assertEquals(0, versionResult.getPatchLevel());
    assertFalse(versionResult.isSnapshot());
    assertTrue(versionResult.isUknownVersion());
    assertTrue(versionResult.isUnknownVersion());
    assertTrue(((List<? extends Module>) dependencies).isEmpty());
  }
}
