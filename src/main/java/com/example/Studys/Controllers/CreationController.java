package com.example.Studys.Controllers;

import com.example.Studys.Models.StudyPlan;
import com.example.Studys.Service.StudyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller //вызывает страницу
public class CreationController {

    private final StudyPlanService studyPlanService;

    @Autowired
    public CreationController(StudyPlanService studyPlanService){
        this.studyPlanService = studyPlanService;
    }

    @GetMapping("/")
    public String readAll(Model model) {
        List<StudyPlan> studyPlanList = studyPlanService.readAll();
        model.addAttribute("studyPlanList", studyPlanList);
        return "creation";
    }

    @GetMapping("/studyPlans/{id}")
    public String read(@PathVariable(name="id") Integer id, Model model){
        StudyPlan studyPlan = studyPlanService.read(id);
        model.addAttribute("studyPlan", studyPlan);
        return "creation"; // вторая страница
    }

    @PostMapping("/studyPlans/creation")
    public String add(@RequestBody StudyPlan studyPlan){
        studyPlanService.add(studyPlan);
        return "redirect:/";
    }

    @PutMapping("/studyPlans/{id}/update")
    public String update(@PathVariable(name="id") Integer id, @RequestBody StudyPlan studyPlan) {
        studyPlanService.update(id, studyPlan);
        return String.format("redirect:/studyPlans/%s", id);
    }

    @DeleteMapping("/studyPlans/{id}/delete")
    public String delete(@PathVariable(name="id") Integer id){
        studyPlanService.delete(id);
        return "redirect:/";
    }


}