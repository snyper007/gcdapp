package com.snyper.gcd.api.rest.dto;

public class InputRequestWithIdDTO {

    private Long id;
    private Long first;
    private Long second;

    public InputRequestWithIdDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
