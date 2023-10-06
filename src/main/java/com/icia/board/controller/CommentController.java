package com.icia.board.controller;

import com.icia.board.dto.CommentDTO;
import com.icia.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    @PutMapping("/comment/save/{id}")
    public String commentSave(@ModelAttribute CommentDTO commentDTO) throws Exception{
        commentService.save(commentDTO);
        return "/boardList";
    }
}
