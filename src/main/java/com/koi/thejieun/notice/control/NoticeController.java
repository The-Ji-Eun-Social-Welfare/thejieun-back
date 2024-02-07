package com.koi.thejieun.notice.control;

import com.koi.thejieun.exception.ErrorCode;
import com.koi.thejieun.exception.MyException;
import com.koi.thejieun.notice.dto.NoticeDTO;
import com.koi.thejieun.notice.service.NoticeServiceImpl;
import com.koi.thejieun.volunteer.dto.VolunteerDTO;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notice")
public class NoticeController {
    private NoticeServiceImpl service;

    @PostMapping("/write")
    public ResponseEntity<?> writeNo(@RequestBody NoticeDTO noticeDTO) throws MyException {
        try{
            service.addNotice(noticeDTO);
            String msg = "공지사항 작성 성공";
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (MyException e) {
            throw new MyException(ErrorCode.CONTENT_NOT_SAVED);
        }
    }
    @GetMapping("/{voNo}")
    public NoticeDTO find(@PathVariable("noticeNo") Long noticeNo) {
        try {
            return service.findByNoticeNo(noticeNo);
        } catch (MyException e) {
            throw new MyException(ErrorCode.CONTENT_NOT_FOUND);
        }
    }

    @PutMapping("/{voNo}")
    @Transactional
    public ResponseEntity<?> modifyInfo(@PathVariable("noticeNo") Long noticeNo, @RequestBody NoticeDTO noticeDTO) {
        noticeDTO.setNoticeNo(noticeNo);
        try {
            service.modifyNotice(noticeDTO);
            String msg="공지사항 수정 성공";
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (MyException e) {
            throw new MyException(ErrorCode.CONTENT_NOT_FOUND);
        }
    }

    @DeleteMapping("/{voNo}")
    @Transactional
    public ResponseEntity<?> deleteNotice(@PathVariable("noticeNo") Long noticeNo) throws MyException {
        try {
            service.removeNotice(noticeNo);
            String msg="공지사항 삭제 성공";
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (MyException e) {
            throw new MyException(ErrorCode.CONTENT_NOT_REMOVED);
        }
    }
}
