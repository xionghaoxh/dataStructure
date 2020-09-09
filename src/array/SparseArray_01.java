package array;

public class SparseArray_01 {
    public static void main(String[] args) {
        //创建一个原始的二维数组 11x11
        //0: 表示没有棋子  1：表示黑子   2：表示白子
        int k = 11;
        int[][] sparseArray = getSparseArray(k, k);
        getNums(sparseArray);

    }

    /**
     * 创建一个x行,y列的数组，并转化为 稀疏数组；
     * 这里方便 ，便用了二重循环，也可以 用其他方法遍历
     *
     * @param x
     * @param y
     * @return
     */
    public static int[][] getSparseArray(int x, int y) {
        //创建数组
        int[][] nums = new int[x][y];
        nums[1][1] = 1;
        nums[2][2] = 2;
        //输出数组
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.printf("%d\t", nums[i][j]);//printf格式化输出
            }
            System.out.println("");
        }

        //找出数组里面的不为0的元素个数
        //sum 统计元素个数
        int sum = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (nums[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("原数组里面有：=========" + sum + "个元素");
        //确定个数就是确定了 行数
        //第一行存储我们的 行数，列数，个数值
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = x;
        sparseArray[0][1] = y;
        sparseArray[0][2] = sum;
        //给其他行赋值
        //其他行 就是存储我们 原数组的所在的位置（x,y）两个值，还有就是 本身的值。
        int count = 1;//从第一行开始记录
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (nums[i][j] != 0) {
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = nums[i][j];
                    count++;
                }

            }
        }
        //打印稀疏数组
        for (int i = 0; i < sparseArray.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%d\t", sparseArray[i][j]);//printf格式化输出
            }
            System.out.println("");
        }


        return sparseArray;
    }
   //给我一个稀疏数组，我帮你还原；
    public static int[][] getNums(int[][] q) {
        //获取行，去创建原来规模大小的数组
        int x=q[0][0];
        int y=q[0][1];
        int[][] chessArray= new int [x][y];
        for(int i=1;i<q.length;i++){
            chessArray[q[i][0]][q[i][1]]=q[i][2];
        }
        for(int i=0;i<x;i++){
            for (int j=0;j<y;j++){
                System.out.printf("%d\t",chessArray[i][j]);
            }
            System.out.println("");
        }

        return chessArray;
        //打印出来

    }

}
