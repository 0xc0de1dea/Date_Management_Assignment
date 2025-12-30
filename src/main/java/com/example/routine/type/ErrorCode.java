package com.example.routine.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    NOT_FOUND_AUTHOR("해당하는 저자를 찾을 수 없습니다."),
    NOT_FOUND_ID("해당하는 아이디를 찾을 수 없습니다."),
    UN_MATCH_CONFIRM_PASSWORD("비밀번호가 일치하지 않습니다.");

    private final String description;
}
