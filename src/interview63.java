public class interview63 {
    /*面试题63、 股票的最大利润
    *csdn博客地址：https://blog.csdn.net/Lizejin961019/article/details/107126292
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
