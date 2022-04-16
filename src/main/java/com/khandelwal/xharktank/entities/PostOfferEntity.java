package com.khandelwal.xharktank.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "COUNTER")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostOfferEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "investor")
    private String investor;

    @Column(name = "offer_id")
    private Long offer_id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "equity")
    private Float equity;
}
