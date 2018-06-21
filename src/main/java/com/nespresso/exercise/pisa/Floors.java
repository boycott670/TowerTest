package com.nespresso.exercise.pisa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.nespresso.exercise.pisa.floors.Floor;
import com.nespresso.exercise.pisa.floors.WindowedFloor;

public class Floors
{
  private final List<Floor> floors;
  
  private final GroupingValueHandler groupingValueHandler;
  
  public Floors()
  {
    floors = new ArrayList<>();
    
    groupingValueHandler = new GroupingValueHandler(Collections.unmodifiableList(floors));
  }
  
  public void addFloor(final Floor floor)
  {
    if (floors.isEmpty() || floors.get(floors.size() - 1).isValidAsHigherFloor(floor))
    {
      floors.add(floor);
    }
    else
    {
      throw new IllegalArgumentException();
    }
  }
  
  public String print(final int floorIndex)
  {
    final Floor floorToPrint = floors.get(floorIndex);
    
    if (floorToPrint instanceof WindowedFloor)
    {
      ((WindowedFloor)floorToPrint).setGrouping(groupingValueHandler.getGroupingValue(floorIndex));
    }
        
    return floorToPrint.print();
  }
}
