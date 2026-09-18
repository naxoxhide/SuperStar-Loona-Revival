package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public class AttenuationProps {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected AttenuationProps(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(AttenuationProps attenuationProps) {
        if (attenuationProps == null) {
            return 0L;
        }
        return attenuationProps.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                Audio360JNI.delete_AttenuationProps(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setMinimumDistance(float f) {
        Audio360JNI.AttenuationProps_minimumDistance_set(this.swigCPtr, this, f);
    }

    public float getMinimumDistance() {
        return Audio360JNI.AttenuationProps_minimumDistance_get(this.swigCPtr, this);
    }

    public void setMaximumDistance(float f) {
        Audio360JNI.AttenuationProps_maximumDistance_set(this.swigCPtr, this, f);
    }

    public float getMaximumDistance() {
        return Audio360JNI.AttenuationProps_maximumDistance_get(this.swigCPtr, this);
    }

    public void setFactor(float f) {
        Audio360JNI.AttenuationProps_factor_set(this.swigCPtr, this, f);
    }

    public float getFactor() {
        return Audio360JNI.AttenuationProps_factor_get(this.swigCPtr, this);
    }

    public void setMaxDistanceMute(boolean z) {
        Audio360JNI.AttenuationProps_maxDistanceMute_set(this.swigCPtr, this, z);
    }

    public boolean getMaxDistanceMute() {
        return Audio360JNI.AttenuationProps_maxDistanceMute_get(this.swigCPtr, this);
    }

    public AttenuationProps() {
        this(Audio360JNI.new_AttenuationProps__SWIG_0(), true);
    }

    public AttenuationProps(float f, float f2, float f3, boolean z) {
        this(Audio360JNI.new_AttenuationProps__SWIG_1(f, f2, f3, z), true);
    }

    public AttenuationProps(float f, float f2, float f3) {
        this(Audio360JNI.new_AttenuationProps__SWIG_2(f, f2, f3), true);
    }
}
