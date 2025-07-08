package com.gtnecore.api.ModularUI;

import gregtech.api.GTValues;

import org.jetbrains.annotations.ApiStatus;

import com.cleanroommc.modularui.api.drawable.IDrawable;
import com.cleanroommc.modularui.drawable.UITexture;
import com.cleanroommc.modularui.screen.viewport.GuiContext;
import com.cleanroommc.modularui.theme.WidgetTheme;

@ApiStatus.Experimental
public class GTNEGUITextures {

    public static final UITexture[] BUTTON_ELEVATOR_EXTEND = slice("textures/gui/widget/space_elevator_extension.png",
            18, 36, 18, 18, false);

    private static UITexture fullImage(String path) {
        return fullImage(path, false);
    }

    private static UITexture fullImage(String path, boolean canApplyTheme) {
        return UITexture.fullImage(GTValues.MODID, path, canApplyTheme);
    }

    @SuppressWarnings("SameParameterValue")
    private static UITexture[] slice(String path, int imageWidth, int imageHeight, int sliceWidth, int sliceHeight,
                                     boolean canApplyTheme) {
        if (imageWidth % sliceWidth != 0 || imageHeight % sliceHeight != 0)
            throw new IllegalArgumentException("Slice height and slice width must divide the image evenly!");

        int countX = imageWidth / sliceWidth;
        int countY = imageHeight / sliceHeight;
        UITexture[] slices = new UITexture[countX * countY];

        for (int indexX = 0; indexX < countX; indexX++) {
            for (int indexY = 0; indexY < countY; indexY++) {
                slices[(indexX * countX) + indexY] = UITexture.builder()
                        .location(GTValues.MODID, path)
                        .canApplyTheme(canApplyTheme)
                        .imageSize(imageWidth, imageHeight)
                        .uv(indexX * sliceWidth, indexY * sliceHeight, sliceWidth, sliceHeight)
                        .build();
            }
        }
        return slices;
    }

    private static UITexture[] slice(String path, int imageWidth, int imageHeight, boolean canApplyTheme) {
        int sliceSize = Math.min(imageWidth, imageHeight);
        return slice(path, imageWidth, imageHeight, sliceSize, sliceSize, canApplyTheme);
    }

    private static IDrawable animated(String path, int imageWidth, int imageHeight, boolean canApplyTheme, int rate) {
        return dynamic(slice(path, imageWidth, imageHeight, canApplyTheme), rate);
    }

    private static UITexture progressBar(String path) {
        return progressBar(path, 20, 40, false);
    }

    private static UITexture progressBar(String path, boolean canApplyTheme) {
        return progressBar(path, 20, 40, canApplyTheme);
    }

    private static UITexture progressBar(String path, int width, int height) {
        return progressBar(path, width, height, false);
    }

    private static UITexture progressBar(String path, int width, int height, boolean canApplyTheme) {
        UITexture.Builder builder = new UITexture.Builder()
                .location(GTValues.MODID, path)
                .imageSize(width, height);
        if (canApplyTheme) builder.canApplyTheme();
        return builder.build();
    }

    public static IDrawable dynamic(UITexture[] textures, int rate) {
        return new IDrawable() {

            int tick = 0;
            int index = 0;

            @Override
            public void draw(GuiContext context, int x, int y, int width, int height, WidgetTheme widgetTheme) {
                int a = tick++ % rate; // this makes rate per frame ?
                if (a == 0) index++;
                textures[index % textures.length].draw(context, x, y, width, height, widgetTheme);
            }
        };
    }

    public static void init() {
        /**/
    }
}
