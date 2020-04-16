package com.kxw.leetcode;

/**
 * 环形路上有n个加油站，第i个加油站的汽油量是gas[i].
 * 你有一辆车，车的油箱可以无限装汽油。从加油站i走到下一个加油站（i+1）花费的油量是cost[i]，你从一个加油站出发，刚开始的时候油箱里面没有汽油。
 * 求从哪个加油站出发可以在环形路上走一圈。返回加油站的下标，如果没有答案的话返回-1。
 * 注意：
 * 答案保证唯一。
 *
 * @author kangxiongwei
 * @date 2020-04-14 20:31
 */
public class GreedyGasSolution {

    public static void main(String[] args) {
        GreedyGasSolution solution = new GreedyGasSolution();
        int[] gas = new int[]{1, 2};
        int[] cost = new int[]{2, 1};
        int circuit = solution.canCompleteCircuit(gas, cost);
        System.out.println(circuit);
    }


    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int res = tryComplete(i, gas, cost);
            if (res >= 0) {
                return res;
            }
        }
        return -1;
    }

    /**
     * 从第i个节点出发，尝试是否可以走一圈
     *
     * @param i
     * @param gas
     * @param cost
     * @return
     */
    public int tryComplete(int i, int[] gas, int[] cost) {
        int res = i;
        int allGas = 0;
        int gg = 0;
        int slow = i;
        int count = 0;
        while (count < gas.length) {
            //总共的汽油量
            allGas = gg + gas[slow % gas.length];
            //剩余的汽油量
            gg = allGas - cost[slow % cost.length];
            if (gg < 0) {
                res = -1;
                break;
            }
            slow++;
            count++;
        }
        return res;
    }


}
