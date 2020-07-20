public class leetcode121 {
    /*leetcode121. 买卖股票的最佳时机
    * */
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, res = 0;
        for(int price : prices) {
            cost = Math.min(cost, price);
            res = Math.max(res, price - cost);
        }
        return res;
    }
}
