package com.koi.thejieun.gallery.service;

import com.koi.thejieun.exception.MyException;
import com.koi.thejieun.gallery.dto.GalleryDTO;
import com.koi.thejieun.util.PageGroup;

public interface GalleryService {
    /**
     * 갤러리를 추가한다.
     *
     * @param galleryDTO 갤러리 dto
     * @throws MyException
     */
    public void addGallery(GalleryDTO galleryDTO) throws MyException;

    /**
     * 갤러리 목록을 페이징 처리하여 조회한다.
     *
     * @param currentPage 현재 페이지
     * @return currentPage에 해당하는 갤러리 목록
     * @throws MyException
     */
    public PageGroup<GalleryDTO> findGalleryList(Integer currentPage) throws MyException;

    /**
     * galleryNo에 해당하는 갤러리를 상세 조회한다.
     *
     * @param galleryNo 갤러리 번호
     * @return galleryNo에 해당하는 갤러리
     * @throws MyException
     */
    public GalleryDTO findByGalleryNo(Long galleryNo) throws MyException;

    /**
     * 갤러리를 수정한다.
     *
     * @param galleryDTO 갤러리 dto
     * @throws MyException
     */
    public void modifyGallery(GalleryDTO galleryDTO) throws MyException;

    /**
     * galleryNo에 해당하는 갤러리를 삭제한다.
     *
     * @param galleryNo 갤러리 번호
     * @throws MyException
     */
    public void removeGallery(Long galleryNo) throws MyException;
}
