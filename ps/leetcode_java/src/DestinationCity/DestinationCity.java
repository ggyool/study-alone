package DestinationCity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DestinationCity {
    public String destCity(List<List<String>> paths) {
        HashSet<String> outDegrees = new HashSet<>();
        List<String> candidates = new ArrayList<>();
        for(int i=0; i<paths.size(); ++i){
            List<String> info = paths.get(i);
            String from = info.get(0);
            String to = info.get(1);
            outDegrees.add(from);
            candidates.add(to);
        }
        for(String s : candidates){
            if(!outDegrees.contains(s)) return s;
        }
        return "";
    }
}
