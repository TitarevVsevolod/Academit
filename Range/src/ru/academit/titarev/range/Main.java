package ru.academit.titarev.range;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(0, 4);
        Range range2 = new Range(5, 6);
        double lengthOfInterval = range1.getLength();
        boolean inside = range1.isInside(-15);
        Range rangeCrossing = range1.getCrossing(range2);
        String rangeAssociation = range1.getAssociation(range2);
        System.out.println(lengthOfInterval);
        System.out.println(inside);
        System.out.println("Интервал пересечения: " + rangeCrossing);
        System.out.println("Интервал объединения: " + (rangeAssociation));
    }
}
