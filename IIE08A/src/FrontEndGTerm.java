
public class FrontEndGTerm {
	BackEnd backend1;
	private GTerm gt;
	private int recordTable;

	public FrontEndGTerm(BackEnd backend) {
		this.backend1 = backend;
		this.gt = new GTerm(1280, 800);
		this.gt.setBackgroundColor(213, 242, 238);
		this.gt.setFontSize(16);
		// table header
		String column = "Name\tTeam\tAge\tHeight(cm)\tCurrent player (Y/N)";
		this.recordTable = this.gt.addTable(650, 500, column);
		// Adds buttons
		this.gt.println(" ");
		this.gt.println(" ");
		this.gt.println("ENTER: Name,Team,age,Height,Current player (Y/N)");
		this.gt.addTextArea("", 300, 100);
		this.gt.addButton("Add", this, "addAthlete");
		this.gt.addButton("Edit", this, "GTermAdd");
		this.gt.addButton("Remove", this, "GTermRemoveRecord");
		this.gt.addButton("close", this, "closeWindow");

	}
//GTerm Edit 
	public void GTermEdit() {
		int selectR;
		selectR = this.gt.getIndexOfSelectedRowFromTable(0);
		String message = backend1.addAthlete(selectR);
		String[] AthDet = message.split(",");

		String Name = AthDet[0];
		String Team = AthDet[1];
		int Age = Integer.parseInt(AthDet[2]);
		float Height = Float.parseFloat(AthDet[3]);
		char CurrentPlayer = AthDet[4].charAt(0);
		String completed = Name + "," + Team + "," + Age + "," + Height + "," + CurrentPlayer;
		this.gt.setTextInEntry(0, completed);
		backend1.select = selectR;
	}

	public void GTermAdd() {
		String Userinput = this.gt.getTextFromEntry(0);

		String[] AthDet = Userinput.split(",");

		String Name = AthDet[0];
		String Team = AthDet[1];
		int Age = Integer.parseInt(AthDet[2]);
		float Height = Float.parseFloat(AthDet[3]);
		char CurrentPlayer = AthDet[4].charAt(0);
		// validations
		// if left blank to renter values
		// if less than 1 or 0 to renter values
		while (Name.isBlank())
			Name = this.gt.getInputString("Cannot leave blank");
		while (Team.isBlank())
			Team = this.gt.getInputString("Cannot leave blank");
		while (Age < 1)
			Age = Integer.parseInt(this.gt.getInputString("Must enter an age greater than 0"));
		while (Height < 0)
			Height = Float.parseFloat(this.gt.getInputString("Re-enter a valid number"));

		backend1.editRecord(Name, Team, Age, Height, CurrentPlayer);
		GtermRefresh();
	}

	public void GTermRemoveRecord() {
		if (backend1.currentNum >= backend1.maxNum) {
			int selected = this.gt.getIndexOfSelectedRowFromTable(0);
			backend1.maxNum -= 1;
			String[] Name = new String[backend1.maxNum];
			String[] Team = new String[backend1.maxNum];
			int[] Age = new int[backend1.maxNum];
			float[] Height = new float[backend1.maxNum];
			char[] CurrentPlayer = new char[backend1.maxNum];

			backend1.removeRecord(selected, Name, Team, Age, Height, CurrentPlayer);
			GtermRefresh();
		}
	}

	public void GtermRefresh() {
		this.gt.clearRowsOfTable(0);
		int i = 0;
		while (i < backend1.currentNum) {
			// currentNum loops adds data to table
			String message = backend1.addAthlete(i);
			this.gt.addRowToTable(0, message.replace(',', '\t'));
			i++;
		}

	}

	public void addAthlete() {
		String Userinput = this.gt.getTextFromEntry(0);
		backend1.array();
		String[] AthDet = Userinput.split(",");

		String Name = AthDet[0];
		String Team = AthDet[1];
		int Age = Integer.parseInt(AthDet[2]);
		float Height = Float.parseFloat(AthDet[3]);
		char CurrentPlayer = AthDet[4].charAt(0);
		// validations
		// if left blank to renter values
		// if less than 1 or 0 to renter values
		while (Name.isBlank())
			Name = this.gt.getInputString("Cannot leave blank");
		while (Team.isBlank())
			Team = this.gt.getInputString("Cannot leave blank");
		while (Age < 1)
			Age = Integer.parseInt(this.gt.getInputString("Must enter an age greater than 0"));
		while (Height < 0)
			Height = Float.parseFloat(this.gt.getInputString("Re-enter a valid number"));

		backend1.addRecord(Name, Team, Age, Height, CurrentPlayer);
		GtermRefresh();

	}

	public void closeWindow() {
		this.gt.close();

	}
}
