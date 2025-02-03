package com.koreait.exam.chat_example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chat") // class에 RequestMapping annotation 추가시 class의 모든 메서드에 적용
public class ChatController {

    private List<ChatMessage> chatMessages = new ArrayList<ChatMessage>();

    public record writeChatMessageResponse(long id) {  // class 안에 class 가능

    }

    @PostMapping("/writeMessage")
    @ResponseBody  // 화면에서 보려면 사용해야 하는 annotation
    public RsData<writeChatMessageResponse> writeMessage() {

        ChatMessage message = new ChatMessage("김철수", "안녕");
        chatMessages.add(message);
        return new RsData<>(
            "S-1",
            "메세지가 작성됨",
            new writeChatMessageResponse(message.getId())
        );
    }

}
