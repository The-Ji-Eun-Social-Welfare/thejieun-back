package com.koi.thejieun.volunteer.control;

import com.koi.thejieun.exception.ErrorCode;
import com.koi.thejieun.exception.MyException;
import com.koi.thejieun.volunteer.dto.VolunteerDTO;
import com.koi.thejieun.volunteer.service.VolunteerServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vol")
public class VolunteerController {
    @Autowired
    private VolunteerServiceImpl service;

    @PostMapping("/write")
    @Transactional
    public ResponseEntity<?> writeVol(@RequestBody VolunteerDTO volunteerDTO) throws MyException {
        try {
            service.addVolunteer(volunteerDTO);
            String msg = "자원봉사 폼 작성 성공";
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (MyException e) {
            throw new MyException(ErrorCode.CONTENT_NOT_SAVED);
        }
    }

    @GetMapping("/{voNo}")
    public VolunteerDTO find(@PathVariable("voNo") Long voNo) {
        try {
            return service.findByVoNo(voNo);
        } catch (MyException e) {
            throw new MyException(ErrorCode.CONTENT_NOT_FOUND);
        }
    }

    @DeleteMapping("/remove/{voNo}")
    @Transactional
    public ResponseEntity<?> deleteVol(@PathVariable("voNo") Long voNo) throws MyException {
        try {
            service.removeVolunteer(voNo);
            String msg="자원봉사 폼 삭제 성공";
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (MyException e) {
            throw new MyException(ErrorCode.CONTENT_NOT_REMOVED);
        }
    }
}
