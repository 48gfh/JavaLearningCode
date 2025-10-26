//自动取款机系统

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/**
 *"自动取款机系统" - 每个用户都是基于自动取款机系统完成业务处理，
 * 如：系统首页展示、开户、登录、存款、取款、转账...等等操作。编写自动取款机系统类（ATM类）负责对账户进行操作，以及对外提供需求。
 * */
public class ATM {
    private ArrayList<Account>  accounts=new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    //封装一个Account用来存储当前登录用户
    private Account loginAccount;

    //展示首页信息
    public  void showHomePage(){
        while(true){
            //展示对应的欢迎页
            System.out.println("============欢迎使用中国建设银行============");
            System.out.println("1、用户登录");
            System.out.println("2、用户开户");
            System.out.println("请选择功能");

            int choice = sc.nextInt();
            switch (choice){
                default:
                    System.out.println("无效输入请重新输入");
                    break;
                case 1:
                    System.out.println("进入用户登录");
                    login();
                    break;
                case 2:
                    System.out.println("进入用户开户");
                    creatAccount();
            }
        }
    }

    //将登录功能单独抽取成一个方法
    private void login() {
        System.out.println("============欢迎使用中国建设银行自动取款机系统完成登录操作============");
        System.out.println("请输入您的卡号");
        String inputCardID = sc.next();
        //根据卡号判断是否开户，如未开户，需要提示先开户再登录。
        isExist(inputCardID);
        Account ac = isExist(inputCardID);
        if(ac==null){
            System.out.println("请先完成开户");
        }else{
            while (true){
                //如果卡号正确，再让用户输入账户密码，如果密码不正确要给出提示，如果密码也正确，则给出登录成功的提示。
                System.out.println("请输入您的密码");
                String inputPassword = sc.next();
                if (inputPassword.equals(ac.getPassword())){
                    //如果登录成功将当前登录的用户进行封装以便当前类内部进行使用
                    loginAccount=ac;
                    System.out.println("登录成功，您的卡号是"+ac.getIdCard());
                    //展示用户操作界面
                    showUserPage();
                    break;
                }else {
                    System.out.println("密码输入错误请重新输入");
                }
            }
        }
    }

    /**
     * ● 登录成功之后，需要显示登录后的用户操作界面。
     * ● 将用户操作界面展示功能提取为一个方法（showUserPage()方法），在用户登录成功后调用即可。
     * ● 用户操作界面展示方法中，包含：查询账户功能、存款功能、取款功能、转账功能、密码修改功能、注销用户功能、退出功能
     * */
    private void showUserPage() {
        System.out.println("~请选择以下功能进行账户处理~");
        System.out.println("1-查询账户");
        System.out.println("2-存款");
        System.out.println("3-取款");
        System.out.println("4-转账");
        System.out.println("5-密码修改");
        System.out.println("6-退出");
        System.out.println("7-注销当前用户");
        while (true){

            System.out.println("~请选择以下功能进行账户处理~");
            System.out.println("1-查询账户");
            System.out.println("2-存款");
            System.out.println("3-取款");
            System.out.println("4-转账");
            System.out.println("5-密码修改");
            System.out.println("6-退出");
            System.out.println("7-注销当前用户");
            int choice = sc.nextInt();
            switch (choice){
                default:
                    System.out.println("无效输入，请重新输入");
                case 1:
                    System.out.println("1-查询账户");
                    showLoginAccount();
                    break;
                case 2:
                    System.out.println("2-存款");
                    saveMoney();
                    break;
                case 3:
                    System.out.println("3-取款");
                    getMoney();
                    break;
                case 4:
                    System.out.println("4-转账");
                    transferMoney();
                    break;
                case 5:
                    System.out.println("5-密码修改");
                    updatePassword();
                    break;
                case 6:
                    System.out.println("6-退出");
                    System.out.println("用户"+loginAccount.getName()+"退出当前系统");
                    return;
                case 7:
                    System.out.println("7-注销当前用户");
                    if(deleteAccount()){

                    }
                    break;

            }
        }

    }
    /**
     *把销户功能单独抽取为一个方法（deleteAccount()方法）
     * ● 确认是否需要注销账户，让用户输入Y或者N
     *   ○ 如果输入Y，表示确认
     *   ○ 如果输入N，表示取消注销操作
     *   ○ 如果输入其它字母，表示录入错误，需重新录入
     * ● 输入Y后，继续判断当前用户的账户是否有钱
     *   ○ 如果账户有钱，提示：“对不起，您的账户中尚存余额，不允许销户操作”
     *   ○ 如果账户没有钱，则把当前账户对象，从系统的集合中删除，完成销户操作
     * */
    private boolean deleteAccount() {
        System.out.println("==进行注销操作==");
        while (true){
            //确认是否需要注销用户，让用户输入Y或者N
            System.out.println("请问是否确认注销用户： Y/N");
            String choice=sc.next();
            switch (choice){
                default:
                    System.out.println("无效输入，请重新输入");
                    break;
                case "Y":
                    if(loginAccount.getMoney()==0){
                        accounts.remove(loginAccount);
                        System.out.println("用户注销成功");
                        return true;
                    }else{
                        System.out.println("当前用户还有余额，无法注销");
                        return false;
                    }

                case "N":
                    System.out.println("账户已经保留");
                    return false;

            }
        }

    }

