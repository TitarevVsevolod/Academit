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

    private boolean isNotIntersection(Range range) {
        return (this.to <= range.from || range.to <= this.from);
    }

    public Range getIntersection(Range range) {
        if (isNotIntersection(range)) {
            return null;
        }
        return new Range(Math.max(this.from, range.from), Math.min(this.to, range.to));
    }

    public Range[] getUnion(Range range) {
        if (isNotIntersection(range)) {
            return new Range[]{new Range(this.from, this.to), new Range(range.from, range.to)};
        }
        return new Range[]{new Range(Math.min(this.from, range.from), Math.max(this.to, range.to))};
    }

    public Range[] getDifference(Range range) {
        if (isNotIntersection(range)) {
            return new Range[]{new Range(this.from, this.to)};
        } else if (this.from <= range.from && this.to <= range.to) {
            return new Range[]{new Range(this.from, range.from)};
        } else if (this.from <= range.from && range.to <= this.to) {
            return new Range[]{new Range(this.from, range.from), new Range(range.to, this.to)};
        } else if (range.from <= this.from && range.to <= this.to) {
            return new Range[]{new Range(range.to, this.to)};
        } else {
            return new Range[0];
        }
    }
}
