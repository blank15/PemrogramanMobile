package yudistirosaputro.gmail.com.pertemuan4;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewNama;
    CheckBox checkBoxBold;
    CheckBox checkBoxItalic;
    RadioButton radioButtonBiru;
    RadioButton radioButtonMerah;
    RadioButton radioButtonKuning;
    RadioButton radioButtonHijau;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewNama = findViewById(R.id.textViewNama);
        checkBoxBold = findViewById(R.id.checkBoxBold);
        checkBoxItalic = findViewById(R.id.checkBoxItalic);
        radioButtonMerah = findViewById(R.id.radioButtonMerah);
        radioButtonBiru = findViewById(R.id.radioButtonBiru);
        radioButtonKuning = findViewById(R.id.radioButtonKuning);
        radioButtonHijau = findViewById(R.id.radioButtonHijau);

    }

    public void onCheckBoxClick(View view){
        if(checkBoxBold.isChecked()) {
            textViewNama.setTypeface(Typeface.DEFAULT_BOLD);
        }
        else  if(checkBoxItalic.isChecked()){
            textViewNama.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
        }
        if(checkBoxItalic.isChecked() && checkBoxBold.isChecked()){
            textViewNama.setTypeface(null,Typeface.BOLD_ITALIC);
        }else if(!checkBoxBold.isChecked() && !checkBoxItalic.isChecked())
            textViewNama.setTypeface(Typeface.DEFAULT);
    }
    public void onSetRadio(View view){

        if(radioButtonMerah.isChecked()){
            textViewNama.setBackgroundColor(getResources().getColor(R.color.colorRed));
        }if (radioButtonBiru.isChecked()){
            textViewNama.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }if(radioButtonHijau.isChecked()){
            textViewNama.setBackgroundColor(getResources().getColor(R.color.colorGreen));
        }if(radioButtonKuning.isChecked()){
            textViewNama.setBackgroundColor(getResources().getColor(R.color.colorYello));
        }
    }

}
