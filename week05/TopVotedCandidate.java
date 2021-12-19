class TopVotedCandidate {

  private int[] persons;
  private int[] times;
  private int[] tops;
  private Map<Integer, Integer> voteCounts;

    public TopVotedCandidate(int[] persons, int[] times) {
      this.persons = persons;
      this.times = times;
      tops = new int[persons.length];
      voteCounts = new HashMap<>();
      voteCounts.put(-1, - 1);

      // 预处理，选出每轮（就是数组的下标）投票结束时最多的候选人
      int top = -1;
      for (int i = 0; i < persons.length; i++) {
          int p = persons[i];
          int vote = voteCounts.getOrDefault(p, 0);
          voteCounts.put(p, vote + 1);
          if (voteCounts.get(p) >= voteCounts.get(top)) {
              top = p;
          }
          tops[i] = top;
      }

    }

    public int q(int t) {
      int pos = getPos(t);
      return tops[pos];
    }

    // 找到 <= t 时刻中最大那个的位置即某一轮选票
    private int getPos(int t) {
      int left = 0;
      int right = times.length - 1;
      while (left < right) {
        int mid = (left + right + 1) / 2;
        if (times[mid] <= t) {
          left = mid;
        } else {
          right = mid - 1;
        }
      }
      return right;
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */

/**
    [0, 1, 1, 0, 0, 1, 0]
i    0  1  2  3  4  5  6
    [0, 5, 10, 15, 20, 25, 30]

t = 3, i = 0
t = 12, i = 2
t = 25, i = 5

map
key: i
value: 投票领先，投的最多

[0, 0],[1,1],[2,1][3,0][4,0],[5, 1]

 */
