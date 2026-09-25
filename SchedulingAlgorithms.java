import java.util.*;

class Process {
    int id;
    int burstTime;
    int arrivalTime;
    int priority;

    public Process(int id, int burstTime, int arrivalTime, int priority) {
        this.id = id;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
        this.priority = priority;
    }
}

public class SchedulingAlgorithms {

    // FCFS Scheduling
    public static void fcfs(List<Process> processes) {
        System.out.println("FCFS Scheduling:");
        int waitTime = 0;
        for (Process p : processes) {
            System.out.println("Process " + p.id + " is executed.");
            System.out.println("Wait time for Process " + p.id + ": " + waitTime);
            waitTime += p.burstTime;
        }
        System.out.println();
    }

    // SJF Scheduling
    public static void sjf(List<Process> processes) {
        System.out.println("SJF Scheduling:");
        processes.sort(Comparator.comparingInt(p -> p.burstTime));
        int waitTime = 0;
        for (Process p : processes) {
            System.out.println("Process " + p.id + " is executed.");
            System.out.println("Wait time for Process " + p.id + ": " + waitTime);
            waitTime += p.burstTime;
        }
        System.out.println();
    }

    // Priority Scheduling
    public static void priorityScheduling(List<Process> processes) {
        System.out.println("Priority Scheduling:");
        processes.sort(Comparator.comparingInt(p -> p.priority));
        int waitTime = 0;
        for (Process p : processes) {
            System.out.println("Process " + p.id + " is executed.");
            System.out.println("Wait time for Process " + p.id + ": " + waitTime);
            waitTime += p.burstTime;
        }
        System.out.println();
    }

    // Round Robin Scheduling
    public static void roundRobin(List<Process> processes, int timeQuantum) {
        System.out.println("Round Robin Scheduling:");
        Queue<Process> queue = new LinkedList<>(processes);
        int time = 0;

        while (!queue.isEmpty()) {
            Process p = queue.poll();
            if (p.burstTime > timeQuantum) {
                System.out.println("Process " + p.id + " executed for " + timeQuantum + " units.");
                p.burstTime -= timeQuantum;
                time += timeQuantum;
                queue.offer(p); // Add back to queue
            } else {
                System.out.println("Process " + p.id + " executed for " + p.burstTime + " units.");
                time += p.burstTime;
                p.burstTime = 0;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Process> processes = new ArrayList<>();

        System.out.print("Enter number of processes: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter burst time for Process " + (i + 1) + ": ");
            int burstTime = scanner.nextInt();
            System.out.print("Enter arrival time for Process " + (i + 1) + ": ");
            int arrivalTime = scanner.nextInt();
            System.out.print("Enter priority for Process " + (i + 1) + ": ");
            int priority = scanner.nextInt();
            processes.add(new Process(i + 1, burstTime, arrivalTime, priority));
        }

        System.out.println("\nChoose a scheduling algorithm:");
        System.out.println("1. FCFS");
        System.out.println("2. SJF");
        System.out.println("3. Priority Scheduling");
        System.out.println("4. Round Robin");

        System.out.print("Enter your choice (1-4): ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                fcfs(processes);
                break;
            case 2:
                sjf(processes);
                break;
            case 3:
                priorityScheduling(processes);
                break;
            case 4:
                System.out.print("Enter time quantum for Round Robin: ");
                int timeQuantum = scanner.nextInt();
                roundRobin(processes, timeQuantum);
                break;
            default:
                System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
