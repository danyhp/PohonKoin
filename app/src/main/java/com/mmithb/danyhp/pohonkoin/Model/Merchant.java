package com.mmithb.danyhp.pohonkoin.Model;

public class Merchant {
    private String merchantNumber, bankLine, waNumber;
    private boolean onlineStatus;

    public Merchant(String merchantNumber, String bankLine, String waNumber) {
        this.merchantNumber = merchantNumber;
        this.bankLine = bankLine;
        this.waNumber = waNumber;
        this.onlineStatus = false;
    }

    public String getMerchantNumber() {
        return merchantNumber;
    }

    public void setMerchantNumber(String merchantNumber) {
        this.merchantNumber = merchantNumber;
    }

    public String getBankLine() {
        return bankLine;
    }

    public void setBankLine(String bankLine) {
        this.bankLine = bankLine;
    }

    public String getWaNumber() {
        return waNumber;
    }

    public void setWaNumber(String waNumber) {
        this.waNumber = waNumber;
    }

    public boolean isOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(boolean onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public String getStatus() {
        if (isOnlineStatus()) {
            return "ONLINE";
        } else {
            return "OFFLINE";
        }
    }
}
