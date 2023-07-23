package com.sujin.board.constants.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sujin.board.board.domain.Board;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor // 자동으로 생성자
@NoArgsConstructor
@Getter @Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동 증가 값.

    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="board_id")
    @JsonBackReference
    private Board board; // boardid연관

    @NonNull
    private String content;
    @NonNull
    private String createDate;


}
