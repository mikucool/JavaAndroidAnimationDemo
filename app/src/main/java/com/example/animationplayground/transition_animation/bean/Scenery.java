package com.example.animationplayground.transition_animation.bean;

public class Scenery {
    private int sceneryId;
    private String sceneryName;
    private String imageUrl;
    private String thumbUrl;
    private String description;

    @Override
    public String toString() {
        return "Scenery{" +
                "sceneryId=" + sceneryId +
                ", sceneryName='" + sceneryName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", thumbUrl='" + thumbUrl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Scenery(int sceneryId, String sceneryName, String imageUrl, String thumbUrl, String description) {
        this.sceneryId = sceneryId;
        this.sceneryName = sceneryName;
        this.imageUrl = imageUrl;
        this.thumbUrl = thumbUrl;
        this.description = description;
    }

    public int getSceneryId() {
        return sceneryId;
    }

    public void setSceneryId(int sceneryId) {
        this.sceneryId = sceneryId;
    }

    public String getSceneryName() {
        return sceneryName;
    }

    public void setSceneryName(String sceneryName) {
        this.sceneryName = sceneryName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return sceneryId;
    }
}
