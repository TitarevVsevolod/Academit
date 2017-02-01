package ru.academit.titarev.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double findLength() {
        return to - from;
    }

    public boolean isInside(double x) {
        if ((x >= from) && (x <= to)) {
            return true;
        }
        return false;
    }
}
