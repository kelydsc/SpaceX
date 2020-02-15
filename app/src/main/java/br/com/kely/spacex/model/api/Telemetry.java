package br.com.kely.spacex.model.api;

import com.google.gson.annotations.SerializedName;

public class Telemetry {

    @SerializedName("flight_club")
    private String flightClub;

    public Telemetry() {
    }

    public String getFlightClub() {
        return flightClub;
    }

    public void setFlightClub(String flightClub) {
        this.flightClub = flightClub;
    }
}
