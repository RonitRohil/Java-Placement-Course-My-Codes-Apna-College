public class FloodFillAlgo {

    // O(m*n)
    public static void helper(int[][] image, int sr, int sc, int color, boolean vis[][], int orgCol) {

        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || vis[sr][sc] || image[sr][sc] != orgCol) {
            return;
        }

        image[sr][sc] = color;

        // left
        helper(image, sr, sc-1, color, vis, orgCol);
        // right
        helper(image, sr, sc+1, color, vis, orgCol);
        // up
        helper(image, sr-1, sc, color, vis, orgCol);
        //down
        helper(image, sr+1, sc, color, vis, orgCol);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, vis, image[sr][sc]);
        return image;
    }

    public static void main(String[] args) {
        int image[][] = {{1, 1, 1},      
                         {1, 1, 0},
                         {1, 0, 1}};

        int ans[][] = floodFill(image, 1, 1, 2);

        System.out.println(ans);
    }
}


/*
 * 
 * 
 * Flood Fill Algorithm
 * 
 * Given a m * n integer grid image where image[i][j] represents the 
 * pixel value of the image. You are also given three integers sr, sc 
 * and color. You should perform a flood fill on the image starting from 
 * the pixel image[sr][sc]. 
 * 
 * To perform a flood fill, consider the starting pixel, plus any pixels 
 * connected 4-directionally to the starting pixel of the same color as 
 * the starting pixel, plus any pixels connected 4-directionally to 
 * those pixels (also with the same color), and so on. Replace the color 
 * of all the a fore mentioned pixels with color.
 * 
 * image = {{1, 1, 1},      
 *          {1, 1, 0},
 *          {1, 0, 1}}
 * 
 * sr = 1, sc = 1, color = 2
 * 
 * ans = {{2, 2, 2},
 *        {2, 2, 0},
 *        {2, 0, 1}}
 * 
 * 
 */