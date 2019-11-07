package com.ucm.reservation.transformer;

import com.ucm.reservation.model.dto.Reservation;

import java.util.ArrayList;
import java.util.List;

public class DaoToDtoTransformer {

    public static Reservation DaoToDto(com.ucm.reservation.model.dao.Reservation reservation){

        Reservation reservationDto = new Reservation();

        reservationDto.setDropOffLocation(reservation.getDropOffLocation());
        reservationDto.setPickUpLocation(reservation.getPickUpLocation());
        reservationDto.setStartDateTime(reservation.getStartDateTime());
        reservationDto.setEndDateTime(reservation.getEndDateTime());
        reservationDto.setResourceId(reservation.getResourceId());
        reservationDto.setPersonResourceId(reservation.getPersonResourceId());
        reservationDto.setCarResourceId(reservation.getCarResourceId());


        return reservationDto;
    }

    public static List<Reservation> DaoListToDtoList(List<com.ucm.reservation.model.dao.Reservation> reservations){

        List<Reservation> reservationsDto = new ArrayList<>();

        for (com.ucm.reservation.model.dao.Reservation  reservation: reservations){

            reservationsDto.add(DaoToDto(reservation));
        }

        return reservationsDto;
    }
}
