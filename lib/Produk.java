package lib;

/**
 * Tugas Besar
 * @author Raynard Lucky Johanes Sukmajaya
 *
 */

public class Produk {
  private String kodeProd;
  private String namaProd;
  private String tipeProd;
  private String pabrikProd;
 /**
  *Memberi nilai awal Produk
  *@param kodeProd,namaProd,tipeProd,pabrikProd
  *
  */
  public Produk(String kodeProd,String namaProd,String tipeProd,String pabrikProd){
    this.kodeProd=kodeProd;
    this.namaProd=namaProd;
    this.tipeProd=tipeProd;
    this.pabrikProd=pabrikProd;
  }
 /**
  *Mengambil kode Produk
  *@return kode Produk
  */
  public String getKodeProd(){
    return kodeProd;
  }
 /**
  *Mengambil nama Produk
  *@return String namaProd
  */
  public String getNamaProd(){
    return namaProd;
  }
 /**
  *Mengambil tipe Produk
  *@return tipeProd-tipeProd
  */
  public String getTipeProd(){
    return tipeProd;
  }
 /**
  *Mengambil pabrik Produk
  *@return (String pabrikProd)
  */
  public String getPabrikProd(){
    return pabrikProd;
  }
 /**
  *Inisialisasi kode Produk
  *@param kodeProd-Kode Produk
  *
  */
  public void setKodeProd(String kodeProd){
    this.kodeProd=kodeProd;
  }
 /**
  *Inisialisasi nama Produk
  *@param namaProd-nama Produk
  *
  */
  public void setNamaProd(String namaProd){
    this.namaProd=namaProd;
  }
 /**
  *Inisialisasi tipe Produk
  *@param tipeProd-tipe produk
  *
  */
  public void setTipeProd(String tipeProd){
    this.tipeProd=tipeProd;
  }
 /**
  *Inisialisasi pabrik Produk
  *@param pabrikProd-pabrik produk
  *
  */
  public void setPabrikProd(String pabrikProd){
    this.pabrikProd=pabrikProd;
  }
}