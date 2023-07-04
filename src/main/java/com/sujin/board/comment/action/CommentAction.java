package com.sujin.board.comment.action;

import com.sujin.board.comment.domain.Comment;
import com.sujin.board.comment.repository.CommentRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@Slf4j
public class CommentAction {
    private final CommentRepository commentRepository;
    /***
     *
     get -> return string (page 이동)
     post -> return response (api 호출)
     */

    @PostMapping("/addComment")
    @ResponseBody
    public Comment addComment(@RequestBody Comment comment){

        commentRepository.save(comment);
        log.info("addComment!!");
        return comment;
    }
    @GetMapping("/addComment")
    public String addComment(){
        return "/board/boardList";
    }





}
