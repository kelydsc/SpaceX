package br.com.kely.spacex.model.api;

import com.google.gson.annotations.SerializedName;

public class OrbitParams {

    @SerializedName("reference_system")
    private String referenceSystem;

    private String regime;

    private String longitude;

    @SerializedName("semi_major_axis_km")
    private String semiMajorAxisKm;

    private String eccentricity;

    @SerializedName("periapsis_km")
    private String periapsisKm;

    @SerializedName("apoapsis_km")
    private String apoapsisKm;

    @SerializedName("inclination_deg")
    private String inclinationDeg;

    @SerializedName("period_min")
    private String periodMin;

    @SerializedName("lifespan_years")
    private String lifespanYears;

    private String epoch;

    @SerializedName("mean_motion")
    private String meanMotion;

    private String raan;

    @SerializedName("arg_of_pericente")
    private String argOfPericenter;

    @SerializedName("mean_anomaly")
    private String meanAnomaly;

    public OrbitParams() {
    }

    public String getReferenceSystem() {
        return referenceSystem;
    }

    public void setReferenceSystem(String referenceSystem) {
        this.referenceSystem = referenceSystem;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getSemiMajorAxisKm() {
        return semiMajorAxisKm;
    }

    public void setSemiMajorAxisKm(String semiMajorAxisKm) {
        this.semiMajorAxisKm = semiMajorAxisKm;
    }

    public String getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(String eccentricity) {
        this.eccentricity = eccentricity;
    }

    public String getPeriapsisKm() {
        return periapsisKm;
    }

    public void setPeriapsisKm(String periapsisKm) {
        this.periapsisKm = periapsisKm;
    }

    public String getApoapsisKm() {
        return apoapsisKm;
    }

    public void setApoapsisKm(String apoapsisKm) {
        this.apoapsisKm = apoapsisKm;
    }

    public String getInclinationDeg() {
        return inclinationDeg;
    }

    public void setInclinationDeg(String inclinationDeg) {
        this.inclinationDeg = inclinationDeg;
    }

    public String getPeriodMin() {
        return periodMin;
    }

    public void setPeriodMin(String periodMin) {
        this.periodMin = periodMin;
    }

    public String getLifespanYears() {
        return lifespanYears;
    }

    public void setLifespanYears(String lifespanYears) {
        this.lifespanYears = lifespanYears;
    }

    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    public String getMeanMotion() {
        return meanMotion;
    }

    public void setMeanMotion(String meanMotion) {
        this.meanMotion = meanMotion;
    }

    public String getRaan() {
        return raan;
    }

    public void setRaan(String raan) {
        this.raan = raan;
    }

    public String getArgOfPericenter() {
        return argOfPericenter;
    }

    public void setArgOfPericenter(String argOfPericenter) {
        this.argOfPericenter = argOfPericenter;
    }

    public String getMeanAnomaly() {
        return meanAnomaly;
    }

    public void setMeanAnomaly(String meanAnomaly) {
        this.meanAnomaly = meanAnomaly;
    }
}
