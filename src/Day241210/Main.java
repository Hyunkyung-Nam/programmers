package Day241210;

import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Inclimation inclimation = new Inclimation();
       // System.out.println(inclimation.solution(new int[][] {{1, 2}, {5, 1}, {3, 6}, {6, 3}}));

        Babbling babbling = new Babbling();
       // System.out.println(babbling.solution(new String[]{"aya", "yee", "u", "maa", "wyeoo"}));

        FrequentNum sol = new FrequentNum();
        //System.out.println(sol.solution(new int[]{1, 1, 2, 2, 3, 3, 3}));

    }
}
class Inclimation{
    //평행
    public int solution(int[][] dots) {
        int answer = 0;
        Arrays.sort(dots, (o1, o2) -> {
            return o1[0] - o2[0]; // 오름차순 정렬
        });

        double x1 = dots[2][0] - dots[0][0];
        double x2 = dots[3][0] - dots[1][0];
        double x3 = dots[1][0] - dots[0][0];
        double x4 = dots[3][0] - dots[2][0];

        double y1 = dots[2][1] - dots[0][1];
        double y2 = dots[3][1] - dots[1][1];
        double y3 = dots[1][1] - dots[0][1];
        double y4 = dots[3][1] - dots[2][1];

        double inclination1 = y1/x1;
        double inclination2 = y2/x2;
        double inclination3 = y3/x3;
        double inclination4 = y4/x4;

        if(inclination1 == inclination2 || inclination3 == inclination4) answer = 1;



        return answer;
    }
}
class Babbling{
    //옹알이1
    public int solution(String[] babbling) {
        int answer = 0;
        for(String s:babbling){
            s = s.replace("aya","-").replace("ye","-").replace("woo","-").replace("ma","-");
            if(s.replaceAll("-","").isEmpty()){
                answer++;
            }
        }
        return answer;
    }
}
class FrequentNum {
    //최빈값 구하기
    public int solution(int[] array) {
        int count= 0;
        int maxCount = 0;
        int frequentNum = 0;
        boolean same = false;
        Arrays.sort(array);

        while(count < array.length){
            if(count == 0){
                frequentNum = array[count];
                maxCount = countNum(array, count);
                count = maxCount;
            }else {
                int num = countNum(array,count);
                count += num;
                if(num > maxCount){
                    maxCount = num;
                    //최빈값 시작값 찾아서 넣기
                    frequentNum = array[count-maxCount+1];
                    same = false;
                } else if(num == maxCount){
                    same = true;
                }
            }

        }
        return same ? -1 : frequentNum;
    }
    public int countNum(int[] array, int num){
        int count = 1;
        int compare = array[num];
        for(int i = num+1; i < array.length; i++){
            if(array[i] == compare){
                count++;
            } else {
                return count;
            }
        }
        return count;
    }
}