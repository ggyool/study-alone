package ReplaceElementsWithGreatestElementOnRightSide;

public class ReplaceElementsWithGreatestElementOnRightSide {

    public int[] replaceElements(int[] arr) {
        int len = arr.length;
        int maxv = arr[len-1];
        arr[len-1] = -1;
        for(int i=len-2; i>=0; --i){
            int tmp = arr[i];
            arr[i] = maxv;
            maxv = Math.max(maxv,tmp);
        }
        return arr;
    }
}
