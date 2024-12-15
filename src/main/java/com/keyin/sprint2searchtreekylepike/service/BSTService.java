package com.keyin.sprint2searchtreekylepike.service;

import com.keyin.sprint2searchtreekylepike.model.BinarySearchTree;
import com.keyin.sprint2searchtreekylepike.model.PreviousTree;
import com.keyin.sprint2searchtreekylepike.repository.PreviousTreeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BSTService {

    @Autowired
    private PreviousTreeRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    public BinarySearchTree buildTree(List<Integer> numbers) {
        BinarySearchTree tree = new BinarySearchTree();
        numbers.forEach(tree::insert);
        return tree;
    }

    public void saveTree(List<Integer> numbers, BinarySearchTree tree) throws Exception {
        PreviousTree previousTree = new PreviousTree();
        previousTree.setInputNumbers(numbers);
        previousTree.setTreeStructure(objectMapper.writeValueAsString(tree.getRoot()));
        repository.save(previousTree);
    }

    public List<PreviousTree> getAllTrees() {
        return repository.findAll();
    }
}