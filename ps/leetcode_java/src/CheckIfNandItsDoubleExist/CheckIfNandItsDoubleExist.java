package CheckIfNandItsDoubleExist;

public class CheckIfNandItsDoubleExist {
    public boolean checkIfExist(int[] arr) {
        int n = arr.length;
        boolean[] chk = new boolean[2001];
        int zeroCnt = 0 ;
        for(int i=0; i<n; ++i){
            if(arr[i]==0) ++zeroCnt;
            chk[arr[i]+1000] = true;
        }
        if(zeroCnt>1) return true;
        for(int i=0; i<n; ++i) {
            if(arr[i]!=0 && arr[i]%2==0){
                if(chk[arr[i]/2+1000])
                    return true;
            }
        }
        return false;
    }
}
