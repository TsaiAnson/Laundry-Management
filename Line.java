
public class Line implements Queue
{
	private ListNode list;
	
	public Line()
	{
		list = null;
	}
	
	@Override
	public boolean isEmpty() 
	{
		if (list != null)
		{
			return false;
		}
		return true;
	}

	public int getSize()
	{
		ListNode current = list;
		int i = 0;
		
		while (current != null)
		{
			current = current.getNext();
			i++;
		}
		return i;
	}
	
	public ListNode getNode()
	{
		return list;
	}
	
	public void setNode(ListNode l1)
	{
		list = l1;
	}
	
	@Override
	public void add(Object obj) 
	{
		ListNode node = new ListNode (obj, null);
		ListNode current;
		
		if (list == null)
			list = node;
		else
		{
			current = list;
			while (current.getNext() != null)
				current = current.getNext();
			current.setNext(node);
		}
	}

	@Override
	public Object next() 
	{
		if (list == null)
		{
			System.out.println("There is nothing in queue");
			return null;
		}
		Object val = list.getValue();
		list = list.getNext();
		return val;
	}

	@Override
	public Object peek() 
	{
		if (list == null)
			return null;
		else
		{
		Object val = list.getValue();
		System.out.println(val);
		return val;
		}
	}

}
