package com.regnosys.rosetta.common.serialisation.xml;

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
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import org.junit.Test;

public class VirtualXMLAttributeDiffblueTest {
  /**
   * Method under test:
   * {@link VirtualXMLAttribute#VirtualXMLAttribute(Class, String, JavaType)}
   */
  @Test
  public void testNewVirtualXMLAttribute() {
    // Arrange
    Class<Object> declaringClass = Object.class;
    PlaceholderForType type = new PlaceholderForType(1);

    // Act
    VirtualXMLAttribute actualVirtualXMLAttribute = new VirtualXMLAttribute(declaringClass, "Name", type);

    // Assert
    assertEquals("Name", actualVirtualXMLAttribute.getName());
    assertNull(actualVirtualXMLAttribute.getAllAnnotations());
    assertNull(actualVirtualXMLAttribute.getTypeContext());
    Class<Object> expectedDeclaringClass = Object.class;
    Class<?> declaringClass2 = actualVirtualXMLAttribute.getDeclaringClass();
    assertEquals(expectedDeclaringClass, declaringClass2);
    assertSame(type, actualVirtualXMLAttribute.getType());
    assertSame(declaringClass, declaringClass2);
  }
}
