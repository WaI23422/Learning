package BetterCodeAnswer.Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/divide-players-into-teams-of-equal-skill/">2491. Divide Players Into Teams of Equal Skill</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given a positive integer array <code>skill</code> of <strong>even</strong> length <code>n</code> where <code>skill[i]</code> denotes the skill of the <code>i<sup>th</sup></code> player. Divide the players into <code>n / 2</code> teams of size <code>2</code> such that the total skill of each team is <strong>equal</strong>.</p>
 * 
 * <p>The <strong>chemistry</strong> of a team is equal to the <strong>product</strong> of the skills of the players on that team.</p>
 * 
 * <p>Return <em>the sum of the <strong>chemistry</strong> of all the teams, or return </em><code>-1</code><em> if there is no way to divide the players into teams such that the total skill of each team is equal.</em></p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> skill = [3,2,5,1,3,4]
 * <strong>Output:</strong> 22
 * <strong>Explanation:</strong> 
 * Divide the players into the following teams: (1, 5), (2, 4), (3, 3), where each team has a total skill of 6.
 * The sum of the chemistry of all the teams is: 1 * 5 + 2 * 4 + 3 * 3 = 5 + 8 + 9 = 22.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> skill = [3,4]
 * <strong>Output:</strong> 12
 * <strong>Explanation:</strong> 
 * The two players form a team with a total skill of 7.
 * The chemistry of the team is 3 * 4 = 12.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> skill = [1,1,2,3]
 * <strong>Output:</strong> -1
 * <strong>Explanation:</strong> 
 * There is no way to divide the players into teams such that the total skill of each team is equal.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>2 &lt;= skill.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>skill.length</code> is even.</li>
 * 	<li><code>1 &lt;= skill[i] &lt;= 1000</code></li>
 * </ul>
 * </div></div>
 */
public class DividePlayersIntoTeamsOfEqualSkill {
    public static void main(String[] args) {
        int[][] tests = {
            {3,2,5,1,3,4}
        };

        for (int[] skill : tests) {
            System.out.println(new DividePlayersIntoTeamsOfEqualSkill_Solution().dividePlayers(skill));
        }
    }
}

// 2ms 55.20MB
class DividePlayersIntoTeamsOfEqualSkill_Solution {

    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int totalSkill = 0;
        int[] skillFrequency = new int[1001];

        // Calculate total skill and skill frequency
        for (int playerSkill : skill) {
            totalSkill += playerSkill;
            skillFrequency[playerSkill]++;
        }

        // Check if total skill can be evenly distributed among teams
        if (totalSkill % (n / 2) != 0) {
            return -1;
        }

        int targetTeamSkill = totalSkill / (n / 2);
        long totalChemistry = 0;

        // Calculate total chemistry while verifying valid team formations
        for (int playerSkill : skill) {
            int partnerSkill = targetTeamSkill - playerSkill;

            // Check if a valid partner exists
            if (skillFrequency[partnerSkill] == 0) {
                return -1;
            }

            totalChemistry += (long) playerSkill * (long) partnerSkill;
            skillFrequency[partnerSkill]--;
        }

        // Return half of totalChemistry as each pair is counted twice
        return totalChemistry / 2;
    }
}