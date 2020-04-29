package org.ggyool.exam01.web.dto;

import lombok.Getter;

@Getter
// @NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;

    public PostsUpdateRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }
}
