package com.vpusher.domains;

import org.neo4j.ogm.annotation.*;

/**
 * Created by vpusher on 4/4/17.
 */
@RelationshipEntity(type="LINKED_TO")
public class Wire {
    @GraphId
    private Long id;
    @Property
    private String inlet;
    @Property
    private String outlet;
    @StartNode
    private Block input;
    @EndNode
    private Block output;

    public Wire() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInlet() {
        return inlet;
    }

    public void setInlet(String inlet) {
        this.inlet = inlet;
    }

    public String getOutlet() {
        return outlet;
    }

    public void setOutlet(String outlet) {
        this.outlet = outlet;
    }

    public Block getInput() {
        return input;
    }

    public void setInput(Block input) {
        this.input = input;
    }

    public Block getOutput() {
        return output;
    }

    public void setOutput(Block output) {
        this.output = output;
    }

}
