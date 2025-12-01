package com.example.umc9th2.global.validator;


import com.example.umc9th2.global.exception.InvalidPageException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidPageAspect {

    // @ValidPage가 붙은 파라미터를 검증
    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping) && args(.., @ValidPage page)")
    public void validatePage(int page) {
        if (page <= 0) {
            throw new InvalidPageException("page는 1 이상의 숫자만 허용됩니다.");
        }
    }
}
