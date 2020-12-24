
# bfs (Breadth First Search) 广度优先搜索

广度优先搜索的本质就是 让你在一幅[图]中 找到从起点 start 到 终点 target 的最近距离

广度优先搜索的核心代码框架:
// 计算从起点start到终点target的最近距离
int BFS(Node start, Node target) {
    Queue<Node> q; // 核心数据结构
    Set<Node> visited; // 避免走回头路
    q.offer(start);// 将起点加入列表中
    visited.add(start);
    int step = 0; // 记录扩散的步数
    while (!q.isEmpty()) {
        int sz = q.size();
        for (int i = 0; i < sz; i++) {
            Node cur = q.poll();
            if (cur is target) {
                return step
            }
            // 这里的cur就是表示上下左右四面位置的相邻节点
            // 将这些节点加入队列
            for (Node x : cur.adj()) {
                if (x not in visited) {
                    q.offer(x);
                    visited.add(x);
                }
            }
        }
        // [划重点 在次数更新步数]
        step++;
    }
}
* 队列就是广度优先搜索bfs的核心数据结构, 就是类似于从起点start到终点target一层一层的进行地毯式搜索.

bfs相对于dfs的最大区别是:
* bfs找到的路径一定是最短的, 但代价就是空间复杂度比dfs大很多.