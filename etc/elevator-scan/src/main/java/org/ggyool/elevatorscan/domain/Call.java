package org.ggyool.elevatorscan.domain;

import lombok.Getter;

@Getter
public class Call {
    private Long id;
    private Long timestamp;
    private Long start;
    private Long end;

    @Override
    public String toString() {
        return "id: " + id + " " + start + "-->" + end;
    }
}
