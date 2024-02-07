package com.koi.thejieun.volunteer.control;

import com.koi.thejieun.exception.ErrorCode;
import com.koi.thejieun.exception.MyException;
import com.koi.thejieun.volunteer.dto.VolunteerDTO;
import com.koi.thejieun.volunteer.service.VolunteerServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vol")
public class VolunteerController {
    @Autowired private VolunteerServiceImpl service;

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

    @PutMapping("/{voNo}")
    @Transactional
    public ResponseEntity<?> modifyInfo(
            @PathVariable("voNo") Long voNo, @RequestBody VolunteerDTO volunteerDTO) {
        try {
            service.chkPwd(voNo, volunteerDTO.getVoPwd()); // 비밀번호가 확인되면 수정 가능
        } catch (MyException e) {
            throw e;
        }

        volunteerDTO.setVoNo(voNo);
        try {
            service.modifyVolunteer(volunteerDTO);
            String msg = "자원봉사 폼 수정 성공";
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (MyException e) {
            throw new MyException(ErrorCode.CONTENT_NOT_FOUND);
        }
    }

    @DeleteMapping("/{voNo}")
    @Transactional
    public ResponseEntity<?> deleteVol(@PathVariable("voNo") Long voNo, @RequestBody Long voPwd, HttpServletRequest request)
            throws MyException {
        HttpSession session = request.getSession();
        String adminId = (String) session.getAttribute("adminId");

        if(adminId==null) { // 관리자의 경우 삭제 가능
            try {
                service.chkPwd(voNo, voPwd); // 관리자가 아닌 경우 비밀번호가 확인되면 삭제 가능
            } catch (MyException e) {
                throw e;
            }
        }

        try {
            service.removeVolunteer(voNo);
            String msg = "자원봉사 폼 삭제 성공";
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (MyException e) {
            throw new MyException(ErrorCode.CONTENT_NOT_REMOVED);
        }
    }
}
