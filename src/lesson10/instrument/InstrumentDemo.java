package lesson10.instrument;

public class InstrumentDemo {
    public static void main(String[] args) {
        Instrument[] instruments = {new Guitar(15), new Drum(4.5), new Trumpet(3.3),
                new Guitar(7), new Drum(7.7), new Trumpet(6.6)};

        for (Instrument instrument : instruments) {
            instrument.play();
        }
    }
}
