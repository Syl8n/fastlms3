package com.zerobase.fastlms.member.LoginHistory;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class LoginHistory implements Comparable<LoginHistory>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String loginId;

    LocalDateTime loginDt;

    String userAgent;
    String ip;

    @Override
    public int compareTo(LoginHistory a) {
        if(this.loginDt.isBefore(a.loginDt)){
            return 1;
        } else if(this.loginDt.isAfter(a.loginDt)){
            return -1;
        }
        return 0;
    }
}
