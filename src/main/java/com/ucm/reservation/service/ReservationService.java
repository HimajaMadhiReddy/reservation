package com.ucm.reservation.service;



import com.ucm.reservation.exceptions.InvalidRequestException;
import com.ucm.reservation.exceptions.ResourceNotFoundException;
import com.ucm.reservation.model.dto.Reservation;
import com.ucm.reservation.repository.ReservationRepository;
import com.ucm.reservation.transformer.DaoToDtoTransformer;
import com.ucm.reservation.transformer.DtoToDaoTransformer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public com.ucm.reservation.model.dto.Reservation validateCreateRequest(com.ucm.reservation.model.dto.Reservation reservation) {

        reservation.setResourceId(UUID.randomUUID());
        return DaoToDtoTransformer.DaoToDto(reservationRepository.save(DtoToDaoTransformer.DtoToDao(reservation)));
    }

    public List<Reservation> validateSearchRequest(String personResourceId, String carResourceId) {

        List<com.ucm.reservation.model.dao.Reservation> reservations = new ArrayList<>();

        if (!StringUtils.isBlank(personResourceId) && StringUtils.isBlank(carResourceId)) {

            reservations = reservationRepository.findReservationByPersonResourceId(UUID.fromString(personResourceId));
        }
        if (!StringUtils.isBlank(carResourceId) && StringUtils.isBlank(personResourceId)) {

            reservations = reservationRepository.findReservationByCarResourceId(UUID.fromString(carResourceId));
        }
        if (!StringUtils.isBlank(personResourceId) && !StringUtils.isBlank(carResourceId)) {

            reservations = reservationRepository.findReservationByPersonResourceIdAndCarResourceId
                    (UUID.fromString(personResourceId), UUID.fromString(carResourceId));

        }

        return DaoToDtoTransformer.DaoListToDtoList(reservations);
    }

    public Reservation getResourceId( String resourceId) throws InvalidRequestException, ResourceNotFoundException {

        try{
            UUID.fromString(resourceId);
        }catch (Exception ex){
            throw new InvalidRequestException("Please enter valid resourceId "+resourceId+" entered is Invalid.");
        }

        com.ucm.reservation.model.dao.Reservation reservationDao = reservationRepository.findByResourceId(UUID.fromString(resourceId));
        if (reservationDao == null){

            throw new ResourceNotFoundException("reservation with the given resourceId " + resourceId+ " doesn't exist");

        }
         return DaoToDtoTransformer.DaoToDto(reservationDao);
    }
}