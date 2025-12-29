import java.util.*;

class Solution {
    record OfflineUser(int returnTime, int userId) {}

    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        final int MOD = 1_000_000_007;

        
        events.sort(Comparator
            .comparingInt((List<String> e) -> Integer.parseInt(e.get(1)))
            .thenComparing(e -> e.get(0), Comparator.reverseOrder())
        );

        int[] ans = new int[numberOfUsers];
        boolean[] online = new boolean[numberOfUsers];
        Arrays.fill(online, true);

        
        PriorityQueue<OfflineUser> pq = new PriorityQueue<>(
            Comparator.comparingInt(OfflineUser::returnTime)
        );
        int globalAllMentions = 0;

        for (List<String> ev : events) {
            String type = ev.get(0);
            int time = Integer.parseInt(ev.get(1));

            
            while (!pq.isEmpty() && pq.peek().returnTime() <= time) {
                online[pq.poll().userId()] = true;
            }

            if (type.equals("OFFLINE")) {
                int uid = Integer.parseInt(ev.get(2));
                online[uid] = false;
                pq.add(new OfflineUser(time + 60, uid));
            } else { 
                String mentions = ev.get(2);
                if (mentions.equals("ALL")) {
                    globalAllMentions++;
                } else if (mentions.equals("HERE")) {
                    for (int u = 0; u < numberOfUsers; u++) {
                        if (online[u]) ans[u]++;
                    }
                } else {
                    for (String token : mentions.split(" ")) {
                        
                        int uid = Integer.parseInt(token.substring(2));
                        ans[uid]++;
                    }
                }
            }
        }

        // Add all global "ALL" mentions to every user
        for (int i = 0; i < numberOfUsers; i++) {
            ans[i] += globalAllMentions;
        }

        return ans;
    }
}
