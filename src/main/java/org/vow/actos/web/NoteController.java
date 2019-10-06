package org.vow.actos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.vow.actos.domain.annotation.Annotation;
import org.vow.actos.domain.note.Note;
import org.vow.actos.domain.note.NoteRepository;
import org.vow.actos.domain.tag.Tag;
import org.vow.actos.domain.tag.TagRepository;

import java.util.List;
import java.util.Optional;

import static org.vow.actos.domain.note.Note.note;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {

    private final NoteRepository noteRepository;
    private final TagRepository tagRepository;

    @Autowired
    public NoteController(NoteRepository noteRepository, TagRepository tagRepository) {
        this.noteRepository = noteRepository;
        this.tagRepository = tagRepository;
    }

    @GetMapping
    public List<Note> get() {
        return noteRepository.findAll();
    }

    @GetMapping("/{noteId}")
    public Note get(@PathVariable("noteId") long id) {
        Optional<Note> byId = noteRepository.findById(id);
        return byId.get();
    }

    @PostMapping
    public void add(@RequestBody NoteCreationRequest creationRequest) {
        noteRepository.save(
                note()
                        .title(creationRequest.title)
                        .content(creationRequest.content)
                        .tag(tagRepository.findByValue(creationRequest.tag)
                                .orElse(new Tag(creationRequest.tag)))
                        .annotation(new Annotation(creationRequest.annotation))
                        .build()
        );
    }

    static class NoteCreationRequest {
        public String title;
        public String content;
        public String tag;
        public String annotation;

        public Note get() {
            return note().title(title).content(content).build();
        }
    }
}
