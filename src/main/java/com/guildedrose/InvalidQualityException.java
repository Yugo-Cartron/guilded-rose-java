package com.guildedrose;

public class InvalidQualityException extends Throwable {
    public InvalidQualityException(int quantity) {
        super("Quality cannot be negative, quality provided: " + quantity);
    }
}
