package org.launchcode.javawebdevtechjobsmvc.controllers;

import org.launchcode.javawebdevtechjobsmvc.models.Job;
import org.launchcode.javawebdevtechjobsmvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.launchcode.javawebdevtechjobsmvc.controllers.ListController.columnChoices;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController extends TechJobsController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    @RequestMapping(value = "results")
    public String displaySearchResults(Model model,
                                @RequestParam(required = false) String searchType,
                                @RequestParam(required = false) String searchTerm) {
        ArrayList<Job> jobs;

        if (searchTerm == null) {
            jobs = JobData.findByColumnAndValue("all", "all");
            model.addAttribute("title", "Jobs with: " + columnChoices.get(searchType));
        } else if (searchType == null) {
            jobs = JobData.findByColumnAndValue("all", searchTerm);
            model.addAttribute("title", "Jobs with: " + searchTerm);
        } else {
            jobs = JobData.findByColumnAndValue(searchType, searchTerm);
            model.addAttribute("title", "Jobs with " + columnChoices.get(searchType) + ": " + searchTerm);
        }

        model.addAttribute("jobs", jobs);
        model.addAttribute("columns", columnChoices);
        model.addAttribute("searchType", searchType);
        model.addAttribute("searchTerm", searchTerm);

        return "search";
    }
}
