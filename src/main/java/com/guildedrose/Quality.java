package com.guildedrose;

public class Quality {

    private static final int NORMAL_QUALITY_DECREASE = 1;
    private static final int FASTER_QUALITY_DECREASE = 2;

    private int value;

    private Quality(int value) throws InvalidQualityException {
        if (value < 0) {
            throw new InvalidQualityException(value);
        }
        this.value = value;
    }

    public static Quality of(int value) throws InvalidQualityException {
        return new Quality(value);
    }
    public int value() {
        return value;
    }

    public void decrease() {
        if (value >= NORMAL_QUALITY_DECREASE) {
            this.value --;
        }
    }

    public void decreaseFaster() {
        if (value >= FASTER_QUALITY_DECREASE) {
            this.value -= FASTER_QUALITY_DECREASE;
        } else {
            this.value = 0;
        }
    }

}
