
package Prac4;

import java.util.Arrays;

/**
 *
 * @author DELL
 */
public class ByteStuff {
    String input,flag;
   public ByteStuff(String input,String flag){
       this.input = input;
       this.flag = flag;
       
   } 
   public String stuffed( ){
       System.out.println("Data after stuffing");
       //StringBuilder sb = new StringBuilder();
       String stuff=""; 
       for(int i=0;i<input.length();i++)
       {
           if(input.charAt(i)== flag.charAt(0))
           {
               stuff = stuff+'H'+input.charAt(i);
           }
           else{
               stuff = stuff+input.charAt(i);
           }
           
       }
       return 'H'+stuff+'H';
       
   }
   public String deStuff(String stuf){
       String destuff="";
       for(int i=1;i<stuf.length()-1;i++)
       {
           if(stuf.charAt(i) == flag.charAt(0))
           {
               destuff = destuff+stuf.charAt(i+1);
               i++;
           }
           else destuff+=stuf.charAt(i);
       }
       return destuff;
   }
   public void stuffBit(){
       String str="";
       int ar[] = new int[input.length()];
       for(int i=0;i<input.length();i++)
       {
           ar[i] = input.charAt(i);
       }
       for(int i=0;i<ar.length;i++)
       {
        str += Integer.toBinaryString(ar[i]);
       }
       System.out.println("String to binary");
        System.out.println(str);
       String flag1 = Integer.toBinaryString(flag.charAt(0));
       System.out.println("Binary of flag val:  " + flag1);
       
       String stuff="";
       System.out.println(str.length());
       for(int i=0;i<str.length();i+=7)
       {
           if(str.substring(i, i+8).equals(flag1))
           {
               stuff = stuff + flag1 + str.substring(i,i+8);
           }
           else {
               stuff = stuff + str.substring(i,i+8);
           }
       }
       System.out.println(flag1+" "+stuff+" "+flag1);
    }
    public static void main(String[] args) {
        ByteStuff b = new ByteStuff("Hi How are you1","H");
//        String stuff = b.stuffed();
//        String destuff = b.deStuff(stuff);
//        System.out.println(stuff);
//        System.out.println("Data after destuffing");
//        System.out.println(destuff);
        b.stuffBit();
    }
}
