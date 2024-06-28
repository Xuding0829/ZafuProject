package cn.java.emp;

import java.util.Objects;

public class Empp {
    private int id;
    private String name;
    private String job;
    private String salary;

    public Empp() {}

    public Empp(int id, String name, String job, String salary) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Empp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empp empp = (Empp) o;
        return id == empp.id && Objects.equals(name, empp.name) && Objects.equals(job, empp.job) && Objects.equals(salary, empp.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, job, salary);
    }
}
