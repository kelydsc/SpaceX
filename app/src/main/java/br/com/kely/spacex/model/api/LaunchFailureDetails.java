package br.com.kely.spacex.model.api;

public class LaunchFailureDetails {

    private String time;

    private String altitude;

    private String reason;

    public LaunchFailureDetails() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
