/**
Employee Free Time (hard) #
For ‘K’ employees, we are given a list of intervals representing the working hours of each employee. 
Our goal is to find out if there is a free interval that is common to all employees. 
You can assume that each list of employee working hours is sorted on the start time.

Example 1:
Input: Employee Working Hours=[[[1,3], [5,6]], [[2,3], [6,8]]]
Output: [3,5]
Explanation: Both the employess are free between [3,5].

Example 2:
Input: Employee Working Hours=[[[1,3], [9,12]], [[2,4]], [[6,8]]]
Output: [4,6], [8,9]
Explanation: All employess are free between [4,6] and [8,9].

Example 3:
Input: Employee Working Hours=[[[1,3]], [[2,4]], [[3,5], [7,9]]]
Output: [5,7]
Explanation: All employess are free between [5,7].
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

class EmployeeInterval{
    Interval interval;
    int employeeIndex;
    int intervalIndex;

    public EmployeeInterval(Interval interval, int employeeIndex, int intervalIndex){
        this.interval = interval;
        this.employeeIndex = employeeIndex;
        this.intervalIndex = intervalIndex;
    }
}

class EmployeeFreeTime {

  public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
    List<Interval> result = new ArrayList<>();

    //minHeap, order by start
    PriorityQueue<EmployeeInterval> minHeap = new PriorityQueue<EmployeeInterval>((e1, e2) -> e1.interval.start - e2.interval.start);

    //存储每个职员的第一个区间
    for (int employeeIndex = 0; employeeIndex < schedule.size(); employeeIndex++) {
        Interval interval = schedule.get(employeeIndex).get(0);
        EmployeeInterval ei = new EmployeeInterval(interval, employeeIndex, 0);
        minHeap.add(ei);
    }
    EmployeeInterval preEI = null;
    while(minHeap.isEmpty() == false){
      
        EmployeeInterval currentEI = minHeap.poll();

        if(preEI == null){
          preEI = currentEI;
        }else{
          // 存在时间间隔
          if(currentEI.interval.start > preEI.interval.end){ //gap
            Interval gap = new Interval(preEI.interval.end, currentEI.interval.start);
            result.add(gap);
          }
          //  更新preEI
          preEI = (currentEI.interval.end > preEI.interval.end) ? currentEI :  preEI;
        }

        // 添加新的职员时间
        if(currentEI.intervalIndex < schedule.get(currentEI.employeeIndex).size()-1){
            int employeeIndex = currentEI.employeeIndex;
            int intervalIndex = currentEI.intervalIndex+1;
            Interval interval = schedule.get(employeeIndex).get(intervalIndex);
            EmployeeInterval ei = new EmployeeInterval(interval, employeeIndex, intervalIndex);
            minHeap.add(ei);
        }
    }
    return result;
  }

  public static void main(String[] args) {

    List<List<Interval>> input = new ArrayList<>();
    input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
    input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
    List<Interval> result = EmployeeFreeTime.findEmployeeFreeTime(input);
    System.out.print("Free intervals: ");
    for (Interval interval : result)
      System.out.print("[" + interval.start + ", " + interval.end + "] ");
    System.out.println();

    input = new ArrayList<>();
    input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
    input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
    input.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 8))));
    result = EmployeeFreeTime.findEmployeeFreeTime(input);
    System.out.print("Free intervals: ");
    for (Interval interval : result)
      System.out.print("[" + interval.start + ", " + interval.end + "] ");
    System.out.println();

    input = new ArrayList<>();
    input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3))));
    input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
    input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
    result = EmployeeFreeTime.findEmployeeFreeTime(input);
    System.out.print("Free intervals: ");
    for (Interval interval : result)
      System.out.print("[" + interval.start + ", " + interval.end + "] ");
  }
}
