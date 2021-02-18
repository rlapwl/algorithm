import java.util.*;

class GenomicRangeQuery {
    // O(N + M)
    public int[] solution(String S, int[] P, int[] Q) {
        int m = P.length;
        int[] result = new int[m];
        
        Map<Character, Integer> matches = new HashMap<>();
        matches.put('A', 1);
        matches.put('C', 2);
        matches.put('G', 3);
        matches.put('T', 4);

        int[] a = new int[S.length() + 1];
        int[] c = new int[S.length() + 1];
        int[] g = new int[S.length() + 1];
        int[] t = new int[S.length() + 1];
        for (int idx = 0; idx < S.length(); idx++) {
            char type = S.charAt(idx);
            if (type == 'A') {
                a[idx + 1] = 1;
            } else if (type == 'C') {
                c[idx + 1] = 1;
            } else if (type == 'G') {
                g[idx + 1] = 1;
            }  else if (type == 'T') {
                t[idx + 1] = 1;
            }
            a[idx + 1] += a[idx];
            c[idx + 1] += c[idx];
            g[idx + 1] += g[idx];
            t[idx + 1] += t[idx];
        }
        
        for (int i = 0; i < m; i++) {
            int preIdx = P[i];
            int lastIdx = Q[i];

            if (preIdx == lastIdx) {
                char type = S.charAt(preIdx);
                result[i] = matches.get(type);
                continue;
            }
            if (a[preIdx] != a[lastIdx + 1]) {
                result[i] = matches.get('A');
            } else if (c[preIdx] != c[lastIdx + 1]) {
                result[i] = matches.get('C');
            } else if (g[preIdx] != g[lastIdx + 1]) {
                result[i] = matches.get('G');
            } else if (t[preIdx] != t[lastIdx + 1]) {
                result[i] = matches.get('T');
            }
        }
        return result;
    }
}