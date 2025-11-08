public class Pizza {
    private String name;
    private int size;
    private int timeToBake;

    Pizza(String name, int size, int timeToBake) {
        this.name = name;
        this.size = size;
        this.timeToBake = timeToBake;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTimeToBake() {
        return timeToBake;
    }

    public void setTimeToBake(int timeToBake) {
        this.timeToBake = timeToBake;
    }
}
