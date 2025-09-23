package com.example.test.StudentSystem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private long id;
    private String name;
    private String surname;
    private int exam;
    private String mark;

    public void calculateMark(){
        if (this.exam >= 90){
            this.mark = "A";
        } else if (this.exam >= 75){
            this.mark = "B";
        } else if (this.exam >= 60){
            this.mark = "C";
        } else if (this.exam >= 50){
            this.mark = "D";
        } else {
            this.mark = "F";
        }
    }
}
