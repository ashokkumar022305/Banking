package ATM;

public class SignUp {
    static int idd=101;
    private int id;
    private String password;
    private String name;
    private int age;
    private int balance;

    SignUp(String password,String name,int age,int balance){
        this.id=idd++;
        this.password=password;
        this.name=name;
        this.age=age;
        this.balance=balance;
        System.out.println("Your Account number is :"+this.id);
    }

    public int getId() {return id;}
    public String getName() {return name;}
    public int getAge() {return age;}
    public String getPassword() {return password;}
    public int getBalance() {return balance;}

    public void setAge(int age) {this.age = age;}
    public void setName(String name) {this.name = name;}
    public void setPassword(String password) {this.password = password;}
    public void setBalance(int balance) {this.balance = balance;}

    public String toString(){
        return "Account number : "+id+"\nname : "+name+"\nage : "+age+"\nPassword : "+password+"\nBalance : "+balance;
    }
}
