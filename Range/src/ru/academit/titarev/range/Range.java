package ru.academit.titarev.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double x) {
        return (x >= from) && (x <= to);
    }

    public String toString() {
        return "(" + this.from + ";" + this.to + ")";
    }

    public Range getCrossing(Range range) {
        if (this.from < range.from && this.to < range.from) {
            return null;
        } else if (range.from < this.from && range.to < this.from) {
            return null;
        } else if (this.from < range.from && this.to < range.to) {
            range.to = this.to;
            return range;
        } else if (this.from < range.from && range.to < this.to) {
            range.from = this.from;
            range.to = this.to;
            return range;
        } else if (range.from < this.from && range.to < this.to) {
            range.from = this.from;
            return range;
        } else {
            return range;
        }
    }

    public Range[] getAssociation(Range range) {
        Range[] arr = new Range[2];
        if (this.from < range.from && this.to < range.from) {

            arr[0] = range;
            arr[1] = this;
            return arr;
        } /*else if (range.from < this.from && range.to < this.from) {
            return null;
        } else if (this.from < range.from && this.to < range.to) {
            range.from = this.from;
            return range;
        } else if (this.from < range.from && range.to < this.to) {
            range.from = this.from;
            range.to = this.to;
            return range;
        } else if (range.from < this.from && range.to < this.to) {
            range.to = this.to;
            return range;
        } */else {
            return null;
        }
    }
}
