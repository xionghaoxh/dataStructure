package queue;

//使用数组去模拟队列
//这个队列问题就是 front 和real 都在往上走，而下面的空间已经浪费，所以数组自能用一次
public class ArrayQueueDemo {
    //队列存放的最大个数值
    private int  maxSize;
    //队列尾部
    private int rear;
    //队列的头部
    private int front;
    //存放数据
    private int []arr;
    //初始化
    public ArrayQueueDemo(int maxSize) {
        this.maxSize = maxSize;
        rear=-1;
        front=-1;
        arr=new int[maxSize];
    }

    //判断队列是否已经满了
    public boolean isFull(){
        return rear==maxSize-1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }
    //进队列
    public void addQueue(int n){
        //进队列要先看 队列是否已经满了
        if(isFull()){
            System.out.println("队列已经满了：无法进队");
        }
        rear++;
        arr[rear]=n;
    }
    //出队列
    public int getQueue(){
        //出队列先判断是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空,不能出队！！");
        }
        front++;
        int a = arr[front];
        System.out.printf("出队数据为%d",a);
        return a;
    }
    //显示队列
    public void show(){
        if(isEmpty()){
            System.out.println(("队列为空,不能出队！！"));
            return;
        }
        for(int i=0;i<arr.length;i++){
            System.out.printf("%d\t",arr[i]);
        }
        System.out.println();
    }
    // 显示队列头的数据，注意不是取出数据 headQueue
    public int headQueue(){
        if(isEmpty()){
            System.out.println(("队列为空！！！"));
        }
        return arr[front+1];
    }
}
