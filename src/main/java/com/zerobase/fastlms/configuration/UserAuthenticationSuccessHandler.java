package com.zerobase.fastlms.configuration;

import com.zerobase.fastlms.main.utils.RequestUtils;
import com.zerobase.fastlms.member.LoginHistory.LoginHistoryService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@Component
public class UserAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final LoginHistoryService loginHistoryService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        loginHistoryService.logging(
                authentication.getName(),
                RequestUtils.getUserAgent(request),
                RequestUtils.getClientIP(request)
        );

        System.out.println("로그인에 성공하였습니다.");

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
