public class Sklad {
    private int pocet_kolacu = 1;
    private int pocet_pokusu = 0;

    public synchronized void addPocet_pokusu(int cislo) {
        pocet_pokusu++;
    }

    public synchronized int getPocet_pokusu() {
        return pocet_pokusu;
    }

    public synchronized int getPocet_kolacu() {
        return pocet_kolacu;
    }

    public synchronized void removeKolac(int pocet_kolacu) {
        this.pocet_kolacu -= pocet_kolacu;
    }

    public synchronized void addKolac(int pocet_kolacu) {
        this.pocet_kolacu += pocet_kolacu;
    }

}
