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
@Table(name = "VPMT_MOCK_SERVICE_CONFIG"
)
public class VpmtMockServiceConfig{

    private Long id;
    private String responseName;
    private byte[] requestByte;
    private byte[] responseByte;
    private Long responseId;    

    private String requestString;
    private String responseString;

    public VpmtMockServiceConfig() {
    }

    public VpmtMockServiceConfig(Long id) {
        this.id = id;
    }

    public VpmtMockServiceConfig(Long id, String responseName, byte[] requestByte, byte[] responseByte, Long responseId) {
        this.id = id;
        this.responseName = responseName;
        this.requestByte = requestByte;
        this.responseByte = responseByte;
        this.responseId = responseId;        
    }

    @Id

    @Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "RESPONSE_NAME", length = 100)
    public String getResponseName() {
        return responseName;
    }

    public void setResponseName(String responseName) {
        this.responseName = responseName;
    }

    @Column(name = "REQUEST_BYTE")
    public byte[] getRequestByte() {
        return requestByte;
    }

    public void setRequestByte(byte[] requestByte) {
        this.requestByte = requestByte;
    }

    @Column(name = "RESPONSE_BYTE")
    public byte[] getResponseByte() {
        return responseByte;
    }

    public void setResponseByte(byte[] responseByte) {
        this.responseByte = responseByte;
    }

    @Column(name = "RESPONSE_ID", precision = 22, scale = 0)
    public Long getResponseId() {
        return responseId;
    }

    public void setResponseId(Long responseId) {
        this.responseId = responseId;
    }
    @Transient
    public String getRequestString() {
        return requestString;
    }

    public void setRequestString(String requestString) {
        this.requestString = requestString;
    }

    @Transient
    public String getResponseString() {
        return responseString;
    }

    public void setResponseString(String responseString) {
        this.responseString = responseString;
    }
   
}
