package com.khandelwal.xharktank.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostOfferdto {
    private static final long serialVersionUID = 1L;

    @JsonProperty("investor")
    private String investor;
    @JsonProperty("amount")
    private Float amount;
    @JsonProperty("equity")
    private Float equity;
    @JsonProperty("comment")
    private String comment;
}
