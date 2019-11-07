package com.ucm.reservation.transformer;

import com.ucm.reservation.model.dao.Reservation;

public class DtoToDaoTransformer {

public static Reservation DtoToDao(com.ucm.reservation.model.dto.Reservation reservation){
    Reservation reservationDto = new Reservation();


    reservationDto.setDropOffLocation(reservation.getDropOffLocation());
    reservationDto.setPickUpLocation(reservation.getPickUpLocation());
    reservationDto.setStartDateTime(reservation.getStartDateTime());
    reservationDto.setEndDateTime(reservation.getEndDateTime());
    reservationDto.setResourceId(reservation.getResourceId());
    reservationDto.setCarResourceId(reservation.getCarResourceId());
    reservationDto.setPersonResourceId(reservation.getPersonResourceId());



    return reservationDto;

}

}

