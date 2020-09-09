package FindSmallestLetterGreaterThanTarget;

public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length;
        int mid = 0;
        while(left<right) {
            mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return letters[right%letters.length];
    }
}
