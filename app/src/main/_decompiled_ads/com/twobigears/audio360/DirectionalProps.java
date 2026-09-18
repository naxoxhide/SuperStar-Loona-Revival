package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public class DirectionalProps {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DirectionalProps(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DirectionalProps directionalProps) {
        if (directionalProps == null) {
            return 0L;
        }
        return directionalProps.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                Audio360JNI.delete_DirectionalProps(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setEffectLevel(float f) {
        Audio360JNI.DirectionalProps_effectLevel_set(this.swigCPtr, this, f);
    }

    public float getEffectLevel() {
        return Audio360JNI.DirectionalProps_effectLevel_get(this.swigCPtr, this);
    }

    public void setConeArea(float f) {
        Audio360JNI.DirectionalProps_coneArea_set(this.swigCPtr, this, f);
    }

    public float getConeArea() {
        return Audio360JNI.DirectionalProps_coneArea_get(this.swigCPtr, this);
    }

    public DirectionalProps() {
        this(Audio360JNI.new_DirectionalProps__SWIG_0(), true);
    }

    public DirectionalProps(float f, float f2) {
        this(Audio360JNI.new_DirectionalProps__SWIG_1(f, f2), true);
    }

    public void set(float f, float f2) {
        Audio360JNI.DirectionalProps_set(this.swigCPtr, this, f, f2);
    }
}
