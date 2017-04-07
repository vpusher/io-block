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

    private String computor;

    private int x;

    private int y;

    @Relationship(type = "LINKED_TO")
    private Set<Wire> wires = new HashSet<>();

    public Block() {
    }

    public Block(String name, String computor, int x, int y) {
        this.name = name;
        this.computor = computor;
        this.x = x;
        this.y = y;
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

    public String getComputor() {
        return computor;
    }

    public void setComputor(String computor) {
        this.computor = computor;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Set<Wire> getWires() {
        return wires;
    }

    public void setWires(Set<Wire> wires) {
        this.wires = wires;
    }
}
