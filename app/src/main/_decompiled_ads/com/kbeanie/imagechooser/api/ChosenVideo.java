package com.kbeanie.imagechooser.api;

/* JADX INFO: loaded from: classes2.dex */
public class ChosenVideo extends ChosenMedia {
    private String thumbnailPath;
    private String thumbnailSmallPath;
    String videoFilePath;
    String videoPreviewImage;

    public String getVideoFilePath() {
        return this.videoFilePath;
    }

    public void setVideoFilePath(String str) {
        this.videoFilePath = str;
    }

    public String getThumbnailPath() {
        return this.thumbnailPath;
    }

    public void setThumbnailPath(String str) {
        this.thumbnailPath = str;
    }

    public String getThumbnailSmallPath() {
        return this.thumbnailSmallPath;
    }

    public void setThumbnailSmallPath(String str) {
        this.thumbnailSmallPath = str;
    }

    public String getVideoPreviewImage() {
        return this.videoPreviewImage;
    }

    public void setVideoPreviewImage(String str) {
        this.videoPreviewImage = str;
    }

    @Override // com.kbeanie.imagechooser.api.ChosenMedia
    public String getMediaHeight() {
        return getHeight(this.videoPreviewImage);
    }

    @Override // com.kbeanie.imagechooser.api.ChosenMedia
    public String getMediaWidth() {
        return getWidth(this.videoPreviewImage);
    }

    public String getExtension() {
        return getFileExtension(this.videoFilePath);
    }
}
