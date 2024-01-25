package com.koi.thejieun.gallery.entity;

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
@Table(name = "Image")
@DynamicInsert
@SequenceGenerator(
        name = "image_no_seq_generator",
        sequenceName = "image_no_seq",
        initialValue = 1,
        allocationSize = 1)
/* 갤러리 이미지 Entity */
public class Image {
    @Id
    @Column(name = "img_no")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_no_seq_generator")
    // 이미지 번호
    private Long imgNo;

    @Column(name = "gall_no")
    // 갤러리 번호
    private Long gallNo;
}
