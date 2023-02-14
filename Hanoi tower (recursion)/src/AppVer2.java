
public class AppVer2 {

	public static void main(String[] args) {
		int NameAnyNumberOfDisks = 5;

		MoveAllDisksFromTowerAtoC(NameAnyNumberOfDisks, 'A', 'B', 'C');
	}

	public static void MoveAllDisksFromTowerAtoC(int NumberOfDisks, char from, char inter, char to) {

		if (NumberOfDisks == 1) {
			System.out.println("Disk 1 from " + from + " to " + to);
		} else {
			MoveAllDisksFromTowerAtoC(NumberOfDisks - 1, from, to, inter);
			System.out.println("Disk " + NumberOfDisks + " from " + from + " to " + to);
			MoveAllDisksFromTowerAtoC(NumberOfDisks - 1, inter, from, to);
		}
	}
}
