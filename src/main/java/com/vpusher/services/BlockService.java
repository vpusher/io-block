package com.vpusher.services;

import com.vpusher.domains.Block;
import com.vpusher.repositories.BlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by f2i on 4/5/17.
 */
@Service
public class BlockService {
    private final BlockRepository blockRepository;

    @Autowired
    public BlockService(BlockRepository BlockRepository) {
        this.blockRepository = BlockRepository;
    }

    public Block get(Long id) {
        return this.blockRepository.findOne(id);
    }

    public Iterable<Block> all() {
        return this.blockRepository.findAll();
    }

    public void update(Block Block) {
        this.blockRepository.save(Block);
    }

    public void remove(Block Block) {
        this.blockRepository.delete(Block);
    }

    public void clean() {
        this.blockRepository.deleteAll();
    }

}