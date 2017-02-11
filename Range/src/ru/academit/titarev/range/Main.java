package ru.academit.titarev.range;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(0, 7);
        Range range2 = new Range(3, 8);
        double lengthOfInterval = range1.getLength();
        boolean inside = range1.isInside(-15);
        Range rangeIntersection = range1.getIntersection(range2);
        Range[] rangeUnion = range1.getUnion(range2);
        Range[] rangeDifference = range1.getDifference(range2);
        System.out.println(lengthOfInterval);
        System.out.println(inside);
        System.out.println("Интервал пересечения: " + rangeIntersection);
        System.out.println("Интервал объединения: " + Arrays.toString(rangeUnion));
        System.out.println("Интервал разности: " + Arrays.toString(rangeDifference));
    }
}
