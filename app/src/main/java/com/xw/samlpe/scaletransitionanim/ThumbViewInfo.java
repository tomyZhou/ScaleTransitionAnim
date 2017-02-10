package com.xw.samlpe.scaletransitionanim;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * ThumbViewInfo
 * <p/>
 * Created by woxingxiao on 2016-10-24.
 */
public class ThumbViewInfo implements Parcelable {

    private String url;
    private int index;
    private Rect mBounds;

    public ThumbViewInfo(String url, int index) {
        this.url = url;
        this.index = index;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Rect getBounds() {
        return mBounds;
    }

    public void setBounds(Rect bounds) {
        mBounds = bounds;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeInt(this.index);
        dest.writeParcelable(this.mBounds, flags);
    }

    private ThumbViewInfo(Parcel in) {
        this.url = in.readString();
        this.index = in.readInt();
        this.mBounds = in.readParcelable(Rect.class.getClassLoader());
    }

    public static final Creator<ThumbViewInfo> CREATOR = new Creator<ThumbViewInfo>() {
        @Override
        public ThumbViewInfo createFromParcel(Parcel source) {
            return new ThumbViewInfo(source);
        }

        @Override
        public ThumbViewInfo[] newArray(int size) {
            return new ThumbViewInfo[size];
        }
    };
}
