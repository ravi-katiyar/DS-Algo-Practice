package in.ravi.practice.grokking.mergerintervals;

import java.util.Arrays;
import java.util.Collections;

/**
 * Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the appointments.
 *
 * Appointments: [[1,4], [2,5], [7,9]]
 * Output: false
 * Explanation: Since [1,4] and [2,5] overlap, a person cannot attend both of these appointments.
 *
 * Appointments: [[6,7], [2,4], [8,12]]
 * Output: true
 * Explanation: None of the appointments overlap, therefore a person can attend all of them.
 */
public class ConflictingAppointments {

    public static boolean canAttendAllAppointments(Interval[] intervals) {

        //sort the input list
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        for (int i=0;i<intervals.length -1;i++){
            if(intervals[i].end > intervals[i+1].start){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
        boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals1);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals2);
        System.out.println("Can attend all appointments: " + result);
    }
}
