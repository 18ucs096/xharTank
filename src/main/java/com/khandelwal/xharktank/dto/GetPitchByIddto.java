package com.khandelwal.xharktank.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.khandelwal.xharktank.entities.PitchersEntity;
import com.khandelwal.xharktank.entities.PostOfferEntity;
import lombok.Builder;

import java.io.Serializable;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class GetPitchByIddto implements Serializable {
    @JsonProperty("id")
    private Long id;
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
    @JsonProperty("offers")
    private List<PostOfferEntity> offers;
}
