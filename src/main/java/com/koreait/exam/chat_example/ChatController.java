package com.koreait.exam.chat_example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chat") // class에 RequestMapping annotation 추가시 class의 모든 메서드에 적용
public class ChatController {

    @GetMapping("/writeMessage")
    @ResponseBody  // 화면에서 보려면 사용해야 하는 annotation
    public String writeMessage() {
        return "메세지가 작성됨";
    }

}
