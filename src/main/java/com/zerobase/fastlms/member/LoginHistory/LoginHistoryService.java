package com.zerobase.fastlms.member.LoginHistory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class LoginHistoryService {

    private final LoginHistoryRepository loginHistoryRepository;

    public void logging(String id, String userAgent, String ip){
        loginHistoryRepository.save(LoginHistory.builder()
                .loginId(id)
                .loginDt(LocalDateTime.now())
                .userAgent(userAgent)
                .ip(ip)
                .build());
    }
}
