class Solution {

    private int n;
    private List<List<Integer>> edges;
    private int[] inDeg;
    private int[] ans;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        n = numCourses;
        edges = new ArrayList<>();
        inDeg = new int[n];
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] course: prerequisites) {
            int a = course[0];
            int b = course[1];
            addEdge(b, a);
        }

        return topSort();
    }

    private int[] topSort(){
        int[] ans = new int[n];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }
        int m = 0;
        while (!q.isEmpty()) {
            int x = q.poll();
            ans[m++] = x;
            for (int y : edges.get(x)) {
                inDeg[y]--;
                if (inDeg[y] == 0) {
                    q.add(y);
                }
            }
        }
        if (m == n) {
            return ans;
        }
        return new int[0];
    }

    private void addEdge(int x, int y) {
        edges.get(x).add(y);
        inDeg[y]++;
    }
}
