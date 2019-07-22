package me.mortuza.edetailingclone;

public class ModelStatus {
    String pName;
    String ago;
    String pImageURL;
    String status;

    public ModelStatus(String pName, String ago, String pImageURL, String status) {
        this.pName = pName;
        this.ago = ago;
        this.pImageURL = pImageURL;
        this.status = status;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getAgo() {
        return ago;
    }

    public void setAgo(String ago) {
        this.ago = ago;
    }

    public String getpImageURL() {
        return pImageURL;
    }

    public void setpImageURL(String pImageURL) {
        this.pImageURL = pImageURL;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
