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
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class NORLatch extends DiodeBlock {

    public static final BooleanProperty INPUT_A = BooleanProperty.create("input_a");
    public static final BooleanProperty INPUT_B = BooleanProperty.create("input_b");
    public static final BooleanProperty OUTPUT_A = BooleanProperty.create("output_a");
    public static final BooleanProperty OUTPUT_B = BooleanProperty.create("output_b");
    public static final Direction IN_A_DIRECTION = Direction.WEST;
    public static final Direction IN_B_DIRECTION = Direction.EAST;
    public static final Direction OUT_A_DIRECTION = Direction.NORTH;
    public static final Direction OUT_B_DIRECTION = Direction.SOUTH;
    public Direction poweredDirection = OUT_A_DIRECTION;

    protected NORLatch(Properties p_52499_) {
        super(p_52499_);
        this.registerDefaultState(
                this.getStateDefinition().any()
                        .setValue(INPUT_A, false)
                        .setValue(INPUT_B, false)
                        .setValue(OUTPUT_A, true)
                        .setValue(OUTPUT_B, false)
                        .setValue(FACING, Direction.NORTH)
                        .setValue(POWERED, Boolean.valueOf(false)));
        this.poweredDirection = this.getStateDefinition().any().getValue(FACING);
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_51887_) {
        p_51887_.add(FACING, POWERED, INPUT_A, INPUT_B, OUTPUT_A, OUTPUT_B);
    }

    @Override
    public boolean canConnectRedstone(BlockState state, BlockGetter world, BlockPos pos, @Nullable Direction side) {
        return side == state.getValue(FACING) || side == state.getValue(FACING).getClockWise()
                || side == state.getValue(FACING).getCounterClockWise()
                || side == state.getValue(FACING).getClockWise().getClockWise();
    }

    @Override
    public int getSignal(BlockState state, BlockGetter blockAccess, BlockPos pos, Direction side) {
        return side == this.poweredDirection ? 15 : 0;
    }

    @Override
    protected int getInputSignal(Level pLevel, BlockPos pPos, BlockState pState) {
        Direction facing = pState.getValue(FACING);
        SignalGetter sGet = pLevel;
        int input1 = sGet.getControlInputSignal(pPos.relative(facing.getClockWise()), facing, dynamicShape);
        int input2 = sGet.getControlInputSignal(pPos.relative(facing.getCounterClockWise()), facing, dynamicShape);

        if (input1 > 0 && this.poweredDirection != pState.getValue(FACING)) {
            this.poweredDirection = pState.getValue(FACING);
            return 15;
        }

        if (input2 > 0 && this.poweredDirection != pState.getValue(FACING).getClockWise().getClockWise()) {
            this.poweredDirection = pState.getValue(FACING).getClockWise().getClockWise();
            return 15;
        }

        return 0;
    }

    @Override
    public boolean isSignalSource(BlockState state) {
        return true;
    }

    @Override
    protected int getDelay(BlockState p_52584_) {
        return 0;
    }
}
