package com.koi.thejieun.notice.service;

import com.koi.thejieun.exception.MyException;
import com.koi.thejieun.notice.dao.NoticeRepository;
import com.koi.thejieun.notice.dto.NoticeDTO;
import com.koi.thejieun.notice.entity.Notice;
import com.koi.thejieun.util.PageGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired private NoticeRepository repository;

    @Override
    public void addNotice(NoticeDTO noticeDTO) throws MyException {
        Notice notice =
                Notice.builder()
                        .noticeTitle(noticeDTO.getNoticeTitle())
                        .noticeContent(noticeDTO.getNoticeContent())
                        .build();
        repository.save(notice);
    }

    @Override
    public PageGroup<NoticeDTO> findNoticeList(Integer currentPage) throws MyException {
        if (currentPage < 1) currentPage = 1;
        int cntPerPage = 10;

        int start;
        int end;
        end = currentPage * cntPerPage;
        start = (currentPage - 1) * cntPerPage + 1;

        List<NoticeDTO> noticeDTOList = new ArrayList<>();
        List<Object[]> objects=repository.findNoticeList(start, end);
        Long noticeCnt = repository.count();

        for (Object[] objArr : objects) {
            NoticeDTO noticeDTO =
                    NoticeDTO.builder()
                            .noticeNo(Long.valueOf(String.valueOf(objArr[1])))
                            .noticeTitle(String.valueOf(objArr[2]))
                            .noticeContent(String.valueOf(objArr[3]))
                            .noticeRegdate((Date)objArr[4])
                            .build();
            noticeDTOList.add(noticeDTO);
        }

        PageGroup<NoticeDTO> noticeDTOPageGroup =
                new PageGroup<>(noticeDTOList, currentPage, noticeCnt);
        return noticeDTOPageGroup;
    }

    @Override
    public NoticeDTO findByNoticeNo(Long noticeNo) throws MyException {
        Optional<Notice> noticeOpt = repository.findById(noticeNo);
        Notice notice = noticeOpt.get();
        NoticeDTO noticeDTO =
                NoticeDTO.builder()
                        .noticeNo(notice.getNoticeNo())
                        .noticeTitle(notice.getNoticeTitle())
                        .noticeContent(notice.getNoticeContent())
                        .noticeRegdate(notice.getNoticeRegdate())
                        .build();

        return noticeDTO;
    }

    @Override
    public void modifyNotice(NoticeDTO noticeDTO) throws MyException {
        Optional<Notice> noticeOpt = repository.findById(noticeDTO.getNoticeNo());
        Notice notice = noticeOpt.get();
        notice.modifyNotice(noticeDTO);
        repository.save(notice);
    }

    @Override
    public void removeNotice(Long noticeNo) throws MyException {
        repository.deleteById(noticeNo);
    }
}
