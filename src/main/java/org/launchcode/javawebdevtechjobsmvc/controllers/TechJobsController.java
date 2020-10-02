package org.launchcode.javawebdevtechjobsmvc.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;

public class TechJobsController {

    static HashMap<String, String> actionChoices = new HashMap<>();
    static HashMap<String, String> columnChoices = new HashMap<>();


    public TechJobsController() {
        actionChoices.put("search", "Search");
        actionChoices.put("list", "List");

        columnChoices.put("all", "All");
        columnChoices.put("employer", "Employer");
        columnChoices.put("location", "Location");
        columnChoices.put("positionType", "Position Type");
        columnChoices.put("coreCompetency", "Skill");
    }

    @ModelAttribute("actions")
    static HashMap getActionChoices() {
        return actionChoices;
    }

    @ModelAttribute("columns")
    static HashMap getColumnChoices() {
        return columnChoices;
    }

}
