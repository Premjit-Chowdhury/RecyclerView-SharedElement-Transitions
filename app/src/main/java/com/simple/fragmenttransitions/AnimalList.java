package com.simple.fragmenttransitions;
import android.os.Parcelable;
import android.os.Parcel;

public class AnimalList implements Parcelable {
    
    private int mId;
    private String mWords;
    private String mMeaning;

    
    public AnimalList() {

    }
    
    public AnimalList(int mId, String mWords, String mMeaning) {
        this.mId = mId;
        this.mWords = mWords;
        this.mMeaning = mMeaning;
    }

    
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel par, int inFlag) {

        par.writeInt(mId);
        par.writeString(mWords);
        par.writeString(mMeaning);
       
        

    }

    public AnimalList(Parcel reads) {

        mId = reads.readInt();
        mWords=reads.readString();
        mMeaning= reads.readString();
        
    }

    public static final Creator<AnimalList> CREATOR = new Creator<AnimalList>() {

        @Override
        public AnimalList createFromParcel(Parcel reads) {
            return new AnimalList(reads);
        }

        @Override
        public AnimalList[] newArray(int size) {
            return new AnimalList[size];
        }

    };
    
    
    
    

    public void setMId(int mId) {
        this.mId = mId;
    }

    public int getMId() {
        return mId;
    }

    public void setMWords(String mWords) {
        this.mWords = mWords;
    }

    public String getMWords() {
        return mWords;
    }

    public void setMMeaning(String mMeaning) {
        this.mMeaning = mMeaning;
    }

    public String getMMeaning() {
        return mMeaning;
    }

    
    
    
}
