package com.nespresso.exercise.pisa;

import java.util.ArrayList;
import java.util.List;

public class Tower
{
  
  private final List<Floor> floors;
  
  public Tower()
  {
    floors = new ArrayList<>();
  }

  public void addFloor(int floorSize)
  {
    final Floor higherFloor = new Floor(floorSize);
    
    if (floors.isEmpty() || floors.get(floors.size() - 1).isValidAsHigherFloor(higherFloor))
    {
      floors.add(higherFloor);
    }
    else
    {
      throw new IllegalArgumentException();
    }
  }

  public String printFloor(int floorIndex)
  {
    return floors.get(floorIndex).print();
  }

  public void addFloorWithWindows(int floorSize, int desiredNumberOfWindows)
  {
    throw new UnsupportedOperationException("Not yet implemented");
  }

}
