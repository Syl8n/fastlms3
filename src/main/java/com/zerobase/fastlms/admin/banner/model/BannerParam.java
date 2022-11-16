package com.zerobase.fastlms.admin.banner.model;

import com.zerobase.fastlms.admin.model.CommonParam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BannerParam extends CommonParam {

    long id;
    boolean visible;
    boolean filtering;

    public BannerParam(boolean visible) {
        this.visible = visible;
        this.filtering = true;
    }
}
