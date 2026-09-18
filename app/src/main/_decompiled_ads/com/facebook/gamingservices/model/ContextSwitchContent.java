package com.facebook.gamingservices.model;

import android.os.Parcel;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;

/* JADX INFO: loaded from: classes2.dex */
public final class ContextSwitchContent implements ShareModel {
    private final String contextID;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private ContextSwitchContent(final Builder builder) {
        this.contextID = builder.contextID;
    }

    ContextSwitchContent(final Parcel parcel) {
        this.contextID = parcel.readString();
    }

    public String getContextID() {
        return this.contextID;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(final Parcel out, final int flags) {
        out.writeString(this.contextID);
    }

    public static class Builder implements ShareModelBuilder<ContextSwitchContent, Builder> {
        private String contextID;

        public Builder setContextID(final String contextID) {
            this.contextID = contextID;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ContextSwitchContent build() {
            return new ContextSwitchContent(this);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(final ContextSwitchContent content) {
            return content == null ? this : setContextID(content.getContextID());
        }

        Builder readFrom(final Parcel parcel) {
            return readFrom((ContextSwitchContent) parcel.readParcelable(ContextSwitchContent.class.getClassLoader()));
        }
    }
}
