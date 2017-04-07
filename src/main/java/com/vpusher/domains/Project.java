package com.vpusher.domains;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vpusher on 4/4/17.
 */
@NodeEntity
public class Project {

    @GraphId
    private Long id;
    private String name;
    @Relationship(type = "OWNS", direction = Relationship.OUTGOING)
    private Set<Block> blocks = new HashSet<>();
    @Relationship(type = "TAKES_PART_IN", direction = Relationship.INCOMING)
    private Set<User> members  = new HashSet<>();

    public Project() {
    }

    public Project(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(Set<Block> blocks) {
        this.blocks = blocks;
    }

    public void add(Block block) {
        this.blocks.add(block);
    }

    public Set<User> getMembers() {
        return members;
    }

    public void setMembers(Set<User> members) {
        this.members = members;
    }
}
