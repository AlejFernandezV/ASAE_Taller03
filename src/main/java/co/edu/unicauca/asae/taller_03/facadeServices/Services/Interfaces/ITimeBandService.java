package co.edu.unicauca.asae.taller_03.facadeServices.Services.Interfaces;

import java.util.List;

import co.edu.unicauca.asae.taller_03.facadeServices.DTO.TimeBandDTO;

public interface ITimeBandService {

    public List<TimeBandDTO> findAll();

    public TimeBandDTO findById(Integer id);

    public TimeBandDTO save(TimeBandDTO timeBand);

    public TimeBandDTO update(Integer id, TimeBandDTO timeBand);

    public boolean delete(Integer id);
}
