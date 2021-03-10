package com.segurosbolivar.automation.commons.enums;

public enum Dom {

    TRANSVERSAL(12345),
    LOGIN(4564),
    HOME(234223424);

    public final int id;

    Dom(int id) {
        this.id = id;
    }

    public final int getId() {
        return id;
    }

}
