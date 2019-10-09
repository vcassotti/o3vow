package org.vow.actos.pwa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.vow.actos.pwa.Configuration.configuration;
import static org.vow.actos.pwa.Configuration.route;

@RestController
@RequestMapping("/api/v1/pwa")
public class PwaController {
    @GetMapping("/configuration")
    public Configuration getConfiguration() {
        return configuration()
                .with(route("/"))
                .with(route("/about"))
                .build();
    }
}
