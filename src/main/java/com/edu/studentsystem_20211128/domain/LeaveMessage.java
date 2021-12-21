package com.edu.studentsystem_20211128.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class LeaveMessage {
    public static int LEAVE_STATUS_WAIT = 0;//等待审核
    public static int LEAVE_STATUS_AGREE = 1;//同意
    public static int LEAVE_STATUS_DISAGREE = -1;//不同意
    private int id;
    private int studentId;
    private String info;//请假理由
    private int status = LEAVE_STATUS_WAIT;//请假条状态
    private String remark;//批复内容
}