    /**
     * 把修改密码的功能单独抽取为一个方法（updatePassword()方法）
     * ● 用户输入当前密码
     * ● 认证当前密码是否正确
     *   ○ 如果认证密码错误，提示“您当前输入的密码不正确”；重新输入密码，再次认证密码是否正确。
     * ● 如果认证密码正确，开始修改密码，修改密码时需要用户输入2次新密码
     * ● 判断两次密码是否一致
     *   ○ 如果两次密码一致，就将新密码设置给当前账户对象，密码修改成功
     *   ○ 如果两次密码不一致，则给出提示“两次密码录入不一致”；重新输入新密码，并确认密码
     * */
    private void updatePassword() {
        System.out.println("==账户密码的修改界面==");
        while (true){
            System.out.println("请输入当前用户的密码");
            String passWord=sc.next();
            //认证当前密码是否正确
            if(loginAccount.getPassword().equals(passWord)){
                //开始修改密码
                System.out.println("请输入新的密码");
                String newPassword=sc.next();
                System.out.println("请再次输入xin密码");
                String newPasswordSecond=sc.next();

                //对两次输入的密码进行比较
                if(newPassword.equals(newPasswordSecond)){
                    System.out.println("修改密码成功");
                    loginAccount.setPassword(newPassword);
                    return;
                }else {
                    System.out.println("两次输入的新密码不一致，请重新设置新密码");
                }
            }else{
                System.out.println("您输入的密码不正确，请再次重新输入");
            }
        }
    }

    //转账操作
    /**
     * 转账即把A账户的钱转到B账户中，将转账操作单独抽取为一个方法（transferMoney()方法）
     * ● 转账前提：
     *   ○ 判断系统中是否存在其他账户
     *   ○ 判断自己的账户中是否有钱
     * ● 转账：
     *   ○ 输入对方卡号，判断对方卡号是否正确
     *   ○ 如果卡号正确，就继续让用户输入姓氏， 并判断这个姓氏是否正确
     *     ■ 如果姓氏不正确，给出提示“对不起，姓氏有误，转账失败”
     *     ■ 如果姓氏正确，继续判断这个转账金额是否超过自己的余额
     *       ● 如果转账金额超过余额，给出提示“对不起，余额不足，转账失败！”
     *   ○ 如果对方卡号存在、姓氏匹配、余额足够，就完成真正的转账操作
     *     ■ 获取当前自己账户的余额，减去转账金额，就可以得到自己账户新的余额，并将新的余额，设置给当前账户
     *     ■ 并且获取对方的账户余额，加上转账金额，就可以得到对方账户新的余额，并将新的余额，设置给对方账户
     *     ■ 给出提示“转账成功了”
     * */
    private void transferMoney() {
        System.out.println("==用户转账==");
        //判断系统中有几个账户
        if(accounts.size()<2){
            System.out.println("当前系统只有一个用户，无法为其他用户转账");
            return;
        }
        //判断自己的账户中是否有钱
        if(loginAccount.getMoney()==0){
            System.out.println("账户余额不足");
        }
        //输入对方卡号，确认对方卡号是否正确
        while (true){
            System.out.println("请输入对方的卡号");
            String tranBankCardID= sc.next();
            Account acc = isExist(tranBankCardID);
            if (acc==null){
                System.out.println("卡号输入错误，请重新输入");
            }else{
                //对姓氏进行判断
                String name = "*"+"*"+acc.getName().substring(acc.getName().length()-1);
                System.out.println("请您输入"+name+"的姓氏");
                String firstName= sc.next();
                //判断姓氏是否正确
                if(acc.getName().startsWith(firstName)){
                    while (true){
                        System.out.println("请输入转给对方的金额");
                        double tranMoney=sc.nextDouble();
                        //与当前用户登录的余额判断
                        if (loginAccount.getMoney()>tranMoney){
                            System.out.println("转账成功");
                            //更新自己账户的余额
                            loginAccount.setMoney(loginAccount.getMoney()-tranMoney);
                            System.out.println("您的用户余额为："+loginAccount.getMoney());
                            //更新对方账户的余额
                            acc.setMoney(acc.getMoney()+tranMoney);
                            System.out.println("您给"+tranBankCardID+"转账"+tranMoney);
                            return;
                        }else {
                            System.out.println("转账失败");
                        }
                    }
                }else {
                    System.out.println("您输入的姓氏不正确");
                }

            }
        }
    }

