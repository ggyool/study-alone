package 베스트앨범;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] sarr = {"a", "a", "a", "d", "e"};
        int[] arr = {500, 700, 600, 2000, 1000};
        int[] res = sol.solution(sarr, arr);
        for (int re : res) {
            System.out.println(re);
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> countMp = new HashMap<>();
        HashMap<String, BestAlbum> songMp = new HashMap<>();
        for(int i=0; i<genres.length; ++i){
            String genre = genres[i];
            int play = plays[i];
            countMp.put(genre, countMp.getOrDefault(genre, 0)+play);
            if(songMp.containsKey(genre)){
                songMp.get(genre).decideOrder(i, play);
            }
            else{
                songMp.put(genre, new BestAlbum(i, play));
            }
        }
        List<String> playList = new ArrayList<>();
        playList.addAll(countMp.keySet());
        Collections.sort(playList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return countMp.get(o2) - countMp.get(o1);
            }
        });
        List<Integer> list = new ArrayList<>();
        for(String key : playList){
            BestAlbum album = songMp.get(key);
            list.add(album.firstIdx);
            if(album.secondIdx!=-1)
                list.add(album.secondIdx);
        }
        int[] ret = new int[list.size()];
        for(int i=0; i<list.size(); ++i){
            ret[i] = list.get(i);
        }
        return ret;
    }
}

class BestAlbum {
    int firstIdx, secondIdx;
    int firstVal, secondVal;
    public BestAlbum(int firstIdx, int firstVal) {
        this.firstIdx = firstIdx;
        this.firstVal = firstVal;
        this.secondIdx = -1;
        this.secondVal = -1;
    }
    public void decideOrder(int idx, int play){
        if(play>firstVal){
            secondVal = firstVal;
            secondIdx = firstIdx;
            firstVal = play;
            firstIdx = idx;
        }
        else if(play>secondVal){
            secondVal = play;
            secondIdx = idx;
        }
    }
}

