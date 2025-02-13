package poom.actividad4.models;

import poom.actividad4.models.Teacher;

public class Course {
    private String name;
    private String topic;
    private int credit;
    private Teacher teacher;

    public Course(String name, String topic, int credit){
        setName(name);
        setTopic(topic);
        setCredit(credit);
    }

    public String getName(){return name;}
    public int getCredit(){return credit;}
    public String getTopic(){return topic;}
    public Teacher getTeacher(){return teacher;}

    public void setName(String name){
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("El nombre no puede quedar vacio.");
        }else{
            this.name = name;
        }
    }

    public void setTopic(String topic){
        if(topic == null || topic.isEmpty()){
            throw new IllegalArgumentException("El tema no puede quedar vacio.");
        }else{
            this.topic = topic;
        }
    }

    public void setCredit(int credit){
        if(credit == 0){
            throw new IllegalArgumentException("Los creditos deben de tener un minimo de 1");
        }else{
            this.credit = credit;
        }
    }

    public void setTeacher(Teacher teacher){
        if(teacher == null){
            throw new IllegalArgumentException("El nombre del profesor no puede estar vacio.");
        }else{
            this.teacher = teacher;
        }
    }

}
