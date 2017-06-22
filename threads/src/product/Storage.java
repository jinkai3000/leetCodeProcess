package product;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jinkai on 2017/3/13.
 */
public class Storage {

    private int maxCount =  -1 ;

    private AtomicInteger theCount = new AtomicInteger();

    public AtomicInteger sequence = new AtomicInteger(1);

    private Product[] products ;

    public Storage(int maxCount) {
        this.maxCount = maxCount;

        products = new Product[maxCount];
    }

    public synchronized void push(Product p){

        try {
            while(theCount.get() == maxCount){
                System.err.println(Thread.currentThread().getName()+"-仓库满了 ，生产者等待");
                wait();
            }

            System.err.println(Thread.currentThread().getName() + "-添加了一个商品 :"+p.getId());

            products[theCount.getAndIncrement()] = p;

            notifyAll();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void pop(){

        try {
            while(theCount.get() == 0){
                System.out.println(Thread.currentThread().getName()+"-仓库空了，消费者等待");
                wait();
            }

            Product p = products[theCount.decrementAndGet()];

            System.out.println(Thread.currentThread().getName() + "消费一个商品 :"+ p.getId());

            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



}
