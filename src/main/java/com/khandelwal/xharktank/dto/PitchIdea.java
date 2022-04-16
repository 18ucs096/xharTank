package com.khandelwal.xharktank.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PitchIdea implements Serializable{
    private static final long serialVersionUID = 1L;
    @JsonProperty("entrepreneur")
    private String entrepreneur;
    @JsonProperty("pitchTitle")
    private String pitchTitle;
    @JsonProperty("pitchIdea")
    private String pitchIdea;
    @JsonProperty("askAmount")
    private Float askAmount;
    @JsonProperty("equity")
    private Float equity;
}
