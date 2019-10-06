package org.vow.actos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.vow.actos.domain.annotation.Annotation;
import org.vow.actos.domain.annotation.AnnotationRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/annotations")
public class AnnotationController {

    private final AnnotationRepository annotationRepository;

    @Autowired
    public AnnotationController(AnnotationRepository annotationRepository) {
        this.annotationRepository = annotationRepository;
    }

    @GetMapping
    public List<Annotation> get() {
        return annotationRepository.findAll();
    }

    @GetMapping("/{annotationId}")
    public Annotation get(@PathVariable("annotationId") long id) {
        Optional<Annotation> byId = annotationRepository.findById(id);
        return byId.get();
    }

    @PostMapping
    public void add(@RequestBody AnnotationCreationRequest creationRequest) {
        annotationRepository.save(creationRequest.get());
    }

    static class AnnotationCreationRequest {
        public String annotation;
        public Annotation get() {
            return Annotation.annotation().text(annotation).build();
        }
    }
}
