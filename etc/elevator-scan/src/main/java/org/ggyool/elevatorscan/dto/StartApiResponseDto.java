package org.ggyool.elevatorscan.dto;

import lombok.Getter;
import org.ggyool.elevatorscan.domain.Elevator;

import java.util.List;

@Getter
public class StartApiResponseDto {
    private String token;
    private Long timestamp;
    private List<Elevator> elevators;
    private boolean is_end;

    @Override
    public String toString() {
        return "startAPI 응답:{" +
                "token='" + token + '\'' + '}';
    }
}
