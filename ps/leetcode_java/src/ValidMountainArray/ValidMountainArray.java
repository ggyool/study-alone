package ValidMountainArray;

public class ValidMountainArray {
//    public boolean validMountainArray(int[] A) {
//        boolean inc=false,dec=false;
//        for(int i=1; i<A.length; ++i){
//            if(A[i-1]==A[i]){
//                return false;
//            }
//            else if(A[i-1]<A[i]){
//                if(dec) return false;
//                inc = true;
//            }
//            else{
//                if(inc==false) return false;
//                dec = true;
//            }
//        }
//        return inc && dec;
//    }
    public boolean validMountainArray(int[] arr) {
        int len = arr.length;
        int i = 1;
        while(i<len && arr[i-1] < arr[i]){
            ++i;
        }
        if(i==1 || i==len) return false;
        while(i<len && arr[i-1] > arr[i]){
            ++i;
        }
        return i==len;
    }
}
