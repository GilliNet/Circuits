package org.gillinet.circuits.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

public class TestBlock extends Block {

    public TestBlock(Properties p_55206_) {
        super(p_55206_);
    }

	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
		return InteractionResult.SUCCESS;
	}


}
