//账户类
/**
 * "账户" - 每个使用自动取款机的用户，都对应一个账户，也就是一个具体的账户对象，所以需要先设计一个账户类（Account类），
 * 封装用户对应的账户信息。账户类中包含用户的个人信息：姓名、身份证号、卡号、密码、账户余额、取款限额。
 * */
public class Account {
    private  String name;
    private  String idCard;
    private  String bankCardID;
    private  String password;
    private  double money;
    private  double limit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBankCardID() {
        return bankCardID;
    }

    public void setBankCardID(String bankCardID) {
        this.bankCardID = bankCardID;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Account() {
    }

    public Account(String name, double limit, double money, String password, String bankCardID, String idCard) {
        this.name = name;
        this.limit = limit;
        this.money = money;
        this.password = password;
        this.bankCardID = bankCardID;
        this.idCard = idCard;
    }

}
