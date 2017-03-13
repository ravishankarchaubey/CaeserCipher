import edu.duke.*;
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestCaesarCipherTwo {
    public int[] countLetters(String message){
        String alpha="abcdefghijklmnopqrstuvwxyz";
        int []counts=new int[26];
        for(int i=0;i<message.length();++i){
            char ch=Character.toLowerCase(message.charAt(i));
            int idx=alpha.indexOf(ch);
            if(idx!=-1)
                counts[idx]++;
        }
        return counts;
    }
    
    public int maxIndex(int []vals){
        int max=0;
        for(int i=0;i<vals.length;++i){
            if(vals[i]>vals[max])
                max=i;
        }
        return max;
    }
    
    public String halfOfString(String message,int start){
        String half="";
        for(int i=start;i<message.length();i+=2){
            half+=message.charAt(i);
        }
        return half;
    }
    
    public int getKey(String s){
        int []freqs=countLetters(s);
        int max=maxIndex(freqs);
        int dkey=max-4;
        if(max<4)
            dkey=26-(4-max);
        return dkey;
    }
    
    public void simpleTests(){
        FileResource fr=new FileResource();
        String s=fr.asString();
        CaesarCipherTwo obj=new CaesarCipherTwo(21,8);
        String en=obj.encrypt(s);
        System.out.println("Encrypted text:"+obj.encrypt(s));
        System.out.println("Decrypted text:"+obj.decrypt(en));
        
        System.out.println("Decrypted Message:"+breakCaesarCipher(s));
        //System.out.println("Decrypted Message:"+breakCaesarCipher("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!"));
    }
    
    public String breakCaesarCipher(String input){
        String half1=halfOfString(input,0);
        String half2=halfOfString(input,1);
        int key1=getKey(half1);
        int key2=getKey(half2);
        System.out.println(key1+","+key2);
        CaesarCipherTwo cc=new CaesarCipherTwo(26-key1,26-key2);
        return cc.encrypt(input);
    }
}
