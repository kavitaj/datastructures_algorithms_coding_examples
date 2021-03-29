package com.basics.algorithms.greedy;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {

    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0.0;
        int n = values.length;

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(values[i], weights[i]);
        }

        Arrays.sort(items, new Comparator<Item>() { // custom compaator for decreasing order
            public int compare(Item o1, Item o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < n; i++) {
            if (capacity <= 0)
                return value;
            int taken = Math.min(capacity, items[i].weight);
            value += (taken * (items[i].value * 1.0) / items[i].weight);
            capacity -= taken;
        }

        return (double)Math.round(value * 10000d) / 10000d;
    }

    static class Item implements Comparable<Item> {
        int weight;
        int value;
        double val_per_unit;

        public Double getValPerUnit() {
            return this.val_per_unit;
        }

        public Item(int val, int wgt) {
            this.weight = wgt;
            this.value = val;
            //val_per_unit = Math.round(((double) val) / ((double) wgt) * 10000.0) / 10000.0;
            val_per_unit = (val * 1.0) / wgt;
        }

        public int compareTo(Item o) {
            return this.getValPerUnit().compareTo(o.val_per_unit);
        }
    }

        public static void main(String args[]) {
       /*     Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int capacity = scanner.nextInt();
            int[] values = new int[n];
            int[] weights = new int[n];
            for (int i = 0; i < n; i++) {
                values[i] = scanner.nextInt();
                weights[i] = scanner.nextInt();
            }
            System.out.println(getOptimalValue(capacity, values, weights));*/
            DecimalFormat decimal = new DecimalFormat("#.##"); // this class rounds off the double upto 2 decimal places
            int[] weights = {2, 1, 6, 5, 3, 7};
            int[] values = {50, 70, 100, 50, 30, 99};
            int capacity = 10;
            double maxValue = getOptimalValue(capacity, values, weights);
            System.out.println("Maximum value we can obtain = " + decimal.format(maxValue));
        }
}

