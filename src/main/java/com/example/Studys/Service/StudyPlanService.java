package com.example.Studys.Service;

import com.example.Studys.Models.StudyPlan;
import com.example.Studys.Repo.StudyPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudyPlanService {
    public static StudyPlanRepository STUDY_PLAN_REPOSITORY;
    public static AtomicInteger ID_HOLDER;

    @Autowired
    public StudyPlanService(StudyPlanRepository studyPlanRepository){
        STUDY_PLAN_REPOSITORY = studyPlanRepository;
        List<StudyPlan> studyPlanList = STUDY_PLAN_REPOSITORY.readAll();
        Integer maxId = 0;
        for (StudyPlan studyPlan : studyPlanList) {
            if (studyPlan.getId() > maxId) {
                maxId = studyPlan.getId();
            }
        }
        ID_HOLDER = new AtomicInteger(maxId);
    }

    public void add(StudyPlan studyPlan){
        Integer id = ID_HOLDER.incrementAndGet();
        studyPlan.setId(id);
        STUDY_PLAN_REPOSITORY.add(studyPlan);
    }

    public StudyPlan read(Integer id){
        return STUDY_PLAN_REPOSITORY.read(id);
    }

    public List<StudyPlan> readAll() {
        return STUDY_PLAN_REPOSITORY.readAll();
    }

    public void update(Integer id, StudyPlan studyPlan){
        STUDY_PLAN_REPOSITORY.update(id, studyPlan);
    }

    public void delete(Integer id){
        STUDY_PLAN_REPOSITORY.delete(id);
    }
}
