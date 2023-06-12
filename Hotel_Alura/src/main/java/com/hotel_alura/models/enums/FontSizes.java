package com.hotel_alura.models.enums;

public enum FontSizes {
    SMALL(12),
    MEDIUM(16),
    LARGE(20),
    XLARGE(24),
    XXLARGE(33);

    private int size;

    FontSizes(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
