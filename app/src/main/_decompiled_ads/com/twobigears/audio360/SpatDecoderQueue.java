package com.twobigears.audio360;

import java.math.BigInteger;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public class SpatDecoderQueue extends SpatDecoderInterface {
    private EventListener eventListener_;
    private transient long swigCPtr;

    protected SpatDecoderQueue(long j, boolean z) {
        super(Audio360JNI.SpatDecoderQueue_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(SpatDecoderQueue spatDecoderQueue) {
        if (spatDecoderQueue == null) {
            return 0L;
        }
        return spatDecoderQueue.swigCPtr;
    }

    @Override // com.twobigears.audio360.SpatDecoderInterface, com.twobigears.audio360.Object3D, com.twobigears.audio360.TransportControl
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public void setEventListener(EventListener eventListener) {
        EventListener eventListener2 = this.eventListener_;
        if (eventListener2 != null) {
            eventListener2.delete();
            this.eventListener_ = null;
        }
        this.eventListener_ = eventListener;
        setEventListenerInternal(eventListener);
    }

    public int getFreeSpaceInQueue(ChannelMap channelMap) {
        return Audio360JNI.SpatDecoderQueue_getFreeSpaceInQueue(this.swigCPtr, this, channelMap.swigValue());
    }

    public int getQueueSize(ChannelMap channelMap) {
        return Audio360JNI.SpatDecoderQueue_getQueueSize(this.swigCPtr, this, channelMap.swigValue());
    }

    public int enqueueSilence(int i, ChannelMap channelMap) {
        return Audio360JNI.SpatDecoderQueue_enqueueSilence(this.swigCPtr, this, i, channelMap.swigValue());
    }

    public void flushQueue() {
        Audio360JNI.SpatDecoderQueue_flushQueue(this.swigCPtr, this);
    }

    public BigInteger getNumSamplesDequeuedPerChannel() {
        return Audio360JNI.SpatDecoderQueue_getNumSamplesDequeuedPerChannel(this.swigCPtr, this);
    }

    public void setEndOfStream(boolean z) {
        Audio360JNI.SpatDecoderQueue_setEndOfStream(this.swigCPtr, this, z);
    }

    public boolean getEndOfStreamStatus() {
        return Audio360JNI.SpatDecoderQueue_getEndOfStreamStatus(this.swigCPtr, this);
    }

    public int enqueueDataInt16(ByteBuffer byteBuffer, int i, ChannelMap channelMap) {
        return Audio360JNI.SpatDecoderQueue_enqueueDataInt16(this.swigCPtr, this, byteBuffer, i, channelMap.swigValue());
    }

    public int enqueueDataFloat(ByteBuffer byteBuffer, int i, ChannelMap channelMap) {
        return Audio360JNI.SpatDecoderQueue_enqueueDataFloat(this.swigCPtr, this, byteBuffer, i, channelMap.swigValue());
    }

    private void setEventListenerInternal(EventListener eventListener) {
        Audio360JNI.SpatDecoderQueue_setEventListenerInternal(this.swigCPtr, this, EventListener.getCPtr(eventListener), eventListener);
    }
}
