package org.vow.actos.domain.annotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "annotations", path = "annotations")
public interface AnnotationRepository
        extends JpaRepository<Annotation, Long> {
}
