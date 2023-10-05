package com.icia.board.entity;

import com.icia.board.dto.BoardDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter(AccessLevel.PRIVATE)
@Getter
@Table(name = "board_table")
public class BoardEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20)
    private String boardWriter;
    @Column(nullable = false, length = 50)
    private String boardTitle;
    @Column(nullable = false, length = 20)
    private String boardPassword;
    @Column(length = 500)
    private String boardContents;
    @Column
    private int boardHits;

    public static BoardEntity toBoardEntity (BoardDTO boardDTO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardPassword(boardDTO.getBoardPassword());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        return boardEntity;
    }

    public static BoardEntity toUpdateEntity(BoardDTO boardDTO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setId(boardDTO.getId());
        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardPassword(boardDTO.getBoardPassword());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        return boardEntity;
    }
}
