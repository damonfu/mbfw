package com.mbfw.entity.qr;

import java.util.List;

public class GirlResult {

    private boolean error;

    private List<Girl> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<Girl> getResults() {
        return results;
    }

    public void setResults(List<Girl> results) {
        this.results = results;
    }
}
