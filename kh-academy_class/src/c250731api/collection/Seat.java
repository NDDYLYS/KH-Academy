package c250731api.collection;;

public class Seat 
{
	private String alphabet;
	private int number;
	private boolean reservation;
	
	public Seat(String alphabet, int number) 
	{
		setAlphabet(alphabet);
		setNumber(number);
		reservation = false;
	}
	
	public String getName() 
	{
		return String.format("- " + alphabet + "" + number);
	}

	public String getAlphabet() {
		return alphabet;
	}
	public void setAlphabet(String alphabet) {
		this.alphabet = alphabet;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public boolean getReservation() {
		return reservation;
	}	
	public void setReservation(boolean reservation) {
		this.reservation = reservation;
	}
	public boolean Reservation() 
	{
		if (!reservation) 
		{
			System.out.println("[" + alphabet + "" + number + "] 좌석을 선택하셨습니다.");
			return true;
		}
		else 
		{
			System.out.println("이미 선택하신 좌석입니다. 선택 해제하시겠습니까(Y/N)?");
			return false;
		}
	}
	
	public void ReservationCancel() 
	{
		System.out.println("[" + alphabet + "" + number + "] 좌석이 선택 해제되었습니다.");
	}
	
	public Seat Search(String select) 
	{
		String alphabet = select.substring(0, 1);
		int number = Integer.parseInt(select.substring(1, select.length() - 1));
		return Search(alphabet, number);
	}
	
	public Seat Search(String alphabet, int number) 
	{
		if (this.alphabet.equals(alphabet) && this.number == number)
			return this;
		return null;
	}
}