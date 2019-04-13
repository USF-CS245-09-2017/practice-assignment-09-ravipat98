// Ravi Patel
// Assignment 9 Practice
// CS 245 Spring 2019
import java.util.Arrays;

public class BinaryHeap 
{

  // create an array of size 10, and the elements to 0
  public Integer[] arr;
  
  private int size;

  public BinaryHeap() 
  {
    arr = new Integer[10];
    size = 0;
  }


  // if the new size equals the array length, then we want to grow the array
  // if not then we want to change the value with the new child or the parent when necessary
  public void add(int value) 
  {
    // Grows array
    if (size >= arr.length) 
    {
      arr = Arrays.copyOf(arr, arr.length * 2);
    }

    arr[size++] = value;

    int current = size - 1;
    int parent = (current - 1) / 2;

    while ((arr[current] < arr[parent])) 
    {
      swap(current, parent);
      current = parent;
      parent = (current - 1) / 2;
    }

  }

  //set the first element the last position and subtract it from size
  //if the size is grater than 0 then do the shift down method which checks if
  //if the children are smaller than their parent we swap them accordingly
  public int remove() 
  {
    assert size > 0;

    swap(0, size - 1);
    size--;

    if (size != 0) {
      shiftDown(0);
   }

    return arr[size];
  }

  private boolean isLeaf(int pos) 
  {
    return ((pos >= (size / 2)) && (pos <= size));
  }

  // this function will swap 2 elements in an array
  private void swap(int value, int value2) 
  {
    int temp = arr[value];
    arr[value] = arr[value2];
    arr[value2] = temp;
  }
  
  // when the node isn't a leaf node, we compare teh 2 children
  // if we want to find the smallest and if the parent is less then we just return a value
  // if the child is less then we change and swap the child with its parent
  // at last we want to create(set) the new position, and the child to go down one level
  private void shiftDown(int pos) 
  {
    int smallestChild;

    while (!isLeaf(pos)) 
    {
      smallestChild = pos * 2 + 1;

      if ((smallestChild + 1 < size) && (arr[smallestChild] > arr[smallestChild + 1])) 
      {
        smallestChild = smallestChild + 1;
      }

      if (arr[pos] <= arr[smallestChild]) 
      {
        return;
      }

      swap(pos, smallestChild);
      pos = smallestChild;
    }
  }

  
}
