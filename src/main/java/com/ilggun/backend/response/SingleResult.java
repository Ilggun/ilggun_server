package com.ilggun.backend.response;

import lombok.Getter;
import lombok.Setter;

/**
 * 결과가 단일건인 API 를 담는 모델
 * Generic Interface 에 <T> 를 지정하여 어떤 형태의 값도 넣을 수 있도록 구현했다.
 * 또한 CommonResult 를 상속받으므로 api 요청 결과도 같이 출력된다.
 * @param <T>
 */

@Getter
@Setter
public class SingleResult<T> extends CommonResult {
    private T data;
}
