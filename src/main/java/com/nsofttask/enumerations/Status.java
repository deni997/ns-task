package com.nsofttask.enumerations;

import com.google.gson.annotations.SerializedName;

public enum Status {
    @SerializedName("0")
    INACTIVE(0),
    @SerializedName("1")
    ACTIVE(1);

    private final int status;

    Status(int status) {
        this.status = status;
    }

    public int getStatus() {
        return this.status;
    }
}
