package pl.edu.agh.to.lab3;

public class Prisoner {
    private int CURRENT_YEAR = 2014;

    private int judgementYear;

    private int senteceDuration;

    private String pesel;

    public String name;

    public String surname;

    public Prisoner(String name, String surname, String pesel, int judgementYear, int sentenceDuration) {
        this.name = name;
        this.surname = surname;
        this.judgementYear = judgementYear;
        this.senteceDuration = sentenceDuration;
    }

    public boolean czyMoglbyEwentualnieBycPodejrzany() {
        return judgementYear + senteceDuration >= CURRENT_YEAR;
    }
}
