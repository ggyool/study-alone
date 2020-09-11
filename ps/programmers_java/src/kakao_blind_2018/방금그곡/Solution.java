package kakao_blind_2018.방금그곡;

import java.util.ArrayList;
import java.util.List;

// 	"CCB", ["03:00,03:10,FOO,CCB#CCB", "04:00,04:08,BAR,ABC"]
public class Solution {
    private int toInt(String time){
        String[] s = time.split(":");
        return 60 * Integer.parseInt(s[0]) + Integer.parseInt(s[1]);
    }
    public String solution(String m, String[] musicinfos) {
        int slen = musicinfos.length;
        List<Song> songs = new ArrayList<>();
        for(int i=0; i<slen; ++i){
            String musicinfo = musicinfos[i];
            String[] list = musicinfo.split(",");
            int start = toInt(list[0]);
            int end = toInt(list[1]);
            int minute = end - start;
            String title = list[2];
            String lylics = list[3];
            StringBuilder sb = new StringBuilder();
            int k = 0;
            int lylicsLen = lylics.length();
            for(int j=0; j<minute; ++j){
                sb.append(lylics.charAt(k));
                k = (k+1) % lylicsLen;
                if(lylics.charAt(k) == '#'){
                    sb.append('#');
                    k = (k+1) % lylicsLen;
                }
            }
            songs.add(new Song(title, sb.toString()));
        }
        int playTime = 0;
        String answer = "(None)";
        char mLast = m.charAt(m.length()-1);
        for (Song song : songs) {
            String lylics = song.play;
            int songLen = lylics.length();
            if(playTime>=songLen) continue;

            while(true){
                int idx = lylics.indexOf(m);
                if(idx==-1) break;
                if(mLast!='#'){
                    int next = idx+m.length();
                    if(next!=lylics.length()) {
                        char songLast = lylics.charAt(next);
                        if(songLast=='#'){
                            lylics = lylics.substring(next);
                            continue;
                        }
                    }
                }
                answer = song.title;
                playTime = songLen;
                break;
            }
        }
        return answer;
    }
}

class Song {
    String title;
    String play;
    public Song(String title, String play) {
        this.title = title;
        this.play = play;
    }
}