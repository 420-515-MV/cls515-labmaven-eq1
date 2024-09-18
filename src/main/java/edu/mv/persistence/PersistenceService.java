package edu.mv.persistence;

import java.util.List;  // For handling lists of rockets
import java.util.Optional;  // For handling Optional results from the repository
import java.util.stream.Collectors;  // To convert Rocket list to RocketDTO list

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mv.db.models.Rocket;
import edu.mv.mapping.RocketMapper;
import edu.mv.models.RocketDTO;
import edu.mv.repository.RocketRepository;

@Service
public class PersistenceService {

    @Autowired
    private RocketRepository rocketRepository;

    public RocketDTO retrieve(int id) throws RocketNotFoundException {
        Optional<Rocket> rocketOptional = rocketRepository.findById(id);
        if (rocketOptional.isPresent()) {
            return convertToRocketDTO(rocketOptional.get());
        }

        throw new RocketNotFoundException(id);
    }

    public void save(RocketDTO Rocket) {
        rocketRepository.save(convertToRocketPersistence(Rocket));
    }

    public List<RocketDTO> getAll() {
        List<Rocket> rockets = (List<Rocket>) rocketRepository.findAll();
        return rockets.stream()
                .map(this::convertToRocketDTO)
                .collect(Collectors.toList());
    }
    public void updateRocket(int id, RocketDTO updatedRocket) throws RocketNotFoundException {
        Rocket oldRocket = rocketRepository.findById(id)
                .orElseThrow(() -> new RocketNotFoundException(id));


        oldRocket.setName(updatedRocket.getName());
        oldRocket.setSorte(updatedRocket.getType());

        rocketRepository.save(oldRocket);
    }



    private Rocket convertToRocketPersistence(RocketDTO RocketDTO) {
        Rocket rocket = RocketMapper.INSTANCE.RocketDTOToRocket(RocketDTO);
        return rocket;
    }

    private RocketDTO convertToRocketDTO(Rocket rocket) {
        RocketDTO rocketDTO = RocketMapper.INSTANCE.RocketToRocketDTO(rocket);
        return rocketDTO;
    }

}
