package com.hibernate.web.controller;

import com.hibernate.persistence.model.Project;
import com.hibernate.persistence.model.Task;
import com.hibernate.service.IProjectService;
import com.hibernate.web.dto.ProjectDto;
import com.hibernate.web.dto.TaskDto;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    private IProjectService projectService;

    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }

    //

    @GetMapping(value = "/{id}")
    public ProjectDto findOne(@PathVariable Long id) {
        Project entity = projectService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return convertToDto(entity);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectDto create(@RequestBody ProjectDto newProject) {
        Project entity = convertToEntity(newProject);
        entity.setDateCreated(LocalDate.now());
        return this.convertToDto(this.projectService.save(entity));
    }

    @GetMapping
    public Collection<ProjectDto> findAll() {
        Iterable<Project> allProjects = this.projectService.findAll();
        List<ProjectDto> projectDtos = new ArrayList<>();
        allProjects.forEach(p -> projectDtos.add(convertToDto(p)));
        return projectDtos;
    }

    @GetMapping("/by-name")
    public Collection<ProjectDto> findProjects(@RequestParam(name = "name", defaultValue = "") String name) {
        Iterable<Project> allProjects = this.projectService.findByName(name);
        List<ProjectDto> projectDtos = new ArrayList<>();
        allProjects.forEach(p -> projectDtos.add(convertToDto(p)));
        return projectDtos;
    }

    @PutMapping("/{id}")
    public ProjectDto updateProject(@PathVariable("id") Long id, @RequestBody ProjectDto updatedProject) {
        Project projectEntity = convertToEntity(updatedProject);
        return this.convertToDto(this.projectService.save(projectEntity));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable("id") Long id) {
        projectService.delete(id);
    }

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