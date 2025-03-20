import java.util.Objects;

public class SklepKomputerowy {
    private final Produkt[] produkty = new Produkt[20];
    private final Klient[] klienci = new Klient[20];
    private final Zamowienie[] zamowienia = new Zamowienie[20];
    private int liczbaProduktow = 0, liczbaKlientow = 0, liczbaZamowien = 0;

    public void dodajProdukt(Produkt produkt) {
        liczbaProduktow++;
        produkty[liczbaProduktow - 1] = produkt;
    }

    public void dodajKlienta(Klient klient) {
        liczbaKlientow++;
        klienci[liczbaKlientow - 1] = klient;
    }

    public Zamowienie utworzZamowienie(Klient klient, Produkt[] produkty, int[] ilosci) {
        liczbaZamowien++;
        Zamowienie z = new Zamowienie();
        z.setKlient(klient);
        z.setProdukty(produkty);
        z.setIlosc(ilosci);
        z.setDataZamowienia(java.time.LocalDate.now().toString());
        z.setStatus("Nowe");
        z.obliczWartoscZamowienia();
        zamowienia[liczbaZamowien - 1] = z;
        return z;
    }

    public void aktualizujStanMagaynowy(Zamowienie zamowienie) {
        int[] ile = zamowienie.getIlosc();
        Produkt[] produkty = zamowienie.getProdukty();
        for (int x = 0; x < produkty.length; x++) {
            if (produkty[x] != null) {
                produkty[x].setIloscWMagazynie(produkty[x].getIloscWMagazynie() - ile[x]);
            }
        }
    }

    public void zmienStatusZamowienia(int idZamowienia, String nowyStatus) {
        zamowienia[idZamowienia].setStatus(nowyStatus);
    }

    public void wyswietlProduktyWKategorii(String kategoria) {
        if (produkty == null || produkty.length == 0) {
            System.out.println("Brak dostępnych produktów.");
            return;
        }
        for (Produkt produkt : produkty) {
            if (produkt != null && produkt.getKategoria().equals(kategoria)) {
                produkt.wyswietlInformacje();
            }
        }
    }

    public void wyswietlZamowieniaKlienta(int idKlienta) {
        for (Zamowienie z : zamowienia) {
            if (z != null && z.getKlient().getId() == idKlienta) {
                z.wyswietlSzczegoly();
            }
        }
    }
}