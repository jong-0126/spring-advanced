package org.example.expert.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;

import java.time.LocalDateTime;

@Component
public class LoggerInterceptor implements HandlerInterceptor {

    private final Logger LOGGER = LoggerFactory.getLogger(LoggerInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //인증 성공 시 요청 시각과 URL 로깅
        String uri = request.getRequestURI();
        LocalDateTime now = LocalDateTime.now();

        LOGGER.info("인증된 요청 - 시간: {}, URL: {}", now, uri);
        return true;
    }
}
