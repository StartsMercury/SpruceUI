/*
 * Copyright © 2020-2022 LambdAurora <email@lambdaurora.dev>
 *
 * This file is part of SpruceUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package dev.lambdaurora.spruceui.widget.container;

import dev.lambdaurora.spruceui.Position;
import dev.lambdaurora.spruceui.background.Background;
import dev.lambdaurora.spruceui.background.EmptyBackground;
import dev.lambdaurora.spruceui.border.Border;
import dev.lambdaurora.spruceui.border.EmptyBorder;
import dev.lambdaurora.spruceui.widget.SpruceWidget;
import dev.lambdaurora.spruceui.widget.WithBackground;
import dev.lambdaurora.spruceui.widget.WithBorder;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.unmapped.C_sedilmty;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Represents a container widget.
 *
 * @author LambdAurora
 * @version 3.3.0
 * @since 2.0.0
 */
public class SpruceContainerWidget extends AbstractSpruceParentWidget<SpruceWidget> implements WithBackground, WithBorder {
	private final List<SpruceWidget> children = new ArrayList<>();
	private Background background = EmptyBackground.EMPTY_BACKGROUND;
	private Border border = EmptyBorder.EMPTY_BORDER;

	public SpruceContainerWidget(Position position, int width, int height) {
		super(position, SpruceWidget.class);
		this.width = width;
		this.height = height;
	}

	@Override
	public Background getBackground() {
		return this.background;
	}

	@Override
	public void setBackground(Background background) {
		this.background = background;
	}

	@Override
	public Border getBorder() {
		return this.border;
	}

	@Override
	public void setBorder(Border border) {
		this.border = border;
	}

	public void addChild(SpruceWidget child) {
		this.setOwnerShip(child);
		this.children.add(child);
	}

	public void addChildren(ChildrenFactory childrenFactory) {
		childrenFactory.build(this.width, this.height, this::addChild);
	}

	@Override
	public List<SpruceWidget> children() {
		return this.children;
	}

	/* Rendering */

	@Override
	protected void renderWidget(C_sedilmty c_sedilmty, int mouseX, int mouseY, float delta) {
		this.forEach(child -> child.render(c_sedilmty, mouseX, mouseY, delta));
		this.getBorder().render(c_sedilmty, this, mouseX, mouseY, delta);
	}

	@Override
	protected void renderBackground(C_sedilmty c_sedilmty, int mouseX, int mouseY, float delta) {
		this.getBackground().render(c_sedilmty, this, 0, mouseX, mouseY, delta);
	}

	public interface ChildrenFactory {
		void build(int containerWidth, int containerHeight, Consumer<SpruceWidget> widgetAdder);
	}
}
