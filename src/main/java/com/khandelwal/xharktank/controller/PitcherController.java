package com.khandelwal.xharktank.controller;

import com.khandelwal.xharktank.dto.GetPitchByIddto;
import com.khandelwal.xharktank.dto.PitchIdea;
import com.khandelwal.xharktank.dto.PostOfferdto;
import com.khandelwal.xharktank.entities.PitchersEntity;
import com.khandelwal.xharktank.entities.PostOfferEntity;
import com.khandelwal.xharktank.service.GetPitchById;
import com.khandelwal.xharktank.service.GetPitches;
import com.khandelwal.xharktank.service.PitcherService;
import com.khandelwal.xharktank.service.PostOfferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping()
public class PitcherController {
    private final PitcherService pitchesService;
    private final PostOfferService postOfferService;
    private final GetPitches getPitches;
    private final GetPitchById getPitchById;
    public PitcherController(PitcherService pitchesService, PostOfferService postOfferService, GetPitches getPitches, GetPitchById getPitchById) {
        this.pitchesService = pitchesService;
        this.postOfferService = postOfferService;
        this.getPitches = getPitches;
        this.getPitchById = getPitchById;
    }
    @GetMapping("/pitches")
    public ResponseEntity<List<GetPitchByIddto>>  getPitch(){
        List<GetPitchByIddto> response=new ArrayList<>();
        try{
            return ResponseEntity.status(200).body(getPitches.getPitch());
        }
        catch (Exception e){
            return ResponseEntity.status(200).body(response);
        }

    }
    @GetMapping("/pitches/{id}")
    public ResponseEntity<GetPitchByIddto>  getPitch(@PathVariable("id")Long id){
        try{
            return ResponseEntity.status(200).body(getPitchById.getPitch(id));
        }
        catch (Exception e){
            return ResponseEntity.status(404).body(null);
        }
    }
    @PostMapping("/pitches")
    public ResponseEntity<HashMap<String,String>> postPitcher(@RequestBody PitchIdea pitchidea){
        HashMap<String,String> response=new HashMap<>();
        try{
            if (pitchidea.getAskAmount()==null || pitchidea.getPitchIdea()==null|| pitchidea.getPitchTitle()==null
            || pitchidea.getEquity()==null||pitchidea.getEntrepreneur()==null){
                return ResponseEntity.status(400).body(null);
            }

            return ResponseEntity.status(201).body(pitchesService.save(pitchidea));
        }
        catch (Exception e){
            return ResponseEntity.status(400).body(null);
        }
    }
    @PostMapping("/pitches/{id}/makeOffer")
    public ResponseEntity<HashMap<String,String>> postCounter(@PathVariable("id") Long id, @RequestBody PostOfferdto postOfferdto){
        HashMap<String,String> hm=new HashMap<>();
        try{
            HashMap<String,String> response=postOfferService.postCounter(id, postOfferdto);
            if (response.get("id").equals("-1"))
                return ResponseEntity.status(404).body(null);
            return ResponseEntity.status(201).body(response);
        }
        catch (Exception e){
            return ResponseEntity.status(400).body(null);
        }
    }
}
