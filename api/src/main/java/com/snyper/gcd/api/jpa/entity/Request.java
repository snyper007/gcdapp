package com.snyper.gcd.api.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.snyper.gcd.api.RequestStatus;

@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private RequestStatus status;

    private Long result;

    private String error;

    private Long first;

    private Long second;
    
    public Request() {
    }

    public Request(Long first, Long second) {
        this.first = first;
        this.second = second;
    }

    public static Request createNotCompleted(Long first, Long second) {
        Request output = new Request(first, second);
        output.status = RequestStatus.NOT_COMPLETED;
        return output;
    }

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

    public Long getFirst() {
        return first;
    }

    public void setFirst(Long first) {
        this.first = first;
    }

    public Long getSecond() {
        return second;
    }

    public void setSecond(Long second) {
        this.second = second;
    }

}