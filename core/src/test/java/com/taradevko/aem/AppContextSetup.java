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
package com.taradevko.aem;

import io.wcm.testing.mock.aem.junit.AemContext;
import io.wcm.testing.mock.aem.junit.AemContextCallback;
import org.apache.sling.api.resource.Resource;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class AppContextSetup implements AemContextCallback, TestRule {

    private Class testClass;

    @Override
    public void execute(final AemContext aemContext) throws Exception {
        aemContext.addModelsForPackage("com.taradevko.aem");

        final Resource content = aemContext.load().json(
                String.format("/%s/%s.json", testClass.getPackage().getName(), testClass.getSimpleName()), "/content");
        aemContext.currentResource(content);
    }

    @Override
    public Statement apply(final Statement base, final Description description) {
        testClass = description.getTestClass();
        return base;
    }
}
