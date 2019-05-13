package org.vow.actos.activity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/activities")
@RestController
public class ActivityController {

    @GetMapping("/{activityId}")
    public Activity get(@PathVariable("activityId") String id) {
        Activity activity = new Activity();
        activity.id = id;
        activity.name = "Activity " + id;
        return activity;
    }

    static class Activity {
        public String id;
        public String name;
    }
}
