package org.ggyool.elevatorscan.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class Command {
    private Long elevator_id;
    private CommandType command;
    private List<Long> call_ids;

    @Builder
    public Command(Long elevator_id, CommandType command, List<Long> call_ids) {
        this.elevator_id = elevator_id;
        this.command = command;
        this.call_ids = call_ids;
    }

    @Override
    public String toString() {
        return "eid: " + elevator_id + ", 요청: " + command;
    }
}
