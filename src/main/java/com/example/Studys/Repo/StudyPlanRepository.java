package com.example.Studys.Repo;

import com.example.Studys.Models.StudyPlan;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudyPlanRepository {
    private static final Map<Integer, StudyPlan> STUDY_PLAN_MAP = new HashMap<>();

    public void add(StudyPlan studyPlan) {
        Integer id = studyPlan.getId(); //взяли из модели Id
        STUDY_PLAN_MAP.put(id, studyPlan);
    }

    public StudyPlan read(Integer id){
        return STUDY_PLAN_MAP.get(id);
    }

    public List<StudyPlan> readAll() {
        return new ArrayList<>(STUDY_PLAN_MAP.values());
    }

    public void update(Integer id, StudyPlan studyPlan){
        STUDY_PLAN_MAP.put(id, studyPlan);
    }

    public void delete(Integer id){
        STUDY_PLAN_MAP.remove(id);
    }
}
