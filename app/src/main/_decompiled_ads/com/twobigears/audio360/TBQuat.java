package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public class TBQuat {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected TBQuat(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TBQuat tBQuat) {
        if (tBQuat == null) {
            return 0L;
        }
        return tBQuat.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                Audio360JNI.delete_TBQuat(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setX(float f) {
        Audio360JNI.TBQuat_x_set(this.swigCPtr, this, f);
    }

    public float getX() {
        return Audio360JNI.TBQuat_x_get(this.swigCPtr, this);
    }

    public void setY(float f) {
        Audio360JNI.TBQuat_y_set(this.swigCPtr, this, f);
    }

    public float getY() {
        return Audio360JNI.TBQuat_y_get(this.swigCPtr, this);
    }

    public void setZ(float f) {
        Audio360JNI.TBQuat_z_set(this.swigCPtr, this, f);
    }

    public float getZ() {
        return Audio360JNI.TBQuat_z_get(this.swigCPtr, this);
    }

    public void setW(float f) {
        Audio360JNI.TBQuat_w_set(this.swigCPtr, this, f);
    }

    public float getW() {
        return Audio360JNI.TBQuat_w_get(this.swigCPtr, this);
    }

    public TBQuat() {
        this(Audio360JNI.new_TBQuat__SWIG_0(), true);
    }

    public TBQuat(float f, float f2, float f3, float f4) {
        this(Audio360JNI.new_TBQuat__SWIG_1(f, f2, f3, f4), true);
    }

    public TBQuat(TBQuat tBQuat) {
        this(Audio360JNI.new_TBQuat__SWIG_2(getCPtr(tBQuat), tBQuat), true);
    }

    public String toString(int i) {
        return Audio360JNI.TBQuat_toString__SWIG_0(this.swigCPtr, this, i);
    }

    public String toString() {
        return Audio360JNI.TBQuat_toString__SWIG_1(this.swigCPtr, this);
    }

    public TBQuat invert() {
        return new TBQuat(Audio360JNI.TBQuat_invert(this.swigCPtr, this), true);
    }

    public static TBQuat convertFromOpenGLQuaternion(float f, float f2, float f3, float f4) {
        return new TBQuat(Audio360JNI.TBQuat_convertFromOpenGLQuaternion(f, f2, f3, f4), true);
    }

    public static TBQuat getQuatFromEulerAngles(float f, float f2, float f3) {
        return new TBQuat(Audio360JNI.TBQuat_getQuatFromEulerAngles(f, f2, f3), true);
    }

    public static TBVector getEulerAnglesFromQuat(TBQuat tBQuat) {
        return new TBVector(Audio360JNI.TBQuat_getEulerAnglesFromQuat(getCPtr(tBQuat), tBQuat), true);
    }

    public static TBQuat quatProductUnNormalised(TBQuat tBQuat, TBQuat tBQuat2) {
        return new TBQuat(Audio360JNI.TBQuat_quatProductUnNormalised(getCPtr(tBQuat), tBQuat, getCPtr(tBQuat2), tBQuat2), true);
    }

    public static TBVector rotateVectorByQuat(TBQuat tBQuat, TBVector tBVector) {
        return new TBVector(Audio360JNI.TBQuat_rotateVectorByQuat(getCPtr(tBQuat), tBQuat, TBVector.getCPtr(tBVector), tBVector), true);
    }

    public static TBVector antiRotateVectorByQuat(TBQuat tBQuat, TBVector tBVector) {
        return new TBVector(Audio360JNI.TBQuat_antiRotateVectorByQuat(getCPtr(tBQuat), tBQuat, TBVector.getCPtr(tBVector), tBVector), true);
    }

    public static TBQuat getFromToQuatRotation(TBVector tBVector, TBVector tBVector2) {
        return new TBQuat(Audio360JNI.TBQuat_getFromToQuatRotation(TBVector.getCPtr(tBVector), tBVector, TBVector.getCPtr(tBVector2), tBVector2), true);
    }

    public static TBVector getForwardFromQuat(TBQuat tBQuat) {
        return new TBVector(Audio360JNI.TBQuat_getForwardFromQuat(getCPtr(tBQuat), tBQuat), true);
    }

    public static TBVector getUpFromQuat(TBQuat tBQuat) {
        return new TBVector(Audio360JNI.TBQuat_getUpFromQuat(getCPtr(tBQuat), tBQuat), true);
    }

    public static TBVector getRightFromQuat(TBQuat tBQuat) {
        return new TBVector(Audio360JNI.TBQuat_getRightFromQuat(getCPtr(tBQuat), tBQuat), true);
    }

    public static TBQuat getQuatFromForwardAndUpVectors(TBVector tBVector, TBVector tBVector2) {
        return new TBQuat(Audio360JNI.TBQuat_getQuatFromForwardAndUpVectors(TBVector.getCPtr(tBVector), tBVector, TBVector.getCPtr(tBVector2), tBVector2), true);
    }

    public static TBQuat getQuatFromMatrix(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        return new TBQuat(Audio360JNI.TBQuat_getQuatFromMatrix(f, f2, f3, f4, f5, f6, f7, f8, f9), true);
    }

    public static TBQuat identity() {
        return new TBQuat(Audio360JNI.TBQuat_identity(), true);
    }

    public void normalise() {
        Audio360JNI.TBQuat_normalise(this.swigCPtr, this);
    }

    public static TBQuat generateRandomQuat() {
        return new TBQuat(Audio360JNI.TBQuat_generateRandomQuat(), true);
    }
}
