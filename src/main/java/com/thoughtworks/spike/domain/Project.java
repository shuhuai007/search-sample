package com.thoughtworks.spike.domain;

/**
 * Created by jiezhou on 21/02/2017.
 */
public class Project {
    private String name;
    private String desc;
    private String duration;
    private String workPattern;
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

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("<br><br>").append("Project Name: ").append(name).append("<br><br>")
                .append("Project Description: ").append(desc).append("<br><br>")
                .append("Project Duration: ").append(duration).append("<br><br>")
                .append("Project work pattern: ").append(workPattern).append("<br><br>")
                .append("Project deployment location: ").append(deployLocation);
        return info.toString();
    }

}
