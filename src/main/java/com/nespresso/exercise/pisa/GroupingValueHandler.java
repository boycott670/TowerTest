package com.nespresso.exercise.pisa;

import java.util.List;
import java.util.OptionalInt;

import com.nespresso.exercise.pisa.floors.Floor;
import com.nespresso.exercise.pisa.floors.WindowedFloor;

public class GroupingValueHandler
{
  private final List<Floor> floors;

  public GroupingValueHandler(List<Floor> floors)
  {
    this.floors = floors;
  }
  
  private int getNumberOfNonWindowedFloorsAbove(final int floorIndex)
  {
    int numberOfNonWindowedFloorsAbove = 0;
    
    for (int index = floorIndex + 1 ; index < floors.size() ; index ++)
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
  
  public OptionalInt getGroupingValue(final int floorIndex)
  {
    final int numberOfNonWindowedFloorsAbove = getNumberOfNonWindowedFloorsAbove(floorIndex);
    
    switch(numberOfNonWindowedFloorsAbove)
    {
      case 0:
        return OptionalInt.empty();
        
      case 1:
        return OptionalInt.of(3);
        
      case 2:
        return OptionalInt.of(2);
        
      default:
        return OptionalInt.of(1);
    }
  }
}
