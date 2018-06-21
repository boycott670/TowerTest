package com.nespresso.exercise.pisa.floors;

import java.util.stream.IntStream;

class WindowedFloor extends Floor
{
  public WindowedFloor(final int size, int numberOfWindows)
  {
    super(size);
    
    int indexOfFirstWindow = (size - numberOfWindows) / 2;
    
    int indexOfLastWindow = indexOfFirstWindow + numberOfWindows - 1;
    
    IntStream.rangeClosed(indexOfFirstWindow, indexOfLastWindow).forEachOrdered(blocks::setWindow);
  }
}
