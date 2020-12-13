package RelativeSortArray;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] ret = new int[arr1.length];
        int[] count = new int[1001];
        for (int num : arr1) {
            count[num]++;
        }

        int i = 0;
        for (int num : arr2) {
            while (count[num]-- > 0){
                ret[i++] = num;
            }
        }

        for (int num = 0; num <= 1000; num++) {
            while (count[num]-- > 0){
                ret[i++] = num;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        RelativeSortArray sol = new RelativeSortArray();
        int[] ints = sol.relativeSortArray(arr1, arr2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
