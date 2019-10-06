package org.vow.actos.domain.tag;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.vow.actos.domain.note.Note;

import javax.persistence.*;
import java.util.Collection;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Tag {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String value;
    @ManyToMany(mappedBy="tags")
    private Collection<Note> notes ;
    public Tag(String value) {
        this.value = value;
    }
    public static Builder tag() {
        return new Builder();
    }
    public static class Builder {
        private String value;
        public Builder value(String value) {
            this.value = value;
            return this;
        }
        public Tag build() {
            Tag tag = new Tag();
            tag.setValue(value);
            return tag;
        }
    }
}
