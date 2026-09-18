package com.applovin.impl.mediation.nativeAds.a;

import com.applovin.impl.sdk.utils.o;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.nativeAds.adPlacer.MaxAdPlacerSettings;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private final o<Integer> auH = new o<>();
    private final TreeSet<Integer> auI = new TreeSet<>();
    private final Map<Integer, MaxAd> auJ = new HashMap();
    private int auK;
    private int auL;

    public a(MaxAdPlacerSettings maxAdPlacerSettings) {
        a(maxAdPlacerSettings);
    }

    private void a(MaxAdPlacerSettings maxAdPlacerSettings) {
        if (!maxAdPlacerSettings.hasValidPositioning()) {
            x.H("MaxAdPlacerData", "No positioning info was provided with ad placer settings. You must set at least (1) one or more fixed positions or (2) a repeating interval greater than or equal to 2 for the ad placer to determine where to position ads.");
            return;
        }
        this.auH.addAll(maxAdPlacerSettings.getFixedPositions());
        if (!maxAdPlacerSettings.isRepeatingEnabled()) {
            return;
        }
        int repeatingInterval = maxAdPlacerSettings.getRepeatingInterval();
        if (this.auH.isEmpty()) {
            this.auH.add(Integer.valueOf(repeatingInterval - 1));
        }
        int iIntValue = ((Integer) this.auH.Ln()).intValue();
        while (true) {
            iIntValue += repeatingInterval;
            if (this.auH.size() >= maxAdPlacerSettings.getMaxAdCount()) {
                return;
            } else {
                this.auH.add(Integer.valueOf(iIntValue));
            }
        }
    }

    public boolean isAdPosition(int i) {
        return this.auH.contains(Integer.valueOf(i));
    }

    public boolean isFilledPosition(int i) {
        return this.auI.contains(Integer.valueOf(i));
    }

    public MaxAd gq(int i) {
        return this.auJ.get(Integer.valueOf(i));
    }

    public int yK() {
        int i = this.auK;
        if (i != -1 && this.auL != -1) {
            while (i <= this.auL) {
                if (isAdPosition(i) && !isFilledPosition(i)) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public Collection<Integer> yL() {
        return new TreeSet((SortedSet) this.auI);
    }

    public Collection<Integer> gr(int i) {
        return new TreeSet((SortedSet) this.auI.tailSet(Integer.valueOf(i), false));
    }

    public void Q(int i, int i2) {
        this.auK = i;
        this.auL = i2;
    }

    public void a(MaxAd maxAd, int i) {
        this.auJ.put(Integer.valueOf(i), maxAd);
        this.auI.add(Integer.valueOf(i));
    }

    public void clearAds() {
        this.auJ.clear();
        this.auI.clear();
    }

    public void g(Collection<Integer> collection) {
        for (Integer num : collection) {
            this.auJ.remove(num);
            this.auI.remove(num);
        }
    }

    public int getAdjustedCount(int i) {
        if (i == 0) {
            return 0;
        }
        return i + q(i - 1, false);
    }

    public int getAdjustedPosition(int i) {
        return i + q(i, false);
    }

    public int getOriginalPosition(int i) {
        if (isAdPosition(i)) {
            return -1;
        }
        return i - q(i, true);
    }

    public void insertItem(int i) {
        int iC = this.auH.c(Integer.valueOf(i));
        for (int size = this.auH.size() - 1; size >= iC; size--) {
            Integer num = (Integer) this.auH.gS(size);
            int iIntValue = num.intValue() + 1;
            R(num.intValue(), iIntValue);
            this.auH.a(size, Integer.valueOf(iIntValue));
        }
    }

    public void removeItem(int i) {
        int iC = this.auH.c(Integer.valueOf(i));
        if (isAdPosition(i)) {
            this.auJ.remove(Integer.valueOf(i));
            this.auI.remove(Integer.valueOf(i));
            this.auH.gT(iC);
        }
        while (iC < this.auH.size()) {
            Integer num = (Integer) this.auH.gS(iC);
            int iIntValue = num.intValue() - 1;
            R(num.intValue(), iIntValue);
            this.auH.a(iC, Integer.valueOf(iIntValue));
            iC++;
        }
    }

    public void moveItem(int i, int i2) {
        removeItem(i);
        insertItem(i2);
    }

    private void R(int i, int i2) {
        if (this.auJ.containsKey(Integer.valueOf(i))) {
            this.auJ.put(Integer.valueOf(i2), this.auJ.get(Integer.valueOf(i)));
            this.auI.add(Integer.valueOf(i2));
            this.auJ.remove(Integer.valueOf(i));
            this.auI.remove(Integer.valueOf(i));
        }
    }

    private int q(int i, boolean z) {
        int iD = this.auH.d(Integer.valueOf(i));
        if (!z) {
            int i2 = i + iD;
            while (iD < this.auH.size() && i2 >= ((Integer) this.auH.gS(iD)).intValue()) {
                i2++;
                iD++;
            }
        }
        return iD;
    }
}
