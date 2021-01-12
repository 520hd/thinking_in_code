package com.hd520.thinking_in_code.dsu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/**
 * @Description 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * leetcode 128
 * @Author xierishi
 * @Date 2021-01-12 16:48:29
 */
public class LongestConsecutive {

	private int[] size;
	private int[] parent;
	public int longestConsecutive(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		size = new int[nums.length];
		parent = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			parent[i] = i;
			size[i] = 1;
		}

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (Math.abs(nums[i] - nums[j]) == 1) {
					unin(i, j, parent, size);
				}
			}
		}
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int root = find(i, parent);
			if (map.get(root) == null) {
				Set<Integer> set = new HashSet<>();
				set.add(nums[i]);
				map.put(root, set);
			} else {
				map.get(root).add(nums[i]);
			}
		}
		int max = 0;
		for (Map.Entry<Integer, Set<Integer>> set : map.entrySet()) {
			max = Math.max(max, set.getValue().size());
		}

		return max;

	}

	private int find(int x, int[] parent) {
		int r = x;
		while (r != parent[r]) {
			r = parent[r];
		}
		return r;
	}

	private void unin(int x, int y, int[] parent, int[] size) {
		int xRoot = find(x, parent);
		int yRoot = find(y, parent);

		if (xRoot != yRoot) {
			if (size[xRoot] >= size[yRoot]){
				size[xRoot] += size[yRoot];
				parent[yRoot] = xRoot;
			} else {
				size[yRoot] += size[xRoot];
				parent[xRoot] = yRoot;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
		LongestConsecutive longestConsecutive = new LongestConsecutive();
		int longestConsecutive1 = longestConsecutive.longestConsecutive(nums);
		System.out.println(longestConsecutive1);


		Map<Integer, Set<Integer>> map = new HashMap<>();
		HashSet<Integer> objects = new HashSet<>();
		objects.add(100);
		map.put(1, objects);
		for (int i = 0; i < nums.length; i++) {
			int val = 2 * i;
			map.computeIfAbsent(i, in -> new HashSet<>()).add(val);
		}
		System.out.println(map);

	}
}
