package com.company.second;


import java.util.Arrays;

public class B {
    // В качестве условной бесконечности
    // выберем достаточно большое число 10^9
    private static final int INF = 1000 * 1000 * 1000;
    static char[] graphLetter = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'S'};

    public static void main(String[] args) {
        B solution = new B();
        solution.solve();
    }

    private void solve() {

        // число вершин и дуг графа
        int vertexCount = 10;
        int edgeCount = 16;

        // Дуги графа будем хранить массиве
        // экземпляров класса Edge
        Edge[] edges = {
                new Edge(0, 1, 4),
                new Edge(0, 2, -2),
                new Edge(1, 6, -2),
                new Edge(1, 7, -4),
                new Edge(2, 3, 2),
                new Edge(2, 5, 1),
                new Edge(4, 5, -2),
                new Edge(4, 7, 3),
                new Edge(5, 3, 3),
                new Edge(6, 8, -1),
                new Edge(7, 6, 1),
                new Edge(8, 7, 1),
                new Edge(9, 0, 7),
                new Edge(9, 2, 6),
                new Edge(9, 4, 6),
                new Edge(9, 5, 5)
        };

        // Создаем массив, i-ый элемент которого
        // будет хранить текущее расстояние от 1-ой
        // (или 0-ой в нашем случае 0-индексации)
        // до i-ой вершины графа
        int[] distance = new int[vertexCount];

        // До начала работы алгоритма все расстояния,
        // кроме 0-го, равны бесконечности (условной)
        Arrays.fill(distance, INF);

        // 0-ое расстояние, очевидно равно нулю,
        // так как расстояние от 0-ой вершины
        // до самой себя равно нулю
        distance[0] = 0;

        // В соответствии с алгоритмом будем
        // обновлять массив расстояний
        for (int i = 0; i < vertexCount - 1; i++) {
            for (int j = 0; j < edgeCount; j++) {
                int from = edges[j].from;
                int to = edges[j].to;
                int weight = edges[j].weight;

                // Ясно, что если вершина from на
                // текущем шаге работы алгоритма
                // находится бесконечно далеко от
                // 0-ой, то она не изменит ответ
                if (distance[from] == INF) {
                    continue;
                }

                // В противном случае обновим
                // расстояние до вершины to,
                // это называют релаксацией
                distance[to] = Math.min(distance[to],
                        distance[from] + weight);
            }
        }

        // Выводим расстояние от 0-ой вершины
        // до каждой отличной от нее
        for (int i = 1; i < vertexCount; i++) {
            if (distance[i] == INF) {
                System.out.println(graphLetter[0] + " -> " + graphLetter[i] + " = " + "маршрут недоступен");
            } else {
                System.out.println(graphLetter[0] + " -> " + graphLetter[i] + " = " + distance[i]);
            }
        }
    }

    // Для удобства хранения дуг графа создадим
    // класс, содержащий информацию о весе дуги,
    // начальной и конечной вершинах дуги
    public class Edge {
        int from;
        int to;
        int weight;

        public Edge(int u, int v, int w) {
            this.from = u;
            this.to = v;
            this.weight = w;
        }
    }
}