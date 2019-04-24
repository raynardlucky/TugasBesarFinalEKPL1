package lib;

/**
 *
 * @author Raynard Lucky Johanes Sukmajaya
 *
 */

public class Warehouse	{
	private String kodeWh;
	private String namaWh;
	private String alamatWh;
  /**
  *Memberi nilai awal Warehouse
  *@param kode Warehouse,nama Warehouse,alamat Warehouse
  *
  */
	public Warehouse(String kodeWh, String namaWh, String alamatWh)	{
		this.kodeWh=kodeWh;
		this.namaWh=namaWh;
		this.alamatWh=alamatWh;
	}
   /**
  *Mengambil kode Warehouse
  *@return kode Warehouse
  *
  */
	public String getKodeWh() {
		return kodeWh;
	}
  /**
  *Mengambil nama Warehouse
  *@return nama Warehouse
  *
  */
	public String getNamaWh() {
		return namaWh;
	}
  /**
  *Mengambil alamat Warehouse
  *@return alamat Warehouse
  *
  */
	public String getAlamatWh() {
		return alamatWh;
	}
  /**
  *Inisialisasi kode Warehouse
  *@param kode Warehouse
  *
  */
	public void setKodeWh(String kodeWh) {
		this.kodeWh=kodeWh;
	}
  /**
  *Inisialisasi nama Warehouse
  *@param nama Warehouse
  *
  */
	public void setNamaWh(String namaWh){
		this.namaWh=namaWh;
	}
  /**
  *Inisialisasi alamat Warehouse
  *@param alamat Warehouse
  *
  */
	public void setAlamatWh(String alamatWh){
		this.alamatWh=alamatWh;
	}
}