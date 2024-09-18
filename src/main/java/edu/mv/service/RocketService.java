package edu.mv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mv.models.RocketDTO;
import edu.mv.persistence.PersistenceService;
import edu.mv.persistence.RocketNotFoundException;
import java.util.List;

@Service
public class RocketService {

    @Autowired
    PersistenceService persistenceService;

    public void putRocket(RocketDTO Rocket) {
        persistenceService.save(Rocket);
    }
    public List<RocketDTO> getAll() {
        return persistenceService.getAll();
    }
    public void updateRocket(int id, RocketDTO updatedRocket) throws RocketNotFoundException {
        persistenceService.updateRocket(id, updatedRocket);
    }
    public RocketDTO getRocket(int id) throws RocketNotFoundException {
        return persistenceService.retrieve(id);
    }
}
