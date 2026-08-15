
package tubeshomestay;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pmaul
 */
public class DataBooking {
    private static final List<BookingItem> DAFTAR = new ArrayList<>();
    private static int autoId = 1;

    private DataBooking() {
    }

    public static synchronized void tambah(BookingItem item) {
        item.setId(autoId++);
        DAFTAR.add(item);
    }

    public static synchronized List<BookingItem> getSemua() {
        return new ArrayList<>(DAFTAR);
    }

    public static synchronized List<BookingItem> getByOwner(int idOwner) {
        List<BookingItem> hasil = new ArrayList<>();
        for (BookingItem b : DAFTAR) {
            if (b.getIdOwner() == idOwner) {
                hasil.add(b);
            }
        }
        return hasil;
    }

    public static synchronized double getTotalPendapatan(int idOwner) {
        double total = 0;
        for (BookingItem b : getByOwner(idOwner)) {
            total += b.getTotalHarga();
        }
        return total;
    }
    
}
