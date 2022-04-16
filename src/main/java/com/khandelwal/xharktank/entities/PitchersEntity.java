package com.khandelwal.xharktank.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PITCHES")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PitchersEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entrepreneur")
    private String entrepreneur;

    @Column(name = "pitchTitle")
    private String pitchTitle;

    @Column(name = "pitchIdea")
    private String pitchIdea;

    @Column(name = "askAmount")
    private Float askAmount;

    @Column(name = "equity")
    private Float equity;

}
