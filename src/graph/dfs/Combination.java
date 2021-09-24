package graph.dfs;

public class Combination {
    public static void main(String[] args){
        System.out.println(Math.pow(2, 8));
    }

    public int[][] getComb(){
        int[][] multiArr = new int[2][2];
        multiArr[0] = new int[]{1, 0};
        multiArr[1] = new int[]{0, 1};

        return multiArr;
    }
}
