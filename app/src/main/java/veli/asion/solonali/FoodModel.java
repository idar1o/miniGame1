package veli.asion.solonali;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.TypedValue;

import java.util.Random;

public class FoodModel {
    Bitmap food[] = new Bitmap[3];
    int foodFrame = 0;
    int foodX, foodY, foodVelocity;
    Random random;
    Context context;
    int numObj;

    public FoodModel(Context context, int numObj){
        this.context = context;
        this.numObj = numObj;
        float dpValueW = 144f; // Значение в dp
        int pxValueW = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValueW, context.getResources().getDisplayMetrics());
        float dpValueH = 202f; // Значение в dp
        int pxValueH = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValueH, context.getResources().getDisplayMetrics());
        food[0] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.pngegg__2_), pxValueW, pxValueH, false);
        food[1] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.pngegg), pxValueW, pxValueH, false);
        food[2] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.pngtreeblueberry_simple_fruit_png_4528212), pxValueW, pxValueH, false);
        random  = new Random();


        switch (numObj){
            case 0:
                foodY = -400;
                break;
            case 1:
                foodY = 0;
                break;
            case 2:
                foodY = 400;
                break;
        }
        resetPosition();
    }


    public void resetPosition() {
        foodX = -200;
        switch (numObj){
            case 0:
                foodY = -400;
                break;
            case 1:
                foodY = 0;
                break;
            case 2:
                foodY = 400;
                break;
        }

        foodFrame = random.nextInt(3);
        foodVelocity = 17 + random.nextInt(10);

    }


    public Bitmap getFood(){
        return food[foodFrame];
    }
    public int getFoodWidth() {
        return food[0].getWidth();
    }
    public int getFoodHeight() {
        return food[0].getHeight();
    }
}
