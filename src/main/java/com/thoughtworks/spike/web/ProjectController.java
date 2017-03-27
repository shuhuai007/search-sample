package com.thoughtworks.spike.web;

import com.thoughtworks.spike.domain.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping(value="/projects")
public class ProjectController {

    private static Map<String, Project> projectMap = new ConcurrentHashMap<String, Project>();
    static {
        Project p = new Project();
        String name = "GoCD";
        p.setName(name);
        p.setDesc("This is the internal project in TW");
        p.setDuration("It depends");
        p.setDeployLocation("TW's office");
        p.setWorkPattern("Whatever");
        projectMap.putIfAbsent(name, p);
    }

    @RequestMapping(value="/", method= RequestMethod.GET)
    public List<Project> getProjectList() {
        List<Project> projectList = new ArrayList<Project>(projectMap.values());
        return projectList;
    }

    @RequestMapping(value="/", method= RequestMethod.POST)
    public String addProject(@ModelAttribute Project project ) {
        projectMap.putIfAbsent(project.getName(), project);
        return "success";
    }

    @RequestMapping(value="/{name}", method=RequestMethod.GET)
    public Project getProject(@PathVariable String name) {
        System.out.println("Enter getProject...");
        System.out.println("name: " + name);
        return projectMap.get(name);
    }

    @RequestMapping(value="/{name}", method=RequestMethod.PUT)
    public String putProject(@PathVariable String name, @ModelAttribute Project project) {
        // 处理"/projects/{name}"的PUT请求，用来更新Project信息
        Project cacheProject = projectMap.get(name);
        cacheProject.setName(project.getName());
        cacheProject.setDesc(project.getDesc());
        projectMap.put(name, cacheProject);
        return "success";
    }

}
