
import java.util.Scanner;

public class StudentView {
    Scanner sc=new Scanner(System.in);
    //count 记录学员的数量
    int count=0;
    //使用数组作为变量存储对象
    Student[] students= new Student[50];
    Student[] newStudent=new Student[50];

    public void studentShow(){
        while (true){
            System.out.println("-----------------欢迎使用学生管理系统-----------------");
            System.out.println("1、添加学生");
            System.out.println("2、修改学生");
            System.out.println("3、删除学生");
            System.out.println("4、查看学生");
            System.out.println("5、退出");
            System.out.println("-----------------请输入您的选择-----------------");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("添加学生");
                    addStudent();
                    break;
                case 2:
                    System.out.println("修改学生");
                    upStudentData();
                    break;
                case 3:
                    System.out.println("删除学生");
                    deletStudent();
                    break;
                case 4:
                    System.out.println("查看学生");
                    checkStudent();
                    break;
                case 5:
                    System.out.println("退出");
                    return;
            }
        }
    }

    private void checkStudent() {
        System.out.println("学号"+"\t"+"姓名"+"\t"+"年龄"+"\t"+"性别");
        /*
          排序是为了防止:删除完之后再重新添加之前删除的序号对应的学生而发生乱序的情况
        */
        for (int j = 0; j < count-1; j++) {
            for (int i = 0; i < count-1-j; i++) {
                if (students[i].getSutdentId()>students[i+1].getSutdentId()){
                    Student temp = students[i];
                    students[i] = students[i+1];
                    students[i+1] = temp;
                }
            }
        }


        //如果count为0(证明没有添加过学生),证明没有学生
        if (count==0){
            System.out.println("待开班.........");
        }else{
            for (int i = 0; i < count; i++) {
                System.out.println(students[i].getSutdentId()+"\t"+students[i].getStudentName()+"\t"+students[i].getStudentAge()+"\t"+students[i].getStudentSex());
            }
        }


    }

    private void deletStudent() {
        //1.输入要删除的学生学号
        System.out.println("请您输入要删除的学生学号:");
        int id = sc.nextInt();
        //2.根据id查询学生对应的索引位置
        int removeIndex = ArrayUtils.findIndexById(students, id, count);

        //复制被删除元素前面一部分,再复制被删除元素后面一部分
        System.arraycopy(students,0,newStudent,0,removeIndex);
        System.arraycopy(students,removeIndex+1,newStudent,removeIndex,students.length-removeIndex-1);

        //将新数组的地址值给老数组
        students = newStudent;
        //删除完之后count--
        count--;
        System.out.println("删除成功");
    }

    private void upStudentData() {
        if(count==0){
            System.out.println("当前中没有学生信息，请添加学生信息");
        }else{
            System.out.println("请输入该学员的学员号");
            int inputId= sc.nextInt();
            System.out.println("请对学员姓名修改");
            String inputName=sc.next();
            System.out.println("请对学员的性别进行修改");
            String inputSex = sc.next();
            System.out.println("请对学员年龄进行修改");
            int inputAge=sc.nextInt();
            Student student=new Student(inputId,inputSex,inputAge,inputName);
            newStudent[count]=student;


        }

    }

    private void addStudent() {
        System.out.println("请输入学生的学号");
        int id=sc.nextInt();
        System.out.println("请输入学生的姓名");
        String name= sc.next();
        System.out.println("请输入学生的年龄");
        int age= sc.nextInt();
        System.out.println("请输入学生的性别");
        String sex=sc.next();
        Student student= new Student(id,name,age,sex);
        students[count]=student;
        count++;
        System.out.println("添加成功");
    }
}
