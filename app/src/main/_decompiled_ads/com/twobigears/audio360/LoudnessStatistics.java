package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public class LoudnessStatistics {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected LoudnessStatistics(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(LoudnessStatistics loudnessStatistics) {
        if (loudnessStatistics == null) {
            return 0L;
        }
        return loudnessStatistics.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                Audio360JNI.delete_LoudnessStatistics(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setIntegrated(float f) {
        Audio360JNI.LoudnessStatistics_integrated_set(this.swigCPtr, this, f);
    }

    public float getIntegrated() {
        return Audio360JNI.LoudnessStatistics_integrated_get(this.swigCPtr, this);
    }

    public void setShortTerm(float f) {
        Audio360JNI.LoudnessStatistics_shortTerm_set(this.swigCPtr, this, f);
    }

    public float getShortTerm() {
        return Audio360JNI.LoudnessStatistics_shortTerm_get(this.swigCPtr, this);
    }

    public void setMomentary(float f) {
        Audio360JNI.LoudnessStatistics_momentary_set(this.swigCPtr, this, f);
    }

    public float getMomentary() {
        return Audio360JNI.LoudnessStatistics_momentary_get(this.swigCPtr, this);
    }

    public void setTruePeak(float f) {
        Audio360JNI.LoudnessStatistics_truePeak_set(this.swigCPtr, this, f);
    }

    public float getTruePeak() {
        return Audio360JNI.LoudnessStatistics_truePeak_get(this.swigCPtr, this);
    }

    public LoudnessStatistics() {
        this(Audio360JNI.new_LoudnessStatistics(), true);
    }
}
