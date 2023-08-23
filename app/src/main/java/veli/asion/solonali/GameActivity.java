package veli.asion.solonali;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class GameActivity extends AppCompatActivity {
    private int animal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        startGame();
    }
    public void startGame(){
        Intent intent = getIntent();
        if (intent != null) {
            animal = intent.getIntExtra("animal", 0);
            // Используйте полученное значение animal
        }
        GameView gameView = new GameView(this, animal);
        setContentView(gameView);
    }
}