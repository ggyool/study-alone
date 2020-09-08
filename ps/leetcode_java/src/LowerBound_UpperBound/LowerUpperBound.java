package LowerBound_UpperBound;

public class LowerUpperBound {
    // 값이 target인 가장 작은 index
    // 값이 없는 경우 따로 체크해야함
    int lowerBound(int target, int left, int right, int[] arr){
        while (left < right) {
            int mid = left + (right-left)/2;
            if(target<=arr[mid]){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return right;
    }
    // 값이 target 보다 큰 가장 작은 index
    // 값이 모두 작은 경우 잘 체크해야함
    int upperBound(int target, int left, int right, int[] arr){
        while (left < right) {
            int mid = left + (right-left)/2;
            if(target<arr[mid]){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return right;
    }
}
