package com.koi.thejieun.gallery.entity;

import com.koi.thejieun.gallery.dto.GalleryDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Gallery")
@DynamicInsert
@SequenceGenerator(
        name = "gallery_no_seq_generator",
        sequenceName = "gallery_no_seq",
        initialValue = 1,
        allocationSize = 1)
/* 갤러리 Entity */
public class Gallery {
    @Id
    @Column(name = "gall_no")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gallery_no_seq_generator")
    // [PK] 갤러리 번호
    private Long gallNo;

    @Column(name = "gall_title")
    // 갤러리 제목
    private String gallTitle;

    @Column(name = "gall_content")
    // 갤러리 내용
    private String gallContent;

    @Column(name = "gall_regdate")
    @ColumnDefault(value = "CURRENT_DATE")
    // 갤러리 생성일
    private String gallRegdate;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "gall_no")
    // 이미지 목록
    private List<Image> imageList;

    // 갤러리 제목 및 내용 수정 메소드
    public void modifyGallInfo(GalleryDTO galleryDTO) {
        this.gallTitle = galleryDTO.getGallTitle();
        this.gallContent = galleryDTO.getGallContent();
    }
}
