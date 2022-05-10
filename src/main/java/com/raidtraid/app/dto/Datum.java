
package com.raidtraid.app.dto;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "liveMinutes",
    "liveViewers",
    "overlappingStreams",
    "otherChannelStreams",
    "overlappingEndedDuring",
    "overlappingEndedAfter",
    "previewLarge",
    "preview",
    "currentGame",
    "avgLengthMins",
    "streams",
    "viewminutes",
    "streamedminutes",
    "maxviewers",
    "avgviewers",
    "milestonefollowers",
    "rownum",
    "followers",
    "followersgained",
    "viewsgained",
    "followersgainedwhileplaying",
    "partner",
    "affiliate",
    "mature",
    "language",
    "languageId",
    "status",
    "previousviewminutes",
    "previousstreamedminutes",
    "previousmaxviewers",
    "previousavgviewers",
    "previousfollowergain",
    "previousviewsgained",
    "gamesPlayed",
    "id",
    "logo",
    "twitchurl",
    "url",
    "displayname",
    "baseOnly"
})
@Generated("jsonschema2pojo")
public class Datum {

    @JsonProperty("liveMinutes")
    private Integer liveMinutes;
    @JsonProperty("liveViewers")
    private Integer liveViewers;
    @JsonProperty("overlappingStreams")
    private Integer overlappingStreams;
    @JsonProperty("otherChannelStreams")
    private Integer otherChannelStreams;
    @JsonProperty("overlappingEndedDuring")
    private Integer overlappingEndedDuring;
    @JsonProperty("overlappingEndedAfter")
    private Integer overlappingEndedAfter;
    @JsonProperty("previewLarge")
    private String previewLarge;
    @JsonProperty("preview")
    private String preview;
    @JsonProperty("currentGame")
    private String currentGame;
    @JsonProperty("avgLengthMins")
    private Integer avgLengthMins;
    @JsonProperty("streams")
    private Integer streams;
    @JsonProperty("viewminutes")
    private Integer viewminutes;
    @JsonProperty("streamedminutes")
    private Integer streamedminutes;
    @JsonProperty("maxviewers")
    private Integer maxviewers;
    @JsonProperty("avgviewers")
    private Integer avgviewers;
    @JsonProperty("milestonefollowers")
    private Object milestonefollowers;
    @JsonProperty("rownum")
    private Integer rownum;
    @JsonProperty("followers")
    private Integer followers;
    @JsonProperty("followersgained")
    private Integer followersgained;
    @JsonProperty("viewsgained")
    private Integer viewsgained;
    @JsonProperty("followersgainedwhileplaying")
    private Integer followersgainedwhileplaying;
    @JsonProperty("partner")
    private Boolean partner;
    @JsonProperty("affiliate")
    private Boolean affiliate;
    @JsonProperty("mature")
    private Boolean mature;
    @JsonProperty("language")
    private String language;
    @JsonProperty("languageId")
    private Integer languageId;
    @JsonProperty("status")
    private String status;
    @JsonProperty("previousviewminutes")
    private Object previousviewminutes;
    @JsonProperty("previousstreamedminutes")
    private Object previousstreamedminutes;
    @JsonProperty("previousmaxviewers")
    private Object previousmaxviewers;
    @JsonProperty("previousavgviewers")
    private Object previousavgviewers;
    @JsonProperty("previousfollowergain")
    private Object previousfollowergain;
    @JsonProperty("previousviewsgained")
    private Object previousviewsgained;
    @JsonProperty("gamesPlayed")
    private String gamesPlayed;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("logo")
    private String logo;
    @JsonProperty("twitchurl")
    private String twitchurl;
    @JsonProperty("url")
    private String url;
    @JsonProperty("displayname")
    private String displayname;
    @JsonProperty("baseOnly")
    private Boolean baseOnly;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("liveMinutes")
    public Integer getLiveMinutes() {
        return liveMinutes;
    }

    @JsonProperty("liveMinutes")
    public void setLiveMinutes(Integer liveMinutes) {
        this.liveMinutes = liveMinutes;
    }

    @JsonProperty("liveViewers")
    public Integer getLiveViewers() {
        return liveViewers;
    }

    @JsonProperty("liveViewers")
    public void setLiveViewers(Integer liveViewers) {
        this.liveViewers = liveViewers;
    }

