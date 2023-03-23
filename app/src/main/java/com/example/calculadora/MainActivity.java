package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

  MaterialButton porcentagem, ce, c, apaga, sete, oito, nove, multiplica, quatro, cinco, seis, menos, um, dois, tres, mais, trocaSinal, zero, ponto, igual;
  TextView resultado, conta;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    super.getSupportActionBar().hide();
    resultado = findViewById(R.id.resultado);
    conta = findViewById(R.id.conta);
    porcentagem = findViewById(R.id.porcentagem);
    ce = findViewById(R.id.ce);
    c = findViewById(R.id.c);
    apaga = findViewById(R.id.apaga);
    sete = findViewById(R.id.sete);
    oito = findViewById(R.id.oito);
    nove = findViewById(R.id.nove);
    multiplica = findViewById(R.id.multiplica);
    quatro = findViewById(R.id.quatro);
    cinco = findViewById(R.id.cinco);
    seis = findViewById(R.id.seis);
    menos = findViewById(R.id.menos);
    um = findViewById(R.id.um);
    dois = findViewById(R.id.dois);
    tres = findViewById(R.id.tres);
    mais = findViewById(R.id.mais);
    trocaSinal = findViewById(R.id.trocaSinal);
    zero = findViewById(R.id.zero);
    ponto = findViewById(R.id.ponto);
    igual = findViewById(R.id.igual);
  }
  public void handleClick(View v){
    MaterialButton button = findViewById(v.getId());
    String buttonText = button.getText().toString();
    handleButtonText(buttonText);
  }
  public void handleButtonText(String buttonText){
    String resultadoText = resultado.getText().toString();
    Float resultadoValue = Float.parseFloat(resultado.getText().toString());
    String contaText = conta.getText().toString();
    switch (buttonText) {
      case "%" :
        resultado.setText(resultadoValue/10000+"");
        break;
      case "CE" :
        resultado.setText("0");
        conta.setText("");
        break;
      case "C" :
        resultado.setText("0");
        break;
      case "«" :
        if(resultadoText.length() <= 1){
          resultado.setText("0");
        } else {
          resultado.setText(resultadoText.substring(0, resultadoText.length() - 1));
        }
        break;
      case "1" :
      case "2" :
      case "3" :
      case "4" :
      case "5" :
      case "6" :
      case "7" :
      case "8" :
      case "9" :
      case "0" :
        if(resultadoValue == 0) {
          resultado.setText(buttonText);
        } else {
          resultado.setText(resultadoText + buttonText);
        }
        break;
      case "+/-" :
        if(resultadoValue != 0) {
          resultado.setText((resultadoValue * -1)+"");
        }
        break;
      case "X" :
        resultado.setText("0");
        conta.setText(resultadoText + " x");
        break;
      case "-" :
        resultado.setText("0");
        conta.setText(resultadoText + " -");
        break;
      case "+" :
        resultado.setText("0");
        conta.setText(resultadoText + " +");
        break;
      case "=" :
        if(!contaText.equals("")){
          String[] contaTextSplited = contaText.split(" ");
          handleEquals(Float.parseFloat(contaTextSplited[0]), contaTextSplited[1]);
        } else {
          Toast.makeText(this, "Insira uma conta antes de realizar esta ação", Toast.LENGTH_SHORT).show();
        }
        break;
      case "." :
        boolean temVirgula = false;
        for(int i = 0; i < resultadoText.length(); i++){
          if(resultadoText.charAt(i) == '.'){
            temVirgula = true;
          };
        }
        if(!temVirgula){
          resultado.setText(resultadoText + ".");
        }
        break;
      default:
        Toast.makeText(this, "Ocorreu algum erro", Toast.LENGTH_SHORT).show();
        break;
    }
  }
  public void handleEquals(Float contaValue, String contaSignal){
    Float resultadoValue = Float.parseFloat(resultado.getText().toString());
    switch (contaSignal) {
      case "x" :
        resultado.setText((contaValue - resultadoValue)+"");
        conta.setText("");
        break;
      case "-" :
        resultado.setText((contaValue - resultadoValue)+"");
        conta.setText("");
        break;
      case "+" :
        resultado.setText((contaValue * resultadoValue)+"");
        conta.setText("");
        break;
      default:
        Toast.makeText(this, "Ocorreu algum erro", Toast.LENGTH_SHORT).show();
        break;
    }
  }
}