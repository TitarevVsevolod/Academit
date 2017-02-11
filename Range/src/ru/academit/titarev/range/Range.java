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
    private boolean isNotIntersection(Range range){
        return (this.from < range.from && this.to < range.from) || (range.from < this.from && range.to < this.from);
    }

    public Range getIntersection(Range range) {
        if (isNotIntersection(range)) {
            return null;
        } else if (this.from <= range.from && this.to <= range.to) {
            return new Range(range.from, this.to);
        } else if (this.from <= range.from && range.to <= this.to) {
            return new Range(this.from, this.to);
        } else if (range.from <= this.from && range.to <= this.to) {
            return new Range(this.from, range.to);
        } else {
            return new Range(range.from, range.to);
        }
    }

    public Range[] getUnion(Range range) {
        Range[] arr ;
        if (this.from < range.from && this.to < range.from) {
            arr = new Range[2];
            arr[0] = new Range(this.from, this.to);
            arr[1] = new Range(range.from, range.to);
            return arr;
        } else if (range.from < this.from && range.to < this.from) {
            arr = new Range[2];
            arr[0] = new Range(range.from, range.to);
            arr[1] = new Range(this.from, this.to);
            return arr;
        } else if (this.from < range.from && this.to < range.to) {
            arr = new Range[1];
            arr[0] = new Range(this.from, range.to);
            return arr;
        } else if (this.from < range.from && range.to < this.to) {
            arr = new Range[1];
            arr[0] = new Range(this.from, this.to);
            return arr;
        } else if (range.from < this.from && range.to < this.to) {
            arr = new Range[1];
            arr[0] = new Range(range.from, this.to);
            return arr;
        } else {
            arr = new Range[1];
            arr[0] = new Range(range.from, range.to);
            return arr;
        }
    }

    public Range[] getDifference(Range range) {
        Range[] arr ;
        if ((this.from < range.from && this.to < range.from) || (range.from < this.from && range.to < this.from)) {
            arr = new Range[1];
            arr[0] = new Range(this.from, this.to);
            return arr;
        } else if (this.from < range.from && this.to < range.to) {
            arr = new Range[1];
            arr[0] = new Range(this.from, range.from);
            return arr;
        } else if (this.from < range.from && range.to < this.to) {
            arr = new Range[2];
            arr[0] = new Range(this.from, range.from);
            arr[1] = new Range(range.to, this.to);
            return arr;
        } else if (range.from < this.from && range.to < this.to) {
            arr = new Range[1];
            arr[0] = new Range(range.to, this.to);
            return arr;
        } else {
            arr = new Range[0];
            return arr;
        }
    }
}
