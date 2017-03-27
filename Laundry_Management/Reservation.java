
/**
 * Object representing a reservation for a machine.
 * @author Yuan-Cheng Tsai
 * */

public class Reservation 
{
    /** String CODE that holds the code to access the machines
     * for the time slot. */
	private String Code;

    /** String TIME that holds the time of the time slot. */
	private String Time;

    /** String STUDENT that holds the student */
	private Student S;

    /** Constructor for RESERVATION. */
	public Reservation(String code, String time, Student s)
	{
		Code = code;
		Time = time;
		S = s;
	}

    /** Returns the String CODE. */
	public String returnCode()
	{
		return Code;
	}

    /** Returns the String TIME. */
	public String returnTime()
	{
		return Time;
	}

    /** Returns the Student S. */
	public Student returnStudent()
	{
		return S;
	}
}
