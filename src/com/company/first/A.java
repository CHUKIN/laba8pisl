package com.company.first;



public class A {

    static int vNum = 9; // количество вершин
    static boolean[] used = new boolean [vNum]; // массив пометок
    static int[][] graph = { // матрица смежности
            {1,1,0,0,1,0,0,0,0},
            {1,1,1,0,1,0,0,0,0},
            {0,1,1,0,0,1,0,0,0},
            {0,0,0,1,0,0,1,1,0},
            {1,1,0,0,1,1,0,0,0},
            {0,0,1,0,1,1,0,0,1},
            {0,0,0,1,0,0,1,1,0},
            {0,0,0,1,0,0,1,1,0},
            {0,0,0,0,0,1,0,0,1},
    };

    static char [] graphLetter = {'A','B','C','D','E','F','G','H','I'};

    static void justDFS(int v) {
        used[v] = true; // помечаем вершину
        //System.out.print(graphLetter[v] + " ");
        for (int nv = 0; nv < vNum; nv++) // перебираем вершины
            if (!used[nv] && graph[v][nv] == 1) { // если вершина не помечена, и смежна с текущей
                System.out.print("(" + graphLetter[v] + ", " + graphLetter[nv] + ") ");
                justDFS(nv); // рекурсивно запускаем от нее DFS
            }
    }

    public static void main(String args[]){
        for (int i = 0; i < vNum; i++){
            System.out.print(graphLetter[i] + ": ");
            justDFS(i);
            System.out.println();
            for (int j = 0; j < vNum; j++){
                used[j] = false;
            }
        }

    }

}
