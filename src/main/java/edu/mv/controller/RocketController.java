package edu.mv.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import edu.mv.models.RocketDTO;
import edu.mv.persistence.RocketNotFoundException;
import edu.mv.service.RocketService;

@RestController
@RequestMapping("/")
public class RocketController {

    private RocketService rocketService;

    public RocketController(RocketService rocketService) {
        this.rocketService = rocketService;
    }

    @GetMapping("/rocket/{rocketid}")
    public RocketDTO getRocket(@PathVariable(value = "rocketid") final String id) throws GetRocketException {
        try {
            return rocketService.getRocket(Integer.valueOf(id));
        } catch (RocketNotFoundException e) {
            throw new GetRocketException();
        }
    }

    @GetMapping("/rockets")
    public List<RocketDTO> getAll() {
        return rocketService.getAll();
    }

    @PostMapping("/rocket")
    public void saveRocket(@RequestBody RocketDTO rocket) {
        rocketService.putRocket(rocket);
    }

    @PostMapping("/rocket/{rocketid}")
    public void updateRocket(@PathVariable(value = "rocketid") final String id, @RequestBody RocketDTO rocket) throws RocketNotFoundException {
        rocketService.updateRocket(Integer.valueOf(id), rocket);
    }
}
