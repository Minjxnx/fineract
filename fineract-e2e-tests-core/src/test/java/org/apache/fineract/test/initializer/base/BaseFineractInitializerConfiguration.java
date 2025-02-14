/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.fineract.test.initializer.base;

import java.util.List;
import org.apache.fineract.test.config.CacheConfiguration;
import org.apache.fineract.test.helper.BusinessDateHelper;
import org.apache.fineract.test.helper.WorkFlowJobHelper;
import org.apache.fineract.test.initializer.global.FineractGlobalInitializerStep;
import org.apache.fineract.test.initializer.scenario.FineractScenarioInitializerStep;
import org.apache.fineract.test.initializer.suite.FineractSuiteInitializerStep;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({ "org.apache.fineract.test.api", "org.apache.fineract.test.helper" })
@PropertySource("classpath:fineract-test-application.properties")
@Import({ CacheConfiguration.class })
public class BaseFineractInitializerConfiguration {

    @Bean
    public FineractInitializer fineractInitializer(List<FineractGlobalInitializerStep> globalInitializerSteps,
            List<FineractSuiteInitializerStep> suiteInitializerSteps, List<FineractScenarioInitializerStep> scenarioInitializerSteps,
            BusinessDateHelper businessDateHelper, WorkFlowJobHelper workFlowJobHelper) {
        return new FineractInitializer(globalInitializerSteps, suiteInitializerSteps, scenarioInitializerSteps, businessDateHelper,
                workFlowJobHelper);
    }
}
