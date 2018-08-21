package com.example.user.list;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class SensorDescription  implements Parcelable{
    String name;
    String type;
    String vendor;
    String version;
    String  max;
    String resolution;


    public SensorDescription(String name, String type, String vendor, String version, String max, String resolution) {
        this.name = name;
        this.type = type;
        this.vendor = vendor;
        this.version = version;
        this.max = max;
        this.resolution = resolution;
    }

    public SensorDescription() {
    }

    protected SensorDescription(Parcel in) {
        name = in.readString();
        type = in.readString();
        vendor = in.readString();
        version = in.readString();
        max = in.readString();
        resolution = in.readString();
    }

    public static final Creator<SensorDescription> CREATOR = new Creator<SensorDescription>() {
        @Override
        public SensorDescription createFromParcel(Parcel in) {
            return new SensorDescription(in);
        }

        @Override
        public SensorDescription[] newArray(int size) {
            return new SensorDescription[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(type);
        parcel.writeString(vendor);
        parcel.writeString(version);
        parcel.writeString(max);
        parcel.writeString(resolution);
    }
}
