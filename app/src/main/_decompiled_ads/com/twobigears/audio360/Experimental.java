package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public class Experimental {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected Experimental(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Experimental experimental) {
        if (experimental == null) {
            return 0L;
        }
        return experimental.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                Audio360JNI.delete_Experimental(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setAmbisonicRenderer(AmbisonicRenderer ambisonicRenderer) {
        Audio360JNI.Experimental_ambisonicRenderer_set(this.swigCPtr, this, ambisonicRenderer.swigValue());
    }

    public AmbisonicRenderer getAmbisonicRenderer() {
        return AmbisonicRenderer.swigToEnum(Audio360JNI.Experimental_ambisonicRenderer_get(this.swigCPtr, this));
    }

    public Experimental() {
        this(Audio360JNI.new_Experimental(), true);
    }
}
