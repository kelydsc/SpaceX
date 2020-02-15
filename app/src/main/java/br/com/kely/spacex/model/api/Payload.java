package br.com.kely.spacex.model.api;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Payload {

    @SerializedName("payload_id")
    private String payloadId;

    @SerializedName("norad_id")
    private List<String> noradId = new ArrayList<>();

    private String reused;

    private List<String> customers = new ArrayList<>();

    private String nationality;

    private String manufacturer;

    @SerializedName("payload_type")
    private String payloadType;

    @SerializedName("payload_mass_kg")
    private String payloadMassKg;

    @SerializedName("payload_mass_lbs")
    private String payloadMassLbs;

    private String orbit;

    @SerializedName("orbit_params")
    private OrbitParams orbitParams;

    public Payload() {
    }

    public String getPayloadId() {
        return payloadId;
    }

    public void setPayloadId(String payloadId) {
        this.payloadId = payloadId;
    }

    public List<String> getNoradId() {
        return noradId;
    }

    public void setNoradId(List<String> noradId) {
        this.noradId = noradId;
    }

    public String getReused() {
        return reused;
    }

    public void setReused(String reused) {
        this.reused = reused;
    }

    public List<String> getCustomers() {
        return customers;
    }

    public void setCustomers(List<String> customers) {
        this.customers = customers;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPayloadType() {
        return payloadType;
    }

    public void setPayloadType(String payloadType) {
        this.payloadType = payloadType;
    }

    public String getPayloadMassKg() {
        return payloadMassKg;
    }

    public void setPayloadMassKg(String payloadMassKg) {
        this.payloadMassKg = payloadMassKg;
    }

    public String getPayloadMassLbs() {
        return payloadMassLbs;
    }

    public void setPayloadMassLbs(String payloadMassLbs) {
        this.payloadMassLbs = payloadMassLbs;
    }

    public String getOrbit() {
        return orbit;
    }

    public void setOrbit(String orbit) {
        this.orbit = orbit;
    }

    public OrbitParams getOrbitParams() {
        return orbitParams;
    }

    public void setOrbitParams(OrbitParams orbitParams) {
        this.orbitParams = orbitParams;
    }
}
