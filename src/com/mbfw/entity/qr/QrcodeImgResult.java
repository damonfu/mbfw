package com.mbfw.entity.qr;

import java.util.List;

public class QrcodeImgResult {

    private boolean error;

    private List<QrcodeImg> qrcodeImgs;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<QrcodeImg> getQrcodeImgs() {
        return qrcodeImgs;
    }

    public void setQrcodeImgs(List<QrcodeImg> qrcodeImgs) {
        this.qrcodeImgs = qrcodeImgs;
    }
}
