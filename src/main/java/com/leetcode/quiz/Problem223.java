package com.leetcode.quiz;

/**
 * 223. 矩形面积
 */
public class Problem223 {

    public static void main(String... args) {
        System.out.println(new Problem223().computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return (C - A) * (D - B) + (G - E) * (H - F)
                - computeIntersection(A, C, E, G) * computeIntersection(B, D, F, H);
    }

    public int computeIntersection(int al, int ar, int bl, int br) {
        if (bl < al) {
            if (br < al) {
                return 0;
            } else if (br < ar) {
                return br - al;
            } else {
                return ar - al;
            }
        } else if (bl < ar) {
            if (br < ar) {
                return br - bl;
            } else {
                return ar - bl;
            }
        } else {
            return 0;
        }
    }
}
