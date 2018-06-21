package com.nespresso.exercise.pisa;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

import com.nespresso.exercise.pisa.floors.Floor;
import com.nespresso.exercise.pisa.floors.WindowedFloor;

public class Floors
{
  private final List<Floor> floors;
  
  public Floors()
  {
    floors = new ArrayList<>();
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
  
  private int numberOfNonWindowedFloorsAbove()
  {
    int numberOfNonWindowedFloorsAbove = 0;
    
    for (int index = floors.size() - 1 ; index >= 0 ; index --)
    {
      if (!(floors.get(index) instanceof WindowedFloor))
      {
        numberOfNonWindowedFloorsAbove += 1;
      }
      else
      {
        break;
      }
    }
    
    return numberOfNonWindowedFloorsAbove;
  }
  
  private OptionalInt grouping()
  {
    final int numberOfNonWindowedFloorsAbove = numberOfNonWindowedFloorsAbove();
    
    if (numberOfNonWindowedFloorsAbove == 0)
    {
      return OptionalInt.empty();
    }
    else if (numberOfNonWindowedFloorsAbove == 1)
    {
      return OptionalInt.of(3);
    }
    else if (numberOfNonWindowedFloorsAbove == 2)
    {
      return OptionalInt.of(2);
    }
    else
    {
      return OptionalInt.of(1);
    }
  }
  
  public String print(final int floorIndex)
  {
    final Floor floorToPrint = floors.get(floorIndex);
    
    if (floorToPrint instanceof WindowedFloor)
    {
      final OptionalInt grouping = grouping();
      
      if (grouping.isPresent())
      {
        ((WindowedFloor)floorToPrint).setGrouping(grouping.getAsInt());
      }
    }
        
    return floorToPrint.print();
  }
}
