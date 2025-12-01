package com.example.umc9th2.global.validator;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER) // 메서드 파라미터에 사용
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidPage {
}
