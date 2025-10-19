import java.util.Scanner;

public class topic18emailName {
    public static void main(String[] args) {
       /* 接收用户输入的邮箱名，获取邮箱的名字*/
        Scanner input = new Scanner(System.in);
        System.out.println("请输入邮箱地址");
        String emailAddress=input.nextLine();
        String username =extractUsername(emailAddress);
        if(username!=null){
            System.out.println("用户邮箱姓名为"+username);
        }else {
            System.out.println("邮箱格式不正确，请重新输入");
        }
    }
    public static String extractUsername(String email){
        if(email==null ||email.isEmpty() ||!email.contains("@")){
            return null;
        }
        String[] parts = email.split("@");
        if(parts.length != 2 || parts[0].isEmpty()){
            return null;
        }else {
            return parts[0];
        }



    }
}
