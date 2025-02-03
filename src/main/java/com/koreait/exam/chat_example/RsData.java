package com.koreait.exam.chat_example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RsData<T> {
    private String resultCode;
    private String msg;
    private T data;  // object는 범위가 너무 넓어서 제너릭을 사용한다
}
