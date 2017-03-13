package com.example.pippp.se2einzelphase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtoutput;
    private Button btndiv;
    private EditText inputdividend, inputdivisor;
    private Calculator calculator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            findViews();
            setListeners();
            calculator= new Calculator();
        }
        catch (Exception e){
            e.printStackTrace();
            Log.e("Error:",e.getMessage());
        }

    }

    private void setListeners() throws Exception {
        this.btndiv.setOnClickListener(this);
    }

    private void findViews() throws Exception{
        this.inputdividend = (EditText) findViewById(R.id.inputtxtdividend);
        this.inputdivisor = (EditText) findViewById(R.id.inputtxtdivisor);
        this.txtoutput = (TextView) findViewById(R.id.txtoutput);
        this.btndiv = (Button) findViewById(R.id.btndiv);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.btndiv){
            try{
                String txtdividend= this.inputdividend.getText().toString();
                String txtdivisor = this.inputdivisor.getText().toString();
                checkInput(txtdividend,txtdivisor);
                txtoutput.setText(Double.toString(calculator.divide(Double.parseDouble(txtdividend), Double.parseDouble(txtdivisor))));


            }catch (Exception e){
                e.printStackTrace();
                txtoutput.setText(e.getMessage());
            }
        }
    }

    private void checkInput(String txtdividend, String txtdivisor) throws Exception {
        if(txtdividend.equals("")){
            throw new Exception("Dividend ist leer ");
        }
        if(txtdivisor.equals("")){
            throw new Exception("Divisor ist leer ");
        }
    }
}
