package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public class TBVector {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected TBVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TBVector tBVector) {
        if (tBVector == null) {
            return 0L;
        }
        return tBVector.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                Audio360JNI.delete_TBVector(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setX(float f) {
        Audio360JNI.TBVector_x_set(this.swigCPtr, this, f);
    }

    public float getX() {
        return Audio360JNI.TBVector_x_get(this.swigCPtr, this);
    }

    public void setY(float f) {
        Audio360JNI.TBVector_y_set(this.swigCPtr, this, f);
    }

    public float getY() {
        return Audio360JNI.TBVector_y_get(this.swigCPtr, this);
    }

    public void setZ(float f) {
        Audio360JNI.TBVector_z_set(this.swigCPtr, this, f);
    }

    public float getZ() {
        return Audio360JNI.TBVector_z_get(this.swigCPtr, this);
    }

    public TBVector() {
        this(Audio360JNI.new_TBVector__SWIG_0(), true);
    }

    public TBVector(float f, float f2, float f3) {
        this(Audio360JNI.new_TBVector__SWIG_1(f, f2, f3), true);
    }

    public TBVector(float f) {
        this(Audio360JNI.new_TBVector__SWIG_2(f), true);
    }

    public static TBVector CrossProduct(TBVector tBVector, TBVector tBVector2) {
        return new TBVector(Audio360JNI.TBVector_CrossProduct(getCPtr(tBVector), tBVector, getCPtr(tBVector2), tBVector2), true);
    }

    public static TBVector zero() {
        return new TBVector(Audio360JNI.TBVector_zero(), true);
    }

    public static TBVector forward() {
        return new TBVector(Audio360JNI.TBVector_forward(), true);
    }

    public static TBVector up() {
        return new TBVector(Audio360JNI.TBVector_up(), true);
    }

    public static float DotProduct(TBVector tBVector, TBVector tBVector2) {
        return Audio360JNI.TBVector_DotProduct(getCPtr(tBVector), tBVector, getCPtr(tBVector2), tBVector2);
    }

    public static float Angle(TBVector tBVector, TBVector tBVector2) {
        return Audio360JNI.TBVector_Angle(getCPtr(tBVector), tBVector, getCPtr(tBVector2), tBVector2);
    }

    public static float magnitude(TBVector tBVector) {
        return Audio360JNI.TBVector_magnitude(getCPtr(tBVector), tBVector);
    }

    public static void clampMagnitude(TBVector tBVector, float f) {
        Audio360JNI.TBVector_clampMagnitude(getCPtr(tBVector), tBVector, f);
    }

    public static float magSquared(TBVector tBVector) {
        return Audio360JNI.TBVector_magSquared(getCPtr(tBVector), tBVector);
    }

    public static void normalise(TBVector tBVector) {
        Audio360JNI.TBVector_normalise(getCPtr(tBVector), tBVector);
    }

    public void set(float f, float f2, float f3) {
        Audio360JNI.TBVector_set(this.swigCPtr, this, f, f2, f3);
    }

    public void abs() {
        Audio360JNI.TBVector_abs__SWIG_0(this.swigCPtr, this);
    }

    public static void rotateByVectors(TBVector tBVector, TBVector tBVector2, TBVector tBVector3) {
        Audio360JNI.TBVector_rotateByVectors(getCPtr(tBVector), tBVector, getCPtr(tBVector2), tBVector2, getCPtr(tBVector3), tBVector3);
    }

    public float min_val() {
        return Audio360JNI.TBVector_min_val(this.swigCPtr, this);
    }

    public float max_val() {
        return Audio360JNI.TBVector_max_val(this.swigCPtr, this);
    }

    public String toString(int i) {
        return Audio360JNI.TBVector_toString__SWIG_0(this.swigCPtr, this, i);
    }

    public String toString() {
        return Audio360JNI.TBVector_toString__SWIG_1(this.swigCPtr, this);
    }

    public static TBVector getVectorFromAziEle(float f, float f2) {
        return new TBVector(Audio360JNI.TBVector_getVectorFromAziEle(f, f2), true);
    }

    public static TBVector getVectorFromAziEleDist(float f, float f2, float f3) {
        return new TBVector(Audio360JNI.TBVector_getVectorFromAziEleDist(f, f2, f3), true);
    }

    public static TBVector getVectorFromEuler(TBVector tBVector) {
        return new TBVector(Audio360JNI.TBVector_getVectorFromEuler(getCPtr(tBVector), tBVector), true);
    }
}
