import java.util.*;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {

        Map<Integer, Integer> map = new HashMap<>();

        // Count losses of every player
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            map.putIfAbsent(winner, 0);

            map.put(loser, map.getOrDefault(loser, 0) + 1);
        }

        List<Integer> zeroLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        // Separate players based on losses
        for (int player : map.keySet()) {

            if (map.get(player) == 0) {
                zeroLoss.add(player);
            }
            else if (map.get(player) == 1) {
                oneLoss.add(player);
            }
        }

        Collections.sort(zeroLoss);
        Collections.sort(oneLoss);

        List<List<Integer>> result = new ArrayList<>();

        result.add(zeroLoss);
        result.add(oneLoss);

        return result;
    }
}