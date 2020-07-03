/**
57 Insert Interval (medium)

1，跳过没有交集的区间
2，合并区间
*/
import java.util.*;

class Interval {
  int start;
  int end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
};

class InsertInterval {

  public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> mergedIntervals = new ArrayList<>();

    int i= 0;
    //1，跳过没有交集的区间
    while(i < intervals.size() && intervals.get(i).end < newInterval.start){
        mergedIntervals.add(intervals.get(i));
        i++;
    }

    // 合并
    while(i < intervals.size() && intervals.get(i).start <= newInterval.end){
        newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
        newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
        i++;
    }
    mergedIntervals.add(newInterval);

    while(i < intervals.size()){
        mergedIntervals.add(intervals.get(i));
        i++;
    }
    return mergedIntervals;
  }

  public static void main(String[] args) {
      List<Interval> input = new ArrayList<Interval>();
    input.add(new Interval(1, 3));
    input.add(new Interval(5, 7));
    input.add(new Interval(8, 12));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(1, 3));
    input.add(new Interval(5, 7));
    input.add(new Interval(8, 12));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(2, 3));
    input.add(new Interval(5, 7));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();
  }
}
