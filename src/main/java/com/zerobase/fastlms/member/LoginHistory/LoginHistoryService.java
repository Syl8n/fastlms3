package com.zerobase.fastlms.member.LoginHistory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LoginHistoryService {

    private final LoginHistoryRepository loginHistoryRepository;

    public void logging(String id, String userAgent, String ip, LocalDateTime ldt){
        loginHistoryRepository.save(LoginHistory.builder()
                .loginId(id)
                .loginDt(ldt)
                .userAgent(userAgent)
                .ip(ip)
                .build());
    }

    public List<LoginHistoryDto> getHistoryByUserId(String userId) {
        return loginHistoryRepository.findByLoginId(userId).map(LoginHistoryDto::of).orElse(null);
    }
}
