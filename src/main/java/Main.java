import CarShop.CarNotFoundException;
import CarShop.Store;
import Mail.MailSender;
import Mail.MyAppender;
import Mail.MyLayout;
import models.Car;
import org.apache.log4j.Appender;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Created by sa on 08.02.17.
 */

public class Main {

    static {
        DOMConfigurator.configure("src/main/resources/log4j.xml");
    }

    public static void main(String[] args) throws CarNotFoundException {
        Store store = new Store();
        //logger.trace("store created");
        store.createCar(500000, "kia-rio",
                "B146AA");
        store.createCar(500000, "kia-rio2",
                "B146AB");
        store.createCar(500000, "kia-rio3",
                "B146AC");

       /* store.sellCar("kia-reva??? reva??? shta???",
                "Jhon",
                "Konner" ,
                "+79126241898");*/

        //store.save();

    }
}
