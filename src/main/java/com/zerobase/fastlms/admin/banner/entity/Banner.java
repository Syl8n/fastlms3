package com.zerobase.fastlms.admin.banner.entity;

import com.zerobase.fastlms.member.entity.MemberCode;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String filename;
    private String urlFilename;
    private String imagePath;
    private String openMethod;
    private long sortValue;
    private boolean visible;
    private LocalDateTime visibleFrom;
    private LocalDateTime visibleTo;
    private LocalDateTime regDt;
    private String registeredBy;
    private LocalDateTime updateDt;
    private String updatedBy;
}
