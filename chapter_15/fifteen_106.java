package chapter_15;

/*
* 785. 判断二分图
* */
public class fifteen_106 {
    /**
     看这个图，题意也就是相邻的点，颜色不能相同。
     https://leetcode.cn/problems/is-graph-bipartite/solution/shou-hua-tu-jie-bfs-si-lu-by-hyj8/

     为什么深度便利？
     因为你确定了一个点的初始的颜色，你就需要把这个点相邻的，和这个点相邻的相邻的，全变成这个颜色。

     这道题思路不难，刚开始没有想到这种附“颜色”的方法。最初想的是，把一个点相邻的放在集合里，
     第二个点在看一下冲不冲突。这样很麻烦，每次两个数组都得重新便利，而且估计还会超时。

     标记！是DFS一个比较重要的东西。
     */
    public boolean isBipartite(int[][] graph) {
        int visited[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            // 根据dfs的思路，如果它被染了，说明它相邻的点也已经判断了
            if (visited[i] == 0) {
                if (dfs(graph, i, 1, visited) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph, int i, int color, int[] visited) {
        // 如果已经被染，看看染的对不对
        if (visited[i] != 0) {
            if (color != visited[i]) {
                return false;
            } else {
                return true;
            }
        }
        visited[i] = color;
        // 相邻的点继续染
        for (int j: graph[i]) {
            // 相邻的点的相邻的点继续染
            if (dfs(graph, j, -color, visited) == false) {
                return false;
            }
        }
        return true;
    }
}
