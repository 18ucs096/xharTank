package com.khandelwal.xharktank.service;

import com.khandelwal.xharktank.dto.PostOfferdto;
import com.khandelwal.xharktank.entities.PitchersEntity;
import com.khandelwal.xharktank.entities.PostOfferEntity;
import com.khandelwal.xharktank.repository.PitcherRepository;
import com.khandelwal.xharktank.repository.PostOfferRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Service
public class PostOfferService {
    private PostOfferRepository postOfferRepository;
    private PitcherRepository pitcherRepository;
    public PostOfferService(PostOfferRepository postOfferRepository, PitcherRepository pitcherRepository) {
        this.postOfferRepository = postOfferRepository;
        this.pitcherRepository=pitcherRepository;
    }

    public HashMap<String,String> postCounter(Long id,PostOfferdto postOfferdto){
        Boolean exit =pitcherRepository.existsById(id);
        HashMap<String,String> hm=new HashMap<>();
        if(exit==Boolean.FALSE) {
            hm.put("id","-1");
            return hm;
        }
        PostOfferEntity postOfferEntity= PostOfferEntity.builder().offer_id(id).comment(postOfferdto.getComment())
                .equity(postOfferdto.getEquity())
                .amount(postOfferdto.getAmount())
                .investor(postOfferdto.getInvestor()).build();
        hm.put("id",postOfferRepository.save(postOfferEntity).getOffer_id().toString());
        return hm;
    }
}
