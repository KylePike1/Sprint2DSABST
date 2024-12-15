package com.keyin.sprint2searchtreekylepike;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.keyin.sprint2searchtreekylepike.service.BSTService;
import com.keyin.sprint2searchtreekylepike.model.BinarySearchTree;
import com.keyin.sprint2searchtreekylepike.model.PreviousTree;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class Sprint2SearchTreeKylePikeApplicationTests {

    @Autowired
    private BSTService bstService;

    @Test
    void testTreeCreation() {
        List<Integer> numbers = List.of(8, 4, 12, 2, 6, 10, 14);
        BinarySearchTree tree = bstService.buildTree(numbers);
        assertNotNull(tree.getRoot());
    }

    @Test
    void testSaveTree() {
        List<Integer> numbers = List.of(8, 4, 12);
        BinarySearchTree tree = bstService.buildTree(numbers);
        assertDoesNotThrow(() -> bstService.saveTree(numbers, tree));
    }

    @Test
    void testRetrieveTrees() {
        List<PreviousTree> trees = bstService.getAllTrees();
        assertNotNull(trees);
    }
}
