package com.zerobase.fastlms.main.controller;


import com.zerobase.fastlms.admin.banner.dto.BannerDto;
import com.zerobase.fastlms.admin.banner.model.BannerParam;
import com.zerobase.fastlms.admin.banner.service.BannerService;
import com.zerobase.fastlms.components.MailComponents;
import com.zerobase.fastlms.main.utils.RequestUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MainController {

    private final BannerService bannerService;

    @RequestMapping("/")
    public String index(Model model, HttpServletRequest request,
                        BannerParam parameter) {
        parameter.setVisible(true);
        parameter.setFiltering(true);
        List<BannerDto> bannerDtoList = bannerService.list(parameter);
        model.addAttribute("list", bannerDtoList);
        return "index";
    }


    @RequestMapping("/error/denied")
    public String errorDenied() {

        return "error/denied";
    }


}
