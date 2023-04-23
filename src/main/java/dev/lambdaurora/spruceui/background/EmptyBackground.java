/*
 * Copyright © 2020-2022 LambdAurora <email@lambdaurora.dev>
 *
 * This file is part of SpruceUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package dev.lambdaurora.spruceui.background;

import dev.lambdaurora.spruceui.widget.SpruceWidget;
import net.minecraft.unmapped.C_sedilmty;

/**
 * Represents an empty background.
 *
 * @author LambdAurora
 * @version 3.0.0
 * @since 2.0.0
 */
public final class EmptyBackground implements Background {
	public static final EmptyBackground EMPTY_BACKGROUND = new EmptyBackground();

	private EmptyBackground() {
	}

	@Override
	public void render(C_sedilmty c_sedilmty, SpruceWidget widget, int vOffset, int mouseX, int mouseY, float delta) {
	}

	@Override
	public String toString() {
		return "EmptyBackground{}";
	}
}