    /**
     * 取款的功能封装成一个方法(getMoney()方法)，具体步骤如下：
     *  如果账户余额不足，提示“您的余额不足，你的账户余额是xxx元”
     *  如果余额充足，继续判断当前取款金额是否超过了每次限额
     *      如果超过限额，提示“每次只能取xxx限额的钱”
     *      如果不超过限额，则在当前余额上减去取钱的金额，得到新的余额并将新的余额设置给账户对象
     * */
    private void getMoney() {
        while (true){
            System.out.println("==进入取款功能==");
            System.out.println("请录入你要取款的金额为");
            double getMoney = sc.nextDouble();
            if (getMoney> loginAccount.getMoney()){
                System.out.println("您的余额不足，您的账户是"+loginAccount.getMoney()+"元");
            }else {
                if (getMoney> loginAccount.getLimit()){
                    System.out.println("超过限额，每次只能取"+loginAccount.getLimit());
                }else {
                    loginAccount.setMoney(loginAccount.getMoney()-getMoney);
                    System.out.println("取钱成功，您取走"+getMoney+"余额为"+loginAccount.getMoney());
                    break;
                }
            }
        }

    }

    /**
     * 存款功能封装为一个方法（saveMoney()方法），具体步骤如下：
     *   键盘录入要存入的金额
     *   在原有余额的基础上，加上存入金额，得到新的余额
     *   再将新的余额设置给当前账户对象
     * */
    private void saveMoney() {
        System.out.println("==进入存款功能==");
        System.out.println("==请输入您要存款的金额==");
        double money = sc.nextDouble();
        loginAccount.setMoney(loginAccount.getMoney()+money);
        System.out.println("您已经存入"+money+"当前账户余额是"+loginAccount.getMoney());
    }

    //展示用户信息
    private void showLoginAccount() {
        System.out.println("用户基本信息展示"+loginAccount.getName());
        System.out.println("卡号"+loginAccount.getBankCardID());
        System.out.println("姓名"+loginAccount.getName());
        System.out.println("身份证号"+loginAccount.getIdCard());
        System.out.println("余额"+loginAccount.getMoney());
        System.out.println("取款限额"+loginAccount.getLimit());
    }

    //判断卡号是否已经存在
    private Account isExist(String cardID){
        for (int i = 0; i < accounts.size(); i++) {
            //遍历账户对象
            Account ac =accounts.get(i);
            if (ac.getIdCard().equals(cardID)){
                return ac;
            }
        }
        return null;
    }

    //生成一个卡号
    private  String createCardID(){
        while (true){
            String cardID = "";
            Random rd = new Random();
            for (int i = 0; i < 8; i++) {
                int num= rd.nextInt(0,10);
                cardID+=num;
            }
            //判断随机数生成的卡号是否重复
            Account a =isExist(cardID);
            if(a==null){
                return cardID;
            }
        }
    }



    //开户功能  卡号和账户余额暂时不封装
    public void creatAccount(){
        //创建一个账户对象，用于封装用户的信息
        Account account = new Account();
        System.out.println("============正在进行开户操作============");

        System.out.println("请输入真实姓名");
        String name = sc.next();
        account.setName(name);

        while (true){
            System.out.println("请输入身份证号码");
            String id =sc.next();

            if (id.length() == 18){
                account.setIdCard(id);
                break;
            }else{
                System.out.println("无效输入，请重新输入18位身份证");
            }
        }

        //录入卡号
        String cadID=createCardID();
        account.setIdCard(cadID);

        //录入密码
        while (true){
            System.out.println("请输入密码");
            String passWord=sc.next();
            System.out.println("请再次输入密码");
            String passWord1= sc.next();
            if(passWord1.equals(passWord)){
                account.setPassword(passWord1);
                break;
            }else{
                System.out.println("两次密码输入不正确，请重新输入");
            }
        }

        //设置限制额
        System.out.println("请输入取款限额");
        double limit= sc.nextDouble();
        account.setLimit(limit);

        //把账户对象存入账户集合中
        accounts.add(account);
        System.out.println("恭喜你成为"+account.getName()+"开户成功，已成为建行用户。卡号是"+account.getIdCard());
    }




}
