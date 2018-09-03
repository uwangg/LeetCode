
/*
* 515. Find Largest Value in Each Tree Row
* Input:
*
*          1
*         / \
*        3   2
*       / \   \
*      5   3   9
* Output: [1, 3, 9]
*
* 같은 depth 내에서 element들중 최대값들을 출력하는 문제
* */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {
  public List<Integer> largestValues(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if( root == null ) {
      return result;
    }

    Queue<TreeNode> parent = new LinkedList<>();
    Queue<TreeNode> child = new LinkedList<>();

    parent.add(root);

    Integer maxVal;

    while( parent.size() > 0 ) {
      maxVal = Integer.MIN_VALUE;
      // 같은 depth내 자식데이터 탐색
      while ( parent.size() > 0 ) {
        TreeNode tmp = parent.poll();
        maxVal = Math.max( maxVal, tmp.val );
        if( tmp.left != null ) {
          child.add(tmp.left);
        }
        if( tmp.right != null ) {
          child.add(tmp.right);
        }
      }
      // 같은 depth 내 value값중 최대값 추가
      result.add(maxVal);
      parent = new LinkedList<>(child);
      child.clear();
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode[] treeNode = new TreeNode[6];
    int[] valList = { 1, 3, 2, 5, 3, 9 };

    for( int i = 0 ; i < valList.length ; i++ ) {
      treeNode[i] = new TreeNode(valList[i]);
    }

    treeNode[0].left = treeNode[1];
    treeNode[0].right = treeNode[2];
    treeNode[1].left = treeNode[3];
    treeNode[1].right = treeNode[4];
    treeNode[2].right = treeNode[5];

    FindLargestValueInEachTreeRow flv = new FindLargestValueInEachTreeRow();
    List<Integer> result = flv.largestValues(treeNode[0]);
    for( int i = 0 ; i < result.size() ; i++ ) {
      System.out.print( result.get(i) + " " );
    }
  }
}
