
/**
 * Object DAY that represents a day a the laundry store.
 * @author Yuan-Cheng Tsai
 */

public class Day 
{
    /** String NAME that holds the name of the day. */
	private String name;

    /** MachineQueues WASH and DRY that are the queues for the
     * washers and dryers. */
	private MachineQueue Wash, Dry;

    /** Constructor of DAY. */
	public Day(String nm)
	{
		name = nm;
		Wash = new MachineQueue("WashingMachine",nm);
		Dry = new MachineQueue("Dryer",nm);
	}

    /** Returns the string NAME. */
	public String getDay()
	{
		return name;
	}

    /** Returns the MachineQueue WASH. */
	public MachineQueue getWasher()
	{
		return Wash;
	}

    /** Returns the MachineQueue DRY. */
	public MachineQueue getDryer()
	{
		return Dry;
	}
}
