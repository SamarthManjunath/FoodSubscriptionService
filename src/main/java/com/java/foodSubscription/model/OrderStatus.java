package com.java.foodSubscription.model;

public enum OrderStatus {
    RECEIVED("received"),
    PREPARING("preparing"),
    DONE("done"),
    DELIVERED("delivered");

    private final String displayName;

    OrderStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static OrderStatus fromString(String value) {
        if (value != null) {
            for (OrderStatus status : OrderStatus.values()) {
                if (value.equalsIgnoreCase(status.name()) ||
                        value.equalsIgnoreCase(status.displayName)) {
                    return status;
                }
            }
        }
        throw new IllegalArgumentException("No enum constant " + OrderStatus.class.getName() + "." + value);
    }
}