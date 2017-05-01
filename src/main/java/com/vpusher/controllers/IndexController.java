package com.vpusher.controllers;

import com.vpusher.domains.Block;
import com.vpusher.domains.Project;
import com.vpusher.domains.Wire;
import com.vpusher.services.BlockService;
import com.vpusher.services.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by vpusher on 4/6/17.
 */

@Controller
public class IndexController {

    private ProjectService projectService;

    private BlockService blockService;

    public IndexController(ProjectService projectService, BlockService blockService) {
        this.projectService = projectService;
        this.blockService = blockService;
    }

    @GetMapping(path = "/{uid}")
    public String getProject(@PathVariable String uid, Model model) {

        Project project = projectService.get(uid);
        Set<Block> blocks = projectService.getWithWires(project.getId()).getBlocks();

        Set wires = blocks.stream()
            .map(Block::getWires)
            .flatMap(Set::stream)
            .collect(Collectors.toSet());

        model.addAttribute("project", project);
        model.addAttribute("blocks", blocks);
        model.addAttribute("wires", wires);

        return "index";
    }

    @GetMapping(path = "/new")
    public String getProject() {

        Project project = new Project();
        projectService.update(project);

        return String.format("redirect:%s", project.getUid());
    }

}
