
public class Day 
{
	private String name;
	private MachineQueue Wash, Dry;
	
	public Day(String nm)
	{
		name = nm;
		Wash = new MachineQueue("WashingMachine",nm);
		Dry = new MachineQueue("Dryer",nm);
	}
	
	public String getDay()
	{
		return name;
	}
	
	public MachineQueue getWasher()
	{
		return Wash;
	}
	
	public MachineQueue getDryer()
	{
		return Dry;
	}
}
