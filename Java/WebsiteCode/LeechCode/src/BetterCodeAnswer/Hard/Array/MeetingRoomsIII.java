package BetterCodeAnswer.Hard.Array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/meeting-rooms-iii/">2402.Meeting Rooms III</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given an integer <code>n</code>. There are <code>n</code> rooms numbered from <code>0</code> to <code>n - 1</code>.</p>

<p>You are given a 2D integer array <code>meetings</code> where <code>meetings[i] = [start<sub>i</sub>, end<sub>i</sub>]</code> means that a meeting will be held during the <strong>half-closed</strong> time interval <code>[start<sub>i</sub>, end<sub>i</sub>)</code>. All the values of <code>start<sub>i</sub></code> are <strong>unique</strong>.</p>

<p>Meetings are allocated to rooms in the following manner:</p>

<ol>
	<li>Each meeting will take place in the unused room with the <strong>lowest</strong> number.</li>
	<li>If there are no available rooms, the meeting will be delayed until a room becomes free. The delayed meeting should have the <strong>same</strong> duration as the original meeting.</li>
	<li>When a room becomes unused, meetings that have an earlier original <strong>start</strong> time should be given the room.</li>
</ol>

<p>Return<em> the <strong>number</strong> of the room that held the most meetings. </em>If there are multiple rooms, return<em> the room with the <strong>lowest</strong> number.</em></p>

<p>A <strong>half-closed interval</strong> <code>[a, b)</code> is the interval between <code>a</code> and <code>b</code> <strong>including</strong> <code>a</code> and <strong>not including</strong> <code>b</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 2, meetings = [[0,10],[1,5],[2,7],[3,4]]
<strong>Output:</strong> 0
<strong>Explanation:</strong>
- At time 0, both rooms are not being used. The first meeting starts in room 0.
- At time 1, only room 1 is not being used. The second meeting starts in room 1.
- At time 2, both rooms are being used. The third meeting is delayed.
- At time 3, both rooms are being used. The fourth meeting is delayed.
- At time 5, the meeting in room 1 finishes. The third meeting starts in room 1 for the time period [5,10).
- At time 10, the meetings in both rooms finish. The fourth meeting starts in room 0 for the time period [10,11).
Both rooms 0 and 1 held 2 meetings, so we return 0. 
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 3, meetings = [[1,20],[2,10],[3,5],[4,9],[6,8]]
<strong>Output:</strong> 1
<strong>Explanation:</strong>
- At time 1, all three rooms are not being used. The first meeting starts in room 0.
- At time 2, rooms 1 and 2 are not being used. The second meeting starts in room 1.
- At time 3, only room 2 is not being used. The third meeting starts in room 2.
- At time 4, all three rooms are being used. The fourth meeting is delayed.
- At time 5, the meeting in room 2 finishes. The fourth meeting starts in room 2 for the time period [5,10).
- At time 6, all three rooms are being used. The fifth meeting is delayed.
- At time 10, the meetings in rooms 1 and 2 finish. The fifth meeting starts in room 1 for the time period [10,12).
Room 0 held 1 meeting while rooms 1 and 2 each held 2 meetings, so we return 1. 
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 100</code></li>
	<li><code>1 &lt;= meetings.length &lt;= 10<sup>5</sup></code></li>
	<li><code>meetings[i].length == 2</code></li>
	<li><code>0 &lt;= start<sub>i</sub> &lt; end<sub>i</sub> &lt;= 5 * 10<sup>5</sup></code></li>
	<li>All the values of <code>start<sub>i</sub></code> are <strong>unique</strong>.</li>
</ul>
</div>
 */
public class MeetingRoomsIII {
    public static void main(String[] args) {
        int[][][][] tests = {
            // {{{2}},{{0,10},{1,5},{2,7},{3,4}}},
            // {{{3}},{{1,20},{2,10},{3,5},{4,9},{6,8}}},
            // {{{1}},{{1,20},{2,10},{3,5},{4,9},{6,8}}},
            {{{4}},{{18,19},{3,12},{17,19},{2,13},{7,10}}},
        };

        for (int[][][] test : tests) {
            int n =test[0][0][0];
            int[][] meetings = test[1];

            System.out.println(new MeetingRoomsIII_Solution().mostBooked(n, meetings));
        }
    }
}

// 50 ms 100.9 MB
class MeetingRoomsIII_Solution2 {
    public int mostBooked1(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b)->a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->(a[0] == b[0] ? a[1]-b[1] : (a[0]-b[0])));
        int rooms[] = new int[n];
        int max = -1, idx = n;
        for(int i=0;i<n;i++){
            pq.add(new int[]{0, i});   
        }
        for(int i=0;i<meetings.length;i++){
            while(!pq.isEmpty() && meetings[i][0]>pq.peek()[0]){
                pq.add(new int[]{meetings[i][0], pq.poll()[1]});
            }
            int arr[] = pq.poll();
            rooms[arr[1]]++;
            if(rooms[arr[1]] > max || (rooms[arr[1]] == max && arr[1] < idx)){
                max = rooms[arr[1]];
                idx = arr[1];
            }
            //System.out.println("max: "+max+" idx: "+idx+" endTime: "+arr[0]);
            arr[0] = Math.max(arr[0], meetings[i][0]) + meetings[i][1] - meetings[i][0];
            pq.add(arr);
        }
        return idx;
    }
    public int mostBooked(int n, int[][] mt) {
        int[] cnt = new int[n];
        long[] t = new long[n];
        Arrays.sort(mt, (a, b)->a[0] - b[0]);
        for(int[] m : mt){
            int st = m[0], ed = m[1];
            boolean f = false;
            long min = Long.MAX_VALUE;
            int idx = -1;
            for(int i = 0; i < n; i++){
                if(t[i] < min){
                    min = t[i];
                    idx = i;
                }
                if(t[i] <= st){
                    t[i] = ed;
                    f = true;
                    cnt[i]++;
                    break;
                }
            }
            if(!f){
                t[idx] += (ed - st);
                cnt[idx]++;
            }
        }
        int max = 0, res = 0;
        for(int i = 0; i < n; i++){
            if(cnt[i] > max){
                max = cnt[i];
                res = i;
            }
        }
        return res;
    }
}

// 50 ms 101 MB
class MeetingRoomsIII_Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] ans = new int[n];
        long[] times = new long[n];
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < meetings.length; i++) {
            int start = meetings[i][0], end = meetings[i][1];
            boolean flag = false;
            int minind = -1;
            long val = Long.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (times[j] < val) {
                    val = times[j];
                    minind = j;
                }
                if (times[j] <= start) {
                    flag = true;
                    ans[j]++;
                    times[j] = end;
                    break;
                }
            }
            if (!flag) {
                ans[minind]++;
                times[minind] += (end - start);
            }
        }

        int maxi = -1, id = -1;
        for (int i = 0; i < n; i++) {
            if (ans[i] > maxi) {
                maxi = ans[i];
                id = i;
            }
        }
        return id;
    }
}

