package com.sujin.board.board.action;

import com.sujin.board.constants.ResponseVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class boardAction {
    /***
     *
     get -> return string (page 이동)
     post -> return response (api 호출)
     */
    /********************************
     * 기능 : boardList
     * @return
     */
    @GetMapping("/boardList")
    @ResponseBody public String boardList (){

        return "boardList";
    }
}
