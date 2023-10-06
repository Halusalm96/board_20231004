package com.icia.board.entity;

import com.icia.board.dto.CommentDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter(AccessLevel.PRIVATE)
@Getter
@Table(name = "comment_table")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20)
    private String commentWriter;
    @Column(nullable = false, length = 200)
    private String commentContents;
    @ManyToOne
    @JoinColumn(name = "board_id", referencedColumnName = "id")
    private BoardEntity boardEntity;

    public static CommentEntity toCommentEntity (CommentDTO commentDTO) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setId(commentDTO.getId());
        commentEntity.setCommentWriter(commentDTO.getCommentContents());
        commentEntity.setCommentContents(commentDTO.getCommentContents());
        return commentEntity;
    }
}
