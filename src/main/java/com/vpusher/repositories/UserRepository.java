package com.vpusher.repositories;

import com.vpusher.domains.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * Created by vpusher on 4/4/17.
 */
public interface UserRepository extends Neo4jRepository<User, Long> {

    User findByNickname(String name);

}
