package com.mmithb.danyhp.pohonkoin.Model;

public class Tree {
    private String treeCode;
    private int remainingHours;
    private int collectedKoin;
    private String status;

    public Tree(String treeCode, int remainingHours, int collectedKoin, String status) {
        this.treeCode = treeCode;
        this.remainingHours = remainingHours;
        this.collectedKoin = collectedKoin;
        this.status = status;
    }

    public String getTreeCode() {
        return treeCode;
    }

    public void setTreeCode(String treeCode) {
        this.treeCode = treeCode;
    }

    public int getRemainingHours() {
        return remainingHours;
    }

    public void setRemainingHours(int remainingHours) {
        this.remainingHours = remainingHours;
    }

    public int getCollectedKoin() {
        return collectedKoin;
    }

    public void setCollectedKoin(int collectedKoin) {
        this.collectedKoin = collectedKoin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
