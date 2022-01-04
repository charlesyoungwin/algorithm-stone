/*
 * @lc app=leetcode.cn id=1301 lang=java
 *
 * [1301] 最大得分的路径数目
 */

// @lc code=start
class Solution {

    private int INF = Integer.MIN_VALUE;
    private int mod = (int)(1e9 + 7);
    private int n;

    public int[] pathsWithMaxScore(List<String> board) {
        n  = board.size();
        char[][] cs = new char[n][n];
        for (int i = 0; i < n; i++) {
            cs[i] = board.get(i).toCharArray();
        }
        int[] f = new int[n * n];
        int[] g = new int[n * n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int idx = getIdx(i, j);
                if (i == n - 1 && j == n - 1) {
                    g[idx] = 1;
                    continue;
                }
                if (cs[i][j] == 'X') {
                    f[idx] = INF;
                    continue;
                }
                // 因为第一个字符是E
                int val = (i == 0 && j == 0) ? 0 : cs[i][j] - '0';
                int u = INF, t = 0;
                if (i + 1 < n) {
                    int cur = f[getIdx(i + 1, j)] + val;
                    int cnt = g[getIdx(i + 1, j)];
                    int[] res = update(cur, cnt, u, t);
                    u = res[0];
                    t = res[1];
                }
                if (j + 1 < n) {
                    int cur = f[getIdx(i, j + 1)] + val;
                    int cnt = g[getIdx(i, j + 1)];
                    int[] res = update(cur, cnt, u, t);
                    u = res[0];
                    t = res[1];
                }
                if (i + 1 < n && j + 1 < n) {
                    int cur = f[getIdx(i + 1, j + 1)] + val;
                    int cnt = g[getIdx(i + 1, j + 1)];
                    int[] res = update(cur, cnt, u, t);
                    u = res[0];
                    t = res[1];
                }
                f[idx] = u < 0 ? INF : u;
                g[idx] = t;
            }
        }
        int[] ans = new int[2];
        ans[0] = f[getIdx(0, 0)] == INF ? 0 : f[getIdx(0, 0)];
        ans[1] = f[getIdx(0, 0)] == INF ? 0 : g[getIdx(0, 0)];
        return ans;
    }

    private int getIdx(int x, int y) {
        return x * n + y;
    }

    private int[] parseIdx(int idx) {
        return new int[]{idx / n, idx % n};
    }

    private int[] update(int cur, int cnt, int u, int t) {
        int[] ans = new int[]{u, t};
        if (cur > u) {
            ans[0] = cur;
            ans[1] = cnt;
        } else if (cur == u && cur != INF) {
            ans[1] += cnt;
        }
        ans[1] %= mod;
        return ans;
    } 

}
// @lc code=end

