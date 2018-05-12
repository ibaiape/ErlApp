package com.example.ibai.erlApp;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.ibai.erlApp.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if(connectWifi())
            connectSSH();

        // TODO: checks
        // TODO: cambiar comportamiento a desconectar

        return true;
    }

    public void connect(){
    }

    public void clickUp(View v){
        // mientras mantenga pulsado enviar orden de mover vehículo adelante, cuando deje de pulsar
        // mandar orden de detenerse
    }

    public void clickDown(View v){
        // mientras mantenga pulsado enviar orden de mover vehículo atrás, cuando deje de pulsar
        // mandar orden de detenerse
    }

    public void clickLeft(View v){
        // mientras mantenga pulsado enviar orden de girar a la izquierda, cuando deje de pulsar
        // devolver la dirección a su posición inicial
    }

    public void clickRight(View v){
        // mientras mantenga pulsado enviar orden de girar a la derecha, cuando deje de pulsar
        // devolver la dirección a su posición inicial
    }


    private boolean connectWifi(){

        // TODO: mostrar listado de redes y solicitar contraseña

        String networkSSID = "erle-robotics-frambuesa";
        String networkPass = "holaerle";

        WifiConfiguration conf = new WifiConfiguration();
        conf.SSID = "\"" + networkSSID + "\"";

        //WPA
        conf.preSharedKey = "\""+ networkPass +"\"";

        WifiManager wifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiManager.addNetwork(conf);

        List<WifiConfiguration> list = wifiManager.getConfiguredNetworks();
        for( WifiConfiguration i : list ) {
            if(i.SSID != null && i.SSID.equals("\"" + networkSSID + "\"")) {
                wifiManager.disconnect();
                wifiManager.enableNetwork(i.networkId, true);
                wifiManager.reconnect();

                break;
            }
        }

        // TODO: si se ha conseguido la conexión
        return true;
    }


    private boolean connectSSH(){

        // TODO: establecer conexión con el servidor y mantener la sesión abierta para mandar las órdenes

        // TODO: si se ha conseguido la conexión
        return true;
    }
}
