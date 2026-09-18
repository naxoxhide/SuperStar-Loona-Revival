package com.twobigears.audio360;

/* JADX INFO: loaded from: classes4.dex */
public abstract class EventListener {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public abstract void onNewEvent(Event event);

    protected EventListener(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(EventListener eventListener) {
        if (eventListener == null) {
            return 0L;
        }
        return eventListener.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                Audio360JNI.delete_EventListener(j);
            }
            this.swigCPtr = 0L;
        }
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        Audio360JNI.EventListener_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        Audio360JNI.EventListener_change_ownership(this, this.swigCPtr, true);
    }

    public EventListener() {
        this(Audio360JNI.new_EventListener(), true);
        Audio360JNI.EventListener_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
