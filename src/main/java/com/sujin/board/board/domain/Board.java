package com.sujin.board.board.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;


@Entity
@AllArgsConstructor // 자동으로 생성자
@NoArgsConstructor // 아무것도 없는 생성자
@Getter @Setter
public class Board {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동 증가 값.

    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String content;
    private String createDate;
    private String updateDate;
    private String deleteYn;

    @JsonManagedReference
    @OneToMany(mappedBy="board", fetch=FetchType.EAGER)
    private List<Comment> comment;

}
