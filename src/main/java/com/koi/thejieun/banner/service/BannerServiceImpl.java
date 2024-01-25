package com.koi.thejieun.banner.service;

import com.koi.thejieun.banner.dao.BannerRepository;
import com.koi.thejieun.banner.dto.BannerDTO;
import com.koi.thejieun.banner.entity.Banner;
import com.koi.thejieun.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BannerServiceImpl implements BannerService {
    @Autowired private BannerRepository repository;

    @Override
    public void addBanner(BannerDTO bannerDTO) throws MyException {
        Banner banner = Banner.builder().imgPath(bannerDTO.getImgPath()).build();
        repository.save(banner);
    }

    @Override
    public List<BannerDTO> findByNoticeNo(Long bannerNo) throws MyException {
        List<Banner> bannerList = repository.findAll();
        List<BannerDTO> bannerDTOList = new ArrayList<>();
        for (Banner ban : bannerList) {
            BannerDTO bannerDTO =
                    BannerDTO.builder()
                            .bannerNo(ban.getBannerNo())
                            .imgPath(ban.getImgPath())
                            .build();
            bannerDTOList.add(bannerDTO);
        }
        return bannerDTOList;
    }

    @Override
    public void modifyBanner(BannerDTO bannerDTO) throws MyException {
        Optional<Banner> bannerOpt = repository.findById(bannerDTO.getBannerNo());
        Banner banner = bannerOpt.get();
        banner.modifyImgPath(bannerDTO.getImgPath());
        repository.save(banner);
    }

    @Override
    public void removeBanner(Long bannerNo) throws MyException {
        repository.deleteById(bannerNo);
    }
}
