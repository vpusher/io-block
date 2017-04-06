package com.vpusher.repositories;

import com.vpusher.domains.Project;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by vpusher on 4/4/17.
 */
@RepositoryRestResource(collectionResourceRel = "project")
public interface ProjectRepository extends Neo4jRepository<Project, Long> {

    Project findOne(Long id);

    Project findByName(String name);

}
