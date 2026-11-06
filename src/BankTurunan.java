public class BankTurunan {

    // main = titik awal program dijalankan
    public static void main(String[] args) {

        // Membuat objek dari class turunan
        Tabungan tabungan = new Tabungan("101", "Ani", 1_000_000, 2.5);   // Tabungan Ani, saldo 1.000.000, bunga 2.5%
        Giro giro = new Giro("201", "Budi", 200_000, 500_000);            // Giro Budi, saldo 200.000, overdraft 500.000
        // (tanda _ di angka hanya pemisah agar mudah dibaca; 1_000_000 = 1000000)

        System.out.println("========== REKENING AWAL ==========");
        tabungan.cetakInfo();    // cetakInfo() versi Tabungan (override)
        giro.cetakInfo();        // cetakInfo() versi Giro (override)
        System.out.println();

        System.out.println("============ TRANSAKSI ============");

        // 1) Tabungan tarik 1.500.000 -> pakai tarik() WARISAN Rekening -> saldo tidak cukup -> Ditolak
        cetakHasil("Tabungan tarik 1.500.000", tabungan.tarik(1_500_000));

        // 2) Giro tarik 500.000 -> pakai tarik() OVERRIDE Giro -> 200.000 - 500.000 = -300.000 (masih dalam batas) -> Berhasil
        cetakHasil("Giro tarik 500.000", giro.tarik(500_000));

        // 3) Giro tarik 300.000 -> -300.000 - 300.000 = -600.000 (melewati -500.000) -> Ditolak
        cetakHasil("Giro tarik 300.000", giro.tarik(300_000));

        // 4) Giro setor 100.000 -> pakai setor() WARISAN Rekening -> -300.000 + 100.000 = -200.000 -> Berhasil
        cetakHasil("Giro setor 100.000", giro.setor(100_000));

        // 5) Tambah bunga tabungan -> 2.5% x 1.000.000 = 25.000, ditambahkan lewat setor()
        int bunga = tabungan.tambahBunga();                              // simpan nilai bunga yang dikembalikan
        System.out.printf("%-26s: %s%n", "Bunga tabungan", Rekening.formatRupiah(bunga));   // static: dipanggil lewat nama class
        System.out.println();

        System.out.println("========== REKENING AKHIR =========");
        tabungan.cetakInfo();    // saldo akhir Ani: Rp1.025.000
        giro.cetakInfo();        // saldo akhir Budi: Rp-200.000
    }

    // Method bantu untuk mencetak satu baris hasil transaksi.
    // tarik() dan setor() mengembalikan boolean: true = Berhasil, false = Ditolak.
    // %-26s = keterangan rata kiri selebar 26 karakter, supaya tanda ":" sejajar.
    private static void cetakHasil(String keterangan, boolean berhasil) {
        System.out.printf("%-26s: %s%n", keterangan, berhasil ? "Berhasil" : "Ditolak");
    }
}