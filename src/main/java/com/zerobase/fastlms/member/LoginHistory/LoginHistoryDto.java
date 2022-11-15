package com.zerobase.fastlms.member.LoginHistory;

import com.zerobase.fastlms.course.dto.CourseDto;
import com.zerobase.fastlms.course.dto.TakeCourseDto;
import com.zerobase.fastlms.course.entity.Course;
import com.zerobase.fastlms.course.entity.TakeCourse;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginHistoryDto {
    long id;

    LocalDateTime loginDt;

    String userAgent;
    String ip;

    long seq;

    public static LoginHistoryDto of(LoginHistory x) {

        return LoginHistoryDto.builder()
                .id(x.getId())
                .loginDt(x.getLoginDt())
                .userAgent(x.getUserAgent())
                .ip(x.getIp())
                .build();
    }

    public static List<LoginHistoryDto> of(List<LoginHistory> histories) {

        if (histories == null) {
            return null;
        }

        Collections.sort(histories);
        int count = histories.size();
        int i = 0;
        List<LoginHistoryDto> historyDtoList = new ArrayList<>();
        for(LoginHistory x : histories) {
            LoginHistoryDto loginHistoryDto = LoginHistoryDto.of(x);
            loginHistoryDto.setSeq(count - i++);
            historyDtoList.add(loginHistoryDto);
        }
        return historyDtoList;
    }

    public String getLoginDtText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
        return loginDt != null ? loginDt.format(formatter) : "";
    }
}
