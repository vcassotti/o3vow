package org.vow.actos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.vow.actos.domain.tag.Tag;
import org.vow.actos.domain.tag.TagRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tags")
public class TagController {

    private final TagRepository tagRepository;

    @Autowired
    public TagController(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @GetMapping
    public List<Tag> get() {
        return tagRepository.findAll();
    }

    @GetMapping("/{tagId}")
    public Tag get(@PathVariable("tagId") long id) {
        Optional<Tag> byId = tagRepository.findById(id);
        return byId.get();
    }

    @PostMapping
    public void add(@RequestBody TagCreationRequest createionRequest) {
        tagRepository.save(createionRequest.get());
    }

    static class TagCreationRequest {
        public String tag;
        public Tag get() {
            return Tag.tag().value(tag).build();
        }
    }
}
