package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public class ThreadSettings {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected ThreadSettings(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ThreadSettings threadSettings) {
        if (threadSettings == null) {
            return 0L;
        }
        return threadSettings.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                Audio360JNI.delete_ThreadSettings(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setUseDecoderThread(boolean z) {
        Audio360JNI.ThreadSettings_useDecoderThread_set(this.swigCPtr, this, z);
    }

    public boolean getUseDecoderThread() {
        return Audio360JNI.ThreadSettings_useDecoderThread_get(this.swigCPtr, this);
    }

    public ThreadSettings() {
        this(Audio360JNI.new_ThreadSettings(), true);
    }
}
