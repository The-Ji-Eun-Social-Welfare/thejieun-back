package com.koi.thejieun.volunteer.entity;

import com.koi.thejieun.volunteer.dto.VolunteerDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Volunteer")
@DynamicInsert
@SequenceGenerator(
        name = "volunteer_no_seq_generator",
        sequenceName = "volunteer_no_seq",
        initialValue = 1,
        allocationSize = 1)
/* 자원봉사 Entity */
public class Volunteer {
    @Id
    @Column(name = "vo_no")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "volunteer_no_seq_generator")
    // [PK] 신청 번호
    private Long voNo;

    @Column(name = "vo_name")
    // 신청자 이름
    private String voName;

    @Column(name = "vo_pwd")
    // 비밀번호
    private Long voPwd;

    @Column(name = "vo_tel")
    // 신청자 전화번호
    private Long voTel;

    @Column(name = "vo_content")
    // 신청 내용
    private String voContent;

    @Column(name = "vo_status")
    @ColumnDefault(value = "1")
    // 완료 여부 : 1=대기중 0=완료
    private Integer voStatus;

    @Column(name = "vo_regdate")
    @ColumnDefault(value = "CURRENT_DATE")
    // 신청일
    private String voRegdate;

    // 자원봉사 내용 수정
    public void modifyVoInfo(VolunteerDTO volunteerDTO) {
        this.voName = volunteerDTO.getVoName();
        this.voContent = volunteerDTO.getVoContent();
        this.voTel = volunteerDTO.getVoTel();
    }

    // 자원봉사 완료 상태로 변경
    public void modifyStatus() {
        this.voStatus = 0;
    }
}
