/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
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
package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.AssertUtil;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author Eric Zhao
 * @since 1.4.0
 */

public class AbstractRuleNacosPublisher<T> implements DynamicRulePublisher<List<T>> {

    private ConfigService configService;
    private Converter<List<T>, String> converter;
    private String dataIdSuffix;
    private String groupId;

    public AbstractRuleNacosPublisher(ConfigService configService, Converter<List<T>, String> converter, String groupId,String dataIdSuffix) {
        Assert.notNull(configService,"configService is null,build nacos publisher failed!");
        Assert.notNull(converter,"converter is null,build nacos publisher failed!");
        Assert.hasText(groupId,"groupId is null,build nacos publisher failed!");
        Assert.hasText(dataIdSuffix,"dataIdSuffix is null,build nacos publisher failed!");


        this.configService = configService;
        this.converter = converter;
        this.dataIdSuffix = dataIdSuffix;
        this.groupId = groupId;
    }

    @Override
    public void publish(String app, List<T> rules) throws Exception {
        AssertUtil.notEmpty(app, "app name cannot be empty");
        if (rules == null) {
            return;
        }
        configService.publishConfig(app + dataIdSuffix,
                groupId, converter.convert(rules));
    }
}
