
package com.moringaschool.bill_tracker;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ConversionApiResponse {

    @SerializedName("query")
    @Expose
    private Query query;
    @SerializedName("data")
    @Expose
    private Data data;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ConversionApiResponse() {
    }

    /**
     * 
     * @param data
     * @param query
     */
    public ConversionApiResponse(Query query, Data data) {
        super();
        this.query = query;
        this.data = data;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
