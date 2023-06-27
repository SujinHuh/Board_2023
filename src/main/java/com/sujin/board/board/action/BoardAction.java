package com.sujin.board.board.action;

import com.sujin.board.board.domain.Board;
import com.sujin.board.board.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public String boardList(Model model) {
        List<Board> boardLists = boardRepository.findAll();
        model.addAttribute("boardLists", boardLists);
        System.out.println(">>>>> " + boardLists);
        return "board/boardList";
    }
    /**
    *
    * BoardAction
    *
    * @author sujin
    * @version 1.0.0
    * @dtae 2023-06-27
    *
    **/
    @GetMapping("/loadMore")
    public String pageLoad(@RequestParam("page") int page, Model model) {
        // 해당 페이지 번호에 해당하는 데이터를 가져와서 boardLists에 담는다.
        List<Board> boardLists = getBoardListsByPage(page); // 페이지에 따른 데이터를 가져오는 로직을 구현해야 함

        // 모델에 boardLists를 담아서 템플릿으로 전달
        model.addAttribute("boardLists", boardLists);

        return "board/boardList";
    }

    // @ResponseBody - ResourceEntity
    @PostMapping("/addBoard")
    @ResponseBody
    public Board addBoard(@RequestBody Board board) {
        //DB저장
        boardRepository.save(board);// 2. boardLsit 저장
        System.out.println(board.toString());

        return board;
    }

    @GetMapping("/addBoard")
    public String addBoard() {
        return "addBoard";
    }

    // 모달창으로 boardView - 페이지 이동
    @GetMapping("/board/view/{id}")
    public String view() {
        return "board/boardList";
    }

    @PostMapping("/board/view/{id}")
    @ResponseBody
    public Optional<Board> view(@PathVariable Long id ) {
        // null체크
        Optional<Board> boardList = boardRepository.findById(id);

        return boardList;
    }

    // 페이지 번호에 따른 데이터를 가져오는 메소드 (가상의 데이터 생성)
    private List<Board> getBoardListsByPage(int page) {
        List<Board> boardLists = new ArrayList<>();

        // 가상의 데이터 생성
        int pageSize = 10; // 페이지당 데이터 개수
        int totalDataCount = 100; // 전체 데이터 개수
        int startIdx = (page - 1) * pageSize;
        int endIdx = Math.min(startIdx + pageSize, totalDataCount);

        for (int i = startIdx; i < endIdx; i++) {
            Board board = new Board();
            board.setTitle("Title " + (i + 1));
            board.setContent("Content " + (i + 1));
            boardLists.add(board);
        }

        return boardLists;
    }

}

