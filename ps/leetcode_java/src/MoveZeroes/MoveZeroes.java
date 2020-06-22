package MoveZeroes;

public class MoveZeroes {
    public void moveZeroes(int[] arr) {
        int i = 0;
        for(int j=0; j<arr.length; ++j){
            if(arr[i]!=0) ++i;
            else if(arr[j] != 0) {
                arr[i++] = arr[j];
                arr[j] = 0;
            }
        }
    }
}
