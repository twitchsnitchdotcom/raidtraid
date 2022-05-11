
package com.raidtraid.app.dto.schedule;

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
    "id",
    "start_time",
    "end_time",
    "title",
    "canceled_until",
    "category",
    "is_recurring"
})
@Generated("jsonschema2pojo")
public class Segment {

    @JsonProperty("id")
    private String id;
    @JsonProperty("start_time")
    private String startTime;
    @JsonProperty("end_time")
    private String endTime;
    @JsonProperty("title")
    private String title;
    @JsonProperty("canceled_until")
    private Object canceledUntil;
    @JsonProperty("category")
    private Object category;
    @JsonProperty("is_recurring")
    private Boolean isRecurring;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("start_time")
    public String getStartTime() {
        return startTime;
    }

    @JsonProperty("start_time")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @JsonProperty("end_time")
    public String getEndTime() {
        return endTime;
    }

    @JsonProperty("end_time")
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("canceled_until")
    public Object getCanceledUntil() {
        return canceledUntil;
    }

    @JsonProperty("canceled_until")
    public void setCanceledUntil(Object canceledUntil) {
        this.canceledUntil = canceledUntil;
    }

    @JsonProperty("category")
    public Object getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(Object category) {
        this.category = category;
    }

    @JsonProperty("is_recurring")
    public Boolean getIsRecurring() {
        return isRecurring;
    }

    @JsonProperty("is_recurring")
    public void setIsRecurring(Boolean isRecurring) {
        this.isRecurring = isRecurring;
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
