package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.*;

public class LinkedTransferQueueTest01 {
    public static void main(String[] args) throws InterruptedException {
    //    ConcurrentLinkedQueue, SynchronousQueue, LinkedBlockingQueue
        TransferQueue<Object> tq = new LinkedTransferQueue<>();
        System.out.println(tq.add("Wadson"));
        System.out.println(tq.offer("Ferreira"));
        System.out.println(tq.offer("Rocha", 5,TimeUnit.SECONDS));
        tq.put("Genesys");
        if(tq.hasWaitingConsumer()){
            tq.transfer("Genesys");
        }
        System.out.println(tq.tryTransfer("Rute"));
        System.out.println(tq.tryTransfer("Rute", 5, TimeUnit.SECONDS));
        System.out.println(tq.element());
        System.out.println(tq.peek());
        System.out.println(tq.poll());
        System.out.println(tq.remove());
        System.out.println(tq.take());
        System.out.println(tq.remainingCapacity());

    }
}
