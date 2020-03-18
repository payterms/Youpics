package ru.payts.youpics.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Season {
    @Expose
    @SerializedName("time_of_year")
    String timeOfYear;

    @Expose
    @SerializedName("year")
    int year;
}

