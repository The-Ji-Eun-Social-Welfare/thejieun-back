package com.koi.thejieun.gallery.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ImageDTO {
    private Long imgNo;
    private Long gallNo;
}
