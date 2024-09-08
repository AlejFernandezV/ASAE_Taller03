package co.edu.unicauca.asae.taller_03.facadeServices.Mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TimeBandMapper {
    @Bean
    public ModelMapper TimeBandModelMapper() {
        return new ModelMapper();
    }
}
