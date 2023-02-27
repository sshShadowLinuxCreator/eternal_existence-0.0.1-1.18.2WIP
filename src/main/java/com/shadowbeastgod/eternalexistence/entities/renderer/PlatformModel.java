package com.shadowbeastgod.eternalexistence.entities.renderer;// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shadowbeastgod.eternalexistence.EternalExistence;
import com.shadowbeastgod.eternalexistence.entities.customentities.PlatFormEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class PlatformModel<Type extends PlatFormEntity> extends EntityModel<Type> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(EternalExistence.MOD_ID, "platform"), "main");
	private final ModelPart bone;
	private final ModelPart bb_main;

	public PlatformModel(ModelPart root) {
		this.bone = root.getChild("bone");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(10, 25).addBox(6.0F, -8.0F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 6).addBox(-7.0F, -8.0F, 6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 0).addBox(-7.0F, -8.0F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 19).addBox(6.0F, -8.0F, 6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(13, 19).addBox(5.0F, -4.0F, -8.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(16, 38).addBox(6.0F, -6.0F, -7.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(23, 27).addBox(5.0F, -7.0F, -8.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(13, 25).addBox(5.0F, -7.0F, 5.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(11, 36).addBox(6.0F, -6.0F, 6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 19).addBox(5.0F, -4.0F, 5.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 25).addBox(-8.0F, -7.0F, 5.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(7, 30).addBox(-7.0F, -6.0F, 6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 6).addBox(-8.0F, -4.0F, 5.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(23, 22).addBox(-8.0F, -7.0F, -8.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(11, 12).addBox(-7.0F, -6.0F, -7.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-8.0F, -4.0F, -8.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(36, 37).addBox(2.0F, -5.0F, -8.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(36, 25).addBox(-6.0F, -5.0F, -8.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 36).addBox(-2.0F, -6.0F, -7.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 34).addBox(2.0F, -5.0F, 7.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(23, 19).addBox(-6.0F, -5.0F, 7.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 12).addBox(-2.0F, -6.0F, 6.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(25, 34).addBox(7.0F, -5.0F, -6.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(33, 19).addBox(7.0F, -5.0F, 2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(32, 28).addBox(6.0F, -6.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(18, 32).addBox(-8.0F, -5.0F, 2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(11, 30).addBox(-8.0F, -5.0F, -6.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 30).addBox(-7.0F, -6.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Type entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}