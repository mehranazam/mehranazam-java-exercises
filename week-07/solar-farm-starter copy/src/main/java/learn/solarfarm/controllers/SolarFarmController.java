package learn.solarfarm.controllers;

import learn.solarfarm.data.DataAccessException;
import learn.solarfarm.domain.SolarPanelService;
import learn.solarfarm.models.SolarPanel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/panels")
public class SolarFarmController {

    private final SolarPanelService service;

    public SolarFarmController(SolarPanelService service) {
        this.service = service;
    }

    @GetMapping("/{section}")
    public List<SolarPanel> findBySection(@PathVariable String section) throws DataAccessException {
        return service.findBySection(section);
    }


}
