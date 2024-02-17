package arrays;

import javax.imageio.ImageTranscoder;

public class SearchSorted2DArray {
    static int[][] matrix = new int[][]{
            {35, 45, 55, 65},
            {40, 50, 60, 70},
            {52, 54, 62, 73},
            {57, 58, 64, 75},
    };

    static int target = 54;

    public static void main(String[] args) {
//        search(matrix, target);
        searchBinarySearch(matrix, target);
    }


    public static void searchBinarySearch(int[][] matrix, int target) {

        int rows = matrix.length;
        int column = matrix[0].length - 1;

        for (int[] row : matrix) {
            if (row[column] > target) {
                int left = 0;
                int right = row.length;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (row[mid] == target) {
                        return;
                    } else if (row[mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        System.out.println("Element not found");
    }

    public static void search(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int column = 0;

        int columns = matrix[0].length;
        while (row > -1 && column < columns) {
            if (target < matrix[row][column]) {
                row--;
            } else if (target > matrix[row][column]) {
                column++;
            } else {
                return;
            }
        }
        System.out.println("Element not found");
    }
}
