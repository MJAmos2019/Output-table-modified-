import java.util.Scanner;
public class FrontEndConsole {
	BackEnd backend1;
	private GTerm gt;
	
	
	public FrontEndConsole(BackEnd backend) {
		this.backend1 = backend;
		consoleMenu();
	}
	
	public void consoleEdit() {
		System.out.println("Enter number of athlete to edit");
		Scanner sca = new Scanner(System.in);
		String input = sca.nextLine();
		int i = Integer.parseInt(input);
		System.out.println("Selected to edit "+ i );
		i -=1;
		backend1.select = i;
		System.out.println("Re-enter details");
		String inputA = sca.nextLine();
	
		String[] update = inputA.split(",");
	
		String Name = update[0];
		String Team = update[1];
		int Age = Integer.parseInt(update[2]);
		float Height = Float.parseFloat(update[3]);
		char CurrentPlayer = update[4].charAt(0);
		
		while (Name.isBlank()) {
			System.out.println("Cannot leave blank");
			String inputname = sca.nextLine();
			Name = inputname;
		}
		while (Team.isBlank()) {
			System.out.println("Cannot leave blank");
			String inputteam = sca.nextLine();
			Team = inputteam;
		}
		while (Age < 1) {
			System.out.println("Cannot leave blank, Must enter an age greater than 0");
		}
		while (Height < 0) {
			Height = Float.parseFloat(this.gt.getInputString("Re-enter a valid number"));
		}

		backend1.editRecord(Name, Team, Age, Height, CurrentPlayer);
		
			consoleMenu();
	
	

		
	}
	public void consoleRemove() {
		Scanner sca = new Scanner(System.in);
		System.out.println("Enter number of athlete to remove");
		int ary = sca.nextInt();
		System.out.println("Removing athlete "+ ary );
		ary -=1;

		backend1.maxNum -=1;
		String[] Name = new String[backend1.maxNum];
		String[] Team = new String[backend1.maxNum];
		int[] Age = new int[backend1.maxNum];
		float[] Height = new float[backend1.maxNum];
		char[] CurrentPlayer = new char[backend1.maxNum];
		String Userinput = this.gt.getTextFromEntry(0);
		
		backend1.removeRecord(ary, Name, Team, Age, Height, CurrentPlayer);
	
		//	consoleMenu();
	}
	public void addRecordConsole() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your the Name,Team,Age,Height,Current Player(Y/N), Seperated by a comma. ");
		String input = sc.nextLine();
		backend1.array();
		String[] change = input.split(",");
		//
		String Name = change[0];
		String Team = change[1];
		int Age = Integer.parseInt(change[2]);
		float Height = Float.parseFloat(change[3]);
		char CurrentPlayer = change[4].charAt(0);
		
		while (Team.isBlank()) {
			System.out.println("Error,cannot leave blank. Re-enter Team");
			String inputteam = sc.nextLine();
			Team = inputteam;

		}
		while (Age < 1) {
			System.out.println("Error,Re-enter number greater than 0");
			int inputage = sc.nextInt();
			Age = inputage;
		}

		while (Height < 0.01) {
			System.out.println("Error,Re-enter number greater than 0");
			Float inputheight = sc.nextFloat();
			Height = inputheight;

		}
		backend1.addRecord(Name, Team, Age, Height, CurrentPlayer);
		consoleMenu();
	}
	
	public void consoleMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("[A] - adds an Athlete");
		System.out.println("[E] - Edits Athlete input");
		System.out.println("[R] - Removes Athlete input");
		System.out.println("[C] - closes program");
		String input = sc.next();
		if (input.equalsIgnoreCase("A")) {
			addRecordConsole();
		} else if (input.equalsIgnoreCase("C")) {
			closeConsole();
		} else if (input.equalsIgnoreCase("R")) {
			consoleRemove();

		} else if (input.equalsIgnoreCase("E")) {
			consoleEdit();
		} else {
			System.out.println("Invalid input,Try again");
			consoleMenu();
		}
	}
	public void consoleDisplay() {
	int i =0;
	System.out.println("Athletes: ");
	while (i < backend1.currentNum) {
		String message = backend1.addAthlete(i);
		System.out.println("_" + (i+1)+" _ "+ message);
		i++;
	}
	closeConsole();
	}
	
	public void closeConsole() {
		Scanner sc = new Scanner(System.in);
		sc.close();
	}
	
	
	
	
	
	
	
	
	
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	





