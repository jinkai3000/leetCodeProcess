package produce;

import product.Product;
import product.Storage;

/**
 * 生产者-消费者模型
 * 生产者
 *
 *
 * Created by jinkai on 2017/3/13.
 */
public class Producer implements Runnable{

    private Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {

        while(true){

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            storage.push(new Product(""+storage.sequence.getAndIncrement()));
        }


    }
}
