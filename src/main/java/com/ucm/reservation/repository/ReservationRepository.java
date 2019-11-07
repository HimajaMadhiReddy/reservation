package com.ucm.reservation.repository;

import com.ucm.reservation.model.dao.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface ReservationRepository extends MongoRepository<Reservation,String> {

List<Reservation> findReservationByCarResourceId (UUID carResourceId);
List<Reservation> findReservationByPersonResourceId(UUID personResourceId );
List<Reservation> findReservationByPersonResourceIdAndCarResourceId(UUID personResourceId, UUID carResourceId);
Reservation findByResourceId(UUID resourceId);

}
