package com.hd520.thinking_in_code.dsu;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description 寻找朋友圈
 * https://zhuanlan.zhihu.com/p/125604577
 * @Author xierishi
 * @Date 2021-01-11 23:08:56
 */
public class FindCircleNum {

	private int[] size;
	private int[] parent;

	public int findCircleNumber(int[][] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		Set<Integer> set = new HashSet<>();
		size = new int[nums.length];
		parent = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			size[i] = 1;
			parent[i] = i;
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				if (nums[i][j] == 1) {
					union(i, j, parent, size);
				}
			}
		}
		for (int i = 0; i < nums.length; i++) {
			int root = find(i, parent);
			set.add(root);
		}
		return set.size();

	}

	private int find(int x, int[] parent) {
		int r = x;
		while(r != parent[r]) {
			r = parent[r];
		}
		return r;
	}

	private void union(int x, int y, int[] parent, int[] size) {

		int xRoot = find(x, parent);
		int yRoot = find(y, parent);
		if (xRoot != yRoot) {
			if (size[xRoot] >= size[yRoot]) {
				parent[yRoot] = xRoot;
				size[xRoot] += size[yRoot];
			} else {
				parent[xRoot] = yRoot;
				size[yRoot] += size[xRoot];
			}
		}
	}
}
