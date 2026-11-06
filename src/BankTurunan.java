public class BankTurunan {
    public static void main(String[] args) {
        System.out.println("=== Praktikum Rekening Turunan ===");
        System.out.println("Erniza Febyola Tampubolon - 2581028");
        System.out.println();

        Tabungan tabungan = new Tabungan("101", "Ani", 1_000_000, 2.5);
        Giro giro = new Giro("201", "Budi", 200_000, 500_000);

        System.out.println("--- Data awal ---");
        tabungan.cetakInfo();
        System.out.println();
        giro.cetakInfo();
        System.out.println();

        System.out.println("--- Transaksi ---");
        System.out.print("Tabungan 101 | ");
        tabungan.tarik(1_500_000);

        System.out.print("Giro 201     | ");
        giro.tarik(500_000);

        System.out.print("Giro 201     | ");
        giro.tarik(300_000);

        System.out.print("Giro 201     | ");
        giro.setor(100_000);

        System.out.print("Tabungan 101 | Tambah bunga -> ");
        int bunga = tabungan.tambahBunga();
        System.out.println("Bunga yang ditambahkan: " + Rekening.formatRupiah(bunga));
        System.out.println();

        System.out.println("--- Data akhir ---");
        tabungan.cetakInfo();
        System.out.println();
        giro.cetakInfo();
    }
}