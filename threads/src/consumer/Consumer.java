package consumer;

import product.Storage;

import java.io.Serializable;

/**
 * Created by jinkai on 2017/3/13.
 */
public class Consumer implements Runnable {

    private Storage storage = null;

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        while(true){

            try {
                Thread.sleep(1100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            storage.pop();

        }


    }
}
