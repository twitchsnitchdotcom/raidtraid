
package com.raidtraid.app.dto.schedule;

import java.util.HashMap;
import java.util.List;
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
    "segments",
    "broadcaster_id",
    "broadcaster_name",
    "broadcaster_login",
    "vacation"
})
@Generated("jsonschema2pojo")
public class Data {

    @JsonProperty("segments")
    private List<Segment> segments = null;
    @JsonProperty("broadcaster_id")
    private String broadcasterId;
    @JsonProperty("broadcaster_name")
    private String broadcasterName;
    @JsonProperty("broadcaster_login")
    private String broadcasterLogin;
    @JsonProperty("vacation")
    private Object vacation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("segments")
    public List<Segment> getSegments() {
        return segments;
    }

    @JsonProperty("segments")
    public void setSegments(List<Segment> segments) {
        this.segments = segments;
    }

    @JsonProperty("broadcaster_id")
    public String getBroadcasterId() {
        return broadcasterId;
    }

    @JsonProperty("broadcaster_id")
    public void setBroadcasterId(String broadcasterId) {
        this.broadcasterId = broadcasterId;
    }

    @JsonProperty("broadcaster_name")
    public String getBroadcasterName() {
        return broadcasterName;
    }

    @JsonProperty("broadcaster_name")
    public void setBroadcasterName(String broadcasterName) {
        this.broadcasterName = broadcasterName;
    }

    @JsonProperty("broadcaster_login")
    public String getBroadcasterLogin() {
        return broadcasterLogin;
    }

    @JsonProperty("broadcaster_login")
    public void setBroadcasterLogin(String broadcasterLogin) {
        this.broadcasterLogin = broadcasterLogin;
    }

    @JsonProperty("vacation")
    public Object getVacation() {
        return vacation;
    }

    @JsonProperty("vacation")
    public void setVacation(Object vacation) {
        this.vacation = vacation;
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
