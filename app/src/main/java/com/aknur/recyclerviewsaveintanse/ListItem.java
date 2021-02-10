package com.aknur.recyclerviewsaveintanse;

import android.os.Parcel;
import android.os.Parcelable;

class ListItem implements Parcelable {
    private String name;

    public ListItem(String name) {
        this.name = name;
    }

    protected ListItem(Parcel in) {
        name = in.readString();
    }

    public static final Creator<ListItem> CREATOR = new Creator<ListItem>() {
        @Override
        public ListItem createFromParcel(Parcel in) {
            return new ListItem(in);
        }

        @Override
        public ListItem[] newArray(int size) {
            return new ListItem[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
    }
}
