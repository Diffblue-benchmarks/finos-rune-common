package com.regnosys.rosetta.common.serialisation.lookup;

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
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.management.loading.MLet;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class JsonLookupDataLoaderDiffblueTest {
  /**
   * Test {@link JsonLookupDataLoader#loadInputFiles(LookupDataSet)} with {@code LookupDataSet}.
   * <p>
   * Method under test: {@link JsonLookupDataLoader#loadInputFiles(LookupDataSet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LookupDataSet JsonLookupDataLoader.loadInputFiles(LookupDataSet)"})
  public void testLoadInputFilesWithLookupDataSet() throws MalformedURLException {
    // Arrange
    MLet classLoader = new MLet();
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    JsonLookupDataLoader jsonLookupDataLoader = new JsonLookupDataLoader(classLoader, rosettaObjectMapper,
        descriptorPath, new ArrayList<>());
    LookupDataSet descriptor = new LookupDataSet("Name", "Key Type", "42", new ArrayList<>());

    // Act and Assert
    assertEquals(descriptor, jsonLookupDataLoader.loadInputFiles(descriptor));
  }
}
