package com.keyin.sprint2searchtreekylepike.controller;

import com.keyin.sprint2searchtreekylepike.model.BinarySearchTree;
import com.keyin.sprint2searchtreekylepike.model.PreviousTree;
import com.keyin.sprint2searchtreekylepike.service.BSTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

@Controller
public class BSTController {

    @Autowired
    private BSTService bstService;

    @GetMapping("/enter-numbers")
    public String enterNumbersPage() {
        return "enter-numbers";
    }

    @GetMapping("/")
    public String showHomepage() {
        return "index"; // Corresponds to `index.html` in the templates folder
    }

    @PostMapping("/process-numbers")
    @ResponseBody
    public BinarySearchTree processNumbers(@RequestParam String numbers) throws Exception {
        List<Integer> numberList = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .toList();
        BinarySearchTree tree = bstService.buildTree(numberList);
        bstService.saveTree(numberList, tree);
        return tree; // JSON representation
    }

    @GetMapping("/previous-trees")
    public String showPreviousTrees(Model model) {
        List<PreviousTree> previousTrees = bstService.getAllTrees();
        model.addAttribute("trees", previousTrees);
        return "previous-trees";
    }
}
