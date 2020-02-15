package br.com.kely.spacex.model.api;

import com.google.gson.annotations.SerializedName;

public class Timeline {

    @SerializedName("webcast_liftoff")
    private String webcastLiftoff;

    public Timeline() {
    }

    public String getWebcastLiftoff() {
        return webcastLiftoff;
    }

    public void setWebcastLiftoff(String webcastLiftoff) {
        this.webcastLiftoff = webcastLiftoff;
    }
}
