package com.zerobase.fastlms.configuration;

import com.zerobase.fastlms.main.utils.RequestUtils;
import com.zerobase.fastlms.member.LoginHistory.LoginHistoryService;
import com.zerobase.fastlms.member.service.MemberService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class UserAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final LoginHistoryService loginHistoryService;
    private final MemberService memberService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        LocalDateTime ldt = LocalDateTime.now();
        loginHistoryService.logging(
                authentication.getName(),
                RequestUtils.getUserAgent(request),
                RequestUtils.getClientIP(request),
                ldt
        );

        memberService.loggingLogInDt(authentication.getName(), ldt);

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
