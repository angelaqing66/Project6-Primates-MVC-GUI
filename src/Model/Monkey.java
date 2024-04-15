package Model;

import Model.Food;

/**
 * monkey class with charaters of monkeys
 */
public class Monkey {
    public String name;
    public String specie;
    public Sex sex;
    public String size;
    public double weight;
    public int age;
    public Food food;
    public boolean completeMedical;

    /**
     * constructor
     * @param name
     * @param specie
     * @param sex
     * @param size
     * @param weight
     * @param age
     * @param food
     */
    public Monkey(String name, String specie, Sex sex, String size, double weight, int age, Food food) {
        this.name = name;
        this.specie = specie;
        this.sex = sex;
        this.size = size;
        this.weight = weight;
        this.age = age;
        this.food = food;
    }

    /**
     * change medical status
     */
    protected void underMedivalAttention() {
        completeMedical = false;
    }

    /**
     * change medical status
     */
    protected void completeMedicalAttention() {
        completeMedical = true;
    }

}
