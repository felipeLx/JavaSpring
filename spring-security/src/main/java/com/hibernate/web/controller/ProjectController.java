package com.hibernate.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.hibernate.events.ProjectCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hibernate.persistence.model.Project;
import com.hibernate.persistence.model.Task;
import com.hibernate.service.IProjectService;
import com.hibernate.web.dto.ProjectDto;
import com.hibernate.web.dto.TaskDto;

@Controller
@RequestMapping(value = "/projects")
public class ProjectController {

    private IProjectService projectService;

    @Autowired
    public ApplicationEventPublisher publisher;

    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public String getProjects(Model model) {
        Iterable<Project> projects = projectService.findAll();
        List<ProjectDto> projectDtos = new ArrayList<>();
        projects.forEach(p -> projectDtos.add(convertToDto(p)));
        model.addAttribute("projects", projectDtos);
        return "projects";
    }

    @GetMapping("/new")
    public String newProject(Model model) {
        model.addAttribute("project", new ProjectDto());
        return "new-project";
    }

    @PostMapping
    public String addProject(ProjectDto project) {
        Project newProject = projectService.save(convertToEntity(project));

        publisher.publishEvent(new ProjectCreatedEvent(newProject.getId()));
        return "redirect:/projects";
    }

    //

    protected ProjectDto convertToDto(Project entity) {
        ProjectDto dto = new ProjectDto(entity.getId(), entity.getName(), entity.getDateCreated());
        dto.setTasks(entity.getTasks()
                .stream()
                .map(t -> convertTaskToDto(t))
                .collect(Collectors.toSet()));
        return dto;
    }

    protected Project convertToEntity(ProjectDto dto) {
        Project project = new Project(dto.getName(), dto.getDateCreated());
        if (!StringUtils.isEmpty(dto.getId())) {
            project.setId(dto.getId());
        }
        return project;
    }

    protected TaskDto convertTaskToDto(Task entity) {
        TaskDto dto = new TaskDto(entity.getId(), entity.getName(), entity.getDescription(), entity.getDateCreated(), entity.getDueDate(), entity.getStatus());
        return dto;
    }

    protected Task convertTaskToEntity(TaskDto dto) {
        Task task = new Task(dto.getName(), dto.getDescription(), dto.getDateCreated(), dto.getDueDate(), dto.getStatus());
        if (!StringUtils.isEmpty(dto.getId())) {
            task.setId(dto.getId());
        }
        return task;
    }

}