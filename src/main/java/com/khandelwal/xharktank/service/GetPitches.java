package com.khandelwal.xharktank.service;

import com.khandelwal.xharktank.dto.GetPitchByIddto;
import com.khandelwal.xharktank.entities.PitchersEntity;
import com.khandelwal.xharktank.repository.PitcherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GetPitches {
    @Autowired
    private PitcherRepository pitcherRepository;
    @Autowired
    private GetPitchById pitchById;
    public List<GetPitchByIddto> getPitch(){
        List<PitchersEntity> pitchidea=pitcherRepository.findAll();
        Collections.sort(pitchidea, (o1, o2) -> o2.getId()-o1.getId()>=0?1:-1);
        List<GetPitchByIddto> getPitchByIddtoList=new ArrayList<>();
        for(PitchersEntity pitchersEntity:pitchidea){
            GetPitchByIddto getPitchByIddto=pitchById.getPitch(pitchersEntity.getId());
            getPitchByIddtoList.add(getPitchByIddto);
        }
        return getPitchByIddtoList;
    }
}
