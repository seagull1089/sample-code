package com.implementations;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by aragipindi on 4/9/15.
 */
public class IteratorOfIterators  {


    public static  class MyIterator<T> implements Iterator<T> {

        private Iterator<Iterator<T>> itt;
        private Iterator<T> current;
        public MyIterator(Iterator<Iterator<T>> itt){
            this.itt = itt;
        }
        @Override
        public boolean hasNext() {

            if((current == null || !current.hasNext()) && itt.hasNext()){
                current = itt.next();
                return hasNext();
            }
            return current.hasNext();

        }

        @Override
        public T next() {
            if(current.hasNext())
                return current.next();
            else
                return null;
        }
    }
    public static void main(String[] args){
        List<Iterator<Integer>> itList = new LinkedList<>();
        int[] array = {1,2,3,4,5};

        List<Integer> it1 = Arrays.asList(1,2,3,4,5);

        itList.add(it1.iterator());
        itList.add((new LinkedList<Integer>()).iterator());
        itList.add(null);
        itList.add(it1.iterator());
        itList.add(it1.iterator());
        itList.add(it1.iterator());

        MyIterator<Integer> it = new MyIterator(itList.iterator());
        while(it.hasNext()){
            System.out.print(it.next());
            System.out.print(",");
        }
        System.out.println();


    }
}
