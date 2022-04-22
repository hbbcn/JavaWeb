package com.atguigu.graph;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *@ClassName Graph
 *@Description  TODO
 *@Author hqb
 *@Date 2022/4/19 22:21
 *@Version 1.0
 */
public class Graph{
    private ArrayList<String> vertexList; //存储顶点集合
    private int[][] edges; //存储图对应的邻结矩阵
    private int numOfEdges; //表示边的数目
    //定义数组boolean[],记录某个结点是否被访问
    private boolean[] isVisited;


    public static void main(String[] args) {

        //测试一把图是否创建ok
        int n = 5; //结点个数
        String Vertexs[] = {"A","B","C","D","E"};
        //创建图对象
        Graph graph = new Graph(n);
        //循环的添加顶点
        for (String value : Vertexs){
            graph.insertVertex(value);
        }
        graph.showGraph();

        //添加边
        //A-B A-C B-C B-D B-E
        graph.insertEdge(0,1,1);//A-B
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        System.out.println();
        graph.showGraph();
        int firstNeighbor = graph.getFirstNeighbor(0);
//        System.out.println(firstNeighbor);

        graph.dfs();

    }

    //构造器
    public Graph(int n){
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        isVisited = new boolean[5];
    }

    //得到第一个邻接结点的下标w
    public int getFirstNeighbor(int index){
        for (int j = 0; j < vertexList.size(); j++){
            if (edges[index][j] > 0){
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1, int v2){
        for (int j = v2 + 1; j < vertexList.size(); j++){
            if (edges[v1][j] > 0){
                return j;
            }
        }
        return -1;
    }

    //深度优先遍历算法
    //i 第一次就是0
    public void dfs(boolean[] isVisited, int i){
        //首先我们访问该结点
        System.out.print(getValueByIndex(i) + "->");
        //将结点设置位已访问
        isVisited[i] = true;
        //查找结点i的第一个邻接结点w
        int w = getFirstNeighbor(i);
        while (w != -1){//说明有
            if (!isVisited[w]){
                dfs(isVisited, w);
            }
            w = getNextNeighbor(i,w);
        }
    }

    //对dfs 进行一个重载，遍历我们所有的结点，并进行dfs
    public void dfs(){
        //遍历所有的结点，进行dfs[回溯]
        for(int i = 0; i < getNumOfVertex(); i++){
            if (!isVisited[i]){
                dfs(isVisited, i);
            }
        }
    }


    //图中常用的方法
    //返回结点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }
    //返回图对应的矩阵
    public void showGraph(){
       for (int[] link : edges){
           System.err.println(Arrays.toString(link));
       }
    }
    //得到边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }
    //返回结点i(下标)对应的数据0—>"A" 1—>"B" 2—"C"
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    //返回v1和v2的权值
    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }


    //插入结点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    //添加边
    /**
     *
     * @param v1 表示点的下标
     * @param v2 表示第二个顶点的下标
     * @param weight 设置0表示不关联，1表示关联
     */
    public void insertEdge(int v1, int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }



}

