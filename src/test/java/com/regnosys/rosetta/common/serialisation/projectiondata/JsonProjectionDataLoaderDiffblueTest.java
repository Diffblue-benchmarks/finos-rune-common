package com.regnosys.rosetta.common.serialisation.projectiondata;

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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.regnosys.rosetta.common.serialisation.reportdata.ReportDataItem;
import com.rosetta.model.lib.ModelReportId;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.management.loading.MLet;
import org.eclipse.core.internal.boot.PlatformURLHandler;
import org.junit.Test;
import org.mockito.Mockito;

public class JsonProjectionDataLoaderDiffblueTest {
  /**
   * Method under test:
   * {@link JsonProjectionDataLoader#loadInputFiles(ProjectionDataSet)}
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
    JsonProjectionDataLoader jsonProjectionDataLoader = new JsonProjectionDataLoader(classLoader, rosettaObjectMapper,
        descriptorPath, new ArrayList<>());
    ArrayList<String> applicableProjections = new ArrayList<>();
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();
    ProjectionDataSet descriptor = new ProjectionDataSet("Data Set Name", "Data Set Short Name", "Input Type",
        applicableProjections, applicableReports, new ArrayList<>());

    // Act
    ProjectionDataSet actualLoadInputFilesResult = jsonProjectionDataLoader.loadInputFiles(descriptor);

    // Assert
    verify(urlStreamHandlerFactory).createURLStreamHandler(eq("jar"));
    assertEquals(descriptor, actualLoadInputFilesResult);
  }

  /**
   * Method under test:
   * {@link JsonProjectionDataLoader#loadInputFiles(ProjectionDataSet)}
   */
  @Test
  public void testLoadInputFiles2() throws MalformedURLException {
    // Arrange
    URLStreamHandlerFactory urlStreamHandlerFactory = mock(URLStreamHandlerFactory.class);
    when(urlStreamHandlerFactory.createURLStreamHandler(Mockito.<String>any())).thenReturn(new PlatformURLHandler());
    URLClassLoader classLoader = new URLClassLoader(
        new URL[]{Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()}, new MLet(),
        urlStreamHandlerFactory);

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    URL descriptorPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    JsonProjectionDataLoader jsonProjectionDataLoader = new JsonProjectionDataLoader(classLoader, rosettaObjectMapper,
        descriptorPath, new ArrayList<>());

    ProjectionDataSet descriptor = new ProjectionDataSet();
    descriptor.setData(new ArrayList<>());

    // Act
    ProjectionDataSet actualLoadInputFilesResult = jsonProjectionDataLoader.loadInputFiles(descriptor);

    // Assert
    verify(urlStreamHandlerFactory).createURLStreamHandler(eq("jar"));
    assertEquals("com.regnosys.rosetta.common.serialisation.reportdata.ExpectedResult",
        actualLoadInputFilesResult.getExpectedType());
    assertNull(actualLoadInputFilesResult.getDataSetName());
    assertNull(actualLoadInputFilesResult.getDataSetShortName());
    assertNull(actualLoadInputFilesResult.getInputType());
    assertTrue(actualLoadInputFilesResult.getData().isEmpty());
    List<String> applicableProjections = actualLoadInputFilesResult.getApplicableProjections();
    assertTrue(applicableProjections.isEmpty());
    assertSame(applicableProjections, actualLoadInputFilesResult.getApplicableReports());
  }

  /**
   * Method under test:
   * {@link JsonProjectionDataLoader#loadInputFiles(ProjectionDataSet)}
   */
  @Test
  public void testLoadInputFiles3() throws MalformedURLException {
    // Arrange
    URLStreamHandlerFactory urlStreamHandlerFactory = mock(URLStreamHandlerFactory.class);
    when(urlStreamHandlerFactory.createURLStreamHandler(Mockito.<String>any())).thenReturn(new PlatformURLHandler());
    URLClassLoader classLoader = new URLClassLoader(
        new URL[]{Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()}, new MLet(),
        urlStreamHandlerFactory);

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    URL descriptorPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    JsonProjectionDataLoader jsonProjectionDataLoader = new JsonProjectionDataLoader(classLoader, rosettaObjectMapper,
        descriptorPath, new ArrayList<>());

    ArrayList<ReportDataItem> data = new ArrayList<>();
    data.add(new ReportDataItem());
    ArrayList<String> applicableProjections = new ArrayList<>();
    ProjectionDataSet descriptor = new ProjectionDataSet("Data Set Name", "Data Set Short Name", "Input Type",
        applicableProjections, new ArrayList<>(), data);

    // Act
    ProjectionDataSet actualLoadInputFilesResult = jsonProjectionDataLoader.loadInputFiles(descriptor);

    // Assert
    verify(urlStreamHandlerFactory).createURLStreamHandler(eq("jar"));
    assertEquals(descriptor, actualLoadInputFilesResult);
  }
}
