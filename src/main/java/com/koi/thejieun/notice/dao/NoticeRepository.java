package com.koi.thejieun.notice.dao;

import com.koi.thejieun.exception.MyException;
import com.koi.thejieun.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
    /* notice paging */
    @Query(
            value =
                    "SELECT * FROM (\n"
                            + "\tSELECT rownum rn, q.*\n"
                            + "\tFROM (\n"
                            + "\t\tSELECT notice_no, notice_title, notice_content, notice_regdate"
                            + "\t\tFROM notice ORDER BY notice_regdate desc\n"
                            + "\t) q\n"
                            + ") pg WHERE rn BETWEEN :start AND :end",
            nativeQuery = true)
    public List<Object[]> findNoticeList(@Param("start") Integer start, @Param("end") Integer end);
}
