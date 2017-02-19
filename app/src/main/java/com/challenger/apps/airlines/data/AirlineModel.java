package com.challenger.apps.airlines.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Challenger on 2/19/17.
 */

public class AirlineModel implements Parcelable {

    @SerializedName("__clazz")
    @Expose
    private String clazz;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("defaultName")
    @Expose
    private String defaultName;
    @SerializedName("logoURL")
    @Expose
    private String logoURL;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("site")
    @Expose
    private String site;
    @SerializedName("usName")
    @Expose
    private String usName;

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDefaultName() {
        return defaultName;
    }

    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    public String getLogoURL() {
        return logoURL;
    }

    public void setLogoURL(String logoURL) {
        this.logoURL = logoURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getUsName() {
        return usName;
    }

    public void setUsName(String usName) {
        this.usName = usName;
    }


    protected AirlineModel(Parcel in) {
        clazz = in.readString();
        code = in.readString();
        defaultName = in.readString();
        logoURL = in.readString();
        name = in.readString();
        phone = in.readString();
        site = in.readString();
        usName = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(clazz);
        dest.writeString(code);
        dest.writeString(defaultName);
        dest.writeString(logoURL);
        dest.writeString(name);
        dest.writeString(phone);
        dest.writeString(site);
        dest.writeString(usName);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<AirlineModel> CREATOR = new Parcelable.Creator<AirlineModel>() {
        @Override
        public AirlineModel createFromParcel(Parcel in) {
            return new AirlineModel(in);
        }

        @Override
        public AirlineModel[] newArray(int size) {
            return new AirlineModel[size];
        }
    };
}
