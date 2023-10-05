package com.icia.board.controller;

import com.icia.board.dto.BoardDTO;
import com.icia.board.service.BoardService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
//@RequestMapping("boardPage")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/save")
    public String boardSave() {
        return "/boardSave";
    }

    @PostMapping("/board/save")
    public String Save(@ModelAttribute BoardDTO boardDTO, Model model) {
        boardService.save(boardDTO);
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "/boardList";
    }

    @GetMapping("/board")
    public String boardList(Model model) {
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "/boardList";
    }

    @GetMapping("/board/{id}")
    public String boardDetail(@PathVariable("id") Long id, Model model) {
        BoardDTO boardDTO = boardService.findById(id);
        boardService.increaseHits(id);
        model.addAttribute("boardDetail", boardDTO);
        return "/boardDetail";
    }

    @GetMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable Long id, Model model) {
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "/boardUpdate";
    }

    @GetMapping("/board/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        boardService.delete(id);
        return "/index";
    }

//    @DeleteMapping("/board/{id}")
//    public ResponseEntity deleteByAxios(@PathVariable("id") Long id) {
//        boardService.delete(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @PutMapping("/board/detail/${id}")
    public ResponseEntity update(@RequestBody BoardDTO boardDTO) {
        boardService.update(boardDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
