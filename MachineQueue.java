import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MachineQueue 
{
	private String Name, Day;
	private Line L1;
	private DateFormat DateForm = new SimpleDateFormat("HH:mm");
	
	public MachineQueue(String nm, String day)
	{
		Name= nm;
		Day = day;
		L1 = new Line();
	}
	
	public String returnName()
	{
		return Name;
	}
	
	public String returnDay()
	{
		return Day;
	}
	
	public Line getLi()
	{
		return L1;
	}
	
	public String addR(String time, Student s) throws ParseException
	{
		String code = s.getName().substring(0,3)+Day.substring(0,3)+time;
		Reservation r1 = new Reservation(code, time, s);
		if (L1.isEmpty())
			L1.add(r1);
		else
		{
			ListNode copy = L1.getNode();
			ListNode copy1 = copy;
			Date d1 = DateForm.parse(time);
			Date comp = DateForm.parse(((Reservation) copy.getValue()).returnTime());
			if (d1.before(comp))
				L1.setNode(new ListNode(r1, copy));
			else
			{
				copy1 = copy1.getNext();
				comp = DateForm.parse(((Reservation) copy1.getValue()).returnTime());
				while (d1.after(comp) && copy1 != null)
				{
					if (copy1.getNext() == null)
						copy1.setNext(new ListNode(r1, null));
					copy1 = copy1.getNext();
					if (copy1 != null)
						comp = DateForm.parse(((Reservation) copy1.getValue()).returnTime());
				}
				copy1.setNext(new ListNode(r1, copy1.getNext()));
			}
			L1.setNode(copy);
		}
		return code;
		//NEED TO BUG TEST
	}
	
	public boolean findStudent(Student s)
	{
		if (L1 == null)
			return false;
		ListNode copy = L1.getNode();
		while (copy!=null)
		{
			if (((Reservation) copy.getValue()).returnStudent().getID().equals(s.getID()))
				return true;
			copy = copy.getNext();
		}
		return false;
	}
}
