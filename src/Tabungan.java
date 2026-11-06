public class Tabungan extends Rekening {
    private double bungaPersen;

    public Tabungan(String nomor, String pemilik, int saldoAwal, double bungaPersen) {
        super(nomor, pemilik, saldoAwal);
        this.bungaPersen = bungaPersen;
    }

    // Menghitung bunga, menambahkannya LEWAT setor (bukan saldo +=), lalu mengembalikan besar bunga
    public int tambahBunga() {
        int bunga = (int) (saldo * bungaPersen / 100);
        setor(bunga);
        return bunga;
    }

    @Override
    public void cetakInfo() {
        super.cetakInfo();
        System.out.println("Jenis   : Tabungan (bunga " + bungaPersen + "%)");
    }
}