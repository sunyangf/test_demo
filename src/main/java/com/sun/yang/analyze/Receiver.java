package com.sun.yang.analyze;

import lombok.Data;

/**
 * @ClassName Receiver
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/21
 **/
@Data
public class Receiver {
    private String eventRecordId;

    private String uuid;

    private String sourceId;

    private String eventType;

    private String nodecode;

    public void resetEventRecordId() {
        if (!this.eventRecordId.startsWith(nodecode)) {
            throw new RuntimeException("eventRecordId NOT start with nodecode, eventRecordId:" + this.eventRecordId + ",nodecode:" + this.nodecode);
        }
        this.uuid = this.eventRecordId.substring(0, nodecode.length());
    }

    @Override
    public String toString() {
        return "Receiver{" +
                "eventRecordId='" + eventRecordId + '\'' +
                ", uuid='" + uuid + '\'' +
                ", sourceId='" + sourceId + '\'' +
                ", eventType='" + eventType + '\'' +
                ", nodecode='" + nodecode + '\'' +
                '}';
    }
}
