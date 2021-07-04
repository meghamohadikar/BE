import java.util.Date;
import java.util.function.Supplier;

public class SupplierInterface {
    public static void main(String[] args) {
        //to return current date
        Supplier<Date> s = () -> new Date();
        System.out.println(s.get());

        //to return random name
        Supplier<String> s1 = () -> {
            String[] str = {"Megha", "Ujjwal", "Vimal", "Sayali"};
            //Math.random() generates value 0<=x<0.9
            int x = (int) (Math.random() * 4);//0<=x<3
            return str[x];
        };
        System.out.println(s1.get());

        //to get random 6 digits OTP
        Supplier<String> s2 = () -> {
            String otp = "";
            for (int i = 0; i < 6; i++) {
                otp = otp + (int) (Math.random() * 10);//generate 0<=x<9
            }
            return otp;
        };
        System.out.println(s2.get());

        //to get random password
        //1. length should be 8 chars
        //2. 2,4,6,8 places only digits
        //3. 1,3,5,7 places only uppercase alphabet and (@,#,$)

        Supplier<String> s3 = () -> {
            String pwd="";
            Supplier<Integer> d=()-> (int) (Math.random() * 10);//0-9 digit creator
            String symbols="ABCDEFGHIJKLMNOPQRSTUVWXYZ@#$"; //symbols.length()=29
            Supplier<Character> c=()->symbols.charAt((int)(Math.random()*29));//0<=x<28
            for(int i=1;i<=8;i++){
                if(i%2==0)
                    pwd=pwd+d.get();
                else
                    pwd=pwd+c.get();
            }
          return  pwd ;
        };
        System.out.println(s3.get());
    }
}
