// Ravi Patel
// Assignment 9 Practice
// CS 245 Spring 2019
import java.util.Arrays;

public class BinaryHeap 
{

  public Integer[] arr;
  
  private int size;

  public BinaryHeap() 
  {
    arr = new Integer[10];
    size = 0;
  }

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

  private void swap(int value, int value2) 
  {
    int temp = arr[value];
    arr[value] = arr[value2];
    arr[value2] = temp;
  }
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
