package com.nespresso.exercise.pisa.floors;

import com.nespresso.exercise.pisa.blocks.Window;

class WindowedFloor extends Floor
{
  public WindowedFloor(final int size, int numberOfWindows)
  {
    super(size);
    
    int indexOfFirstWindow = (size - numberOfWindows) / 2;
    
    int indexOfLastWindow = indexOfFirstWindow + numberOfWindows - 1;
    
    for (int index = indexOfFirstWindow ; index <= indexOfLastWindow ; index ++)
    {
      blocks[index] = new Window();
    }
  }
}
