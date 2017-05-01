package com.vpusher.repositories;

import com.vpusher.domains.Block;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.Set;

/**
 * Created by vpusher on 4/4/17.
 */

@RepositoryRestResource(collectionResourceRel = "blocks")
public interface BlockRepository extends Neo4jRepository<Block, Long> {

    Block findOne(Long id);

}
