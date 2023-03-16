package com.grajber.algorithms.leetcode;

import com.grajber.algorithms.leetcode.common.TreeNode;

/**
 * <a href="https://leetcode.com/problems/maximum-binary-tree/">Leetcode.com</a>
 */
public class MaximumBinaryTree {

    public static void main(String[] args) {

        int nums[] = {3, 2, 1, 6, 0, 5};

        TreeNode maxTreeNode = generateMaximumBT(nums, 0, nums.length-1);
    }

    private static TreeNode generateMaximumBT(int[] nums, int p, int q) {

        if (p==q)
            return new TreeNode(nums[p]);
        if (p>q)
            return null;

        int maxIndex = 0;
        int maxValue = -1;
        for (int  i = p; i <=q; i++) {
            if (nums[i] > maxValue){
                maxIndex = i;
                maxValue = nums[i];
            }
        }

        return new TreeNode(maxValue, generateMaximumBT(nums, p, maxIndex-1), generateMaximumBT(nums, maxIndex+1, q));

    }
}
