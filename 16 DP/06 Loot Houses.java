/**********************************************************************************************************

A thief wants to loot houses. He knows the amount of money in each house. He cannot loot two consecutive
houses. Find the maximum amount of money he can loot.
Input format :
The first line of input contains an integer value of 'n'. It is the total number of houses.

The second line of input contains 'n' integer values separated by a single space denoting the amount of
money each house has.
Output format :
Print the the maximum money that can be looted.
Constraints :
0 <= n <= 10 ^ 4

Time Limit: 1 sec
Sample Input 1 :
6
5 5 10 100 10 5
Sample Output 1 :
110
Sample Input 2 :
6
10 2 30 20 3 50
Sample Output 2 :
90
Explanation of Sample Output 2 :
Looting first, third, and the last houses([10 + 30 + 50]) will result in the maximum loot, and all the 
other possible combinations would result in less than 90.

***********************************************************************************************************/



public class Solution {

    public static int maxMoneyLooted(int house[],int n,int dp[]){
        if(n<0)
            return 0;
        if(n == 0)
            return house[0];
        
        if(dp[n] != -1)
            return dp[n];
        
        int looted = house[n] + maxMoneyLooted(house,n-2,dp);
        int notLooted = maxMoneyLooted(house,n-1,dp);
        
        dp[n] = Math.max(looted,notLooted);
        return dp[n];
    }
	public static int maxMoneyLooted(int[] houses) {
		//Your code goes here
        int n = houses.length;
        int dp[] = new int[n+1];
        for(int i=0;i<=n;i++)
            dp[i] = -1;
        return maxMoneyLooted(houses,houses.length-1,dp);
            
	}

}


