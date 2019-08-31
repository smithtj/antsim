package com.worldwarant.antsim.common;

import java.util.Random;

public class RandomUtils {
    private static Random random = new Random();

    public static void forceSetRandom(long seed) {
        random = new Random(seed);
    }

    public static int getRandomInRange(int lowerBound, int range) {
        if (range < 1) return lowerBound;
        int baseRandom = random.nextInt(range + 1);
        int shiftedRandom = baseRandom + lowerBound;
        return shiftedRandom;
    }

    public static int getRandomInRange(int upperBound) {
        return getRandomInRange(0, upperBound);
    }
}
