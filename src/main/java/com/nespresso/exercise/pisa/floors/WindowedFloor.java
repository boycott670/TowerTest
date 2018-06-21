package com.nespresso.exercise.pisa.floors;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class WindowedFloor extends Floor
{
  private OptionalInt grouping;
  
  public WindowedFloor(final int size, int numberOfWindows)
  {
    super(size);
    
    int indexOfFirstWindow = (size - numberOfWindows) / 2;
    
    int indexOfLastWindow = indexOfFirstWindow + numberOfWindows - 1;
    
    IntStream.rangeClosed(indexOfFirstWindow, indexOfLastWindow).forEachOrdered(blocks::setWindow);
    
    grouping = OptionalInt.empty();
  }
  
  public void setGrouping(final int grouping)
  {
    this.grouping = OptionalInt.of(grouping);
  }
  
  @Override
  public String print()
  {
    if (grouping.isPresent())
    {
      return blocks.group(grouping.getAsInt()).print();
    }
    
    return super.print();
  }
}
