import edu.duke.*;
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestCaesarCipher {
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
    
    public void simpleTests(){
        FileResource fr=new FileResource();
        String s=fr.asString();
        CaesarCipher obj=new CaesarCipher(15);
        String en=obj.encrypt(s);
        System.out.println("Encrypted text:"+obj.encrypt(s));
        System.out.println("Decrypted text:"+obj.decrypt(en));
        
        System.out.println("Decrypted Message:"+breakCaesarCipher(en));
    }
    
    public String breakCaesarCipher(String input){
        int []freqs=countLetters(input);
        int max=maxIndex(freqs);
        int dkey=max-4;
        if(max<4)
            dkey=26-(4-max);
        CaesarCipher cc=new CaesarCipher(26-dkey);
        return cc.encrypt(input);
    }
    
}
