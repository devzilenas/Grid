/**
 * Grid represents a 2 dimensional grid.
 *
 * @param <E> the type of elements in this grid
 *
 * @author Marius Žilėnas
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;

public class Grid<E>
{
	private int     width   ;
	private int     height  ;
	private List<E> elements;

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
		this(sideSize, sideSize);
	}

	/**
	 * Copy constructor.
	 */
	public Grid(Grid grid)
	{
		this.width  = grid.getWidth() ;
		this.height = grid.getHeight(); 
		this.setElements(
				new ArrayList<E>(
					grid.getElements()));
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
	 * Set elements.
	 */
	public void setElements(List<E> elements)
	{
		this.elements = elements;
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
	 * @return list iterator for a grid
	 */
	public ListIterator<E> listIterator()
	{
		return getElements().listIterator();
	}

	/**
	 * Returns the element at position (x,y). Doesn't fail on out of bounds x, y.
	 *
	 * @return the element at position (x,y)
	 */
	public E get(int x, int y)
	{
		return    x >= 0 
			   && y >= 0
			   && x < getWidth()
			   && y < getHeight()
			   ? getElements().get(
					   				idx(x,y))
			   : null ;
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
		getElements().set(idx, element);
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

	/**
	 * @return neighbors of the cell.
	 */
	public List<E> getNeighbors(int x, int y)
	{
		return new ArrayList<>(
								Arrays.asList(
												get(x  ,y-1), 
												get(x-1,y-1),
												get(x-1,y  ),
												get(x-1,y+1),
												get(x  ,y+1),
												get(x+1,y+1),
												get(x+1,y  ),
												get(x+1,y-1)));
	}

	/**
	 * @return neighbors of the cell.
	 */
	public List<E> getNeighbors(int idx)
	{
		return getNeighbors(
							x(idx), 
							y(idx));
	}

	/**
	 * Fills Grid with random values.
	 * @param values values for random.
	 */
	public void populate(E[] values)
	{
		Random random = new Random();
        for (ListIterator<E> iterator = getElements().listIterator(); iterator.hasNext(); )
        {
			iterator.next();
			iterator.set(values[random.nextInt(values.length)]);
        }
	}

	/**
	 * Makes a list of indexes at which a given value is.
	 * @return indexes of values.
	 */
	public List<Integer> getIndexes(E value)
	{
		List<Integer> indexes = new ArrayList<>();
		E element             = null;
		Integer index = 0;
		for (Iterator<E> iterator = iterator(); iterator.hasNext();)
		{
			element = iterator.next();
			if (value.equals(element))
			{
				indexes.add(index);
			}
			index++;
		}
		return indexes;
	}

	/**
	 * @return random index
	 */
	public int randomIndex()
	{
		Random random = new Random();
		return random.nextInt(getSize());
	}

	/**
	 * Get index of random element of given type.
	 */
	public int randomIndex(Object obj)
	{
		Random random = new Random();
		E el = null;
		int count = 0;
		int index = 0;
		for (int i = random.nextInt(getSize()); count < getSize(); count++) 
		{
			if (i >= getSize())
			{
				i = 0;
			}

			el = get(i);
			if (obj.equals(el))
			{
				index = i;
				break;
			} 
			i++;
		}
		return index;
	}
}
