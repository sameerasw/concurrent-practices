void main() {
    Plate plate = new Plate(null);
    int numberOfServings = 10;

    Runnable mom = new Mother(plate, numberOfServings);
    Runnable child = new Child(plate, numberOfServings);

    Thread momThread = new Thread(mom, "mom");
    Thread childThread = new Thread(child, "child");

    momThread.start();
    childThread.start();
}
