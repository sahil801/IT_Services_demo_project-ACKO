package com.example.ItService.enums;

public enum requestStatusType {
    OPEN("open"),
    IN_PROGRESS("in-progress"),
    CLOSED("closed");
    private final String value;
    requestStatusType(String value){
        this.value=value;
    }
    @Override
    public String toString(){
        return this.value;
    }
}
