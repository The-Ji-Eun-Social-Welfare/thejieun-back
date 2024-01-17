package com.koi.thejieun.notice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class NoticeDTO {
    private Long noticeNo;
    private String noticeTitle;
    private String noticeContent;
    @JsonFormat(pattern = "yy-MM-dd", timezone = "Asia/Seoul")
    private Date noticeRegdate;
}
