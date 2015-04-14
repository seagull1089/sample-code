package com.implementations;

import java.util.Arrays;

/**
 * Created by aragipindi on 4/13/15.
 */
public class MaxBiPartite {
    int m, n;
    boolean[][] graph;
    boolean seen[];
    int matchL[];   //What left vertex i is matched to (or -1 if unmatched)
    int matchR[];   //What right vertex j is matched to (or -1 if unmatched)

    int maximumMatching() {
        //Read input and populate graph[][]
        //Set m to be the size of L, n to be the size of R
        Arrays.fill(matchL, -1);
        Arrays.fill(matchR, -1);

        int count = 0;
        for (int i = 0; i < m; i++) {
            Arrays.fill(seen, false);
            if (bpm(i)) count++;
        }
        return count;
    }

    boolean bpm(int u) {
        //try to match with all vertices on right side
        for (int v = 0; v < n; v++) {
            if (!graph[u][v] || seen[v]) continue;
            seen[v] = true;
            //match u and v, if v is unassigned, or if v's match on the left side can be reassigned to another right vertex
            if (matchR[v] == -1 || bpm(matchR[v])) {
                matchL[u] = v;
                matchR[v] = u;
                return true;
            }
        }
        return false;
    }
}
