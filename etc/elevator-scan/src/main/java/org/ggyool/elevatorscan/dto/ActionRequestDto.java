package org.ggyool.elevatorscan.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.ggyool.elevatorscan.domain.Command;

import java.util.List;

@Getter
@NoArgsConstructor
public class ActionRequestDto {
    private List<Command> commands;

    @Builder
    public ActionRequestDto(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public String toString() {
        return "\n\nAction 요청" +
                "commands=" + commands +
                '}' + "\n";
    }
}
