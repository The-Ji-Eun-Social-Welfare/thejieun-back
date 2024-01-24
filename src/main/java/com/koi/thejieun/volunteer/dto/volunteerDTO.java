package com.koi.thejieun.volunteer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class volunteerDTO {
    private Long voNo;
    private String voName;
    private Long voTel;
    private String voContent;
    private Integer voStatus;
    @JsonFormat(pattern = "yy-MM-dd", timezone = "Asia/Seoul")
    private String voRegdate;
}
