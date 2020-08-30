package SearchA2DMatrix2;

public class SearchA2DMatrix2 {
    private boolean find(int[][] arr, int target, int y, int x, int h, int w){
        if(h==0 || w==0) return false;
        if(h==1 && w==1){
            return arr[y][x] == target;
        }
        if(target<arr[y][x] || arr[y+h-1][x+w-1]<target) return false;
        boolean ret = false;
        int halfH = h/2;
        int halfW = w/2;
        int oddH = h%2==1 ? 1 : 0;
        int oddW = w%2==1 ? 1 : 0;

        ret |= find(arr, target, y, x, halfH, halfW);
        ret |= find(arr, target, y, x+halfW, halfH, halfW+oddW);
        ret |= find(arr, target, y+halfH, x, halfH+oddH, halfW);
        ret |= find(arr, target, y+halfH, x+halfW, halfH+oddH, halfW+oddW);
        return ret;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0) return false;

        int r = matrix.length;
        int c = matrix[0].length;
        return find(matrix, target, 0,0, r, c);
    }
}

