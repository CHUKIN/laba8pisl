package com.company.second;

import static java.lang.Math.min;
import static java.util.Arrays.fill;


public class A {
    static int INF = Integer.MAX_VALUE / 2; // "Бесконечность"
    static char [] graphLetter = {'A','B','C','D','E','F','G','H'};
    static int n = 8; // количество вершин
    static int[][] weight = {
            {INF,1,INF,INF,4,8,INF ,INF},
            {INF,INF,2,INF,INF,6,6,INF},
            {INF,INF,INF,1,INF,INF,2,INF },
            {INF,INF,INF,INF,INF,INF ,1,4},
            {INF,INF,INF,INF,INF,5,INF,INF},
            {INF,INF,INF,INF,INF,INF,INF,INF},
            {INF,INF,INF,INF,INF,1,INF,1},
            {INF,INF,INF,INF,INF,INF,INF, INF},
    };

    //Алгоритм Дейкстры
    static void Dijkstra(int st) {

        boolean visited[] = new boolean[n];
        int D[] = new int[n];
        for(int i=0;i<n;i++)
        {
            D[i]= weight[st][i];
            visited[i]=false;
        }

        D[st] = 0;

        System.out.print(graphLetter[st]);

        int index = 0, u = 0;
        for (int i = 0; i < n; i++) {
            int min = INF;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && D[j] < min) {
                    min = D[j];
                    index = j;
                }
            }
            u = index;
            visited[u] = true;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && weight[u][j]!=INF && D[u] != INF && (D[u] + weight[u][j] < D[j])){
                    D[j] = D[u] + weight[u][j];
                }
            }
        }
        System.out.println();
        System.out.println("\nСтоимость пути из начальной вершины до остальных(Алгоритм Дейкстры):");
        for (int i = 0; i < n; i++) {
            if (D[i] != INF)
                System.out.println(graphLetter[st] + " -> " + graphLetter[i] + " = " + D[i]);
            else
                System.out.println(graphLetter[st] + " -> " + graphLetter[i] + " = " + "маршрут недоступен");
        }
    }

    public static void main(String args[]) {
        Dijkstra(0);
    }
}
