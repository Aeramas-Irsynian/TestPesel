public class Osoba {
    String imie;
    String nazwisko;
    String pesel;

    Osoba (String imie, String nazwisko, String pesel) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = Pesel.checkPesel(pesel);
    }
}

