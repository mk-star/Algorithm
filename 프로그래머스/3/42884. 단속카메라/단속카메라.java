import java.util.*;

class Car implements Comparable<Car> {
    int enter;
    int exit;
    
    Car(int enter, int exit) {
        this.enter = enter;
        this.exit = exit;
    }
    
    @Override
    public int compareTo(Car c) {
        return this.exit - c.exit;
    }
}

class Solution {
    public int solution(int[][] routes) {
        Car[] car = new Car[routes.length];
        
        for(int i = 0; i < routes.length; i++) {
            car[i] = new Car(routes[i][0], routes[i][1]);
        }
        
        Arrays.sort(car);
        
        int cnt = 1;
        int camera = car[0].exit;
        for(int i = 1; i < routes.length; i++) {
            if(car[i].enter <= camera) continue;
            camera = car[i].exit;
            cnt++;
        }
        return cnt;
    }
}