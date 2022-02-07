
package com.moringaschool.bill_tracker;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Query {

    @SerializedName("timestamp")
    @Expose
    private Integer timestamp;
    @SerializedName("base_currency")
    @Expose
    private String baseCurrency;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Query() {
    }

    /**
     * 
     * @param baseCurrency
     * @param timestamp
     */
    public Query(Integer timestamp, String baseCurrency) {
        super();
        this.timestamp = timestamp;
        this.baseCurrency = baseCurrency;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

}
