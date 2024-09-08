package co.edu.unicauca.asae.taller_03.facadeServices.Services.Implementations;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.taller_03.DataAccess.Models.TimeBandEntity;
import co.edu.unicauca.asae.taller_03.DataAccess.Repositories.TimeBandRepository;
import co.edu.unicauca.asae.taller_03.facadeServices.DTO.TimeBandDTO;
import co.edu.unicauca.asae.taller_03.facadeServices.Services.Interfaces.ITimeBandService;

@Service
public class TimeBandServiceImpl implements ITimeBandService {

    private TimeBandRepository serviceDataAccess;
    private ModelMapper modelMapper;

    public TimeBandServiceImpl(TimeBandRepository serviceDataAccess, ModelMapper modelMapper) {
        this.serviceDataAccess = serviceDataAccess;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TimeBandDTO> findAll() {
        List<TimeBandEntity> tbEntities = this.serviceDataAccess.findAll();
        return this.modelMapper.map(tbEntities, new TypeToken<List<TimeBandDTO>>() {
        }.getType());
    }

    @Override
    public TimeBandDTO findById(Integer id) {
        TimeBandEntity objCLienteEntity = this.serviceDataAccess.findById(id);
        return this.modelMapper.map(objCLienteEntity, TimeBandDTO.class);
    }

    @Override
    public TimeBandDTO save(TimeBandDTO timeBand) {
        TimeBandEntity TimeBandEntity = this.modelMapper.map(timeBand, TimeBandEntity.class);
        TimeBandEntity objCLienteEntity = this.serviceDataAccess.save(TimeBandEntity);
        return this.modelMapper.map(objCLienteEntity, TimeBandDTO.class);
    }

    @Override
    public TimeBandDTO update(Integer id, TimeBandDTO timeBand) {
        TimeBandEntity TimeBandEntity = this.modelMapper.map(timeBand, TimeBandEntity.class);
        TimeBandEntity clienteEntityActualizado = this.serviceDataAccess.update(id, TimeBandEntity);
        return this.modelMapper.map(clienteEntityActualizado, TimeBandDTO.class);
    }

    @Override
    public boolean delete(Integer id) {
        return this.serviceDataAccess.delete(id);
    }

}
