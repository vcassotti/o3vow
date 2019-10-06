package org.vow.actos.domain.tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "tags", path = "tags")
public interface TagRepository
        extends JpaRepository<Tag, Long> {
    Optional<Tag> findByValue(String tag);
}
