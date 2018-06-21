package com.nespresso.exercise.pisa.floors;

public abstract class Floor
{
  final Blocks blocks;
  
  Floor(final int size)
  {
    this.blocks = Blocks.filledWithBricks(size);
  }
  
  public final String print()
  {
    return blocks.print();
  }
  
  public final boolean isValidAsHigherFloor(final Floor higherFloor)
  {
    return higherFloor.blocks.size() <= blocks.size();
  }
}
