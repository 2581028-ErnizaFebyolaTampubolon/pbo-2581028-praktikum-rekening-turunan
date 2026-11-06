public class Rekening {
    private String nomor;
    private String pemilik;
    protected int saldo;

    public Rekening(String nomor, String pemilik, int saldoAwal) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldoAwal;
    }

    public String getNomor() {
        return nomor;
    }

    public String getPemilik() {
        return pemilik;
    }

    public int getSaldo() {
        return saldo;
    }

    public boolean setor(int jumlah) {
        if (jumlah <= 0) {
            System.out.println("Setor gagal: jumlah harus lebih dari 0.");
            return false;
        }
        saldo += jumlah;
        System.out.println("Setor " + formatRupiah(jumlah) + " berhasil. Saldo: " + formatRupiah(saldo));
        return true;
    }

    public boolean tarik(int jumlah) {
        if (jumlah <= 0) {
            System.out.println("Tarik gagal: jumlah harus lebih dari 0.");
            return false;
        }
        if (jumlah > saldo) {
            System.out.println("Tarik " + formatRupiah(jumlah) + " gagal: saldo tidak cukup. Saldo: " + formatRupiah(saldo));
            return false;
        }
        saldo -= jumlah;
        System.out.println("Tarik " + formatRupiah(jumlah) + " berhasil. Saldo: " + formatRupiah(saldo));
        return true;
    }

    protected static String formatRupiah(int angka) {
        String tanda = angka < 0 ? "-" : "";
        return tanda + "Rp" + String.format("%,d", Math.abs((long) angka)).replace(',', '.');
    }

    public void cetakInfo() {
        System.out.println("Nomor   : " + nomor);
        System.out.println("Pemilik : " + pemilik);
        System.out.println("Saldo   : " + formatRupiah(saldo));
    }
}