import java.util.*;
import java.io.*;

class Task implements Comparable<Task>, Cloneable {
    int duration;
    List<Integer> pre;
    int time;

    Task(int duration, List<Integer> pre, int time) {
        this.duration = duration;
        this.pre = pre;
        this.time = time;
    }

    @Override
    public int compareTo(Task t) {
        int thisMax = this.pre.isEmpty() ? -1 : Collections.max(this.pre);
        int thatMax = t.pre.isEmpty() ? -1 : Collections.max(t.pre);
        return Integer.compare(thisMax, thatMax);
    }

    public int getDuration() {
        return duration;
    }

    public List<Integer> getPre() {
        return pre;
    }

    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }

    public String toString() {
        return time + " " + pre;
    }

    @Override
    public Task clone() throws CloneNotSupportedException {
        return (Task) super.clone();
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Task[] arr = new Task[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int duration = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            List<Integer> preTask = new ArrayList<>();
            for(int j = 0; j < num; j++) {
                preTask.add(Integer.parseInt(st.nextToken()));
            }
            arr[i] = new Task(duration, preTask, 0);
        }

        Task[] copyArr = arr.clone();
        Arrays.sort(copyArr);
        int max = 0;

        for(int i = 0; i < N; i++) {
            Task t = copyArr[i];
            
            if(t.getPre().size() == 0) t.setTime(t.getDuration());
            else {
                int maxPre = 1;
                for(int pre : t.getPre()) {
                    maxPre = arr[maxPre - 1].getTime() < arr[pre - 1].getTime() ? pre : maxPre;
                }
                t.setTime(arr[maxPre - 1].getTime() + t.getDuration());
            }
            max = Math.max(t.getTime(), max);
        }
        System.out.println(max);
    }
}
