package com.koi.thejieun.gallery.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.koi.thejieun.gallery.entity.Image;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class GalleryDTO {
    private Long gallNo;
    private String gallTitle;
    private String gallContent;
    @JsonFormat(pattern = "yy-MM-dd", timezone = "Asia/Seoul")
    private String gallRegdate;
    private List<Image> imageList;
}
