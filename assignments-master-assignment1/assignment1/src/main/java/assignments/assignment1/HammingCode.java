package assignments.assignment1;

import java.lang.Math;
import java.util.Scanner;

public class HammingCode {
    static final int ENCODE_NUM = 1;
    static final int DECODE_NUM = 2;
    static final int EXIT_NUM = 3;
    
    /** Encoding information to hamming code.**/
    public static String encode(String data) {
        int m = data.length();
        int r = 1;
        while (r > 0) {
            if ((Math.pow(2, r)) >= (m + r + 1)) {
                break;
            } else {
                r++;
                continue;
            }
        }
        //menempati parity bit
        int indexFromOne = 1;
        String code1 = "";
        int indexData = 0;
        double pangkat = 1.0;
        while (indexFromOne <= (m + r)) {
            if (indexFromOne == 1) {
                code1 = code1 + "0";
                indexFromOne++;
            } else if (Math.pow(indexFromOne, 1.0 / pangkat) == 2.0) {
                code1 = code1 + "0";
                indexFromOne++;
                pangkat++;
            } else {
                code1 = code1 + data.charAt(indexData);
                indexFromOne++;
                indexData++;
            }
        }
        //cek parityyy
        int pos1 = 0;
        for (int p1 = 0; p1 < (m + r); p1 = p1 + 2) { //parity 1
            if (code1.charAt(p1) == '1') {
                pos1++;
            }
        }
        if (pos1 % 2 != 0) {
            String codeP1 = '1' + code1.substring(1, (m + r));
            code1 = codeP1;
        }
        int pangkatPow = 2; //parity 2 dan setelahnya
        if (r > 1) {
            int position = 2;
            int parity = 1;
            while (position <= ((int)(Math.pow(2, r - 1)))) { //2,4,8
                int counter = 0;
                int indexCode = 0;
                while (indexCode < code1.length()) { //(0,1,2,3,4,5,...)
                    if (((int)(Math.ceil((double)indexCode / 2.0)
                                % position) >= (position / 2))
                            && ((int)(Math.ceil((double)indexCode / 2.0)
                                % position) < position)) {
                        if (code1.charAt(indexCode) == '1') {
                            counter++;
                        }
                        indexCode++;
                    } else {
                        indexCode++;
                    }
                }
                if (counter % 2 != 0) { //jika ganjil diganti
                    String code1New = code1.substring(0, (position - 1)) + '1'
                            + code1.substring(position, (m + r));
                    code1 = code1New;
                }
                position = (int) (Math.pow(2, pangkatPow));
                pangkatPow++;
            }
        }
        return code1;
    }
    
    /** Decoding hamming code to information.**/
    public static String decode(String code) {
        int n = code.length();
        int index = 1;
        double pangkat = 0;
        int r = 0;
        while (index <= n) {
            if (index == 1) {
                r++;
                index++;
                pangkat++;
            } else if (Math.pow(index, 1.0 / pangkat) == 2.0) {
                pangkat++;
                index++;
                r++;
            } else {
                index++;
            }
        }
        //cek parity
        int pos1 = 0;
        for (int p1 = 0; p1 < code.length(); p1 = p1 + 2) { //parity 1
            if (code.charAt(p1) == '1') {
                pos1++;
            }
        }
        if (pos1 % 2 != 0) {
            String codeP1 = '1' + code.substring(1, code.length());
            code = codeP1;
        }
        int pangkatPow = 2; //parity 2 dan setelahnya
        if (r > 1) {
            int position = 2;
            int parity = 1;
            int error = 0;
            while (position <= ((int) (Math.pow(2, r - 1)))) { //2,4,
                int counter = 0;
                int indexCode = 0;
                while (indexCode < code.length()) { //index code1 (0,1,2,3,4,5,...)
                    if (((int)(Math.ceil((double)indexCode / 2.0)
                            % position) >= (position / 2))
                            && ((int)(Math.ceil((double)indexCode / 2.0)
                                    % position) < position)) {
                        if (code.charAt(indexCode) == '1') {
                            counter++;
                        }
                        indexCode++;
                    } else {
                        indexCode++;
                    }
                }
                if (counter % 2 != 0) { //parity yang jumlahnya ganjil
                    error = error + position;
                }
                position = (int)(Math.pow(2, pangkatPow));
                pangkatPow++;
            }
            if (error > 1) { //mengganti parity index ke-error
                if (code.charAt((error - 1)) == '0') {
                    String codeNew = code.substring(0, (error - 1)) + '1'
                            + code.substring(error, code.length());
                    code = codeNew;
                } else {
                    String codeNew = code.substring(0, (error - 1)) + '0'
                            + code.substring(error, code.length());
                    code = codeNew;
                }
            }
            int pangkatReversed = (r - 1); //mengeluarkan parity menjadi kode asli
            if (code.length() > 1) {
                for (int index2 = (code.length() - 1); index2 > 0; index2--) {
                    if ((int)(Math.pow(2, pangkatReversed)) == index2) { //jika index power of 2
                        String codeNew = code.substring(0, (index2 - 1))
                                + code.substring(index2, code.length());
                        pangkatReversed--;
                        code = codeNew;
                    }
                }
            }
        }
        return code;
    }

    /**
     * Main program for Hamming Code.
     * @param args unused
     */
    public static void main(String[] args) {
        System.out.println("Selamat datang di program Hamming Code!");
        System.out.println("=======================================");
        Scanner in = new Scanner(System.in);
        boolean hasChosenExit = false;
        while (!hasChosenExit) {
            System.out.println();
            System.out.println("Pilih operasi:");
            System.out.println("1. Encode");
            System.out.println("2. Decode");
            System.out.println("3. Exit");
            System.out.println("Masukkan nomor operasi yang diinginkan: ");
            int operation = in.nextInt();
            if (operation == ENCODE_NUM) {
                System.out.println("Masukkan data: ");
                String data = in.next();
                String code = encode(data);
                System.out.println("Code dari data tersebut adalah: " + code);
            } else if (operation == DECODE_NUM) {
                System.out.println("Masukkan code: ");
                String code = in.next();
                String data = decode(code);
                System.out.println("Data dari code tersebut adalah: " + data);
            } else if (operation == EXIT_NUM) {
                System.out.println("Sampai jumpa!");
                hasChosenExit = true;
            }
        }
        in.close();
    }
}
