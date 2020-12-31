package com.hd520.thinking_in_code.algorithmic_thinking.pre_sum;

import com.hd520.thinking_in_code.util.TreeNode;
import com.hd520.thinking_in_code.util.TreeOperation;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 前缀和方法解决子数组问题
 * @Author xierishi
 * @Date 2020-12-31 10:39:05
 */
public class PreSum {

	public int ArrayPreSum(int[] arr, int k) {

		int len = arr.length;
		// 创建一个前缀和的map, 记录前缀和出现的次数
		HashMap<Integer, Integer> preSumMap = new HashMap<>(len + 1);

		// base case 前缀和为0出现次数为1
		preSumMap.put(0, 1);
		int preSum = 0;
		int count = 0;
		for (int i = 0; i < len; i++) {
			preSum += arr[i];
			preSumMap.put(preSum, preSumMap.getOrDefault(preSum, 0) + 1);
			if (preSumMap.containsKey(preSum - k)) {
				count += preSumMap.get(preSum - k);
			}
		}
		return count;
	}

	int count = 0;
	public int TreeNodePreSum(TreeNode root,int k) {

		// 创建一个map, 记录前缀和出现的次数
		Map<Integer, Integer> preSumMap = new HashMap<>();
		// base case
		preSumMap.put(0, 1);
		return handlePreSumNew(root, k, 0, preSumMap);
//		return count;
	}

	/**
	 * 前缀和的递归回溯思路
	 * 从当前节点反推到根节点(反推比较好理解，正向其实也只有一条)，有且仅有一条路径，因为这是一棵树
	 * 如果此前有和为preSum - k,而当前的和又为preSum,两者的差就肯定为k了
	 * 所以前缀和对于当前路径来说是唯一的，当前记录的前缀和，在回溯结束，回到本层时去除，保证其不影响其他分支的结果
	 * @param root
	 * @param k
	 * @param preSum
	 * @param preSumMap
	 */
	private void handlePreSum(TreeNode root, int k, int preSum, Map<Integer, Integer> preSumMap) {

		// 1.递归终止条件
		if (root == null) {
			return;
		}
		//---核心代码
		// 看看root到当前节点这条路上是否存在节点前缀和加k为preSum的路径
		// 当前节点->root节点反推，有且仅有一条路径，如果此前有和为preSum-k,而当前的和又为preSum,两者的差就肯定为k了
		// preSum-k相当于找路径的起点，起点的sum+k=preSum，当前点到起点的距离就是k
		preSum += root.val;
		// 更新路径上当前节点前缀和的个数
		preSumMap.put(preSum, preSumMap.getOrDefault(preSum, 0) + 1);
		if (preSumMap.containsKey(preSum - k)) {
			count += preSumMap.get(preSum - k);
		}
		//---核心代码

		// 3.进入下一层
		handlePreSum(root.left, k, preSum, preSumMap);
		handlePreSum(root.right, k, preSum, preSumMap);

		// 4.回到本层，恢复状态，去除当前节点的前缀和数量
		preSumMap.put(preSum,  preSumMap.getOrDefault(preSum, 0) - 1);
	}

	public int handlePreSumNew(TreeNode root, int k, int preSum, Map<Integer, Integer> preSumMap) {
		// 1. 递归终止条件
		if (root == null) {
			return 0;
		}
		int res = 0;
		preSum += root.val;
		if (preSumMap.containsKey(preSum - k)) {
			res += preSumMap.get(preSum - k);
		}
		preSumMap.put(preSum, preSumMap.getOrDefault(preSum, 0) + 1);

		int left = handlePreSumNew(root.left, k, preSum, preSumMap);
		int right = handlePreSumNew(root.right, k, preSum, preSumMap);
		preSumMap.put(preSum, preSumMap.getOrDefault(preSum, 0) - 1);
		return res + left + right;

	}

	public static void main(String[] args) {
		PreSum preSum = new PreSum();
//		int count = preSum.ArrayPreSum(new int[]{1, 1, 1, 2}, 2);
//		System.out.println(count);

		TreeNode treeNode = TreeOperation.fromArray(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1});
		int countTree = preSum.TreeNodePreSum(treeNode, 22);
		System.out.println(countTree);
	}
}
