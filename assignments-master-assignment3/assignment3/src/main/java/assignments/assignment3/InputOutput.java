package assignments.assignment3;

import java.io.*;

/** Class InputOutput. **/
public class InputOutput{
  	
    private BufferedReader br;
    private PrintWriter pw;
    private String inputFile;
    private String outputFile; 
    private World world;

    /** Constructor InputOutput. **/
    public InputOutput(String inputType, String inputFile, String outputType, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        setBufferedReader(inputType);
        setPrintWriter(outputType);
    }

    /** Membuat BufferedReader sesuai dengan tipe input. **/
    public void setBufferedReader(String inputType) {
        if (inputType.equalsIgnoreCase("TERMINAL")) {
            InputStreamReader isr = new InputStreamReader(System.in);
            this.br = new BufferedReader(isr);
        } else {
            try {
                this.br = new BufferedReader(new FileReader(this.inputFile));
            } catch (IOException e) {
                System.out.println("Sorry! File cannot be found");
            }
        }
    }
    
    /** Membuat PrintWriter sesuai dengan tipe output. **/
    public void setPrintWriter(String outputType) {
        if (outputType.equalsIgnoreCase("TERMINAL")) {
            this.pw = new PrintWriter(System.out);
        } else {
            try {
                this.pw = new PrintWriter(new FileWriter(this.outputFile));
            } catch (IOException e) {
                System.out.println("Sorry! FIle cannot be found");
            }
        }
    }

    /** Menjalankan program. **/
    public void run() throws IOException {
        String line;
        World world = new World();
        while ((line = this.br.readLine()) != null) {
            String [] splitLine = line.split(" ");
            if (splitLine[0].equalsIgnoreCase("ADD")) {                   //Add
                world.createObject(splitLine[1], splitLine[2]);
                Carrier carrier1 = world.getCarrier(splitLine[2]);
            }
            
            else if (splitLine[0].equalsIgnoreCase("INTERAKSI") ) {     //Interaksi
                Carrier carrier1 = world.getCarrier(splitLine[1]);
                Carrier carrier2 = world.getCarrier(splitLine[2]);
                if (carrier1.getStatusCovid().equals("Positif")) {
                    carrier1.interaksi(carrier2);
                } else {
                    carrier2.interaksi(carrier1);
                }
            }
            
            else if (splitLine[0].equalsIgnoreCase("POSITIFKAN")) {     //Positifkan
                Carrier carrier1 = world.getCarrier(splitLine[1]);
                carrier1.ubahStatus("Positif");
            }
            
            else if (splitLine[0].equalsIgnoreCase("SEMBUHKAN")) {      //Sembuhkan
                Carrier carrier = world.getCarrier(splitLine[2]);
                Manusia manusia = (Manusia) carrier;
                Carrier medis = world.getCarrier(splitLine[1]);
                PetugasMedis petugas = (PetugasMedis) medis;
                petugas.obati(manusia);
            }
            
            else if (splitLine[0].equalsIgnoreCase("BERSIHKAN")) {      //Bersihkan
                Carrier carrier1 = world.getCarrier(splitLine[1]);
                CleaningService ob = (CleaningService) carrier1;
                Carrier carrier2 = world.getCarrier(splitLine[2]);
                Benda carrier = (Benda) carrier2;
                ob.bersihkan(carrier);
            }
            
            else if (splitLine[0].equalsIgnoreCase("RANTAI")) {          //Rantai 
                Carrier carrier1 = world.getCarrier(splitLine[1]);
                while(true) {
                    try {
                        if (carrier1.getStatusCovid().equals("Positif")) {
                            pw.write("Rantai penyebaran "+carrier1.toString()+": ");
                            pw.flush();
                        }
                        for (Carrier carrier : carrier1.getRantaiPenular()) {
                            pw.write(carrier.toString());
                            pw.flush();
                            if (carrier1.getRantaiPenular().indexOf(carrier) == (carrier1.getRantaiPenular().size() - 1)) {
                                pw.write("\n");
                                pw.flush();
                                break;
                            }
                            pw.write(" -> ");
                            pw.flush();
                        }
                    } catch (BelumTertularException e) {
                        pw.write(e.toString() + "\n");
                        pw.flush();
                    }
                    break;
                }
            }
            
            else if (splitLine[0].equalsIgnoreCase("TOTAL_KASUS_DARI_OBJEK")) { //Total Kasus
                Carrier carrier1 = world.getCarrier(splitLine[1]);
                pw.write(carrier1.toString() + " telah menyebarkan virus COVID ke " +
                          carrier1.getTotalKasusDisebabkan() + " objek\n");
                pw.flush();
            }
            
            else if (splitLine[0].equalsIgnoreCase("AKTIF_KASUS_DARI_OBJEK")) { //Aktif Kasus
                Carrier carrier1 = world.getCarrier(splitLine[1]);
                pw.write(carrier1.toString() + " telah menyebarkan virus COVID dan masih teridentifikasi "
                        + "positif sebanyak " + carrier1.getAktifKasusDisebabkan() + " objek\n");
                pw.flush();
            }
            
            else if (splitLine[0].equalsIgnoreCase("TOTAL_SEMBUH_MANUSIA")) {   //Total Manusia
                pw.write("Total sembuh dari kasus COVID yang menimpa manusia ada sebanyak: "
                        + Manusia.getJumlahSembuh() + " kasus\n");
                pw.flush();
            }
            
            else if (splitLine[0].equalsIgnoreCase("TOTAL_SEMBUH_PETUGAS_MEDIS")) { //Total Medis
                Carrier carrier = world.getCarrier(splitLine[1]);
                PetugasMedis petugas = (PetugasMedis) carrier;
                pw.write(carrier.toString() + " telah menyembuhkan " + petugas.getJumlahDisembuhkan() + " manusia\n");
                pw.flush();
            }
            
            else if (splitLine[0].equalsIgnoreCase("TOTAL_BERSIH_CLEANING_SERVICE")) { //Total Cleaning Service
                Carrier carrier = world.getCarrier(splitLine[1]);
                CleaningService ob = (CleaningService) carrier;
                pw.write(carrier.toString() + " membersihkan " + ob.getJumlahDibersihkan() + " benda\n");
                pw.flush();
            } 
            
            else if (splitLine[0].equalsIgnoreCase("EXIT")) {
                break;
            } 
            
            else {
                throw new IOException("You've entered the wrong command");
            }
        }
    }
}