package br.com.kely.spacex.model.api;

import com.google.gson.annotations.SerializedName;

public class Core {

    @SerializedName("core_serial")
    private String coreSerial;

    private String flight;

    private String block;

    private String gridfins;

    private String legs;

    private String reused;

    @SerializedName("land_success")
    private String landSuccess;

    @SerializedName("landing_intent")
    private String landingIntent;

    @SerializedName("landing_type")
    private String landingType;

    @SerializedName("landing_vehicle")
    private String landingVehicle;

    public Core() {
    }

    public String getCoreSerial() {
        return coreSerial;
    }

    public void setCoreSerial(String coreSerial) {
        this.coreSerial = coreSerial;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getGridfins() {
        return gridfins;
    }

    public void setGridfins(String gridfins) {
        this.gridfins = gridfins;
    }

    public String getLegs() {
        return legs;
    }

    public void setLegs(String legs) {
        this.legs = legs;
    }

    public String getReused() {
        return reused;
    }

    public void setReused(String reused) {
        this.reused = reused;
    }

    public String getLandSuccess() {
        return landSuccess;
    }

    public void setLandSuccess(String landSuccess) {
        this.landSuccess = landSuccess;
    }

    public String getLandingIntent() {
        return landingIntent;
    }

    public void setLandingIntent(String landingIntent) {
        this.landingIntent = landingIntent;
    }

    public String getLandingType() {
        return landingType;
    }

    public void setLandingType(String landingType) {
        this.landingType = landingType;
    }

    public String getLandingVehicle() {
        return landingVehicle;
    }

    public void setLandingVehicle(String landingVehicle) {
        this.landingVehicle = landingVehicle;
    }
}
