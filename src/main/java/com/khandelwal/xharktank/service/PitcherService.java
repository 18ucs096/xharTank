package com.khandelwal.xharktank.service;

import com.khandelwal.xharktank.dto.PitchIdea;
import com.khandelwal.xharktank.entities.PitchersEntity;
import com.khandelwal.xharktank.repository.PitcherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PitcherService {

    @Autowired
    private PitcherRepository pitcherRepository;
    public HashMap<String,String> save(PitchIdea pitchIdea){
        PitchersEntity pitchersEntity= PitchersEntity.builder().pitchIdea(pitchIdea.getPitchIdea()).
                askAmount(pitchIdea.getAskAmount())
                .entrepreneur(pitchIdea.getEntrepreneur())
                .equity(pitchIdea.getEquity())
                .pitchTitle(pitchIdea.getPitchTitle())
                .build();
        String res=pitcherRepository.save(pitchersEntity).getId().toString();
        HashMap<String,String> hm=new HashMap<>();
        hm.put("id",res);
        return hm;
    }
}
