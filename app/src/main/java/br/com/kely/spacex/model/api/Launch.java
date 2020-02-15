package br.com.kely.spacex.model.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Ignore;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Launch {

    @SerializedName("flight_number")
    private String flightNumber;

    @SerializedName("mission_name")
    private String missionName;

    @SerializedName("mission_id")
    private List<String> missionId = new ArrayList<>();

    private String upcoming;

    @SerializedName("launch_year")
    private String launchYear;

    @SerializedName("launch_date_unix")
    private String launchDateUnix;

    @SerializedName("launch_date_utc")
    private String launchDateUtc;

    @SerializedName("launch_date_local")
    private String launchDateLocal;

    @SerializedName("is_tentative")
    private String isTentative;

    @SerializedName("tentative_max_precision")
    private String tentativeMaxPrecision;

    private String tbd;

    @SerializedName("launch_window")
    private String launchWindow;

    private Rocket rocket;

    private List<String> ships = new ArrayList<>();

    private Telemetry telemetry;

    @SerializedName("launch_site")
    private LaunchSite launchSite;

    @SerializedName("launch_success")
    private String launchSuccess;

    @SerializedName("launch_failure_details")
    private LaunchFailureDetails launchFailureDetails;

    private Links links;

    private String details;

    @SerializedName("static_fire_date_utc")
    private String staticFireDateUtc;

    @SerializedName("static_fire_date_unix")
    private String staticFireDateUnix;

    private Timeline timeline;

    //private String crew;

    public Launch() {
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public List<String> getMissionId() {
        return missionId;
    }

    public void setMissionId(List<String> missionId) {
        this.missionId = missionId;
    }

    public String getUpcoming() {
        return upcoming;
    }

    public void setUpcoming(String upcoming) {
        this.upcoming = upcoming;
    }

    public String getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(String launchYear) {
        this.launchYear = launchYear;
    }

    public String getLaunchDateUnix() {
        return launchDateUnix;
    }

    public void setLaunchDateUnix(String launchDateUnix) {
        this.launchDateUnix = launchDateUnix;
    }

    public String getLaunchDateUtc() {
        return launchDateUtc;
    }

    public void setLaunchDateUtc(String launchDateUtc) {
        this.launchDateUtc = launchDateUtc;
    }

    public String getLaunchDateLocal() {
        return launchDateLocal;
    }

    public void setLaunchDateLocal(String launchDateLocal) {
        this.launchDateLocal = launchDateLocal;
    }

    public String getIsTentative() {
        return isTentative;
    }

    public void setIsTentative(String isTentative) {
        this.isTentative = isTentative;
    }

    public String getTentativeMaxPrecision() {
        return tentativeMaxPrecision;
    }

    public void setTentativeMaxPrecision(String tentativeMaxPrecision) {
        this.tentativeMaxPrecision = tentativeMaxPrecision;
    }

    public String getTbd() {
        return tbd;
    }

    public void setTbd(String tbd) {
        this.tbd = tbd;
    }

    public String getLaunchWindow() {
        return launchWindow;
    }

    public void setLaunchWindow(String launchWindow) {
        this.launchWindow = launchWindow;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public List<String> getShips() {
        return ships;
    }

    public void setShips(List<String> ships) {
        this.ships = ships;
    }

    public Telemetry getTelemetry() {
        return telemetry;
    }

    public void setTelemetry(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    public LaunchSite getLaunchSite() {
        return launchSite;
    }

    public void setLaunchSite(LaunchSite launchSite) {
        this.launchSite = launchSite;
    }

    public String getLaunchSuccess() {
        return launchSuccess;
    }

    public void setLaunchSuccess(String launchSuccess) {
        this.launchSuccess = launchSuccess;
    }

    public LaunchFailureDetails getLaunchFailureDetails() {
        return launchFailureDetails;
    }

    public void setLaunchFailureDetails(LaunchFailureDetails launchFailureDetails) {
        this.launchFailureDetails = launchFailureDetails;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStaticFireDateUtc() {
        return staticFireDateUtc;
    }

    public void setStaticFireDateUtc(String staticFireDateUtc) {
        this.staticFireDateUtc = staticFireDateUtc;
    }

    public String getStaticFireDateUnix() {
        return staticFireDateUnix;
    }

    public void setStaticFireDateUnix(String staticFireDateUnix) {
        this.staticFireDateUnix = staticFireDateUnix;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }
}
