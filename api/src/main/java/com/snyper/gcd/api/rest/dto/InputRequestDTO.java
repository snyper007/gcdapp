package com.snyper.gcd.api.rest.dto;

import io.swagger.annotations.ApiModelProperty;

public class InputRequestDTO {

    @ApiModelProperty(required = true, value = "First number to calculate.", example = "9")
    private Long first;
    @ApiModelProperty(required = true, value = "Second number to calculate..", example = "6")
    private Long second;

    public InputRequestDTO() {
        super();
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
