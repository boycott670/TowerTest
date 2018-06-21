package com.nespresso.exercise.pisa.floors;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.nespresso.exercise.pisa.blocks.Block;
import com.nespresso.exercise.pisa.blocks.Brick;
import com.nespresso.exercise.pisa.blocks.Window;

public class Blocks
{
  public static Blocks filledWithBricks(final int size)
  {
    return new Blocks(Stream.generate(Brick::new).limit(size).toArray(Block[]::new));
  }
  
  private final Block[] blocks;
  
  private Blocks(final Block[] blocks)
  {
    this.blocks = blocks;
  }
  
  public String print()
  {
    return Arrays.stream(blocks)
        .map(Block::print)
        .collect(Collectors.joining());
  }
  
  public int size()
  {
    return blocks.length;
  }
  
  void setWindow(final int index)
  {
    blocks[index] = new Window();
  }
  
  public Blocks group(final int grouping)
  {
    final Block[] groupedBlocks = Arrays.copyOf(blocks, size());
    
    return new Blocks(groupedBlocks);
  }
}
