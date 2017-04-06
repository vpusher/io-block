package com.vpusher.domains;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.RelationshipEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vpusher on 4/4/17.
 */

@NodeEntity
public class Block {

    @GraphId
    private Long id;

    private String name;

    @Relationship(type = "LINKED_TO")
    private Set<Wire> wires = new HashSet<>();

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

    public Set<Wire> getWires() {
        return wires;
    }

    public void setWires(Set<Wire> wires) {
        this.wires = wires;
    }
}
