package poom.actividad4.models;

import java.util.ArrayList;

public class Teacher {
    private String name;
    private double salary;
    private double payroll;
    public ArrayList<Subject> subjects;


    public Teacher(String name, double salary, double payroll) {
        setName(name);
        setSalary(salary);
        setPayroll(payroll);
        this.subjects = new ArrayList<>();  
    }

    public String getName(){return name;}
    public double getSalary(){return salary;}
    public double getPayroll(){return payroll;}

    public void setName(String name){
        if(name.isEmpty() || name == null){
            throw new IllegalArgumentException("El nombre no puede quedarse en blanco.");
        }else{
            this.name = name;
        }
    }

    public void setSalary(double salary){
        if(salary == 0){
            throw new IllegalArgumentException("El salario debe ser minimo de 1.00");
        }else{
            this.salary = salary;
        }
    }

    public void setPayroll(double payroll){
        if(payroll == 0){
            throw new IllegalArgumentException("La nomina debe de ser de almenos de 1.00");
        }else{
            this.payroll = payroll;
        }
    }

    public void setSubjects(ArrayList<Subject> subjects){
        if(subjects == null || subjects.isEmpty()){
            throw new IllegalArgumentException("El nombre de la materia no puede quedarse en blanco.");
        }else{
            this.subjects = subjects;
            subjects.addAll(subjects);
        }
    }

    public ArrayList<Subject> getSubjects(){
        return subjects;
    }
}
