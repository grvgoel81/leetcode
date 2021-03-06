import java.util.ArrayList;
import java.util.List;

// Definition for binary tree
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> levels = new ArrayList<List<Integer>>();
		search(levels, root, 0);
		reverse(levels);
		return levels;
	}

	void search(List<List<Integer>> levels, TreeNode node, int depth) {
		if (node == null) {
			return;
		}
		if (depth == levels.size()) {
			levels.add(new ArrayList<Integer>());
		}
		levels.get(depth).add(node.val);
		search(levels, node.left, depth + 1);
		search(levels, node.right, depth + 1);
	}

	void reverse(List<List<Integer>> levels) {
		for (int i = 0, j = levels.size() - 1; i < j; i++, j--) {
			List<Integer> temp = levels.get(i);
			levels.set(i, levels.get(j));
			levels.set(j, temp);
		}
	}
}