    @JsonProperty("overlappingStreams")
    public Integer getOverlappingStreams() {
        return overlappingStreams;
    }

    @JsonProperty("overlappingStreams")
    public void setOverlappingStreams(Integer overlappingStreams) {
        this.overlappingStreams = overlappingStreams;
    }

    @JsonProperty("otherChannelStreams")
    public Integer getOtherChannelStreams() {
        return otherChannelStreams;
    }

    @JsonProperty("otherChannelStreams")
    public void setOtherChannelStreams(Integer otherChannelStreams) {
        this.otherChannelStreams = otherChannelStreams;
    }

    @JsonProperty("overlappingEndedDuring")
    public Integer getOverlappingEndedDuring() {
        return overlappingEndedDuring;
    }

    @JsonProperty("overlappingEndedDuring")
    public void setOverlappingEndedDuring(Integer overlappingEndedDuring) {
        this.overlappingEndedDuring = overlappingEndedDuring;
    }

    @JsonProperty("overlappingEndedAfter")
    public Integer getOverlappingEndedAfter() {
        return overlappingEndedAfter;
    }

    @JsonProperty("overlappingEndedAfter")
    public void setOverlappingEndedAfter(Integer overlappingEndedAfter) {
        this.overlappingEndedAfter = overlappingEndedAfter;
    }

    @JsonProperty("previewLarge")
    public String getPreviewLarge() {
        return previewLarge;
    }

    @JsonProperty("previewLarge")
    public void setPreviewLarge(String previewLarge) {
        this.previewLarge = previewLarge;
    }

    @JsonProperty("preview")
    public String getPreview() {
        return preview;
    }

    @JsonProperty("preview")
    public void setPreview(String preview) {
        this.preview = preview;
    }

    @JsonProperty("currentGame")
    public String getCurrentGame() {
        return currentGame;
    }

    @JsonProperty("currentGame")
    public void setCurrentGame(String currentGame) {
        this.currentGame = currentGame;
    }

    @JsonProperty("avgLengthMins")
    public Integer getAvgLengthMins() {
        return avgLengthMins;
    }

    @JsonProperty("avgLengthMins")
    public void setAvgLengthMins(Integer avgLengthMins) {
        this.avgLengthMins = avgLengthMins;
    }

    @JsonProperty("streams")
    public Integer getStreams() {
        return streams;
    }

    @JsonProperty("streams")
    public void setStreams(Integer streams) {
        this.streams = streams;
    }

    @JsonProperty("viewminutes")
    public Integer getViewminutes() {
        return viewminutes;
    }

    @JsonProperty("viewminutes")
    public void setViewminutes(Integer viewminutes) {
        this.viewminutes = viewminutes;
    }

    @JsonProperty("streamedminutes")
    public Integer getStreamedminutes() {
        return streamedminutes;
    }

    @JsonProperty("streamedminutes")
    public void setStreamedminutes(Integer streamedminutes) {
        this.streamedminutes = streamedminutes;
    }

    @JsonProperty("maxviewers")
    public Integer getMaxviewers() {
        return maxviewers;
    }

    @JsonProperty("maxviewers")
    public void setMaxviewers(Integer maxviewers) {
        this.maxviewers = maxviewers;
    }

    @JsonProperty("avgviewers")
    public Integer getAvgviewers() {
        return avgviewers;
    }

    @JsonProperty("avgviewers")
    public void setAvgviewers(Integer avgviewers) {
        this.avgviewers = avgviewers;
    }

    @JsonProperty("milestonefollowers")
    public Object getMilestonefollowers() {
        return milestonefollowers;
    }

    @JsonProperty("milestonefollowers")
    public void setMilestonefollowers(Object milestonefollowers) {
        this.milestonefollowers = milestonefollowers;
    }

    @JsonProperty("rownum")
    public Integer getRownum() {
        return rownum;
    }

    @JsonProperty("rownum")
    public void setRownum(Integer rownum) {
        this.rownum = rownum;
    }

    @JsonProperty("followers")
    public Integer getFollowers() {
        return followers;
    }

    @JsonProperty("followers")
    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    @JsonProperty("followersgained")
    public Integer getFollowersgained() {
        return followersgained;
    }

