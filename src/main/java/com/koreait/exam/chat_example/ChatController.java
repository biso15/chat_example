package com.koreait.exam.chat_example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chat") // class에 RequestMapping annotation 추가시 class의 모든 메서드에 적용
public class ChatController {

    private List<ChatMessage> chatMessages = new ArrayList<ChatMessage>();

    // record가 아닐 때
    @AllArgsConstructor
    @Getter
    public static class writeChatMessageRequest {  // class 안에 class 가능
        private final String authorName;
        private final String content;
    }

//    public record writeChatMessageRequest(String authorName, String content) {
//
//    }

    public record writeChatMessageResponse(long id) {

    }

    @PostMapping("/writeMessage")
    @ResponseBody  // 화면에서 보려면 사용해야 하는 annotation
    public RsData<writeChatMessageResponse> writeMessage(@RequestBody writeChatMessageRequest req) {  // record가 아닐 때
//    public RsData<writeChatMessageResponse> writeMessage(@RequestBody writeChatMessageRequest req) {

         ChatMessage message = new ChatMessage(req.authorName, req.content);  // record가 아닐 때
//        ChatMessage message = new ChatMessage(req.authorName(), req.content());
        chatMessages.add(message);
        return new RsData<>(
            "S-1",
            "메세지가 작성됨",
            new writeChatMessageResponse(message.getId())
        );
    }

    public record messagesResponse(List<ChatMessage> messages, long count) {

    }

    @GetMapping("/messages")
    @ResponseBody  // 화면에서 보려면 사용해야 하는 annotation
    public RsData<messagesResponse> messages() {
        return new RsData<>(
                "S-1",
                "메세지 리스트",
                new messagesResponse(chatMessages, chatMessages.size())
        );
    }
}



//    @GetMapping("/message")
//    @ResponseBody  // 화면에서 보려면 사용해야 하는 annotation
//    public RsData<List<ChatMessage>> messages() {
////        ChatMessage message = new ChatMessage("김철수", "안녕");
////        chatMessages.add(message);
//        return new RsData<>(
//                "S-1",
//                "메세지가 작성됨",
//                new writeChatMessageResponse(new ChatMessage)
//        );
//    }