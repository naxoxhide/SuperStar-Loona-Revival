package com.facebook.gamingservices.model;

import android.os.Parcel;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;

/* JADX INFO: loaded from: classes2.dex */
public class ContextCreateContent implements ShareModel {
    private final String suggestedPlayerID;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private ContextCreateContent(final Builder builder) {
        this.suggestedPlayerID = builder.suggestedPlayerID;
    }

    ContextCreateContent(final Parcel parcel) {
        this.suggestedPlayerID = parcel.readString();
    }

    public String getSuggestedPlayerID() {
        return this.suggestedPlayerID;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(final Parcel out, final int flags) {
        out.writeString(this.suggestedPlayerID);
    }

    public static class Builder implements ShareModelBuilder<ContextCreateContent, Builder> {
        private String suggestedPlayerID;

        public Builder setSuggestedPlayerID(final String suggestedPlayerID) {
            this.suggestedPlayerID = suggestedPlayerID;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ContextCreateContent build() {
            return new ContextCreateContent(this);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(final ContextCreateContent content) {
            return content == null ? this : setSuggestedPlayerID(content.getSuggestedPlayerID());
        }

        Builder readFrom(final Parcel parcel) {
            return readFrom((ContextCreateContent) parcel.readParcelable(ContextCreateContent.class.getClassLoader()));
        }
    }
}
