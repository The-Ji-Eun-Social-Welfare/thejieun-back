package com.koi.thejieun.exception;

import static org.springframework.http.HttpStatus.*;

import lombok.AllArgsConstructor;
import lombok.Getter;

import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    /* 400 BAD_REQUEST : 잘못된 요청 */
    FILE_NOT_SAVED(BAD_REQUEST, "파일을 저장할 수 없습니다."),

    /* 401 UNAUTHORIZED : 사용자 인증실패 */
    UNAVAILABLE_REFRESH_TOKEN(UNAUTHORIZED, "유효하지 않은 접근입니다."),

    /* 403 FORBIDDEN : 인가 실패. 특정 리소스에 대한 권한 부족 */
    UNAUTHORIZED_ACCESS(FORBIDDEN, "접근권한이 없습니다."),

    /* 404 NOT_FOUND : Resource 를 찾을 수 없음 */
    FILE_NOT_FOUND(NOT_FOUND, "파일을 찾을 수 없습니다.");

    /* 304 NOT_MODIFIED : 클라이언트가 가지고 있는 Resource 가 수정되지 않았음 */

    /* 409 CONFLICT : Resource 의 현재 상태와 충돌. 보통 중복된 데이터 존재 */

    private final HttpStatus httpStatus;
    private final String detail;
}
