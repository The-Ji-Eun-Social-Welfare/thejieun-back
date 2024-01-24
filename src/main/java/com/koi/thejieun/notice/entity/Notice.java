package com.koi.thejieun.notice.entity;

import com.koi.thejieun.notice.dto.NoticeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Notice")
@DynamicInsert
@SequenceGenerator(
        name = "notice_no_seq_generator",
        sequenceName = "notice_no_seq",
        initialValue = 1,
        allocationSize = 1)
/* 공지사항 Entity */
public class Notice {
    @Id
    @Column(name = "notice_no")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notice_no_seq_generator")
    // [PK] 공지사항 번호
    private Long noticeNo;

    @Column(name = "notice_title")
    // 공지사항 제목
    private String noticeTitle;

    @Column(name = "notice_content")
    // 공지사항 내용
    private String noticeContent;

    @Column(name = "notice_regdate")
    @ColumnDefault(value = "CURRENT_DATE")
    // 공지사항 생성일
    private Date noticeRegdate;

    // 공지사항 수정 메소드
    public void modifyNotice(NoticeDTO noticeDTO) {
        this.noticeTitle = noticeDTO.getNoticeTitle();
        this.noticeContent = noticeDTO.getNoticeContent();
    }
}
