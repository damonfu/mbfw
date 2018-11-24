package com.mbfw.entity.app;

public class AppVersionResult {

    private boolean success;
    private AppVersionBean appVersionBean;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public AppVersionBean getAppVersionBean() {
        return appVersionBean;
    }

    public void setAppVersionBean(AppVersionBean appVersionBean) {
        this.appVersionBean = appVersionBean;
    }
}
