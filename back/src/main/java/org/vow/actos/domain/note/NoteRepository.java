package org.vow.actos.domain.note;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "notes", path = "notes", excerptProjection = NoteRepository.NoteView.class)
public interface NoteRepository
        extends JpaRepository<Note, Long> {

    @Projection(name = "noteView", types = { Note.class })
    interface NoteView {
        String getTitle();
        String getContent();
        @Value("#{target.tags.![value]}")
        List<String> getTags();
        @Value("#{target.annotations.![text]}")
        List<String> getAnnotations();
    }
}
