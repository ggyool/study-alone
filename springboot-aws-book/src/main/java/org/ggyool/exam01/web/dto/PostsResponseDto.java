package org.ggyool.exam01.web.dto;

import lombok.Getter;
import org.ggyool.exam01.domain.posts.Posts;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts posts){
        id = posts.getId();
        title = posts.getTitle();
        content = posts.getContent();
        author = posts.getAuthor();
    }
}
