package org.vow.actos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.vow.actos.domain.activity.Activity;
import org.vow.actos.domain.activity.ActivityRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/activities")
public class ActivityController {

    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityController(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @GetMapping
    public List<Activity> get() {
        return activityRepository.findAll();
    }

    @GetMapping("/{activityId}")
    public Activity get(@PathVariable("activityId") long id) {
        Optional<Activity> byId = activityRepository.findById(id);
        return byId.get();
    }

    @PostMapping
    public void add(@RequestBody ActivityCreationRequest creationRequest) {
        activityRepository.save(creationRequest.get());
    }

    static class ActivityCreationRequest {
        public String name;
        public Activity get() {
            Activity activity = new Activity();
            activity.setName(name);
            return activity;
        }
    }
}
