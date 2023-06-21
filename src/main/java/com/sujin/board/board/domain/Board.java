package com.sujin.board.board.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Board")
@Table(name = "board")
@AllArgsConstructor // 자동으로 생성자
@NoArgsConstructor // 아무것도 없는 생성자
@Getter @Setter
public class Board {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동 증가 값.
    private Long id;
    @NonNull
    private String boardId;
}
