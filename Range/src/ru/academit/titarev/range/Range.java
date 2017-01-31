package ru.academit.titarev.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double findLengthOfInterval() {
        return Math.abs(to - from);
    }

    public boolean isInside(double x) {
        if (from > to) {
            if (x >= to && x <= from) {
                return true;
            }
        } else {
            if (x >= from && x <= from) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Range range = new Range(-5, -18.7);
        double lengthOfInterval = range.findLengthOfInterval();
        boolean inside = range.isInside(-20);
        System.out.println(lengthOfInterval);
        System.out.println(inside);

    }
}
