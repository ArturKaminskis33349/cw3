import java.util.Objects;

public class SklepKomputerowy {
    private Produkt[] produkty;
    private Klient[] klienci;
    private Zamowienie[] zamowienia;
    private int liczbaProduktow=0, liczbaKlientow=0, liczbaZamowien=0;
    public void dodajProdukt(Produkt produkt) {
        liczbaProduktow++;
        produkty[liczbaProduktow-1] = produkt;
    }
    public void dodajKlienta(Klient klient) {
        liczbaKlientow++;
        klienci[liczbaKlientow-1] = klient;
    }
    public Zamowienie utworzZamowienie(Klient klient, Produkt[] produkty, int[] ilosci) {
        liczbaZamowien++;
        Zamowienie z = new Zamowienie();
        z.setKlient(klient);
        z.setProdukty(produkty);
        z.setIlosc(ilosci);
        zamowienia[liczbaZamowien-1] = z;
        aktualizujStanMagaynowy(z);
        return z;
    }
    public void aktualizujStanMagaynowy(Zamowienie zamowienie) {
        for(Produkt produkt : zamowienie.getProdukty()) {
            produkt.setIloscWMagazynie(produkt.getIloscWMagazynie()-1);
        }
    }
    public void zmienStatusZamowienia(int idZamowienia, String nowyStatus){
        zamowienia[idZamowienia].setStatus(nowyStatus);
    }
    public void wyswietlProduktyWKategorii(String kategoria){
        for(Produkt produkt : produkty) {
            if(Objects.equals(produkt.getKategoria(), kategoria)) {
                produkt.wyswietlInformacje();
            }
        }
    }
    public void wyswietlZamowieniaKlienta(int idKlienta){
        for(Zamowienie z : zamowienia){
            if(z.getKlient().getId() == idKlienta) {
                z.wyswietlSzczegoly();
            }
        }
    }
}
