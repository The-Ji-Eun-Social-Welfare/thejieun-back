package com.koi.thejieun.banner.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Banner")
@DynamicInsert
@SequenceGenerator(
        name = "banner_no_seq_generator",
        sequenceName = "banner_no_seq",
        initialValue = 1,
        allocationSize = 1)
/* 배너 Entity */
public class Banner {
    @Id
    @Column(name="banner_no")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "banner_no_seq_generator")
    // [PK] 배너 번호
    private Long bannerNo;

    @Column(name="img_path")
    // 이미지 경로
    private String imgPath;
}
