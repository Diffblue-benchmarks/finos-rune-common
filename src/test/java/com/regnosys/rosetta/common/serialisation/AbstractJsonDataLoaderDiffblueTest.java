package com.regnosys.rosetta.common.serialisation;

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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.regnosys.rosetta.common.postprocess.qualify.QualificationReport;
import com.regnosys.rosetta.common.projection.ProjectionDataItemExpectation;
import com.regnosys.rosetta.common.serialisation.lookup.JsonLookupDataLoader;
import com.regnosys.rosetta.common.serialisation.projectiondata.ProjectionDataSet;
import com.regnosys.rosetta.common.serialisation.reportdata.ExpectedResult;
import com.regnosys.rosetta.common.serialisation.reportdata.ReportDataItem;
import com.rosetta.model.lib.ModelReportId;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.management.loading.MLet;
import net.bytebuddy.dynamic.loading.ByteArrayClassLoader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AbstractJsonDataLoaderDiffblueTest {
  /**
   * Test {@link AbstractJsonDataLoader#load()}.
   *
   * <p>Method under test: {@link AbstractJsonDataLoader#load()}
   */
  @Test
  @DisplayName("Test load()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractJsonDataLoader.load()"})
  void testLoad() throws MalformedURLException {
    // Arrange
    MLet classLoader = new MLet();
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    JsonLookupDataLoader jsonLookupDataLoader =
        new JsonLookupDataLoader(
            classLoader, rosettaObjectMapper, descriptorPath, new ArrayList<>());

    // Act and Assert
    assertTrue(jsonLookupDataLoader.load().isEmpty());
  }

  /**
   * Test {@link AbstractJsonDataLoader#load()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractJsonDataLoader#load()}
   */
  @Test
  @DisplayName("Test load(); given ArrayList() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractJsonDataLoader.load()"})
  void testLoad_givenArrayListAddFoo() throws MalformedURLException {
    // Arrange
    ArrayList<String> descriptorFileNames = new ArrayList<>();
    descriptorFileNames.add("foo");
    MLet classLoader = new MLet();
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    JsonLookupDataLoader jsonLookupDataLoader =
        new JsonLookupDataLoader(
            classLoader, rosettaObjectMapper, descriptorPath, descriptorFileNames);

    // Act and Assert
    assertTrue(jsonLookupDataLoader.load().isEmpty());
  }

  /**
   * Test {@link AbstractJsonDataLoader#load()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code Resolved URL {}}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractJsonDataLoader#load()}
   */
  @Test
  @DisplayName("Test load(); given ArrayList() add 'Resolved URL {}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractJsonDataLoader.load()"})
  void testLoad_givenArrayListAddResolvedUrl() throws MalformedURLException {
    // Arrange
    ArrayList<String> descriptorFileNames = new ArrayList<>();
    descriptorFileNames.add("Resolved URL {}");
    descriptorFileNames.add("foo");
    MLet classLoader = new MLet();
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    JsonLookupDataLoader jsonLookupDataLoader =
        new JsonLookupDataLoader(
            classLoader, rosettaObjectMapper, descriptorPath, descriptorFileNames);

    // Act and Assert
    assertTrue(jsonLookupDataLoader.load().isEmpty());
  }

  /**
   * Test {@link AbstractJsonDataLoader#resolve(URL, String)}.
   *
   * <p>Method under test: {@link AbstractJsonDataLoader#resolve(URL, String)}
   */
  @Test
  @DisplayName("Test resolve(URL, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"URL AbstractJsonDataLoader.resolve(URL, String)"})
  void testResolve() throws MalformedURLException {
    // Arrange
    MLet classLoader = new MLet();
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    JsonLookupDataLoader jsonLookupDataLoader =
        new JsonLookupDataLoader(
            classLoader, rosettaObjectMapper, descriptorPath, new ArrayList<>());

    // Act
    URL actualResolveResult =
        jsonLookupDataLoader.resolve(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(), "Child");

    // Assert
    Path getResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt", "Child");
    String expectedToStringResult = String.join("", "file:", getResult.toString());
    assertEquals(expectedToStringResult, actualResolveResult.toString());
  }

  /**
   * Test {@link AbstractJsonDataLoader#getInput(String, ReportDataItem, URL)}.
   *
   * <ul>
   *   <li>Given {@link Builder} {@link Builder#findAndAddModules()} return builder.
   *   <li>Then return size is four.
   * </ul>
   *
   * <p>Method under test: {@link AbstractJsonDataLoader#getInput(String, ReportDataItem, URL)}
   */
  @Test
  @DisplayName(
      "Test getInput(String, ReportDataItem, URL); given Builder findAndAddModules() return builder; then return size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object AbstractJsonDataLoader.getInput(String, ReportDataItem, URL)"})
  void testGetInput_givenBuilderFindAndAddModulesReturnBuilder_thenReturnSizeIsFour()
      throws ClassNotFoundException, MalformedURLException {
    // Arrange
    ByteArrayClassLoader classLoader = mock(ByteArrayClassLoader.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(classLoader.loadClass(Mockito.<String>any())).thenReturn(forNameResult);

    Builder builder = mock(Builder.class);
    when(builder.findAndAddModules()).thenReturn(JsonMapper.builder());
    JsonMapper rosettaObjectMapper = builder.findAndAddModules().build();
    URL descriptorPath =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    JsonLookupDataLoader jsonLookupDataLoader =
        new JsonLookupDataLoader(
            classLoader, rosettaObjectMapper, descriptorPath, new ArrayList<>());

    ReportDataItem data = mock(ReportDataItem.class);
    when(data.getInput()).thenReturn(QualificationReport.SUCCESS);

    // Act
    Object actualInput =
        jsonLookupDataLoader.getInput(
            "Input Type",
            data,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());

    // Assert
    verify(builder).findAndAddModules();
    verify(data, atLeast(1)).getInput();
    verify(classLoader).loadClass("Input Type");
    assertEquals(4, ((Map<String, Object>) actualInput).size());
    Object getResult = ((Map<String, Object>) actualInput).get("results");
    assertTrue(getResult instanceof List);
    assertTrue(actualInput instanceof Map);
    assertNull(((Map<String, Object>) actualInput).get("ingestedObject"));
    assertEquals(
        0,
        ((Integer) ((Map<String, Object>) actualInput).get("qualifiableObjectsCount")).intValue());
    assertEquals(
        0,
        ((Integer) ((Map<String, Object>) actualInput).get("uniquelyQualifiedObjectsCount"))
            .intValue());
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test {@link AbstractJsonDataLoader#getInput(String, ReportDataItem, URL)}.
   *
   * <ul>
   *   <li>Given {@link ExpectedResult#ExpectedResult()}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link AbstractJsonDataLoader#getInput(String, ReportDataItem, URL)}
   */
  @Test
  @DisplayName(
      "Test getInput(String, ReportDataItem, URL); given ExpectedResult(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object AbstractJsonDataLoader.getInput(String, ReportDataItem, URL)"})
  void testGetInput_givenExpectedResult_thenReturnSizeIsOne()
      throws ClassNotFoundException, MalformedURLException {
    // Arrange
    ByteArrayClassLoader classLoader = mock(ByteArrayClassLoader.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(classLoader.loadClass(Mockito.<String>any())).thenReturn(forNameResult);
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    JsonLookupDataLoader jsonLookupDataLoader =
        new JsonLookupDataLoader(
            classLoader, rosettaObjectMapper, descriptorPath, new ArrayList<>());

    ReportDataItem data = mock(ReportDataItem.class);
    when(data.getInput()).thenReturn(new ExpectedResult());

    // Act
    Object actualInput =
        jsonLookupDataLoader.getInput(
            "Input Type",
            data,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());

    // Assert
    verify(data, atLeast(1)).getInput();
    verify(classLoader).loadClass("Input Type");
    assertTrue(actualInput instanceof Map);
    assertEquals(1, ((Map<String, Object>) actualInput).size());
    assertNull(((Map<String, Object>) actualInput).get("expectationsPerReport"));
  }

  /**
   * Test {@link AbstractJsonDataLoader#getInput(String, ReportDataItem, URL)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>When {@link ReportDataItem#ReportDataItem()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractJsonDataLoader#getInput(String, ReportDataItem, URL)}
   */
  @Test
  @DisplayName(
      "Test getInput(String, ReportDataItem, URL); given 'java.lang.Object'; when ReportDataItem(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object AbstractJsonDataLoader.getInput(String, ReportDataItem, URL)"})
  void testGetInput_givenJavaLangObject_whenReportDataItem_thenReturnNull()
      throws ClassNotFoundException, MalformedURLException {
    // Arrange
    ByteArrayClassLoader classLoader = mock(ByteArrayClassLoader.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(classLoader.loadClass(Mockito.<String>any())).thenReturn(forNameResult);
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    JsonLookupDataLoader jsonLookupDataLoader =
        new JsonLookupDataLoader(
            classLoader, rosettaObjectMapper, descriptorPath, new ArrayList<>());

    // Act
    Object actualInput =
        jsonLookupDataLoader.getInput(
            "Input Type",
            new ReportDataItem(),
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());

    // Assert
    verify(classLoader).loadClass("Input Type");
    assertNull(actualInput);
  }

  /**
   * Test {@link AbstractJsonDataLoader#getInput(String, ReportDataItem, URL)}.
   *
   * <ul>
   *   <li>Given {@link ReportDataItem#ReportDataItem()}.
   *   <li>Then return {@link ReportDataItem}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractJsonDataLoader#getInput(String, ReportDataItem, URL)}
   */
  @Test
  @DisplayName(
      "Test getInput(String, ReportDataItem, URL); given ReportDataItem(); then return ReportDataItem")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object AbstractJsonDataLoader.getInput(String, ReportDataItem, URL)"})
  void testGetInput_givenReportDataItem_thenReturnReportDataItem()
      throws ClassNotFoundException, MalformedURLException {
    // Arrange
    ByteArrayClassLoader classLoader = mock(ByteArrayClassLoader.class);
    Class<ReportDataItem> forNameResult = ReportDataItem.class;
    Mockito.<Class<?>>when(classLoader.loadClass(Mockito.<String>any())).thenReturn(forNameResult);

    Builder builder = mock(Builder.class);
    when(builder.findAndAddModules()).thenReturn(JsonMapper.builder());
    JsonMapper rosettaObjectMapper = builder.findAndAddModules().build();
    URL descriptorPath =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    JsonLookupDataLoader jsonLookupDataLoader =
        new JsonLookupDataLoader(
            classLoader, rosettaObjectMapper, descriptorPath, new ArrayList<>());

    ReportDataItem data = mock(ReportDataItem.class);
    ReportDataItem reportDataItem = new ReportDataItem();
    when(data.getInput()).thenReturn(reportDataItem);

    // Act
    Object actualInput =
        jsonLookupDataLoader.getInput(
            "Input Type",
            data,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());

    // Assert
    verify(builder).findAndAddModules();
    verify(data, atLeast(1)).getInput();
    verify(classLoader).loadClass("Input Type");
    assertTrue(actualInput instanceof ReportDataItem);
    assertEquals(reportDataItem, actualInput);
  }

  /**
   * Test {@link AbstractJsonDataLoader#getInput(String, ReportDataItem, URL)}.
   *
   * <ul>
   *   <li>Given {@link QualificationReport#SUCCESS}.
   *   <li>Then return size is four.
   * </ul>
   *
   * <p>Method under test: {@link AbstractJsonDataLoader#getInput(String, ReportDataItem, URL)}
   */
  @Test
  @DisplayName(
      "Test getInput(String, ReportDataItem, URL); given SUCCESS; then return size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object AbstractJsonDataLoader.getInput(String, ReportDataItem, URL)"})
  void testGetInput_givenSuccess_thenReturnSizeIsFour()
      throws ClassNotFoundException, MalformedURLException {
    // Arrange
    ByteArrayClassLoader classLoader = mock(ByteArrayClassLoader.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(classLoader.loadClass(Mockito.<String>any())).thenReturn(forNameResult);
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    JsonLookupDataLoader jsonLookupDataLoader =
        new JsonLookupDataLoader(
            classLoader, rosettaObjectMapper, descriptorPath, new ArrayList<>());

    ReportDataItem data = mock(ReportDataItem.class);
    when(data.getInput()).thenReturn(QualificationReport.SUCCESS);

    // Act
    Object actualInput =
        jsonLookupDataLoader.getInput(
            "Input Type",
            data,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());

    // Assert
    verify(data, atLeast(1)).getInput();
    verify(classLoader).loadClass("Input Type");
    assertEquals(4, ((Map<String, Object>) actualInput).size());
    Object getResult = ((Map<String, Object>) actualInput).get("results");
    assertTrue(getResult instanceof List);
    assertTrue(actualInput instanceof Map);
    assertNull(((Map<String, Object>) actualInput).get("ingestedObject"));
    assertEquals(
        0,
        ((Integer) ((Map<String, Object>) actualInput).get("qualifiableObjectsCount")).intValue());
    assertEquals(
        0,
        ((Integer) ((Map<String, Object>) actualInput).get("uniquelyQualifiedObjectsCount"))
            .intValue());
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test {@link AbstractJsonDataLoader#getInput(String, ReportDataItem, URL)}.
   *
   * <ul>
   *   <li>Then return {@code NON_EMPTY}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractJsonDataLoader#getInput(String, ReportDataItem, URL)}
   */
  @Test
  @DisplayName("Test getInput(String, ReportDataItem, URL); then return 'NON_EMPTY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object AbstractJsonDataLoader.getInput(String, ReportDataItem, URL)"})
  void testGetInput_thenReturnNonEmpty() throws ClassNotFoundException, MalformedURLException {
    // Arrange
    ByteArrayClassLoader classLoader = mock(ByteArrayClassLoader.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(classLoader.loadClass(Mockito.<String>any())).thenReturn(forNameResult);
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    JsonLookupDataLoader jsonLookupDataLoader =
        new JsonLookupDataLoader(
            classLoader, rosettaObjectMapper, descriptorPath, new ArrayList<>());
    ReportDataItem data =
        new ReportDataItem(
            "Name", BeanPropertyWriter.MARKER_FOR_EMPTY, BeanPropertyWriter.MARKER_FOR_EMPTY);

    // Act
    Object actualInput =
        jsonLookupDataLoader.getInput(
            "Input Type",
            data,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());

    // Assert
    verify(classLoader).loadClass("Input Type");
    assertEquals("NON_EMPTY", actualInput);
  }

  /**
   * Test {@link AbstractJsonDataLoader#getInput(String, ReportDataItem, URL)}.
   *
   * <ul>
   *   <li>Then return size is six.
   * </ul>
   *
   * <p>Method under test: {@link AbstractJsonDataLoader#getInput(String, ReportDataItem, URL)}
   */
  @Test
  @DisplayName("Test getInput(String, ReportDataItem, URL); then return size is six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object AbstractJsonDataLoader.getInput(String, ReportDataItem, URL)"})
  void testGetInput_thenReturnSizeIsSix() throws ClassNotFoundException, MalformedURLException {
    // Arrange
    ByteArrayClassLoader classLoader = mock(ByteArrayClassLoader.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(classLoader.loadClass(Mockito.<String>any())).thenReturn(forNameResult);
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    JsonLookupDataLoader jsonLookupDataLoader =
        new JsonLookupDataLoader(
            classLoader, rosettaObjectMapper, descriptorPath, new ArrayList<>());

    ReportDataItem data = mock(ReportDataItem.class);
    ProjectionDataItemExpectation projectionDataItemExpectation =
        new ProjectionDataItemExpectation("Input File", "42", "Output File", 1, true, true);
    when(data.getInput()).thenReturn(projectionDataItemExpectation);

    // Act
    Object actualInput =
        jsonLookupDataLoader.getInput(
            "Input Type",
            data,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());

    // Assert
    verify(data, atLeast(1)).getInput();
    verify(classLoader).loadClass("Input Type");
    assertTrue(actualInput instanceof Map);
    assertEquals(6, ((Map<String, Object>) actualInput).size());
    assertEquals("42", ((Map<String, Object>) actualInput).get("keyValueFile"));
    assertEquals("Input File", ((Map<String, Object>) actualInput).get("inputFile"));
    assertEquals("Output File", ((Map<String, Object>) actualInput).get("outputFile"));
    assertEquals(
        1, ((Integer) ((Map<String, Object>) actualInput).get("validationFailures")).intValue());
    assertTrue((Boolean) ((Map<String, Object>) actualInput).get("error"));
    assertTrue((Boolean) ((Map<String, Object>) actualInput).get("validXml"));
  }

  /**
   * Test {@link AbstractJsonDataLoader#getDataItem(DataSet, URL)}.
   *
   * <p>Method under test: {@link AbstractJsonDataLoader#getDataItem(DataSet, URL)}
   */
  @Test
  @DisplayName("Test getDataItem(DataSet, URL)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractJsonDataLoader.getDataItem(DataSet, URL)"})
  void testGetDataItem() throws MalformedURLException {
    // Arrange
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    JsonLookupDataLoader jsonLookupDataLoader =
        new JsonLookupDataLoader(null, rosettaObjectMapper, descriptorPath, new ArrayList<>());

    ArrayList<ReportDataItem> data = new ArrayList<>();
    data.add(new ReportDataItem());
    ArrayList<String> applicableProjections = new ArrayList<>();

    ProjectionDataSet descriptor =
        new ProjectionDataSet(
            "Data Set Name",
            "Data Set Short Name",
            "Input Type",
            applicableProjections,
            new ArrayList<>(),
            data);

    // Act and Assert
    assertEquals(
        data,
        jsonLookupDataLoader.getDataItem(
            descriptor,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
  }

  /**
   * Test {@link AbstractJsonDataLoader#getDataItem(DataSet, URL)}.
   *
   * <ul>
   *   <li>Given {@link ReportDataItem#ReportDataItem()}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractJsonDataLoader#getDataItem(DataSet, URL)}
   */
  @Test
  @DisplayName("Test getDataItem(DataSet, URL); given ReportDataItem(); then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractJsonDataLoader.getDataItem(DataSet, URL)"})
  void testGetDataItem_givenReportDataItem_thenReturnArrayList() throws MalformedURLException {
    // Arrange
    MLet classLoader = new MLet();
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    JsonLookupDataLoader jsonLookupDataLoader =
        new JsonLookupDataLoader(
            classLoader, rosettaObjectMapper, descriptorPath, new ArrayList<>());

    ArrayList<ReportDataItem> data = new ArrayList<>();
    data.add(new ReportDataItem());
    ArrayList<String> applicableProjections = new ArrayList<>();

    ProjectionDataSet descriptor =
        new ProjectionDataSet(
            "Data Set Name",
            "Data Set Short Name",
            "Input Type",
            applicableProjections,
            new ArrayList<>(),
            data);

    // Act and Assert
    assertEquals(
        data,
        jsonLookupDataLoader.getDataItem(
            descriptor,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
  }

  /**
   * Test {@link AbstractJsonDataLoader#getDataItem(DataSet, URL)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AbstractJsonDataLoader#getDataItem(DataSet, URL)}
   */
  @Test
  @DisplayName("Test getDataItem(DataSet, URL); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractJsonDataLoader.getDataItem(DataSet, URL)"})
  void testGetDataItem_thenReturnEmpty() throws MalformedURLException {
    // Arrange
    MLet classLoader = new MLet();
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    JsonLookupDataLoader jsonLookupDataLoader =
        new JsonLookupDataLoader(
            classLoader, rosettaObjectMapper, descriptorPath, new ArrayList<>());
    ArrayList<String> applicableProjections = new ArrayList<>();
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    ProjectionDataSet descriptor =
        new ProjectionDataSet(
            "Data Set Name",
            "Data Set Short Name",
            "Input Type",
            applicableProjections,
            applicableReports,
            new ArrayList<>());

    // Act and Assert
    assertTrue(
        jsonLookupDataLoader
            .getDataItem(
                descriptor,
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL())
            .isEmpty());
  }
}
