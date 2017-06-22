import consumer.Consumer;
import produce.Producer;
import product.Storage;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jinkai on 2017/3/19.
 */
public class App {

    public static void main(String[] args) {

        Storage storage = new Storage(10);

        Runnable p1 = new Producer(storage);
        Runnable p2 = new Producer(storage);
        Runnable p3 = new Producer(storage);
        Runnable p4 = new Producer(storage);

        Runnable c1 = new Consumer(storage);
        Runnable c2 = new Consumer(storage);
        Runnable c3 = new Consumer(storage);

        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(p1);
        service.execute(p2);
        service.execute(p3);
        service.execute(p4);

        service.execute(c1);
        service.execute(c2);
        service.execute(c3);

    }
}
