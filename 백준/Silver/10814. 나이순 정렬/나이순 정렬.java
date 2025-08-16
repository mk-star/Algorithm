import java.io.*;
import java.util.*;

class User implements Comparable<User> {
	int age;
	String name;
	int order;

	User(int age, String name, int order) {
		this.age = age;
		this.name = name;
		this.order = order;
	}

	public int compareTo(User u) {
		if(u.age == this.age) return this.order - u.order;
		else return this.age - u.age;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		User[] arr = new User[N];

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();

			arr[i] = new User(age, name, i);
		}

		Arrays.sort(arr);

		for(User u : arr) {
			System.out.println(u.age + " " + u.name);
		}
	}
}