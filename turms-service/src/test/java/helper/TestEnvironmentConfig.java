/*
 * Copyright (C) 2019 The Turms Project
 * https://github.com/turms-im/turms
 *
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
 */

package helper;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import im.turms.server.common.infra.property.TurmsProperties;
import im.turms.server.common.infra.property.TurmsPropertiesManager;
import im.turms.server.common.infra.property.env.service.ServiceProperties;
import im.turms.server.common.infra.property.env.service.env.database.MongoProperties;
import im.turms.server.common.infra.property.env.service.env.elasticsearch.ElasticsearchClientProperties;
import im.turms.server.common.infra.property.env.service.env.elasticsearch.ElasticsearchUseCasesProperties;
import im.turms.server.common.infra.property.env.service.env.elasticsearch.TurmsElasticsearchProperties;
import im.turms.server.common.infra.property.env.service.env.redis.TurmsRedisProperties;
import im.turms.server.common.testing.BaseIntegrationTest;
import im.turms.server.common.testing.environment.TestEnvironmentManager;
import im.turms.server.common.testing.properties.TestProperties;

/**
 * @author James Chen
 */
@Slf4j
public class TestEnvironmentConfig {

    public TestEnvironmentConfig(
            TurmsPropertiesManager propertiesManager,
            TestProperties testProperties) {
        TestEnvironmentManager testEnvironmentManager =
                BaseIntegrationTest.setupTestEnvironment(testProperties);
        configureTestEnvironmentProperties(propertiesManager, testEnvironmentManager);
    }

    private void configureTestEnvironmentProperties(
            TurmsPropertiesManager propertiesManager,
            TestEnvironmentManager testEnvironmentManager) {
        TurmsProperties localProperties = propertiesManager.getLocalProperties();
        ServiceProperties serviceProperties = localProperties.getService();

        String elasticsearchUri = testEnvironmentManager.getElasticsearchUri();
        String mongoUri = testEnvironmentManager.getMongoUri();
        String redisUri = testEnvironmentManager.getRedisUri();

        // Cluster
        localProperties.getCluster()
                .getSharedConfig()
                .getMongo()
                .setUri(mongoUri);

        // Elasticsearch
        TurmsElasticsearchProperties elasticsearchProperties = serviceProperties.getElasticsearch();
        ElasticsearchUseCasesProperties useCasesProperties = elasticsearchProperties.getUseCase();
        ElasticsearchClientProperties elasticsearchClientProperties =
                ElasticsearchClientProperties.builder()
                        .uri(elasticsearchUri)
                        .build();
        useCasesProperties.getUser()
                .setClient(elasticsearchClientProperties);
        useCasesProperties.getGroup()
                .setClient(elasticsearchClientProperties);

        // Mongo
        MongoProperties mongoProperties = serviceProperties.getMongo();
        mongoProperties.getAdmin()
                .setUri(mongoUri);
        mongoProperties.getUser()
                .setUri(mongoUri);
        mongoProperties.getGroup()
                .setUri(mongoUri);
        mongoProperties.getConversation()
                .setUri(mongoUri);
        mongoProperties.getMessage()
                .setUri(mongoUri);

        // Redis
        TurmsRedisProperties redisProperties = serviceProperties.getRedis();
        List<String> redisUris = List.of(redisUri);
        redisProperties.getSequenceId()
                .setUriList(redisUris);
        redisProperties.getSession()
                .setUriList(redisUris);
        redisProperties.getLocation()
                .setUriList(redisUris);
        redisProperties.getIpBlocklist()
                .setUri(redisUri);
        redisProperties.getUserIdBlocklist()
                .setUri(redisUri);
    }

}