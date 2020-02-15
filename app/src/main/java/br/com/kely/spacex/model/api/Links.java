package br.com.kely.spacex.model.api;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Links {

    @SerializedName("mission_patch")
    private String missionPatch;

    @SerializedName("mission_patch_small")
    private String missionPatchSmall;

    @SerializedName("reddit_campaign")
    private String redditCampaign;

    @SerializedName("reddit_launch")
    private String redditLaunch;

    @SerializedName("reddit_recovery")
    private String redditRecovery;

    @SerializedName("reddit_media")
    private String redditMedia;

    private String presskit;

    @SerializedName("article_link")
    private String articleLink;

    private String wikipedia;

    @SerializedName("video_link")
    private String videoLink;

    @SerializedName("youtube_id")
    private String youtubeId;

    @SerializedName("flickr_images")
    private List<String> flickrImages = new ArrayList<>();

    public Links() {
    }

    public String getMissionPatch() {
        return missionPatch;
    }

    public void setMissionPatch(String missionPatch) {
        this.missionPatch = missionPatch;
    }

    public String getMissionPatchSmall() {
        return missionPatchSmall;
    }

    public void setMissionPatchSmall(String missionPatchSmall) {
        this.missionPatchSmall = missionPatchSmall;
    }

    public String getRedditCampaign() {
        return redditCampaign;
    }

    public void setRedditCampaign(String redditCampaign) {
        this.redditCampaign = redditCampaign;
    }

    public String getRedditLaunch() {
        return redditLaunch;
    }

    public void setRedditLaunch(String redditLaunch) {
        this.redditLaunch = redditLaunch;
    }

    public String getRedditRecovery() {
        return redditRecovery;
    }

    public void setRedditRecovery(String redditRecovery) {
        this.redditRecovery = redditRecovery;
    }

    public String getRedditMedia() {
        return redditMedia;
    }

    public void setRedditMedia(String redditMedia) {
        this.redditMedia = redditMedia;
    }

    public String getPresskit() {
        return presskit;
    }

    public void setPresskit(String presskit) {
        this.presskit = presskit;
    }

    public String getArticleLink() {
        return articleLink;
    }

    public void setArticleLink(String articleLink) {
        this.articleLink = articleLink;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    public List<String> getFlickrImages() {
        return flickrImages;
    }

    public void setFlickrImages(List<String> flickrImages) {
        this.flickrImages = flickrImages;
    }
}
