package com.vpusher.services;

import com.vpusher.domains.Block;
import com.vpusher.domains.Project;
import com.vpusher.domains.User;
import com.vpusher.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by f2i on 4/5/17.
 */
@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project get(Long id) {
        return this.projectRepository.findOne(id);
    }

    public Project get(String uid) {
        return this.projectRepository.findByUid(uid);
    }

    public Project getWithWires(Long id) {
        return this.projectRepository.findOne(id, 2);
    }

    public Iterable<Project> all() {
        return this.projectRepository.findAll();
    }

    public void update(Project project) {
        this.projectRepository.save(project);
    }

    public void delete(Project project) {
        this.projectRepository.delete(project);
    }

    public void clean() {
        this.projectRepository.deleteAll();
    }

    public void addMembers(Project project, User... users) {
        project.getMembers().addAll(Arrays.asList(users));
        this.projectRepository.save(project);
    }

    public void addBlocks(Project project, Block... blocks) {
        project.getBlocks().addAll(Arrays.asList(blocks));
        this.projectRepository.save(project);
    }

}
