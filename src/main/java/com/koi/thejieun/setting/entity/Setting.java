package com.koi.thejieun.setting.entity;

import com.koi.thejieun.setting.dto.SettingDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Setting")
@DynamicInsert
@SequenceGenerator(
        name = "setting_no_seq_generator",
        sequenceName = "setting_no_seq",
        initialValue = 1,
        allocationSize = 1)
/* 설정 Entity */
public class Setting {
    @Id
    @Column(name = "setting_no")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "setting_no_seq_generator")
    // [PK] 설정 번호
    private Long settingNo;

    @Column(name = "admin_id")
    // 관리자 아이디
    private String adminId;

    @Column(name = "admin_pwd")
    // 관리자 비밀번호
    private String adminPwd;

    public void modifySetInfo(SettingDTO settingDTO) {
        this.adminId = settingDTO.getAdminId();
        this.adminPwd = settingDTO.getAdminPwd();
    }
}
