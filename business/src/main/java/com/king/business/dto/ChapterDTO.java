package com.king.business.dto;

public class ChapterDTO {

    private String id;

    private String courseId;

    @Override
    public String toString() {
        return "ChapterDTO{" +
                "id='" + id + '\'' +
                ", courseId='" + courseId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
