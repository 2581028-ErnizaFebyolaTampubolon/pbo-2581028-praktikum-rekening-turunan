public class Tabungan extends Rekening { //"extends Rekening" artinya Tabungan adalah TURUNAN (subclass / child) dari Rekening.
    private double bungaPersen; //besar bunga dalam persen

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

    @Override //Mengganti method induk. Kalau nama method salah ketik, compiler langsung protes
    public void cetakInfo() {
        super.cetakInfo(); // di dalam override	: Menjalankan versi induk dulu, lalu menambah keterangan sendiri
        System.out.println("Jenis   : Tabungan (bunga " + bungaPersen + "%)");
    }
}