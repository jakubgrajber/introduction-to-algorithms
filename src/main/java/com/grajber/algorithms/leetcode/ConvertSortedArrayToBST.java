package com.grajber.algorithms.leetcode;

import com.grajber.algorithms.leetcode.common.TreeNode;

/**
 * <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/">Leetcode.com</a>
 */
public class ConvertSortedArrayToBST {

    public static void main(String[] args) {

        int[] nums = {-10, -3, 0, 5, 9};

        getBinaryTree(nums, 0, nums.length-1);
    }

    public static TreeNode getBinaryTree(int[] nums, int p, int q) {

        int mid = (p + q + 1) / 2;

        if (p == q)
            return new TreeNode(nums[p]);
        if (p>q)
            return null;

        return new TreeNode(nums[mid], getBinaryTree(nums, p, mid-1), getBinaryTree(nums, mid+1, q));
    }
}


