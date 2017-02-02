package ru.academit.titarev.range;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(5, 18.7);
        double lengthOfInterval = range.getLength();
        boolean inside = range.isInside(-15);
        System.out.println(lengthOfInterval);
        System.out.println(inside);
    }
}
