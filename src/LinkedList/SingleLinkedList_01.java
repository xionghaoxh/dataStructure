package LinkedList;

import java.util.List;

public class SingleLinkedList_01 {
    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode node5 = new HeroNode(4, "熊浩", "昊天");
        SingleLinkedList list = new SingleLinkedList();
//        list.add(node1);
//        list.add(node4);
//        list.add(node3);
//        list.add(node2);
        list.addOrder(node1);
        list.addOrder(node4);
        list.addOrder(node3);
        list.addOrder(node2);
        list.show();
        list.update(node5);//注意修改的时候不能改编号
        System.out.println("===================");
        list.show();
        System.out.println("===================");
        list.delete(node3);
        list.show();
    }
}
    //创建单链表类
      class SingleLinkedList{
        private HeroNode head = new HeroNode(0,"","");
        //单链表的增加（无序）

        /**
         * 在list末尾添加元素
         * @param heroNode
         */
        public void add(HeroNode heroNode) {
            HeroNode tmp=head;//因为头节点不能动，所以要用到我们辅助节点；
            while(true){
                if(tmp.next==null){
                    break;
                }
                tmp=tmp.next;
            }
            tmp.next=heroNode;
        }

        /**
         * list里面按照顺序添加（重要）第二种添加英雄的方式，根据排名将英雄插入到指定的位置
         * @param heroNode
         */
        public  void addOrder(HeroNode heroNode){
            HeroNode tmp =head;//因为头节点不能动，所以要用到我们辅助节点；
            boolean flag=false;//标志和添加的节点和链表中节点的编号没有重复
            while(true){
                if(tmp.next==null){
                    break;
                }
                if(tmp.next.no>heroNode.no){//找到比自己小的才能插入
                    break;
                }else if(tmp.next.no==heroNode.no){
                    flag=true;
                    break;
                }
                tmp=tmp.next;
            }
            if(flag){
                System.out.println("节点已经存在");//是根据节点编号去判断存在
            }else{
              heroNode.next=tmp.next;
              tmp.next=heroNode;
            }
        }

        /**
         * 删除指定节点
         * @param heroNode
         */
         public void delete(HeroNode heroNode){
             HeroNode tmp =head;//因为头节点不能动，所以要用到我们辅助节点；
             boolean flag=false; //标志有没有那个节点
             while(true){
                 if(tmp.next==null){
                     break;
                 }
                 if(tmp.next.no == heroNode.no){
                     flag=true;
                     break;
                 }
                 tmp=tmp.next;
             }
             if(flag){
                 tmp.next=tmp.next.next;
             }else {
                 System.out.println("没有这个节点去删除");
             }
         }
        /**
         * 修改某个节点的信息，但是不能改编号
         * @param heroNode
         */
        public void update(HeroNode heroNode){
            HeroNode tmp =head;//因为头节点不能动，所以要用到我们辅助节点；
            boolean flag=false; //标志有没有那个节点
            while(true){//退出循环的时候就代表找到相应的节点了tmp.next
                if (tmp.next==null) {
                    break;
                }
                if(tmp.next.no==heroNode.no){//找到这个节点
                    flag=true;
                    break;
                }
                tmp=tmp.next;
            }
            if (flag) {
                tmp.next.name=heroNode.name;
                tmp.next.nickName=heroNode.nickName;
            }else{
                System.out.println("没有找到这个节点");
            }
        }
        /**
         * 显示出来我们的list
         */
        public void show(){
            if(head.next==null){
                System.out.println("链表为空");
            }
            HeroNode tmp = head;
            while(true){
            if(tmp.next==null){
                break;
            }
            tmp=tmp.next;
            System.out.println(tmp);
        }
    }

    }


    //创建heroNoed （英雄）类；
    class HeroNode {
        public int no;//编号
        public String name;//姓名
        public String nickName;//昵称
        public HeroNode next;//下一个节点

        //构造器
        public HeroNode(int no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\''+'}' ;
        }
    }

