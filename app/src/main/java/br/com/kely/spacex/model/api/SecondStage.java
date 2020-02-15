package br.com.kely.spacex.model.api;

import java.util.ArrayList;
import java.util.List;

public class SecondStage {

    private String block;

    private List<Payload> payloads = new ArrayList<>();

    public SecondStage() {
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public List<Payload> getPayloads() {
        return payloads;
    }

    public void setPayloads(List<Payload> payloads) {
        this.payloads = payloads;
    }
}
