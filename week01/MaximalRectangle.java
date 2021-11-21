class Solution {
    private Deque<Rect> s = new LinkedList<>();

    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        if (r == 0) {
            return 0;
        }
        int c = matrix[0].length;
        int ans = 0;
        int[] heights = new int[c];
        for (int i = 0; i < r; i++) {

            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] = heights[j] + 1;
                } else {
                    heights[j] = 0;
                }
            }
            ans = Math.max(ans, largestRectangleArea(heights));
        }
        return ans;
    }


    private int largestRectangleArea(int[] heights) {
        int ans = 0;
        int[] copy = new int[heights.length + 1];
        for (int i = 0; i < heights.length; i++) {
            copy[i] = heights[i];
        }
        for (int height : copy) {
            int aWidth = 0;
            while (!s.isEmpty() && s.peek().height >= height) {
                aWidth += s.peek().width;
                ans = Math.max(ans, s.peek().height * aWidth);
                s.pop();
            }
            s.push(new Rect(aWidth + 1, height));
        }
        return ans;
    }

    private class Rect {
        int width;
        int height;
        Rect(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }
}
