package com.zerobase.fastlms.admin.banner.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpenMethods {
    String id;
    String desc;

    public static List<OpenMethods> init(){
        List<OpenMethods> list = new ArrayList<>();
        list.add(new OpenMethods("self", "현재 창"));
        list.add(new OpenMethods("blank", "새 창"));
        return list;
    }
}
