package com.iweb.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Min
 * @date 2023/11/21 10:21
 */
public class Test3 {
    public void run(int n, int[] arr, int k, int d) {
        int max = 0;
        if (n < d) {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (arr[i] * arr[j] > max) {
                        max = arr[i] * arr[j];
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < i + d; j++) {
                if (i + d == n) {
                    break;
                }
                if (arr[i] * arr[j] > max) {
                    max = arr[i] * arr[j];
                }
            }
            for (int l = i+1; l < n; l++) {
                if (arr[i] * arr[l] > max) {
                    max = arr[i] * arr[l];
                }
            }
        }
    }

    public static void main(String[] args) {
    }
}
