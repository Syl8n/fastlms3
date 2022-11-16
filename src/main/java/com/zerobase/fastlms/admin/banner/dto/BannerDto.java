package com.zerobase.fastlms.admin.banner.dto;

import com.zerobase.fastlms.admin.banner.entity.Banner;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BannerDto {
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

    //추가컬럼
    long totalCount;
    long seq;

    public static BannerDto of(Banner banner){
        if(banner == null){
            return null;
        }

        return BannerDto.builder()
                .id(banner.getId())
                .name(banner.getName())
                .filename(banner.getFilename())
                .urlFilename(banner.getUrlFilename())
                .imagePath(banner.getImagePath())
                .openMethod(banner.getOpenMethod())
                .sortValue(banner.getSortValue())
                .visible(banner.isVisible())
                .visibleFrom(banner.getVisibleFrom())
                .visibleTo(banner.getVisibleTo())
                .regDt(banner.getRegDt())
                .registeredBy(banner.getRegisteredBy())
                .updateDt(banner.getUpdateDt())
                .updatedBy(banner.getUpdatedBy())
                .build();
    }

    public static List<BannerDto> of(List<Banner> banners){
        if (banners == null) {
            return null;
        }

        List<BannerDto> bannerList = new ArrayList<>();
        for(Banner x : banners) {
            bannerList.add(BannerDto.of(x));
        }
        return bannerList;
    }

    public String getRegDtText() {
        return regDt != null ? regDt.toLocalDate().toString() : "";
    }

    public String getUdtDtText() {
        return updateDt != null ? updateDt.toLocalDate().toString() : "";
    }
}
