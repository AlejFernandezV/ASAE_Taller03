package co.edu.unicauca.asae.taller_03.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.taller_03.facadeServices.DTO.TimeBandDTO;
import co.edu.unicauca.asae.taller_03.facadeServices.Services.Interfaces.ITimeBandService;

@RestController
@RequestMapping("/api")
public class TimeBandRestController {

    @Autowired
    private ITimeBandService timeBandService;

    @GetMapping("/timeBands")
    public List<TimeBandDTO> listTimeBands() {
        return timeBandService.findAll();
    }

    @GetMapping("/timeBands/{id}")
    public TimeBandDTO consultTimeBand(@PathVariable Integer id) {
        TimeBandDTO objTimeBand = null;
        objTimeBand = timeBandService.findById(id);
        return objTimeBand;
    }

    @PostMapping("/timeBands")
    public TimeBandDTO createTimeBand(@RequestBody TimeBandDTO timeBand) {
        TimeBandDTO objTimeBand = null;
        objTimeBand = timeBandService.save(timeBand);
        return objTimeBand;
    }

    @PutMapping("/timeBands/{id}")
    public TimeBandDTO updateTimeBand(@RequestBody TimeBandDTO timeBand, @PathVariable Integer id) {
        TimeBandDTO objTimeBand = null;
        TimeBandDTO currentTimeBand = timeBandService.findById(id);
        if (currentTimeBand != null) {
            objTimeBand = timeBandService.update(id, timeBand);
        }
        return objTimeBand;
    }

    @DeleteMapping("/timeBands")
    public Boolean deleteTimeBand(@RequestParam Integer id) {
        Boolean bandera = false;
        TimeBandDTO currentTimeBand = timeBandService.findById(id);
        if (currentTimeBand != null) {
            bandera = timeBandService.delete(id);
        }
        return bandera;
    }

    @GetMapping("/timeBands/listarCabeceras")
    public void listHeaders(@RequestHeader Map<String, String> headers) {
        System.out.println("cabeceras");
        headers.forEach((key, value) -> {
            System.out.println(String.format("Cabecera '%s' = %s", key, value));
        });
    }
}
