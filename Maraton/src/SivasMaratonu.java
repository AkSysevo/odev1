import java.util.Arrays;

public class SivasMaratonu {

    public static void main(String[] args) {
        String[] ogrenciIsimleri = {"kadir", "pınar", "gökhan", "hakan", "suzan","mehmet","ali","emel","fırat","james","jale",
                "ersin","deniz","gözde","anıl","burak"};
        int[] dereceler = {341, 445, 273, 278, 329,402,388,270,243,334,412,393,299,343,317,265};

        int[] enIyiUcDereceIndeksleri = enIyiUcDereceyiBul(dereceler);

        System.out.println("En iyi koşucu: " + ogrenciIsimleri[enIyiUcDereceIndeksleri[0]] + " - " + dereceler[enIyiUcDereceIndeksleri[0]] + " dakika");
        System.out.println("İkinci en iyi koşucu: " + ogrenciIsimleri[enIyiUcDereceIndeksleri[1]] + " - " + dereceler[enIyiUcDereceIndeksleri[1]] + " dakika");
        System.out.println("Üçüncü en iyi koşucu: " + ogrenciIsimleri[enIyiUcDereceIndeksleri[2]] + " - " + dereceler[enIyiUcDereceIndeksleri[2]] + " dakika");

        siniflandirVeYazdir(dereceler);
    }

    public static int[] enIyiUcDereceyiBul(int[] dereceler) {
        int[] indeksler = new int[3];
        Arrays.fill(indeksler, -1);

        for (int i = 0; i < dereceler.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (indeksler[j] == -1 || dereceler[i] < dereceler[indeksler[j]]) {
                    for (int k = 2; k > j; k--) {
                        indeksler[k] = indeksler[k - 1];
                    }
                    indeksler[j] = i;
                    break;
                }
            }
        }
        return indeksler;
    }

    public static void siniflandirVeYazdir(int[] dereceler) {
        int[] sinifSayilari = new int[3];

        for (int derece : dereceler) {
            if (derece >= 200 && derece <= 299) {
                sinifSayilari[0]++;
            } else if (derece >= 300 && derece <= 399) {
                sinifSayilari[1]++;
            } else if (derece >= 400) {
                sinifSayilari[2]++;
            }
        }

        System.out.println("A sınıfında " + sinifSayilari[0] + " öğrenci var");
        System.out.println("B sınıfında " + sinifSayilari[1] + " öğrenci var");
        System.out.println("C sınıfında " + sinifSayilari[2] + " öğrenci var");
    }
}