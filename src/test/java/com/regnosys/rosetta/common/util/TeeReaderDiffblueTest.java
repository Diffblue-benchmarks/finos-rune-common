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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TeeReaderDiffblueTest {
  /**
   * Test {@link TeeReader#TeeReader(Reader)}.
   *
   * <ul>
   *   <li>When {@link FileReader#FileReader(FileDescriptor)} with {@link
   *       FileDescriptor#FileDescriptor()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TeeReader#TeeReader(Reader)}
   */
  @Test
  @DisplayName(
      "Test new TeeReader(Reader); when FileReader(FileDescriptor) with FileDescriptor(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TeeReader.<init>(Reader)"})
  void testNewTeeReader_whenFileReaderWithFileDescriptor_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new TeeReader(new FileReader(new FileDescriptor())));
  }

  /**
   * Test {@link TeeReader#splitInto(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return array length is three.
   * </ul>
   *
   * <p>Method under test: {@link TeeReader#splitInto(int)}
   */
  @Test
  @DisplayName("Test splitInto(int); when three; then return array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Reader[] TeeReader.splitInto(int)"})
  void testSplitInto_whenThree_thenReturnArrayLengthIsThree() throws IOException {
    // Arrange and Act
    Reader[] actualSplitIntoResult = new TeeReader(new StringReader("foo")).splitInto(3);

    // Assert
    assertEquals(3, actualSplitIntoResult.length);
    assertFalse(actualSplitIntoResult[0].ready());
    assertFalse(actualSplitIntoResult[1].ready());
    assertFalse(actualSplitIntoResult[2].ready());
  }
}
