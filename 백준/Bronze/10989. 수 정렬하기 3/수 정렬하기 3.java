import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 빠른 입력을 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        // 2. 입력값 범위가 1~10,000이므로 크기 10,001 배열 생성
        int[] count = new int[10001];

        // 3. 숫자를 입력받을 때마다 해당 인덱스의 빈도수 증가
        for (int i = 0; i < N; i++) {
            count[Integer.parseInt(br.readLine())]++;
        }

        // 4. 출력을 모아서 한 번에 하기 위해 StringBuilder 사용
        StringBuilder sb = new StringBuilder();

        // 5. count 배열을 순회하며 빈도수만큼 숫자 출력
        for (int i = 1; i <= 10000; i++) {
            while (count[i] > 0) {
                sb.append(i).append('\n');
                count[i]--;
            }
        }
        
        // 최종 결과 출력
        System.out.print(sb);
    }
}