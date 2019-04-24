package lib;

/**
 *
 * @author Raynard Lucky Johanes Sukmajaya
 *
 */

public class Inventory  {
  private String kodeWh;
  private String kodeProd;
  private double hargaProd;
  private int jumlahProd;
   /**
  *Memberi nilai awal Inventory
  *@param kode Warehouse,kode Produk,harga Produk,jumlah Produk
  *
  */
  public Inventory(String kodeWh,String kodeProd,double hargaProd,int jumlahProd){
    this.kodeWh=kodeWh;
    this.kodeProd=kodeProd;
    this.hargaProd=hargaProd;
    this.jumlahProd=jumlahProd;
  }
  /**
  *Mengambil kode Warehouse
  *@return kode Warehouse
  *
  */
  public String getKodeWh(){
    return kodeWh;
  }
  /**
  *Mengambil kode Produk
  *@return kodeProduk
  *
  */
  public String getKodeProd(){
    return kodeProd;
  }
  /**
  *Mengambil harga Produk
  *@return harga Produk
  *
  */
  public double getHargaProd(){
    return hargaProd;
  }
  /**
  *Mengambil jumlah Produk
  *@return jumlah Produk
  *
  */
  public int getJumlahProd(){
    return jumlahProd;
  }
  /**
  *Inisialisasi kode Warehouse
  *@param kode Warehouse
  *
  */
  public void setKodeWH(String kodeWh){
    this.kodeWh=kodeWh;
  }
  /**
  *Inisialisasi kode Produk
  *@param kodeProduk
  *
  */
  public void setKodeProd(String kodeProd){
    this.kodeProd=kodeProd;
  }
  /**
  *Inisialisasi harga Produk
  *@param harga Produk
  *
  */
  public void setHargaProd(double hargaProd){
    this.hargaProd=hargaProd;
  }
  /**
  *Inisialisasi jumlah Produk
  *@param jumlah Produk
  *
  */
  public void setJumlahProd(int jumlahProd){
    this.jumlahProd=jumlahProd;
  }
  /**
  *Menambahkan jumlah Produk
  *@param jumlah Produk
  *
  */
  public void addProd(int plus){
    jumlahProd+=plus;
  }
   /**
  *Mengurangi jumlah Produk
  *@param jumlah Produk
  *
  */
  public void removeProd(int minus){
    jumlahProd-=minus;
  }
}