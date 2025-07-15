import java.util.*;
import java.io.*;

class Student {
    int studentNo;
    int count;
    int order;

    Student(int studentNo, int count, int order) {
        this.studentNo = studentNo;
        this.count = count;
        this.order = order;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int R = Integer.parseInt(br.readLine());

        PriorityQueue<Student> pq = new PriorityQueue<>(new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                if(s1.count == s2.count) {
                    return s1.order - s2.order; // order 값이 작을수록 오래된 것 
                } else {
                    return s1.count - s2.count;
                }
            }
        });

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < R; i++) {
            int num = Integer.parseInt(st.nextToken());
            boolean isExists = false;
            PriorityQueue<Student> tmp = new PriorityQueue<>(pq);

            // 이미 있다면
            while(!tmp.isEmpty()) {
                Student s = tmp.poll();
                if(s.studentNo == num) {
                    pq.remove(s);
                    s.count++;
                    pq.offer(s);
                    isExists = true;
                    break;
                }
            }

            if(isExists) continue;
            
            if(pq.size() == N) { // 없는데 꽉 찼다면
                pq.poll();
            }
            
            pq.offer(new Student(num, 1, i));   
        }

        PriorityQueue<Student> result = new PriorityQueue<>(new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.studentNo - s2.studentNo;
            }
        });

        result.addAll(pq);
        
        while(!result.isEmpty()) {
            Student s = result.poll();
            System.out.print(s.studentNo + " ");
        }
    }
}
