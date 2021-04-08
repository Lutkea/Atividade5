//https://www.devmedia.com.br/explorando-a-classe-arraylist-no-java/24298
//https://stackoverflow.com/questions/28190847/how-to-passing-list-in-bundle

package com.example.atividade5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Float.parseFloat;

public class MainActivity extends AppCompatActivity {
    List<Alunos> Arrayalunos = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);


        //Cria layout
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        layout.setPadding(10, 10, 10, 10);

        //Nome
        TextView nome = new TextView(this);
        nome.setText("Nome:");
        nome.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(nome);

        EditText tnome = new EditText(this);
        tnome.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(tnome);
        //Focus
        tnome.requestFocus();

        //Endereço
        TextView endereco = new TextView(this);
        endereco.setText("Endereço:");
        endereco.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(endereco);

        EditText tendereco = new EditText(this);
        tendereco.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(tendereco);

        //Data Nascimento
        TextView nascimento = new TextView(this);
        nascimento.setText("Data Nascimento:");
        nascimento.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(nascimento);

        EditText tnascimento = new EditText(this);
        tnascimento.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(tnascimento);

        //Cria layout 2
        LinearLayout layout2 = new LinearLayout(this);
        layout2.setOrientation(LinearLayout.HORIZONTAL);
        layout2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        layout2.setPadding(10, 10, 10, 10);
        //Nota 1
        TextView nota1 = new TextView(this);
        nota1.setText("Nota 1:");
        nota1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout2.addView(nota1);

        EditText tnota1 = new EditText(this);
        tnota1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout2.addView(tnota1);

        //Nota 2
        TextView nota2 = new TextView(this);
        nota2.setText("Nota 2:");
        nota2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout2.addView(nota2);

        EditText tnota2 = new EditText(this);
        tnota2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout2.addView(tnota2);

        //Nota 3
        TextView nota3 = new TextView(this);
        nota3.setText("Nota 3:");
        nota3.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout2.addView(nota3);

        EditText tnota3 = new EditText(this);
        tnota3.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout2.addView(tnota3);

        //Nota 4
        TextView nota4 = new TextView(this);
        nota4.setText("Nota 4:");
        nota4.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout2.addView(nota4);

        EditText tnota4 = new EditText(this);
        tnota4.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout2.addView(tnota4);

        layout.addView(layout2);

        //Botao Calcula
        Button calcula = new Button(this);
        calcula.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        calcula.setGravity(Gravity.RIGHT);
        calcula.setText("Calcula");
        layout.addView(calcula);

        //Média
        TextView media = new TextView(this);
        media.setText("Média:");
        media.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(media);

        //Botao novo aluno
        Button novo = new Button(this);
        novo.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        novo.setGravity(Gravity.RIGHT);
        novo.setText("Adicionar");
        layout.addView(novo);

        //Botao Limpar
        Button limpar = new Button(this);
        limpar.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        limpar.setGravity(Gravity.RIGHT);
        limpar.setText("Limpar");
        layout.addView(limpar);

        //Botao relatorio
        Button relatorio = new Button(this);
        relatorio.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        relatorio.setGravity(Gravity.RIGHT);
        relatorio.setText("Relatório");
        layout.addView(relatorio);

        //Alunos
        ListView listaluno = new ListView(this);
        listaluno.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(listaluno);
        // Construct the data source
        ArrayList<Alunos> arrayOfAlunos = new ArrayList<Alunos>();
        // Create the adapter to convert the array to views
        AlunosAdapter adapter = new AlunosAdapter(this, arrayOfAlunos);
        listaluno.setAdapter(adapter);
        setContentView(layout);

        // Regra para calcular a média
        calcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float n1 = parseFloat(tnota1.getText().toString());
                Float n2 = parseFloat(tnota2.getText().toString());
                Float n3 = parseFloat(tnota3.getText().toString());
                Float n4 = parseFloat(tnota4.getText().toString());
                Float m = (n1+n2+n3+n4)/4;

                media.setText(m.toString());
            }
        });

        // Regra para calcular a média
        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tnome.setText(null);
                tendereco.setText(null);
                tnascimento.setText(null);
                tnota1.setText(null);
                tnota2.setText(null);
                tnota3.setText(null);
                tnota4.setText(null);
            }
        });

        // Regra para nova nota de aluno
        novo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float n1 = parseFloat(tnota1.getText().toString());
                Float n2 = parseFloat(tnota2.getText().toString());
                Float n3 = parseFloat(tnota3.getText().toString());
                Float n4 = parseFloat(tnota4.getText().toString());
                Float m = (n1+n2+n3+n4)/4;

                // Add item to adapter
                Alunos newAluno = new Alunos(tnome.getText().toString(), (float) m);
                Arrayalunos.add(newAluno);

                adapter.clear();
                for (Alunos a: Arrayalunos) {
                    float media = a.getMedia();
                    adapter.add(a);
                }
            }
        });

        // Relatorio
        relatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TESTE", " Entrou aqui Primeiro: "+Arrayalunos.size());
                Intent intent = new Intent(MainActivity.this,RelatorioActivity.class);
                Bundle params = new Bundle();
                params.putParcelableArrayList("array", (ArrayList<? extends Parcelable>) Arrayalunos);
                intent.putExtras(params);
                startActivityForResult(intent, 2);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Verifica se o requestCode recebido é o mesmo que o enviado
        if(requestCode == 2) {
            //Testa o retorno da activity
        }
    }
}