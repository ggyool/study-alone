package org.ggyool.elevatorscan.domain;

import lombok.Getter;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Elevator {
    private Long id;
    private Long floor;
    private List<Call> passengers;
    private Status status;

    private static final int MAX_NUM_OF_PEOPLE = 8;
    private Long maxFloor;
    private Long minFloor;
    private FloorInformation floorInformation;
    private Direction[] directions;

    public void additionalInit(Long minFloor, Long maxFloor, FloorInformation floorInformation, Direction[] directions){
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        this.floorInformation = floorInformation;
        this.directions = directions;
    }

    public Command decideCommand(){
        List<Long> dropOffList = getDropOffList();
        // 현재 층에 내려야 할 승객이 잇으면 내려준다.
        if(dropOffList.size()>0){
            return getDropOffCommand(dropOffList);
        }
        // 현재 층에 태울 수 있는 승객이 있으면 태운다.
        List<Long> dropInList = getDropInList();
        if(dropInList.size()>0){
            return getDropInCommand(dropInList);
        }
        return getMoveCommand();
    }

    // 현재 층에 내려야 할 목록을 반환한다.
    List<Long> getDropOffList(){
        List<Long> ret = new ArrayList<>();
        for(int i=0; i<passengers.size(); ++i){
            Call call = passengers.get(i);
            if(call.getEnd() == floor){
                ret.add(call.getId());
            }
            if(floor==maxFloor && call.getEnd()>floor){
                ret.add(call.getId());
            }
            if(floor==minFloor && call.getEnd()<floor){
                ret.add(call.getId());
            }
        }
        return ret;
    }

    private Command getDropOffCommand(List<Long> dropOffList){
        CommandType commandType = CommandType.STOP;
        if(isMoving()) commandType = CommandType.STOP;
        if(isStopped()) commandType = CommandType.OPEN;
        if(isOpened()) commandType = CommandType.EXIT;
        return Command.builder().command(commandType)
                                .call_ids(dropOffList)
                                .elevator_id(id).build();
    }

    // 방향이 같은 애들만 태운다.
    // 최소층 최대층일 때 따로 처리를 한다.
    private List<Long> getDropInList(){
        List<Long> ret = new ArrayList<>();
        List<Call> currentFloorInfo = floorInformation.getInfo(floor.intValue());
//        System.out.println("current:" + currentFloorInfo);
        for (Call call : currentFloorInfo) {
            if(floorInformation.isVisited(call)) continue;
            if(passengers.size() + ret.size()>=MAX_NUM_OF_PEOPLE) break;
            Long start = call.getStart();
            Long end = call.getEnd();
            boolean upPeople = (end-start>0);
            boolean downPeople = !upPeople;
            if(floor==maxFloor){
                if(downPeople){
                    floorInformation.setVisited(call);
                    ret.add(call.getId());
                }
            }
            else if(floor==minFloor){
                if(upPeople){
                    floorInformation.setVisited(call);
                    ret.add(call.getId());
                }
            }
            else {
                if(isUpDirection() && upPeople){
                    floorInformation.setVisited(call);
                    ret.add(call.getId());
                }
                if(isDownDirection() && downPeople){
                    floorInformation.setVisited(call);
                    ret.add(call.getId());
                }
            }
        }
//        System.out.println("-------------태울목록----------------");
//        System.out.println(ret);
//        System.out.println("-----------------------------");
        return ret;
    }

    private Command getDropInCommand(List<Long> dropInList) {
        CommandType commandType = CommandType.STOP;
        if(isMoving()) commandType = CommandType.STOP;
        if(isStopped()) commandType = CommandType.OPEN;
        if(isOpened()) commandType = CommandType.ENTER;
        return Command.builder().command(commandType)
                .call_ids(dropInList)
                .elevator_id(id).build();
    }

    private Command getMoveCommand(){
//        System.out.println("-------------current dir---------------");
//        System.out.println("--------------" + directions[id.intValue()] + "---------------");
        CommandType commandType = CommandType.STOP;
        if(isOpened()) commandType = CommandType.CLOSE;
        else if(floor==maxFloor){
            directions[id.intValue()] = Direction.DOWN;
            if(isUpward()) commandType = CommandType.STOP;
            else commandType = CommandType.DOWN;
        }
        else if(floor==minFloor){
            directions[id.intValue()] = Direction.UP;
            if(isDownward()) commandType = CommandType.STOP;
            else commandType = CommandType.UP;
        }
        else{
            if(isUpward()) commandType = CommandType.UP;
            if(isDownward()) commandType = CommandType.DOWN;
            if(isStopped()){
                if(isUpDirection()) commandType = CommandType.UP;
                if(isDownDirection()) commandType = CommandType.DOWN;
            }
        }
        return Command.builder().command(commandType)
                .elevator_id(id).build();
    }

    private boolean isUpDirection(){
        return directions[id.intValue()]==Direction.UP;
    }
    private boolean isDownDirection(){
        return directions[id.intValue()]==Direction.DOWN;
    }
    private boolean isMoving(){ return isUpward() || isDownward(); }
    private boolean isUpward(){ return status == Status.UPWARD; }
    private boolean isDownward(){ return status == Status.DOWNWARD; }
    private boolean isStopped(){ return status == Status.STOPPED; }
    private boolean isOpened(){ return status == Status.OPENED; }

    @Override
    public String toString() {
        return "id: " + id + ", 층: " + floor + ", 승객: " + passengers + ", 상태: " + status;
    }
}
