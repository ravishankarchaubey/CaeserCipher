
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipherTwo{
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainkey1;
    private int mainkey2;
    
    public CaesarCipherTwo(int key1,int key2){
        alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1=alphabet.substring(key1)+alphabet.substring(0,key1);
        shiftedAlphabet2=alphabet.substring(key2)+alphabet.substring(0,key2);
        mainkey1=key1;
        mainkey2=key2;
    }
    
    public String encrypt(String input){
        int lc;
        StringBuilder encrypted=new StringBuilder(input);
        for(int i=0;i<encrypted.length();++i){
            lc=0;
            char currChar=encrypted.charAt(i);
            if(Character.isLowerCase(currChar)){
                lc=1;
            }
            currChar=Character.toUpperCase(currChar);
            int idx=alphabet.indexOf(currChar);
            if(idx!=-1){
                if(i%2==0){
                    char newChar=shiftedAlphabet1.charAt(idx);
                    if(lc==0)
                        encrypted.setCharAt(i,newChar);
                    else
                        encrypted.setCharAt(i,Character.toLowerCase(newChar));
                }
                else{
                    char newChar=shiftedAlphabet2.charAt(idx);
                    if(lc==0)
                        encrypted.setCharAt(i,newChar);
                    else
                        encrypted.setCharAt(i,Character.toLowerCase(newChar));
                }
            }
        }
        return encrypted.toString();
    }
    
    public String decrypt(String input){
        CaesarCipherTwo cct=new CaesarCipherTwo(26-mainkey1,26-mainkey2);
        return cct.encrypt(input);
    }
}
