package org.ggyool.elevatorscan.dto;

import lombok.Getter;
import org.ggyool.elevatorscan.domain.Call;
import org.ggyool.elevatorscan.domain.Elevator;

import java.util.List;

@Getter
public class OnCallResponseDto {
    private String token;
    private Long timestamp;
    private List<Elevator> elevators;
    private List<Call> calls;
    private Boolean is_end;

    @Override
    public String toString() {
        return "\nOnCall 응답\n" +
                elevators + "\n" +
                calls;
    }
}
