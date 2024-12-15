package com.keyin.sprint2searchtreekylepike.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class PreviousTree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<Integer> inputNumbers;

    @Lob
    private String treeStructure; // JSON representation of the tree

    // Getters and setters
    public void setInputNumbers(List<Integer> inputNumbers) {
        this.inputNumbers = inputNumbers;
    }
    public List<Integer> getInputNumbers() {
        return inputNumbers;
    }
    public void setTreeStructure(String treeStructure) {
        this.treeStructure = treeStructure;
    }
    public String getTreeStructure() {
        return treeStructure;
    }
    public Long getId() {
        return id;
    }
}
