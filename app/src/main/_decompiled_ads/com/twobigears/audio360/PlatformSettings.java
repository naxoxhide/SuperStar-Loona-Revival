package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public class PlatformSettings {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected PlatformSettings(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(PlatformSettings platformSettings) {
        if (platformSettings == null) {
            return 0L;
        }
        return platformSettings.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                Audio360JNI.delete_PlatformSettings(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setUseAndroidFastPath(boolean z) {
        Audio360JNI.PlatformSettings_useAndroidFastPath_set(this.swigCPtr, this, z);
    }

    public boolean getUseAndroidFastPath() {
        return Audio360JNI.PlatformSettings_useAndroidFastPath_get(this.swigCPtr, this);
    }

    public PlatformSettings() {
        this(Audio360JNI.new_PlatformSettings(), true);
    }
}
