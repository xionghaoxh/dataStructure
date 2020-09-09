package queue;

import java.util.Scanner;

public class CrileArrayQueueDemo {

    public static void main(String[] args) {
        CircleArray queue =new CircleArray(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop =true;
        while(loop){
            System.out.println("s:显示队列");
            System.out.println("e:退出程序");
            System.out.println("a:添加数据到队列");
            System.out.println("g:从队列取出数据");
            System.out.println("h:查看队列头的数据");

            key=scanner.next().charAt(0);
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.print("输入一个数：");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        queue.getQueue();
                    } catch (Exception e) {
                        System.out.printf(e.getMessage());
                    }
                    break;
                case 'h':

                    try {
                        int v= queue.headQueue();
                        System.out.printf("从队头取出的元素为：%d",v);
                    } catch (Exception e) {
                        System.out.printf(e.getMessage());
                    }

                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
            }
            System.out.println();
        }
        System.out.println("程序退出~~");
    }
}


class CircleArray{
    private int maxSize; //表示数组的最大容量
    private int front;  //指向队头              默认为0
    private int rear;   //指向队尾的后一个位置    默认为0
    private int[] array; //存放数据

    // 创建队列的构造器
    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        array =new int[maxSize];
    }

    // 判断队列是否为满
    public boolean isFull(){
        return (rear+1)%maxSize == front;
    }

    // 判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    // 添加数据到队列 addQueue
    public void addQueue(int a){
        if(isFull()){
            System.out.println("队列已满，不能添加数据！！");
            return;
        }
        array[rear]=a;
        rear=(rear+1)%maxSize;
    }

    // 数据出队列 getQueue
    public void getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空,不能出队！！");
        }
        int a = array[front];
        front=(front+1)%maxSize;
        System.out.printf("出队数据为%d",a);
    }

    // 显示队列的所有数据 showQueue
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空！！！");
            return;
        }
        //从front遍历，遍历多少个元素
        System.out.println("队列为:");
        for(int i=front;i<front+size();i++){
            System.out.printf("%d\t",array[i%maxSize]);
        }
        System.out.println();
    }

    //队列的长度
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }


    // 显示队列头的数据，注意不是取出数据 headQueue
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！！！");
        }
        return array[front];
    }
}
