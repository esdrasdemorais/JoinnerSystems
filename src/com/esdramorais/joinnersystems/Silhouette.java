package com.esdrasmorais.joinnersystems;

import java.util.List;
import java.util.ArrayList;

public class Silhouette {
    private Integer width;
    private Integer height;
    private List<Integer> filledPositions;

    public Silhouette() {
        this.filledPositions = new ArrayList<>();
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getWidth() {
        return this.width;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getHeight() {
        return this.height;
    }

    public void setFilledPositions(List<Integer> filledPositions) {
        this.filledPositions = filledPositions;
    }

    public List<Integer> getFilledPositions() {
        return this.filledPositions;
    }
}


