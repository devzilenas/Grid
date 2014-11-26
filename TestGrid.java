/**
 * Tests a 2 dimensional Grid.
 */
public class TestGrid
{
	public static final int     SIZE = 10;
	public static final Integer el1  = new Integer(2);
	public static final Integer el2  = new Integer(3);
	public static final Integer el3  = new Integer(3);

	public static void main(String[] args)
	{
		Grid<Integer> grid = new Grid<>(SIZE);
		assert grid.getCapacity() == SIZE*SIZE ;

		assert grid.idx(0,0) == 0 ;
		assert grid.idx(1,0) == 1 ;
		assert grid.idx(0,1) == 10;
		assert grid.idx(6,1) == 16; 
		assert grid.idx(9,9) == 99;

		grid.put(1, el1);
		assert grid.get(1) == el1 : grid.get(1);

		grid.put(0, 1, el2);
		assert grid.get(0,1) != el1 && el1 != el2 && grid.get(0,1) == el2;

		grid.put(15, el3);
		assert grid.get(5,1) == el3;
	}
}

