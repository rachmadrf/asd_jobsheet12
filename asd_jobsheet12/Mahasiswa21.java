package asd_jobsheet12;

public class Mahasiswa21 {
  public String nim;
  public String nama;
  public String kelas;
  public String ipk;

  public Mahasiswa21(String nim, String nama, String kelas, String ipk) {
    this.nim = nim;
    this.nama = nama;
    this.kelas = kelas;
    this.ipk = ipk;
  }

  public void tampi() {
    System.out.println("NIM: " + nim + " Nama: " + nama + " Kelas: " + kelas + " IPK: " + ipk);
  }
}