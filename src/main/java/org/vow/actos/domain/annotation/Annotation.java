package org.vow.actos.domain.annotation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.vow.actos.domain.note.Note;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity @Table(name = "annotation")
public class Annotation {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    @ManyToOne
    private Note note;
    public Annotation(String text) {
        this.text = text;
    }
    public static Builder annotation() {
        return new Builder();
    }
    public static class Builder {
        private String text;
        public Builder text(String text) {
            this.text = text;
            return this;
        }
        public Annotation build() {
            Annotation annotation = new Annotation();
            annotation.setText(text);
            return annotation;
        }
    }
}
