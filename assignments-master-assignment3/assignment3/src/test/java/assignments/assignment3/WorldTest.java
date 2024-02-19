package assignments.assignment3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WorldTest {
    @Test
    public void testGetCarrier() {
        World world = new World();
        Carrier dokter = new PetugasMedis("Sakura");
        Carrier pekerja = new PekerjaJasa("Udin");
        Carrier jurnalis = new Jurnalis("Najwa");
        Carrier ojol = new Ojol("Bangjek");
        Carrier cs = new CleaningService("Asep");
        Carrier pegangan = new PeganganTangga("Baba");
        Carrier pintu = new Pintu("Bebe");
        Carrier tombol = new TombolLift("Bubu");
        Carrier angkutan = new AngkutanUmum("Bobo");
        
        world.listCarrier.add(dokter);
        world.listCarrier.add(pekerja);
        world.listCarrier.add(jurnalis);
        world.listCarrier.add(ojol);
        world.listCarrier.add(cs);
        world.listCarrier.add(pegangan);
        world.listCarrier.add(pintu);
        world.listCarrier.add(tombol);
        world.listCarrier.add(angkutan);

        assertEquals(ojol, world.getCarrier("Bangjek"));
    }
}
