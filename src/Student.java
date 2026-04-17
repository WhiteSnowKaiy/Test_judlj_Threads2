import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class Student extends Thread {
    private static Logger LOG = LoggerFactory.getLogger(Student.class);

    private Sklad sklad;

    private String name;
    private int kolace_goal = 3;

    @Override
    public void run() {
        LOG.info(name + " Začal jíst ");
        for (int i = 1; i <= kolace_goal; i++) {
            if (sklad.getPocet_kolacu()>0) {
                try {
                    decision(diceThrow());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else  {
                LOG.error(name + ": Chybi kolace :(");
                Thread.currentThread().interrupt();
                return;
            }
        }
        LOG.info(name + ": Napapal jsem se");
    }

    private void decision(int cislo) throws InterruptedException {
        LOG.info(name + ": Cislo: " + cislo);
        sklad.addPocet_pokusu(1);
        switch (cislo) {
            case 1: default_case();
            break;
            case 2: kolac_navic();
            break;
            case 3: spanek();
            break;
            case 4: default_case();
            break;
            case 5: pridej_kolac();
            break;
            case 6: nic_se_nestane();
            break;
        }
    }

    private void nic_se_nestane(){
        LOG.info(name + ": Nic se nestane, pokracuji dale");
    }

    private void pridej_kolac() {
        sklad.addKolac(1);
        LOG.info(name + ": Pridal jsem kolac");
    }

    private void spanek() throws InterruptedException {
        Thread.sleep(5000);
        LOG.info(name + ": Vyspinkal jsem se");
    }

    private void kolac_navic() {
        kolace_goal++;
        LOG.info(name + ": Musim snist vic kolacu");
    }

    private void default_case() throws InterruptedException {
        if (sklad.getPocet_kolacu() <= 0){
            LOG.info(name + ": Pekarna je prazdna, studenti zustali hladovi.");
            return;
        }
        sklad.removeKolac(1);
        Thread.sleep(3000);
        LOG.info(name + ": Spapal jsem kolac");
    }

    private int diceThrow(){
        return new Random().nextInt(1, 7);
    }

    public Student(Sklad sklad, String name) {
        this.sklad = sklad;
        this.name = name;
    }
}
