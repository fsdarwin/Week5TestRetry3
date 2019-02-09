
package com.example.week5testretry3.pojos.Sat;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sat implements Parcelable
{
    //PJOJ for received sat list
    @SerializedName("dbn")
    @Expose
    private String dbn;
    @SerializedName("num_of_sat_test_takers")
    @Expose
    private String numOfSatTestTakers;
    @SerializedName("sat_critical_reading_avg_score")
    @Expose
    private String satCriticalReadingAvgScore;
    @SerializedName("sat_math_avg_score")
    @Expose
    private String satMathAvgScore;
    @SerializedName("sat_writing_avg_score")
    @Expose
    private String satWritingAvgScore;
    @SerializedName("school_name")
    @Expose
    private String schoolName;
    public final static Creator<Sat> CREATOR = new Creator<Sat>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Sat createFromParcel(Parcel in) {
            return new Sat(in);
        }

        public Sat[] newArray(int size) {
            return (new Sat[size]);
        }

    }
    ;

    protected Sat(Parcel in) {
        this.dbn = ((String) in.readValue((String.class.getClassLoader())));
        this.numOfSatTestTakers = ((String) in.readValue((String.class.getClassLoader())));
        this.satCriticalReadingAvgScore = ((String) in.readValue((String.class.getClassLoader())));
        this.satMathAvgScore = ((String) in.readValue((String.class.getClassLoader())));
        this.satWritingAvgScore = ((String) in.readValue((String.class.getClassLoader())));
        this.schoolName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Sat() {
    }

    public String getDbn() {
        return dbn;
    }

    public void setDbn(String dbn) {
        this.dbn = dbn;
    }

    public String getNumOfSatTestTakers() {
        return numOfSatTestTakers;
    }

    public void setNumOfSatTestTakers(String numOfSatTestTakers) {
        this.numOfSatTestTakers = numOfSatTestTakers;
    }

    public String getSatCriticalReadingAvgScore() {
        return satCriticalReadingAvgScore;
    }

    public void setSatCriticalReadingAvgScore(String satCriticalReadingAvgScore) {
        this.satCriticalReadingAvgScore = satCriticalReadingAvgScore;
    }

    public String getSatMathAvgScore() {
        return satMathAvgScore;
    }

    public void setSatMathAvgScore(String satMathAvgScore) {
        this.satMathAvgScore = satMathAvgScore;
    }

    public String getSatWritingAvgScore() {
        return satWritingAvgScore;
    }

    public void setSatWritingAvgScore(String satWritingAvgScore) {
        this.satWritingAvgScore = satWritingAvgScore;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(dbn);
        dest.writeValue(numOfSatTestTakers);
        dest.writeValue(satCriticalReadingAvgScore);
        dest.writeValue(satMathAvgScore);
        dest.writeValue(satWritingAvgScore);
        dest.writeValue(schoolName);
    }

    public int describeContents() {
        return  0;
    }

}
