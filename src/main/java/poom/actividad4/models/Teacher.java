package poom.actividad4.models;

import java.util.ArrayList;

/**
 * La clase Teacher representa a un profesor con atributos como nombre, salario y nómina.
 * Además, maneja una lista de materias que el profesor imparte.
 */

 public class Teacher {
    private String name;
    private double salary;
    private double payroll;
    public ArrayList<Subject> subjects;

    /**
     * @param name    Nombre del profesor.
     * @param salary  Salario del profesor.
     * @param payroll Nómina del profesor.
     */


     public Teacher(String name, double salary, double payroll) {
        setName(name);
        setSalary(salary);
        setPayroll(payroll);
        this.subjects = new ArrayList<>();  
    }

    /**
     * Obtiene el nombre del profesor.
     * @return Nombre del profesor.
     */

     public String getName(){return name;}

    /**
     * Obtiene el salario del profesor.
     * @return Salario del profesor.
     */

     public double getSalary(){return salary;}

    /**
     * Obtiene la nómina del profesor.
     * @return Nómina del profesor.
     */

     public double getPayroll(){return payroll;}

    /**
     * Establece el nombre del profesor.
     * @param name Nombre del profesor.
     * @throws IllegalArgumentException Si el nombre está vacío o es nulo.
     */

     public void setName(String name){
        if(name.isEmpty() || name == null){
            throw new IllegalArgumentException("El nombre no puede quedarse en blanco.");
        }else{
            this.name = name;
        }
    }

    /**
     * Establece el salario del profesor.
     * @param salary Salario del profesor.
     * @throws IllegalArgumentException Si el salario es 0.
     */

     public void setSalary(double salary){
        if(salary == 0){
            throw new IllegalArgumentException("El salario debe ser minimo de 1.00");
        }else{
            this.salary = salary;
        }
    }

    /**
     * Establece la nómina del profesor.
     * @param payroll Nómina del profesor.
     * @throws IllegalArgumentException Si la nómina es 0.
     */

     public void setPayroll(double payroll){
        if(payroll == 0){
            throw new IllegalArgumentException("La nomina debe de ser de almenos de 1.00");
        }else{
            this.payroll = payroll;
        }
    }

    /**
     * Establece la lista de materias del profesor.
     * @param subjects Lista de materias impartidas por el profesor.
     * @throws IllegalArgumentException Si la lista es nula o está vacía.
     */

     public void setSubjects(ArrayList<Subject> subjects){
        if(subjects == null || subjects.isEmpty()){
            throw new IllegalArgumentException("El nombre de la materia no puede quedarse en blanco.");
        }else{
            this.subjects = subjects;
            subjects.addAll(subjects);
        }
    }
    /**
     * Obtiene la lista de materias del profesor. 
     * @return Lista de materias.
     */

     public ArrayList<Subject> getSubjects(){
        return subjects;
    }

    

    
}

