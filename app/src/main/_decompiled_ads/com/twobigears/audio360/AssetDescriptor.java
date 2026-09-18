package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public class AssetDescriptor {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected AssetDescriptor(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(AssetDescriptor assetDescriptor) {
        if (assetDescriptor == null) {
            return 0L;
        }
        return assetDescriptor.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                Audio360JNI.delete_AssetDescriptor(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setOffsetInBytes(long j) {
        Audio360JNI.AssetDescriptor_offsetInBytes_set(this.swigCPtr, this, j);
    }

    public long getOffsetInBytes() {
        return Audio360JNI.AssetDescriptor_offsetInBytes_get(this.swigCPtr, this);
    }

    public void setLengthInBytes(long j) {
        Audio360JNI.AssetDescriptor_lengthInBytes_set(this.swigCPtr, this, j);
    }

    public long getLengthInBytes() {
        return Audio360JNI.AssetDescriptor_lengthInBytes_get(this.swigCPtr, this);
    }

    public AssetDescriptor() {
        this(Audio360JNI.new_AssetDescriptor__SWIG_0(), true);
    }

    public AssetDescriptor(long j, long j2) {
        this(Audio360JNI.new_AssetDescriptor__SWIG_1(j, j2), true);
    }
}
