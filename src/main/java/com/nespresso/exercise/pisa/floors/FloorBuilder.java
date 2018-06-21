package com.nespresso.exercise.pisa.floors;

import java.util.OptionalInt;

public class FloorBuilder
{
  private final int size;
  
  private OptionalInt numberOfWindows;
  
  public FloorBuilder(final int size)
  {
    this.size = size;
    
    numberOfWindows = OptionalInt.empty();
  }
  
  public FloorBuilder withWindows(int numberOfWindows)
  {
    if (numberOfWindows >= size)
    {
      numberOfWindows -= 2;
    }
    
    this.numberOfWindows = OptionalInt.of(numberOfWindows);
    
    return this;
  }
  
  public Floor build()
  {
    if (numberOfWindows.isPresent())
    {
      return new WindowedFloor(size, numberOfWindows.getAsInt());
    }
    
    return new NonWindowedFloor(size);
  }
}
