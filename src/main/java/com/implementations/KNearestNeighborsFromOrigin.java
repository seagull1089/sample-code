package com.implementations;

import java.util.*;

/**
 * Created by aragipindi on 4/9/15.
 */
public class KNearestNeighborsFromOrigin {

    public static final class Point implements Comparable<Point> {
        private final int x,y;
        public Point(int x,int y){
            this.x = x; this.y = y;
        }
        public int getDistance(){
            return x*x + y*y;
        }

        @Override
        public int compareTo(Point o) {
            return  o.getDistance() - this.getDistance();
        }
        @Override
        public String toString(){
            return "x: " +x + ", y:" + y;
        }
    }
    public static List<Point> getKNNPoints(List<Point> allPoints,int top){
        PriorityQueue<Point> pq = new PriorityQueue<>(top);
        for(Point p : allPoints){
            if(pq.size() >= top){
                Point q = pq.peek();
                if(p.compareTo(q) > 0){
                    pq.remove();
                    pq.add(p);
                }
            }else{
                pq.add(p);
            }
        }
        //List<Point> returnList = new ArrayList<Point>(pq.size());
        Point[] returnList = new Point[pq.size()];
        int i = pq.size()-1;
        while(!pq.isEmpty()){
           returnList[i] = pq.remove();
            i--;
        }
        return Arrays.asList(returnList);

    }

    public static void main(String[] args){
        List<Point> allPoints = new ArrayList<Point>(){{
            for (int i = 10; i >=0 ; i--) {
                add(new Point(i,i));

            }
        }};
        for(Point p:getKNNPoints(allPoints,3)){
            System.out.println(p);
        }

    }
}
