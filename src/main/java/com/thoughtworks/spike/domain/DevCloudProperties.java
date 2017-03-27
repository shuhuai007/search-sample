package com.thoughtworks.spike.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
//@ConfigurationProperties(prefix="com.thoughtworks.devcloud")
public class DevCloudProperties {

    @Value("${com.thoughtworks.devcloud.name}")
    private String name;
    @Value("${com.thoughtworks.devcloud.desc}")
    private String desc;
   @Value("${com.thoughtworks.devcloud.duration}")
    private String duration;
    @Value("${com.thoughtworks.devcloud.workPattern}")
    private String workPattern;

    @Value("${devcloud.deployLocation}")
    private String deployLocation;

    public String getWorkPattern() {
        return workPattern;
    }

    public void setWorkPattern(String workPattern) {
        this.workPattern = workPattern;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDeployLocation() {
        return deployLocation;
    }

    public void setDeployLocation(String deployLocation) {
        this.deployLocation = deployLocation;
    }
}
