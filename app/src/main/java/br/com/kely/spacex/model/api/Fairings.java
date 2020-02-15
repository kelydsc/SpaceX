package br.com.kely.spacex.model.api;

import com.google.gson.annotations.SerializedName;

public class Fairings {

    private String reused;

    @SerializedName("recovery_attempt")
    private String recoveryAttempt;

    private String recovered;

    private String ship;

    public Fairings() {
    }

    public String getReused() {
        return reused;
    }

    public void setReused(String reused) {
        this.reused = reused;
    }

    public String getRecoveryAttempt() {
        return recoveryAttempt;
    }

    public void setRecoveryAttempt(String recoveryAttempt) {
        this.recoveryAttempt = recoveryAttempt;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getShip() {
        return ship;
    }

    public void setShip(String ship) {
        this.ship = ship;
    }
}
