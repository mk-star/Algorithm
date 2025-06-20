function solution(a, b) {
    const dayOfWeek = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT'];
    const date = `2016-${a}-${b}`;
    return dayOfWeek[new Date(date).getDay()]; 
}