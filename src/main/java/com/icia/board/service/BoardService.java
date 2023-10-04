package com.icia.board.service;

import com.icia.board.dto.BoardDTO;
import com.icia.board.entity.BoardEntity;
import com.icia.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void save(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toBoardEntity(boardDTO);
        boardRepository.save(boardEntity);
    }

    public List<BoardDTO> findAll() {
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        boardEntityList.forEach(board -> {
            boardDTOList.add(BoardDTO.toBoardDTO(board));
        });
//        for(BoardEntity boardEntity : boardEntityList) {
//            boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));
//        }
        return boardDTOList;
    }

    public BoardDTO findById(Long id) {
        Optional<BoardEntity> boardEntityId = boardRepository.findById(id);
        if(boardEntityId.isPresent()) {
            BoardEntity boardEntity = boardEntityId.get();
            return BoardDTO.toBoardDTO(boardEntity);
        }else {
            return null;
        }
    }
}
