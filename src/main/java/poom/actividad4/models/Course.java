package poom.actividad4.models;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private String topic;
    private int credit;

    public Course(String name, String topic, int credit){
        setName(name);
        setTopic(topic);
        setCredit(credit);
    }

    public String getName(){return name;}
    public int getCredit(){return credit;}
    public String getTopic(){return topic;}

    public void setName(String name){
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("El nombre no puede quedar vacio.");
        }else{
            this.name = name;
        }
    }

    public void setTopic(String topic){
        
    }

    public void setCredit(int credit){
        if(credit == 0){
            throw new IllegalArgumentException("Los creditos deben de tener un minimo de 1");
        }else{
            this.credit = credit;
        }
    }

}
