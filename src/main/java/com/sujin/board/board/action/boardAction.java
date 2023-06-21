package com.sujin.board.board.action;

import com.sujin.board.board.domain.Board;
import com.sujin.board.board.repository.BoardRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor//repository값 자동 할당

public class BoardAction {
    private final BoardRepository boardRepository;

    /***
     *
     get -> return string (page 이동)
     post -> return response (api 호출)
     */

    /********************************
     * 기능 : boardList
     * @return
     **********************************/
    @GetMapping("/boardList")
    public String boardList (){

        return "board/boardList";
    }

//        @ResponseBody
    @PostMapping("/addBoard")
    public String addBoard(@RequestParam ("boardList") String boardList){
        //DB저장
        //1. boardLsit를 쓴다. 2. 저장한다.
        Board board = new Board();
        board.setBoardId(boardList);// 1. boardLsit 값 넣
        boardRepository.save(board);// 2. boardLsit 저장
        System.out.println(boardList);
        return "board/boardList";
    }
}

