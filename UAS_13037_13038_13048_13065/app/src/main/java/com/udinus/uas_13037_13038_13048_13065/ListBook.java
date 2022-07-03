package com.udinus.uas_13037_13038_13048_13065;

import android.os.Parcel;
import android.os.Parcelable;

public class ListBook implements Parcelable {
    private String judul;
    private String detail;
    private int photo;

    public ListBook(){

    }

    protected ListBook(Parcel in) {
        judul = in.readString();
        detail = in.readString();
        photo = in.readInt();
    }

    public static final Creator<ListBook> CREATOR = new Creator<ListBook>() {
        @Override
        public ListBook createFromParcel(Parcel in) {
            return new ListBook(in);
        }

        @Override
        public ListBook[] newArray(int size) {
            return new ListBook[size];
        }
    };

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDetail() { return detail; }

    public void setDetail(String detail) { this.detail = detail; }

    public int getPhoto() { return photo; }

    public void setPhoto(int photo) { this.photo = photo; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(judul);
        parcel.writeString(detail);
        parcel.writeInt(photo);
    }
}
