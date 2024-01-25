package com.koi.thejieun.gallery.service;

import com.koi.thejieun.exception.MyException;
import com.koi.thejieun.gallery.dao.GalleryRepository;
import com.koi.thejieun.gallery.dto.GalleryDTO;
import com.koi.thejieun.gallery.dto.ImageDTO;
import com.koi.thejieun.gallery.entity.Gallery;
import com.koi.thejieun.gallery.entity.Image;
import com.koi.thejieun.util.PageGroup;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GalleryServiceImpl implements GalleryService {
    @Autowired GalleryRepository repository;

    @Override
    public void addGallery(GalleryDTO galleryDTO) throws MyException {
        List<Image> imageList = new ArrayList<>();
        for (ImageDTO img : galleryDTO.getImageList()) {
            Image image = Image.builder().gallNo(img.getGallNo()).build();
            imageList.add(image);
        }

        Gallery gallery =
                Gallery.builder()
                        .gallTitle(galleryDTO.getGallTitle())
                        .gallContent(galleryDTO.getGallContent())
                        .imageList(imageList)
                        .build();

        repository.save(gallery);
    }

    // 페이징 처리 아직 안 함
    @Override
    public PageGroup<GalleryDTO> findGalleryList(Integer currentPage) throws MyException {
        if (currentPage < 1) currentPage = 1;
        int cntPerPage = 10;

        int start;
        int end;
        end = currentPage * cntPerPage;
        start = (currentPage - 1) * cntPerPage + 1;
        return null;
    }

    @Override
    public GalleryDTO findByGalleryNo(Long galleryNo) throws MyException {
        Optional<Gallery> galleryOpt = repository.findById(galleryNo);
        Gallery gallery = galleryOpt.get();
        GalleryDTO galleryDTO =
                GalleryDTO.builder()
                        .gallNo(gallery.getGallNo())
                        .gallTitle(gallery.getGallTitle())
                        .gallContent(gallery.getGallContent())
                        .gallRegdate(gallery.getGallRegdate())
                        .build();
        return galleryDTO;
    }

    @Override
    public void modifyGallery(GalleryDTO galleryDTO) throws MyException {
        Optional<Gallery> galleryOpt = repository.findById(galleryDTO.getGallNo());
        Gallery gallery = galleryOpt.get();
        gallery.modifyGallInfo(galleryDTO);
        repository.save(gallery);
    }

    @Override
    public void removeGallery(Long galleryNo) throws MyException {
        repository.deleteById(galleryNo);
    }
}
