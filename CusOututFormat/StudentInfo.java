package com.CusOututFormat;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class StudentInfo implements WritableComparable<StudentInfo> {
    private String name;
    private int score;




    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(name);
        dataOutput.writeInt(score);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        name= dataInput.readUTF();
        score= dataInput.readInt();
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    //无参构造方法
    public StudentInfo() {
    }

    //有参构造方法
    public StudentInfo(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    @Override
    public int compareTo(StudentInfo o) {
        if(this.score>o.score){
            return  -1;
        }else if (this.score<o.score){
            return  1;
        }else {
            return 0;
        }
    }
}
