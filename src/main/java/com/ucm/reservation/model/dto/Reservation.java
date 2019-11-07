package com.ucm.reservation.model.dto;


import java.util.UUID;

public class Reservation {


        private UUID resourceId;
        private  String personResourceId;
        private String carResourceId;
        private String pickUpLocation;
        private String dropOffLocation;
        private  String startDateTime;
        private String endDateTime;
        private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UUID getResourceId() {
        return resourceId;
    }

    public void setResourceId(UUID resourceId) {
        this.resourceId = resourceId;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }


    public String getPersonResourceId() {
        return personResourceId;
    }

    public void setPersonResourceId(String personResourceId) {
        this.personResourceId = personResourceId;
    }

    public String getCarResourceId() {
        return carResourceId;
    }

    public void setCarResourceId(String carResourceId) {
        this.carResourceId = carResourceId;
    }

    public String getPickUpLocation() {
            return pickUpLocation;
        }

        public void setPickUpLocation(String pickUpLocation) {
            this.pickUpLocation = pickUpLocation;
        }

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
    }
}

