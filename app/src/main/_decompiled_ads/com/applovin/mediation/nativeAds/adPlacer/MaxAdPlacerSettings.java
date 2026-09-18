package com.applovin.mediation.nativeAds.adPlacer;

import com.applovin.impl.sdk.x;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public class MaxAdPlacerSettings {
    public static final int MIN_REPEATING_INTERVAL = 2;
    private final Set<Integer> aYT = new TreeSet();
    private int aYU = 0;
    private int aYV = 256;
    private int aYW = 4;
    private final String adUnitId;
    private String amL;

    public MaxAdPlacerSettings(String str) {
        this.adUnitId = str;
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public String getPlacement() {
        return this.amL;
    }

    public void setPlacement(String str) {
        this.amL = str;
    }

    public Set<Integer> getFixedPositions() {
        return this.aYT;
    }

    public int getRepeatingInterval() {
        return this.aYU;
    }

    public int getMaxAdCount() {
        return this.aYV;
    }

    public void setMaxAdCount(int i) {
        this.aYV = i;
    }

    public int getMaxPreloadedAdCount() {
        return this.aYW;
    }

    public void setMaxPreloadedAdCount(int i) {
        this.aYW = i;
    }

    public void addFixedPosition(int i) {
        this.aYT.add(Integer.valueOf(i));
    }

    public void resetFixedPositions() {
        this.aYT.clear();
    }

    public void setRepeatingInterval(int i) {
        if (i >= 2) {
            this.aYU = i;
            x.D("MaxAdPlacerSettings", "Repeating interval set to " + i);
        } else {
            this.aYU = 0;
            x.F("MaxAdPlacerSettings", "Repeating interval has been disabled, since it has been set to " + i + ", which is less than minimum value of 2");
        }
    }

    public boolean isRepeatingEnabled() {
        return this.aYU >= 2;
    }

    public boolean hasValidPositioning() {
        return !this.aYT.isEmpty() || isRepeatingEnabled();
    }

    public String toString() {
        return "MaxAdPlacerSettings{adUnitId='" + this.adUnitId + "', fixedPositions=" + this.aYT + ", repeatingInterval=" + this.aYU + ", maxAdCount=" + this.aYV + ", maxPreloadedAdCount=" + this.aYW + '}';
    }
}
