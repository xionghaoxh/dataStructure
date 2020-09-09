package queue;

public class TestArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueueDemo aqd =  new ArrayQueueDemo(3);
        aqd.addQueue(5);
        aqd.addQueue(4);
        aqd.addQueue(10);
        aqd.show();
        System.out.println(aqd.isFull());
        aqd.getQueue();
        System.out.println();
        aqd.headQueue();
        System.out.println("============");
        System.out.println(aqd.headQueue());
    }
}
