import java.util.*;
public class RabinKarp{
    static List<Integer> rabinKarp(String text,String pattern){
        List<Integer> res=new ArrayList<>();
        int d=256,q=101,m=pattern.length(),n=text.length(),p=0,t=0,h=1;
        for(int i=0;i<m-1;i++)h=(h*d)%q;
        for(int i=0;i<m;i++){
            p=(d*p+pattern.charAt(i))%q;
            t=(d*t+text.charAt(i))%q;
        }
        for(int i=0;i<=n-m;i++){
            if(p==t&&text.substring(i,i+m).equals(pattern))res.add(i);
            if(i<n-m){
                t=(d*(t-text.charAt(i)*h)+text.charAt(i+m))%q;
                if(t<0)t+=q;
            }
        }
        return res;
    }
    public static void main(String[] args){
        String text="ababcabcabababd",pattern="abab";
        List<Integer> res=rabinKarp(text,pattern);
        System.out.println(res);
    }
}
