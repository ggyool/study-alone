package LargestRectangleInHistogram;

public class LargestRectangleInHistogram {

    private int solve(int left, int right, int[] heights){
        if(left==right) return heights[left];
        int mid = left + (right-left)/2;

        int ret =  solve(left, mid, heights);
        ret = Math.max(ret, solve(mid+1, right, heights));

        int i = mid, j = mid+1;
        int h = Math.min(heights[i], heights[j]);
        int wh = (j-i+1)*h;
        ret = Math.max(ret, wh);
        while(left<=i || j<=right){
            if(i==left && j==right) break;
            if(i==left){
                ++j;
                h = Math.min(h, heights[j]);
            }
            else if(j==right){
                --i;
                h = Math.min(h, heights[i]);
            }
            else if(heights[i-1]<heights[j+1]){
                ++j;
                h = Math.min(h, heights[j]);
            }
            else {
                --i;
                h = Math.min(h, heights[i]);
            }
            wh = (j-i+1)*h;
            ret = Math.max(ret, wh);
        }
        return ret;
    }
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) return 0;
        return solve(0, heights.length-1, heights);
    }
}
