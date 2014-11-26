/**
 * Grid represents a 2 dimensional grid.
 *
 * @param <E> the type of elements in this grid
 *
 * @author Marius Žilėnas
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Grid<E>
{
	private int     size    ;
	private int     width   ;
	private int     height  ;
	private List<E> elements;

	public int getCapacity()
	{
		return getWidth() * getHeight();
	}

	/**
	 * @return number of elements in grid. Null is also an element.
	 */
	public int getSize()
	{
		return getElements().size();
	}

	/**
	 * @param sideSize size of the grid side
	 */
	public Grid(int sideSize)
	{
		this(sideSize,sideSize);
	}

	/**
	 * @param width of the grid
	 * @param height of the grid
	 */
	public Grid(int width, int height)
	{
		this.width  = width ;
		this.height = height; 
		this.elements = new ArrayList<E>(
				Collections.nCopies(width*height, (E)null));
	}

	public int getHeight()
	{
		return height;
	}

	public int getWidth()
	{
		return width;
	}

	/**
	 * @return all elements of the grid
	 */
	public List<E> getElements()
	{
		return elements;
	}

	/**
	 * @return iterator for a grid
	 */
	public Iterator<E> iterator()
	{
		return getElements().iterator();
	}

	/**
	 * Returns the element at position (x,y).
	 *
	 * @return the element at position (x,y)
	 */
	public E get(int x, int y)
	{
		return getElements().get(
				idx(x,y));
	}

	/**
	 * Returns the element at index idx.
	 *
	 * @return the element at given index
	 */
	public E get(int idx)
	{
		return getElements().get(idx);
	}

	/**
	 * Puts an element to the position idx
	 *
	 * @param element to be added
	 *
	 * @param x position x to add element to
	 *
	 * @param y position y to add element to
	 */
	public void put(int x, int y, E element)
	{
		put(idx(x,y), element);
	}

	/**
	 * Puts an element to the position idx
	 *
	 * @param element to be added
	 *
	 * @param idx to add element at
	 */
	public void put(int idx, E element)
	{
		getElements().add(idx, element);
	}

	/**
	 * Returns the x coordinate from the index.
	 *
	 * @return x coordinate of the index
	 */
	public int x(int idx)
	{
		return idx % getHeight();
	}

	/**
	 * Returns the y coordinate from the index.
	 *
	 * @return y coordinate of the index
	 */
	public int y(int idx)
	{
		return (idx - idx % getHeight()) / getHeight();
	}

	/**
	 * Returns index of element at (x,y).
	 *
	 * @return index of the coordinates
	 */
	public int idx(int x, int y)
	{
		return y*getHeight() + x;
	}
}
