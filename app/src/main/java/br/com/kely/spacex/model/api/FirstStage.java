package br.com.kely.spacex.model.api;

import java.util.ArrayList;
import java.util.List;

public class FirstStage {

    private List<Core> cores = new ArrayList<>();

    public FirstStage() {
    }

    public List<Core> getCores() {
        return cores;
    }

    public void setCores(List<Core> cores) {
        this.cores = cores;
    }
}
