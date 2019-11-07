package com.ucm.reservation.controller;

import com.ucm.reservation.exceptions.InvalidRequestException;
import com.ucm.reservation.model.dto.Reservation;
import com.ucm.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

   @ResponseBody
   @RequestMapping(method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
   com.ucm.reservation.model.dto.Reservation createService(@RequestBody com.ucm.reservation.model.dto.Reservation reservation){

        return reservationService.validateCreateRequest(reservation);
    }

    @ResponseBody
    @RequestMapping(produces = "application/json")
    List<Reservation> searchService(@RequestParam(required = false) String personResourceId, @RequestParam(required = false) String carResourceId){

       return reservationService.validateSearchRequest(personResourceId, carResourceId);
    }

    @ResponseBody
    @RequestMapping(value = "/{resourceId}", produces = "application/json")
    Reservation getByResourceId(@PathVariable String resourceId) throws InvalidRequestException {
     return reservationService.getResourceId(resourceId);
    }

}
