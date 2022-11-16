package com.zerobase.fastlms.admin.banner.service;

import com.zerobase.fastlms.admin.banner.dto.BannerDto;
import com.zerobase.fastlms.admin.banner.entity.Banner;
import com.zerobase.fastlms.admin.banner.mapper.BannerMapper;
import com.zerobase.fastlms.admin.banner.model.BannerInput;
import com.zerobase.fastlms.admin.banner.model.BannerParam;
import com.zerobase.fastlms.admin.banner.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BannerServiceImpl implements BannerService {

    private final BannerRepository bannerRepository;
    private final BannerMapper bannerMapper;

    @Override
    public boolean add(BannerInput parameter, String userName) {
        LocalDateTime localDateTime = LocalDateTime.now();
        Banner banner = Banner.builder()
                .id(parameter.getId())
                .name(parameter.getName())
                .imagePath(parameter.getImagePath())
                .openMethod(parameter.getOpenMethod())
                .sortValue(parameter.getSortValue())
                .visible(parameter.isVisible())
                .visibleFrom(parameter.getVisibleFrom())
                .visibleTo(parameter.getVisibleTo())
                .regDt(localDateTime)
                .registeredBy(userName)
                .updateDt(localDateTime)
                .updatedBy(userName)
                .build();
        if(parameter.getFilename() != null && parameter.getFilename().length() > 0) {
            banner.setFilename(parameter.getFilename());
            banner.setUrlFilename(parameter.getUrlFilename());
        }
        bannerRepository.save(banner);

        return true;
    }

    @Override
    public boolean set(BannerInput parameter, String userName) {

        Optional<Banner> optionalBanner = bannerRepository.findById(parameter.getId());
        if (!optionalBanner.isPresent()) {
            //수정할 데이터가 없음
            return false;
        }

        Banner banner = optionalBanner.get();
        banner.setName(parameter.getName());
        if(parameter.getFilename() != null && parameter.getFilename().length() > 0) {
            banner.setFilename(parameter.getFilename());
            banner.setUrlFilename(parameter.getUrlFilename());
        }
        banner.setImagePath(parameter.getImagePath());
        banner.setOpenMethod(parameter.getOpenMethod());
        banner.setSortValue(parameter.getSortValue());
        banner.setVisible(parameter.isVisible());
        banner.setUpdateDt(LocalDateTime.now());
        banner.setUpdatedBy(userName);

        bannerRepository.save(banner);

        return true;
    }

    @Override
    public BannerDto getById(long id) {
        return bannerRepository.findById(id).map(BannerDto::of).orElse(null);
    }

    @Override
    public boolean del(String idList) {

        if (idList != null && idList.length() > 0) {
            String[] ids = idList.split(",");
            for (String x : ids) {
                long id = 0L;
                try {
                    id = Long.parseLong(x);
                } catch (Exception e) {
                }

                if (id > 0) {
                    bannerRepository.deleteById(id);
                }
            }
        }

        return true;
    }

    @Override
    public BannerDto frontDetail(long id) {

        Optional<Banner> optionalBanner = bannerRepository.findById(id);
        if (optionalBanner.isPresent()) {
            return BannerDto.of(optionalBanner.get());
        }
        return null;
    }

    @Override
    public List<BannerDto> list(BannerParam parameter) {

        long totalCount = bannerMapper.selectListCount(parameter);

        List<BannerDto> list = bannerMapper.selectList(parameter);
        if (!CollectionUtils.isEmpty(list)) {
            int i = 0;
            for (BannerDto x : list) {
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - parameter.getPageStart() - i);
                i++;
            }
        }

        return list;
    }

}


























