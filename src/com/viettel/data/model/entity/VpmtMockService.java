package com.viettel.data.model.entity;

// Generated May 21, 2014 10:29:16 AM by Hibernate Tools 3.6.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Projects generated by hbm2java
 */
@Entity
@Table(name = "VPMT_MOCK_SERVICE"
)
public class VpmtMockService {

    private Long id;
    private String code;
    private String mockName;
    private String mockType;    
    private Long appId;
    private byte[] valueByte;
    
    private String mockValue;
    public VpmtMockService() {
    }

    public VpmtMockService(Long id) {
        this.id = id;
    }

    public VpmtMockService(Long id, String code, String mockName, String mockType, String mockValue) {
        this.id = id;
        this.code = code;
        this.mockName = mockName;
        this.mockType = mockType;
        this.mockValue = mockValue;
    }
    @Id

    @Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "CODE", length = 500)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    @Column(name = "MOCK_NAME", length = 100)
    public String getMockName() {
        return mockName;
    }

    public void setMockName(String mockName) {
        this.mockName = mockName;
    }
    @Column(name = "MOCK_TYPE", length = 100)
    public String getMockType() {
        return mockType;
    }

    public void setMockType(String mockType) {
        this.mockType = mockType;
    }    
    @Transient
    public String getMockValue() {
        return mockValue;
    }

    public void setMockValue(String mockValue) {
        this.mockValue = mockValue;
    }
    @Column(name = "APP_ID",precision = 22, scale = 0)
    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }
    @Column(name = "VALUE_BYTE")
    public byte[] getValueByte() {
        return valueByte;
    }

    public void setValueByte(byte[] valueByte) {
        this.valueByte = valueByte;
    }
    
    
}
