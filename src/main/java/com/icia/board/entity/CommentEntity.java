package com.icia.board.entity;

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
    private String comment_writer;
    @Column(nullable = false, length = 200)
    private String comment_contents;
    @ManyToOne
    @JoinColumn(name = "board_id", referencedColumnName = "id")
    private BoardEntity board;
}
