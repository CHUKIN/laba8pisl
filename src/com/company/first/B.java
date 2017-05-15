package com.company.first;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class B {
    static int vNum = 8; // количество вершин
    static boolean [] used = new boolean [vNum]; // массив пометок
    static int[][] graph = { // матрица смежности
            {1,0,1,0,0,0,0,0},
            {0,1,1,0,0,0,0,0},
            {0,0,1,1,1,0,0,0},
            {0,0,0,1,0,1,0,0},
            {0,0,0,0,1,1,0,0},
            {0,0,0,0,0,1,1,1},
            {0,0,0,0,0,0,1,0},
            {0,0,0,0,0,0,0,1}
    };

    static char [] graphLetter = {'A','B','C','D','E','F','G','H'};

    static List<Integer> result = new ArrayList<>();

    static void justDFS(int v) {
        used[v] = true; // помечаем вершину
        //System.out.print(graphLetter[v] + " ");
        for (int nv = 0; nv < vNum; nv++) { // перебираем вершины
            if (!used[nv] && graph[v][nv] == 1) { // если вершина не помечена, и смежна с текущей
                //System.out.print("(" + graphLetter[v] + ", " + graphLetter[nv] + ") ");
                justDFS(nv); // рекурсивно запускаем от нее DFS
            }
        }
        result.add(v);
    }

    static void topological_sort() {
        for (int i=0; i<vNum; ++i)
            used[i] = false;
        result.clear();
        for (int i=0; i<vNum; ++i)
            if (!used[i])
                justDFS(i);
        Collections.reverse(result);
    }

    public static void main(String args[]) {
        topological_sort();
        for (int i : result) {
            System.out.print(graphLetter[i] + " ");
        }
    }

}

