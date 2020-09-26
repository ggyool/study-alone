package org.ggyool.elevatorscan.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.*;

@Getter
@NoArgsConstructor
public class FloorInformation {

    private int maxFloor;
    List<Call>[] infos;
    HashSet<Long> visited;

    @Builder
    public FloorInformation(List<Call> calls, int maxFloor) {
        visited = new HashSet<>();
        this.maxFloor = maxFloor;
        infos = new List[maxFloor+1];
        for(int i=0; i<=maxFloor; ++i){
            infos[i] = new ArrayList<>();
        }
        for (Call call : calls) {
            int floor = call.getStart().intValue();
            Long id = call.getId();
            infos[floor].add(call);
        }
    }

    public void setVisited(Call call){
        Long id = call.getId();
        visited.add(id);
    }
    public boolean isVisited(Call call){
        Long id = call.getId();
        return visited.contains(id);
    }
    public List<Call> getInfo(int floor){
        return infos[floor];
    }

    @Override
    public String toString() {
        String ret = "\n";
        ret += "층 정보\n";
        for(int i=1; i<=maxFloor; ++i){
            if(getInfo(i).size()>0){
                ret += i+"층: " + getInfo(i) + "\n";
            }
        }
        return ret;
    }


}
