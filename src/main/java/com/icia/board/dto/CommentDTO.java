package com.icia.board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CommentDTO {
    private Long id;
    private String comment_writer;
    private String comment_contents;
    private String board_id;

}
