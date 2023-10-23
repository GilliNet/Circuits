package org.gillinet.circuits.blocks;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DiodeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.SignalGetter;

public class ANDGate extends DiodeBlock {

    public ANDGate(Properties p_49795_) {
        super(p_49795_);
        this.registerDefaultState(
                this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(POWERED, Boolean.valueOf(false)));
    }

    // Sets the signal delay to 0
    @Override
    protected int getDelay(BlockState p_52584_) {
        return 0;
    }

    // Creates the block state for the the FACING and POWERED values
    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_51887_) {
        p_51887_.add(FACING, POWERED);
    }

    // Allows redstone to connect on the north, east, and west facings
    @Override
    public boolean canConnectRedstone(BlockState state, BlockGetter world, BlockPos pos, @Nullable Direction side) {
        return side == state.getValue(FACING) || side == state.getValue(FACING).getClockWise()
                || side == state.getValue(FACING).getCounterClockWise();
    }

    // Compares the east and west redstone inputs and returns a signal according to an AND gate
    @Override
	protected int getInputSignal(Level pLevel, BlockPos pPos, BlockState pState) {
		Direction facing = pState.getValue(FACING);

        SignalGetter sGet = pLevel;
        // Gets east input
        int input1 = sGet.getControlInputSignal(pPos.relative(facing.getClockWise()), facing, dynamicShape);

        // Gets west input
        int input2 = sGet.getControlInputSignal(pPos.relative(facing.getCounterClockWise()), facing, dynamicShape);

        // Comparison
        if (input1 > 0 && input2 > 0) {
            return 15;
        } else {
            return 0;
        }
	}
}
