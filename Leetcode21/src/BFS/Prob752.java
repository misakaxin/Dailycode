package BFS;

import java.util.*;

/**
 * @author misakaxin
 */
public class Prob752 {
    public  static int openLock(String[] deadends, String target) {
        Set<String >deads = new HashSet<>();
        Collections.addAll(deads, deadends);
        Queue<String> q=new LinkedList<>();
        Set<String> visited=new HashSet<>();
        q.offer("0000");
        visited.add("0000");
        int step=0;

        while (!q.isEmpty()){
            int sz=q.size();
            for (int i = 0; i <sz ; i++) {
                String cur=q.poll();
                if (deads.contains(cur)){
                    continue;
                }
                assert cur != null;
                if (cur.equals(target)){
                    return step;
                }

                for (int j = 0; j < 4; j++) {
                    String up=plusOne(cur,j);
                    if (!visited.contains(up)){
                        q.offer(up);
                        visited.add(up);
                    }
                    String down=minusOne(cur,j);
                    if (!visited.contains(down)){
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
           step++;
        }
        return -1;
    }
    public  static String plusOne(String s,int j){
        char[] ch=s.toCharArray();
        if (ch[j]=='9'){
            ch[j]='0';
        }
        else {
            ch[j]+=1;
        }
        return new String(ch);
    }


    public  static String minusOne(String s, int j){
        char[] ch=s.toCharArray();
        if (ch[j]=='0'){
            ch[j]='9';
        }
        else {
            ch[j]-=1;
        }
        return new String(ch);
    }

    public  static void main(String[] args) {

        String[] deadends ={"0201","0101","0102","1212","2002"};
        String target="0202";
        System.out.println(openLock(deadends,target));
    }

}
