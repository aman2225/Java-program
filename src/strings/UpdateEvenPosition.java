package strings;

public class UpdateEvenPosition {
    public static void main(String[] args) {
        String s="Aman kumar";
        String str="";
        for(int i=0;i<s.length();i++){
            if(i%2==0){
                str+='a';
            }
            else{
                str+= s.charAt(i);
            }
        }
        System.out.print(str);

    }
}
