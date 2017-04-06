package com.vpusher.services;

import com.vpusher.domains.Block;
import com.vpusher.domains.Wire;
import com.vpusher.repositories.WireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by f2i on 4/5/17.
 */
@Service
public class WireService {

    private final WireRepository wireRepository;

    @Autowired
    public WireService(WireRepository wireRepository) {
        this.wireRepository = wireRepository;
    }

    public Wire get(Long id) {
        return this.wireRepository.findOne(id);
    }

    public Iterable<Wire> all() {
        return this.wireRepository.findAll();
    }

    public void update(Wire Wire) {
        this.wireRepository.save(Wire);
    }

    public void remove(Wire Wire) {
        this.wireRepository.delete(Wire);
    }

    public void clean() {
        this.wireRepository.deleteAll();
    }

    public void connect(Block inputBlock, String inlet, Block outputBlock, String outlet) {
        Wire wire = new Wire();
        wire.setInput(inputBlock);
        wire.setOutput(outputBlock);
        wire.setInlet(inlet);
        wire.setOutlet(outlet);
        wireRepository.save(wire);
    }

    /*public void disconnect(Block inputBlock, String inlet, Block outputBlock, String outlet) {

    }*/
}
