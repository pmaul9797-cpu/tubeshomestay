package tubeshomestay;

public class HomestayItem {
    private int id;
    private int idOwner;
    private String nama;
    private String kategori;
    private String lokasi;
    private double harga;
    private double rating;
    private int jumlahKamar;
    private boolean fasilitasAc;
    private boolean fasilitasWifi;
    private boolean fasilitasWaterHeater;
    private String deskripsi;
    private String status;
    private String gambar;

    
    public HomestayItem(int id, int idOwner, String nama, String kategori, String lokasi, double harga, double rating, int jumlahKamar, boolean fasilitasAc, boolean fasilitasWifi, boolean fasilitasWaterHeater, String deskripsi, String status, String gambar) {
        this.id = id;
        this.idOwner = idOwner;
        this.nama = nama;
        this.kategori = kategori;
        this.lokasi = lokasi;
        this.harga = harga;
        this.rating = rating;
        this.jumlahKamar = jumlahKamar;
        this.fasilitasAc = fasilitasAc;
        this.fasilitasWifi = fasilitasWifi;
        this.fasilitasWaterHeater = fasilitasWaterHeater;
        this.deskripsi = deskripsi;
        this.status = status;
        this.gambar = gambar;
    }

    
    public HomestayItem(int id, int idOwner, String nama, String lokasi, double harga, String deskripsi, String status, String gambar) {
        this.id = id;
        this.idOwner = idOwner;
        this.nama = nama;
        this.lokasi = lokasi;
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.status = status;
        this.gambar = gambar;
        this.kategori = "STANDARD";
        this.rating = 5.0;
        this.jumlahKamar = 1;
        this.fasilitasAc = false;
        this.fasilitasWifi = false;
        this.fasilitasWaterHeater = false;
    }

    HomestayItem(int aInt, String string, String umum, String string0, double aDouble, double d, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdOwner() { return idOwner; }
    public int getOwnerId() { return idOwner; }
    public void setIdOwner(int idOwner) { this.idOwner = idOwner; }

    public String getNama() { return nama; }
    public String getNamaHomestay() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public void setNamaHomestay(String nama) { this.nama = nama; }

    public String getKategori() { return kategori; }
    public void setKategori(String kategori) { this.kategori = kategori; }

    public String getLokasi() { return lokasi; }
    public String getAlamat() { return lokasi; }
    public void setLokasi(String lokasi) { this.lokasi = lokasi; }
    public void setAlamat(String alamat) { this.lokasi = alamat; }

    public double getHarga() { return harga; }
    public double getHargaPerMalam() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }
    public void setHargaPerMalam(double harga) { this.harga = harga; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public int getJumlahKamar() { return jumlahKamar; }
    public void setJumlahKamar(int jumlahKamar) { this.jumlahKamar = jumlahKamar; }

    public boolean isFasilitasAc() { return fasilitasAc; }
    public void setFasilitasAc(boolean fasilitasAc) { this.fasilitasAc = fasilitasAc; }

    public boolean isFasilitasWifi() { return fasilitasWifi; }
    public void setFasilitasWifi(boolean fasilitasWifi) { this.fasilitasWifi = fasilitasWifi; }

    public boolean isFasilitasWaterHeater() { return fasilitasWaterHeater; }
    public void setFasilitasWaterHeater(boolean fasilitasWaterHeater) { this.fasilitasWaterHeater = fasilitasWaterHeater; }

    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getGambar() { return gambar; }
    public void setGambar(String gambar) { this.gambar = gambar; }
}