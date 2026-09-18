package com.facebook.gamingservices.model;

import android.os.Parcel;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ContextChooseContent implements ShareModel {
    private final List<String> filters;
    private final Integer maxSize;
    private final Integer minSize;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private ContextChooseContent(final Builder builder) {
        this.filters = builder.filters;
        this.maxSize = builder.maxSize;
        this.minSize = builder.minSize;
    }

    ContextChooseContent(final Parcel parcel) {
        this.filters = parcel.createStringArrayList();
        this.maxSize = Integer.valueOf(parcel.readInt());
        this.minSize = Integer.valueOf(parcel.readInt());
    }

    public List<String> getFilters() {
        List<String> list = this.filters;
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        return null;
    }

    public Integer getMaxSize() {
        return this.maxSize;
    }

    public Integer getMinSize() {
        return this.minSize;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(final Parcel out, final int flags) {
        out.writeStringList(this.filters);
        out.writeInt(this.maxSize.intValue());
        out.writeInt(this.minSize.intValue());
    }

    public static class Builder implements ShareModelBuilder<ContextChooseContent, Builder> {
        private List<String> filters;
        private Integer maxSize;
        private Integer minSize;

        public Builder setFilters(final List<String> filters) {
            this.filters = filters;
            return this;
        }

        public Builder setMaxSize(final Integer maxSize) {
            this.maxSize = maxSize;
            return this;
        }

        public Builder setMinSize(final Integer minSize) {
            this.minSize = minSize;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ContextChooseContent build() {
            return new ContextChooseContent(this);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(final ContextChooseContent content) {
            return content == null ? this : setFilters(content.getFilters()).setMaxSize(content.getMaxSize()).setMinSize(content.getMinSize());
        }

        Builder readFrom(final Parcel parcel) {
            return readFrom((ContextChooseContent) parcel.readParcelable(ContextChooseContent.class.getClassLoader()));
        }
    }
}
