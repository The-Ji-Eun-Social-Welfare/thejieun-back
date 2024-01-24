package com.koi.thejieun.banner.service;

import com.koi.thejieun.banner.dto.BannerDTO;
import com.koi.thejieun.exception.MyException;

public interface BannerService {
    /**
     * 배너 사진 추가
     * @param bannerDTO 배너 dto
     * @throws MyException
     * */
    public void addBanner(BannerDTO bannerDTO) throws MyException;


    /**
    * bannerNo의 배너를 조회한다.
     * @param bannerNo 배너 번호
     * @return bannerNo에 해당하는 배너
     * @throws MyException
    * */
    public BannerDTO findByNoticeNo(Long bannerNo) throws MyException;



    /**
     * 배너를 수정한다.
     * @param bannerDTO 배너 dto
     * @throws MyException
     */
    public void modifyBanner(BannerDTO bannerDTO) throws MyException;

    /**
     * bannerNo의 내용을 삭제한다.
     * @param bannerNo 배너 번호
     * @throws MyException
     */
    public void removeBanner(Long bannerNo) throws MyException;
}
