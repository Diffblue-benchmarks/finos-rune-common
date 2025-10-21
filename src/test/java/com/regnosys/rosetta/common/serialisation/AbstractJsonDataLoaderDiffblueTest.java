package com.regnosys.rosetta.common.serialisation;

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
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.cfg.MapperBuilder;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;
import com.regnosys.rosetta.common.serialisation.lookup.JsonLookupDataLoader;
import com.regnosys.rosetta.common.serialisation.projectiondata.ProjectionDataSet;
import com.regnosys.rosetta.common.serialisation.reportdata.ReportDataItem;
import com.rosetta.model.lib.ModelReportId;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.management.loading.MLet;
import net.bytebuddy.dynamic.loading.ByteArrayClassLoader;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class AbstractJsonDataLoaderDiffblueTest {
  /**
   * Test {@link AbstractJsonDataLoader#load()}.
   * <p>
   * Method under test: {@link AbstractJsonDataLoader#load()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.List AbstractJsonDataLoader.load()"})
  public void testLoad() throws MalformedURLException {
    // Arrange
    MLet classLoader = new MLet();
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    // Act and Assert
    assertTrue((new JsonLookupDataLoader(classLoader, rosettaObjectMapper, descriptorPath, new ArrayList<>())).load()
        .isEmpty());
  }

  /**
   * Test {@link AbstractJsonDataLoader#load()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractJsonDataLoader#load()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.List AbstractJsonDataLoader.load()"})
  public void testLoad_givenArrayListAddFoo() throws MalformedURLException {
    // Arrange
    ArrayList<String> descriptorFileNames = new ArrayList<>();
    descriptorFileNames.add("foo");
    MLet classLoader = new MLet();

    // Act and Assert
    assertTrue((new JsonLookupDataLoader(classLoader, JsonMapper.builder().findAndAddModules().build(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(), descriptorFileNames)).load()
        .isEmpty());
  }

  /**
   * Test {@link AbstractJsonDataLoader#load()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code Resolved URL {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractJsonDataLoader#load()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.List AbstractJsonDataLoader.load()"})
  public void testLoad_givenArrayListAddResolvedUrl() throws MalformedURLException {
    // Arrange
    ArrayList<String> descriptorFileNames = new ArrayList<>();
    descriptorFileNames.add("Resolved URL {}");
    descriptorFileNames.add("foo");
    MLet classLoader = new MLet();

    // Act and Assert
    assertTrue((new JsonLookupDataLoader(classLoader, JsonMapper.builder().findAndAddModules().build(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(), descriptorFileNames)).load()
        .isEmpty());
  }

  /**
   * Test {@link AbstractJsonDataLoader#resolve(URL, String)}.
   * <p>
   * Method under test: {@link AbstractJsonDataLoader#resolve(URL, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"URL AbstractJsonDataLoader.resolve(URL, String)"})
  public void testResolve() throws MalformedURLException {
    // Arrange
    MLet classLoader = new MLet();
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    // Act
    URL actualResolveResult = (new JsonLookupDataLoader(classLoader, rosettaObjectMapper, descriptorPath,
        new ArrayList<>()))
        .resolve(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(), "Child");

    // Assert
    String expectedToStringResult = String.join("", "file:",
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt", "Child").toString());
    assertEquals(expectedToStringResult, actualResolveResult.toString());
  }

  /**
   * Test {@link AbstractJsonDataLoader#getInput(String, ReportDataItem, URL)}.
   * <ul>
   *   <li>Given {@code AbstractJsonDataLoader}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractJsonDataLoader#getInput(String, ReportDataItem, URL)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object AbstractJsonDataLoader.getInput(String, ReportDataItem, URL)"})
  public void testGetInput_givenComRegnosysRosettaCommonSerialisationAbstractJsonDataLoader()
      throws ClassNotFoundException, MalformedURLException {
    // Arrange
    ByteArrayClassLoader classLoader = mock(ByteArrayClassLoader.class);
    Class<AbstractJsonDataLoader> forNameResult = AbstractJsonDataLoader.class;
    Mockito.<Class<?>>when(classLoader.loadClass(Mockito.<String>any())).thenReturn(forNameResult);
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    JsonLookupDataLoader jsonLookupDataLoader = new JsonLookupDataLoader(classLoader, rosettaObjectMapper,
        descriptorPath, new ArrayList<>());

    // Act
    Object actualInput = jsonLookupDataLoader.getInput("Input Type", new ReportDataItem(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());

    // Assert
    verify(classLoader).loadClass(eq("Input Type"));
    assertNull(actualInput);
  }

  /**
   * Test {@link AbstractJsonDataLoader#getInput(String, ReportDataItem, URL)}.
   * <ul>
   *   <li>Given {@code ReportDataItem}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractJsonDataLoader#getInput(String, ReportDataItem, URL)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object AbstractJsonDataLoader.getInput(String, ReportDataItem, URL)"})
  public void testGetInput_givenComRegnosysRosettaCommonSerialisationReportdataReportDataItem()
      throws ClassNotFoundException, MalformedURLException {
    // Arrange
    ByteArrayClassLoader classLoader = mock(ByteArrayClassLoader.class);
    Class<ReportDataItem> forNameResult = ReportDataItem.class;
    Mockito.<Class<?>>when(classLoader.loadClass(Mockito.<String>any())).thenReturn(forNameResult);
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    JsonLookupDataLoader jsonLookupDataLoader = new JsonLookupDataLoader(classLoader, rosettaObjectMapper,
        descriptorPath, new ArrayList<>());

    // Act
    Object actualInput = jsonLookupDataLoader.getInput("Input Type", new ReportDataItem(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());

    // Assert
    verify(classLoader).loadClass(eq("Input Type"));
    assertNull(actualInput);
  }

  /**
   * Test {@link AbstractJsonDataLoader#getInput(String, ReportDataItem, URL)}.
   * <ul>
   *   <li>Then calls {@link MapperBuilder#findAndAddModules()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractJsonDataLoader#getInput(String, ReportDataItem, URL)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object AbstractJsonDataLoader.getInput(String, ReportDataItem, URL)"})
  public void testGetInput_thenCallsFindAndAddModules() throws ClassNotFoundException, MalformedURLException {
    // Arrange
    ByteArrayClassLoader classLoader = mock(ByteArrayClassLoader.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(classLoader.loadClass(Mockito.<String>any())).thenReturn(forNameResult);
    Builder builder = mock(Builder.class);
    when(builder.findAndAddModules()).thenReturn(JsonMapper.builder());
    JsonMapper rosettaObjectMapper = builder.findAndAddModules().build();
    URL descriptorPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    JsonLookupDataLoader jsonLookupDataLoader = new JsonLookupDataLoader(classLoader, rosettaObjectMapper,
        descriptorPath, new ArrayList<>());

    // Act
    Object actualInput = jsonLookupDataLoader.getInput("Input Type", new ReportDataItem(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());

    // Assert
    verify(builder).findAndAddModules();
    verify(classLoader).loadClass(eq("Input Type"));
    assertNull(actualInput);
  }

  /**
   * Test {@link AbstractJsonDataLoader#getInput(String, ReportDataItem, URL)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractJsonDataLoader#getInput(String, ReportDataItem, URL)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object AbstractJsonDataLoader.getInput(String, ReportDataItem, URL)"})
  public void testGetInput_thenReturnNull() throws ClassNotFoundException, MalformedURLException {
    // Arrange
    ByteArrayClassLoader classLoader = mock(ByteArrayClassLoader.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(classLoader.loadClass(Mockito.<String>any())).thenReturn(forNameResult);
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    JsonLookupDataLoader jsonLookupDataLoader = new JsonLookupDataLoader(classLoader, rosettaObjectMapper,
        descriptorPath, new ArrayList<>());

    // Act
    Object actualInput = jsonLookupDataLoader.getInput("Input Type", new ReportDataItem(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());

    // Assert
    verify(classLoader).loadClass(eq("Input Type"));
    assertNull(actualInput);
  }

  /**
   * Test {@link AbstractJsonDataLoader#getDataItem(DataSet, URL)}.
   * <p>
   * Method under test: {@link AbstractJsonDataLoader#getDataItem(DataSet, URL)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.List AbstractJsonDataLoader.getDataItem(DataSet, URL)"})
  public void testGetDataItem() throws MalformedURLException {
    // Arrange
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    JsonLookupDataLoader jsonLookupDataLoader = new JsonLookupDataLoader(null, rosettaObjectMapper, descriptorPath,
        new ArrayList<>());

    ArrayList<ReportDataItem> data = new ArrayList<>();
    data.add(new ReportDataItem());
    ArrayList<String> applicableProjections = new ArrayList<>();

    // Act and Assert
    assertEquals(data,
        jsonLookupDataLoader
            .getDataItem(
                new ProjectionDataSet("Data Set Name", "Data Set Short Name", "Input Type", applicableProjections,
                    new ArrayList<>(), data),
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
  }

  /**
   * Test {@link AbstractJsonDataLoader#getDataItem(DataSet, URL)}.
   * <ul>
   *   <li>Given {@link ReportDataItem#ReportDataItem()}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractJsonDataLoader#getDataItem(DataSet, URL)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.List AbstractJsonDataLoader.getDataItem(DataSet, URL)"})
  public void testGetDataItem_givenReportDataItem_thenReturnArrayList() throws MalformedURLException {
    // Arrange
    MLet classLoader = new MLet();
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    JsonLookupDataLoader jsonLookupDataLoader = new JsonLookupDataLoader(classLoader, rosettaObjectMapper,
        descriptorPath, new ArrayList<>());

    ArrayList<ReportDataItem> data = new ArrayList<>();
    data.add(new ReportDataItem());
    ArrayList<String> applicableProjections = new ArrayList<>();

    // Act and Assert
    assertEquals(data,
        jsonLookupDataLoader
            .getDataItem(
                new ProjectionDataSet("Data Set Name", "Data Set Short Name", "Input Type", applicableProjections,
                    new ArrayList<>(), data),
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
  }

  /**
   * Test {@link AbstractJsonDataLoader#getDataItem(DataSet, URL)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractJsonDataLoader#getDataItem(DataSet, URL)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.List AbstractJsonDataLoader.getDataItem(DataSet, URL)"})
  public void testGetDataItem_thenReturnEmpty() throws MalformedURLException {
    // Arrange
    MLet classLoader = new MLet();
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    JsonLookupDataLoader jsonLookupDataLoader = new JsonLookupDataLoader(classLoader, rosettaObjectMapper,
        descriptorPath, new ArrayList<>());
    ArrayList<String> applicableProjections = new ArrayList<>();
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    // Act and Assert
    assertTrue(
        jsonLookupDataLoader
            .getDataItem(
                new ProjectionDataSet("Data Set Name", "Data Set Short Name", "Input Type", applicableProjections,
                    applicableReports, new ArrayList<>()),
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL())
            .isEmpty());
  }
}
