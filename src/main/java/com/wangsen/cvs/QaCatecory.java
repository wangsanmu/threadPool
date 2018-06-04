package com.wangsen.cvs;

/**
 * @author wangsen
 * @data 2018/6/4 22:52
 * @des
 */
public class QaCatecory {
    private String parentId;
    private String projectId;
    private String treeName;
    private String treePath;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }

    public String getTreePath() {
        return treePath;
    }

    public void setTreePath(String treePath) {
        this.treePath = treePath;
    }
}
