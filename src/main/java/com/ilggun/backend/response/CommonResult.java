package com.ilggun.backend.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * API 의 실행 결과를 담는 공통 모델
 * api 의 처리 상태 및 메시지를 내려주는 데이터로 구성됨.
 * success 는 api 의 성공/실패 여부를 나타내고
 * code, msg 는 해당 상황에서의 응답 코드와 응답 메시지를 나타낸다.
 */

@Getter
@Setter
public class CommonResult {
    @ApiModelProperty(value = "응답 성공 여부 : true/false")
    private boolean success;

    @ApiModelProperty(value = "응답 코드 번호 : >= 0 정상, < 0 비정상")
    private int code;

    @ApiModelProperty(value = "응답 메시지")
    private String msg;
}
