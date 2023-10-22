package org.gillinet.circuits.blocks;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.SignalGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DiodeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

public class XORGate extends DiodeBlock {
    protected XORGate(Properties p_52499_) {
        super(p_52499_);
    }

    @Override
    protected int getDelay(BlockState p_52584_) {
        return 0;
    }
    
    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_51887_) {
        p_51887_.add(FACING, POWERED);
    }

    @Override
    public boolean canConnectRedstone(BlockState state, BlockGetter world, BlockPos pos, @Nullable Direction side) {
        return side == state.getValue(FACING) || side == state.getValue(FACING).getClockWise()
                || side == state.getValue(FACING).getCounterClockWise();
    }

    @Override
	protected int getInputSignal(Level pLevel, BlockPos pPos, BlockState pState) {
		Direction facing = pState.getValue(FACING);

        SignalGetter sGet = pLevel;
        int input1 = sGet.getControlInputSignal(pPos.relative(facing.getClockWise()), facing, dynamicShape);
        int input2 = sGet.getControlInputSignal(pPos.relative(facing.getCounterClockWise()), facing, dynamicShape);

        if (input1 > 0 && input2 > 0) {
            return 0;
        } else if (input1 > 0 || input2 > 0) {
            return 15;
        }
		return 0;
	}
}
