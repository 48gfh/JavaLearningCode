public class ArrayUtils {
    private ArrayUtils(){

    }

    public static int findIndexById(Student[] students,int id,int count){
        //遍历,查找
        for (int i = 0; i < count; i++) {
            if (id==students[i].getSutdentId()){
                return i;
            }
        }

        return -1;
    }
}
