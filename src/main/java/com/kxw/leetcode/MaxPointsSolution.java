package com.kxw.leetcode;

/**
 * @author kangxiongwei
 * @date 2020-03-30 23:03
 */
public class MaxPointsSolution {

    public static class Point {
        int x;
        int y;

        Point() {

        }

        Point(int a, int b) {
            this.x = a;
            this.y = b;
        }
    }

    public static void main(String[] args) {
        MaxPointsSolution solution = new MaxPointsSolution();
        Point[] points = new Point[]{new Point(0, 0), new Point(1, 1), new Point(2, 2)};
        int maxPoints = solution.maxPoints(points);
        System.out.println(maxPoints);
    }


    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        if (points.length < 3) {
            return points.length;
        }
        int maxPoint = 2;
        for (int i = 0; i < points.length; i++) {
            int x1 = points[i].x;
            int y1 = points[i].y;
            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j].x;
                int y2 = points[j].y;
                int max = 2;
                //判断其他节点，是否和(x1,y1) & (x2, y2)构成的直线一致
                for (int k = 0; k < points.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    int x3 = points[k].x;
                    int y3 = points[k].y;
                    boolean flag;
                    if (x1 == x2) {
                        //横坐标相同
                        flag = x3 == x1;
                    } else if (y1 == y2) {
                        //纵坐标相同
                        flag = y3 == y1;
                    } else {
                        //斜率是否相同
                        flag = (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1);
                    }
                    if (flag) {
                        max++;
                    }
                }
                maxPoint = Math.max(maxPoint, max);
            }
        }
        return maxPoint;
    }


}
