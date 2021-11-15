package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author:TangFenQi
 * @Date:2021/11/14 13:08
 **/
@Component
@ConfigurationProperties(prefix = "spring.cloud.sentinel.adapter.nacos")
public class NacosConfiguration {

    private String address;//nacos的地址
    private String flowRuleDataIdSuffix="_FLOW_SENTINEL_DATA";//将flow规则的sentinel数据保存到nacos的dataId后缀
    private String paramRuleDataIdSuffix="_PARAM_SENTINEL_DATA";//将param规则的sentinel数据保存到nacos的dataId后缀
    private String degradeRuleDataIdSuffix="_DEGRADE_SENTINEL_DATA";//将degrade规则的sentinel数据保存到nacos的dataId后缀
    private String groupId="SENTINEL_CONFIG";//nacos上的分组信息
    private String namespace="dev";//nacos上的命名空间，指定某个环境

    public String getAddress() {
        return address;
    }

    public String getFlowRuleDataIdSuffix() {
        return flowRuleDataIdSuffix;
    }

    public String getParamRuleDataIdSuffix() {
        return paramRuleDataIdSuffix;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFlowRuleDataIdSuffix(String flowRuleDataIdSuffix) {
        this.flowRuleDataIdSuffix = flowRuleDataIdSuffix;
    }

    public void setParamRuleDataIdSuffix(String paramRuleDataIdSuffix) {
        this.paramRuleDataIdSuffix = paramRuleDataIdSuffix;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getDegradeRuleDataIdSuffix() {
        return degradeRuleDataIdSuffix;
    }

    public void setDegradeRuleDataIdSuffix(String degradeRuleDataIdSuffix) {
        this.degradeRuleDataIdSuffix = degradeRuleDataIdSuffix;
    }
}
