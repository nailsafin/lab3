package com.company;

public interface DependentOnPosition {
    default int getPosition() {
        return 0;
    }
}
