package com.koreait.exam.chat_example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ChatMessage {
    private long id;
    private LocalDateTime createDate;
    private String authorName;
    private String content;

    public ChatMessage(String authorName, String content) {
        this(ChatMessageIdGenerator.getNextId(), LocalDateTime.now(), authorName, content);  // 다른 생성자를 호출한다. -> AllArgsConstructor
    }
}

class ChatMessageIdGenerator {

    private static long id = 0;

    public static long getNextId() {
        return ++id;
    }
}