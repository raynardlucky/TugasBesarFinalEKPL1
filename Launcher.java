
/**
 *
 * @author Jeremmy Augustinus and Raynard Lucky Johanes Sukmajaya
 *
 */

import lib.Produk;
import lib.Warehouse;
import lib.Inventory;
import lib.DataList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.FileNotFoundException;
import java.lang.ArrayIndexOutOfBoundsException;

public class Launcher {
	private static boolean run = true;
	private static DataList datalist = new DataList();
   /**
	*Menampilkan menu
	*
	*
	*/
	public static void menu() throws FileNotFoundException {
		Scanner menu = new Scanner(System.in);
		while(true) {
			try {
				System.out.println();
				System.out.println("|\\    /| | |\\  | |	|\\    /|   /\\   |```\\ |  / |``` ``|``");
				System.out.println("| \\  / | | | \\ | |	| \\  / |  /__\\  |,,,/ | /  |---   |  ");
				System.out.println("|  \\/  | | |  \\| |	|  \\/  | /    \\ |   \\ |  \\ |,,,   |  ");
				System.out.println();
				System.out.println("1. tampilkan seluruh data warehouse");
				System.out.println("2. tampilkan seluruh produk, warehouse, dan unit inventory");
				System.out.println("3. tampilkan produk dan unit inventory pada warehouse tertentu");
				System.out.println("4. tampilkan produk tertentu pada warehouse dan unit inventory");
				System.out.println("5. Menambah dan menghapus warehouse dan produk baru");
				System.out.println("6. menambah kuantitas dari produk di dalam inventory");
				System.out.println("7. mengurangi kuantitas dari produk di dalam inventory");
				System.out.println("0. simpan dan keluar dari aplikasi");
				byte choice = menu.nextByte();
				
				if (choice == 1) {
					datalist.printWarehouse();
				}

				else if (choice == 2) {
					datalist.printWarehouse();
					datalist.printProduk();
					datalist.printInventory();
				}

				else if (choice == 3) {
					Scanner input = new Scanner(System.in);
					System.out.print("Warehouse/code: ");
					String search = input.nextLine();
					datalist.printSearch(choice, search);
				}

				else if (choice == 4) {
					Scanner input = new Scanner(System.in);
					System.out.print("produk/code: ");
					String search = input.nextLine();
					datalist.printSearch(choice, search);
				}
				
				else if (choice == 5) {
					System.out.println("1. tambah produk     |  2. hapus produk");
					System.out.println("---------------------+--------------------");
					System.out.println("3. tambah warehouse  |  4. hapus warehouse");
					choice = menu.nextByte();
					if		(choice == 1) { datalist.tambahProduk(); }
					else if (choice == 2) { datalist.hapusProduk(); }
					else if (choice == 3) { datalist.tambahWarehouse(); }
					else if (choice == 4) { datalist.hapusWarehouse(); }
				}
				
				else if (choice == 6) { 
					datalist.editData(choice);
				}
				
				else if (choice == 7) { 
					datalist.editData(choice);
				}

				else if (choice == 0) { 
					datalist.closeWorkspace();
					run = false; break;
				}
			}

			catch(InputMismatchException exception) {
				System.out.println();
				System.err.println("status: input_error_byte_required");
				break;
			}
		}
	}
   /**
	*Main method
	*
	*
	*/
	public static void main(String[] args) {
		System.out.println("status: start");
		try {
			System.out.println("status: loading...");
			datalist.setWarehouse(); datalist.setInventory(); datalist.setProduct();
			System.out.println("status: load_data_success");
			while(run) { menu(); }
		}

		catch (FileNotFoundException exception) {
			System.err.println("status: unable_to_load_data");
			System.err.println("status: program_terminated");
		}

		catch (ArrayIndexOutOfBoundsException exception) {
			System.err.println("status: array_index_out_of_range");
			System.err.println("status: program_terminated");	
		}
	}
}
