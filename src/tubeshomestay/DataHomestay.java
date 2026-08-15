package tubeshomestay;

import java.util.ArrayList;
import java.util.List;

public class DataHomestay {
    private static final List<HomestayItem> listHomestay = new ArrayList<>();

    public static void tambah(HomestayItem item) {
        listHomestay.add(item);
    }

    public static List<HomestayItem> getAll() {
        return listHomestay;
    }

    public static List<HomestayItem> getByOwner(int idOwner) {
        List<HomestayItem> hasil = new ArrayList<>();
        for (HomestayItem h : listHomestay) {
            if (h.getIdOwner() == idOwner) {
                hasil.add(h);
            }
        }
        return hasil;
    }

    public static HomestayItem getById(int id) {
        for (HomestayItem h : listHomestay) {
            if (h.getId() == id) {
                return h;
            }
        }
        return null;
    }

    public static void hapus(int id) {
        listHomestay.removeIf(h -> h.getId() == id);
    }

    public static void perbarui(HomestayItem editData) {
        for (int i = 0; i < listHomestay.size(); i++) {
            if (listHomestay.get(i).getId() == editData.getId()) {
                listHomestay.set(i, editData);
                break;
            }
        }
    }

    public static List<HomestayItem> cari(String kategori, String keyword) {
        List<HomestayItem> hasil = new ArrayList<>();
        for (HomestayItem h : listHomestay) {
            boolean cocokKategori = kategori.equalsIgnoreCase("SEMUA") || h.getKategori().equalsIgnoreCase(kategori);
            boolean cocokKeyword = keyword.isEmpty() || 
                                   h.getNama().toLowerCase().contains(keyword.toLowerCase()) || 
                                   h.getLokasi().toLowerCase().contains(keyword.toLowerCase());
            if (cocokKategori && cocokKeyword) {
                hasil.add(h);
            }
        }
        return hasil;
    }
}