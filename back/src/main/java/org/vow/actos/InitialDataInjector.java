package org.vow.actos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.vow.actos.domain.activity.ActivityRepository;
import org.vow.actos.domain.annotation.Annotation;
import org.vow.actos.domain.annotation.AnnotationRepository;
import org.vow.actos.domain.note.NoteRepository;
import org.vow.actos.domain.tag.Tag;
import org.vow.actos.domain.tag.TagRepository;

import static org.vow.actos.domain.note.Note.note;

@Component
public class InitialDataInjector implements CommandLineRunner {

    private final ActivityRepository activityRepository;
    private final TagRepository tagRepository;
    private final NoteRepository noteRepository;
    private final AnnotationRepository annotationRepository;

    @Autowired
    public InitialDataInjector(
            ActivityRepository activityRepository,
            TagRepository tagRepository,
            NoteRepository noteRepository,
            AnnotationRepository annotationRepository
    ) {
        this.activityRepository = activityRepository;
        this.tagRepository = tagRepository;
        this.noteRepository = noteRepository;
        this.annotationRepository = annotationRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        tagRepository.save(new Tag("Urgent"));
        tagRepository.save(new Tag("Travail"));
        tagRepository.save(new Tag("Privé"));

        Tag aTag = tagRepository.save(new Tag("Personnel"));

        noteRepository.save(note()
                .title("Ma Note")
                .content("Ceci est une note.")
                .tag(aTag)
                .annotation(new Annotation("une annotation"))
                .build());
    }
}
