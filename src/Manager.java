import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Manager {
    private static Logger LOG = LoggerFactory.getLogger(Manager.class);
    private Sklad sklad;

    public void launch() throws InterruptedException {
        LOG.info("Vytvarim studenty");
        Student s1 = new  Student(sklad, "Marek");
        Student s2 = new  Student(sklad, "Petr");
        Student s3 = new  Student(sklad, "Karel");
        Student s4 = new  Student(sklad, "Honza");
        Student s5 = new  Student(sklad, "Jirka");

        LOG.info("Zapinam studenty");
        s1.start();
        s2.start();
        s3.start();
        s4.start();
        s5.start();

        s1.join();
        s2.join();
        s3.join();
        s4.join();
        s5.join();

        LOG.info(""); // Empty lines, nevím jak tu napsat zpětný lomítko pro new line char xddd
        LOG.info("");
        LOG.info("Studenti provedly " + sklad.getPocet_pokusu() + " pokusu");
        LOG.info("Zbylo " + sklad.getPocet_kolacu() + " susenek");

    }

    Manager(Sklad s) {
        this.sklad = s;
    }
}
