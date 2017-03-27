
/**
 * Object representing a Student at the college.
 * @author Yuan-Cheng Tsai
 * */

public class Student 
{
    /** String ID that holds the ID of the student. */
	private String ID;

    /** String NAME that holds the name. */
	private String Name;

    /** Constructor of STUDENT. */
	public Student (String nm, String id)
	{
		ID = id;
		Name = nm;
	}

    /** Returns String ID. */
	public String getID()
	{
		return ID;
	}

    /** Returns String NAME. */
	public String getName()
	{
		return Name;
	}
}
