package com.shadowbeastgod.eternalexistence.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.shadowbeastgod.eternalexistence.EternalExistence;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class EternalAltarScreen extends AbstractContainerScreen<EternalAltarMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(EternalExistence.MOD_ID, "textures/gui/eternal_altar_gui.png");

    public EternalAltarScreen(EternalAltarMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }


    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f,1.0f,1.0F,1.0f);
        RenderSystem.setShaderTexture(0,TEXTURE);


        int x = (width - imageWidth)/2;
        int y = ((height - imageHeight)/2);

        this.blit(pPoseStack, x, y,0,0, imageWidth, imageHeight);


        if(menu.isCrafting()){
            blit(pPoseStack,x+112,y+33,178,63,menu.getRecipeScaledProgress(), 14);
        }
        if(menu.isGrabbingMana()){
            blit(pPoseStack,x+27+menu.getManaScaledProgress(),y+30,180+menu.getManaScaledProgress(),83,menu.getManaScaledProgress(), 14);
        }

            blit(pPoseStack,x+13,y+8+menu.getManaContainerScaledProgress(),177,63+menu.getManaContainerScaledProgress(),menu.getManaContainerScaledProgress() , 14);



    }


    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pPoseStack,pMouseX ,pMouseY);

    }


}
