package MergeSortedArray;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m+n;
        int l = m-1, r = n-1;
        int i = len-1;
        while(l>=0 && r>=0){
            if(nums1[l] >= nums2[r]){
                nums1[i--] = nums1[l--];
            }
            else{
                nums1[i--] = nums2[r--];
            }
        }
        while(l>=0){
            nums1[i--] = nums1[l--];
        }
        while(r>=0){
            nums1[i--] = nums2[r--];
        }
    }
}
