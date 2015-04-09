package com.implementations;


import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by aragipindi on 3/10/15.
 */
public final class Slicer<T extends Object> {
    private final T[] lst;
    private final int window,step;
    private int currentIndex = 0;
    private boolean hasMore = Boolean.TRUE;
    public Slicer(T[] lst,int window,int step){
        this.lst = lst;
        this.window = window;
        this.step = step;
    }

    public T[] next(){
        // currentIndex + window - currentIndex

        if(hasNext()){
            int numElements = Math.min(window,lst.length - currentIndex);
            ArrayList<T> returnElements  = new ArrayList<T>(numElements);
            for(int i = currentIndex; i < currentIndex + window && i < lst.length; i++ ){
                returnElements.add(lst[i]);
                if(i == lst.length-1){
                    hasMore = Boolean.FALSE;
                }
            }
            currentIndex += step;
            return returnElements.toArray((T[]) Array.newInstance(returnElements.get(0).getClass(),0));
        }else{
            throw new NoSuchElementException("no elements to iterate ");
        }

    }

    public boolean hasNext(){
        return currentIndex < lst.length && hasMore;
    }


    public static void main(String[] args) {
        ArrayList<Integer> lst = new ArrayList<Integer>();
        for(int i = 0; i < 100; i ++){
            lst.add(i);
        }
        Slicer slicer = new Slicer(lst.toArray(new Integer[lst.size()]),4,5);
        while(slicer.hasNext()){
            Integer[] elems = (Integer[])slicer.next();
            StringJoiner sj = new StringJoiner(",");
            for(Integer elem: elems){
                sj.add(elem.toString());
            }
            System.out.println(sj.toString());
        }
    }


    public <T> String join(List<T> someList,String sep){
        Iterator<T> it = someList.iterator();
        StringBuilder b = new StringBuilder();
        boolean hasFirst = Boolean.FALSE;
        while (it.hasNext()){
            if(hasFirst){
                b.append(sep);
            }
            b.append(it.next());
            hasFirst  = Boolean.TRUE;
        }
        return b.toString();
    }
}
