package com.java.foodSubscription.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class OrderStatusConverter implements AttributeConverter<OrderStatus, String> {

    @Override
    public String convertToDatabaseColumn(OrderStatus status) {
        return status != null ? status.getDisplayName() : null;
    }

    @Override
    public OrderStatus convertToEntityAttribute(String dbValue) {
        return dbValue != null ? OrderStatus.fromString(dbValue) : null;
    }
}