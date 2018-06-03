package com.wangsen.cvs;

/**
 * @author wangsen
 * @data 2018/6/3 10:39
 * @des
 */
public class QaRecoder {

    private String projectId;
    private String categoryId;
    private String[] titles;
    private String comment;


    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String[] getTitles() {
        return titles;
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
