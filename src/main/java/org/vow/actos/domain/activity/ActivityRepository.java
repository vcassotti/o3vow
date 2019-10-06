package org.vow.actos.domain.activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "activities", path = "activities")
public interface ActivityRepository
        extends JpaRepository<Activity, Long> {
}
