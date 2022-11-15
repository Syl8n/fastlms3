package com.zerobase.fastlms.member.LoginHistory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {
    Optional<List<LoginHistory>> findByLoginId(String loginId);
}
