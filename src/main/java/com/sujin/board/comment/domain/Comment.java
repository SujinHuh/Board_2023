package com.sujin.board.comment.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Comment")
@Table(name = "comment")
@AllArgsConstructor // 자동으로 생성자
@NoArgsConstructor
@Getter @Setter
@ToString
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동 증가 값.

    private Long id;
    private Long boardId; // boardid연관
    @NonNull
    private String content;
    @NonNull
    private String createDate;


}
