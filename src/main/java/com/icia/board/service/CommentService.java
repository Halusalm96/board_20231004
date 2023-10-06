package com.icia.board.service;

import com.icia.board.dto.CommentDTO;
import com.icia.board.entity.CommentEntity;
import com.icia.board.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    public Long save(CommentDTO commentDTO)throws IOException {
        CommentEntity commentEntity = CommentEntity.toCommentEntity(commentDTO);
        return commentRepository.save(commentEntity).getId();
    }
}
