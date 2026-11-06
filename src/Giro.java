// Praktikum Bab 10 - Rekening Turunan
// Nama : Erniza Febyola Tampubolon
// NIM  : 2581028

public class Giro extends Rekening {
    private int batasOverdraft;

    public Giro(String nomor, String pemilik, int saldoAwal, int batasOverdraft) {
        super(nomor, pemilik, saldoAwal);
        this.batasOverdraft = batasOverdraft;
    }

    // Giro boleh minus sampai -batasOverdraft, jadi tarik milik Rekening diganti
    @Override
    public boolean tarik(int jumlah) {
        if (jumlah <= 0) {
            System.out.println("Tarik gagal: jumlah harus lebih dari 0.");
            return false;
        }
        if (saldo - jumlah < -batasOverdraft) {
            System.out.println("Tarik " + formatRupiah(jumlah) + " gagal: melewati batas overdraft "
                    + formatRupiah(batasOverdraft) + ". Saldo: " + formatRupiah(saldo));
            return false;
        }
        saldo -= jumlah;
        System.out.println("Tarik " + formatRupiah(jumlah) + " berhasil. Saldo: " + formatRupiah(saldo));
        return true;
    }

    // Percobaan akses field private milik Rekening:
    // System.out.println(nomor);
    // Pesan error: java: nomor has private access in Rekening
    // (IntelliJ: 'nomor' has private access in 'Rekening')

    @Override
    public void cetakInfo() {
        super.cetakInfo();
        System.out.println("Jenis   : Giro (batas overdraft " + formatRupiah(batasOverdraft) + ")");
    }
}