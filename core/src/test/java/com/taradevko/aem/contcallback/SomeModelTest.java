/*
   Copyright 2018 Oleksandr Tarasenko

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package com.taradevko.aem.contcallback;

import com.taradevko.aem.AppContextSetup;
import io.wcm.testing.mock.aem.junit.AemContext;
import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class SomeModelTest {

    @Rule
    public final AppContextSetup appContextSetup = new AppContextSetup();

    @Rule
    public AemContext aemContext = new AemContext(appContextSetup, ResourceResolverType.RESOURCERESOLVER_MOCK);

    @Test
    public void demoTest() {
        final SomeModel someModel = aemContext.currentResource().adaptTo(SomeModel.class);
        assertEquals("Should contain value from json", someModel.doSmthWithProperty(), "JSONPROP1VALUE");
    }
}