package Day241211;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){

        ChangeLetter changeLetter = new ChangeLetter();
        System.out.println(changeLetter.solution("allpe","apple"));

        Share share = new Share();
       // System.out.println(share.solution(5,4));

        Letter letter = new Letter();
       // System.out.println(letter.solution(".... . .-.. .-.. ---"));
        Emergency emergency = new Emergency();
        //System.out.println(Arrays.toString(emergency.solution(new int[] {30,10,23,6,100})));
        ThrowBall throwBall = new ThrowBall();
        //System.out.println(throwBall.solution(new int[] {1,2,3,4},999));

    }
}
//연속하는 숫자의 합 만들기
class SumNumber {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int middle = 0;
        if(num % 2 == 1){
            middle = total/num;
            for(int i = 0; i < num ; i++){
                answer[i] = middle - num/2  + i;
            }
        }else {
            middle = (total - num/2)/num;
            for(int i = 0; i < num ; i++){
                answer[i] = middle - (num-1)/2 + i ;
            }
        }
        return answer;
    }
}
//순서바꿔 만들기
class ChangeLetter {
    public int solution(String before, String after) {
        String[] afterArr = after.split("");
        for(String s :afterArr){
            before = before.replaceFirst(s, "-");
        }
        return before.replaceAll("-","").isEmpty() ? 1 : 0;
    }
}
//2차원 배열로 만들기
class Matrix {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length / n][n];
        int count = 0;

        for (int i = 0; i < num_list.length / n; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = num_list[i * n + j + count];
            }
        }
        return answer;
    }
}

//구슬 나누기
class Share {
    public int solution(int balls, int share) {
        long answer = 1;

        if(balls == share){
            return 1;
        }

        int num = share < balls-share ? share : balls-share;

        for(int i = 1; i <= num ; i++){
            answer = answer * (balls-i+1) / i;
        }
        return (int)answer;
    }
}

//모스부호
class Letter {
    public String solution(String letter) {
        String answer = "";
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."} ;

        String[] letterArr = letter.split(" ");

        for(String s : letterArr){
            char c = (char)(Arrays.asList(morse).indexOf(s)+(int) 'a') ;
            answer += c;
        }

        return answer;
    }
}
//위급환자
class Emergency {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        int[] sortedEmergency = Arrays.copyOf(emergency,emergency.length);
        Arrays.sort(sortedEmergency);
        System.out.println(Arrays.toString(sortedEmergency));

        for(int i = sortedEmergency.length ;i > 0; i--) {
            for(int j = 0; j < sortedEmergency.length ; j++){
                if(sortedEmergency[i-1] == emergency[j]){
                    answer[j] = sortedEmergency.length-i+1;
                    break;
                }
            }
        }

        return answer;
    }
}
//공던지기
class ThrowBall {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        if(numbers.length %2 == 0){
            int num = k % (numbers.length/2)==0 ? numbers.length/2 : k % (numbers.length/2);
            answer = 2*num -1;
        }else {
            int num = k % (numbers.length) == 0 ? numbers.length : k % (numbers.length);
            //짝수번째
            if((numbers.length+1)/2 < num){
                answer = (num - (numbers.length+1)/2)*2;
            }
            //홀수번쨰
            else {
                answer = num*2 - 1 ;
            }
        }
        return answer;
    }
}