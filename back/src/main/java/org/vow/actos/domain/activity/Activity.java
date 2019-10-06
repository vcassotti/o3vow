package org.vow.actos.domain.activity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter
public class Activity {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
}
