package com.nespresso.exercise.pisa.floors;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.nespresso.exercise.pisa.blocks.Block;
import com.nespresso.exercise.pisa.blocks.Brick;

public abstract class Floor
{
  final Block[] blocks;
  
  Floor(final int size)
  {
    this.blocks = Stream.generate(Brick::new)
        .limit(size)
        .toArray(Block[]::new);
  }
  
  public final String print()
  {
    return Arrays.stream(blocks)
        .map(Block::print)
        .collect(Collectors.joining());
  }
  
  public final boolean isValidAsHigherFloor(final Floor higherFloor)
  {
    return higherFloor.blocks.length <= blocks.length;
  }
}
