package com.khandelwal.xharktank.service;

import com.khandelwal.xharktank.dto.GetPitchByIddto;
import com.khandelwal.xharktank.entities.PitchersEntity;
import com.khandelwal.xharktank.entities.PostOfferEntity;
import com.khandelwal.xharktank.repository.PitcherRepository;
import com.khandelwal.xharktank.repository.PostOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPitchById {
    @Autowired
    private PitcherRepository pitcherRepository;
    @Autowired
    private PostOfferRepository postOfferRepository;
    public GetPitchByIddto getPitch(Long id){
        PitchersEntity pitchersEntity=pitcherRepository.findById(id).get();
        List<PostOfferEntity> postOfferEntityList=postOfferRepository.getOffer(id);
        GetPitchByIddto getPitchByIddto= GetPitchByIddto.builder().id(pitchersEntity.getId())
                .entrepreneur(pitchersEntity.getEntrepreneur())
                .pitchTitle(pitchersEntity.getPitchTitle())
                .pitchIdea(pitchersEntity.getPitchIdea())
                .askAmount(pitchersEntity.getAskAmount())
                .equity(pitchersEntity.getEquity())
                .offers(postOfferEntityList).build();
        return getPitchByIddto;
    }
}
