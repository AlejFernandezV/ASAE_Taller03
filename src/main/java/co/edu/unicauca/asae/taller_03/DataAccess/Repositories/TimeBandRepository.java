package co.edu.unicauca.asae.taller_03.DataAccess.Repositories;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.taller_03.DataAccess.Enums.Day;
import co.edu.unicauca.asae.taller_03.DataAccess.Enums.PhysycalSpace;
import co.edu.unicauca.asae.taller_03.DataAccess.Models.TimeBandEntity;

@Repository
public class TimeBandRepository {
    private ArrayList<TimeBandEntity> lstTimeBandEntities;

    public TimeBandRepository() {
        this.lstTimeBandEntities = new ArrayList<TimeBandEntity>();
        this.uploadTimeBands();
    }

    public List<TimeBandEntity> findAll() {
        System.out.println("Calling find all Time Bands");
        return this.lstTimeBandEntities;
    }

    public TimeBandEntity findById(Integer id) {
        System.out.println("Calling find a Time Band for id");
        TimeBandEntity objTimeBand = null;

        for (TimeBandEntity TimeBand : lstTimeBandEntities) {
            if (TimeBand.getId() == id) {
                objTimeBand = TimeBand;
                break;
            }
        }

        return objTimeBand;
    }

    public TimeBandEntity save(TimeBandEntity TimeBand) {
        System.out.println("Calling save Time Band");
        TimeBandEntity objTimeBand = null;
        if (this.lstTimeBandEntities.add(TimeBand)) {
            objTimeBand = TimeBand;
        }

        return objTimeBand;
    }

    public TimeBandEntity update(Integer id, TimeBandEntity TimeBand) {
        System.out.println("Calling update Time Band");
        TimeBandEntity objTimeBand = null;

        for (int i = 0; i < this.lstTimeBandEntities.size(); i++) {
            if (this.lstTimeBandEntities.get(i).getId() == id) {
                this.lstTimeBandEntities.set(i, TimeBand);
                objTimeBand = TimeBand;
                break;
            }
        }

        return objTimeBand;
    }

    public boolean delete(Integer id) {
        System.out.println("Calling to delete TimeBandEntity");
        boolean flag = false;

        for (int i = 0; i < this.lstTimeBandEntities.size(); i++) {
            if (this.lstTimeBandEntities.get(i).getId() == id) {
                this.lstTimeBandEntities.remove(i);
                flag = true;
                break;
            }
        }

        return flag;
    }

    private void uploadTimeBands() {
        this.lstTimeBandEntities.add(new TimeBandEntity(1, 1, PhysycalSpace.Salon, Day.Viernes,
                LocalDateTime.of(2024, 9, 6, 7, 00), LocalDateTime.of(2024, 9, 6, 9, 00)));
    }
}
