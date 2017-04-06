package com.vpusher.repositories;

import com.vpusher.domains.Wire;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * Created by vpusher on 4/4/17.
 */
public interface WireRepository extends Neo4jRepository<Wire, Long> {

}
