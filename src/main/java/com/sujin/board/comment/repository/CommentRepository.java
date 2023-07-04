package com.sujin.board.comment.repository;

import com.sujin.board.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    /**
    *
    * CommentRepository
    *
    * @author sujin
    * @version 1.0.0
    * @dtae 2023-07-04
    *
    **/
}
