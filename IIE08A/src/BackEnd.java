
public class BackEnd {
	private String[] Name;
	private String[] Team;
	private int[] Age;
	private float[] Height;
	private char[] CurrentPlayer;
	public int currentNum;
	public int maxNum;
	public int select;

	public BackEnd() {
		this.currentNum = 0;
		this.maxNum = 1;
		this.select = 0;
		this.Name = new String[this.maxNum];
		this.Team = new String[this.maxNum];
		this.Age = new int[this.maxNum];
		this.Height = new float[this.maxNum];
		this.CurrentPlayer = new char[this.maxNum];

	}

	//
	public void addRecord(String Name, String Team, int Age, float Height, char CurrentPlayer) {

		this.Name[this.currentNum] = Name;
		this.Team[this.currentNum] = Team;
		this.Age[this.currentNum] = Age;
		this.Height[this.currentNum] = Height;
		this.CurrentPlayer[this.currentNum] = CurrentPlayer;
		
		this.currentNum++;

	}
	//

	public void editRecord(String longerName, String longerTeam, int longerAge, float longerHeight, char longerCp) {

		this.Name[this.select] = longerName;
		this.Team[this.select] = longerTeam;
		this.Age[this.select] = longerAge;
		this.Height[this.select] = longerHeight;
		this.CurrentPlayer[this.select] = longerCp;
	}

	public void removeRecord(int arrayIndex, String[] longerName, String[] longerTeam, int[] longerAge,
			float[] longerHeight, char[] longerCp) {

		int j = 0;
		while (j < this.maxNum) {
			if (j < arrayIndex) {
				longerName[j] = this.Name[j];
				longerTeam[j] = this.Team[j];
				longerAge[j] = this.Age[j];
				longerHeight[j] = this.Height[j];
				longerCp[j] = this.CurrentPlayer[j];
			} else if (j >= arrayIndex) {
				longerName[j] = this.Name[j + 1];
				longerTeam[j] = this.Team[j + 1];
				longerAge[j] = this.Age[j + 1];
				longerHeight[j] = this.Height[j + 1];
				longerCp[j] = this.CurrentPlayer[j + 1];
			}
			j++;
		}

		this.Name = longerName;
		this.Team = longerTeam;
		this.Age = longerAge;
		this.Height = longerHeight;
		this.CurrentPlayer = longerCp;

		this.currentNum = this.maxNum;
	}

	public String addAthlete(int arrayIndex) {
		int i = arrayIndex;
		String message = this.Name[i] + "," + this.Team[i] + "," + this.Age[i] + "," + this.Height[i] + ","
				+ this.CurrentPlayer[i];
		return message;
	}

	// Expanding array to add multiple entries
	public void array() {
		if (this.currentNum >= this.maxNum) {
			this.maxNum++;

			String[] longerNames = new String[this.maxNum];
			String[] longerTeams = new String[this.maxNum];
			int[] longerAges = new int[this.maxNum];
			float[] longerHeights = new float[this.maxNum];
			char[] longerCps = new char[this.maxNum];

			int j = 0;

			while (j < this.currentNum) {
				longerNames[j] = this.Name[j];
				longerTeams[j] = this.Team[j];
				longerAges[j] = this.Age[j];
				longerHeights[j] = this.Height[j];
				longerCps[j] = this.CurrentPlayer[j];

				j++;

			}
			this.Name = longerNames;
			this.Team = longerTeams;
			this.Age = longerAges;
			this.Height = longerHeights;
			this.CurrentPlayer = longerCps;

		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
