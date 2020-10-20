package DesignUndergroundSystem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// HashMap의 key의 type에 주의해야 할 듯
public class UndergroundSystem {

    HashMap<List<String>, Double> totalTime;
    HashMap<List<String>, Integer> count;
    // 해당 id인 사람이 어디에서 몇시에 출발했는지
    HashMap<Integer, StartInfo> startTable;

    public UndergroundSystem() {
        totalTime = new HashMap<>();
        count = new HashMap<>();
        startTable = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        startTable.put(id, new StartInfo(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        StartInfo startInfo = startTable.get(id);
        List<String> path = Arrays.asList(startInfo.station, stationName);
        totalTime.put(path, totalTime.getOrDefault(path, 0.0D) + t-startInfo.startTime);
        count.put(path, count.getOrDefault(path, 0) + 1);
    }

    public double getAverageTime(String startStation, String endStation) {
        List<String> path = Arrays.asList(startStation, endStation);
        if(count.containsKey(path)==false) return 0.0D;
        return totalTime.get(path) / count.get(path);
    }

}

class StartInfo {
    String station;
    int startTime;
    public StartInfo(String station, int startTime) {
        this.station = station;
        this.startTime = startTime;
    }
}