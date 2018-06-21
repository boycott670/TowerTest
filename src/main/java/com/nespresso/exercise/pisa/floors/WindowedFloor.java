package com.nespresso.exercise.pisa.floors;

import com.nespresso.exercise.pisa.blocks.Window;

public class WindowedFloor extends Floor
{
  public WindowedFloor(final int size, int numberOfWindows)
  {
    super(size);
    
    int indexOfFirstWindow = (size - numberOfWindows) / 2;
    
    for (int index = indexOfFirstWindow ; index < indexOfFirstWindow + numberOfWindows ; index ++)
    {
      blocks[index] = new Window();
    }
  }
}
