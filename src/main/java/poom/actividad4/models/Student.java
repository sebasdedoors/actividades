package poom.actividad4.models;

/**
 * La clase Student representa a un estudiante con atributos básicos como nombre, edad, matrícula y curso.
 */

public class Student {
    private String name;
    private int age;
    private int tuition;
    private String course;

    /**
     *  @param name   Nombre del estudiante.
     * @param age    Edad del estudiante.
     * @param tuition Matrícula del estudiante.
     * @param course Curso en el que está inscrito el estudiante.
     * @throws IllegalArgumentException si alguno de los parámetros no cumple con los criterios establecidos.
     */

     public Student(String name, int age, int tuition, String course) {
        setName(name);
        setAge(age);
        setToition(tuition);
        setCourse(course);
    }

    /**
     * Obtiene el nombre del estudiante.
     * @return Nombre del estudiante.
     */

     public String getName() {
        return name;
    }

    /**
     * Obtiene la edad del estudiante.
     * @return Edad del estudiante.
     */

    public int getAge() {
        return age;
    }

    /**
     * Obtiene la matrícula del estudiante.
     * @return Matrícula del estudiante.
     */

    public int getToition() {
        return tuition;
    }

    /**
     * Obtiene el curso del estudiante.
     * @return Curso del estudiante.
     */

    public String getCourse() {
        return course;
    }

    /**
     * Establece el nombre del estudiante.
     * @param name Nombre del estudiante.
     * @throws IllegalArgumentException si el nombre es nulo, vacío o contiene números.
     */

     public void setName(String name){
        if (name == null || name.trim().isEmpty() || name.matches(".*\\d.*")) {
            throw new IllegalArgumentException("El nombre no puede contener números.");
    }
        this.name = name;
    }

    /**
     * Establece la edad del estudiante.
     * @param age Edad del estudiante.
     * @throws IllegalArgumentException si la edad es negativa.
     */

     public void setAge(int age){
        if (age < 0 ){
            throw new IllegalArgumentException("la edad no puede ser 0. ");
        }
        this.age = age;
    }

    /**
     * Establece la matrícula del estudiante.
     * @param tuition Matrícula del estudiante.
     * @throws IllegalArgumentException si la matrícula es negativa.
     */

     public void setToition(int tuition){
        if (tuition < 0){
            throw new IllegalArgumentException("La matrícula no puede ser negativa.");
        }
        this.tuition = tuition;
    }

    /**
     * Establece el curso del estudiante.
     * @param course Curso del estudiante.
     * @throws IllegalArgumentException si el curso es nulo.
     */

     public void setCourse(String course){
        if(course == null){
            throw new IllegalArgumentException("El curso no puede contener números.");
        }
        this.course = course;
    }
}

