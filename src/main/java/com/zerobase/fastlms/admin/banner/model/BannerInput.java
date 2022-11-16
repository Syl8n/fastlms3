package com.zerobase.fastlms.admin.banner.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BannerInput {
    private long id;
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

    //삭제용
    String idList;
}
