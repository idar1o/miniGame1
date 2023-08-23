package veli.asion.solonali;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.CountDownTimer;
import android.util.TypedValue;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.navigation.NavController;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GameView extends View {


    Runnable runnable;
    Context context;
    Paint scorePaint = new Paint();
    ImageView backgroundImageView;
    float TEXT_SIZE = 90;
    int points = 0;
    int goodFood = 0;
    static int dWidth , dHeight;
    Bitmap mainFood, otherFood1,  otherFood2;
    android.os.Handler handler;
    ArrayList<FoodModel> foods = new ArrayList<FoodModel>();
    private CountDownTimer countDownTimer;
    private long remainingTimeMillis;
    private Paint timerPaint;

    public GameView(Context context, int goodFood) {

        super(context);
        this.context = context;
        this.goodFood = goodFood;

        float dpValueW = 144f; // Значение в dp
        int pxValueW = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValueW, context.getResources().getDisplayMetrics());
        float dpValueH = 202f; // Значение в dp
        int pxValueH = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValueH, context.getResources().getDisplayMetrics());
        switch (goodFood){
            case 0:
                mainFood = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.pngegg__2_), pxValueW, pxValueH, false);
                otherFood1 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.pngegg), pxValueW, pxValueH, false);
                otherFood2 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.pngtreeblueberry_simple_fruit_png_4528212), pxValueW, pxValueH, false);
                break;
            case 1 :
                otherFood1 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.pngegg__2_), pxValueW, pxValueH, false);
                mainFood = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.pngegg), pxValueW, pxValueH, false);
                otherFood2 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.pngtreeblueberry_simple_fruit_png_4528212), pxValueW, pxValueH, false);
                break;
            case 2:
                otherFood2 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.pngegg__2_), pxValueW, pxValueH, false);
                otherFood1 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.pngegg), pxValueW, pxValueH, false);
                mainFood = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.pngtreeblueberry_simple_fruit_png_4528212), pxValueW, pxValueH, false);
                break;

        }

        backgroundImageView = new ImageView(getContext());

        // Установите изображение фона
        backgroundImageView.setImageResource(R.drawable.nikita_kozlov_123);

        backgroundImageView.setAlpha(0.5F);
        // Установите масштабирование изображения
        backgroundImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        // Добавьте ImageView в качестве заднего фона
        setBackground(backgroundImageView.getDrawable());
        Display display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        dWidth = size.x;
        dHeight = size.y;
        handler = new android.os.Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };
        scorePaint.setColor(Color.rgb(255, 165, 0));
        scorePaint.setTextSize(TEXT_SIZE);
        scorePaint.setTextAlign(Paint.Align.LEFT);
//        scorePaint.setTypeface(ResourcesCompat.getFont(context, R.))
        for (int i = 0; i < 3; i++) {
            FoodModel foodModel = new FoodModel(context,i);
            foods.add(foodModel);
        }
        initTimer();


    }
    public void incrementScore() {
        points+=5;
        invalidate(); // Перерисовка View после изменения счета
    }
    public void minosScore() {
        points--;
        invalidate(); // Перерисовка View после изменения счета
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int x = getWidth() - 20; // Координата X для текста таймера
        int y = 40; // Координата Y для текста таймера

        // Преобразование оставшегося времени в формат "мм:сс"
        String timerText = String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(remainingTimeMillis),
                TimeUnit.MILLISECONDS.toSeconds(remainingTimeMillis) % 60);

        canvas.drawText(timerText, x, 100f, timerPaint);
        String scoreText = "Score: " + points;
        canvas.drawText(scoreText, 10f, 100f, scorePaint);
//        canvas.drawBitmap(background, 0, 0,null);
        for (int i = 0; i < foods.size(); i++) {
            canvas.drawBitmap(foods.get(i).getFood(), foods.get(i).foodX, foods.get(i).foodY, null );

            foods.get(i).foodX += (foods.get(i).foodVelocity-10);
            foods.get(i).foodY += foods.get(i).foodVelocity;


            if (foods.get(i).foodX + foods.get(i).getFoodWidth() >= dWidth +200 || foods.get(i).foodY + foods.get(i).getFoodHeight()>= dHeight+200){
                foods.get(i).resetPosition();
            }
        }


        handler.postDelayed(runnable, 30);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        float x = event.getX();
        float y = event.getY();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                // Обработка события нажатия
                for (int i = 0; i < foods.size(); i++) {
                    // Получаем координаты верхнего левого угла картинки
                    int foodX = foods.get(i).foodX;
                    int foodY = foods.get(i).foodY;

                    // Получаем ширину и высоту картинки
                    int foodWidth = foods.get(i).getFoodWidth();
                    int foodHeight = foods.get(i).getFoodHeight();

                    // Проверяем, попадает ли нажатие в пределы картинки
                    if (x >= foodX && x <= (foodX + foodWidth) && y >= foodY && y <= (foodY + foodHeight)) {
                        if (foods.get(i).getFood().sameAs(mainFood)){
                            incrementScore();
                        }else if ((foods.get(i).getFood().sameAs(otherFood1))||(foods.get(i).getFood().sameAs(otherFood2)))
                            minosScore();
                    }

                }

                break;
            case MotionEvent.ACTION_MOVE:
                // Обработка события перемещения
                break;
            case MotionEvent.ACTION_UP:
                // Обработка события отпускания
                break;
        }

        // Возвращаем true, чтобы указать, что событие было обработано
        return true;
    }
    private void initTimer() {
        timerPaint = new Paint();
        timerPaint.setColor(Color.rgb(255, 165, 0));
        timerPaint.setTextSize(TEXT_SIZE);
        timerPaint.setTextAlign(Paint.Align.RIGHT);

        // Установка таймера на 1 минуту (60000 миллисекунд)
        countDownTimer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                remainingTimeMillis = millisUntilFinished;
                invalidate(); // Перерисовка View для обновления отображения таймера
            }

            @Override
            public void onFinish() {
               AppPreferences appPreferences = new AppPreferences(getContext());
// Сохранение значения
                switch (goodFood){
                    case 0:
                        appPreferences.addSquirrel(points);

                        break;
                    case 1:
                        appPreferences.addFawn(points);

                        break;
                    case 2:
                        appPreferences.addEagle(points);

                        break;
                }


                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("animal", goodFood);
                intent.putExtra("points", points);

                context.startActivity(intent);
                ((Activity) context).finish();
            }
        };

        countDownTimer.start(); // Запуск таймера
    }
}
