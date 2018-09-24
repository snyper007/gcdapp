package com.snyper.gcd.api.rest.dto;

import com.snyper.gcd.api.RequestStatus;

public class ResultOfRequestDTO {

    private Long id;
    private RequestStatus status;
    private Long result;
    private String error;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
