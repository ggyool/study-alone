package org.ggyool.elevatorscan.dto;

import lombok.Getter;
import org.ggyool.elevatorscan.domain.Elevator;

import java.util.List;

@Getter
public class ActionResponseDto {
    private String token;
    private Long timestamp;
    private List<Elevator> elevators;
    private Boolean is_end;
    @Override
    public String toString() {
        return "\nAction 응답\n" +
                elevators + "\n" +
                timestamp + "초";
    }
}
