package com.nespresso.exercise.pisa;

import java.util.Collections;

public class Floor
{
  private final int size;

  public Floor(int size)
  {
    this.size = size;
  }
  
  public String print()
  {
    return String.join("", Collections.nCopies(size, "X"));
  }
  
  public boolean isValidAsHigherFloor(final Floor higherFloor)
  {
    return higherFloor.size <= size;
  }
}
