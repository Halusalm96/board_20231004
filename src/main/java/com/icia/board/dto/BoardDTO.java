package com.icia.board.dto;

import com.icia.board.entity.BoardEntity;
import com.icia.board.util.UtilClass;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardDTO {
    private Long id;
    private String boardWriter;
    private String boardTitle;
    private String boardPassword;
    private String boardContents;
    private String createdAt;
    private int boardHits;
    private MultipartFile boardFile;
    private int fileAttached;
    private String originalFileName;
    private String storedFileName;

    public static BoardDTO toBoardDTO(BoardEntity boardEntity) {
//        BoardDTO boardDTO = new BoardDTO();
//        boardDTO.setId(boardEntity.getId());
//        boardDTO.setBoardWriter(boardEntity.getBoardWriter());
//        boardDTO.setBoardTitle(boardEntity.getBoardTitle());
//        boardDTO.setBoardPassword(boardEntity.getBoardPassword());
//        boardDTO.setBoardContents(boardEntity.getBoardContents());
//        boardDTO.setBoardHits(boardEntity.getBoardHits());
//        boardDTO.setCreatedAt(boardEntity.getCreatedAt());
//        String formattedDate = boardEntity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        boardDTO.setCreatedAt(formattedDate);
//        boardDTO.setCreatedAt((UtilClass.dateTimeFormat(boardEntity.getCreatedAt())));
        BoardDTO boardDTO = BoardDTO.builder()
                .id(boardEntity.getId())
                .boardContents(boardEntity.getBoardContents())
                .boardHits(boardEntity.getBoardHits())
                .boardPassword(boardEntity.getBoardPassword())
                .boardWriter(boardEntity.getBoardWriter())
                .boardTitle(boardEntity.getBoardTitle())
                .createdAt(UtilClass.dateTimeFormat(boardEntity.getCreatedAt()))
                .build();
        return boardDTO;

    }
}
