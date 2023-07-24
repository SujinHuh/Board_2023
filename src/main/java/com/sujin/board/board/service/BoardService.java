package com.sujin.board.board.service;

import com.sujin.board.board.domain.Board;
import com.sujin.board.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//비지니스 로직, 트랜젝션
@Service
@RequiredArgsConstructor //생성자를 통한 의존성 주입 자동으로 final 키워드 필드찾아서./ final 붙지 않은 필드가 있을수도 있기에 @AllArgsConstructor유연함.
public class BoardService {
    private final BoardRepository boardRepository;
    /* Paging */
    @Transactional(readOnly = true) //DB 작업은 트랜잭션 안에서 수행
    public Page<Board> pageList(int page) {

        PageRequest pageRequest = PageRequest.of(page, 10); // 페이지네이션을 위한 PageRequest, 페이지는 0으로 고정한다.

        return boardRepository.findAll(pageRequest);
    }
}
