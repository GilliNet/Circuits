package org.gillinet.circuits.blocks;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.SignalGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DiodeBlock;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.Blocks;

public class InverterGate extends DiodeBlock {

    protected InverterGate(Properties p_52499_) {
        super(p_52499_);
        this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(POWERED, Boolean.valueOf(false));
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
        return side == state.getValue(FACING)
                || side == state.getValue(FACING).getCounterClockWise().getCounterClockWise();
    }

    @Override
    protected int getInputSignal(Level p_52544_, BlockPos p_52545_, BlockState p_52546_) {
        Direction direction = p_52546_.getValue(FACING);
        BlockPos blockpos = p_52545_.relative(direction);

        BlockState blockstate = p_52544_.getBlockState(blockpos);
        int power = blockstate.getValue(RedStoneWireBlock.POWER);
        
        if (power > 0) {
            return 0;
        } else {
            return 15;
        }
    }
}
