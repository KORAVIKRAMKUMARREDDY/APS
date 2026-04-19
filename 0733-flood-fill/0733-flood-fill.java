class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        // Edge case: no change needed
        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int originalColor, int color) {
        // Boundary + color check
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length 
            || image[i][j] != originalColor) {
            return;
        }

        // Change color
        image[i][j] = color;

        // Explore 4 directions
        dfs(image, i + 1, j, originalColor, color);
        dfs(image, i - 1, j, originalColor, color);
        dfs(image, i, j + 1, originalColor, color);
        dfs(image, i, j - 1, originalColor, color);
    }
}