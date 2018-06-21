package com.nespresso.exercise.pisa;

import java.util.ArrayList;
import java.util.List;

import com.nespresso.exercise.pisa.floors.Floor;
import com.nespresso.exercise.pisa.floors.FloorBuilder;

public class Tower
{
  
  private final List<Floor> floors;
  
  public Tower()
  {
    floors = new ArrayList<>();
  }
  
  private void checkAndAddHigherFloor(final Floor higherFloor)
  {
    if (floors.isEmpty() || floors.get(floors.size() - 1).isValidAsHigherFloor(higherFloor))
    {
      floors.add(higherFloor);
    }
    else
    {
      throw new IllegalArgumentException();
    }
  }

  public void addFloor(int floorSize)
  {
    final Floor higherFloor = new FloorBuilder(floorSize).build();
    
    checkAndAddHigherFloor(higherFloor);
  }
  
  public void addFloorWithWindows(int floorSize, int desiredNumberOfWindows)
  {
    final Floor higherFloor = new FloorBuilder(floorSize).withWindows(desiredNumberOfWindows).build();
    
    checkAndAddHigherFloor(higherFloor);
  }

  public String printFloor(int floorIndex)
  {
    return floors.get(floorIndex).print();
  }

}
