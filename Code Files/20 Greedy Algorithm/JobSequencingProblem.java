import java.util.*;;

public class JobSequencingProblem {

    static class Job {
        int deadline;
        int profit;
        int id;

        public Job(int i, int d, int p)
        {
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String[] args) {
        int JobsInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};
        
        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < JobsInfo.length; i++) {
            jobs.add(new Job(i, JobsInfo[i][0], JobsInfo[i][1]));
        }

        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);
        // Descending order of profit

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;

        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                seq.add(curr.id);
                time++;
            }
        }

        // print seq
        System.out.println(seq.size());
        for (int i = 0; i < seq.size(); i++) {
            System.out.print(seq.get(i) + " ");
        }
    }
}


/*
 * 
 * Job Sequencing Problem
 * Given an array of jobs where every job has a deadline and profit if 
 * the job is finished before the deadline. It is also given that every
 * job takes a single unit of time, so the minimum possible deadline for 
 * any job is 1. Maximize the total profit if only one job can be 
 * scheduled at a time.
 * 
 * Job A = 4, 20
 * Job B = 1, 10
 * Job C = 1, 40
 * Job D = 1, 30
 * 
 * ans = C, A
 * 
 * 
 */