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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.management.loading.MLet;
import org.eclipse.core.internal.boot.PlatformURLHandler;
import org.junit.Test;
import org.mockito.Mockito;

public class JsonLookupDataLoaderDiffblueTest {
  /**
   * Method under test: {@link JsonLookupDataLoader#loadInputFiles(LookupDataSet)}
   */
  @Test
  public void testLoadInputFiles() throws MalformedURLException {
    // Arrange
    URLStreamHandlerFactory urlStreamHandlerFactory = mock(URLStreamHandlerFactory.class);
    when(urlStreamHandlerFactory.createURLStreamHandler(Mockito.<String>any())).thenReturn(new PlatformURLHandler());
    URLClassLoader classLoader = new URLClassLoader(
        new URL[]{Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()}, new MLet(),
        urlStreamHandlerFactory);

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    URL descriptorPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    JsonLookupDataLoader jsonLookupDataLoader = new JsonLookupDataLoader(classLoader, rosettaObjectMapper,
        descriptorPath, new ArrayList<>());
    LookupDataSet descriptor = new LookupDataSet("Name", "Key Type", "42", new ArrayList<>());

    // Act
    LookupDataSet actualLoadInputFilesResult = jsonLookupDataLoader.loadInputFiles(descriptor);

    // Assert
    verify(urlStreamHandlerFactory).createURLStreamHandler(eq("jar"));
    assertEquals(descriptor, actualLoadInputFilesResult);
  }
}
