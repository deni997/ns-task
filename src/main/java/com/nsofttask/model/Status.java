package com.nsofttask.model;

public enum Status {
    INACTIVE(0),
    ACTIVE(1);

    private final int status;

    Status(int status) {
        this.status = status;
    }

    public int getStatus() {
        return this.status;
    }
}
