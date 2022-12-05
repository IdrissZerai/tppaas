package com.tppaas.notificationmanager.repo;

import com.tppaas.notificationmanager.entities.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoachService {

    @Autowired
    private CoachRepo coachRepo;

    public Coach save(Coach coach){
        return coachRepo.save(coach);
    }

    public Iterable<Coach> getAvailable(){
        return coachRepo.findAll();
    }
}
