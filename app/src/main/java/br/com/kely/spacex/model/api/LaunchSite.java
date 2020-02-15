package br.com.kely.spacex.model.api;

import com.google.gson.annotations.SerializedName;

public class LaunchSite {

    @SerializedName("site_id")
    private String siteId;

    @SerializedName("site_name")
    private String siteName;

    @SerializedName("site_name_long")
    private String siteNameLong;

    public LaunchSite() {
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteNameLong() {
        return siteNameLong;
    }

    public void setSiteNameLong(String siteNameLong) {
        this.siteNameLong = siteNameLong;
    }
}
