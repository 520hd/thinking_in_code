package com.hd520.thinking_in_code.topology_sort;

import java.util.*;

/**
 * @Description 项目管理
 * 需要对项目组进行拓扑排序以及对项目进行拓扑排序
 * leetcode 1203
 * @Author xierishi
 * @Date 2021-01-13 22:04:04
 */
public class ProjectManage {

	public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {

		for (int i = 0; i < n; i++) {
			if (group[i] == -1) {
				group[i] = m;
				m++;
			}
		}

		// 对项目进行归类, 索引为项目的id, 值为项目列表
		List<List<Integer>> groupItem = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			groupItem.add(new ArrayList<>());
		}
		for (int i = 0; i < n; i++) {
			groupItem.get(group[i]).add(i);
		}

		// 创建组内关系图,用于存储前置项目  与后置项目的关系
		List<List<Integer>> itemsGraph = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			itemsGraph.add(new ArrayList<>());
		}

		// 创建组间关系图,用于存储前置项目组 与后置项目组的关系
		List<List<Integer>> groupGraph = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			groupGraph.add(new ArrayList<>());
		}


		List<Integer> groupIdList = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			groupIdList.add(i);
		}

		int[] itemIn = new int[n];
		int[] groupIn = new int[m];

		for (int i = 0; i < n; i++) {
			int curGroupId = group[i];
			List<Integer> preItems = beforeItems.get(i);
			for (Integer pre : preItems) {
				int preGroupId = group[pre];

				if (preGroupId == curGroupId) {
					// 此时前置的项目和当前项目在同一个项目组,因此创建组内关系图谱
					// 组内项目入度加1
					itemIn[i]++;
					// 项目的后置项目列表添加
					itemsGraph.get(pre).add(i);
				} else {
					// 此时前置的项目和当前项目不在同一个项目组,创建组间关系
					// 项目组的入度加1
					groupIn[curGroupId]++;
					// 项目组的后置项目组列表添加
					groupGraph.get(preGroupId).add(curGroupId);
				}
			}
		}

		List<Integer> groupList = topSort(groupIn, groupGraph, groupIdList);
		if (groupList.size() == 0) {
			return new int[]{};
		}
		List<Integer> totalRes = new ArrayList<>();
		for (Integer groupId : groupList) {
			List<Integer> itemList = topSort(itemIn, itemsGraph, groupItem.get(groupId));
			totalRes.addAll(itemList);
		}
		if (totalRes.size() != n) {
			return new int[]{};
		}
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = totalRes.get(i);
		}
		return res;
	}

	private List<Integer> topSort (int[] itemIn, List<List<Integer>> itemsGraph, List<Integer> idList) {

		Queue<Integer> queue = new LinkedList<>();
		for (Integer id : idList) {
			if (itemIn[id] == 0) {
				queue.offer(id);
			}
		}
		List<Integer> res = new ArrayList<>();
		while (!queue.isEmpty()) {
			Integer cur = queue.poll();
			res.add(cur);
			List<Integer> list = itemsGraph.get(cur);
			for (Integer postItem : list) {
				if (--itemIn[postItem] == 0) {
					queue.add(postItem);
				}
			}
		}
		return res.size() == idList.size() ? res : new ArrayList<>();
	}

	public static void main(String[] args) {
		ProjectManage projectManage = new ProjectManage();

		int n = 8;
		int m = 2;
		int[] group = new int[]{-1, -1, 1, 0, 0, 1, 0, -1};
		List<List<Integer>> beforeItems = new ArrayList<>(8);
		for (int i = 0; i < n; i++) {
			beforeItems.add(new ArrayList<>());
		}

		beforeItems.set(1, Collections.singletonList(6));
		beforeItems.set(2, Collections.singletonList(5));
		beforeItems.set(3, Collections.singletonList(6));
		beforeItems.set(4, Arrays.asList(3, 6));


//		int n = 5;
//		int m = 5;
//		int[] group = new int[]{2,0,-1,3,0};
//		List<List<Integer>> beforeItems = new ArrayList<>();
//		for (int i = 0; i < n; i++) {
//			beforeItems.add(new ArrayList<>());
//		}
//
//		beforeItems.set(0, Arrays.asList(2,1,3));
//		beforeItems.set(1, Arrays.asList(2,4));

		int[] sortItems = projectManage.sortItems(n, m, group, beforeItems);
		System.out.println(Arrays.toString(sortItems));
	}
}
