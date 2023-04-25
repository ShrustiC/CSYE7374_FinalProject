package org.csye7374.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class Utils {
    private static AtomicInteger ID = new AtomicInteger(0);

    public static Integer getID() {
        return ID.addAndGet(1);
    }
}
