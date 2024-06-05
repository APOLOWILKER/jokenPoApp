package com.apolowilker.appjokenpo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void selectStone(View view){
        verifyWinner("pedra");
    }

    public void selectPaper(View view){
        verifyWinner("papel");
    }

    public void selectScissors(View view){
        verifyWinner("tesoura");
    }

    private String generateRandomChoicePC() {

        String[] choices = {"pedra", "papel", "tesoura"};
        int randomNumber = new Random().nextInt(3);

        String choicePC = choices[randomNumber];

        ImageView imageApp = findViewById(R.id.ivPChoice);
        switch (choicePC){
            case "pedra" :
                imageApp.setImageResource(R.drawable.pedra);
                break;
            case "papel" :
                imageApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura" :
                imageApp.setImageResource(R.drawable.tesoura);
                break;
        }
        return choicePC;
    }

    private void verifyWinner( String choiceUser ){
    
        String choicePC = generateRandomChoicePC();
        TextView result = findViewById(R.id.text_result);

       if(
               (Objects.equals(choiceUser, "pedra") && Objects.equals(choicePC, "tesoura")) ||
               (Objects.equals(choiceUser, "papel") && Objects.equals(choicePC, "pedra")) ||
               (Objects.equals(choiceUser, "tesoura") && Objects.equals(choicePC, "papel"))
       ) {
           result.setText("Você venceu!! =)");
       } else if (Objects.equals(choiceUser, choicePC)) {
           result.setText("Empate! ;) ");
       } else {
           result.setText("Você perdeu :( ");
       }
    }


}