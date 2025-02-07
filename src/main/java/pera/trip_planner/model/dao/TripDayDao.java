package pera.trip_planner.model.dao;

import pera.trip_planner.model.domain.TripDay;

import java.time.LocalDate;

public interface TripDayDao extends DAO<LocalDate, TripDay>{

    @Override
    default TripDay create(LocalDate date) {
        return new TripDay(date);
    }
}
