package co.edu.unicauca.asae.taller_03.facadeServices.DTO;

import java.time.LocalDateTime;

import co.edu.unicauca.asae.taller_03.DataAccess.Enums.Day;
import co.edu.unicauca.asae.taller_03.DataAccess.Enums.PhysycalSpace;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeBandDTO {
    private int id;
    private int courseId;
    private PhysycalSpace space;
    private Day day;
    private LocalDateTime hourStart;
    private LocalDateTime hourFinish;
}