    @JsonProperty("followersgained")
    public void setFollowersgained(Integer followersgained) {
        this.followersgained = followersgained;
    }

    @JsonProperty("viewsgained")
    public Integer getViewsgained() {
        return viewsgained;
    }

    @JsonProperty("viewsgained")
    public void setViewsgained(Integer viewsgained) {
        this.viewsgained = viewsgained;
    }

    @JsonProperty("followersgainedwhileplaying")
    public Integer getFollowersgainedwhileplaying() {
        return followersgainedwhileplaying;
    }

    @JsonProperty("followersgainedwhileplaying")
    public void setFollowersgainedwhileplaying(Integer followersgainedwhileplaying) {
        this.followersgainedwhileplaying = followersgainedwhileplaying;
    }

    @JsonProperty("partner")
    public Boolean getPartner() {
        return partner;
    }

    @JsonProperty("partner")
    public void setPartner(Boolean partner) {
        this.partner = partner;
    }

    @JsonProperty("affiliate")
    public Boolean getAffiliate() {
        return affiliate;
    }

    @JsonProperty("affiliate")
    public void setAffiliate(Boolean affiliate) {
        this.affiliate = affiliate;
    }

    @JsonProperty("mature")
    public Boolean getMature() {
        return mature;
    }

    @JsonProperty("mature")
    public void setMature(Boolean mature) {
        this.mature = mature;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("languageId")
    public Integer getLanguageId() {
        return languageId;
    }

    @JsonProperty("languageId")
    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("previousviewminutes")
    public Object getPreviousviewminutes() {
        return previousviewminutes;
    }

    @JsonProperty("previousviewminutes")
    public void setPreviousviewminutes(Object previousviewminutes) {
        this.previousviewminutes = previousviewminutes;
    }

    @JsonProperty("previousstreamedminutes")
    public Object getPreviousstreamedminutes() {
        return previousstreamedminutes;
    }

    @JsonProperty("previousstreamedminutes")
    public void setPreviousstreamedminutes(Object previousstreamedminutes) {
        this.previousstreamedminutes = previousstreamedminutes;
    }

    @JsonProperty("previousmaxviewers")
    public Object getPreviousmaxviewers() {
        return previousmaxviewers;
    }

    @JsonProperty("previousmaxviewers")
    public void setPreviousmaxviewers(Object previousmaxviewers) {
        this.previousmaxviewers = previousmaxviewers;
    }

    @JsonProperty("previousavgviewers")
    public Object getPreviousavgviewers() {
        return previousavgviewers;
    }

    @JsonProperty("previousavgviewers")
    public void setPreviousavgviewers(Object previousavgviewers) {
        this.previousavgviewers = previousavgviewers;
    }

    @JsonProperty("previousfollowergain")
    public Object getPreviousfollowergain() {
        return previousfollowergain;
    }

    @JsonProperty("previousfollowergain")
    public void setPreviousfollowergain(Object previousfollowergain) {
        this.previousfollowergain = previousfollowergain;
    }

    @JsonProperty("previousviewsgained")
    public Object getPreviousviewsgained() {
        return previousviewsgained;
    }

    @JsonProperty("previousviewsgained")
    public void setPreviousviewsgained(Object previousviewsgained) {
        this.previousviewsgained = previousviewsgained;
    }

    @JsonProperty("gamesPlayed")
    public String getGamesPlayed() {
        return gamesPlayed;
    }

    @JsonProperty("gamesPlayed")
    public void setGamesPlayed(String gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("logo")
    public String getLogo() {
        return logo;
    }

    @JsonProperty("logo")
    public void setLogo(String logo) {
        this.logo = logo;
    }

    @JsonProperty("twitchurl")
    public String getTwitchurl() {
        return twitchurl;
    }

    @JsonProperty("twitchurl")
    public void setTwitchurl(String twitchurl) {
        this.twitchurl = twitchurl;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("displayname")
    public String getDisplayname() {
        return displayname;
    }

    @JsonProperty("displayname")
    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    @JsonProperty("baseOnly")
    public Boolean getBaseOnly() {
        return baseOnly;
    }

    @JsonProperty("baseOnly")
    public void setBaseOnly(Boolean baseOnly) {
        this.baseOnly = baseOnly;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
