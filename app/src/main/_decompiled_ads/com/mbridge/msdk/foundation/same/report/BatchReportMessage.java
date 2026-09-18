package com.mbridge.msdk.foundation.same.report;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes4.dex */
public class BatchReportMessage implements Parcelable {
    public static final Parcelable.Creator<BatchReportMessage> CREATOR = new Parcelable.Creator<BatchReportMessage>() { // from class: com.mbridge.msdk.foundation.same.report.BatchReportMessage.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BatchReportMessage[] newArray(int i) {
            return new BatchReportMessage[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BatchReportMessage createFromParcel(Parcel parcel) {
            return new BatchReportMessage(parcel);
        }
    };
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2161b;
    private long c;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BatchReportMessage(String str, String str2, long j) {
        this.a = str;
        this.f2161b = str2;
        this.c = j;
    }

    protected BatchReportMessage(Parcel parcel) {
        this.a = parcel.readString();
        this.f2161b = parcel.readString();
        this.c = parcel.readLong();
    }

    public String getUuid() {
        return this.a;
    }

    public void setUuid(String str) {
        this.a = str;
    }

    public String getReportMessage() {
        return this.f2161b;
    }

    public void setReportMessage(String str) {
        this.f2161b = str;
    }

    public long getTimestamp() {
        return this.c;
    }

    public void setTimestamp(long j) {
        this.c = j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.f2161b);
        parcel.writeLong(this.c);
    }
}
