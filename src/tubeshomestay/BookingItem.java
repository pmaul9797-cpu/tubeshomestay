package tubeshomestay;

public class BookingItem {

    private int id;
    private int idHomestay;
    private int idOwner;
    private String namaHomestay;
    private String namaPemesan;
    private String tanggalCheckIn;
    private String tanggalCheckOut;
    private int jumlahMalam;
    private double totalHarga;

    public BookingItem(int id, int idHomestay, int idOwner, String namaHomestay,
            String namaPemesan, String tanggalCheckIn, String tanggalCheckOut,
            int jumlahMalam, double totalHarga) {
        this.id = id;
        this.idHomestay = idHomestay;
        this.idOwner = idOwner;
        this.namaHomestay = namaHomestay;
        this.namaPemesan = namaPemesan;
        this.tanggalCheckIn = tanggalCheckIn;
        this.tanggalCheckOut = tanggalCheckOut;
        this.jumlahMalam = jumlahMalam;
        this.totalHarga = totalHarga;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getIdHomestay() { return idHomestay; }
    public int getIdOwner() { return idOwner; }
    public String getNamaHomestay() { return namaHomestay; }
    public String getNamaPemesan() { return namaPemesan; }
    public String getTanggalCheckIn() { return tanggalCheckIn; }
    public String getTanggalCheckOut() { return tanggalCheckOut; }
    public int getJumlahMalam() { return jumlahMalam; }
    public double getTotalHarga() { return totalHarga; }
}