package com.koi.thejieun.notice.service;

import com.koi.thejieun.exception.MyException;
import com.koi.thejieun.notice.dao.NoticeRepository;
import com.koi.thejieun.notice.dto.NoticeDTO;
import com.koi.thejieun.notice.entity.Notice;
import com.koi.thejieun.util.PageGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public NoticeDTO findByNoticeNo(Long noticeNo) throws MyException {
        return null;
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
