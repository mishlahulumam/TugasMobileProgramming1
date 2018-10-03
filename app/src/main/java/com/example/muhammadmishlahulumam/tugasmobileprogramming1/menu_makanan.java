package com.example.muhammadmishlahulumam.tugasmobileprogramming1;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class menu_makanan {
    private EditText jmlMakanan[] = new EditText[6];
    private int jumlah[] = new int[6];
    private Button btnPesan;
    private int result;
    private String jml;
    private int loop;
    int harga[] = {12000,11000,10000,15000,3000,5000};
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_menu);
        jmlMakanan[0] = (EditText)findViewById(R.id.jumlahNasiGoreng);
        jmlMakanan[1] = (EditText)findViewById(R.id.jumlahMieGoreng);
        jmlMakanan[2] = (EditText)findViewById(R.id.jumlahKwetiau);
        jmlMakanan[3] = (EditText)findViewById(R.id.jumlahAyamBakar);
        jmlMakanan[4] = (EditText)findViewById(R.id.jumlahEsTeh);
        jmlMakanan[5] = (EditText)findViewById(R.id.jumlahKopiHangat);
        btnPesan = (Button)findViewById(R.id.btnPesan);
        btnPesan.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(DaftarMenu.this, Pesanan.class);
        total = 0;
        loop = 0;
        for(int i=0; i<6; i++){
            jml = jmlMakanan[i].getText().toString();
            if(TextUtils.isEmpty(jml)){
                jumlah[i] = 0;
                loop = loop + 1;
            }
            else{
                jumlah[i] = Integer.parseInt(jml);
                jumlah[i] = jumlah[i] * harga[i];
                total = jumlah[i] + total;
            }
        }
        if(loop==6){
            jmlMakanan[0].setError("Silahkan isi jumlah makanan/minuman");
        }
        else{
            intent.putExtra("jumlah", jumlah);
            intent.putExtra("total", total);
            startActivity(intent);
        }
    }
}
