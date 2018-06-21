package com.nespresso.exercise.pisa;

import com.nespresso.exercise.pisa.floors.Floor;
import com.nespresso.exercise.pisa.floors.FloorBuilder;

public class Tower
{
  private final Floors floors;
  
  public Tower()
  {
    floors = new Floors();
  }

  public void addFloor(int floorSize)
  {
    final Floor higherFloor = new FloorBuilder(floorSize).build();
    
    floors.addFloor(higherFloor);
  }
  
  public void addFloorWithWindows(int floorSize, int desiredNumberOfWindows)
  {
    final Floor higherFloor = new FloorBuilder(floorSize).withWindows(desiredNumberOfWindows).build();
    
    floors.addFloor(higherFloor);
  }

  public String printFloor(int floorIndex)
  {
    return floors.print(floorIndex);
  }

}
