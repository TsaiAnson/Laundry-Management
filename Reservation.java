
public class Reservation 
{
	private String Code;
	private String Time;
	private Student S;
	
	public Reservation(String code, String time, Student s)
	{
		Code = code;
		Time = time;
		S = s;
	}
	
	public String returnCode()
	{
		return Code;
	}
	
	public String returnTime()
	{
		return Time;
	}
	
	public Student returnStudent()
	{
		return S;
	}
}
