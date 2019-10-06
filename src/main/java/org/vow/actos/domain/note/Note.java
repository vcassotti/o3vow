package org.vow.actos.domain.note;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.vow.actos.domain.annotation.Annotation;
import org.vow.actos.domain.tag.Tag;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String title;

    private String content;

    @OneToMany(mappedBy = "note"
            // , cascade = CascadeType.ALL, orphanRemoval = true
    )
    private Collection<Annotation> annotations = new ArrayList<>();

    @ManyToMany(
            // cascade = CascadeType.ALL
    )
    private Collection<Tag> tags = new ArrayList<>();

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static Builder note() {
        return new Builder();
    }
    public static class Builder {
        private String title;
        private String content;
        private List<Tag> tags = new ArrayList<>();
        private List<Annotation> annotations= new ArrayList<>();
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder content(String content) {
            this.content = content;
            return this;
        }
        public Builder tag(Tag tag) {
            this.tags.add(tag);
            return this;
        }
        public Builder annotation(Annotation annotation) {
            this.annotations.add(annotation);
            return this;
        }
        public Note build() {
            Note note = new Note();
            note.setTitle(title);
            note.setContent(content);
            note.setTags(tags);
            note.setAnnotations(annotations);
            return note;
        }
    }
}
