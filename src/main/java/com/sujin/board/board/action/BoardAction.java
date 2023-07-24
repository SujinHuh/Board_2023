package com.sujin.board.board.action;

import com.sujin.board.board.domain.Board;
import com.sujin.board.board.service.BoardService;
import com.sujin.board.constants.domain.Comment;
import com.sujin.board.board.repository.BoardRepository;
import com.sujin.board.constants.repository.CommentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Controller
@AllArgsConstructor //repository값 자동 할당  << 생성자를 자동으로 DI해주는거.
public class BoardAction {
    /***
     *
     get -> return string (page 이동)
     post -> return response (api 호출)
     */

    private final BoardRepository boardRepository;
    private final BoardService boardService;

    private final CommentRepository commentRepository;

    /********************************
     * 기능 : boardList
     * @return
     **********************************/
    @GetMapping("/boardList")
    public String boardList(Model model){
        int page = 0;
        // paging
        //List<Board> boardLists = boardRepository.findAll();
        //model.addAttribute("boardLists", boardLists);
        model.addAttribute("boardLists",boardService.pageList(page));
        log.info("posts>>>> " + model);
        //System.out.println(">>>>> " + boardLists);
        return "board/boardList";
    }

    //post 페이징
    @PostMapping("/boardList")
    @ResponseBody
    public Page<Board> boardList(@RequestParam int page){
        return boardService.pageList(page);
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
        return "/board/addBoard";
    }

    @PostMapping("/board/view/{id}")
    @ResponseBody
    public Board view(@PathVariable Long id ) {
        // null체크
        System.out.println("id " + id);

        //  board부를때 commentList도 불려줘야함.

        return boardRepository.findById(id).orElse(null);
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

    @PostMapping("/addComment")
    @ResponseBody
    public Comment addComment(@RequestBody Comment comment){
        commentRepository.save(comment);
        return comment;
    }

}

