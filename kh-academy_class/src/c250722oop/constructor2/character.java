package c250722oop.constructor2;;

public class character 
{
	String id;
	String job;
	int level;
	int gold;
	String getId() {
		return id;
	}
	void setId(String id) {
		this.id = id;
	}
	String getJob() {
		return job;
	}
	void setJob(String job) {
		switch(job) 
		{
		case "도둑" :
		case "성직자" :
		case "전사" :
			this.job = job;
			break;
		}
	}
	int getLevel() {
		return level;
	}
	void setLevel(int level) {
		if (level < 1)
			return;
		this.level = level;
	}
	int getGold() {
		return gold;
	}
	void setGold(int gold) {
		if (gold < 0)
			return;
		this.gold = gold;
	}
	
	public character(String id, String job, int level, int gold) 
	{
		setId(id);
		setJob(job);
		setLevel(level);
		setGold(gold);
	}
	
	public character(String id, String job)
	{
		this(id, job, 1, 0);
	}
	
	void levelup() 
	{
		int level = getLevel();
		setLevel(level++);
	}
	
	void info() 
	{
		String callName = "";
		int gold = getGold();
		if (gold < 1000)
			callName = "가난한 ";
		else if (100000 <= gold)
			callName = "부유한 ";
		System.out.println(getId() + " : " + callName + job + "(lv." + getLevel() + ") : " + getGold() + "gold");
	}
}