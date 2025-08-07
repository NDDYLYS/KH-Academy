package c250723oop.inner1;;

public class Robber 
{
	private String name;
	private Gun gun;
	
	public Robber(String name, Gun gun) 
	{
		this.setName(name);
		this.setGun(gun);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gun getGun() {
		return gun;
	}

	public void setGun(Gun gun) {
		this.gun = gun;
	}
}