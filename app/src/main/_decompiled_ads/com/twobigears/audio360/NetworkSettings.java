package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public class NetworkSettings {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected NetworkSettings(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NetworkSettings networkSettings) {
        if (networkSettings == null) {
            return 0L;
        }
        return networkSettings.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                Audio360JNI.delete_NetworkSettings(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setStreamingBufferSizeBytes(long j) {
        Audio360JNI.NetworkSettings_streamingBufferSizeBytes_set(this.swigCPtr, this, j);
    }

    public long getStreamingBufferSizeBytes() {
        return Audio360JNI.NetworkSettings_streamingBufferSizeBytes_get(this.swigCPtr, this);
    }

    public void setMaxDownloadSpeedBytes(long j) {
        Audio360JNI.NetworkSettings_maxDownloadSpeedBytes_set(this.swigCPtr, this, j);
    }

    public long getMaxDownloadSpeedBytes() {
        return Audio360JNI.NetworkSettings_maxDownloadSpeedBytes_get(this.swigCPtr, this);
    }

    public void setPrintDebugInfo(boolean z) {
        Audio360JNI.NetworkSettings_printDebugInfo_set(this.swigCPtr, this, z);
    }

    public boolean getPrintDebugInfo() {
        return Audio360JNI.NetworkSettings_printDebugInfo_get(this.swigCPtr, this);
    }

    public NetworkSettings() {
        this(Audio360JNI.new_NetworkSettings(), true);
    }
}
