package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void rob2Test() {
        Solution solution = new Solution();
        assertEquals(3, solution.rob(new int[]{2,3,2}));
        assertEquals(4, solution.rob(new int[]{1,2,3,1}));
        assertEquals(3, solution.rob(new int[]{1,2,3}));
        assertEquals(0, solution.rob(new int[]{0}));
        assertEquals(131, solution.rob(new int[]{43,55,15,76,23}));
    }

}