package assignments.assignment3;

import java.util.ArrayList;
import java.util.List;

/** Class World. **/
public class World {

    public List<Carrier> listCarrier;

    /** Constructor World. **/
    public World() {
        this.listCarrier = new ArrayList<Carrier>();
    }
    
    /** Memasukkan objek Carrier ke listCarrier. **/
    public Carrier createObject(String tipe, String nama) {
        if (tipe.equalsIgnoreCase("PETUGAS_MEDIS")) {
            Carrier carrier = new PetugasMedis(nama);
            listCarrier.add(carrier);
            return carrier;
        } else if (tipe.equalsIgnoreCase("PEKERJA_JASA")) {
            Carrier carrier = new PekerjaJasa(nama);
            listCarrier.add(carrier);
            return carrier;
        } else if (tipe.equalsIgnoreCase("JURNALIS")) {
            Carrier carrier = new Jurnalis(nama);
            this.listCarrier.add(carrier);
            return carrier;
        } else if (tipe.equalsIgnoreCase("OJOL")) {
            Carrier carrier = new Ojol(nama);
            listCarrier.add(carrier);
            return carrier;
        } else if (tipe.equalsIgnoreCase("CLEANING_SERVICE")) {
            Carrier carrier = new CleaningService(nama);
            listCarrier.add(carrier);
            return carrier;
        } else if (tipe.equalsIgnoreCase("PEGANGAN_TANGGA")) {
            Carrier carrier = new PeganganTangga(nama);
            listCarrier.add(carrier);
            return carrier;
        } else if (tipe.equalsIgnoreCase("PINTU")) {
            Carrier carrier = new Pintu(nama);
            listCarrier.add(carrier);
            return carrier;
        } else if (tipe.equalsIgnoreCase("TOMBOL_LIFT")) {
            Carrier carrier = new TombolLift(nama);
            listCarrier.add(carrier);
            return carrier;
        } else {
            Carrier carrier = new AngkutanUmum(nama);
            listCarrier.add(carrier);
            return carrier;
        }
    }

    /** Mengambil objek Carrier yang sesuai dengan nama input. **/
    public Carrier getCarrier(String nama) {
        // TODO: Implementasikan apabila ingin mengambil object carrier dengan nama sesuai dengan parameter
        for (Carrier carrier : listCarrier) {
            if (carrier.getNama().equalsIgnoreCase(nama)) {
                return carrier;
            }
        }
        return null;
    }
}
