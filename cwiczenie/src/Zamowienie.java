public class Zamowienie {
    private int id;
    private Klient klient;
    private Produkt[] produkty;
    private int[] ilosc;
    private String dataZamowienia;
    private String status;
    private double wartosc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public Produkt[] getProdukty() {
        return produkty;
    }

    public void setProdukty(Produkt[] produkty) {
        this.produkty = produkty;
    }

    public int[] getIlosc() {
        return ilosc;
    }

    public void setIlosc(int[] ilosc) {
        this.ilosc = ilosc;
    }

    public String getDataZamowienia() {
        return dataZamowienia;
    }

    public void setDataZamowienia(String dataZamowienia) {
        this.dataZamowienia = dataZamowienia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getWartosc() {
        return wartosc;
    }

    public void setWartosc(double wartosc) {
        this.wartosc = wartosc;
    }

    public void obliczWartoscZamowienia(){
        for(int i = 0; i<produkty.length; i++){
            wartosc = produkty[i].getCena()*ilosc[i];
        }
    }
    public void zastosujZnizke(){
        if(klient.isCzyStaly()){
            wartosc *= 0.9;
        }
    }

    public void wyswietlSzczegoly(){
        System.out.println("Id: "+id+", klient: "+klient+", produkty: "+produkty.length+", ilosc: "+ilosc.length+", data: "+dataZamowienia+", status: "+status+", wartosc: "+wartosc);
    }
}
