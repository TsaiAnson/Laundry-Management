
/**
 * Interface for a generic Queue.
 * @author Yuan-Cheng Tsai
 */

public interface Queue 
{
	/** Returns TRUE if queue is empty, false otherwise. */
	boolean isEmpty();

	/** Adds Object OBJ to queue. (Push) */
	void add (Object obj);

	/** Returns and removes the next Object in the queue. */
	Object next();

	/** Returns but does not remove the next Object. */
	Object peek();
}
