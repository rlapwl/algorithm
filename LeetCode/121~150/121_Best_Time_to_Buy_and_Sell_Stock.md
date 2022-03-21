## 121. Best Time to Buy and Sell Stock
> You are given an array prices where prices[i] is the price of a given stock on the ith day. You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. [link](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
```
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
```

#### Solution 1
```java
class Solution {
    public int maxProfit(int[] prices) {
        Queue<Integer> queue = new LinkedList<>();
		queue.add(prices[0]);
        
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            while (!queue.isEmpty() && queue.peek() > prices[i]) {
                queue.poll();
            }

            if (!queue.isEmpty()) {
                maxProfit = Math.max(maxProfit, prices[i] - queue.peek());
            } else {
                queue.add(prices[i]);
            }
        }
        return maxProfit;
    }
}
```

#### Solution 2
```java
class Solution {
    public int maxProfit(int[] prices) {
        int minBuy = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            minBuy = Math.min(minBuy, prices[i]);
            profit = Math.max(profit, prices[i] - minBuy);
        }
        return profit;
    }
}
```