
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainkey;
    
    public CaesarCipher(int key){
        alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet=alphabet.substring(key)+alphabet.substring(0,key);
        mainkey=key;
    }
    
    public String encrypt(String input){
        StringBuilder encrypted=new StringBuilder(input);
        int lc;
        for(int i=0;i<encrypted.length();++i){
            lc=0;
            char currChar=encrypted.charAt(i);
            if(Character.isLowerCase(currChar)){
                lc=1;
            }
            currChar=Character.toUpperCase(currChar);
            int idx=alphabet.indexOf(currChar);
            if(idx!=-1){
                char newChar=shiftedAlphabet.charAt(idx);
                if(lc==0)
                    encrypted.setCharAt(i,newChar);
                else
                    encrypted.setCharAt(i,Character.toLowerCase(newChar));
            }
        }
        return encrypted.toString();
    }
    
    public String decrypt(String input){
        CaesarCipher cc=new CaesarCipher(26-mainkey);
        return cc.encrypt(input);
    }
}
