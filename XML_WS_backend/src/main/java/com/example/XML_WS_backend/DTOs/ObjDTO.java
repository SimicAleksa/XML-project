package com.example.XML_WS_backend.DTOs;


import java.lang.reflect.Field;

public abstract class ObjDTO {
    public boolean areAllAttributesNonNull() {
        for (Field field : this.getClass().getDeclaredFields())
            try {
                field.setAccessible(true);
                if (field.getType().equals(String.class) && field.get(this) == null)
                    return false;
            } catch (IllegalAccessException ignored) {}
        return true;
    }
}
