package test1;

public class PG_문자열압축 {
    public int solution(String s) {
        char[] src = s.toCharArray();
        int min = Integer.MAX_VALUE;

        for(int i=1; i<=src.length; i++) {
            StringBuilder res = new StringBuilder();  // 압축된 문자열
            int cnt = 1;
            for(int j=0; j*i<src.length; j++) {
                String now = s.substring(j*i, (j+1)*i);
                // 현재값 j*i ~ (j+1)*i
                if((j+2)*i > src.length) {
                    if(cnt == 1) {
                        res.append(s.substring(j*i,src.length));
                    }else {
                        res.append(cnt);
                        res.append(now);
                        res.append(s.substring((j+1)*i,src.length));
                        cnt = 1;
                    }

                    break;
                }
                // if (j+2)*i > src.length j*i ~ src.length 까지 stringBuilder에 추가하고 break;
                String next = s.substring((j+1)*i, (j+2)*i);
                // 다음값 (j+1)*i ~ (j+2)*i
                if(now.equals(next)) {
                    cnt++;
                }else {
                    if(cnt == 1) {
                        res.append(now);
                    }else {

                        res.append(cnt);
                        res.append(now);
                        cnt = 1;
                    }
                }
                // 현재값 다음값 비교
                // 같으면 cnt++
                // 아니면 StringBuilder에 추가 cnt가 1이면 무시


            }
            min = Math.min(min, res.length());
            // 압축된 문자열 전체 길이 min 값 비교
        }

        return min;
    }
}
