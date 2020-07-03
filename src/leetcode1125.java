import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode1125 {

    /*详细题解在我的csdn：https://blog.csdn.net/Lizejin961019/article/details/107116318
    * 作为项目经理，你规划了一份需求的技能清单 req_skills，并打算从备选人员名单 people 中选出些人组成一个「必要团队」（ 编号为 i 的备选人员 people[i] 含有一份该备选人员掌握的技能列表）。

所谓「必要团队」，就是在这个团队中，对于所需求的技能列表 req_skills 中列出的每项技能，团队中至少有一名成员已经掌握。

我们可以用每个人的编号来表示团队中的成员：例如，团队 team = [0, 1, 3] 表示掌握技能分别为 people[0]，people[1]，和 people[3] 的备选人员。

请你返回 任一 规模最小的必要团队，团队成员用人员编号表示。你可以按任意顺序返回答案，本题保证答案存在。* */

        public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
            int pNum = people.size();
            int skNum = req_skills.length;
            int[] dp = new int[1<<skNum];
            List<Integer>[] res = new ArrayList[1<<skNum];
            Map<String,Integer> map = new HashMap<>();
            for(int i=0;i<skNum;i++){
                map.put(req_skills[i],1<<i);
            }
            for(int i=0;i<(1<<skNum);i++){
                dp[i]=-1;
                res[i] = new ArrayList<>();
            }
            dp[0]=0;
            for(int i=0;i<pNum;i++){
                int sk=0;
                for(String str:people.get(i))
                    sk|=( map.get(str) == null ? 0 : map.get(str) );
                for(int st=0;st<(1<<skNum);st++){
                    if(dp[st]==-1) continue;
                    int newState = sk|st;
                    if(dp[newState]==-1||dp[st]+1<dp[newState]){
                        dp[newState] = dp[st] + 1; //更新人员数量
                        res[newState].clear();
                        res[newState].addAll(res[st]);  //更新人员的编号
                        res[newState].add(i);
                    }
                }
            }
            int[] result = new int[res[(1<<skNum)-1].size()];
            for(int i=0;i<result.length;i++){
                result[i] = res[(1<<skNum)-1].get(i);
            }
            return result;
        }
}



