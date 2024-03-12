package zdenko;

import java.time.LocalDate;

public class Zaznam {
    private String text;
    private LocalDate datum;

    public Zaznam(String text, LocalDate datum) {
        this.text = text;
        this.datum = datum;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
}
