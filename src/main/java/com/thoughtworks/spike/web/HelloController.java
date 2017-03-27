package com.thoughtworks.spike.web;

import com.thoughtworks.spike.domain.DevCloudProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private DevCloudProperties devCloudProperties;

    @RequestMapping("/hello")
    public String good() {
        return "Hello World";
    }

    @RequestMapping("/devcloud")
    public String readConfig() {
        StringBuilder info = new StringBuilder();
        info.append("<br><br>").append("Project Name: ").append(devCloudProperties.getName()).append("<br><br>")
                .append("Project Description: ").append(devCloudProperties.getDesc()).append("<br><br>")
                .append("Project Duration: ").append(devCloudProperties.getDuration()).append("<br><br>")
                .append("Project work pattern: ").append(devCloudProperties.getWorkPattern()).append("<br><br>")
                .append("Project deployment location: ").append(devCloudProperties.getDeployLocation());
        return info.toString();
    }

}
