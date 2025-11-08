import com.sameerasw.tut07.Barista;
import com.sameerasw.tut07.Cafe;
import com.sameerasw.tut07.Customer;

void main() throws InterruptedException {
    Cafe cafe = new Cafe();

    Runnable customer = new Customer(cafe);
    Runnable barista = new Barista(cafe);

    Thread customerThread = new Thread(customer, "customer");
    Thread baristaThread = new Thread(barista, "barista");

    customerThread.start();
    baristaThread.start();

    customerThread.join();
    baristaThread.join();
}
