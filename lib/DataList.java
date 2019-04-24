package lib;

/**
 *
 * @author Raynard dan Jeremmy
 *
 */

import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class DataList {
	private ArrayList<Warehouse> arrwh = new ArrayList<Warehouse>();
	private ArrayList<Inventory> arrinventory = new ArrayList<Inventory>();
	private ArrayList<Produk> arrproduk = new ArrayList<Produk>();
        /**
	*Memberi nilai awal Inventory dari file .txt
	*
	*
	*/
	public void setInventory()throws FileNotFoundException {
		File baca = new File("data\\Inventory.txt");
		Scanner in = new Scanner(baca);
		while(in.hasNext()){
			String str = in.nextLine();
			String[] split = str.split(",");
			String kodeWH = split[0];
			String kodeProd = split[1];
			String hargaProd = split[2];
			String jumlahProd = split[3];
			
			kodeWH = kodeWH.replace("\"" ,"");
			kodeProd = kodeProd.replace("\"" ,"");
			hargaProd = hargaProd.replace("\"" ,"");
			jumlahProd = jumlahProd.replace("\"" ,"");
			
			double harga = Double.parseDouble(hargaProd);
			int jumlah = Integer.parseInt(jumlahProd);

				
			Inventory inv = new Inventory(kodeWH,kodeProd,harga,jumlah);
			arrinventory.add(inv);
		}
		
	}
   /**
	*Memberi nilai awal Produk dari file .txt
	*
	*
	*/
	public void setProduct()throws FileNotFoundException {
		File baca = new File("data\\Produk.txt");
		Scanner in = new Scanner(baca);
		while(in.hasNext()){
			String str = in.nextLine();
			String[] split = str.split(",");
			String kodeProd = split[0];
			String namaProd = split[1];
			String tipeProd = split[2];
			String pabrikProd = split[3];
			
			kodeProd = kodeProd.replace("\"" ,"");
			namaProd = namaProd.replace("\"" ,"");
			tipeProd = tipeProd.replace("\"" ,"");
			pabrikProd = pabrikProd.replace("\"" ,"");
			
			Produk pro = new Produk(kodeProd,namaProd,tipeProd,pabrikProd);
			arrproduk.add(pro);			
		}
	}
   /**
	*Memberi nilai awal Warehouse dari file .txt
	*
	*
	*/
	public void setWarehouse()throws FileNotFoundException {
		File baca = new File("data\\Warehouse.txt");
		Scanner in = new Scanner(baca);
		while(in.hasNext()){
			String str = in.nextLine();
			String[] split = str.split(",");
			String kodeWh = split[0];
			String namaWh = split[1];
			String alamatWh = split[2];
			
			kodeWh = kodeWh.replace("\"" ,"");
			namaWh = namaWh.replace("\"" ,"");
			alamatWh = alamatWh.replace("\"" ,"");

			Warehouse war = new Warehouse(kodeWh,namaWh,alamatWh);
			arrwh.add(war);			
		}
	}
   /**
	*Menampilkan kop atas tabel
	*@param 1 : Tabel Warehouse; 2 : Tabel Produk; 3 : Tabel Inventory;
	*
	*/
	public void headerTable(byte choice) {
		if(choice==1) {
			System.out.println("+------------------------------------------------------------+");
			System.out.println("|--------------------- TABLE WAREHOUSE ----------------------|");
			System.out.println("+------+------------------+----------------------------------+");
			System.out.println("| kode |       nama       |               alamat             |");
			System.out.println("+------+------------------+----------------------------------+");
		}
		if(choice==2) {
			System.out.println("+--------------------------------------------------------------------+");
			System.out.println("|--------------------------- TABLE PRODUK ---------------------------|");
			System.out.println("+------+------------------+------------------+-----------------------+");
			System.out.println("| KODE |       nama       |      jenis       |    nama perusahaan    |");
			System.out.println("+------+------------------+------------------+-----------------------+");
		}
		if(choice==3) {
			System.out.println("+------------------------------------------+");
			System.out.println("|------------- TABLE INVENTORI ------------|");
			System.out.println("+---------+---------+---------------+------+");
			System.out.println("| kode_wh | kode_pd |     harga     | stok |");
			System.out.println("+---------+---------+---------------+------+");
		}
	}
   /**
	*Menampilkan isi tabel Warehouse
	*
	*
	*/
	public void printWarehouse() {
		Scanner scan = new Scanner(System.in);
		headerTable((byte)1);
		for(int count=0; count<arrwh.size(); count++) {
			Warehouse w = arrwh.get(count);
			System.out.println("| "+w.getKodeWh()+" | "+w.getNamaWh()+" | "+w.getAlamatWh());
		}
		scan.nextLine();
	}
   /**
	*Menampilkan isi tabel Produk
	*
	*
	*/
	public void printProduk() {
		Scanner scan = new Scanner(System.in);
		headerTable((byte)2);
		for(int count=0; count<arrproduk.size(); count++) {
			Produk p = arrproduk.get(count);
			System.out.println("| "+p.getKodeProd()+" | "+p.getNamaProd()+" | "+p.getTipeProd()+" | "+p.getPabrikProd());
		}
		scan.nextLine();
	}
   /**
	*Menampilkan isi tabel Inventory
	*
	*
	*/
	public void printInventory() {
		Scanner scan = new Scanner(System.in);
		headerTable((byte)3);
		for(int count=0; count<arrinventory.size(); count++) {
			Inventory i = arrinventory.get(count);
			System.out.println("| "+i.getKodeWh()+" | "+i.getKodeProd()+" | "+i.getHargaProd()+" | "+i.getJumlahProd());
		}
		scan.nextLine();
	}
   /**
	*Mencari data
	*@param (pilihan menu dari Launcher,yang mau dicari)
	*
	*/
	public void printSearch(byte choice, String search) {
		Scanner scan = new Scanner(System.in);

		if(choice==3) {
			for(int count=0; count<arrwh.size(); count++) {
				Warehouse w = arrwh.get(count);
				if(w.getNamaWh().equalsIgnoreCase(search) || w.getKodeWh().equalsIgnoreCase(search)) {
					headerTable((byte)2);
					for(int index=0; index<arrinventory.size(); index++){
						Inventory i = arrinventory.get(index);
						Produk p = arrproduk.get(index);
						if(i.getKodeWh().equalsIgnoreCase(w.getKodeWh())){
							System.out.println("| "+p.getKodeProd()+" | "+p.getNamaProd()+" | "+p.getTipeProd()+" | "+p.getPabrikProd());
						}
					}

					scan.nextLine();

					headerTable((byte)3);
					for(int index=0; index<arrinventory.size(); index++){
						Inventory i = arrinventory.get(index);
						if(i.getKodeWh().equalsIgnoreCase(w.getKodeWh())){
							System.out.println("| "+i.getKodeWh()+" | "+i.getKodeProd()+" | "+i.getHargaProd()+" | "+i.getJumlahProd());
						}
					}

					scan.nextLine();
				}
			}
		}

		if(choice==4) {
			for(int count=0; count<arrproduk.size(); count++) {
				Produk p = arrproduk.get(count);
				if(p.getNamaProd().equalsIgnoreCase(search) || p.getKodeProd().equalsIgnoreCase(search)) {
					headerTable((byte)2);
					for(int index=0; index<arrinventory.size(); index++){
						Inventory i = arrinventory.get(index);
						Warehouse w = arrwh.get(index);
						if(i.getKodeProd().equalsIgnoreCase(p.getKodeProd())){
							System.out.println("| "+w.getKodeWh()+" | "+w.getNamaWh()+" | "+w.getAlamatWh());
						}
					}

					scan.nextLine();

					headerTable((byte)3);
					for(int index=0; index<arrinventory.size(); index++){
						Inventory i = arrinventory.get(index);
						if(i.getKodeProd().equalsIgnoreCase(p.getKodeProd())){
							System.out.println("| "+i.getKodeWh()+" | "+i.getKodeProd()+" | "+i.getHargaProd()+" | "+i.getJumlahProd());
						}
					}

					scan.nextLine();
				}
			}
		}
	}
   /**
	*Menambahkan produk baru
	*
	*
	*/
	public void tambahProduk() {
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		Scanner input3 = new Scanner(System.in);
		System.out.print("Kode barang: ");
		String kodeProd = input.next();
		System.out.print("Nama barang: ");
		String namaProd = input1.nextLine();
		System.out.print("Tipe barang(food/non-food): ");
		String tipeProd = input.next();
		System.out.print("Jumlah :");
		int jumlahProd = input.nextInt();
		System.out.print("Harga: ");
		double hargaProd = input.nextDouble();
		System.out.print("Produsen: ");
		String pabrikProd = input2.nextLine();
		System.out.print("Warehouse: ");
		String warehouse = input3.nextLine();
		
		byte message=1;
		for(int count=0; count<arrwh.size(); count++) {
			Warehouse w = arrwh.get(count);
			if(w.getNamaWh().equalsIgnoreCase(warehouse) || w.getKodeWh().equalsIgnoreCase(warehouse)) {
				Produk p = new Produk(kodeProd,namaProd,tipeProd,pabrikProd);
				arrproduk.add(p);
				Inventory i = new Inventory(warehouse,kodeProd,hargaProd,jumlahProd);
				arrinventory.add(i);
				message=(byte)0;
				break;
			}
		}
		
		if(message==(byte)1) {
			System.out.println("\nstatus: no_warehouse_selected");
			System.out.println("status: form_removed");
			System.out.println("status: create_new_warehouse\n");
		} else if(message==(byte)0) {
			System.out.println("\nstatus: add_product_success\n");
		}
	}
   /**
	*Menghapus produk
	*
	*
	*/
	public void hapusProduk() {
		Scanner input = new Scanner(System.in);
		System.out.print("Kode produk yang dihapus: ");
		String inputkode = input.next();
		for(int count=0;count<arrproduk.size();count++){
			Produk p=arrproduk.get(count);
			String kodeProd = p.getKodeProd();
			if(kodeProd.equalsIgnoreCase(inputkode)){
				arrproduk.remove(count);
				arrinventory.remove(count);
			}
		}	
	}
   /**
	*Menambahkan warehouse baru
	*
	*
	*/
	public void tambahWarehouse() {
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		System.out.print("Kode warehouse: ");
		String kodeWH = input.next();
		System.out.print("Nama warehouse: ");
		String namaWh = input1.nextLine();
		System.out.print("Alamat warehouse: ");
		String alamatWh = input2.nextLine();
		
		Warehouse w = new Warehouse(kodeWH,namaWh,alamatWh);
		arrwh.add(w);
	}
   /**
	*Menghapus warehouse
	*
	*
	*/
	public void hapusWarehouse() {
		Scanner input = new Scanner(System.in);
		System.out.print("Warehouse/code: ");
		String search = input.nextLine();

		for(int count=0; count<arrwh.size(); count++) {
			Warehouse w = arrwh.get(count);
			if(w.getNamaWh().equalsIgnoreCase(search) || w.getKodeWh().equalsIgnoreCase(search)) {
				headerTable((byte)2);
				for(int index=0; index<arrinventory.size(); index++){
					Inventory i = arrinventory.get(index);
					Produk p = arrproduk.get(index);
					if(i.getKodeWh().equalsIgnoreCase(w.getKodeWh())){
						arrproduk.remove(index);
					}
				}

				headerTable((byte)3);
				for(int index=0; index<arrinventory.size(); index++){
					Inventory i = arrinventory.get(index);
					if(i.getKodeWh().equalsIgnoreCase(w.getKodeWh())){
						arrinventory.remove(index);
					}
				}
				arrwh.remove(count);
			}
		}
	}
   /**
	*Menambah atau mengurangi stok produk
	*@param pilihan dari Launcher(choice = 6 untuk menambah produk dan choice = 7 untuk mengurangi jumlah produk)
	*
	*/
	public void editData(byte choice){
		if(choice == 6){
			Scanner input = new Scanner(System.in);
			System.out.print("Masukkan nama/kode produk: ");
			String search = input.nextLine();
			System.out.print("Masukkan jumlah: ");
			int jumlah = input.nextInt();
			for(int count=0; count<arrinventory.size(); count++) {
				Produk p = arrproduk.get(count);
				Inventory i = arrinventory.get(count);
				if(p.getNamaProd().equalsIgnoreCase(search) || p.getKodeProd().equalsIgnoreCase(search)) {
					i.addProd(jumlah);
				}
			}
		}
		if(choice == 7){
			Scanner input = new Scanner(System.in);
			System.out.print("Masukkan nama/kode produk: ");
			String search = input.nextLine();
			System.out.print("Masukkan jumlah: ");
			int jumlah = input.nextInt();
			for(int count=0; count<arrinventory.size(); count++) {
				Produk p = arrproduk.get(count);
				Inventory i = arrinventory.get(count);
				if(p.getNamaProd().equalsIgnoreCase(search) || p.getKodeProd().equalsIgnoreCase(search)) {
					i.removeProd(jumlah);
				}
			}
		}
	}
  /**
	*Menutup program dan menulis hasil pengolahan ke dalam file .txt
	*
	*
	*/
	public void closeWorkspace() throws FileNotFoundException {
		PrintWriter warehouse = new PrintWriter("data\\Warehouse.txt");
		PrintWriter produk 	  = new PrintWriter("data\\Produk.txt");
		PrintWriter inventory = new PrintWriter("data\\Inventory.txt");

		for(int count=0; count<arrwh.size(); count++) {
			Warehouse w = arrwh.get(count);
			String data = "\""+w.getKodeWh()+","+w.getNamaWh()+","+w.getAlamatWh()+"\"";
			warehouse.println(data);
		}

		for(int count=0; count<arrproduk.size(); count++) {
			Produk p = arrproduk.get(count);
			String data = "\""+p.getKodeProd()+","+p.getNamaProd()+","+p.getTipeProd()+","+p.getPabrikProd()+"\"";
			produk.println(data);
		}

		for(int count=0; count<arrinventory.size(); count++) {
			Inventory i = arrinventory.get(count);
			String data = "\""+i.getKodeWh()+","+i.getKodeProd()+","+i.getHargaProd()+","+i.getJumlahProd()+"\"";
			inventory.println(data);
		}
		warehouse.close();
		produk.close();
		inventory.close();
	}
}
