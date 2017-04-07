package com.vpusher.controllers;

import com.vpusher.domains.Block;
import com.vpusher.services.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

/**
 * Created by vpusher on 4/6/17.
 */

@Controller
public class IndexContoller {

    private ProjectService projectService;

    public IndexContoller(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping(path = "/")
    public String index(HttpServletRequest request, Model model) {

        Set<Block> blocks = projectService.get("project1").getBlocks();

        model.addAttribute("blocks", blocks);

        return "index";
    }

}
